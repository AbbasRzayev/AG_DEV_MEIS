package stepdefinitions;

import Page.loginAndLogOut_Page;
import Page.registration_Page;
import Page.structureAndDuties_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class registration_Steps {
    registration_Page page = new registration_Page();
    loginAndLogOut_Page enter = new loginAndLogOut_Page();
    structureAndDuties_Page search = new structureAndDuties_Page();

    @And("selects new user button")
    public void selectsNewUserButton() {
        ReusableMethods.wait(1);
        page.newUserButton.click();
        ReusableMethods.wait(1);
    }

    @And("adds information to the field on the first registration stage")
    public void addsInformationToTheFieldOnTheFirstRegistrationStage(DataTable dataTable) {
        ReusableMethods.scrollEndByJavascript();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String FIN = row.get("FIN");
            String Seriya = row.get("Sənədin seriya və nömrəsi");
            String Elektron = row.get("Elektron poçt");
            String LDAP = row.get("LDAP istifadəçi adı");
            page.finRegField.sendKeys(FIN);
            ReusableMethods.wait(1);
            page.serialNumField.sendKeys(Seriya);
            ReusableMethods.wait(1);
            page.emailField.sendKeys(Elektron);
            ReusableMethods.wait(1);
            page.ldapField.sendKeys(LDAP);
        }
    }

    @And("selects not domein registration")
    public void selectsNotDomeinRegistration() {
        page.domenCheckboxs.click();
        ReusableMethods.wait(1);
    }

    @And("selects next button on the first stage")
    public void selectsNextButtonOnTheFirstStage() {
        page.firstNextButton.click();
        ReusableMethods.wait(1);
    }

    @And("adds picture and information to the field on the second registration stage")
    public void addsPictureAndInformationToTheFieldOnTheSecondRegistrationStage(DataTable dataTable) throws IOException {
        String photoPath = "C:\\Users\\User\\TestFiles\\Test.png";
        page.photoButton.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String name = row.get("Ad");
                String surname = row.get("Soyad");
                String fatherName = row.get("Ata adı");
                String birthData = row.get("Dogum tarixi");
                String lastData = row.get("Etibarlıq müddəti");
                String adress = row.get("Yaşadıqı ünvan");
                page.regNameField.sendKeys(name);
                ReusableMethods.wait(1);
                page.regSurnameField.sendKeys(surname);
                ReusableMethods.wait(1);
                page.regFatherName.sendKeys(fatherName);
                ReusableMethods.wait(1);
                page.regBirthData.sendKeys(birthData);
                ReusableMethods.wait(1);
                page.regLastData.sendKeys(lastData);
                ReusableMethods.wait(1);
                page.regAdress.sendKeys(adress);
                ReusableMethods.wait(1);
            }

        }
    }

    @And("selects next button on the second stage")
    public void selectsNextButtonOnTheSecondStage() {
        page.secondNextButton.click();
        ReusableMethods.wait(1);
    }

    @And("information to the field on the third registration stage")
    public void informationToTheFieldOnTheThirdRegistrationStage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String newpassword = row.get("Yeni şifrə");
            String reppassword = row.get("Sifrənin təkrarı");
            ReusableMethods.wait(1);
            page.regNewPass.sendKeys(newpassword);
            ReusableMethods.wait(1);
            page.regRepPass.sendKeys(reppassword);
        }
    }

    @And("selects next button on the third stage")
    public void selectsNextButtonOnTheThirdStage() {
        page.secondNextButton.click();
        ReusableMethods.wait(1);
    }

    @And("information to the field on the fourth registration stage")
    public void informationToTheFieldOnTheFourthRegistrationStage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String room = row.get("Otaq");
            String mobnum = row.get("Mobil nömrə");
            String ipTelephone = row.get("İP telefon nömrəsi");
            String stasnum = row.get("Stasinonar nömrə");
            page.regRoom.sendKeys(room);
            ReusableMethods.wait(1);
            page.regMob.sendKeys(mobnum);
            ReusableMethods.wait(1);
            page.regIp.sendKeys(ipTelephone);
            ReusableMethods.wait(1);
            page.regStasnum.sendKeys(stasnum);
            ReusableMethods.wait(1);
        }
    }

    @And("selects next button on the fourth stage")
    public void selectsNextButtonOnTheFourthStage() {
        page.fourthNext.click();
        ReusableMethods.wait(1);
    }

    @And("selects duty and structure on the fifth stage")
    public void selectsDutyAndStructureOnTheFifthStage() {
        page.regDuty.click();
        ReusableMethods.wait(1);
        page.regDirector.click();
        ReusableMethods.wait(1);
        page.regStructure.click();
        ReusableMethods.wait(1);
    }

    @And("selects next button on the fifth stage")
    public void selectsNextButtonOnTheFifthStage() {
        page.secondNextButton.click();
        ReusableMethods.wait(1);
    }

    @And("selects instructor on the sixth stage")
    public void selectsInstructorOnTheSixthStage() {
        page.instructorSelect.click();
        ReusableMethods.wait(1);
        page.regSearchInstructor.sendKeys("Abbas Rzayev");
        ReusableMethods.wait(1);
        page.addInsttructor.click();
        ReusableMethods.wait(1);
    }

    @And("selects complete registration button")
    public void selectsCompleteRegistrationButton() {
        page.confirmButton.click();
        ReusableMethods.wait(2);
    }

    @And("gets the verification code from email and puts it to the add code field")
    public void getsTheVerificationCodeFromEmailAndPutsItToTheAddCodeField() {
        String currentWindowHandle = getDriver().getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open();");
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        getDriver().get("https://mail.google.com/");
        ReusableMethods.wait(5);
        page.googleEmail.sendKeys("zamanovabbasqa@gmail.com");
        ReusableMethods.wait(2);
        page.googleNextButton.click();
        ReusableMethods.wait(5);
        page.googlepasswordField.sendKeys("abbasabbas88");
        ReusableMethods.wait(3);
        page.googleNextButton.click();
        ReusableMethods.wait(2);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));
        WebElement emailRowElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[@role='row' and contains(., 'Qeydiyyat üçün təsdiq kodunuz aşağıdakıdır:')]")));

        // Extract the specific text containing the code
        String code = emailRowElement.getText();

//        String text = page.googleofficeMail.getText();
        String[] parts = code.split(":");
        String code1 = parts[1].trim();

        System.out.println("code = " + code1);
        page.googleChechboxs.click();
        ReusableMethods.flash(page.googleDeletebutton, getDriver());
        page.googleDeletebutton.click();
        getDriver().switchTo().window(currentWindowHandle);
        ReusableMethods.wait(3);
        page.addCodeInput.sendKeys(code1);
        ReusableMethods.wait(2);
        //page.confirmCode.click();


    }

    @When("user selects confirm button")
    public void userSelectsConfirmButton() {
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        String currentUrl = getDriver().getCurrentUrl();
//        System.out.println("currentUrl = " + currentUrl);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Təsdiq et']")));
//        confirmButton.click();
        //page.confirmCode.click();
    }

    @Then("new user successfully registered")
    public void newUserSuccessfullyRegistered() {
        ReusableMethods.flash(page.regFinished, getDriver());
        assertTrue(page.regFinished.isDisplayed());
        page.regFinished.click();
        ReusableMethods.wait(2);
    }

    @And("admin logs to the system to give the necessary permissions to the use")
    public void adminLogsToTheSystemToGiveTheNecessaryPermissionsToTheUse() {

        try {
            getDriver().manage().deleteAllCookies();
            String currentWindowHandle = getDriver().getWindowHandle();
            System.out.println("Current window handle: " + currentWindowHandle);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.open();");

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(3));
            Set<String> windowHandles = getDriver().getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(currentWindowHandle)) {
                    // Switch to the new window
                    getDriver().switchTo().window(currentWindowHandle).close();
                    getDriver().switchTo().window(windowHandle);
                    System.out.println("Switched to new window handle: " + windowHandle);
                    break;
                }
            }
            ReusableMethods.wait(3);
            getDriver().get("");
            System.out.println("Navigated to: " + getDriver().getCurrentUrl());
            wait.until(ExpectedConditions.urlToBe("https://dev-meis.aist.group/auth"));


        } catch (org.openqa.selenium.TimeoutException e) {
            // Handle timeout exception and attempt navigation using JavaScript
            System.out.println("Navigation using driver.get() failed, attempting with JavaScript...");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.location.href='';");

            // Confirm the URL change
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://dev-meis.aist.group/auth"));
            System.out.println("Navigated to (JS): " + getDriver().getCurrentUrl());
        }
        ReusableMethods.wait(1);
        enter.emailField.sendKeys(ConfigReader.getProperty("FaridLogin"));
        ReusableMethods.wait(1);
        enter.passwordField.sendKeys(ConfigReader.getProperty("FaridPassword"));
        enter.enterToTheSystem.click();

    }



//        String currentWindowHandle = getDriver().getWindowHandle();
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("window.open();");
//        Set<String> windowHandles = getDriver().getWindowHandles();
//        for (String windowHandle : windowHandles) {
//            if (!windowHandle.equals(currentWindowHandle)) {
//                getDriver().switchTo().window(windowHandle);
//                break;
//            }
//        }
//        getDriver().get("");
//        ReusableMethods.wait(1);






    @And("selects search button in the users tab")
    public void selectsSearchButtonInTheUsersTab() {
        page.searchButton.click();
        ReusableMethods.wait(1);
    }

    @And("selects founded user and switches to the user permissions tab")
    public void selectsFoundedUserAndSwitchesToTheUserPermissionsTab() {
        page.foundedUser.click();
        ReusableMethods.wait(1);
        page.userPermisshonsTab.click();
        ReusableMethods.wait(1);
    }

    @When("admin gives rights to new user to login the system")
    public void adminGivesRightsToNewUserToLoginTheSystem() {
        page.instructorConfirm.click();
        ReusableMethods.wait(1);
        page.currrentStatus.click();
        ReusableMethods.wait(1);
        page.selectAllPremissons.click();
        ReusableMethods.wait(1);
        page.saveChanges.click();
        ReusableMethods.wait(1);
        ReusableMethods.scrollEndByJavascript();
        //  ReusableMethods.visibleWait(page.savePrem,2);
        page.savePrem.click();
        ReusableMethods.scrollTopByJavascript();
        ReusableMethods.wait(1);
    }

    @Then("new user logs to the system successfully")
    public void newUserLogsToTheSystemSuccessfully() {
        String currentWindowHandle = getDriver().getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open();");
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        getDriver().get("https://dev-meis.aist.group/auth");
        ReusableMethods.wait(1);
        enter.emailField.sendKeys(ConfigReader.getProperty("AbbasTestUserName"));
        ReusableMethods.wait(1);
        enter.passwordField.sendKeys(ConfigReader.getProperty("AbbasTestUserPass"));
        enter.enterToTheSystem.click();
        ReusableMethods.wait(3);
        WebElement name = getDriver().findElement(By.xpath("//span[contains(.,'Abbas Zamanov')]"));
        ReusableMethods.flash(name,getDriver());
        String expectedUrl = "https://dev-meis.aist.group/home";
        assertEquals(expectedUrl, getDriver().getCurrentUrl());
        //getDriver().switchTo().window(currentWindowHandle);
        ReusableMethods.wait(1);
    }
    @When("admin selects archive user button")
    public void adminSelectsArchiveUserButton() {
        page.archiveUser.click();
        ReusableMethods.wait(1);
        page.yesArchiveUser.click();
        ReusableMethods.wait(1);
    }
    @When("admin selects search button in the users tab")
    public void adminSelectsSearchButtonInTheUsersTab() {
        page.searchButton.click();
        ReusableMethods.wait(1);
    }
    @Then("user not found and successfully archived")
    public void userSuccessfullyArchived() {
        assertElementNotDisplayed(page.foundedUser);
        ReusableMethods.wait(1);
    }

    public void assertElementNotDisplayed(WebElement element) {
        try {
            assertFalse(element.isDisplayed());
            System.out.println("Element is not displayed as expected.");
        } catch (NoSuchElementException e) {
            System.out.println("Element is not found. Test passed.");
        }
    }

    @And("admin goes to the control panel")
    public void adminGoesToTheControlPanel() {
        search.controlPanel.click();
        ReusableMethods.wait(1);
        search.userTab.click();
    }

    @And("admin adds name {string} and fin {string} to the name and fin fields")
    public void adminAddsNameAndFinToTheNameAndFinFields(String name, String fin) {
        page.agnameField.sendKeys(name);
        ReusableMethods.wait(1);
        search.finField.sendKeys(fin);
        ReusableMethods.wait(1);
    }

    @Given("user goes to the gmail")
    public void userGoesToTheGmail() {
        getDriver().get("https://mail.google.com/");
        ReusableMethods.wait(3);
        page.googleEmail.sendKeys("zamanovabbasqa@gmail.com");
        ReusableMethods.wait(2);
        page.googleNextButton.click();
        ReusableMethods.wait(3);
        page.googlepasswordField.sendKeys("abbasabbas88");
        ReusableMethods.wait(3);
        page.googleNextButton.click();
        ReusableMethods.wait(2);
    }

    @Then("deletes confirmation letter")
    public void deletesConfirmationLetter() {
        page.googleChechboxs.click();
        ReusableMethods.flash(page.googleDeletebutton, getDriver());
        ReusableMethods.wait(1);
        page.googleDeletebutton.click();
        ReusableMethods.wait(3);
        assertFalse(page.googleDeletebutton.isDisplayed());
    }


}