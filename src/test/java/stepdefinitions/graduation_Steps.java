package stepdefinitions;

import Page.graduation_Page;
import Page.structureAndDuties_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utilities.Driver.getDriver;

public class graduation_Steps {
    graduation_Page graduationPage = new graduation_Page();
    structureAndDuties_Page structureAndDutiesPage = new structureAndDuties_Page();
    @And("administrator approval switcher turned on or off")
    public void administratorApprovalSwitcherTurnedOnOrOff() {
        graduationPage.adminApprovalSwitcher.click();
        ReusableMethods.wait(1);
    }
    @And("current account status switcher turned on or off")
    public void currentAccountStatusSwitcherTurnedOnOrOff() {
        graduationPage.currentAccountStatusSwticher.click();
        ReusableMethods.wait(1);
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
        graduationPage.graduationTodayDate.sendKeys(formattedDate);
    }
    @And("graduation end date is added")
    public void graduationEndDateIsAdded() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = futureDate.format(formatter);
        graduationPage.graduationLastDate.sendKeys(formattedDate);
    }

    @And("after searching the results are displayed in the users table")
    public void afterSearchingTheResultsAreDisplayedInTheUsersTable() {
        structureAndDutiesPage.searchButton.click();
        ReusableMethods.wait(1);
    }

    @Then("the user's administrative approval is displayed as closed in the table")
    public void theUserSAdministrativeApprovalIsDisplayedAsClosedInTheTable() {
        ReusableMethods.flash(graduationPage.adminApprovalResultTable,getDriver());
        String actual = graduationPage.adminApprovalResultTable.getText();
        String expected = "close";
        Assert.assertEquals(actual,expected);
    }
    
    @Then("the user's current account status is displayed as closed in the table")
    public void theUserSCurrentAccountStatusIsDisplayedAsClosedInTheTable() {
        ReusableMethods.flash(graduationPage.currentAccountResultTable,getDriver());
        String actual = graduationPage.currentAccountResultTable.getText();
        String expected = "close";
        Assert.assertEquals(actual,expected);
    }

    @Then("the user's administrative approval is displayed as opened in the table")
    public void theUserSAdministrativeApprovalIsDisplayedAsOpenedInTheTable() {
        ReusableMethods.flash(graduationPage.adminApprovalResultTable,getDriver());
        String actual = graduationPage.adminApprovalResultTable.getText();
        String expected = "check";
        Assert.assertEquals(actual,expected);
    }

    @Then("the user's current account status is displayed as opened in the table")
    public void theUserSCurrentAccountStatusIsDisplayedAsOpenedInTheTable() {
        ReusableMethods.flash(graduationPage.currentAccountResultTable,getDriver());
        String actual = graduationPage.currentAccountResultTable.getText();
        String expected = "check";
        Assert.assertEquals(actual,expected);
    }
}