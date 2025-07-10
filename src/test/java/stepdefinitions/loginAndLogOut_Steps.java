package stepdefinitions;

import Page.loginAndLogOut_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ReusableMethods;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static utilities.Driver.getDriver;

public class loginAndLogOut_Steps {

    loginAndLogOut_Page page = new loginAndLogOut_Page();


    @Given("user enters the {string} system")
    public void userEntersTheSystem(String environment) {
        if(environment.contains("AG-MEIS")){
            getDriver().get("https://dev-meis.aist.group/auth");
            ReusableMethods.wait(1);
        }
    }

    @When("user adds {string} and {string}")
    public void userAddsAnd(String arg0, String arg1) {
        String firstPage= getDriver().getWindowHandle();
        page.emailField.sendKeys(arg0);
        page.passwordField.sendKeys(arg1);
        page.enterToTheSystem.click();
        ReusableMethods.wait(1);
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(firstPage)) {
                getDriver().switchTo().window(handle);
            }
        }
        String secondPage = getDriver().getCurrentUrl();
        System.out.println("secondPage = " + secondPage);
    }

    @Then("entrance to the system is {string}")
    public void entranceToTheSystemIs(String arg0) {
        String expectedUrl = "home";
        ReusableMethods.wait(1);
        String actual = getDriver().getCurrentUrl();
        String secondPage = "";

        try {
            URI uri = new URI(actual);
            String path = uri.getPath();

            String[] parts = path.split("/");
            for (String part : parts) {
                if (part.equals("home")) {
                    secondPage = part;
                    break;
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (arg0.equals("true")) {
            System.out.println("secondPage = " + secondPage);
            System.out.println("expectedUrl = " + expectedUrl);
            assertEquals(expectedUrl, secondPage);
        } else if (arg0.equals("false")) {
            System.out.println("secondPage = " + secondPage);
            System.out.println("expectedUrl = " + expectedUrl);
            assertNotEquals(expectedUrl, secondPage);
        } else {
            System.out.println("username və ya password yalnışdır ");
        }
    }

    @When("user selects exit button")
    public void userSelectsExitButton() {
        ReusableMethods.wait(1);
        page.exitBtn.click();
        ReusableMethods.wait(1);
        page.yesExit.click();
        ReusableMethods.wait(1);
    }

    @Then("user has been successfully logged out from system")
    public void userHasBeenSuccessfullyLoggedOutFromSystem() {
        String expectedUrl = "auth";
        ReusableMethods.wait(1);
        String actualUrl = ReusableMethods.getPathSegment(expectedUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    @When("user selects exit button from personal cabinet")
    public void userSelectsExitButtonFromPersonalCabinet() {
        page.personalCabinetBtn.click();
        page.personalCabinetExitBtn.click();
        page.yesExit.click();
    }
}