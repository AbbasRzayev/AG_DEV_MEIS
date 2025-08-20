package stepdefinitions;

import Page.changePassword_Page;
import Page.loginAndLogOut_Page;
import Page.registration_Page;
import Page.structureAndDuties_Page;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class registration_Steps {
    registration_Page page = new registration_Page();
    loginAndLogOut_Page enter = new loginAndLogOut_Page();
    structureAndDuties_Page search = new structureAndDuties_Page();

    static public String fakeEmail;
    static public String fakePin;
    static public String serialNumber;

    @And("selects new user button")
    public void selectsNewUserButton() {
        ReusableMethods.wait(2);
        page.newUserButton.click();
        ReusableMethods.wait(1);
    }

    @And("adds information to the field on the first registration stage")
    public void addsInformationToTheFieldOnTheFirstRegistrationStage(DataTable dataTable) {
        ReusableMethods.scrollEndByJavascript();
        Faker faker = new Faker(new Locale("az"));
        fakeEmail = faker.internet().emailAddress();
        System.out.println("fakeEmail = " + fakeEmail);
        fakePin = faker.number().digits(7);
        System.out.println("fakePin = " + fakePin);
        serialNumber = "AZ" + faker.number().digits(7);
        System.out.println("serialNumber = " + serialNumber);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
//            String fin = row.get("FIN");
//            String seria = row.get("Sənədin seriya və nömrəsi");
//            String email = row.get("Elektron poçt");
            String ldap = row.get("LDAP istifadəçi adı");
            page.finRegField.sendKeys(fakePin);
            ReusableMethods.wait(1);
            page.serialNumField.sendKeys(serialNumber);
            ReusableMethods.wait(1);
            page.emailField.sendKeys(fakeEmail);
            ReusableMethods.wait(1);
//            page.ldapField.sendKeys(ldap);
        }
    }

    @And("selects not domain registration")
    public void selectsNotDomainRegistration() {
        page.domenCheckboxs.click();
        ReusableMethods.wait(1);
    }

    @And("selects next button")
    public void selectsNextButton() {
        ReusableMethods.wait(2);
        page.firstNextButton.click();
        ReusableMethods.wait(7);
    }

    @And("adds picture and information to the field on the second registration stage")
    public void addsPictureAndInformationToTheFieldOnTheSecondRegistrationStage(DataTable dataTable) throws IOException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String name = row.get("Ad");
                String surname = row.get("Soyad");
                String fatherName = row.get("Ata adı");
                String birthData = row.get("Dogum tarixi");
                String lastData = row.get("Etibarlıq müddəti");
                String address = row.get("Yaşadıqı ünvan");
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
                page.regAddress.sendKeys(address);
                ReusableMethods.wait(1);
            }

        }
    }

    @And("information to the field on the third registration stage")
    public void informationToTheFieldOnTheThirdRegistrationStage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String newPassword = row.get("Yeni şifrə");
            String repPassword = row.get("Sifrənin təkrarı");
            ReusableMethods.wait(1);
            page.regNewPass.sendKeys(newPassword);
            ReusableMethods.wait(1);
            page.regRepPass.sendKeys(repPassword);
        }
    }

    @And("information to the field on the fourth registration stage")
    public void informationToTheFieldOnTheFourthRegistrationStage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String room = row.get("Otaq");
            String mobNum = row.get("Mobil nömrə");
            String ipTelephone = row.get("İP telefon nömrəsi");
            String stasionerNum = row.get("Stasinonar nömrə");
            page.regRoom.sendKeys(room);
            ReusableMethods.wait(1);
            page.regMob.sendKeys(mobNum);
            ReusableMethods.wait(1);
            page.regIp.sendKeys(ipTelephone);
            ReusableMethods.wait(1);
            page.regStasNum.sendKeys(stasionerNum);
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
        page.regDuty.sendKeys("QA_AT");
        ReusableMethods.wait(1);
        page.regQA.click();
        ReusableMethods.wait(1);
        page.regStructure.click();
        ReusableMethods.wait(1);
    }

    @And("selects instructor on the sixth stage")
    public void selectsInstructorOnTheSixthStage() {
//        page.instructorSelect.click();
//        ReusableMethods.wait(1);
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

//        getDriver().get("https://mail.google.com/");
        getDriver().get("https://mail.az/");
        ReusableMethods.wait(1);
//        page.googleEmail.sendKeys("zamanovabbasqa@gmail.com");
        System.out.println(getDriver().getCurrentUrl());
//        page.mailAz.sendKeys("zamanovabbasqa@mail.az");


        ReusableMethods.wait(3);
//        page.googleNextButton.click();
//        ReusableMethods.wait(5);
//        page.googlepasswordField.sendKeys("abbasabbas88");
        page.mailAzPasswordField.sendKeys("abbasabbas88");
        ReusableMethods.wait(3);
//        page.googleNextButton.click();
        page.enterToTheMail.click();
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
        ReusableMethods.flash(name, getDriver());
        String expectedUrl = "https://dev-meis.aist.group/home";
        assertEquals(expectedUrl, getDriver().getCurrentUrl());
        //getDriver().switchTo().window(currentWindowHandle);
        ReusableMethods.wait(1);
    }

    @When("admin selects search button in the users tab")
    public void adminSelectsSearchButtonInTheUsersTab() {
        page.searchButton.click();
        ReusableMethods.wait(1);
    }

    @Then("user not found and successfully archived")
    public void userSuccessfullyArchived() {
        ReusableMethods.wait(1);
        try {
            if (page.foundedUser.isDisplayed()) {
                throw new AssertionError("❌ Xəta: Silinmiş user hələ də sistemdə görünür!");
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            // foundedUser tapılmadı, deməli yoxa çıxıb, indi noResult-u yoxla
            if (page.noResult.isDisplayed()) {
                ReusableMethods.flash(page.noResult, getDriver());
                System.out.println("✅ Silinmiş istifadəçi sistemdən uğurla silinib.");
            } else {
                throw new AssertionError("⚠️ Heç bir nəticə çıxmadı amma noResult da görünmür – Gözlənilməz vəziyyət.");
            }
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


    @Then("new user {string} successfully registered")
    public void newUserSuccessfullyRegistered(String user) {
        if (user.contains("Zamanov")) {
            String personZamanov = "Abbas Zamanov";
            ReusableMethods.flash(page.zamanovCheckTab, getDriver());
            Assert.assertEquals(personZamanov, page.zamanovCheckTab.getText());
        }
    }

    @And("close register modal window")
    public void closeRegisterModalWindow() {
        page.closeModalWindow.click();
        ReusableMethods.wait(1);
    }

    @Then("new registered users pin and serial number are displayed correctly")
    public void newRegisteredUsersPinAndSerialNumberAreDisplayedCorrectly() {
        ReusableMethods.flash(page.checkPersonalPin, getDriver());
        ReusableMethods.flash(page.checkPersonalSerialNumber, getDriver());
        Assert.assertEquals(page.checkPersonalPin.getText().trim(), fakePin);
        Assert.assertEquals(page.checkPersonalSerialNumber.getText().trim(), serialNumber);
    }

    @Then("new registered users name and surname and father name and birth data and gender and validity period are displayed correctly")
    public void newRegisteredUsersNameAndSurnameAndFatherNameAndBirtDataAndGenderAndValidityPeriodAreDisplayedCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String name = row.get("Ad");
                String surname = row.get("Soyad");
                String fatherName = row.get("Ata adı");
                String birtData = row.get("Dogum tarixi");
                String validData = row.get("Etibarlıq müddəti");
                String gender = row.get("Cins");

                ReusableMethods.flash(page.checkPersonalName, getDriver());
                Assert.assertEquals(page.checkPersonalName.getText().trim(), name);

                ReusableMethods.flash(page.checkPersonalSurname, getDriver());
                Assert.assertEquals(page.checkPersonalSurname.getText().trim(), surname);

                ReusableMethods.flash(page.checkPersonalFatherName, getDriver());
                Assert.assertEquals(page.checkPersonalFatherName.getText().trim(), fatherName);

                ReusableMethods.flash(page.checkPersonalBirthData, getDriver());
                Assert.assertEquals(page.checkPersonalBirthData.getText().trim(), birtData);

                ReusableMethods.flash(page.checkPersonalGender, getDriver());
                Assert.assertEquals(page.checkPersonalGender.getText().trim(), gender);

                ReusableMethods.flash(page.checkPersonalValidData, getDriver());
                Assert.assertEquals(page.checkPersonalValidData.getText().trim(), validData);

            }
        }
    }

    @Then("new registered users room and ip phone and stationary number and mobile number and email is displayed correctly")
    public void newRegisteredUsersRoomAndIpPhoneAndStationaryNumberAndMobileNumberAndEmailIsDisplayedCorrectly(DataTable dataTable) {
        ReusableMethods.pageDown();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String room = row.get("Otaq");
                String ip = row.get("IP telefon nömrəsi");
                String statNum = row.get("Stasinonar nömrə");
                String mobileNum = row.get("Mobil nömrə");

                ReusableMethods.flash(page.checkPersonalRoom, getDriver());
                Assert.assertEquals(page.checkPersonalRoom.getText().trim(), room);

                ReusableMethods.flash(page.checkPersonalIP, getDriver());
                Assert.assertEquals(page.checkPersonalIP.getText().trim(), ip);

                ReusableMethods.flash(page.checkPersonalStatNum, getDriver());
                Assert.assertEquals(page.checkPersonalStatNum.getText().trim(), statNum);

                ReusableMethods.flash(page.checkPersonalMobileNumber, getDriver());
                Assert.assertEquals(page.checkPersonalMobileNumber.getText().trim(), mobileNum);

                ReusableMethods.flash(page.checkPersonalEMAIL, getDriver());
                Assert.assertEquals(page.checkPersonalEMAIL.getText().trim(), fakeEmail);

            }
        }
    }

    @When("admin select edit button in the user account control page")
    public void adminSelectEditButtonInTheUserAccountControlPage() {
        page.personalInfoEdit.click();
        ReusableMethods.wait(1);
    }

    @When("admin edited users personal and contact info in the user account control page")
    public void adminEditedUsersPersonalAndContactInfoInTheUserAccountControlPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String name = row.get("Ad");
                String surname = row.get("Soyad");
                String fatherName = row.get("Ata adı");
                String birtData = row.get("Dogum tarixi");
                String validData = row.get("Etibarlıq müddəti");
                String gender = row.get("Cins");
                String room = row.get("Otaq");
                String ip = row.get("IP");
                String statNum = row.get("Stasionar nömrə");
                String mobileNum = row.get("Mobil nömrə");
                String email = row.get("Email");
                String pin = row.get("FIN");
                String serialNum = row.get("Seriya");
                String userCom = row.get("Komputer");

                page.nameEdit.clear();
                ReusableMethods.wait(1);
                page.nameEdit.sendKeys(name);

                page.surNameEdit.clear();
                ReusableMethods.wait(1);
                page.surNameEdit.sendKeys(surname);

                page.fatherNameEdit.clear();
                ReusableMethods.wait(1);
                page.fatherNameEdit.sendKeys(fatherName);

//                page.birthDataEdit.clear();
//                ReusableMethods.wait(1);
//                page.birthDataEdit.sendKeys(birtData);

                page.piNEdit.clear();
                ReusableMethods.wait(1);
                page.piNEdit.sendKeys(pin);

                page.serialNumberEdit.clear();
                ReusableMethods.wait(1);
                page.serialNumberEdit.sendKeys(serialNum);

//                page.validDataEdit.clear();
                ReusableMethods.clearTextBox(page.validDataEdit);
//                ReusableMethods.wait(1);
                page.validDataEdit.sendKeys(validData);

                page.roomEdit.clear();
                ReusableMethods.wait(1);
                page.roomEdit.sendKeys(room);

//                page.surNameEdit.clear();
//                ReusableMethods.wait(1);
//                page.surNameEdit.sendKeys(gender);

                page.ipEdit.clear();
                ReusableMethods.wait(1);
                page.ipEdit.sendKeys(ip);

                page.statEdit.clear();
                ReusableMethods.wait(1);
                page.statEdit.sendKeys(statNum);

                page.mobileEdit.clear();
                ReusableMethods.wait(1);
                page.mobileEdit.sendKeys(mobileNum);

                page.userCompEdit.clear();
                ReusableMethods.wait(1);
                page.userCompEdit.sendKeys(userCom);

                page.emailEdit.clear();
                ReusableMethods.wait(1);
                page.emailEdit.sendKeys(email);

                page.saveAfterEdit.click();
                ReusableMethods.wait(1);

            }
        }
    }

    @Then("users personal and contact info are successfully edited")
    public void usersPersonalAndContactInfoAreSuccessfullyEdited(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String name = row.get("Ad");
                String surname = row.get("Soyad");
                String fatherName = row.get("Ata adı");
                String birtData = row.get("Dogum tarixi");
                String validData = row.get("Etibarlıq müddəti");
                String gender = row.get("Cins");
                String room = row.get("Otaq");
                String ip = row.get("IP");
                String statNum = row.get("Stasionar nömrə");
                String mobileNum = row.get("Mobil nömrə");
                String email = row.get("Email");
                String pin = row.get("FIN");
                String serialNum = row.get("Seriya");
                String userCom = row.get("Komputer");

                ReusableMethods.pageUp();
                ReusableMethods.flash(page.checkPersonalPin, getDriver());
                Assert.assertEquals(page.checkPersonalPin.getText().trim(), pin);

                ReusableMethods.flash(page.checkPersonalSerialNumber, getDriver());
                Assert.assertEquals(page.checkPersonalSerialNumber.getText().trim(), serialNum);

                ReusableMethods.flash(page.checkPersonalName, getDriver());
                Assert.assertEquals(page.checkPersonalName.getText().trim(), name);

                ReusableMethods.flash(page.checkPersonalSurname, getDriver());
                Assert.assertEquals(page.checkPersonalSurname.getText().trim(), surname);

                ReusableMethods.flash(page.checkPersonalFatherName, getDriver());
                Assert.assertEquals(page.checkPersonalFatherName.getText().trim(), fatherName);

                ReusableMethods.flash(page.checkPersonalBirthData, getDriver());
                Assert.assertEquals(page.checkPersonalBirthData.getText().trim(), birtData);

                ReusableMethods.flash(page.checkPersonalGender, getDriver());
                Assert.assertEquals(page.checkPersonalGender.getText().trim(), gender);

                ReusableMethods.flash(page.checkPersonalValidData, getDriver());
                Assert.assertEquals(page.checkPersonalValidData.getText().trim(), validData);

                ReusableMethods.pageDown();

                ReusableMethods.flash(page.checkPersonalRoom, getDriver());
                Assert.assertEquals(page.checkPersonalRoom.getText().trim(), room);

                ReusableMethods.flash(page.checkPersonalIP, getDriver());
                Assert.assertEquals(page.checkPersonalIP.getText().trim(), ip);

                ReusableMethods.flash(page.checkPersonalStatNum, getDriver());
                Assert.assertEquals(page.checkPersonalStatNum.getText().trim(), statNum);

                ReusableMethods.flash(page.checkPersonalMobileNumber, getDriver());
                Assert.assertEquals(page.checkPersonalMobileNumber.getText().trim(), mobileNum);

                ReusableMethods.flash(page.checkPersonalEMAIL, getDriver());
                Assert.assertEquals(page.checkPersonalEMAIL.getText().trim(), email);

            }
        }
    }

    @And("goes to the user permissions tab")
    public void goesToTheUserPermissionsTab() {
        ReusableMethods.pageUp();
        ReusableMethods.wait(1);
        page.userPermissionsTab.click();
        ReusableMethods.wait(1);
    }

    @And("admin gives rights and permissions to the new user")
    public void adminGivesRightsAndPermissionsToTheNewUser() {
        page.adminPerToggle.click();
        ReusableMethods.wait(1);
        page.statusToggle.click();
        ReusableMethods.wait(1);
        page.allPermission.click();
        ReusableMethods.wait(1);
        ReusableMethods.pageDown();
        page.saveRights.click();
        ReusableMethods.wait(3);
        page.savePermission.click();
        ReusableMethods.wait(2);
    }

    @Then("admin control is displayed as a given in the users table")
    public void adminControlIsDisplayedAsAGivenInTheUsersTable() {
        ReusableMethods.flash(page.adminControlIcon, getDriver());
        String iconText = page.adminControlIcon.getText().trim();
        if (iconText.equals("close")) {
            throw new AssertionError("❌ Xəta: Status icon 'close' göstərir – icazə verildiyi halda!");
        } else if (iconText.equals("check")) {
            System.out.println("✅ Status icon 'check' göstərir – hər şey qaydasındadır.");
        } else {
            throw new AssertionError("⚠️ Gözlənilməz status icon tapıldı: " + iconText);
        }
    }

    @Then("status is displayed as a given in the users table")
    public void statusIsDisplayedAsAGivenInTheUsersTable() {
        ReusableMethods.flash(page.statusIcon, getDriver());
        String iconText = page.statusIcon.getText().trim();
        if (iconText.equals("close")) {
            throw new AssertionError("❌ Xəta: Status icon 'close' göstərir – selahiyyət verildiyi halda!");
        } else if (iconText.equals("check")) {
            System.out.println("✅ Status icon 'check' göstərir – hər şey qaydasındadır.");
        } else {
            throw new AssertionError("⚠️ Gözlənilməz status icon tapıldı: " + iconText);
        }
        ReusableMethods.wait(1);
    }

    @And("new user logs into the {string} system")
    public void newUserLogsIntoTheSystem(String environment, DataTable table) {
        if (environment.contains("AG-MEIS")) {
            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            {
                for (Map<String, String> row : data) {
                    String email = row.get("Email");
                    String password = row.get("Şifrə");
//                    getDriver().get(ConfigReader.getProperty("AG-MEIS"));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    ReusableMethods.wait(1);
                    enter.emailField.sendKeys(email);
                    ReusableMethods.wait(1);
                    enter.passwordField.sendKeys(password);
                    enter.enterToTheSystem.click();
                    ReusableMethods.wait(1);
                }
            }
        }
    }

    @Then("new user has been successfully log into the system")
    public void newUserHasBeenSuccessfullyLogIntoTheSystem() {
        String expectedUrl = "home";
        ReusableMethods.wait(1);
        String actualUrl = ReusableMethods.getPathSegment(expectedUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    @When("user switches to the personal info tab in the personal cabinet")
    public void userSwitchesToThePersonalInfoTabInThePersonalCabinet() {
        page.personalInfoInThePersonalCabinet.click();
        ReusableMethods.wait(3);
    }

    @Then("the users personal info is displayed correctly")
    public void theUsersPersonalInfoIsDisplayedCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String name = row.get("Ad");
                String surname = row.get("Soyad");
                String fatherName = row.get("Ata adı");
                String birtData = row.get("Dogum tarixi");
                String validData = row.get("Etibarlıq müddəti");
                String gender = row.get("Cins");
                String pin = row.get("FIN");
                String serial = row.get("Seriya");

                ReusableMethods.flash(page.checkPersonalNameInfo, getDriver());
                Assert.assertEquals(page.checkPersonalNameInfo.getText().trim(), name);

                ReusableMethods.flash(page.checkPersonalSurnameInfo, getDriver());
                Assert.assertEquals(page.checkPersonalSurnameInfo.getText().trim(), surname);

                ReusableMethods.flash(page.checkPersonalFatherNameInfo, getDriver());
                Assert.assertEquals(page.checkPersonalFatherNameInfo.getText().trim(), fatherName);

                ReusableMethods.flash(page.checkPersonalGenderInfo, getDriver());
                Assert.assertEquals(page.checkPersonalGenderInfo.getText().trim(), gender);

                ReusableMethods.flash(page.checkPersonalPinInfo, getDriver());
                Assert.assertEquals(page.checkPersonalPinInfo.getText().trim(), pin);

                ReusableMethods.flash(page.checkPersonalSerialNumInfo, getDriver());
                Assert.assertEquals(page.checkPersonalSerialNumInfo.getText().trim(), serial);

                ReusableMethods.flash(page.checkPersonalValidInfo, getDriver());
                Assert.assertEquals(page.checkPersonalValidInfo.getText().trim(), validData);

                ReusableMethods.flash(page.checkPersonalBirthDataInfo, getDriver());
                Assert.assertEquals(page.checkPersonalBirthDataInfo.getText().trim(), birtData);
            }
        }
    }


    @When("user switches to the connection info tab in the personal cabinet")
    public void userSwitchesToTheConnectionInfoTabInThePersonalCabinet() {
        page.connectInfoInThePersonalCabinet.click();
        ReusableMethods.wait(1);
    }

    @Then("the users connection info is displayed correctly")
    public void theUsersConnectionInfoIsDisplayedCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        {
            for (Map<String, String> row : data) {
                String room = row.get("Otaq");
                String ip = row.get("IP");
                String statNum = row.get("Stasionar nömrə");
                String mobileNum = row.get("Mobil nömrə");
                String email = row.get("Email");
                String userCom = row.get("Komputer");

                ReusableMethods.flash(page.checkPersonalRoom, getDriver());
                Assert.assertEquals(page.checkPersonalRoom.getText().trim(), room);

                ReusableMethods.flash(page.checkPersonalIp, getDriver());
                Assert.assertEquals(page.checkPersonalIp.getText().trim(), ip);

                ReusableMethods.flash(page.checkPersonalStatNum, getDriver());
                Assert.assertEquals(page.checkPersonalStatNum.getText().trim(), statNum);

                ReusableMethods.flash(page.checkPersonalMobileNumber, getDriver());
                Assert.assertEquals(page.checkPersonalMobileNumber.getText().trim(), mobileNum);

                ReusableMethods.flash(page.checkPersonalEmail, getDriver());
                Assert.assertEquals(page.checkPersonalEmail.getText().trim(), email);

                ReusableMethods.flash(page.checkPersonalComputer, getDriver());
                Assert.assertEquals(page.checkPersonalComputer.getText().trim(), userCom);

            }
        }
    }

    @And("admin archived the new user")
    public void adminArchivedTheNewUser() {
        page.archiveUser.click();
        ReusableMethods.wait(1);
        page.yesArchiveUser.click();
        ReusableMethods.wait(1);
    }

    @Then("the archived user cannot access to the system")
    public void theArchivedUserCannotAccessToTheSystem() {
        String expectedUrl = "auth";
        ReusableMethods.wait(1);
        String actualUrl = ReusableMethods.getPathSegment(expectedUrl);
        assertEquals(expectedUrl, actualUrl);
    }
}