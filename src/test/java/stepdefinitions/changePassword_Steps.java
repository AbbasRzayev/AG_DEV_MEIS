package stepdefinitions;

import Page.changePassword_Page;
import Page.loginAndLogOut_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class changePassword_Steps {

    loginAndLogOut_Page page = new loginAndLogOut_Page();
    changePassword_Page changePage = new changePassword_Page();
    String path = "src/test/java/data/userData.xlsx";
    String sheetName = "pozitive";
    ExcelUtils excelUtils=new ExcelUtils(path,sheetName);

    @And("the user with login {string} and password {string} logs into the {string} system")
    public void theUserWithLoginAndPasswordLogsIntoTheSystem(String arg0, String arg1, String environment) {
        if(environment.contains("AG-MEIS")) {
            getDriver().get("https://dev-meis.aist.group/auth");
            ReusableMethods.wait(1);
            page.emailField.sendKeys(arg0);
            page.passwordField.sendKeys(arg1);
            page.enterToTheSystem.click();
        }
    }

    @And("switches to the Personal cabinet")
    public void switchesToThePersonalCabinet() {
        ReusableMethods.wait(2);
        changePage.personalCabinet.click();
    }

    @And("goes to the change password tab")
    public void goesToTheChangePasswordTab() {
        ReusableMethods.wait(1);
        changePage.changePasswordTab.click();
        ReusableMethods.wait(1);
    }

    @And("add the {string} password")
    public void addThePassword(String arg0) {
        ReusableMethods.wait(1);
        changePage.openOld.click();
        changePage.oldPassword.sendKeys(arg0);
    }

    @And("add {string} new password")
    public void addNewPassword(String arg0) {
        ReusableMethods.wait(1);
        changePage.openNew.click();
        changePage.newPassword.sendKeys(arg0);

    }

    @And("add {string} the new password")
    public void addTheNewPassword(String arg0) {
        ReusableMethods.wait(1);
        changePage.openReapet.click();
        changePage.repeatNewPassword.sendKeys(arg0);
    }

    @And("select submit button")
    public void selectSubmitButton() {
        ReusableMethods.wait(1);
        changePage.subPassword.click();
    }

    @And("goes to the authorization page")
    public void goesToTheAuthorizationPage() {
        ReusableMethods.wait(1);
        page.exitBtn.click();
        ReusableMethods.wait(1);
        page.yesExit.click();
    }

    @And("user with {string} and {string} logs into the MEIS system")
    public void userWithAndLogsIntoTheMeisSystem(String arg0, String arg1) {
        ReusableMethods.wait(1);
        page.emailField.sendKeys(arg0);
        ReusableMethods.wait(1);
        page.passwordField.sendKeys(arg1);
        ReusableMethods.wait(1);
        page.enterToTheSystem.click();
    }

    @Then("user has successfully entered to the MEIS system")
    public void userHasSuccessfullyEnteredToTheMeisSystem() {
        ReusableMethods.wait(3);
        String expectedUrl = "https://dev-meis.aist.group/home";
        String actualUrl = getDriver().getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        ReusableMethods.wait(1);
        assertEquals(expectedUrl, actualUrl);
    }

    @Given("user with login {string} and password {string} logs into the {string} system")
    public void userWithLoginAndPasswordLogsIntoTheSystem(String user, String arg1, String environment) {
        if(environment.contains("AG-MEIS") && user.equals("imranovfarid@gmail.com")){
            getDriver().get(ConfigReader.getProperty("AG-MEIS"));
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ReusableMethods.wait(1);
            page.emailField.sendKeys(ConfigReader.getProperty("FaridLogin"));
            ReusableMethods.wait(1);
            page.passwordField.sendKeys(ConfigReader.getProperty("FaridPassword"));
            page.enterToTheSystem.click();
        }
        else if(environment.contains("AG-MEIS") && user.equals("abbas.rzayev@aist.group")){
            getDriver().get(ConfigReader.getProperty("AG-MEIS"));
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ReusableMethods.wait(1);
            page.emailField.sendKeys(ConfigReader.getProperty("AbbasLogin"));
            ReusableMethods.wait(1);
            page.passwordField.sendKeys(ConfigReader.getProperty("AbbasPassword"));
            page.enterToTheSystem.click();
        }
    }

    @And("user add the old password {string} to the current password field")
    public void userAddTheOldPasswordToTheCurrentPasswordField(String arg0) {
        ReusableMethods.wait(1);
        changePage.oldPassword.sendKeys(ConfigReader.getProperty("FaridPassword"));
        ReusableMethods.wait(1);
    }

    @When("user added not valid data to the new password field and to the repeat new password field")
    public void userAddedNotValidDataToTheNewPasswordFieldAndToTheRepeatNewPasswordField(DataTable dataTable) {
        List<String> notValidData = dataTable.asList();
        System.out.println("notValidData = " + notValidData);
        System.out.println(ExpectedConditions.elementToBeClickable(changePage.disabledLoc));
        for (int i=0; i<notValidData.size();i++)
        {
            changePage.newPassword.sendKeys(notValidData.get(i));
            changePage.openNew.click();
            ReusableMethods.wait(1);
            changePage.repeatNewPassword.sendKeys(notValidData.get(i));
            changePage.openReapet.click();
            ReusableMethods.wait(1);
            changePage.newPassword.clear();
            changePage.repeatNewPassword.clear();
        }
    }

    @Then("the submit button is not active")
    public void theSubmitButtonIsNotActive() {
      assertFalse(changePage.disabledLoc.isSelected());
      System.out.println(ExpectedConditions.elementToBeClickable(changePage.disabledLoc));
//        String disabledActual = changePAge.disabledLoc.getAttribute("disabled");
//        String disabledExpected = "true";
//        System.out.println("disabledactual = " + disabledActual);
//        assertNotEquals(disabledExpected,disabledActual);
//        assertEquals(disabledExpected,disabledActual);
//        assertFalse(ReusableMethods.);

    }

    @When("user added valid datas to the new password field and to the repeat new password field")
    public void userAddedValidDatasToTheNewPasswordFieldAndToTheRepeatNewPasswordField() {
        int size = excelUtils.rowCount();
        System.out.println("size = " + size);
        for (int i = 1; i <= size; i++){
            String newpass = excelUtils.getCellData(i,0);
            changePage.newPassword.sendKeys(newpass);
            ReusableMethods.wait(1);
            String repPass = excelUtils.getCellData(i,1);
            changePage.repeatNewPassword.sendKeys(repPass);
            ReusableMethods.wait(1);
            changePage.newPassword.clear();
            changePage.repeatNewPassword.clear();

        }
    }

    @Then("the submit button becomes active")
    public void theSubmitButtonBecomesActive() {
        assertTrue(changePage.subPassword.isEnabled());
    }


}