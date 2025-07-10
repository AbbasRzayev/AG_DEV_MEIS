package stepdefinitions;

import Page.registration_Page;
import Page.usersPermissions_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class usersPermissions_Steps {
    usersPermissions_Page page = new usersPermissions_Page();
    registration_Page page1 = new registration_Page();

    @And("switches to the user permissions tab")
    public void switchesToTheUserPermissionsTab() {
        page1.userPermissionsTab.click();
        ReusableMethods.wait(1);
    }

    @And("selects {string} in the permissions tab")
    public void selectsInThePermissionsTab(String permissions) {
        if (permissions.contains("Bütün istifadəçilərlə əməliyyatların aparılması")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();
            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();
                System.out.println("Checkbox is not selected.");
            }

        } else if (permissions.contains("Şəxsin adından sistemə giriş etmək")) {

            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.logWithUserName.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.logWithUserName.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            }

        } else if (permissions.contains("Strukturda əməliyyatların aparılması")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.sturctireAndDutyCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.sturctireAndDutyCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            }

        } else if (permissions.contains("Təyin edilmiş proqramlardan istifadə")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.programUseCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.programUseCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();
            }

        } else if (permissions.contains("Elanlar modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            }

        } else if (permissions.contains("Proqramçı IT mütəxəssis")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.scrollToElementByActions(page.proqITSpecCheck);
                ReusableMethods.wait(1);
                page.proqITSpecCheck.click();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.scrollToElementByActions(page.proqITSpecCheck);
                ReusableMethods.wait(1);
                page.proqITSpecCheck.click();

            }

        } else if (permissions.contains("Fikir bankı modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.ideaCheck);
                ReusableMethods.wait(1);
                page.ideaCheck.click();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.ideaCheck);
                ReusableMethods.wait(1);
                page.ideaCheck.click();

            }

        } else if (permissions.contains("Təqvimə baxış imkanı")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.calendarCheck);
                ReusableMethods.wait(1);
                page.calendarCheck.click();

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.calendarCheck);
                ReusableMethods.wait(1);
                page.calendarCheck.click();

            }

        } else if (permissions.contains("Təqvim modulunun idarəedilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.calenEditCheck);
                page.calenEditCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.calenEditCheck);
                page.calenEditCheck.click();
                ReusableMethods.wait(1);

            }

        } else if (permissions.contains("Yardım masası modulunun idarəedilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskEditCheck);
                page.helpDeskEditCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskEditCheck);
                page.helpDeskEditCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Yardım masasına göndərilən müraciətlərə baxış")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskVisionCheck);
                page.helpDeskEditCheck.click();
                page.helpDeskVisionCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskVisionCheck);
                page.helpDeskEditCheck.click();
                page.helpDeskVisionCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Təlimlər moduluna baxış")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.scrollToElementByActions(page.studyEditCheck);
                page.studyVisionCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.scrollToElementByActions(page.studyEditCheck);
                page.studyVisionCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Təlimlər modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.studyEditCheck);
                page.studyEditCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.studyEditCheck);
                page.studyEditCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Təbriklər modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.scrollToElementByActions(page.congratsCheck);
                page.congratsCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.scrollToElementByActions(page.congratsCheck);
                page.congratsCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Hüquqi baza modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.bazaCheck);
                page.bazaCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.bazaCheck);
                page.bazaCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Proqramlar modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.programEditCheck);
                page.programEditCheck.click();
                ReusableMethods.wait(1);

            } else {

                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.programEditCheck);
                page.programEditCheck.click();
                ReusableMethods.wait(1);

            }

        } else if (permissions.contains("Faydalı məlumatlar moduluna baxış")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullCheck);
                page.usefullCheck.click();
                ReusableMethods.wait(1);
            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullCheck);
                page.usefullCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Faydalı məlumatlar modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullEditCheck);
                page.usefullEditCheck.click();
                ReusableMethods.wait(1);
            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.allPermissons.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullEditCheck);
                page.usefullEditCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Bütün əməliyyatların aparılması")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");

            } else {
                page.allPermissons.click();
                ReusableMethods.wait(1);
            }

        }

    }

    @And("user select save changes button")
    public void userSelectSaveChangesButton() {
        ReusableMethods.wait(1);
        page.saveAllChangesBtn.click();
        ReusableMethods.scrollTopByJavascript();
        ReusableMethods.wait(1);

    }

    @When("admin selects Log in with user name button")
    public void adminSelectsLogInWithUserNameButton() {
        ReusableMethods.waitForClickabilityAndClick(page.enterWithNameUser, 10);
        ReusableMethods.wait(2);
    }

    @Then("user can realize his {string} in the Meis system according to the permissions given to him")
    public void userCanRealizeHisInTheMeisSystemAccordingToThePermissionsGivenToHim(String opportunities) {
        if (opportunities.contains("firstCase")) {
            ReusableMethods.wait(1);
            page.leftSideBare.click();
            ReusableMethods.flash(page.adminPanelBtn, getDriver());
            assertTrue(page.adminPanelBtn.isDisplayed());
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.userTittle, getDriver());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("secondCase")) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.checkUserName, getDriver());
            assertTrue(page.checkUserName.isDisplayed());
        } else if (opportunities.contains("thirdCase")) {
            page.leftSideBare.click();
            ReusableMethods.wait(2);
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.sturctireAndDutyTab, getDriver());
            ReusableMethods.wait(1);
            assertTrue(page.sturctireAndDutyTab.isDisplayed());
            page.sturctireAndDutyTab.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("fourthCase")) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.mainProqramBtnk, getDriver());
            ReusableMethods.wait(1);
            page.leftSideBare.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.leftSideBareProgram, getDriver());
            page.leftSideBareProgram.click();
            ReusableMethods.flash(page.programTittle, getDriver());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("fifthCase")) {
            page.leftSideBare.click();
            ReusableMethods.wait(2);
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.elanAdmin, getDriver());
            page.elanAdmin.click();
            ReusableMethods.wait(1);
            //ReusableMethods.flash(page.tebrikAdmin, getDriver());
            //page.tebrikAdmin.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.soraqAdmin, getDriver());
            page.soraqAdmin.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("sixthCase")) {
            page.leftSideBare.click();
            ReusableMethods.wait(2);
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.helpAdminFlash, getDriver());
            assertTrue(page.helpAdminFlash.isDisplayed());
            ReusableMethods.wait(1);
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.helpAdminFlash2, getDriver());
            assertTrue(page.helpAdminFlash2.isDisplayed());
        } else if (opportunities.contains("seventhCase")) {
            page.leftSideBare.click();
            ReusableMethods.wait(2);
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.ideaAdmin, getDriver());
            assertTrue(page.ideaAdmin.isDisplayed());
            page.ideaAdmin.click();
            ReusableMethods.wait(1);
            page.soraqAdmin.click();
            ReusableMethods.flash(page.ideaSoraq, getDriver());
        } else if (opportunities.contains("eighthCase")) {
            ReusableMethods.flash(page.mainCalendar, getDriver());
            page.leftSideBare.click();
            ReusableMethods.wait(2);
            ReusableMethods.flash(page.leftSideCalendar, getDriver());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("ninthCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.adminCalendar, getDriver());
            page.adminCalendar.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("tenthCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.helpDeskAdmin, getDriver());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("eleventhCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            page.helpDeskAdmin.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.helpDeskVisionAdin, getDriver());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("twelfthCase")) {
            page.leftSideBare.click();
            page.elanSideBare.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.studyAdminFlash, getDriver());
            assertTrue(page.studyAdminFlash.isDisplayed());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("thirteenthCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            page.electronBookAdmin.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.newUsefull, getDriver());
            assertTrue(page.newUsefull.isDisplayed());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("fourteenthCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.congratAdmin, getDriver());
            page.congratAdmin.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("fifteenCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.bazaAdmin, getDriver());
            page.bazaAdmin.click();
            ReusableMethods.wait(2);
        } else if (opportunities.contains("sixteenCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.shablonAdmin, getDriver());
            page.shablonAdmin.click();
            ReusableMethods.flash(page.proqAdmin, getDriver());
            assertTrue(page.proqAdmin.isDisplayed());
            page.proqAdmin.click();
            ReusableMethods.wait(2);
        } else if (opportunities.contains("seventeenCase")) {
            page.leftSideBare.click();
            page.electronBookLeftside.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.usefullFlash, getDriver());
            assertTrue(page.usefullFlash.isDisplayed());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("eighteenCase")) {
            page.leftSideBare.click();
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            page.electronBookAdmin.click();
            ReusableMethods.flash(page.usefullFlash, getDriver());
            ReusableMethods.flash(page.usefullAddBtn, getDriver());
            assertTrue(page.usefullAddBtn.isDisplayed());
            page.usefullAddBtn.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("nineteenth")) {
            ReusableMethods.flash(page.checkUserName, getDriver());
            assertTrue(page.checkUserName.isDisplayed());
            ReusableMethods.flash(page.mainEsas, getDriver());
            assertTrue(page.mainEsas.isDisplayed());
            ReusableMethods.flash(page.mainPersonalCab, getDriver());
            assertTrue(page.mainEsas.isDisplayed());
            ReusableMethods.flash(page.mainProg, getDriver());
            assertTrue(page.mainProg.isDisplayed());
            ReusableMethods.flash(page.mainElan, getDriver());
            assertTrue(page.mainElan.isDisplayed());
            ReusableMethods.flash(page.mainFikir, getDriver());
            assertTrue(page.mainFikir.isDisplayed());
            ReusableMethods.flash(page.mainBaza, getDriver());
            assertTrue(page.mainBaza.isDisplayed());
            ReusableMethods.scrollEndByJavascript();
            ReusableMethods.flash(page.mainElectronBook, getDriver());
            assertTrue(page.mainElectronBook.isDisplayed());
            ReusableMethods.flash(page.mainCal, getDriver());
            assertTrue(page.mainCal.isDisplayed());
            ReusableMethods.flash(page.mainAdminPanel, getDriver());
            assertTrue(page.mainAdminPanel.isDisplayed());
            ReusableMethods.flash(page.mainHelpDesk, getDriver());
            assertTrue(page.mainHelpDesk.isDisplayed());
            ReusableMethods.flash(page.mainExit, getDriver());
            assertTrue(page.mainExit.isDisplayed());
            ReusableMethods.scrollTopByJavascript();
            page.leftSideBare.click();

            ReusableMethods.flash(page.leftMain, getDriver());
            assertTrue(page.leftMain.isDisplayed());
            ReusableMethods.flash(page.leftPer, getDriver());
            assertTrue(page.leftPer.isDisplayed());
            ReusableMethods.flash(page.leftProq, getDriver());
            assertTrue(page.leftProq.isDisplayed());
            ReusableMethods.flash(page.leftElm, getDriver());
            assertTrue(page.leftElm.isDisplayed());
            ReusableMethods.flash(page.leftIdea, getDriver());
            assertTrue(page.leftIdea.isDisplayed());
            ReusableMethods.flash(page.leftBaza, getDriver());
            assertTrue(page.leftBaza.isDisplayed());
            ReusableMethods.flash(page.leftELecLibary, getDriver());
            assertTrue(page.leftELecLibary.isDisplayed());
            ReusableMethods.flash(page.leftcal, getDriver());
            assertTrue(page.leftcal.isDisplayed());
            ReusableMethods.flash(page.leftAdmin, getDriver());
            assertTrue(page.leftAdmin.isDisplayed());
            ReusableMethods.flash(page.leftHelp, getDriver());
            assertTrue(page.leftHelp.isDisplayed());
            ReusableMethods.flash(page.leftExit, getDriver());
            assertTrue(page.leftExit.isDisplayed());
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);

            page.adminUsers.click();
            ReusableMethods.flash(page.adminUsers, getDriver());
            assertTrue(page.adminUsers.isDisplayed());
            ReusableMethods.wait(1);

            page.adminShablon.click();
            ReusableMethods.flash(page.adminShablon, getDriver());
            assertTrue(page.adminShablon.isDisplayed());
            ReusableMethods.wait(1);

            page.adminProqram.click();
            ReusableMethods.flash(page.adminProqram, getDriver());
            assertTrue(page.adminProqram.isDisplayed());
            ReusableMethods.wait(1);


            page.adminStrukturDuty.click();
            ReusableMethods.flash(page.adminStrukturDuty, getDriver());
            assertTrue(page.adminStrukturDuty.isDisplayed());
            ReusableMethods.wait(1);


            page.adminElan.click();
            ReusableMethods.flash(page.adminElan, getDriver());
            assertTrue(page.adminElan.isDisplayed());
            ReusableMethods.wait(1);


            page.adminCongrats.click();
            ReusableMethods.flash(page.adminCongrats, getDriver());
            assertTrue(page.adminCongrats.isDisplayed());
            ReusableMethods.wait(1);

            page.adminIdea.click();
            ReusableMethods.flash(page.adminIdea, getDriver());
            assertTrue(page.adminIdea.isDisplayed());
            ReusableMethods.wait(1);

            page.adminBaza.click();
            ReusableMethods.flash(page.adminBaza, getDriver());
            assertTrue(page.adminBaza.isDisplayed());
            ReusableMethods.wait(1);

            page.adminElectrLibary.click();
            ReusableMethods.flash(page.adminElectrLibary, getDriver());
            assertTrue(page.adminElectrLibary.isDisplayed());
            ReusableMethods.wait(1);

            page.adminCal.click();
            ReusableMethods.flash(page.adminCal, getDriver());
            assertTrue(page.adminCal.isDisplayed());
            ReusableMethods.wait(1);

            page.adminHelpDesk.click();
            ReusableMethods.flash(page.adminHelpDesk, getDriver());
            assertTrue(page.adminHelpDesk.isDisplayed());
            ReusableMethods.wait(1);

            page.adminQuestionnaires.click();
            ReusableMethods.flash(page.adminQuestionnaires, getDriver());
            assertTrue(page.adminQuestionnaires.isDisplayed());
            ReusableMethods.wait(1);
        }
    }
}