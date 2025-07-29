package stepdefinitions;

import Page.headerAndFooter_Page;
import Page.loginAndLogOut_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.shaded.messages.types.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class headerAndFooter_Steps {
    loginAndLogOut_Page enter = new loginAndLogOut_Page();
    headerAndFooter_Page page = new headerAndFooter_Page();

    @Given("user with login {string} and with password {string} logs into the {string} system")
    public void  userWithLoginAndWithPasswordLogsIntoTheSystem(String arg0, String arg1, String arg2) {
        getDriver().get(ConfigReader.getProperty("Meis"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ReusableMethods.wait(1);
        enter.emailField.sendKeys(arg0);
        ReusableMethods.wait(1);
        enter.passwordField.sendKeys(arg1);
        enter.enterToTheSystem.click();
    }

    @When("user scrolls to the end of page")
    public void userScrollsToTheEndOfPage() {
        ReusableMethods.scrollEndByJavascript();
        ReusableMethods.wait(1);
    }

    @Then("footers copyright text and icons are displayed and redirected")
    public void footersCopyrightTextAndIconsAreDisplayedAndRedirected() {
//        ReusableMethods.flash(page.footerIconFirst, getDriver());
//        assertTrue(page.footerIconFirst.isDisplayed());
//        ReusableMethods.wait(1);
//        page.footerIconFirst.click();
//        ReusableMethods.wait(1);
//        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
//        ReusableMethods.wait(1);
//        Set<String> windowHandles = getDriver().getWindowHandles();
//        for (String handle : windowHandles) {
//            if (!handle.equals(originalWindowHandle)) {
//                getDriver().switchTo().window(handle); // Switch to the new window
//                ReusableMethods.flash(page.footerIconFirstCheck, getDriver());
//                getDriver().close();
//                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
//                break; // Exit the loop after switching back to the original window
//            }
//        }

      //  getDriver().close();
    }

    @Then("headers left sidebar are clickable and visible")
    public void headersLeftSidebarAreClickableAndVisible() {
        ReusableMethods.wait(2);
        page.leftSideBarBtn.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.leftSideBarBtn2, getDriver());
        ReusableMethods.wait(1);
        page.closeLeftSideBar.click();
    }

    @Then("{string} is displayed in the header section")
    public void isDisplayedInTheHeaderSection(String text) {
//        assertTrue(page.headersText.isDisplayed());
        Assert.assertTrue(page.headersText.getText().contains(text));
        ReusableMethods.flash(page.headersText, getDriver());
        ReusableMethods.wait(1);
    }

    @Then("contacts are clickable and visible in the header section")
    public void contactsAreClickableAndVisibleInTheHeaderSection() {
        assertTrue(page.headerContacts.isDisplayed());
        ReusableMethods.flash(page.headerContacts, getDriver());
        page.headerContacts.click();
        ReusableMethods.wait(1);
    }

    @Then("notification is clickable and visible in the header section")
    public void notificationIsClickableAndVisibleInTheHeaderSection() {
        assertTrue(page.headerNotifaction.isDisplayed());
        ReusableMethods.flash(page.headerNotifaction, getDriver());
        page.headerNotifaction.click();
        ReusableMethods.wait(1);
//        page.headerNotifaction.click();
        page.closeNote.click();
    }

    @Then("personal cabinet is clickable and visible in the header section")
    public void personalCabinetIsClickableAndVisibleInTheHeaderSection() {
        page.personalCabinetHeader.click();
        ReusableMethods.wait(1);
        page.personalCabinetLink.click();
        ReusableMethods.wait(1);
    }


    @Then("{string} name and surname of user is displayed correctly in the header section")
    public void nameAndSurnameOfUserIsDisplayedCorrectlyInTheHeaderSection(String nameAndSurname) {
//      assertTrue(page.headerFullname.isDisplayed());
        assertTrue(page.headerFullname.getText().contains(nameAndSurname));
        ReusableMethods.flash(page.headerFullname, getDriver());
        ReusableMethods.wait(1);
    }

    @Then("copyright is displayed in the footer section")
    public void copyrightIsDisplayedInTheFooterSection() {
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.footercopyright, getDriver());
        System.out.println("getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());
        assertTrue(page.footercopyright.isDisplayed());
    }

    @Then("logo is displayed and redirected in the footer section")
    public void logoIsDisplayedAndRedirectedInTheFooterSection() {
        ReusableMethods.flash(page.footerIconSecond,getDriver());
        page.footerIconSecond.click();
        String originalWindowHandle1 = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);
        Set<String> windowHandles1 = getDriver().getWindowHandles();
        for (String handle : windowHandles1) {
            if (!handle.equals(originalWindowHandle1)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.wait(1);
                ReusableMethods.flash(page.footerIconSecondCheck,getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle1); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.wait(1);
    }
}