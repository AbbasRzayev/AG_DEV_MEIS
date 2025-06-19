package stepdefinitions;

import Page.electronLibrary_Page;
import Page.loginAndLogOut_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class electronLibrary_Steps {

    static electronLibrary_Page page = new electronLibrary_Page();
    loginAndLogOut_Page pageSecond = new loginAndLogOut_Page();

    //    @And("goes to the electronic library tab from personal cabinet")
//    public void goesToTheElectronicLibraryTabFromPersonalCabinet() {
//        page.electronicLibTab.click();
//        ReusableMethods.wait(1);
//    }
//
//    @And("selects new training button in the training materials tab")
//    public void selectsNewTrainingButtonInTheTrainingMaterialsTab() {
//
//    }
//
//    @And("adds <{string}> to training name input")
//    public void addsToTrainingNameInput(String arg0) {
//
//    }
    @And("goes to the electronic library tab from personal cabinet")
    public void goesToTheElectronicLibraryTabFromPersonalCabinet() {
        System.out.println("page = " + getDriver().getCurrentUrl());
        ReusableMethods.waitForClickabilityAndClick(page.electronicLibTab, 5);
        ReusableMethods.wait(1);
    }


    @And("selects new training button in the training materials tab")
    public void selectsNewTrainingButtonInTheTrainingMaterialsTab() {
        page.newTraningBtn.click();
        ReusableMethods.wait(1);
    }

    @And("adds {string} to training name input")
    public void addsToTrainingNameInput(String arg0) {
        if (arg0.contains("Daxili təlim")) {
            page.traningName.sendKeys("Daxili təlim");
            ReusableMethods.wait(1);
        } else if (arg0.contains("Kənardan təlim")) {
            page.traningName.sendKeys("Kənardan təlim");
            ReusableMethods.wait(1);
        }
    }

    @And("selects one of the two {string}")
    public void selectsOneOfTheTwo(String arg0) {
        if (arg0.contains("firstcase")) {
            page.checkBoxesInnerTraniner.click();
            ReusableMethods.wait(1);
        } else if (arg0.contains("secondcase")) {
            page.checkBoxesExternalTrainer.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds instructor from search list")
    public void addsInstructorFromSearchList() {
        if (page.inner.isSelected()) {
            page.trainSearch.click();
            ReusableMethods.wait(1);
            page.chooseFromList.click();
            page.closeList.click();
            ReusableMethods.wait(1);
        } else if (page.foregin.isSelected()) {
            ReusableMethods.wait(1);
            page.instructorNameInput.sendKeys("Teacher of Qa");
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

    @And("adds note to the note input")
    public void addsNoteToTheNoteInput() {
        page.noteInput.sendKeys("However, successful automation implementation necessitates careful planning, strategic alignment, and ongoing optimization.");
        ReusableMethods.wait(1);
    }

    @When("user selects sava button")
    public void userSelectsSavaButton() {
        page.saveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("new {string} successfully added")
    public void newSuccessfullyAdded(String arg0) {
        if (arg0.contains("firstcase")) {
            ReusableMethods.flash(page.checkİnnerName, getDriver());
            assertTrue(page.checkİnnerName.isDisplayed());
        } else if (arg0.contains("secondcase")) {
            ReusableMethods.flash(page.checkForein, getDriver());
            assertTrue(page.checkForein.isDisplayed());
        }
    }

    @And("user edit newly added material by using {string}")
    public void userEditNewlyAddedMaterialByUsing(String arg0) {
        if (arg0.contains("firstcase")) {
            String text = "Daxili təlim";
            EditButtonForString1(text);
            ReusableMethods.wait(1);
            page.traningEditName.clear();
            page.traningEditName.sendKeys("DAXİLİ TƏLİM");
            ReusableMethods.wait(1);
            page.trainSearch.click();
            page.chooseEditFromList.click();
            page.closeList.click();
            ReusableMethods.wait(1);
            ReusableMethods.clearTextBox(page.dateEditInput);
            //page.dateEditInput.clear();
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = today.format(formatter);
            page.dateEditInput.sendKeys(formattedDate);
            ReusableMethods.wait(2);
            page.addEditFileBtn.click();
            String tex1t = "file:///C:/Users/User/Desktop/TestFiles/ChangeDoc.pdf";
            ReusableMethods.robotClassDosyaYukleme(tex1t);
            ReusableMethods.wait(2);
            page.editYesBtn.click();
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

    @Then("newly added material succssfully {string}")
    public void newlyAddedMaterialSuccssfully(String arg0) {
        if (arg0.contains("firstcase")) {
            String name = "DAXİLİ TƏLİM";
            String instruc = "ABBAS RZAYEV, Fərid İmranov";
        }
    }

    @When("user selects delete button on the {string} added material")
    public void userSelectsDeleteButtonOnTheAddedMaterial(String arg0) {
        if (arg0.contains("Daxili təlim")) {
            ReusableMethods.wait(2);
            String text2 = "Daxili təlim";
            DeleteButtonForString2(text2);
            ReusableMethods.waitForClickability(page.deleteYes, 3);
            page.deleteYes.click();
        } else if (arg0.contains("Kənardan təlim")) {
            ReusableMethods.wait(2);
            String text2 = "Kənardan təlim";
            DeleteButtonForString2(text2);
            ReusableMethods.waitForClickability(page.deleteYes, 3);
            page.deleteYes.click();
        }
    }

    public static void DeleteButtonForString2(String text) {
        // Find the row containing the specified text
        WebElement row = getDriver().findElement(By.xpath("//td[contains(text(), '" + text + "')]//ancestor::tr"));
        ReusableMethods.wait(2);
        // Find the edit button within the row
        WebElement deleteButton = row.findElement(By.xpath(".//mat-icon[@class='mat-icon notranslate mat-warn material-icons mat-ligature-font' and contains(text(), 'delete')]"));
        deleteButton.click();
    }

    @Then("newly added material successfully {string}")
    public void newlyAddedMaterialSuccessfully(String arg0) {
        if (arg0.contains("firstcase")) {
            ReusableMethods.wait(2);
            String text = "Daxili təlim";
            ReusableMethods.assertElementDeleted(getDriver(), text);
        } else if (arg0.contains("secondcase")) {
            ReusableMethods.wait(2);
            String text = "Kənardan təlim";
            ReusableMethods.assertElementDeleted(getDriver(), text);
        }
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

    @And("selects person for notification and mail")
    public void selectsPersonForNotificationAndMail() {
        page.selectNotPersomForTrain.sendKeys("Fərid İmranov");
        ReusableMethods.wait(1);
        WebElement namePerson = getDriver().findElement(By.xpath("//label[contains(.,'Fərid İmranov')]"));
        namePerson.click();
        ReusableMethods.wait(1);
    }

    @And("selects person for the who sees field")
    public void selectsPersonForTheWhoSeesField() {
        page.selectPersomForWhoSees.click();
        ReusableMethods.wait(1);
        WebElement selectWhoSe = getDriver().findElement(By.xpath("(//span[text()='Ünvanlanmış şəxslərə görə'])[2]"));
        selectWhoSe.click();
        ReusableMethods.wait(1);
        WebElement clickPerson = getDriver().findElement(By.xpath("(//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-25']//input)[1]"));
//        clickPerson.sendKeys("Fərid İmranov");
//        WebElement namePerson = getDriver().findElement(By.xpath("//label[contains(.,'Fərid İmranov')]"));
//        namePerson.click();
        ReusableMethods.wait(1);
    }

    @And("adds file for training")
    public void addsFileForTraining() {
        String file = "C:\\Users\\User\\Desktop\\TestFiles\\Document.pdf";
        page.addFileBtn.click();
        ReusableMethods.wait(2);
        ReusableMethods.robotClassDosyaYukleme(file);
    }


    String trainingMaterialsInitial;
    Integer trainingCountMaterialsInitial;
    @Then("gets the information of the initial {string} of the file for training materials")
    public void getsTheInformationOfTheInitialOfTheFileForTrainingMaterials(String count) {
        if(count.contains("Daxili"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Daxili təlim')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[6]"));
            ReusableMethods.flash(viewCountCell,getDriver());
            trainingMaterialsInitial = viewCountCell.getText();
            System.out.println("viewCountText = " + trainingMaterialsInitial);
            String trainingMaterialsInitialCount = trainingMaterialsInitial.replaceAll(".*\\((\\d+)\\).*", "$1");
            trainingCountMaterialsInitial = Integer.parseInt(trainingMaterialsInitialCount);
        }
        else if(count.contains("Kənar")){
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Kənardan təlim')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[6]"));
            ReusableMethods.flash(viewCountCell,getDriver());
            trainingMaterialsInitial = viewCountCell.getText();
            System.out.println("viewCountText = " + trainingMaterialsInitial);
            String trainingMaterialsInitialCount = trainingMaterialsInitial.replaceAll(".*\\((\\d+)\\).*", "$1");
            trainingCountMaterialsInitial = Integer.parseInt(trainingMaterialsInitialCount);
        }
    }
    Integer expectCountFileTraningIncrease;
    String trainingMaterialsInitialSecond;
    Integer actualFileTraning;

    @Then("counter of the information folder is displayed correctly due to the {string} of the file for training materials")
    public void counterOfTheInformationFolderIsDisplayedCorrectlyDueToTheOfTheFileForTrainingMaterials(String increase) {
        if(increase.contains("Daxili"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Daxili təlim')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[6]"));
            ReusableMethods.flash(viewCountCell,getDriver());
            expectCountFileTraningIncrease = trainingCountMaterialsInitial + 1;
            System.out.println("expectCount = " + expectCountFileTraningIncrease);
            trainingMaterialsInitialSecond = viewCountCell.getText();
            System.out.println("viewCountText = " + trainingMaterialsInitialSecond);
            String trainingMaterialsInitialCount = trainingMaterialsInitialSecond.replaceAll(".*\\((\\d+)\\).*", "$1");
            actualFileTraning = Integer.parseInt(trainingMaterialsInitialCount);
            Assert.assertEquals(expectCountFileTraningIncrease, actualFileTraning);
        }
        else if (increase.contains("Kənar"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Kənardan təlim')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[6]"));
            ReusableMethods.flash(viewCountCell,getDriver());
            expectCountFileTraningIncrease = trainingCountMaterialsInitial + 1;
            System.out.println("expectCount = " + expectCountFileTraningIncrease);
            trainingMaterialsInitialSecond = viewCountCell.getText();
            System.out.println("viewCountText = " + trainingMaterialsInitialSecond);
            String trainingMaterialsInitialCount = trainingMaterialsInitialSecond.replaceAll(".*\\((\\d+)\\).*", "$1");
            actualFileTraning = Integer.parseInt(trainingMaterialsInitialCount);
            Assert.assertEquals(expectCountFileTraningIncrease, actualFileTraning);
        }
    }
    @When("user upload the {string} from table")
    public void userUploadTheFromTable(String count) {
        if (count.contains("Daxili")) {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Daxili təlim')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[5]"));
            viewCountCell.click();
            ReusableMethods.wait(1);
            WebElement fileSelect = getDriver().findElement(By.xpath("//a[text()=' Fayl ']"));
            fileSelect.click();
            ReusableMethods.wait(1);
            getDriver().navigate().refresh();

        } else if (count.contains("Kənar")) {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Kənardan təlim')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[5]"));
            viewCountCell.click();
            ReusableMethods.wait(1);
            WebElement fileSelect = getDriver().findElement(By.xpath("//a[text()=' Fayl ']"));
            fileSelect.click();
            ReusableMethods.wait(1);
            getDriver().navigate().refresh();

        }
        else if(count.contains("file for useful information"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Grow uP')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[4]"));
            viewCountCell.click();
            ReusableMethods.wait(1);
            WebElement fileSelect = getDriver().findElement(By.xpath("//a[text()=' Fayl ']"));
            fileSelect.click();
            ReusableMethods.wait(1);
            getDriver().navigate().refresh();
        }
        else if(count.contains("file for electron journal"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Qa Journal')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[4]"));
            viewCountCell.click();
            ReusableMethods.wait(1);
            WebElement fileSelect = getDriver().findElement(By.xpath("//a[text()=' Fayl ']"));
            fileSelect.click();
            ReusableMethods.wait(1);
            getDriver().navigate().refresh();
        }
    }
    String usefulInformationInitial;
    Integer usefulInformationCountInitial;
    String electronJournalInitial;
    Integer electronJournalCountInitial;

    @Then("gets the information of the initial counter of the file for {string}")
    public void getsTheInformationOfTheInitialCounterOfTheFileFor(String initial) {
        if(initial.contains("useful information"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Grow uP')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[5]"));
            ReusableMethods.flash(viewCountCell,getDriver());
            usefulInformationInitial = viewCountCell.getText();
            System.out.println("viewCountText = " + usefulInformationInitial);
            String trainingMaterialsInitialCount = usefulInformationInitial.replaceAll(".*\\((\\d+)\\).*", "$1");
            usefulInformationCountInitial = Integer.parseInt(trainingMaterialsInitialCount);
        }
        else if(initial.contains("electron journal"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Qa Journal')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[7]"));
            ReusableMethods.flash(viewCountCell,getDriver());
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
        if(count.contains("useful information"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Grow uP')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[5]"));
            ReusableMethods.flash(viewCountCell,getDriver());
            expectCountFileUsefulInformation = usefulInformationCountInitial + 1;
            System.out.println("expectCount = " + expectCountFileUsefulInformation);
            usefulInformationInitialSecond = viewCountCell.getText();
            System.out.println("viewCountText = " + usefulInformationInitialSecond);
            String usefulinfotmationInitialCount = usefulInformationInitialSecond.replaceAll(".*\\((\\d+)\\).*", "$1");
            actualFileTraning = Integer.parseInt(usefulinfotmationInitialCount);
            Assert.assertEquals(expectCountFileUsefulInformation, actualFileTraning);
        }
        else if(count.contains("electron journal"))
        {
            WebElement table = getDriver().findElement(By.className("mat-mdc-table"));
            WebElement row = table.findElement(By.xpath("//tr[td[contains(text(), 'Qa Journal')]]"));
            WebElement viewCountCell = row.findElement(By.xpath(".//td[7]"));
            ReusableMethods.flash(viewCountCell,getDriver());
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
}
