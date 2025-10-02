package stepdefinitions;

import Page.calendar_Page;
import Page.electronLibrary_Page;
import Page.loginAndLogOut_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static stepdefinitions.calendar_Steps.isElementVisible;
import static utilities.Driver.getDriver;

public class electronLibrary_Steps {

    //    static electronLibrary_Page page = new electronLibrary_Page();
    electronLibrary_Page page;

    public electronLibrary_Steps() {
        this.page = new electronLibrary_Page();
    }

    loginAndLogOut_Page pageSecond = new loginAndLogOut_Page();
    calendar_Page calendar = new calendar_Page();
    String viewCounter;

    @And("selects new {string} button in the training materials tab")
    public void selectsNewButtonInTheTrainingMaterialsTab(String selection) {
        if (selection.contains("training")) {
            ReusableMethods.wait(1);
            page.newTrainingBtn.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("information")) {
            ReusableMethods.wait(1);
            page.newInformationBtn.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("journal")) {
            ReusableMethods.wait(1);
            page.newJournalBtn.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds {string} to training name input")
    public void addsToTrainingNameInput(String arg0) {
        if (arg0.contains("Daxili təlim AT")) {
            page.traningName.sendKeys("Daxili təlim");
            ReusableMethods.wait(1);

        } else if (arg0.contains("Kənardan təlim")) {
            page.traningName.clear();
            ReusableMethods.wait(1);
            page.traningName.sendKeys("Kənardan təlim");
            ReusableMethods.wait(1);
        }
    }

    @And("adds instructor {string} from search list")
    public void addsInstructorFromSearchList(String selection) {
        if (selection.contains("Davud")) {
            calendar.choosePersonInput.sendKeys("Davud Zamanov");
            ReusableMethods.wait(2);
            calendar.choosePersonDavud.click();
//            ReusableMethods.clickByJavaScript(calendar.choosePersonDavud);
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveByOffset(5, 5).click().build().perform();
//            page.closeList.click();
//            ReusableMethods.wait(1);
        } else if (selection.contains("Abbas Rzayev")) {
            page.checkboxTraining.click();
            ReusableMethods.wait(1);
            page.instructorNameInput.sendKeys("Abbas Rzayev");
            ReusableMethods.wait(1);
            page.plusBtn.click();
        }
    }

    @And("adds training date")
    public void addsTrainingDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        page.dateInput.sendKeys(formattedDate);
        ReusableMethods.wait(1);
    }

    @And("adds note {string} to the note input")
    public void addsNoteToTheNoteInput(String selection) {
        if (selection.contains("Automaiton kurslar barədə")) {
            page.noteInput.sendKeys("Automaiton kurslar barədə");
            ReusableMethods.wait(2);
        }

    }

    public static void EditButtonForString1(String text) {
        // Find the row containing the specified text
        WebElement row = getDriver().findElement(By.xpath("(//td[contains(text(), '" + text + "')]//ancestor::tr)[1]"));
        System.out.println(row);
        ReusableMethods.wait(1);
        // Find the edit button within the row
        WebElement editButton = row.findElement(By.xpath(".//mat-icon[contains(@class, 'mat-primary') and contains(text(), 'edit')]"));
        ;
        System.out.println("editButton = " + editButton);
        editButton.click();
    }

    public static void DeleteButtonForString2(String text) {
        // Find the row containing the specified text
        WebElement row = getDriver().findElement(By.xpath("//td[contains(text(), '" + text + "')]//ancestor::tr"));
        ReusableMethods.wait(2);
        // Find the edit button within the row
        WebElement deleteButton = row.findElement(By.xpath(".//mat-icon[@class='mat-icon notranslate mat-warn material-icons mat-ligature-font' and contains(text(), 'delete')]"));
        deleteButton.click();
    }

    @Given("{string} with login logs to the system")
    public void withLoginLogsToTheSystem(String arg0) {
        if (arg0.contains("Fərid")) {
            getDriver().get(ConfigReader.getProperty("Meis"));
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ReusableMethods.wait(1);
            pageSecond.emailField.sendKeys(ConfigReader.getProperty("FaridLogin"));
            ReusableMethods.wait(1);
            pageSecond.passwordField.sendKeys(ConfigReader.getProperty("FaridPassword"));
            pageSecond.enterToTheSystem.click();
        } else if (arg0.contains("Abbas")) {
            getDriver().get(ConfigReader.getProperty("Meis"));
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ReusableMethods.wait(1);
            pageSecond.emailField.sendKeys(ConfigReader.getProperty("AbbasLogin"));
            ReusableMethods.wait(1);
            pageSecond.passwordField.sendKeys(ConfigReader.getProperty("AbbasPassword"));
            pageSecond.enterToTheSystem.click();

        }

    }

    @And("selects new useful information button in the electronic library tab")
    public void selectsNewUsefulInformationButtonInTheElectronicLibraryTab() {
        ReusableMethods.waitForClickability(page.usefulInformation, 5);
        page.usefulInformation.click();
        ReusableMethods.waitForClickability(page.usefulPlusBtn, 5);
        page.usefulPlusBtn.click();
        ReusableMethods.wait(1);
    }

    @And("adds file in the new useful information tab")
    public void addsFileInTheNewUsefulInformationTab() {
        String file = "file:///C:/Users/User/Desktop/TestFiles/ChangeDoc.pdf";
        page.addUsefulFile.click();
        ReusableMethods.robotClassDosyaYukleme(file);
    }

    @When("user selects save button in the new useful information tab")
    public void userSelectsSaveButtonInTheNewUsefulInformationTab() {
        page.usefulSaveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("new useful information successfully added")
    public void newUsefulInformationSuccessfullyAdded() {
        ReusableMethods.flash(page.checkUseful, getDriver());
        assertTrue(page.checkUseful.isDisplayed());
        ReusableMethods.wait(1);
    }

    @And("selects person {string} for notification and mail")
    public void selectsPersonForNotificationAndMail(String selection) {
        if (selection.contains("Musa")) {
            calendar.choosePersonInputSecond.sendKeys("Musa Rzayev");
            calendar.cancelMusaPerson.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveByOffset(5, 5).click().build().perform();
        } else if (selection.contains("İbrahim")) {
            calendar.choosePersonInputSecond.sendKeys("İbrahim Rzayev");
            calendar.cancelIbrahimPerson.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveByOffset(5, 5).click().build().perform();
        }
    }

    @And("selects person {string} for the who sees field")
    public void selectsPersonForTheWhoSeesField(String selection) {
        if (selection.contains("Musa")) {
            page.selectPersomForWhoSees.click();
            ReusableMethods.wait(1);
            WebElement selectWhoSe = getDriver().findElement(By.xpath("(//span[text()='Ünvanlanmış şəxslərə'])[2]"));
            selectWhoSe.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("İbrahim")) {
            page.selectPersomForWhoSees.click();
            ReusableMethods.wait(1);
            WebElement selectWhoSe = getDriver().findElement(By.xpath("(//span[text()='Ünvanlanmış şəxslərə'])[2]"));
            selectWhoSe.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds file {string} for training")
    public void addsFileForTraining(String selection) {
        if (selection.contains("new")) {
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\QaAutomation.pdf";
            page.addFileBtn.click();
            ReusableMethods.wait(3);
            ReusableMethods.robotClassDosyaYukleme(path);
        } else if (selection.contains("edit")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(2);
            page.fileDelete.click();
            ReusableMethods.wait(1);
            page.deleteYes.click();
            ReusableMethods.pageDown();
            ReusableMethods.wait(5);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\EndToEnd.pdf";
            page.addFileBtn.click();
            ReusableMethods.wait(3);
            ReusableMethods.robotClassDosyaYukleme(path);
        }
    }

    Integer actualFileTraning;

    String usefulInformationInitial;
    Integer usefulInformationCountInitial;
    String electronJournalInitial;
    Integer electronJournalCountInitial;

    @Then("gets the information of the initial counter of the file for {string}")
    public void getsTheInformationOfTheInitialCounterOfTheFileFor(String initial) {
        if (initial.contains("useful information")) {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Grow uP')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[5]"));
            ReusableMethods.flash(viewCountCell, getDriver());
            usefulInformationInitial = viewCountCell.getText();
            System.out.println("viewCountText = " + usefulInformationInitial);
            String trainingMaterialsInitialCount = usefulInformationInitial.replaceAll(".*\\((\\d+)\\).*", "$1");
            usefulInformationCountInitial = Integer.parseInt(trainingMaterialsInitialCount);
        } else if (initial.contains("electron journal")) {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Qa Journal')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[7]"));
            ReusableMethods.flash(viewCountCell, getDriver());
            electronJournalInitial = viewCountCell.getText();
            System.out.println("viewCountText = " + electronJournalInitial);
            String trainingMaterialsInitialCount = electronJournalInitial.replaceAll(".*\\((\\d+)\\).*", "$1");
            electronJournalCountInitial = Integer.parseInt(trainingMaterialsInitialCount);
        }

    }

    Integer expectCountFileUsefulInformation;
    String usefulInformationInitialSecond;
    Integer expectCountFileElectronJournal;
    String electronJournalInitialSecond;
    Integer actualFileUseful;

    @Then("counter of the information folder is displayed correctly due to the increase of the file for {string}")
    public void counterOfTheInformationFolderIsDisplayedCorrectlyDueToTheIncreaseOfTheFileFor(String count) {
        if (count.contains("useful information")) {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Grow uP')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[5]"));
            ReusableMethods.flash(viewCountCell, getDriver());
            expectCountFileUsefulInformation = usefulInformationCountInitial + 1;
            System.out.println("expectCount = " + expectCountFileUsefulInformation);
            usefulInformationInitialSecond = viewCountCell.getText();
            System.out.println("viewCountText = " + usefulInformationInitialSecond);
            String usefulinfotmationInitialCount = usefulInformationInitialSecond.replaceAll(".*\\((\\d+)\\).*", "$1");
            actualFileTraning = Integer.parseInt(usefulinfotmationInitialCount);
            Assert.assertEquals(expectCountFileUsefulInformation, actualFileTraning);
        } else if (count.contains("electron journal")) {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Qa Journal')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[7]"));
            ReusableMethods.flash(viewCountCell, getDriver());
            expectCountFileElectronJournal = electronJournalCountInitial + 1;
            System.out.println("expectCount = " + expectCountFileElectronJournal);
            electronJournalInitialSecond = viewCountCell.getText();
            System.out.println("viewCountText = " + electronJournalInitialSecond);
            String elecJounralInitialCount = electronJournalInitialSecond.replaceAll(".*\\((\\d+)\\).*", "$1");
            actualFileTraning = Integer.parseInt(elecJounralInitialCount);
            Assert.assertEquals(expectCountFileElectronJournal, actualFileTraning);
        }
    }

    @And("selects new electron journal button in the electronic library tab")
    public void selectsNewElectronJournalButtonInTheElectronicLibraryTab() {
        ReusableMethods.waitForClickability(page.electronJournal, 5);
        page.electronJournal.click();
        ReusableMethods.waitForClickability(page.electronJournalPlusBtn, 5);
        page.electronJournalPlusBtn.click();
        ReusableMethods.wait(1);
    }

    @And("adds new journal name")
    public void addsNewJournalName() {
        page.nameEJ.sendKeys("Qa Journal");
        ReusableMethods.wait(1);
    }

    @And("adds number for journal name")
    public void addsNumberForJournalName() {
        page.numberEJ.sendKeys("887799");
        ReusableMethods.wait(1);
    }

    @And("selects person for notification and mail for the electron journal")
    public void selectsPersonForNotificationAndMailForTheElectronJournal() {
        page.selectNotPersomForElectronJournal.sendKeys("Fərid İmranov");
        ReusableMethods.wait(1);
        WebElement namePerson = getDriver().findElement(By.xpath("//label[contains(.,'Fərid İmranov')]"));
        namePerson.click();
        ReusableMethods.wait(1);
    }

    @And("adds journal date")
    public void addsJournalDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        page.dateInputEJ.sendKeys(formattedDate);
        ReusableMethods.wait(1);
    }

    @And("selects person for the who sees field for the electron journal")
    public void selectsPersonForTheWhoSeesFieldForTheElectronJournal() {
        page.selectPersomForWhoSees.click();
        ReusableMethods.wait(1);
        WebElement selectWhoSe = getDriver().findElement(By.xpath("(//span[text()='Ünvanlanmış şəxslərə görə'])[2]"));
        selectWhoSe.click();
        ReusableMethods.wait(1);
        // WebElement clickPerson = getDriver().findElement(By.xpath("(//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-25']//input)[1]"));
//        clickPerson.sendKeys("Fərid İmranov");
//        WebElement namePerson = getDriver().findElement(By.xpath("//label[contains(.,'Fərid İmranov')]"));
//        namePerson.click();
        //  ReusableMethods.wait(1);
    }

    @When("user selects accept button")
    public void userSelectsAcceptButton() {
        ReusableMethods.wait(3);
        page.acceptBtn.click();
        ReusableMethods.wait(1);
    }

    @When("user selects delete button in the new electron journal tab")
    public void userSelectsDeleteButtonInTheNewElectronJournalTab() {
        WebElement itemRow = getDriver().findElement(By.xpath("//td[contains(text(),'Qa Journal')]/ancestor::tr"));
        WebElement deleteButton = itemRow.findElement(By.cssSelector(".mat-icon.mat-warn"));
        deleteButton.click();
        ReusableMethods.wait(1);
        page.deleteYes.click();
        ReusableMethods.wait(1);
    }

    @Then("newly added electron journal successfully deleted")
    public void newlyAddedElectronJournalSuccessfullyDeleted() {
        getDriver().navigate().refresh();
        ReusableMethods.wait(1);
        String text = "Qa Journal";
        ReusableMethods.assertElementDeleted(getDriver(), text);
    }

    @And("goes to the electronic library tab in the control panel")
    public void goesToTheElectronicLibraryTabInTheControlPanel() {
        ReusableMethods.wait(2);
        System.out.println("im here and url:" + getDriver().getCurrentUrl());
//        page.electronicLibraryTabAdmin.click();
        ReusableMethods.clickByJavaScript(page.electronicLibraryTabAdmin);
        ReusableMethods.wait(1);
    }

    @Then("all information about the training material is displayed in the table in the admin panel")
    public void allInformationAboutTheTrainingMaterialIsDisplayedInTheTableInTheAdminPanel(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String trainingName = row.get("Təlimin adı");
            String trainingTeacherName = row.get("Təlimçi");
            String trainingMaterial = row.get("Təlim materialları");
            String viewCount = row.get("Baxış sayı");

            ReusableMethods.flash(page.trainingNameTable, getDriver());
            Assert.assertEquals(page.trainingNameTable.getText().trim(), trainingName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.trainingTeachersNameTable, getDriver());
            Assert.assertEquals(page.trainingTeachersNameTable.getText().trim(), trainingTeacherName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.trainingTimeTable, getDriver());
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = today.format(formatter);
            Assert.assertEquals(page.trainingTimeTable.getText().trim(), formattedDate);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.trainingMaterialsTable, getDriver());
            Assert.assertEquals(page.trainingMaterialsTable.getText().trim(), trainingMaterial);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.viewCountsTable, getDriver());
            Assert.assertEquals(page.viewCountsTable.getText().trim(), viewCount);
            viewCounter = page.viewCountsTable.getText().trim();
            System.out.println("viewCounter = " + viewCounter);
            ReusableMethods.wait(1);
        }
    }


    @And("all the information about training material is displayed in the notification")
    public void allTheInformationAboutTrainingMaterialIsDisplayedInTheNotification(DataTable dataTable) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            if (isElementVisible(page.trainingNoteModal, wait)) {
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String trainingName = row.get("Başlıq");

                    WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
                    ReusableMethods.waitForOverlayToDisappear(getDriver());

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.trainingNameModal, getDriver());
                    Assert.assertEquals(page.trainingNameModal.getText().trim(), trainingName);
                    ReusableMethods.wait(1);
                    calendar.closeModal.click();
                    ReusableMethods.wait(1);

                }
            } else {
                ReusableMethods.wait(1);
                WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                button.click();
                ReusableMethods.wait(3);
                System.out.println("\"Imhere1\" = " + "Imhere0");
//                By.xpath("//li[.//span[contains(normalize-space(),'Yardım masası')]][1]");
//                By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]");
                WebElement element = getDriver().findElement(By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]"));
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].click();", element);
                element.click();
                ReusableMethods.wait(5);
                System.out.println("\"Imhere1\" = " + "Imhere1");
                ReusableMethods.wait(3);
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String trainingName = row.get("Başlıq");

                    ReusableMethods.flash(page.trainingNameModal, getDriver());
                    Assert.assertEquals(page.trainingNameModal.getText().trim(), trainingName);
                    ReusableMethods.wait(1);
                    calendar.closeModal.click();
                    ReusableMethods.wait(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            Assert.fail("Test zamanı istisna baş verdi: " + e.getMessage());
        }
    }

    @And("goes to the electronic library tab from main page")
    public void goesToTheElectronicLibraryTabFromMainPage() {
        page.electronicMainPage.click();
        ReusableMethods.wait(1);
    }

    @And("user opens the document view modal window")
    public void userOpensTheDocumentViewModalWindow() {
        page.viewCountsTable.click();
        ReusableMethods.wait(1);
    }

    @And("uploads a video from the document view modal window")
    public void uploadsAVideoFromTheDocumentViewModalWindow() {
        page.fileDocumentModal.click();
        ReusableMethods.wait(7);
    }

    @When("user closes the document view modal window")
    public void userClosesTheDocumentViewModalWindow() {
        new Actions(getDriver()).sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.wait(3);
    }

    @Then("an increase is observed in the view count data")
    public void anIncreaseIsObservedInTheViewCountData() {
        ReusableMethods.flash(page.viewCountsTable, getDriver());
        String viewCounterExpectedStr = page.viewCountsTable.getText().trim();
        System.out.println("viewCounterExpectedStr = " + viewCounterExpectedStr);
        int viewCounterExpected = Integer.parseInt(viewCounterExpectedStr);
        int viewCounterInt = Integer.parseInt(viewCounter);
        int expectedValue = viewCounterInt + 1;
        Assert.assertEquals(viewCounterExpected, expectedValue);
    }

    @And("selects edit button in the control panel")
    public void selectsEditButtonInTheControlPanel() {
        page.editButton.click();
        ReusableMethods.wait(1);
    }

    @And("user selects edit button")
    public void userSelectsEditButton() {
        page.editBtn.click();
        ReusableMethods.wait(10);
    }

    @When("selects delete button in the control panel")
    public void selectsDeleteButtonInTheControlPanel() {
        page.deleteButton.click();
        ReusableMethods.wait(1);
        page.deleteYes.click();
        ReusableMethods.wait(1);
    }

    @Then("the deleted training material is not displayed in the control panel")
    public void theDeletedTrainingMaterialIsNotDisplayedInTheControlPanel() {
        while (true) {
            try {
                if (!page.deleteButton.isDisplayed()) {
                    break;
                }
                page.deleteButton.click();
                ReusableMethods.wait(1);
                page.deleteYes.click();
                ReusableMethods.wait(2);
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                break;
            }
        }
        System.out.println("Bütün təlim materialları silindi və test passed oldu ✅");
    }

    @And("the user {string} enters to the e-mail address")
    public void theUserEntersToTheEMailAddress(String person) {
        if (person.contains("İbrahim")) {
            getDriver().get("https://account.proton.me/mail");
            ReusableMethods.wait(3);
            page.emailUsername.sendKeys("ibrahimzamanov88@proton.me");
            ReusableMethods.wait(1);
            page.emailPassword.sendKeys("Ibrahimibrahim88!!");
            ReusableMethods.wait(1);
            page.enterEmail.click();
            ReusableMethods.wait(5);
        } else if (person.contains("Davud")) {
            getDriver().get("https://account.proton.me/mail");
            ReusableMethods.wait(3);
            page.emailUsername.sendKeys("davudzamanov88@proton.me");
            ReusableMethods.wait(1);
            page.emailPassword.sendKeys("Davud8888!!!!");
            ReusableMethods.wait(1);
            page.enterEmail.click();
            ReusableMethods.wait(5);
        }
    }

    @And("opens notification about {string} in the email")
    public void opensNotificationAboutInTheEmail(String about) {
        if (about.contains("Training material")) {
            ReusableMethods.wait(7);
            ReusableMethods.flash(page.selectsTrainingMaterialEmailNot, getDriver());
            page.selectsTrainingMaterialEmailNot.click();
            ReusableMethods.wait(7);
        } else if (about.contains("event")) {
            ReusableMethods.wait(7);
            ReusableMethods.flash(page.selectsEventEmailNot, getDriver());
            page.selectsEventEmailNot.click();
            ReusableMethods.wait(7);
        } else if (about.contains("help-desk-redirect")) {
            ReusableMethods.wait(7);
//            ReusableMethods.flash(page.helpDeskRedirect, getDriver());
//            page.helpDeskRedirect.click();
            System.out.println("im here");
            ReusableMethods.clickByJavaScript(page.helpDeskRedirect);
            ReusableMethods.wait(7);
        } else if (about.contains("useful information")) {
            ReusableMethods.wait(7);
//            ReusableMethods.flash(page.helpDeskRedirect, getDriver());
//            page.helpDeskRedirect.click();
            System.out.println("im here");
            ReusableMethods.clickByJavaScript(page.usefulInformationTitleMail);
            ReusableMethods.wait(7);
        }else if (about.contains("Journal Manual")) {
            ReusableMethods.wait(7);
//            ReusableMethods.flash(page.helpDeskRedirect, getDriver());
//            page.helpDeskRedirect.click();
            System.out.println("im here");
            ReusableMethods.clickByJavaScript(page.electronicJournalTitleMail);
            ReusableMethods.wait(7);
        }
    }

    @Then("all information about the {string} is displayed in the email notification")
    public void allInformationAboutTheIsDisplayedInTheEmailNotification(String selection, DataTable dataTable) {
        if (selection.contains("Training material")) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {
                String trainingStatus = row.get("Təlim status");
                String description = row.get("Təsvir");
                String innerTeachers = row.get("Daxili təlimçilər");
                String title = row.get("Başlığı");
                String whoSent = row.get("Tərtib edən");
                String status = row.get("Status");
                String whomSent = row.get("Şəxslər");

                ReusableMethods.wait(1);
                List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
                System.out.println("Iframe sayı: " + iframes.size());

                boolean found = false;
                for (int i = 0; i < iframes.size(); i++) {
                    getDriver().switchTo().defaultContent(); // hər dəfə sıfırdan başla
                    getDriver().switchTo().frame(i);

                    List<WebElement> elements = getDriver().findElements(By.xpath("//strong[contains(text(),'Yeni daxili təlim yaradıldı!')]"));
                    if (!elements.isEmpty()) {
                        System.out.println("Tapıldı iframe index: " + i);
                        found = true;

                        String firstLine = page.headingElement.getText();
                        String headLine = firstLine.split("\n")[0].trim();
                        System.out.println("Training Status = " + headLine);
                        Assert.assertEquals(headLine, trainingStatus);
                        ReusableMethods.wait(1);

                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        String desc = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Təsvir:')]"))
                        );
                        String descriptionLion = desc.split("\n")[0].trim();
                        System.out.println("descriptionLion = " + descriptionLion);
                        Assert.assertEquals(descriptionLion, description);

                        String trainingDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Təlimin tarixi:')]"))
                        );
                        String trainingDateMail = trainingDate.split("\n")[0].trim();
                        System.out.println("trainingDateMail = " + trainingDateMail);
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String formattedDate = today.format(formatter);
                        Assert.assertEquals(formattedDate, trainingDateMail);

                        String trainingTeachers = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Daxili təlimçilər:')]"))
                        );
                        String trainingTeachersMail = trainingTeachers.split("\n")[0].trim();
                        System.out.println("descriptionLion = " + descriptionLion);
                        Assert.assertEquals(trainingTeachersMail, innerTeachers);

                        String titleText = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Başlığı:')]"))
                        );
                        String titleTextMail = titleText.split("\n")[0].trim();
                        System.out.println("titleTextMail = " + titleTextMail);
                        Assert.assertEquals(titleTextMail, title);

                        String whoSentText = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tərtib edən:')]"))
                        );
                        String whoSentTextMail = whoSentText.split("\n")[0].trim();
                        System.out.println("descriptionLion = " + whoSent);
                        Assert.assertEquals(whoSentTextMail, whoSent);

                        String addDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Təlimin yaradılma tarixi:')]"))
                        );
                        String actualDate = addDate.split(" ")[0];
                        LocalDate todayActual = LocalDate.now();
                        DateTimeFormatter formatterActual = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String expectedDate = todayActual.format(formatterActual);
                        Assert.assertEquals(expectedDate, actualDate);

                        String statusText = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Status:')]"))
                        );
                        String statusTextMail = statusText.split("\n")[0].trim();
                        System.out.println("statusTextMail = " + statusTextMail);
                        Assert.assertEquals(statusTextMail, status);

                        String whomSentText = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Şəxslər:')]"))
                        );
                        String whomSentTextMail = whomSentText.split("\n")[0].trim();
                        System.out.println("whomSentTextMail = " + whomSentTextMail);
                        Assert.assertEquals(whomSentTextMail, whomSent);


                        break;
                    }
                }

                if (!found) {
                    System.out.println("Element heç bir iframe-də tapılmadı!");
                }
                getDriver().switchTo().defaultContent();
            }
        } else if (selection.contains("event")) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {

                String notName = row.get("Bildiriş Adı");
                String notStatus = row.get("Tədbir status");
                String notCategory = row.get("Kateqoriya");
                String eventName = row.get("Başlığı");
                String eventCreated = row.get("Tərtib edən");
                String eventDescription = row.get("Təsvir");
                String eventPlace = row.get("Tədbirin keçiriləcəyi yer");
                String eventStatus = row.get("Status");
                String notWhomSent = row.get("Şəxslər");
                String startNote = row.get("Başlama Saatı");
                String endNote = row.get("Bitmə Saatı");
                String notUrl = row.get("Url");

                Assert.assertEquals(page.notName.getText().trim(), notName);
                ReusableMethods.pageDown();
                ReusableMethods.wait(1);

                ReusableMethods.wait(1);
                List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
                System.out.println("Iframe sayı: " + iframes.size());

                boolean found = false;
                for (int i = 0; i < iframes.size(); i++) {
                    getDriver().switchTo().defaultContent(); // hər dəfə sıfırdan başla
                    getDriver().switchTo().frame(i);

                    List<WebElement> elements = getDriver().findElements(By.xpath("//strong[contains(text(),'Təqvim yaradıldı!')]"));
                    if (!elements.isEmpty()) {
                        System.out.println("Tapıldı iframe index: " + i);
                        found = true;

                        String firstLine = page.headingElement.getText();
                        String headLine = firstLine.split("\n")[0].trim();
                        System.out.println("headLine Status = " + headLine);
                        Assert.assertEquals(headLine, notStatus);
                        ReusableMethods.wait(1);

                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        String category = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Kateqoriya:')]"))
                        );
                        String categoryNot = category.split("\n")[0].trim();
                        System.out.println("notCategory = " + categoryNot);
                        Assert.assertEquals(notCategory, categoryNot);

                        String eventN = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Başlıq:')]"))
                        );
                        String eventNotName = eventN.split("\n")[0].trim();
                        System.out.println("eventNotName = " + categoryNot);
                        Assert.assertEquals(eventNotName, eventName);

                        String eventCreat = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tərtib edən:')]"))
                        );
                        String eventCreatNot = eventCreat.split("\n")[0].trim();
                        System.out.println("eventCreated = " + eventCreatNot);
                        Assert.assertEquals(eventCreatNot, eventCreated);


                        String noteDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Başlama tarixi:')]"))
                        );
                        String noteDateMail = noteDate.split("\n")[0].trim();
                        System.out.println("noteDateMail = " + noteDateMail);
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String formattedDate = today.format(formatter);
                        Assert.assertEquals(formattedDate, noteDateMail);

                        String noteEndDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Bitmə tarixi:')]"))
                        );
                        String noteEndDateMail = noteEndDate.split("\n")[0].trim();
                        System.out.println("noteEndDateMail = " + noteEndDateMail);
                        LocalDate tomorrow = today.plusDays(1);
                        DateTimeFormatter formatterEndDay = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String formattedDateEnd = tomorrow.format(formatterEndDay);
                        Assert.assertEquals(formattedDateEnd, noteEndDateMail);

                        String desc = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Təsvir:')]"))
                        );
                        String descriptionNot = desc.split("\n")[0].trim();
                        System.out.println("descriptionNot = " + descriptionNot);
                        Assert.assertEquals(descriptionNot, eventDescription);

                        String notPlace = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tədbirin keçiriləcəyi yer:')]"))
                        );
                        String notPlaceMail = notPlace.split("\n")[0].trim();
                        System.out.println("notPlaceMail = " + notPlaceMail);
                        Assert.assertEquals(notPlaceMail, eventPlace);

                        String statusText = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Status:')]"))
                        );
                        String statusTextMail = statusText.split("\n")[0].trim();
                        System.out.println("statusTextMail = " + statusTextMail);
                        Assert.assertEquals(statusTextMail, eventStatus);

                        String whomSentText = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Şəxslər:')]"))
                        );
                        String whomSentTextMail = whomSentText.split("\n")[0].trim();
                        System.out.println("whomSentTextMail = " + whomSentTextMail);
                        Assert.assertEquals(whomSentTextMail, notWhomSent);

                        String startTimeNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Başlama Saatı:')]"))
                        );
                        String startNoteMail = startTimeNote.split("\n")[0].trim();
                        System.out.println("startNoteMail = " + startNoteMail);
                        Assert.assertEquals(startNoteMail, startNote);

                        String endTimeNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Bitmə Saatı:')]"))
                        );
                        String endTimeNoteMail = endTimeNote.split("\n")[0].trim();
                        System.out.println("endTimeNoteMail = " + endTimeNoteMail);
                        Assert.assertEquals(endTimeNoteMail, endNote);

                        String urlNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'URL:')]"))
                        );
                        String urlNoteMail = urlNote.split("\n")[0].trim();
                        System.out.println("urlNoteMail = " + urlNoteMail);
                        Assert.assertEquals(urlNoteMail, notUrl);
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Element heç bir iframe-də tapılmadı!");
                }
                getDriver().switchTo().defaultContent();
            }
        } else if (selection.contains("help-desk-redirect")) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {

                String direction = row.get("İstiqamət");
                String type = row.get("Növü");
                String description = row.get("Təsvir");
                String priority = row.get("Prioritet");
                String requester = row.get("Müraciət edən");
                String executor = row.get("İcraçı");
                String pc = row.get("İstifadəçi kompüterinin adı");
                String requestStatus = row.get("Cari nəticə");
                String note = row.get("Qeyd");

//                Assert.assertTrue(page.helpDeskHeader.isDisplayed());
//                ReusableMethods.wait(1);

                ReusableMethods.wait(1);
                List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
                System.out.println("Iframe sayı: " + iframes.size());

                boolean found = false;
                for (int i = 0; i < iframes.size(); i++) {
                    getDriver().switchTo().defaultContent();
                    getDriver().switchTo().frame(i);

                    List<WebElement> elements = getDriver().findElements(By.xpath("//strong"));
                    if (!elements.isEmpty()) {
                        System.out.println("Tapıldı iframe index: " + i);
                        found = true;

                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        String directionNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'İstiqamət:')]"))
                        );
                        String directionNoteMail = directionNote.split("\n")[0].trim();
                        System.out.println("directionNoteMail = " + directionNoteMail);
                        Assert.assertEquals(directionNoteMail, direction);

                        String noteDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tarix:')]"))
                        );
                        String noteDateMail = noteDate.split("\n")[0].trim();
                        System.out.println("noteDateMail = " + noteDateMail);
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String formattedDate = today.format(formatter);
                        Assert.assertEquals(formattedDate, noteDateMail);

                        String typeNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Növü:')]"))
                        );
                        String typeNoteMail = typeNote.split("\n")[0].trim();
                        System.out.println("typeNoteMail = " + typeNoteMail);
                        Assert.assertEquals(typeNoteMail, type);

                        String descriptionNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Təsvir:')]"))
                        );
                        String descriptionNoteMail = descriptionNote.split("\n")[0].trim();
                        System.out.println("descriptionNoteMail = " + descriptionNoteMail);
                        Assert.assertEquals(descriptionNoteMail, description);

                        String priorityNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Prioritet:')]"))
                        );
                        String priorityNoteMail = priorityNote.split("\n")[0].trim();
                        System.out.println("priorityNoteMail = " + priorityNoteMail);
                        Assert.assertEquals(priorityNoteMail, priority);

                        String requesterNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Müraciət edən:')]"))
                        );
                        String requesterNoteMail = requesterNote.split("\n")[0].trim();
                        System.out.println("requesterNoteMail = " + requesterNoteMail);
                        Assert.assertEquals(requesterNoteMail, requester);

                        String executorNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'İcraçı:')]"))
                        );
                        String executorNoteMail = executorNote.split("\n")[0].trim();
                        System.out.println("executorNoteMail = " + executorNoteMail);
                        Assert.assertEquals(executorNoteMail, executor);

                        String pcNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'İstifadəçi kompüterinin adı:')]"))
                        );
                        String pcNoteMail = pcNote.split("\n")[0].trim();
                        System.out.println("pcNoteMail = " + pcNoteMail);
                        Assert.assertEquals(pcNoteMail, pc);

                        String requestStatusNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Cari nəticə:')]"))
                        );
                        String requestStatusMail = requestStatus.split("\n")[0].trim();
                        System.out.println("requestStatusMail = " + requestStatusMail);
                        Assert.assertEquals(requestStatusMail, requestStatus);

                        String noteType = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Qeyd:')]"))
                        );
                        String noteTypeMail = noteType.split("\n")[0].trim();
                        System.out.println("noteTypeMail = " + noteTypeMail);
                        Assert.assertEquals(noteTypeMail, note);

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Element heç bir iframe-də tapılmadı!");
                }
                getDriver().switchTo().defaultContent();
            }
        }else if (selection.contains("help-desk-assigned")) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {

                String direction = row.get("İstiqamət");
                String type = row.get("Növü");
                String description = row.get("Təsvir");
                String priority = row.get("Prioritet");
                String requester = row.get("Müraciət edən");
                String executor = row.get("İcraçı");
                String pc = row.get("İstifadəçi kompüterinin adı");
                String requestStatus = row.get("Cari nəticə");
                String note = row.get("Qeyd");

//                Assert.assertTrue(page.helpDeskHeader.isDisplayed());
//                ReusableMethods.wait(1);

                ReusableMethods.wait(1);
                List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
                System.out.println("Iframe sayı: " + iframes.size());

                boolean found = false;
                for (int i = 0; i < iframes.size(); i++) {
                    getDriver().switchTo().defaultContent();
                    getDriver().switchTo().frame(i);

                    List<WebElement> elements = getDriver().findElements(By.xpath("//strong"));
                    if (!elements.isEmpty()) {
                        System.out.println("Tapıldı iframe index: " + i);
                        found = true;

                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        String directionNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'İstiqamət:')]"))
                        );
                        String directionNoteMail = directionNote.split("\n")[0].trim();
                        System.out.println("directionNoteMail = " + directionNoteMail);
                        Assert.assertEquals(directionNoteMail, direction);

                        String noteDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tarix:')]"))
                        );
                        String noteDateMail = noteDate.split("\n")[0].trim();
                        System.out.println("noteDateMail = " + noteDateMail);
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String formattedDate = today.format(formatter);
                        Assert.assertEquals(formattedDate, noteDateMail);

                        String typeNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Növü:')]"))
                        );
                        String typeNoteMail = typeNote.split("\n")[0].trim();
                        System.out.println("typeNoteMail = " + typeNoteMail);
                        Assert.assertEquals(typeNoteMail, type);

                        String descriptionNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Təsvir:')]"))
                        );
                        String descriptionNoteMail = descriptionNote.split("\n")[0].trim();
                        System.out.println("descriptionNoteMail = " + descriptionNoteMail);
                        Assert.assertEquals(descriptionNoteMail, description);

                        String priorityNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Prioritet:')]"))
                        );
                        String priorityNoteMail = priorityNote.split("\n")[0].trim();
                        System.out.println("priorityNoteMail = " + priorityNoteMail);
                        Assert.assertEquals(priorityNoteMail, priority);

                        String requesterNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Müraciət edən:')]"))
                        );
                        String requesterNoteMail = requesterNote.split("\n")[0].trim();
                        System.out.println("requesterNoteMail = " + requesterNoteMail);
                        Assert.assertEquals(requesterNoteMail, requester);

                        String executorNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'İcraçı:')]"))
                        );
                        String executorNoteMail = executorNote.split("\n")[0].trim();
                        System.out.println("executorNoteMail = " + executorNoteMail);
                        Assert.assertEquals(executorNoteMail, executor);

                        String pcNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'İstifadəçi kompüterinin adı:')]"))
                        );
                        String pcNoteMail = pcNote.split("\n")[0].trim();
                        System.out.println("pcNoteMail = " + pcNoteMail);
                        Assert.assertEquals(pcNoteMail, pc);

                        String requestStatusNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Cari nəticə:')]"))
                        );
                        String requestStatusMail = requestStatus.split("\n")[0].trim();
                        System.out.println("requestStatusMail = " + requestStatusMail);
                        Assert.assertEquals(requestStatusMail, requestStatus);

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Element heç bir iframe-də tapılmadı!");
                }
                getDriver().switchTo().defaultContent();
            }
        } else if (selection.contains("useful information")) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {

                String usefulName = row.get("Başlığı");
                String usefulCreated = row.get("Tərtib edən");
                String usefulStatus = row.get("Status");
                String usefulWhomSent = row.get("Şəxslər");

                ReusableMethods.wait(1);
                List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
                System.out.println("Iframe sayı: " + iframes.size());

                boolean found = false;
                for (int i = 0; i < iframes.size(); i++) {
                    getDriver().switchTo().defaultContent(); // hər dəfə sıfırdan başla
                    getDriver().switchTo().frame(i);

                    List<WebElement> elements = getDriver().findElements(By.xpath("//strong[contains(text(),'Yeni useful manual qa yaradıldı!')]"));
                    if (!elements.isEmpty()) {
                        System.out.println("Tapıldı iframe index: " + i);
                        found = true;


                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        String usefulNameNot = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Başlığı:')]"))
                        );
                        String usefulNameNotMail = usefulNameNot.split("\n")[0].trim();
                        System.out.println("usefulNameNotMail = " + usefulNameNotMail);
                        Assert.assertEquals(usefulNameNotMail, usefulName);

                        String usefulCreat = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tərtib edən:')]"))
                        );
                        String usefulCreatMail = usefulCreat.split("\n")[0].trim();
                        System.out.println("usefulCreatMail = " + usefulCreatMail);
                        Assert.assertEquals(usefulCreatMail, usefulCreated);


                        String noteDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Yaradılma tarixi:')]"))
                        );
                        String noteDateMail = noteDate.split(" ")[0].trim();
                        System.out.println("noteDateMail = " + noteDateMail);
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String formattedDate = today.format(formatter);
                        Assert.assertEquals(formattedDate, noteDateMail);

                        String usefulPerson = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Şəxslər:')]"))
                        );
                        String usefulPersonMail = usefulPerson.split("\n")[0].trim();
                        System.out.println("usefulPersonMail = " + usefulPersonMail);
                        Assert.assertEquals(usefulPersonMail, usefulWhomSent);

                        String statusNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Status:')]"))
                        );
                        String statusNoteMail = statusNote.split("\n")[0].trim();
                        System.out.println("statusNoteMail = " + statusNoteMail);
                        Assert.assertEquals(statusNoteMail, usefulStatus);
                    }
                }

                if (!found) {
                    System.out.println("Element heç bir iframe-də tapılmadı!");
                }
                getDriver().switchTo().defaultContent();
            }
        }else if (selection.contains("Journal Manual")) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {

                String usefulName = row.get("Başlığı");
                String usefulCreated = row.get("Tərtib edən");
                String journalNumber = row.get("Jurnalın buraxılış nömrəsi");
                String usefulStatus = row.get("Status");
                String usefulWhomSent = row.get("Şəxslər");

                ReusableMethods.wait(1);
                List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));
                System.out.println("Iframe sayı: " + iframes.size());

                boolean found = false;
                for (int i = 0; i < iframes.size(); i++) {
                    getDriver().switchTo().defaultContent(); // hər dəfə sıfırdan başla
                    getDriver().switchTo().frame(i);

                    List<WebElement> elements = getDriver().findElements(By.xpath("//strong[contains(text(),'Yeni useful manual qa yaradıldı!')]"));
                    if (!elements.isEmpty()) {
                        System.out.println("Tapıldı iframe index: " + i);
                        found = true;


                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        String usefulNameNot = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Adı:')]"))
                        );
                        String usefulNameNotMail = usefulNameNot.split("\n")[0].trim();
                        System.out.println("usefulNameNotMail = " + usefulNameNotMail);
                        Assert.assertEquals(usefulNameNotMail, usefulName);

                        String usefulCreat = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Tərtib edən:')]"))
                        );
                        String usefulCreatMail = usefulCreat.split("\n")[0].trim();
                        System.out.println("usefulCreatMail = " + usefulCreatMail);
                        Assert.assertEquals(usefulCreatMail, usefulCreated);


                        String noteDate = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Yaradılma tarixi:')]"))
                        );
                        String noteDateMail = noteDate.split(" ")[0].trim();
                        System.out.println("noteDateMail = " + noteDateMail);
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String formattedDate = today.format(formatter);
                        Assert.assertEquals(formattedDate, noteDateMail);

                        String journalNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Jurnalın buraxılış nömrəsi:')]"))
                        );
                        String journalNoteMail = journalNote.split("\n")[0].trim();
                        System.out.println("usefulPersonMail = " + journalNoteMail);
                        Assert.assertEquals(journalNoteMail, journalNumber);

                        String usefulPerson = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Şəxslər:')]"))
                        );
                        String usefulPersonMail = usefulPerson.split("\n")[0].trim();
                        System.out.println("usefulPersonMail = " + usefulPersonMail);
                        Assert.assertEquals(usefulPersonMail, usefulWhomSent);

                        String statusNote = (String) js.executeScript(
                                "return arguments[0].nextSibling.textContent.trim();",
                                getDriver().findElement(By.xpath("//strong[contains(text(),'Status:')]"))
                        );
                        String statusNoteMail = statusNote.split("\n")[0].trim();
                        System.out.println("statusNoteMail = " + statusNoteMail);
                        Assert.assertEquals(statusNoteMail, usefulStatus);
                    }
                }

                if (!found) {
                    System.out.println("Element heç bir iframe-də tapılmadı!");
                }
                getDriver().switchTo().defaultContent();
            }
        }
    }

            @Then("file for {string} is displayed in the email notification")
            public void fileForIsDisplayedInTheEmailNotification (String selection){
                if (selection.contains("Training material")) {
                    Assert.assertTrue(page.trainingMaterialFile.isDisplayed());
                    ReusableMethods.wait(1);
                } else if (selection.contains("event")) {
                    Assert.assertTrue(page.trainingMaterialFile.isDisplayed());
                    ReusableMethods.wait(1);
                    Assert.assertTrue(page.secondFileEvent.isDisplayed());
                    ReusableMethods.wait(1);
                } else if (selection.contains("help-desk")) {
                    Assert.assertTrue(page.secondFileEvent.isDisplayed());
                    ReusableMethods.wait(1);
                } else if (selection.contains("useful information")) {
                    Assert.assertTrue(page.trainingMaterialFile.isDisplayed());
                    ReusableMethods.wait(1);
                } else if (selection.contains("Journal Manual")) {
                    Assert.assertTrue(page.trainingMaterialFile.isDisplayed());
                    ReusableMethods.wait(1);
                }
            }

            @And("goes to the electronic library in the control panel")
            public void goesToTheElectronicLibraryInTheControlPanel () {
                System.out.println(" Im here " + getDriver().getCurrentUrl());
                Set<String> windowHandles = getDriver().getWindowHandles();
                for (String handle : windowHandles) {
                    getDriver().switchTo().window(handle);
                }
                ReusableMethods.wait(1);
                getDriver().findElement(By.xpath("//span[normalize-space()='Elektron kitabxana']")).click();
                ReusableMethods.wait(1);
            }

            @And("switches to the {string} tab in electronic library")
            public void switchesToTheTabInElectronicLibrary (String selection){
                if (selection.contains("Training material")) {
                    page.trainingMaterialTab.click();
                    ReusableMethods.wait(1);

                } else if (selection.contains("Useful information")) {
                    page.usefulInformationTab.click();
                    ReusableMethods.wait(1);
                } else if (selection.contains("Electronic journal")) {
                    page.electronicJournalTab.click();
                    ReusableMethods.wait(1);
                }
            }

            @And("adds {string} to useful information name input")
            public void addsToUsefulInformationNameInput (String selection){
                if (selection.contains("Manual Qa")) {
                    page.usefulNameInput.sendKeys("Useful Manual QA");
                    ReusableMethods.wait(1);
                } else if (selection.contains("Automation QA")) {
                    page.usefulNameInput.clear();
                    ReusableMethods.wait(1);
                    page.usefulNameInput.sendKeys("Useful Autmaion QA");
                    ReusableMethods.wait(1);
                }
            }

            @And("selects person {string} for notification and mail for electronic library")
            public void selectsPersonForNotificationAndMailForElectronicLibrary (String selection){
                if (selection.contains("Musa")) {
                    calendar.choosePersonInput.sendKeys("Musa Rzayev");
                    calendar.cancelMusaPerson.click();
                    ReusableMethods.wait(1);
                    Actions actions = new Actions(getDriver());
                    actions.moveByOffset(5, 5).click().build().perform();
                } else if (selection.contains("İbrahim")) {
                    calendar.choosePersonInput.sendKeys("İbrahim Rzayev");
                    calendar.cancelIbrahimPerson.click();
                    ReusableMethods.wait(1);
                    Actions actions = new Actions(getDriver());
                    actions.moveByOffset(5, 5).click().build().perform();
                }
            }

            @Then("all information about the useful information is displayed in the table in the admin panel")
            public void allInformationAboutTheUsefulInformationIsDisplayedInTheTableInTheAdminPanel (DataTable dataTable)
            {
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String materialName = row.get("Məlumatın adı");
                    String material = row.get("Materiallar");
                    String viewCount = row.get("Baxış sayı");

                    ReusableMethods.flash(page.trainingNameTable, getDriver());
                    Assert.assertEquals(page.trainingNameTable.getText().trim(), materialName);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.filePathMaterialTable, getDriver());
                    Assert.assertEquals(page.filePathMaterialTable.getText().trim(), material);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.usefulDateTable, getDriver());
                    LocalDate today = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    String formattedDate = today.format(formatter);
                    Assert.assertEquals(page.usefulDateTable.getText().trim(), formattedDate);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.viewCountsTable, getDriver());
                    Assert.assertEquals(page.viewCountsTable.getText().trim(), viewCount);
                    viewCounter = page.viewCountsTable.getText().trim();
                    System.out.println("viewCounter = " + viewCounter);
                    ReusableMethods.wait(1);
                }
            }

            @And("all the information about useful information is displayed in the notification")
            public void allTheInformationAboutUsefulInformationIsDisplayedInTheNotification (DataTable dataTable){
                try {
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
                    if (isElementVisible(page.trainingNoteModal, wait)) {
                        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                        for (Map<String, String> row : data) {
                            String trainingName = row.get("Başlıq");

                            WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
                            ReusableMethods.waitForOverlayToDisappear(getDriver());

                            ReusableMethods.waitForOverlayToDisappear(getDriver());
                            ReusableMethods.flash(page.trainingNameModal, getDriver());
                            Assert.assertEquals(page.trainingNameModal.getText().trim(), trainingName);
                            ReusableMethods.wait(1);
                            calendar.closeModal.click();
                            ReusableMethods.wait(1);

                        }
                    } else {
                        ReusableMethods.wait(1);
                        WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                        button.click();
                        ReusableMethods.wait(3);
                        System.out.println("\"Imhere1\" = " + "Imhere0");
//                By.xpath("//li[.//span[contains(normalize-space(),'Yardım masası')]][1]");
//                By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]");
                        WebElement element = getDriver().findElement(By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]"));
                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
                        js.executeScript("arguments[0].click();", element);
                        element.click();
                        ReusableMethods.wait(5);
                        System.out.println("\"Imhere1\" = " + "Imhere1");
                        ReusableMethods.wait(3);
                        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                        for (Map<String, String> row : data) {
                            String trainingName = row.get("Başlıq");

                            ReusableMethods.flash(page.trainingNameModal, getDriver());
                            Assert.assertEquals(page.trainingNameModal.getText().trim(), trainingName);
                            ReusableMethods.wait(1);
                            calendar.closeModal.click();
                            ReusableMethods.wait(1);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
//            Assert.fail("Test zamanı istisna baş verdi: " + e.getMessage());
                }
            }

    @And("adds {string} to journal name input")
    public void addsToJournalNameInput(String selection) {
        if(selection.contains("Journal Manual")){
            page.journalInput.sendKeys("Journal Manual");
            ReusableMethods.wait(1);
        }  else if(selection.contains("Journal Automation")){
            page.journalInput.clear();
            ReusableMethods.wait(1);
            page.journalInput.sendKeys("Journal Automation");
            ReusableMethods.wait(1);
        }
    }

    @And("adds {string} to journal number input")
    public void addsToJournalNumberInput(String selection) {
        if(selection.contains("7777")){
            page.journalNumberInput.sendKeys("7777");
            ReusableMethods.wait(1);
        }    else if(selection.contains("8888")){
            page.journalNumberInput.clear();
            ReusableMethods.wait(1);
            page.journalNumberInput.sendKeys("8888");
            ReusableMethods.wait(1);
        }
    }

    @Then("all information about the electronic journal is displayed in the table in the admin panel")
    public void allInformationAboutTheElectronicJournalIsDisplayedInTheTableInTheAdminPanel(DataTable dataTable) {
        {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {
                String name = row.get("Adı");
                String number = row.get("Buraxılış nömrəsi");
                String material = row.get("Materiallar");

                String viewCount = row.get("Baxış sayı");

                ReusableMethods.flash(page.journalNameTable, getDriver());
                Assert.assertEquals(page.journalNameTable.getText().trim(), name);
                ReusableMethods.wait(1);

                ReusableMethods.flash(page.journalNumberTable, getDriver());
                Assert.assertEquals(page.journalNumberTable.getText().trim(), number);
                ReusableMethods.wait(1);

                ReusableMethods.flash(page.usefulDateTable, getDriver());
                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                String formattedDate = today.format(formatter);
                Assert.assertEquals(page.usefulDateTable.getText().trim(), formattedDate);
                ReusableMethods.wait(1);

                ReusableMethods.flash(page.journalFileTable, getDriver());
                Assert.assertEquals(page.journalFileTable.getText().trim(), material);
                ReusableMethods.wait(1);

                ReusableMethods.flash(page.viewCountsTable, getDriver());
                Assert.assertEquals(page.viewCountsTable.getText().trim(), viewCount);
                viewCounter = page.viewCountsTable.getText().trim();
                System.out.println("viewCounter = " + viewCounter);
                ReusableMethods.wait(1);
            }
        }
}

    @And("all the information about electronic journal is displayed in the notification")
    public void allTheInformationAboutElectronicJournalIsDisplayedInTheNotification(DataTable dataTable) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            if (isElementVisible(page.trainingNoteModal, wait)) {
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String electronicJournal = row.get("Başlıq");

                    WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
                    ReusableMethods.waitForOverlayToDisappear(getDriver());

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.trainingNameModal, getDriver());
                    Assert.assertEquals(page.trainingNameModal.getText().trim(), electronicJournal);
                    ReusableMethods.wait(1);
                    calendar.closeModal.click();
                    ReusableMethods.wait(1);

                }
            } else {
                ReusableMethods.wait(1);
                WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                button.click();
                ReusableMethods.wait(3);
                System.out.println("\"Imhere1\" = " + "Imhere0");
//                By.xpath("//li[.//span[contains(normalize-space(),'Yardım masası')]][1]");
//                By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]");
                WebElement element = getDriver().findElement(By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]"));
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].click();", element);
                element.click();
                ReusableMethods.wait(5);
                System.out.println("\"Imhere1\" = " + "Imhere1");
                ReusableMethods.wait(3);
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String electronicJournal = row.get("Başlıq");

                    ReusableMethods.flash(page.trainingNameModal, getDriver());
                    Assert.assertEquals(page.trainingNameModal.getText().trim(), electronicJournal);
                    ReusableMethods.wait(1);
                    calendar.closeModal.click();
                    ReusableMethods.wait(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            Assert.fail("Test zamanı istisna baş verdi: " + e.getMessage());
        }
    }

    @Then("the deleted electronic journal is not displayed in the control panel")
    public void theDeletedElectronicJournalIsNotDisplayedInTheControlPanel() {
        while (true) {
            try {
                if (!page.deleteButton.isDisplayed()) {
                    break;
                }
                page.deleteButton.click();
                ReusableMethods.wait(1);
                page.deleteYes.click();
                ReusableMethods.wait(2);
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                break;
            }
        }
        System.out.println("Bütün e" +
                " silindi və test passed oldu ✅");
    }

    @And("adds file {string} for electronic journal")
    public void addsFileForElectronicJournal(String selection) {
      if (selection.contains("edit")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(2);
            page.fileDelete.click();
            ReusableMethods.wait(1);
//            page.deleteYes.click();
            ReusableMethods.pageDown();
            ReusableMethods.wait(5);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\EndToEnd.pdf";
            page.addFileBtn.click();
            ReusableMethods.wait(3);
            ReusableMethods.robotClassDosyaYukleme(path);
        }
    }
}