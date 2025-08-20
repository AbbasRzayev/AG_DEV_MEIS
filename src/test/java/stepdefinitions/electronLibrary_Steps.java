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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static stepdefinitions.calendar_Steps.isElementVisible;
import static utilities.Driver.getDriver;

public class electronLibrary_Steps {

    static electronLibrary_Page page = new electronLibrary_Page();
    loginAndLogOut_Page pageSecond = new loginAndLogOut_Page();
    calendar_Page calendar = new calendar_Page();
    String viewCounter;

    @And("selects new training button in the training materials tab")
    public void selectsNewTrainingButtonInTheTrainingMaterialsTab() {
        page.newTrainingBtn.click();
        ReusableMethods.wait(1);
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
            ReusableMethods.wait(1);
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

    @And("adds tittle name to tittle name input")
    public void addsTittleNameToTittleNameInput() {
        page.tittleInput.sendKeys("Grow uP");
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

    @When("user selects delete button in the new useful information tab")
    public void userSelectsDeleteButtonInTheNewUsefulInformationTab() {
        WebElement itemRow = getDriver().findElement(By.xpath("//td[contains(text(),'Grow uP')]/ancestor::tr"));
        WebElement deleteButton = itemRow.findElement(By.cssSelector(".mat-icon.mat-warn"));
        deleteButton.click();
        ReusableMethods.wait(1);
        page.deleteYes.click();
//        deleteButton.click();
//        ReusableMethods.wait(1);
    }

    @Then("newly added useful successfully deleted")
    public void newlyAddedUsefulSuccessfullyDeleted() {
        getDriver().navigate().refresh();
        ReusableMethods.wait(1);
        String text = "Grow Up";
        ReusableMethods.assertElementDeleted(getDriver(), text);
    }

    @And("selects person {string} for notification and mail")
    public void selectsPersonForNotificationAndMail(String selection) {
        if (selection.contains("Musa")) {
            calendar.choosePersonInputSecond.sendKeys("Musa Rzayev");
            calendar.cancelMusaPerson.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveByOffset(5, 5).click().build().perform();
        } else  if (selection.contains("İbrahim")) {
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
        }   else if (selection.contains("İbrahim")) {
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
            ReusableMethods.wait(2);
            ReusableMethods.robotClassDosyaYukleme(path);
        }
        else if(selection.contains("edit")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            page.fileDelete.click();
            ReusableMethods.wait(1);
            page.deleteYes.click();
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\EndToEnd.pdf";
            page.addFileBtn.click();
            ReusableMethods.wait(2);
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
        page.electronicLibraryTabAdmin.click();
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
        ReusableMethods.wait(2);
    }

    @When("user closes the document view modal window")
    public void userClosesTheDocumentViewModalWindow() {
        new Actions(getDriver()).sendKeys(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
    }

    @Then("an increase is observed in the view count data")
    public void anIncreaseIsObservedInTheViewCountData() {
        ReusableMethods.flash(page.viewCountsTable,getDriver());
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
}