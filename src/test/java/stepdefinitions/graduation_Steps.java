package stepdefinitions;

import Page.graduation_Page;
import Page.registration_Page;
import Page.structureAndDuties_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static utilities.Driver.getDriver;

public class graduation_Steps {
    graduation_Page graduationPage = new graduation_Page();
    structureAndDuties_Page structureAndDutiesPage = new structureAndDuties_Page();
    registration_Page register = new registration_Page();
    String expectedStartDate;
    String expectedEndDate;

    @And("administrator approval switcher turned off")
    public void administratorApprovalSwitcherTurnedOff() {
//        graduationPage.adminApprovalSwitcher.click();
//        ReusableMethods.wait(1);
        WebElement toggleDiv = getDriver().findElement(By.cssSelector("div.toggle-switch"));

        String classValue = toggleDiv.getAttribute("class");

        if (classValue.contains("toggled")) {
            graduationPage.adminApprovalSwitcher.click();
            ReusableMethods.wait(1);
        } else {
            System.out.println("Toggle düzgün vəziyyətdədir, heç nə edilmir.");
        }
    }

    @And("current account status switcher turned off")
    public void currentAccountStatusSwitcherTurnedOff() {
//        graduationPage.currentAccountStatusSwticher.click();
//        ReusableMethods.wait(1);
        WebElement statusLabel = getDriver().findElement(By.xpath("//label[contains(text(), 'Hesabın cari statusu')]"));
        WebElement toggleDiv = statusLabel.findElement(By.xpath("preceding-sibling::div[contains(@class, 'toggle-switch')]"));
        String toggleClass = toggleDiv.getAttribute("class");

        if (toggleClass.contains("toggled")) {
            System.out.println("Toggle aktivdir, klik edilir.");
            graduationPage.currentAccountStatusSwticher.click();
        } else {
            System.out.println("Toggle passivdir, heç nə edilmir.");
        }
    }

    @And("user saved changes")
    public void userSavedChanges() {
        graduationPage.saveChangesBtn.click();
        ReusableMethods.wait(1);
    }

    @And("graduation start date is added")
    public void graduationStartDateIsAdded() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        ReusableMethods.wait(1);
//        graduationPage.graduationTodayDate.clear();
        ReusableMethods.clearTextBox(graduationPage.graduationTodayDate);
        ReusableMethods.wait(1);
        graduationPage.graduationTodayDate.sendKeys(formattedDate);
        ReusableMethods.wait(1);
        WebElement vacationStartInput = getDriver().findElement(By.cssSelector("input[formcontrolname='vacationStartDate']"));
        expectedStartDate = vacationStartInput.getAttribute("value");
        System.out.println("Tarix: " + expectedStartDate);
    }

    @And("graduation end date is added")
    public void graduationEndDateIsAdded() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = futureDate.format(formatter);
//        graduationPage.graduationLastDate.clear();
        ReusableMethods.clearTextBox(graduationPage.graduationLastDate);
        graduationPage.graduationLastDate.sendKeys(formattedDate);

        WebElement vacationEndInput = getDriver().findElement(By.cssSelector("input[formcontrolname='vacationEndDate']"));
        expectedEndDate = vacationEndInput.getAttribute("value");
        System.out.println("Tarix: " + expectedEndDate);
    }

    @And("after searching the results are displayed in the users table")
    public void afterSearchingTheResultsAreDisplayedInTheUsersTable() {
        structureAndDutiesPage.searchButton.click();
        ReusableMethods.wait(1);
    }

    @Then("the user's administrative approval is displayed as closed in the table")
    public void theUserSAdministrativeApprovalIsDisplayedAsClosedInTheTable() {
        ReusableMethods.flash(graduationPage.adminApprovalResultTable, getDriver());
        String actual = graduationPage.adminApprovalResultTable.getText();
        String expected = "close";
        Assert.assertEquals(actual, expected);
    }

    @Then("the user's current account status is displayed as closed in the table")
    public void theUserSCurrentAccountStatusIsDisplayedAsClosedInTheTable() {
        ReusableMethods.flash(graduationPage.currentAccountResultTable, getDriver());
        String actual = graduationPage.currentAccountResultTable.getText();
        String expected = "close";
        Assert.assertEquals(actual, expected);
    }

    @Then("the user's administrative approval is displayed as opened in the table")
    public void theUserSAdministrativeApprovalIsDisplayedAsOpenedInTheTable() {
        ReusableMethods.flash(graduationPage.adminApprovalResultTable, getDriver());
        String actual = graduationPage.adminApprovalResultTable.getText();
        String expected = "check";
        Assert.assertEquals(actual, expected);
    }

    @Then("the user's current account status is displayed as opened in the table")
    public void theUserSCurrentAccountStatusIsDisplayedAsOpenedInTheTable() {
        ReusableMethods.flash(graduationPage.currentAccountResultTable, getDriver());
        String actual = graduationPage.currentAccountResultTable.getText();
        String expected = "check";
        Assert.assertEquals(actual, expected);
    }

    @And("page is down")
    public void pageIsDown() {
        ReusableMethods.pageDown();
        ReusableMethods.wait(3);
    }


    @And("page is up")
    public void pageIsUp() {
        ReusableMethods.pageUp();
        ReusableMethods.wait(3);
    }

    @And("graduation note is added")
    public void graduationNoteIsAdded() {
        graduationPage.graduationNote.clear();
        ReusableMethods.wait(1);
        graduationPage.graduationNote.sendKeys("Bir ay məzuniyyətdə olacaq.");
        ReusableMethods.wait(1);
    }

    @Then("admin control is displayed as not approved in the users table")
    public void adminControlIsDisplayedAsNotApprovedInTheUsersTable() {
        ReusableMethods.flash(register.adminControlIcon, getDriver());
        String iconText = register.adminControlIcon.getText().trim();
        if (iconText.equals("close")) {
            System.out.println("✅ Status icon 'close' göstərir – hər şey qaydasındadır.");
        } else if (iconText.equals("check")) {
            throw new AssertionError("❌ Xəta: Status icon 'check' göstərir – məzuniyyət verildiyi halda!");
        } else {
            throw new AssertionError("⚠️ Gözlənilməz status icon tapıldı: " + iconText);
        }
    }

    @Then("status is displayed as not approved in the users table")
    public void statusIsDisplayedAsNotApprovedInTheUsersTable() {
        ReusableMethods.flash(register.statusIcon, getDriver());
        String iconText = register.statusIcon.getText().trim();
        if (iconText.equals("close")) {
            System.out.println("✅ Status icon 'close' göstərir – hər şey qaydasındadır.");
        } else if (iconText.equals("check")) {
            throw new AssertionError("❌ Xəta: Status icon 'check' göstərir – məzuniyyət verildiyi halda!");
        } else {
            throw new AssertionError("⚠️ Gözlənilməz status icon tapıldı: " + iconText);
        }
        ReusableMethods.wait(1);
    }

    @Then("A user on vacation is unable to enter the system")
    public void aUserOnVacationIsUnableToEnterTheSystem() {
        String expectedUrl = "auth";
        ReusableMethods.wait(1);
        String actualUrl = ReusableMethods.getPathSegment(expectedUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    @And("administrator approval switcher turned on")
    public void administratorApprovalSwitcherTurnedOn() {
        WebElement toggleDiv = getDriver().findElement(By.cssSelector("div.toggle-switch"));
        String classValue = toggleDiv.getAttribute("class");
        if (classValue.equals("toggle-switch")) {
            graduationPage.adminApprovalSwitcher.click();
            ReusableMethods.wait(1);
        } else {
            System.out.println("Toggle düzgün vəziyyətdədir, heç nə edilmir.");
        }

    }

    @And("current account status switcher turned on")
    public void currentAccountStatusSwitcherTurnedOn() {
        WebElement statusLabel = getDriver().findElement(By.xpath("//label[contains(text(), 'Hesabın cari statusu')]"));
        WebElement toggleDiv = statusLabel.findElement(By.xpath("preceding-sibling::div[contains(@class, 'toggle-switch')]"));
        String toggleClass = toggleDiv.getAttribute("class");
        if (toggleClass.equals("toggle-switch")) {
            System.out.println("Toggle aktivdir, klik edilir.");
            graduationPage.currentAccountStatusSwticher.click();
        } else {
            System.out.println("Toggle passivdir, heç nə edilmir.");
        }
    }

    @And("previous start date for graduation is displayed")
    public void previousStartDateForGraduationIsDisplayed() {
        WebElement vacationStartInput = getDriver().findElement(By.cssSelector("input[formcontrolname='vacationStartDate']"));
        ReusableMethods.flash(vacationStartInput,getDriver());
        String actualStartDate = vacationStartInput.getAttribute("value");
        System.out.println("Tarix: " + actualStartDate);
        Assert.assertEquals(expectedStartDate,actualStartDate);
    }

    @And("previous end date for graduation is displayed")
    public void previousEndDateForGraduationIsDisplayed() {
        WebElement vacationEndInput = getDriver().findElement(By.cssSelector("input[formcontrolname='vacationEndDate']"));
        ReusableMethods.flash(vacationEndInput,getDriver());
        String actualEndDate = vacationEndInput.getAttribute("value");
        System.out.println("Tarix: " + actualEndDate);
        Assert.assertEquals(expectedEndDate,actualEndDate);
    }

    @And("previous note for graduation is displayed")
    public void previousNoteForGraduationIsDisplayed() {
        WebElement vacationNoteInput = getDriver().findElement(By.cssSelector("textarea[formcontrolname='deactivationNote']"));
        ReusableMethods.flash(vacationNoteInput,getDriver());
        String actualNote = vacationNoteInput.getAttribute("value");
        System.out.println("Note: " + actualNote);
        String expectedNote = "Bir ay məzuniyyətdə olacaq.";
        Assert.assertEquals(expectedNote,actualNote);
    }

    @Then("the user is successfully entered to the system")
    public void theUserIsSuccessfullyEnteredToTheSystem() {
        String expectedUrl = "home";
        ReusableMethods.wait(5);
        String actualUrl = ReusableMethods.getPathSegment(expectedUrl);
        assertEquals(expectedUrl, actualUrl);
    }
}