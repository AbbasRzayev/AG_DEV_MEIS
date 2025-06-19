package stepdefinitions;

import Page.helpDesk_Page;
import Page.loginAndLogOut_Page;
import Page.registration_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class helpDesk_Steps {
    registration_Page page2 = new registration_Page();
    helpDesk_Page page = new helpDesk_Page();
    loginAndLogOut_Page page1 = new loginAndLogOut_Page();
    String value;

    @And("goes to the help desk tab from main page")
    public void goesToTheHelpDeskTabFromMainPage() {
        page.helpDeskBtnFromMainPage.click();
        ReusableMethods.wait(1);
    }

    @And("selects software selection from the direction dropdown list")
    public void selectsSoftwareSelectionFromTheDirectionDropdownList() {
        page.directionList.click();
        ReusableMethods.wait(1);
        page.differentProblemsSelect.click();
        ReusableMethods.wait(1);
    }

    @And("selects change password from the software dropdown list")
    public void selectsChangePasswordFromTheSoftwareDropdownList() {
        page.sowftwareSelectasd.click();
        ReusableMethods.wait(1);
        page.changePass.click();
    }

    @And("selects appeal from the notification type dropdown list")
    public void selectsAppealFromTheNotificationTypeDropdownList() {
        page.noteTypeList.click();
        ReusableMethods.wait(1);
        page.noteTypeSelect.click();
        ReusableMethods.wait(1);
    }

    @And("selects high from the notification priority dropdown list")
    public void selectsHighFromTheNotificationPriorityDropdownList() {
        page.notePriority.click();
        ReusableMethods.wait(1);
        page.notePriorityHigh.click();
        ReusableMethods.wait(1);
    }

    @And("adds text to the description field")
    public void addsTextToTheDescriptionField() {
        page.addText.sendKeys("Xahiş olunur ki müraciətimə təcili baxılsın!");
        ReusableMethods.wait(1);
    }

    @And("adds file in the help desk tab")
    public void addsFileInTheHelpDeskTab() {
        page.addFile.click();
        ReusableMethods.wait(1);
        String path = "C:\\Users\\User\\TestFiles\\Test.png";
        ReusableMethods.robotClassDosyaYukleme(path);
    }

    @When("user selects save button in the help desk tab")
    public void userSelectsSaveButtonInTheHelpDeskTab() {
        page.saveRequest.click();
        ReusableMethods.wait(1);
    }

    @Then("new request has been successfully created")
    public void newRequestHasBeenSuccessfullyCreated() {
        WebElement tableBody = getDriver().findElement(By.cssSelector("tbody.mdc-data-table__content"));
        List<WebElement> rows = tableBody.findElements(By.xpath(".//tr[contains(@class, 'mat-mdc-row')]"));
        for (WebElement row : rows) {
            WebElement regUserCell = row.findElement(By.xpath(".//td[contains(@class, 'cdk-column-regUserFullName')]"));
            WebElement feedbackTypeCell = row.findElement(By.xpath(".//td[contains(@class, 'cdk-column-feedBackType')]"));
            String regUserText = regUserCell.getText();
            String feedbackTypeText = feedbackTypeCell.getText();
            assertTrue(regUserText.contains("Fərid İmranov"));
            assertTrue(feedbackTypeText.contains("Xəta"));
            if (regUserText.equals("Fərid İmranov") && feedbackTypeText.equals("Xəta")) {
                row.click();
                System.out.println("Clicked the row with Fərid İmranov and Xəta");
                break;
            }
        }
        ReusableMethods.flash(page.check1, getDriver());
        ReusableMethods.flash(page.check2, getDriver());
        ReusableMethods.flash(page.check3, getDriver());
        ReusableMethods.flash(page.check4, getDriver());
        ReusableMethods.flash(page.check5, getDriver());
        ReusableMethods.flash(page.check6, getDriver());
        ReusableMethods.flash(page.check7, getDriver());
        ReusableMethods.flash(page.check8, getDriver());
        ReusableMethods.flash(page.check9, getDriver());
        ReusableMethods.flash(page.check10, getDriver());
        ReusableMethods.flash(page.check11, getDriver());
        ReusableMethods.flash(page.check14, getDriver());
        ReusableMethods.flash(page.check12, getDriver());
        //ReusableMethods.flash(page.check13,getDriver());
    }

    @Given("test user with login {string} and with password {string} logs into the {string} system")
    public void testUserWithLoginAndWithPasswordLogsIntoTheSystem(String arg0, String arg1, String arg2) {
        getDriver().get(ConfigReader.getProperty("Meis"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ReusableMethods.wait(1);
        page1.emailField.sendKeys(arg0);
        ReusableMethods.wait(1);
        page1.passwordField.sendKeys(arg1);
        page1.enterToTheSystem.click();
    }

    @Then("new help desk request has been successfully created")
    public void newHelpDeskRequestHasBeenSuccessfullyCreated() {
        WebElement tableBody = getDriver().findElement(By.cssSelector("tbody.mdc-data-table__content"));
        List<WebElement> rows = tableBody.findElements(By.xpath(".//tr[contains(@class, 'mat-mdc-row')]"));
        for (WebElement row : rows) {
            WebElement regUserCell = row.findElement(By.xpath(".//td[contains(@class, 'cdk-column-regUserFullName')]"));
            WebElement feedbackTypeCell = row.findElement(By.xpath(".//td[contains(@class, 'cdk-column-feedBackType')]"));
            String regUserText = regUserCell.getText();
            String feedbackTypeText = feedbackTypeCell.getText();
            assertTrue(regUserText.contains("ibrahim Rzayev"));
            assertTrue(feedbackTypeText.contains("Xəta"));
            if (regUserText.equals("ibrahim Rzayev") && feedbackTypeText.equals("Xəta")) {
                row.click();
                System.out.println("Clicked the row with ibrahim Rzayev and Xəta");
                break;
            }
        }
        ReusableMethods.flash(page.check1, getDriver());

    }

    @Then("an email about a new request has been sent to the e-mail address of the person designated in the system")
    public void anEmailAboutANewRequestHasBeenSentToTheEMailAddressOfThePersonDesignatedInTheSystem() {

//        WebElement spanElement1 = getDriver().findElement(By.xpath("//a[contains(., 'Göndərdiyim müraciətlər')]"));
//        spanElement1.click();
//
//        WebElement tableBody = getDriver().findElement(By.cssSelector("tbody.mdc-data-table__content"));
//        List<WebElement> rows = tableBody.findElements(By.xpath(".//tr[contains(@class, 'mat-mdc-row')]"));
//        for (WebElement row : rows) {
//            WebElement regUserCell = row.findElement(By.xpath(".//td[contains(@class, 'cdk-column-regUserFullName')]"));
//            WebElement feedbackTypeCell = row.findElement(By.xpath(".//td[contains(@class, 'cdk-column-feedBackType')]"));
//            String regUserText = regUserCell.getText();
//            String feedbackTypeText = feedbackTypeCell.getText();
//            assertTrue(regUserText.contains("ibrahim Rzayev"));
//            assertTrue(feedbackTypeText.contains("Xəta"));
//            if (regUserText.equals("ibrahim Rzayev") && feedbackTypeText.equals("Xəta")) {
//                row.click();
//                System.out.println("Clicked the row with ibrahim Rzayev and Xəta");
//                break;
//            }
//        }
//        ReusableMethods.flash(page.check1, getDriver());


        WebElement spanElement = getDriver().findElement(By.xpath("//span[@class='ng-star-inserted']"));
        String text = spanElement.getText();
        System.out.println("Extracted text: " + text);

//        String originalWindow = getDriver().getWindowHandle();
//        ((JavascriptExecutor) getDriver()).executeScript("window.open('https://gmail.com/', '_blank');");
        getDriver().get("https://gmail.com/");
//        Set<String> windowHandles = getDriver().getWindowHandles();
//        for (String handle : windowHandles) {
//            if (!handle.equals(originalWindow)) {
//                getDriver().switchTo().window(handle);
//                break;
//            }
//        }
//        getDriver().switchTo().window(originalWindow).close();
//        for (String handle : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(handle);
//        }
//
//        // Выполняем действия на новой странице
//        String newUrl = getDriver().getCurrentUrl();
//        System.out.println("Switched to URL: " + newUrl);

        // Закрываем предыдущее окно
        //getDriver().switchTo().window(originalWindow).close();

        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page2.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page2.googleNextButton.click();
        ReusableMethods.wait(3);
        page2.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page2.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);

        WebElement row = getDriver().findElement(By.xpath("//tr[contains(@class, 'zA zE') and .//span[contains(text(), 'yaradılıb')]]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4']//span[text()='meis']"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }
        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());

        WebElement divElement = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        List<WebElement> childElements = divElement.findElements(By.xpath("//div[@class='a3s aiL ']"));
        for (WebElement element : childElements) {
            String text1 = element.getText().trim();
            System.out.println("text1 = " + text1);
            assertTrue(text1.contains(" Digər problemlər"));
            //assertTrue(text1.contains(" 09.07.2024"));
            assertTrue(text1.contains(" Xəta"));
            assertTrue(text1.contains(" Xahiş olunur ki müraciətimə təcili baxılsın!"));
            assertTrue(text1.contains(" Yüksək"));
            assertTrue(text1.contains(" ibrahim Rzayev"));
            assertTrue(text1.contains(" 111111111"));
            assertTrue(text1.contains(" Yeni"));
            ReusableMethods.wait(1);
            WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
            WebElement fayl = getDriver().findElement(By.xpath("//div[@class='aQH']"));
            ReusableMethods.flash(alltext, getDriver());
            ReusableMethods.flash(fayl, getDriver());

//            String originalWindow1 = getDriver().getWindowHandle();
//            ((JavascriptExecutor) getDriver()).executeScript("window.open('https://mono-meis.competition.gov.az/auth', '_blank');");
//            //getDriver().get("https://mono-meis.competition.gov.az/auth");
//            Set<String> windowHandles1 = getDriver().getWindowHandles();
//            for (String handle : windowHandles1) {
//                if (!handle.equals(originalWindow1)) {
//                    getDriver().switchTo().window(handle);
//                    break;
//                }
//            }
//            //getDriver().switchTo().window(originalWindow).close();
//            for (String handle : getDriver().getWindowHandles()) {
//                getDriver().switchTo().window(handle);
//            }
//            String url = getDriver().getCurrentUrl();
//            System.out.println("url = " + url);
//            ReusableMethods.scrollEndByJavascript();
//            WebElement exit = getDriver().findElement(By.xpath("/html/body/app-root/div/div/main/app-home/div[2]/app-menu-item[11]/div"));
//            WebElement exitYes = getDriver().findElement(By.xpath("//span[text()='Bəli']"));
//            ReusableMethods.clickByJavaScript(exit);
//            exit.click();
//            exitYes.click();


        }
    }

    @And("admin goes to the help desk tab from admin panel")
    public void adminGoesToTheHelpDeskTabFromAdminPanel() {
        page.adminPanelBtn.click();
        ReusableMethods.wait(1);
        page.adminHelpTab.click();
        ReusableMethods.wait(1);
    }

    @And("admin selects new request from table")
    public void adminSelectsNewRequestFromTable() {
        page.selectReguest.click();
        ReusableMethods.wait(1);

    }

    @And("admin selects an executive person for the new request")
    public void adminSelectsAnExecutivePersonForTheNewRequest() {
        page.openEmployeeList.click();
        ReusableMethods.wait(1);
        page.selectinputEmployee.sendKeys("Davud Zamanov");
        ReusableMethods.wait(1);
        page.selectnameEmployee.click();
        ReusableMethods.wait(1);
        page.acceptEmployee.click();
        ReusableMethods.wait(3);
        page.getbackTable.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the application and the name of the IT specialist are displayed in the general table")
    public void theStatusOfTheApplicationAndTheNameOfTheITSpecialistAreDisplayedInTheGeneralTable() {
        ReusableMethods.flash(page.tableIlkinStatus, getDriver());
        ReusableMethods.flash(page.tableNameEmlpoyee, getDriver());
    }

    @And("IT specialist with login {string} and with password {string} logs to the system")
    public void ITSpecialistWithLoginAndWithPasswordLogsToTheSystem(String arg0, String arg1) {
        page.exitBtn.click();
        ReusableMethods.wait(1);
        page.acceptExitBtn.click();
        ReusableMethods.wait(1);
        page1.emailField.sendKeys(arg0);
        ReusableMethods.wait(1);
        page1.passwordField.sendKeys(arg1);
        page1.enterToTheSystem.click();
    }

    @Then("the system notification and information about request are displayed")
    public void theSystemNotificationAndInformationAboutRequestAreDisplayed() {
//        if (!page.noteMainCheck.isDisplayed()) {
//            page.systemNotBtn.click();
//            ReusableMethods.wait(1);
//            page.selectNotBtn.click();
//            ReusableMethods.flash(page.noteMainCheck, getDriver());
//            ReusableMethods.flash(page.firstNoteCheck, getDriver());
//            ReusableMethods.flash(page.secondNoteCheck, getDriver());
//            ReusableMethods.flash(page.thirdNoteCheck, getDriver());
//            ReusableMethods.flash(page.fourthNoteCheck, getDriver());
//            ReusableMethods.flash(page.fifthNoteCheck, getDriver());
//            ReusableMethods.flash(page.sixthNoteCheck, getDriver());
//            page.moreIntormationBtn.click();
//            ReusableMethods.wait(1);
//        }
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

            // Check if the noteMainCheck is displayed
            if (isElementVisible(page.noteMainCheck, wait)) {
                ReusableMethods.flash(page.noteMainCheck, getDriver());
                ReusableMethods.flash(page.firstNoteCheck, getDriver());
                ReusableMethods.flash(page.secondNoteCheck, getDriver());
                ReusableMethods.flash(page.thirdNoteCheck, getDriver());
                ReusableMethods.flash(page.fourthNoteCheck, getDriver());
                ReusableMethods.flash(page.fifthNoteCheck, getDriver());
                ReusableMethods.flash(page.sevenNoteCheck, getDriver());
                ReusableMethods.flash(page.sixthNoteCheck, getDriver());

                page.moreIntormationBtn.click();
                ReusableMethods.wait(1);
            } else {
                page.systemNotBtn.click();
                ReusableMethods.wait(1);
                page.selectNotBtn.click();
                ReusableMethods.flash(page.noteMainCheck, getDriver());
                ReusableMethods.flash(page.firstNoteCheck, getDriver());
                ReusableMethods.flash(page.secondNoteCheck, getDriver());
                ReusableMethods.flash(page.thirdNoteCheck, getDriver());
                ReusableMethods.flash(page.fourthNoteCheck, getDriver());
                ReusableMethods.flash(page.fifthNoteCheck, getDriver());
                ReusableMethods.flash(page.sevenNoteCheck, getDriver());
                ReusableMethods.flash(page.sixthNoteCheck, getDriver());
                page.moreIntormationBtn.click();
                ReusableMethods.wait(1);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private static boolean isElementVisible(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Then("the notice arrived successfully in the mail and the information are displayed")
    public void theNoticeArrivedSuccessfullyInTheMailAndTheInformationAreDisplayed() {
        WebElement infoValueElement = getDriver().findElement(By.xpath("//p[@class='info_value']"));
        String text = infoValueElement.getText();
        System.out.println("text = " + text);

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
        getDriver().get("https://e.mail.ru/");
        ReusableMethods.wait(2);
        page.mailUsername.sendKeys("anjelika.huseynova60@mail.ru");
        ReusableMethods.wait(1);
        page.signIn.click();
        ReusableMethods.wait(2);
        page.mailPassword.sendKeys("abyu8894");
        ReusableMethods.wait(3);
        page.signIn.click();
        ReusableMethods.wait(3);
        page.searchInputMailRuClick.click();
        page.searchInputMailRu.sendKeys(text);
        page.searchInputMailRu.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        try {
            // Wait until the element is present
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='llc__content llc__content_pony-mode']")));

            // Locate the element containing the text "sizə təyin edilib"
            WebElement targetElement = getDriver().findElement(By.xpath("//div[@class='llc__content llc__content_pony-mode']//span[contains(text(), 'sizə təyin edilib')]"));

            if (targetElement != null) {
                // Click the container element if the text is found
                container.click();
                ReusableMethods.wait(1);
                System.out.println("Clicked on the container with the specified text.");
            } else {
                System.out.println("Text not found in the specified element.");
            }
        } catch (Exception e) {
            // Handle any exceptions (e.g., element not found)
            e.printStackTrace();
        }

        WebElement divElement = getDriver().findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']"));
        List<WebElement> childElements = divElement.findElements(By.xpath("//div[@class='js-helper js-readmsg-msg']"));
        for (WebElement element : childElements) {

            String divText = element.getText();

            Assert.assertTrue(divText.contains("Digər problemlər"));
            //Assert.assertTrue(divText.contains("11.07.2024"));
            Assert.assertTrue(divText.contains("Yüksək"));
            Assert.assertTrue(divText.contains("ibrahim Rzayev"));
            //Assert.assertTrue(divText.contains("11.07.2024"));
            Assert.assertTrue(divText.contains("Yüksək"));
            Assert.assertTrue(divText.contains("ibrahim Rzayev"));
            Assert.assertTrue(divText.contains("Davud Zamanov"));
            ReusableMethods.flash(page.checkNumHedaerMailRu, getDriver());
            ReusableMethods.flash(page.checkFIleMailRu, getDriver());
            ReusableMethods.flash(page.checkalltextMailRu, getDriver());
            getDriver().switchTo().window(currentWindowHandle);
            ReusableMethods.wait(1);
        }
    }

    @When("IT specialist changes request status to the in process")
    public void itSpecialistChangesRequestStatusToTheInProcess() {
        page.reqStatus.click();
        ReusableMethods.wait(1);
        page.reqStatusList.click();
        ReusableMethods.wait(1);
        page.reqAcceptStatusList.click();
        ReusableMethods.wait(1);
        page.noteInput.sendKeys("Icraya qəbul edildi");
        ReusableMethods.wait(1);
        page.acceptStatusNote.click();
        ReusableMethods.wait(1);
        ReusableMethods.pageDown();
        ReusableMethods.flash(page.checkNote, getDriver());
    }

    @Then("the request status successful has been changed to the in proccees")
    public void theRequestStatusSuccessfulHasBeenChangedToTheInProccees() {
        ReusableMethods.wait(1);
        page.getbackTable.click();
        ReusableMethods.wait(1);
        ReusableMethods.scrollToElementByActions(page.checkStatusTableInWork);
        ReusableMethods.flash(page.checkStatusTableInWork, getDriver());
    }

    @Given("user with role IT specialist logs to the system")
    public void userWithRoleITSpecialistLogsToTheSystem() {
        getDriver().get(ConfigReader.getProperty("Meis"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ReusableMethods.wait(1);
        page1.emailField.sendKeys("anjelika.huseynova60@mail.ru");
        ReusableMethods.wait(1);
        page1.passwordField.sendKeys("Davud88!!!");
        page1.enterToTheSystem.click();
    }

    @When("IT specialist changes request status to the done")
    public void itSpecialistChangesRequestStatusToTheDone() {
        page.adminPanelBtn.click();
        ReusableMethods.wait(1);
        page.adminHelpTab.click();
        ReusableMethods.wait(1);
        List<WebElement> rows = getDriver().findElements((By.xpath("//tr[td[contains(text(), 'İcraya qəbul edilib')] and td[contains(text(), 'Davud Zamanov')]]")));
        for (WebElement row : rows) {
            row.click();
            ReusableMethods.wait(1);
        }
        page.inProqressBtn.click();
        ReusableMethods.wait(1);


        page.statList.click();
        ReusableMethods.wait(1);
        page.setDoneList.click();
        ReusableMethods.wait(1);
        page.doneInput.sendKeys("Müvəffəqiyyətlə icra edildi");
        ReusableMethods.wait(1);
        page.actInput.sendKeys("Akt-8888");
        ReusableMethods.wait(1);
        page.acceptEmployee.click();
        ReusableMethods.wait(1);
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        page.editStat.click();
        page.statInput.sendKeys("İcra edildi, icra faizi 100%");
        page.perscentDone.click();
        ReusableMethods.wait(1);
        page.perscentDone.click();
        ReusableMethods.wait(1);
        page.perscentDone.click();
        ReusableMethods.wait(1);
        page.perscentDone.click();
        ReusableMethods.wait(1);
        page.acceptEmployee.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.nameCheckReq, getDriver());
        ReusableMethods.flash(page.dateCheckReq, getDriver());
        ReusableMethods.flash(page.noteCheckReq, getDriver());
        ReusableMethods.pageDown();
        page.getbackTable.click();
        ReusableMethods.wait(1);

    }

    @Then("the request status successful has been changed to the done")
    public void theRequestStatusSuccessfulHasBeenChangedToTheDone() {
        //ReusableMethods.pageUp();
        ReusableMethods.wait(2);
        ReusableMethods.flash(page.checkDoneStatusTable, getDriver());
        ReusableMethods.wait(1);
    }

    @Then("the system notification and information about request status is displayed")
    public void theSystemNotificationAndInformationAboutRequestStatusIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

            // Check if the noteMainCheck is displayed
            if (isElementVisible(page.noteMainCheck, wait)) {
                ReusableMethods.flash(page.noteMainCheck, getDriver());
                ReusableMethods.flash(page.firstNoteCheck, getDriver());
                ReusableMethods.flash(page.secondNoteCheck, getDriver());
                ReusableMethods.flash(page.doneNoteCheck, getDriver());
                //ReusableMethods.flash(page.NoteCheck, getDriver());
                ReusableMethods.flash(page.actNoteCheck, getDriver());

                ReusableMethods.flash(page.fourthNoteCheck, getDriver());
                ReusableMethods.flash(page.fifthNoteCheck, getDriver());
                ReusableMethods.flash(page.sevenNoteCheck, getDriver());
                ReusableMethods.flash(page.sixthNoteCheck, getDriver());

                page.moreIntormationBtn.click();
                ReusableMethods.wait(1);
            } else {
                page.systemNotBtn.click();
                ReusableMethods.wait(1);
                page.selectNotBtn.click();
                ReusableMethods.flash(page.noteMainCheck, getDriver());
                ReusableMethods.flash(page.firstNoteCheck, getDriver());
                ReusableMethods.flash(page.secondNoteCheck, getDriver());
                ReusableMethods.flash(page.doneNoteCheck, getDriver());
                //ReusableMethods.flash(page.NoteCheck, getDriver());
                ReusableMethods.flash(page.actNoteCheck, getDriver());

                ReusableMethods.flash(page.fourthNoteCheck, getDriver());
                ReusableMethods.flash(page.fifthNoteCheck, getDriver());
                ReusableMethods.flash(page.sevenNoteCheck, getDriver());
                ReusableMethods.flash(page.sixthNoteCheck, getDriver());
                page.moreIntormationBtn.click();
                ReusableMethods.wait(1);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Then("the notification about done status arrived successfully in the mail and the information are displayed")
    public void theNotificationAboutDoneStatusArrivedSuccessfullyInTheMailAndTheInformationAreDisplayed() {
        WebElement pElement = getDriver().findElement(By.xpath("//p[contains(@class, 'info_value')]"));
        value = pElement.getText();
        System.out.println("The value is: " + value);

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
        getDriver().get("https://e.mail.ru/");
        ReusableMethods.wait(2);
        page.mailUsername.sendKeys("irina.kolesnikova62@mail.ru");
        ReusableMethods.wait(1);
        page.signIn.click();
        ReusableMethods.wait(2);
        page.mailPassword.sendKeys("abyu8894");
        ReusableMethods.wait(3);
        page.signIn.click();
        ReusableMethods.wait(3);
        page.searchInputMailRuClick.click();
        page.searchInputMailRu.sendKeys(value);
        page.searchInputMailRu.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        try {
            // Wait until the element is present
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='llc__container']")));

            // Locate the element containing the text "icra edilib"
            WebElement targetElement = getDriver().findElement(By.xpath("//div[@class='ll-sj']//span[contains(text(), ' icra edilib')]"));

            if (targetElement != null) {
                // Click the container element if the text is found
                container.click();
                ReusableMethods.wait(1);
                System.out.println("Clicked on the container with the specified text.");
            } else {
                System.out.println("Text not found in the specified element.");
            }
        } catch (Exception e) {
            // Handle any exceptions (e.g., element not found)
            e.printStackTrace();
        }
        WebElement headText = getDriver().findElement(By.xpath("//div[@class='thread__subject-line']"));
        ReusableMethods.flash(headText, getDriver());
        WebElement file = getDriver().findElement(By.xpath("//div[@class='attach-list__thumbs']"));
        ReusableMethods.flash(file, getDriver());
        WebElement alltext1 = getDriver().findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']"));
        ReusableMethods.flash(alltext1, getDriver());
        ReusableMethods.wait(3);
    }

    @Then("the notification about done status arrived successfully in the mail and the information are displayed to the person designated in the system")
    public void theNotificationAboutDoneStatusArrivedSuccessfullyInTheMailAndTheInformationAreDisplayedToThePersonDesignatedInTheSystem() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page2.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page2.googleNextButton.click();
        ReusableMethods.wait(3);
        page2.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page2.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        ReusableMethods.wait(2);
        System.out.println("value = " + value);
        spanElement2.sendKeys(value);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);

        WebElement row = getDriver().findElement(By.xpath("//tr[contains(@class, 'zA zE') and .//span[contains(text(), ' icra edilib')]]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4']//span[text()='meis']"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }
        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());

        WebElement divElement = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        List<WebElement> childElements = divElement.findElements(By.xpath("//div[@class='a3s aiL ']"));
        for (WebElement element : childElements) {
            String text1 = element.getText().trim();
            System.out.println("text1 = " + text1);
            assertTrue(text1.contains(" Digər problemlər"));
            //assertTrue(text1.contains(" 09.07.2024"));
            assertTrue(text1.contains(" Xəta"));
            assertTrue(text1.contains(" Yüksək"));
            assertTrue(text1.contains(" ibrahim Rzayev"));
            assertTrue(text1.contains(" Davud Zamanov"));
            assertTrue(text1.contains(" Müvəffəqiyyətlə icra edildi"));
            assertTrue(text1.contains(" PC_İbrahim"));
            assertTrue(text1.contains(" 111111111"));
            assertTrue(text1.contains(" 2222"));
            assertTrue(text1.contains(" İcra edi̇ldi̇"));
            ReusableMethods.wait(1);
            WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
            WebElement fayl = getDriver().findElement(By.xpath("//div[@class='aQH']"));
            ReusableMethods.flash(alltext, getDriver());
            ReusableMethods.flash(fayl, getDriver());
        }
    }
}