package stepdefinitions;

import Page.contactInformationEditing_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class contactInformationEditing_Steps {
    contactInformationEditing_Page page = new contactInformationEditing_Page();

    @And("user goes to the contact information tab from personal cabinet")
    public void userGoesToTheContactInformationTabFromPersonalCabinet() {
        page.contacInfoTab.click();
        ReusableMethods.wait(1);


    }

    @And("user selects edit button in the contact information tab")
    public void userSelectsEditButtonInTheContactInformationTab() {
        ReusableMethods.scrollEndByJavascript();
        page.editBTn.click();
        ReusableMethods.wait(1);
    }


    @And("user changes {string} and {string} and {string} and {string} and {string} and {string} in the edit modal window")
    public void userChangesAndAndAndAndAndInTheEditModalWindow(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        page.roomField.clear();
        ReusableMethods.wait(1);
        page.roomField.sendKeys(arg0);
        ReusableMethods.wait(1);
        page.ipPhoneField.clear();
        ReusableMethods.wait(1);
        page.ipPhoneField.sendKeys(arg1);
        page.stasNumField.clear();
        ReusableMethods.wait(1);
        page.stasNumField.sendKeys(arg2);
        ReusableMethods.wait(1);
        page.mobNumField.clear();
        page.mobNumField.sendKeys(arg3);
        ReusableMethods.wait(1);
        page.userCompField.clear();
        page.userCompField.sendKeys(arg4);
        ReusableMethods.wait(1);
        page.LDAPfield.clear();
        page.LDAPfield.sendKeys(arg5);
        ReusableMethods.wait(1);
    }

    @When("user selects save button in the edit modal window")
    public void userSelectsSaveButtonInTheEditModalWindow() {
        page.saveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("user contact information has been successfully {string}")
    public void userContactInformationHasBeenSuccessfully(String arg0) {
        if (arg0.contains("firstcase")) {
            String exroom = "1111";
            String exIp = "3456";
            String exStas = "498521478";
            String exMob = "553968888";
            String exUser = "PC_DESKTOP_15124DD";
            String exLdap = "Ferid";
            ReusableMethods.flash(page.actualRoom, getDriver());
            assertEquals(exroom, page.actualRoom.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualIp, getDriver());
            assertEquals(exIp, page.actualIp.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualStasNum, getDriver());
            assertEquals(exStas, page.actualStasNum.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualMob, getDriver());
            assertEquals(exMob, page.actualMob.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualPC, getDriver());
            assertEquals(exUser, page.actualPC.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualLDAP, getDriver());
           // assertEquals(exLdap, page.LDAPfield.getText());
            System.out.println("exLdap = " + exLdap);
            System.out.println("page.LDAPfield = " + page.LDAPfield);

        } else if (arg0.contains("secondcase")) {
            String exroom = "2222";
            String exIp = "4542";
            String exStas = "454535351";
            String exMob = "506730717";
            String exUser = "PC_DESKTOP_13123FF";
            String exLdap = "Abbas";
            ReusableMethods.flash(page.actualRoom, getDriver());
            assertEquals(exroom, page.actualRoom.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualIp, getDriver());
            assertEquals(exIp, page.actualIp.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualStasNum, getDriver());
            assertEquals(exStas, page.actualStasNum.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualMob, getDriver());
            assertEquals(exMob, page.actualMob.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualPC, getDriver());
            assertEquals(exUser, page.actualPC.getText());
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.actualLDAP, getDriver());
            //assertEquals(exLdap, page.LDAPfield.getText());
        }
    }

    @And("selects founded user")
    public void selectsFoundedUser() {
        WebElement search = getDriver().findElement(By.xpath("//span[text()=' Axtar ']"));
        search.click();
        page.foundedUser.click();
        ReusableMethods.wait(1);
    }

    @And("user selects edit button in the users information tab")
    public void userSelectsEditButtonInTheUsersInformationTab() {
        page.editBTnAdmin.click();
    }

    @And("user changes {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void userChangesAndAndAndAndAndAndAndAnd(String fathername, String birthdate, String validitydate, String room, String ipnum, String stasnum, String mobilenum, String userpc, String email) {
        ReusableMethods.wait(1);
        page.adminFathersName.clear();
        page.adminFathersName.sendKeys(fathername);
        ReusableMethods.wait(1);
//        if (birthdate.contains("14.04.1988")) {
//            page.birthDate.click();
//            ReusableMethods.wait(1);
//            page.birthdaySelectFirst.click();
//        } else if (birthdate.contains("22.04.1988")) {
//            ReusableMethods.wait(1);
//            page.birthDate.click();
//            ReusableMethods.wait(1);
//            page.birthdaySelectSecond.click();
//            ReusableMethods.wait(1);
//        }
//
//        if (validitydate.contains("07.10.2030")) {
//            ReusableMethods.wait(1);
//            ReusableMethods.waitForClickability(page.validityPeriod,10);
//            ReusableMethods.clickByJavaScript(page.validityPeriod);
//            //page.validityPeriod.click();
//            ReusableMethods.wait(1);
//            //page.validitySelectFirst.click();
//        } else if (validitydate.contains("29.10.2030")) {
//            ReusableMethods.wait(1);
//            page.validityPeriod.click();
//            ReusableMethods.wait(1);
////            page.validitySelectSecond.click();
//        }
        ReusableMethods.wait(1);
        page.adminRoom.clear();
        page.adminRoom.sendKeys(room);
        ReusableMethods.wait(1);
        page.adminIp.clear();
        page.adminIp.sendKeys(ipnum);
        ReusableMethods.wait(1);
        page.adminStas.clear();
        page.adminStas.sendKeys(stasnum);
        ReusableMethods.wait(1);
        page.adminMob.clear();
        page.adminMob.sendKeys(mobilenum);
        ReusableMethods.wait(1);
        page.adminUserPc.clear();
        page.adminUserPc.sendKeys(userpc);
        ReusableMethods.wait(1);
        page.adminEmail.clear();
        page.adminEmail.sendKeys(email);
        ReusableMethods.wait(1);
    }

    @Then("user contact information has been successfully {string} in the users personal information tab")
    public void userContactInformationHasBeenSuccessfullyInTheUsersPersonalInformationTab(String changed) {
        if (changed.contains("firstcase")) {
            String fathername = "Fuad oğlu";
            String birthdate = "14.04.1988";
            String validityDate = "07.10.2030";
            String room = "1111";
            String ip = "4433";
            String stas = "22222223341";
            String mob = "506730717";
            String userpc = "RZAYEV_PC";
            String email = "rzabbasqa@gmail.com";
            ReusableMethods.flash(page.adminActualFathersName, getDriver());
            System.out.println("page.adminFathersName = " + page.adminFathersName);
            assertEquals(fathername, page.adminActualFathersName.getText());
            System.out.println("page.adminActualBirthDate = " + page.adminActualBirthDate);
            ReusableMethods.flash(page.adminActualBirthDate, getDriver());
           // assertEquals(birthdate, page.adminActualBirthDate.getText());
            ReusableMethods.flash(page.adminActualVerifyDate, getDriver());
          //  assertEquals(validityDate, page.adminActualVerifyDate.getText());
            ReusableMethods.flash(page.adminActualRoom, getDriver());
            assertEquals(room, page.adminActualRoom.getText());
            ReusableMethods.flash(page.adminActualIp, getDriver());
            assertEquals(ip, page.adminActualIp.getText());
            ReusableMethods.flash(page.adminActualStas, getDriver());
            assertEquals(stas, page.adminActualStas.getText());
            ReusableMethods.flash(page.adminActualMob, getDriver());
            assertEquals(mob, page.adminActualMob.getText());
            ReusableMethods.flash(page.adminActualEmail, getDriver());
            assertEquals(email, page.adminActualEmail.getText());
        }
        else if (changed.contains("secondcase")) {
            String fathername = "FUAD OĞLU";
            String birthdate = "22.04.1988";
            String validityDate = "29.10.2030 ";
            String room = "2222";
            String ip = "5577";
            String stas = "11111111111";
            String mob = "553968888";
            String userpc = "ABBAS_PC";
            String email = "abbas.rzayev@aist.group";
            ReusableMethods.flash(page.adminActualFathersName, getDriver());
            assertEquals(fathername, page.adminActualFathersName.getText());
            ReusableMethods.flash(page.adminActualBirthDate, getDriver());
            //assertEquals(birthdate, page.adminActualBirthDate.getText());
            ReusableMethods.flash(page.adminActualVerifyDate, getDriver());
           // assertEquals(validityDate, page.adminActualVerifyDate.getText());
            ReusableMethods.flash(page.adminActualRoom, getDriver());
            assertEquals(room, page.adminActualRoom.getText());
            ReusableMethods.flash(page.adminActualIp, getDriver());
            assertEquals(ip, page.adminActualIp.getText());
            ReusableMethods.flash(page.adminActualStas, getDriver());
            assertEquals(stas, page.adminActualStas.getText());
            ReusableMethods.flash(page.adminActualMob, getDriver());
            assertEquals(mob, page.adminActualMob.getText());
            ReusableMethods.flash(page.adminActualEmail, getDriver());
            assertEquals(email, page.adminActualEmail.getText());
        }
    }
}