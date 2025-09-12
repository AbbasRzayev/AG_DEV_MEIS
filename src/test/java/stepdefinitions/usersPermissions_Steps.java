package stepdefinitions;

import Page.*;
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
    leftSIdeBarMenu_Page leftSideBare = new leftSIdeBarMenu_Page();
    headerAndFooter_Page header = new headerAndFooter_Page();
    electronLibrary_Page electronLibrary = new electronLibrary_Page();
    helpDesk_Page helpDesk = new helpDesk_Page();

    @And("switches to the user permissions tab")
    public void switchesToTheUserPermissionsTab() {
        page1.userPermissionsTab.click();
        ReusableMethods.wait(3);
    }

    @And("selects {string} in the permissions tab")
    public void selectsInThePermissionsTab(String permissions) {
        if (permissions.contains("Bütün istifadəçilərlə əməliyyatların aparılması")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();
            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.logWithUserName.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.sturctireAndDutyCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.programUseCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollEndByJavascript();

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.scrollToElementByActions(page.proqITHelpSpecCheck);
                ReusableMethods.wait(1);
                page.proqITHelpSpecCheck.click();
                ReusableMethods.scrollToElementByActions(page.proqITSpecCheck);
                ReusableMethods.wait(1);
                page.proqITSpecCheck.click();
            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.scrollToElementByActions(page.proqITHelpSpecCheck);
                ReusableMethods.wait(1);
                page.proqITHelpSpecCheck.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.ideaCheck);
                ReusableMethods.wait(1);
                page.ideaCheck.click();

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.calendarCheck);
                ReusableMethods.wait(1);
                page.calendarCheck.click();

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                System.out.println("Checkbox is selected.");
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.calenEditCheck);
                page.calenEditCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskEditCheck);
                page.helpDeskEditCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskVisionCheck);
                page.proqITHelpSpecCheck.click();
                ReusableMethods.wait(1);
//                page.helpDeskEditCheck.click();
                page.helpDeskVisionCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.helpDeskVisionCheck);
                page.proqITHelpSpecCheck.click();
                ReusableMethods.wait(1);
//                page.helpDeskEditCheck.click();
                page.helpDeskVisionCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Təlimlər moduluna baxış")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.scrollToElementByActions(page.studyEditCheck);
                page.studyVisionCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.studyEditCheck);
                page.studyEditCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                page.elanCheck.click();
                ReusableMethods.scrollToElementByActions(page.congratsCheck);
                page.congratsCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.bazaCheck);
                page.bazaCheck.click();
                ReusableMethods.wait(1);

            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.programEditCheck);
                page.programEditCheck.click();
                ReusableMethods.wait(1);

            } else {

                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullCheck);
                page.usefullCheck.click();
                ReusableMethods.wait(1);
            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullCheck);
                page.usefullCheck.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Elektron jurnallara baxış")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.electronicJournal);
                page.electronicJournal.click();
                ReusableMethods.wait(1);
            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.electronicJournal);
                page.electronicJournal.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Elektron jurnalların idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.electronicJournalEdit);
                page.electronicJournalEdit.click();
                ReusableMethods.wait(1);
            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.electronicJournalEdit);
                page.electronicJournalEdit.click();
                ReusableMethods.wait(1);
            }

        } else if (permissions.contains("Faydalı məlumatlar modulunun idarə edilməsi")) {
            WebElement checkbox = getDriver().findElement(By.xpath("//input[@id='mat-mdc-checkbox-1-input']"));
            System.out.println("checkbox.getClass() = " + checkbox.getClass());

            if (checkbox.isSelected()) {
                System.out.println("Checkbox isselected.");
                ReusableMethods.wait(1);
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.usersAllOperations.click();
                ReusableMethods.wait(1);
                ReusableMethods.scrollToElementByActions(page.usefullEditCheck);
                page.usefullEditCheck.click();
                ReusableMethods.wait(1);
            } else {
                page.allPermissions.click();
                ReusableMethods.wait(1);
                page.allPermissions.click();
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
                System.out.println("Checkbox is selected.");

            } else {
                page.allPermissions.click();
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

    @Then("user can realize his {string} in the MEIS system according to the permissions given to him")
    public void userCanRealizeHisInTheMEISSystemAccordingToThePermissionsGivenToHim(String opportunities) {
        if (opportunities.contains("firstCase")) {
            ReusableMethods.wait(1);
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.flash(page.adminPanelBtn, getDriver());
            assertTrue(page.adminPanelBtn.isDisplayed());
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.adminUsers, getDriver());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("secondCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);
            leftSideBare.congrats.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.announceTittle, getDriver());
            assertTrue(page.announceTittle.isDisplayed());
            ReusableMethods.wait(1);
            page.adminPanelBtn.click();
            ReusableMethods.flash(page.adminElan, getDriver());
            page.adminElan.click();
            ReusableMethods.wait(1);
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.adminCongrats, getDriver());
//            page.adminCongrats.click();
            ReusableMethods.wait(1);
            assertTrue(page.adminElan.isDisplayed());
            ReusableMethods.flash(page.adminQuestionnaires, getDriver());
            page.adminQuestionnaires.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("thirdCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);
            leftSideBare.libery.click();
            ReusableMethods.wait(2);
            ReusableMethods.flash(electronLibrary.electronicJournalTab, getDriver());
            assertTrue(electronLibrary.electronicJournalTab.isDisplayed());
            ReusableMethods.wait(1);
        }else if (opportunities.contains("fourthCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);
            leftSideBare.adminpanel.click();
            ReusableMethods.wait(2);
            page.adminElectrLibary.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminElectronJournal, getDriver());
            assertTrue(page.adminElectronJournal.isDisplayed());
            ReusableMethods.wait(1);
        } else if (opportunities.contains("fifthCase")) {
            leftSideBare.leftSideBarBtn.click();
            leftSideBare.libery.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminUsefulInfor, getDriver());
            assertTrue(page.adminUsefulInfor.isDisplayed());
            ReusableMethods.wait(1);
        }
        else if (opportunities.contains("sixthCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            leftSideBare.adminpanel.click();
            ReusableMethods.wait(1);
            page.adminElectrLibary.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminUsefulInfor, getDriver());
            assertTrue(page.adminUsefulInfor.isDisplayed());
            ReusableMethods.wait(1);
        }   else if (opportunities.contains("seventhCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);

            leftSideBare.idea.click();
            ReusableMethods.wait(2);
            
            ReusableMethods.flash(leftSideBare.ideaLogo, getDriver());
            assertTrue(leftSideBare.ideaLogo.isDisplayed());

            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
            ReusableMethods.flash(page.adminIdea, getDriver());
            assertTrue(page.adminIdea.isDisplayed());
            page.adminIdea.click();
            ReusableMethods.wait(1);
        } else if (opportunities.contains("eighthCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);

            leftSideBare.base.click();
            ReusableMethods.wait(2);

            ReusableMethods.flash(leftSideBare.baseLogo, getDriver());
            assertTrue(leftSideBare.baseLogo.isDisplayed());

            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
            ReusableMethods.flash(page.adminBaza, getDriver());
            assertTrue(page.adminBaza.isDisplayed());
            page.adminBaza.click();
            ReusableMethods.wait(1);

        }else if (opportunities.contains("ninthCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
            ReusableMethods.flash(page.adminHelpDesk, getDriver());
            assertTrue(page.adminHelpDesk.isDisplayed());
            ReusableMethods.wait(1);
            page.adminHelpDesk.click();
            ReusableMethods.wait(1);
            helpDesk.firstAppealFromTable.click();
            ReusableMethods.wait(2);
            helpDesk.addExecutorToTheRequest.click();
            ReusableMethods.wait(2);
            helpDesk.executorInputToTheRequest.sendKeys("Abbas Zam");
            ReusableMethods.wait(2);
            ReusableMethods.flash(helpDesk.abbasExecutorSelect,getDriver());
            assertTrue(helpDesk.abbasExecutorSelect.isDisplayed());
        }else if (opportunities.contains("tenthCase")) {
            leftSideBare.leftSideBarBtn.click();
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminShablon, getDriver());
            page.adminShablon.click();
            ReusableMethods.flash(page.adminProqram, getDriver());
            assertTrue(page.adminProqram.isDisplayed());
            page.adminProqram.click();
            ReusableMethods.wait(2);
        }else if (opportunities.contains("eleventhCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminStrukturDuty, getDriver());
            ReusableMethods.wait(1);
            assertTrue(page.adminStrukturDuty.isDisplayed());
            page.adminStrukturDuty.click();
            ReusableMethods.wait(1);
        }else if (opportunities.contains("twelfthCase")) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(helpDesk.abbasUserNameCheck, getDriver());
            assertTrue(helpDesk.abbasUserNameCheck.isDisplayed());
        }else if (opportunities.contains("thirteenthCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            leftSideBare.congrats.click();
            ReusableMethods.wait(1);
            String checkAnnounce = "Elan və təbriklər | MEIS";
            assertEquals(checkAnnounce, getDriver().getTitle());
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminCongrats, getDriver());
            page.adminCongrats.click();
            ReusableMethods.wait(1);
        }else if (opportunities.contains("fourteenthCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            leftSideBare.libery.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.libaryLogo, getDriver());
            String checkElectron = "Elektron kitabxana | MEIS";
            assertEquals(checkElectron, getDriver().getTitle());
        }else if (opportunities.contains("fifteenCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            page.adminElectrLibary.click();
            ReusableMethods.flash(page.adminElectrLibaryStudy, getDriver());
            assertTrue(page.adminElectrLibaryStudy.isDisplayed());
        }else if (opportunities.contains("sixteenCase")) {
            ReusableMethods.flash(page.mainCal, getDriver());
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(2);
            leftSideBare.calendar.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.calendar, getDriver());
            ReusableMethods.wait(1);
        }else if (opportunities.contains("seventeenCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminCal, getDriver());
            ReusableMethods.wait(1);
            page.adminCal.click();
            ReusableMethods.wait(1);
        }else if (opportunities.contains("eighteenCase")) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.mainProg, getDriver());
            ReusableMethods.wait(1);
        }else if (opportunities.contains("nineteenCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            leftSideBare.helpDesk.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.helpDeskLogo, getDriver());
            String checkHelpDesk = "Yardım masası | MEIS";
            assertEquals(checkHelpDesk, getDriver().getTitle());
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.adminHelpDesk, getDriver());
            assertTrue(page.adminHelpDesk.isDisplayed());
            ReusableMethods.wait(1);
        }else if (opportunities.contains("twentyFirstCase")) {
            leftSideBare.leftSideBarBtn.click();
            ReusableMethods.wait(1);
            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
            ReusableMethods.wait(1);
            page.adminHelpDesk.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(helpDesk.firstAppealFromTable, getDriver());
            assertTrue(helpDesk.firstAppealFromTable.isDisplayed());
            ReusableMethods.wait(1);
        }

        else if (opportunities.contains("twentySecondCase")) {
            ReusableMethods.flash(page.mainProg, getDriver());
            assertTrue(page.mainProg.isDisplayed());
            ReusableMethods.flash(page.mainAnnouncements, getDriver());
            assertTrue(page.mainAnnouncements.isDisplayed());
            ReusableMethods.flash(page.mainIdea, getDriver());
            assertTrue(page.mainIdea.isDisplayed());
            ReusableMethods.flash(page.mainLegalBasis, getDriver());
            assertTrue(page.mainLegalBasis.isDisplayed());
            ReusableMethods.scrollEndByJavascript();
            ReusableMethods.flash(page.mainElectronLibrary, getDriver());
            assertTrue(page.mainElectronLibrary.isDisplayed());
            ReusableMethods.flash(page.mainCal, getDriver());
            assertTrue(page.mainCal.isDisplayed());
            ReusableMethods.flash(page.mainAdminPanel, getDriver());
            assertTrue(page.mainAdminPanel.isDisplayed());
            ReusableMethods.flash(page.mainHelpDesk, getDriver());
            assertTrue(page.mainHelpDesk.isDisplayed());
            ReusableMethods.scrollTopByJavascript();

            leftSideBare.leftSideBarBtn.click();
            leftSideBare.mainPage.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.mainLogo, getDriver());
            String tittle = "Ana səhifə | MEIS";
            assertEquals(tittle, getDriver().getTitle());
            ReusableMethods.wait(2);

            leftSideBare.personalCabinet.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.mainLogo, getDriver());
            String checkPerson = "Şəxsi kabinetim | MEIS";
            assertEquals(checkPerson, getDriver().getTitle());

            leftSideBare.programs.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.progLogo, getDriver());
            String checkProg = "Proqramlarım | MEIS";
            ReusableMethods.wait(5);
            assertEquals(checkProg, getDriver().getTitle());

            leftSideBare.congrats.click();
            ReusableMethods.wait(3);
            String checkAnnounce = "Elan və təbriklər | MEIS";
            assertEquals(checkAnnounce, getDriver().getTitle());

            leftSideBare.idea.click();
            ReusableMethods.wait(2);
            ReusableMethods.flash(leftSideBare.ideaLogo, getDriver());
            String checkIdea = "İdea bankı | MEIS";
            assertEquals(checkIdea, getDriver().getTitle());

            leftSideBare.base.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.baseLogo, getDriver());
            String checkBase = "Hüquqi baza | MEIS";
            assertEquals(checkBase, getDriver().getTitle());

            leftSideBare.libery.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.libaryLogo, getDriver());
            String checkElectron = "Elektron kitabxana | MEIS";
            assertEquals(checkElectron, getDriver().getTitle());

            leftSideBare.calendar.click();
            ReusableMethods.wait(2);
            String checkCalendar = "Təqvim | MEIS";
            assertEquals(checkCalendar, getDriver().getTitle());

            leftSideBare.adminpanel.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.adminLogo, getDriver());
            String checkAdmin = "İstifadəçilər | MEIS";
            assertEquals(checkAdmin, getDriver().getTitle());

            leftSideBare.helpDesk.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(leftSideBare.helpDeskLogo, getDriver());
            String checkHelpDesk = "Yardım masası | MEIS";
            assertEquals(checkHelpDesk, getDriver().getTitle());

            page.adminPanelBtn.click();
            ReusableMethods.wait(1);
            header.closeLeftSideBar.click();
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
//        if (opportunities.contains("firstCase")) {
//            ReusableMethods.wait(1);
//            page.leftSideBare.click();
//            ReusableMethods.flash(page.adminPanelBtn, getDriver());
//            assertTrue(page.adminPanelBtn.isDisplayed());
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.userTittle, getDriver());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("secondCase")) {
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.checkUserName, getDriver());
//            assertTrue(page.checkUserName.isDisplayed());
//        } else if (opportunities.contains("thirdCase")) {
//            page.leftSideBare.click();
//            ReusableMethods.wait(2);
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.sturctireAndDutyTab, getDriver());
//            ReusableMethods.wait(1);
//            assertTrue(page.sturctireAndDutyTab.isDisplayed());
//            page.sturctireAndDutyTab.click();
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("fourthCase")) {
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.mainProqramBtnk, getDriver());
//            ReusableMethods.wait(1);
//            page.leftSideBare.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.leftSideBareProgram, getDriver());
//            page.leftSideBareProgram.click();
//            ReusableMethods.flash(page.programTittle, getDriver());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("fifthCase")) {
//            page.leftSideBare.click();
//            ReusableMethods.wait(2);
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.elanAdmin, getDriver());
//            page.elanAdmin.click();
//            ReusableMethods.wait(1);
//            //ReusableMethods.flash(page.tebrikAdmin, getDriver());
//            //page.tebrikAdmin.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.soraqAdmin, getDriver());
//            page.soraqAdmin.click();
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("sixthCase")) {
//            page.leftSideBare.click();
//            ReusableMethods.wait(2);
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.helpAdminFlash, getDriver());
//            assertTrue(page.helpAdminFlash.isDisplayed());
//            ReusableMethods.wait(1);
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.helpAdminFlash2, getDriver());
//            assertTrue(page.helpAdminFlash2.isDisplayed());
//        } else if (opportunities.contains("seventhCase")) {
//            page.leftSideBare.click();
//            ReusableMethods.wait(2);
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.ideaAdmin, getDriver());
//            assertTrue(page.ideaAdmin.isDisplayed());
//            page.ideaAdmin.click();
//            ReusableMethods.wait(1);
//            page.soraqAdmin.click();
//            ReusableMethods.flash(page.ideaSoraq, getDriver());
//        } else if (opportunities.contains("eighthCase")) {
//            ReusableMethods.flash(page.mainCalendar, getDriver());
//            page.leftSideBare.click();
//            ReusableMethods.wait(2);
//            ReusableMethods.flash(page.leftSideCalendar, getDriver());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("ninthCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.adminCalendar, getDriver());
//            page.adminCalendar.click();
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("tenthCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.flash(page.helpDeskAdmin, getDriver());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("eleventhCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//            page.helpDeskAdmin.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.helpDeskVisionAdin, getDriver());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("twelfthCase")) {
//            page.leftSideBare.click();
//            page.elanSideBare.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.studyAdminFlash, getDriver());
//            assertTrue(page.studyAdminFlash.isDisplayed());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("thirteenthCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            page.electronBookAdmin.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.newUsefull, getDriver());
//            assertTrue(page.newUsefull.isDisplayed());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("fourteenthCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.congratAdmin, getDriver());
//            page.congratAdmin.click();
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("fifteenCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.bazaAdmin, getDriver());
//            page.bazaAdmin.click();
//            ReusableMethods.wait(2);
//        } else if (opportunities.contains("sixteenCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.shablonAdmin, getDriver());
//            page.shablonAdmin.click();
//            ReusableMethods.flash(page.proqAdmin, getDriver());
//            assertTrue(page.proqAdmin.isDisplayed());
//            page.proqAdmin.click();
//            ReusableMethods.wait(2);
//        } else if (opportunities.contains("seventeenCase")) {
//            page.leftSideBare.click();
//            page.electronBookLeftside.click();
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.usefullFlash, getDriver());
//            assertTrue(page.usefullFlash.isDisplayed());
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("eighteenCase")) {
//            page.leftSideBare.click();
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//            page.electronBookAdmin.click();
//            ReusableMethods.flash(page.usefullFlash, getDriver());
//            ReusableMethods.flash(page.usefullAddBtn, getDriver());
//            assertTrue(page.usefullAddBtn.isDisplayed());
//            page.usefullAddBtn.click();
//            ReusableMethods.wait(1);
//        } else if (opportunities.contains("nineteenth")) {
//            ReusableMethods.flash(page.checkUserName, getDriver());
//            assertTrue(page.checkUserName.isDisplayed());
//            ReusableMethods.flash(page.mainEsas, getDriver());
//            assertTrue(page.mainEsas.isDisplayed());
//            ReusableMethods.flash(page.mainPersonalCab, getDriver());
//            assertTrue(page.mainEsas.isDisplayed());
//            ReusableMethods.flash(page.mainProg, getDriver());
//            assertTrue(page.mainProg.isDisplayed());
//            ReusableMethods.flash(page.mainElan, getDriver());
//            assertTrue(page.mainElan.isDisplayed());
//            ReusableMethods.flash(page.mainFikir, getDriver());
//            assertTrue(page.mainFikir.isDisplayed());
//            ReusableMethods.flash(page.mainBaza, getDriver());
//            assertTrue(page.mainBaza.isDisplayed());
//            ReusableMethods.scrollEndByJavascript();
//            ReusableMethods.flash(page.mainElectronBook, getDriver());
//            assertTrue(page.mainElectronBook.isDisplayed());
//            ReusableMethods.flash(page.mainCal, getDriver());
//            assertTrue(page.mainCal.isDisplayed());
//            ReusableMethods.flash(page.mainAdminPanel, getDriver());
//            assertTrue(page.mainAdminPanel.isDisplayed());
//            ReusableMethods.flash(page.mainHelpDesk, getDriver());
//            assertTrue(page.mainHelpDesk.isDisplayed());
//            ReusableMethods.flash(page.mainExit, getDriver());
//            assertTrue(page.mainExit.isDisplayed());
//            ReusableMethods.scrollTopByJavascript();
//            page.leftSideBare.click();
//
//            ReusableMethods.flash(page.leftMain, getDriver());
//            assertTrue(page.leftMain.isDisplayed());
//            ReusableMethods.flash(page.leftPer, getDriver());
//            assertTrue(page.leftPer.isDisplayed());
//            ReusableMethods.flash(page.leftProq, getDriver());
//            assertTrue(page.leftProq.isDisplayed());
//            ReusableMethods.flash(page.leftElm, getDriver());
//            assertTrue(page.leftElm.isDisplayed());
//            ReusableMethods.flash(page.leftIdea, getDriver());
//            assertTrue(page.leftIdea.isDisplayed());
//            ReusableMethods.flash(page.leftBaza, getDriver());
//            assertTrue(page.leftBaza.isDisplayed());
//            ReusableMethods.flash(page.leftELecLibary, getDriver());
//            assertTrue(page.leftELecLibary.isDisplayed());
//            ReusableMethods.flash(page.leftcal, getDriver());
//            assertTrue(page.leftcal.isDisplayed());
//            ReusableMethods.flash(page.leftAdmin, getDriver());
//            assertTrue(page.leftAdmin.isDisplayed());
//            ReusableMethods.flash(page.leftHelp, getDriver());
//            assertTrue(page.leftHelp.isDisplayed());
//            ReusableMethods.flash(page.leftExit, getDriver());
//            assertTrue(page.leftExit.isDisplayed());
//            page.adminPanelBtn.click();
//            ReusableMethods.wait(1);
//
//            page.adminUsers.click();
//            ReusableMethods.flash(page.adminUsers, getDriver());
//            assertTrue(page.adminUsers.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminShablon.click();
//            ReusableMethods.flash(page.adminShablon, getDriver());
//            assertTrue(page.adminShablon.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminProqram.click();
//            ReusableMethods.flash(page.adminProqram, getDriver());
//            assertTrue(page.adminProqram.isDisplayed());
//            ReusableMethods.wait(1);
//
//
//            page.adminStrukturDuty.click();
//            ReusableMethods.flash(page.adminStrukturDuty, getDriver());
//            assertTrue(page.adminStrukturDuty.isDisplayed());
//            ReusableMethods.wait(1);
//
//
//            page.adminElan.click();
//            ReusableMethods.flash(page.adminElan, getDriver());
//            assertTrue(page.adminElan.isDisplayed());
//            ReusableMethods.wait(1);
//
//
//            page.adminCongrats.click();
//            ReusableMethods.flash(page.adminCongrats, getDriver());
//            assertTrue(page.adminCongrats.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminIdea.click();
//            ReusableMethods.flash(page.adminIdea, getDriver());
//            assertTrue(page.adminIdea.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminBaza.click();
//            ReusableMethods.flash(page.adminBaza, getDriver());
//            assertTrue(page.adminBaza.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminElectrLibary.click();
//            ReusableMethods.flash(page.adminElectrLibary, getDriver());
//            assertTrue(page.adminElectrLibary.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminCal.click();
//            ReusableMethods.flash(page.adminCal, getDriver());
//            assertTrue(page.adminCal.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminHelpDesk.click();
//            ReusableMethods.flash(page.adminHelpDesk, getDriver());
//            assertTrue(page.adminHelpDesk.isDisplayed());
//            ReusableMethods.wait(1);
//
//            page.adminQuestionnaires.click();
//            ReusableMethods.flash(page.adminQuestionnaires, getDriver());
//            assertTrue(page.adminQuestionnaires.isDisplayed());
//            ReusableMethods.wait(1);
//        }
//    }
}