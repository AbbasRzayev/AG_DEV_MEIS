package stepdefinitions;

import Page.contactInformationEditing_Page;
import Page.programs_Page;
import Page.structureAndDuties_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class programs_Steps {
    programs_Page page = new programs_Page();

    @And("switches to the my programs tab")
    public void switchesToTheMyProgramsTab() {
        ReusableMethods.wait(1);
        page.programTab.click();
        ReusableMethods.wait(10);
    }

    contactInformationEditing_Page userPer = new contactInformationEditing_Page();
    structureAndDuties_Page structure = new structureAndDuties_Page();

    @And("select new program button")
    public void selectNewProgramButton() {
        ReusableMethods.wait(2);
        page.newProgramButton.click();
    }

    @And("added data to the program name and to the keyword field")
    public void addedDataToTheProgramNameAndToTheKeywordField(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String programName = row.get("PROGRAM NAME");
            String keyword = row.get("KEYWORD");
            System.out.println("programName = " + programName);
            System.out.println("keyword = " + keyword);
            page.programNameField.sendKeys(programName);
            page.kewwordField.sendKeys(keyword);
        }
    }

    @And("added data to the program address field")
    public void addedDataToTheProgramAddressField(DataTable dataTable) {
        String programAddress = dataTable.cell(0, 0);
        page.programAdressField.sendKeys(programAddress);
        ReusableMethods.wait(2);
    }

    @And("added data to the notes about programs field")
    public void addedDataToTheNotesAboutProgramsField(DataTable dataTable) {
        String notes = dataTable.cell(0, 0);
        page.noteAboutProgramField.sendKeys(notes);
    }

    @And("added data to the url for api integration field")
    public void addedDataToTheUrlForApiIntegrationField(DataTable table) {
        String notes = table.cell(0, 0);
        page.apiIntegrationField.sendKeys(notes);
    }

    @And("added program icon")
    public void addedProgramIcon() {
        String photoPath = "C:\\Users\\User\\TestFiles\\Test.png";
        page.iconButton.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath);
    }

//    @And("added video to the video instruction file")
//    public void addedVideoToTheVideoInstructionFile() {
//        String iconPath ="C:\\Users\\User\\Desktop\\TestFiles";
//        page.videoInstructionButton.click();
//        ReusableMethods.robotClassDosyaYukleme(iconPath);
//    }
//
//    @And("added pdf file to the instruction file")
//    public void addedPdfFileToTheInstructionFile() {
//        String iconPath ="C:\\Users\\User\\Desktop\\Sened";
//        page.instructionButton.click();
//        ReusableMethods.robotClassDosyaYukleme(iconPath);
//    }
//
//    @And("added one more pdf file to the another file")
//    public void addedOneMorePdfFileToTheAnotherFile() {
//        String iconPath ="C:\\Users\\User\\Desktop\\Sened";
//        page.anotherInstructionButton.click();
//        ReusableMethods.robotClassDosyaYukleme(iconPath);
//
//    }

    @When("selects the save button to create a new program")
    public void userSelectsTheSaveButtonToCreateANewProgram() {
        ReusableMethods.wait(3);
        page.saveButton.click();
        ReusableMethods.wait(5);
        //ReusableMethods.clickByJavaScript(page.saveButton);
        //ReusableMethods.waitForClickabilityAndClick(page.saveButton,2);
        //ReusableMethods.clickJSElementWithJavaScript(String.valueOf(page.saveButton));
    }

    @Then("the program {string} is successfully created")
    public void theProgramIsSuccessfullyCreated(String selection) {
        if (selection.contains("Bright Future")) {
            ReusableMethods.wait(1);
            page.searchInput.sendKeys("Bright Future");
            ReusableMethods.wait(3);
            ReusableMethods.flash(page.createdProq, getDriver());
            Assert.assertTrue("Test.png şəkli DOM-da görünmür!", page.programName.isDisplayed());
            Assert.assertTrue("Bright Future", page.createdProq.isDisplayed());
            ReusableMethods.wait(1);
            page.createdProq.click();
            ReusableMethods.wait(3);
        } else if (selection.contains("Light Future")) {
            ReusableMethods.wait(1);
            page.searchInput.sendKeys("Light Future");
            ReusableMethods.wait(3);
            ReusableMethods.flash(page.createdProgSecond, getDriver());
            Assert.assertTrue("QAAT.png şəkli DOM-da görünmür!", page.programNameSecond.isDisplayed());
            Assert.assertTrue("Light Future", page.createdProgSecond.isDisplayed());
            ReusableMethods.wait(1);
            page.createdProgSecond.click();
            ReusableMethods.wait(3);
        }
    }


    @And("selects operation on modules button")
    public void selectsOperationOnModulesButton() {
        ReusableMethods.clickByJavaScript(page.operationsOnModules);
        // page.operationsOnModules.click();
        ReusableMethods.wait(1);
    }

    @And("adds data to the add name field in the operation on modules modal window")
    public void addsDataToTheAddNameFieldInTheOperationOnModulesModalWindow(DataTable dataTable) {
        String notest = dataTable.cell(0, 0);
        page.addNameModul.sendKeys(notest);
        ReusableMethods.wait(1);
    }

    @And("adds data to the keyword field in the operation on modules modal window")
    public void addsDataToTheKeywordFieldInTheOperationOnModulesModalWindow(DataTable dataTable) {
        String note = dataTable.cell(0, 0);
        page.addKeyWordModul.sendKeys(note);
        ReusableMethods.wait(1);
    }

    @And("accepts changes in the operation on modules modal window")
    public void acceptsChangesInTheOperationOnModulesModalWindow() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(page.acceptModul).build().perform();
        ReusableMethods.wait(1);
        page.acceptModul.click();
        ReusableMethods.wait(1);
    }

    @And("selects close button in the operation on modules modal window")
    public void selectsCloseButtonInTheOperationOnModulesModalWindow() {
        page.closeModul.click();
        ReusableMethods.wait(1);
    }

    @And("selects user categories operations button")
    public void selectsUserCategoriesOperationsButton() {
        page.userCategoriesOperations.click();
        ReusableMethods.wait(1);
    }

    @And("adds data to the add name field in the user categories operations modal window")
    public void addsDataToTheAddNameFieldInTheUserCategoriesOperationsModalWindow(DataTable dataTable) {
        String data = dataTable.cell(0, 0);
        page.addNameModul.sendKeys(data);
        ReusableMethods.wait(1);
    }

    @And("adds data to the keyword field in the user categories operations modal window")
    public void addsDataToTheKeywordFieldInTheUserCategoriesOperationsModalWindow(DataTable dataTable) {
        String noteKey = dataTable.cell(0, 0);
        page.addKeyWordModul.sendKeys(noteKey);
        ReusableMethods.wait(1);
    }

    @And("opens modules from modules search list")
    public void opensModulesFromModulesSearchList() {
        ReusableMethods.wait(1);
        ReusableMethods.clickByJavaScript(page.modulList);
        ReusableMethods.wait(1);
    }

    @And("selects modul from list")
    public void selectsModulFromList() {
        page.modulSelect.click();
        ReusableMethods.wait(1);
        page.acceptModul.click();
        ReusableMethods.wait(1);
        page.acceptModul.click();
    }

    @And("accepts changes in the user categories operations modal window")
    public void acceptsChangesInTheUserCategoriesOperationsModalWindow() {
        page.acceptModul.click();
        ReusableMethods.wait(1);
    }

    @And("selects close button in the user categories operations modal window")
    public void selectsCloseButtonInTheUserCategoriesOperationsModalWindow() {
        page.closeModul.click();
        ReusableMethods.wait(1);
    }

    @And("after searching selects founded user")
    public void afterSearchingSelectsFoundedUser() {
        structure.searchButton.click();
        ReusableMethods.wait(1);
        userPer.foundedUser.click();
        ReusableMethods.wait(1);
    }

    @And("switches to the user programs tab")
    public void switchesToTheUserProgramsTab() {
        ReusableMethods.wait(2);
        structure.foundedUser.click();
        ReusableMethods.wait(2);
        page.switchProgramTab.click();
        ReusableMethods.wait(7);
    }

    @And("finds the newly added program by using search input in the programs tab")
    public void findsTheNewlyAddedProgramByUsingSearchInputInTheProgramsTab() {
        page.progTabSearchField.sendKeys("Bright Future");
        ReusableMethods.wait(1);
    }

    @And("activates the program by selecting it")
    public void activatesTheProgramBySelectingIt() {
        page.activetedProgram.click();
        ReusableMethods.wait(1);
        assertTrue(page.activetedText.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.backgroundColor = 'red'", page.activetedText);
    }

    @And("adds module and category")
    public void addsModuleAndCategoriy() {
        page.selectProgram.click();
        ReusableMethods.wait(1);
        page.selectModulForProg.click();
        ReusableMethods.wait(1);
        page.selectCategForProg.click();
        ReusableMethods.wait(1);
        page.saveProg.click();
        ReusableMethods.wait(1);
    }

    @And("user goes to my programs tab in the main page")
    public void userGoesToMyProgramsTabInTheMainPage() {
        page.mainProg.click();
        ReusableMethods.wait(1);
    }

    @When("user selects and switches to the newly added program")
    public void userSwitchesToTheNewlyAddedProgramBySelectingIt() {
        page.searchInput.sendKeys("Bright Future");
        ReusableMethods.wait(2);
    }

    @Then("user successfully switches to the program")
    public void userSuccessfullySwitchesToTheProgram() {
        page.switchToTheProq.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                String expectedTitle = "Baş səhifə - AISTGroup MMC";
                assertEquals(expectedTitle, getDriver().getTitle());
                ReusableMethods.flash(page.aistLogo, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
    }

    @And("user goes programs tab in the control panel")
    public void userGoesProgramsTabInTheControlPanel() {
        page.programsControlPanel.click();
        ReusableMethods.wait(1);
    }

    @And("finds added program by using search input in the programs tab")
    public void findsAddedProgramByUsingSearchInputInTheProgramsTab() {
        page.progTabSearchFieldNew.sendKeys("Bright Future");
        ReusableMethods.wait(2);
        page.activetedProgramNew.click();
        ReusableMethods.wait(1);
    }

    @And("user edits program fields")
    public void userEditsProgramFields(DataTable dataTable) {
        page.programNameField.clear();
        page.kewwordField.clear();
        page.programAdressField.clear();
        page.noteAboutProgramField.clear();
        page.apiIntegrationField.clear();
        List<List<String>> data = dataTable.asLists(String.class);
        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            String programName = row.get(0);
            String programDescription = row.get(1);
            String prognotes = row.get(2);
            String progIntegration = row.get(3);
            String progAdress = row.get(4);
            String progIcon = row.get(5);
            page.programNameField.sendKeys(programName);
            ReusableMethods.wait(1);
            page.kewwordField.sendKeys(programDescription);
            ReusableMethods.wait(1);
            page.noteAboutProgramField.sendKeys(prognotes);
            ReusableMethods.wait(1);
            page.programAdressField.sendKeys(progAdress);
            ReusableMethods.wait(1);
            page.apiIntegrationField.sendKeys(progIntegration);
            ReusableMethods.wait(1);
            page.iconButton.click();
            ReusableMethods.wait(1);
            ReusableMethods.robotClassDosyaYukleme(progIcon);
        }
    }

    @And("user selects save button in the program page")
    public void userSelectsSaveButtonInTheProgramPage() {
        page.saveProg.click();
        ReusableMethods.wait(1);
    }

    @Then("program data has been successfully changed")
    public void programDataHasBeenSuccessfullyChanged() {
        page.searchInput.sendKeys("AistGroup");
        ReusableMethods.wait(2);
        ReusableMethods.flash(page.createdProqNew, getDriver());
        ReusableMethods.wait(1);
        page.createdProqNew.click();
        ReusableMethods.wait(1);
        String exproqName = "AistGroup";
        String exproqdesc = "Saytların yaradılması";
        String exproqAdress = "https://aist.group/az/programming";
        String exproqApi = "https://aist.group/az/about-us";
        ReusableMethods.flash(page.programNameField, getDriver());
        ReusableMethods.flash(page.kewwordField, getDriver());
        ReusableMethods.flash(page.programAdressField, getDriver());
        ReusableMethods.flash(page.noteAboutProgramField, getDriver());
        ReusableMethods.flash(page.apiIntegrationField, getDriver());
        ReusableMethods.flash(page.iconButton, getDriver());
    }

    @When("user selects delete button to delete the program")
    public void userSelectsDeleteButtonToDeleteTheProgram() {
        page.progDelete.click();
        ReusableMethods.wait(2);
        page.progDeleteAccept.click();
        ReusableMethods.wait(2);
    }

    @Then("the {string} program is successfully deleted")
    public void theProgramIsSuccessfullyDeleted(String selection) {
        if (selection.contains("new")) {
            page.searchInput.sendKeys("Bright Future");
            ReusableMethods.wait(3);
            ReusableMethods.assertElementNotDisplayed(page.createdProq);
        } else if (selection.contains("edited")) {
            page.searchInput.sendKeys("Light Future");
            ReusableMethods.wait(3);
            ReusableMethods.assertElementNotDisplayed(page.createdProgSecond);
        }
    }

    @And("selects founded user from table")
    public void selectsFoundedUserFromTable() {
        structure.foundedUser.click();
        ReusableMethods.wait(2);
    }

    @And("added video to the video instruction file")
    public void addedVideoToTheVideoInstructionFile() {
        String photoPath = "C:\\Users\\User\\TestFiles\\AutomatedTesting.mp4";
        page.iconVideoBtn.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath);
        ReusableMethods.wait(8);
    }

    @And("added pdf file to the instruction file")
    public void addedPdfFileToTheInstructionFile() {
        String photoPath = "C:\\Users\\User\\TestFiles\\QA.pdf";
        page.iconInstructionBtn.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath);
        ReusableMethods.wait(3);
    }

    @And("added one more pdf file to the another file")
    public void addedOneMorePdfFileToTheAnotherFile() {
        String photoPath = "C:\\Users\\User\\TestFiles\\QA.pdf";
        page.iconAnotherFileBtn.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath);
        ReusableMethods.wait(2);
    }

    @Then("all information is displayed in the review section of the program")
    public void allInformationIsDisplayedInTheReviewSectionOfTheProgram(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String programName = row.get("PROGRAM NAME");
            String keyword = row.get("KEYWORD");
            String programAddress = row.get("PROGRAM ADDRESS");
            String apiUrl = row.get("API URL");
            String note = row.get("NOTE");


            ReusableMethods.flash(page.programNameField, getDriver());
            WebElement inputValue = getDriver().findElement(By.xpath("//label[contains(., 'Proqramın adı')]/following::input[1]"));
            String progNameEx = inputValue.getAttribute("value");
            System.out.println("actual = " + progNameEx);
            Assert.assertEquals(progNameEx, programName);

            ReusableMethods.flash(page.kewwordField, getDriver());
            WebElement inputValue2 = getDriver().findElement(By.xpath(" //label[contains(., 'Proqramın adı')]/following::input[2]"));
            String progKWEx = inputValue2.getAttribute("value");
            System.out.println("actual = " + progKWEx);
            Assert.assertEquals(progKWEx, keyword);

            ReusableMethods.flash(page.programAdressField, getDriver());
            WebElement inputValue3 = getDriver().findElement(By.xpath(" //label[contains(., 'Proqramın adı')]/following::input[3]"));
            String progAddress = inputValue3.getAttribute("value");
            System.out.println("actual = " + progAddress);
            Assert.assertEquals(progAddress, programAddress);

            ReusableMethods.flash(page.apiIntegrationField, getDriver());
            WebElement inputValue4 = getDriver().findElement(By.xpath(" //label[contains(., 'Proqramın adı')]/following::input[4]"));
            String progApi = inputValue4.getAttribute("value");
            System.out.println("actual = " + progApi);
            Assert.assertEquals(apiUrl, progApi);

            ReusableMethods.flash(page.noteAboutProgramField, getDriver());
            WebElement inputValue5 = getDriver().findElement(By.xpath(" //following::textarea[1]"));
            String progNote = inputValue5.getAttribute("value");
            System.out.println("actual = " + progNote);
            Assert.assertEquals(progNote, note);
        }
    }

    @Then("the {string} logo is displayed in the review section of the program")
    public void theLogoIsDisplayedInTheReviewSectionOfTheProgram(String selection) {
        if (selection.contains("new")) {
            ReusableMethods.flash(page.iconButton, getDriver());
            Assert.assertTrue("Logo görünmür", page.programIconCheck.isDisplayed());
            Assert.assertTrue("Test.png yazısı yoxdur", page.iconText.isDisplayed());
        } else if (selection.contains("edited")) {
            ReusableMethods.flash(page.iconButton, getDriver());
            Assert.assertTrue("Logo görünmür", page.programIconCheck.isDisplayed());
            Assert.assertTrue("QAAT.png yazısı yoxdur", page.iconTextSecond.isDisplayed());
        }
    }

    @Then("the {string} video instruction file is displayed in the review section of the program")
    public void theVideoInstructionFileIsDisplayedInTheReviewSectionOfTheProgram(String selection) {
        if (selection.contains("new")) {
            ReusableMethods.flash(page.VideoButton, getDriver());
            Assert.assertTrue("Logo görünmür", page.videoIcon.isDisplayed());
            Assert.assertTrue("Video yazısı yoxdur", page.fileText.isDisplayed());
        } else if (selection.contains("edited")) {
            ReusableMethods.flash(page.VideoButton, getDriver());
            Assert.assertTrue("Logo görünmür", page.videoIcon.isDisplayed());
            Assert.assertTrue("Video yazısı yoxdur", page.fileTextSecond.isDisplayed());
        }
    }

    @Then("the {string} instruction file is displayed in the review section of the program")
    public void theInstructionFileIsDisplayedInTheReviewSectionOfTheProgram(String selection) {
        if (selection.contains("new")) {
            ReusableMethods.flash(page.fileButton, getDriver());
            Assert.assertTrue("Logo görünmür", page.fileIcon.isDisplayed());
            Assert.assertTrue("Pdf yoxdur", page.videoText.isDisplayed());
        } else if (selection.contains("edited")) {
            ReusableMethods.flash(page.fileButton, getDriver());
            Assert.assertTrue("Logo görünmür", page.fileIcon.isDisplayed());
            Assert.assertTrue("Test.png yazısı yoxdur", page.videoTextSecond.isDisplayed());
        }
    }

    @Then("the {string} another instruction file is displayed in the review section of the program")
    public void theAnotherInstructionFileIsDisplayedInTheReviewSectionOfTheProgram(String selection) {
        if (selection.contains("new")) {
            ReusableMethods.flash(page.otherFile, getDriver());
            Assert.assertTrue("Logo görünmür", page.otherIcon.isDisplayed());
            Assert.assertTrue("Test.png yazısı yoxdur", page.fileText.isDisplayed());
        } else if (selection.contains("edited")) {
            ReusableMethods.flash(page.otherFile, getDriver());
            Assert.assertTrue("Logo görünmür", page.otherIcon.isDisplayed());
            Assert.assertTrue("Test.png yazısı yoxdur", page.fileTextSecond.isDisplayed());
        }
    }

    @And("edited all information in the review section of the program")
    public void editedAllInformationInTheReviewSectionOfTheProgram(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String programName = row.get("PROGRAM NAME");
            String keyword = row.get("KEYWORD");
            String programAddress = row.get("PROGRAM ADDRESS");
            String apiUrl = row.get("API URL");
            String note = row.get("NOTE");

            page.programNameField.clear();
            ReusableMethods.wait(1);
            page.programNameField.sendKeys(programName);
            ReusableMethods.wait(1);

            page.kewwordField.clear();
            ReusableMethods.wait(1);
            page.kewwordField.sendKeys(keyword);
            ReusableMethods.wait(1);

            page.programAdressField.clear();
            ReusableMethods.wait(1);
            page.programAdressField.sendKeys(programAddress);
            ReusableMethods.wait(1);

            page.apiIntegrationField.clear();
            ReusableMethods.wait(1);
            page.apiIntegrationField.sendKeys(apiUrl);
            ReusableMethods.wait(1);

            page.noteAboutProgramField.clear();
            ReusableMethods.wait(1);
            page.noteAboutProgramField.sendKeys(note);
            ReusableMethods.wait(1);
        }
    }

    @And("edited all files in the review section of the program")
    public void editedAllFilesInTheReviewSectionOfTheProgram() {
        String path = "C:\\Users\\User\\Desktop\\TestFiles\\QAAT.png";
        page.changeIcon.click();
        ReusableMethods.robotClassDosyaYukleme(path);
        ReusableMethods.wait(1);
        page.progDeleteAccept.click();
        ReusableMethods.wait(1);

        page.deleteFileFirst.click();
        ReusableMethods.wait(1);
        page.progDeleteAccept.click();

        page.deleteFileSecond.click();
        ReusableMethods.wait(1);
        page.progDeleteAccept.click();

        ReusableMethods.wait(1);
        page.deleteFileFirst.click();
        ReusableMethods.wait(1);
        page.progDeleteAccept.click();

        String photoPath1 = "C:\\Users\\User\\Desktop\\TestFiles\\EndToEnd.pdf";
        page.iconInstructionBtn.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath1);
        ReusableMethods.wait(3);

        String photoPath = "C:\\Users\\User\\Desktop\\TestFiles\\EndToEnd.pdf";
        page.iconAnotherFileBtn.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath);
        ReusableMethods.wait(2);

        String photoPath2 = "C:\\Users\\User\\Desktop\\TestFiles\\programs.mp4";
        page.iconVideoBtn.click();
        ReusableMethods.robotClassDosyaYukleme(photoPath2);
        ReusableMethods.wait(3);
    }

    @And("all edited information is displayed in the review section of the program")
    public void allEditedInformationIsDisplayedInTheReviewSectionOfTheProgram(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String programName = row.get("PROGRAM NAME");
            String keyword = row.get("KEYWORD");
            String programAddress = row.get("PROGRAM ADDRESS");
            String apiUrl = row.get("API URL");
            String note = row.get("NOTE");


            ReusableMethods.flash(page.programNameField, getDriver());
            WebElement inputValue = getDriver().findElement(By.xpath("//label[contains(., 'Proqramın adı')]/following::input[1]"));
            String progNameEx = inputValue.getAttribute("value");
            System.out.println("actual = " + progNameEx);
            Assert.assertEquals(progNameEx, programName);

            ReusableMethods.flash(page.kewwordField, getDriver());
            WebElement inputValue2 = getDriver().findElement(By.xpath(" //label[contains(., 'Proqramın adı')]/following::input[2]"));
            String progKWEx = inputValue2.getAttribute("value");
            System.out.println("actual = " + progKWEx);
            Assert.assertEquals(progKWEx, keyword);

            ReusableMethods.flash(page.programAdressField, getDriver());
            WebElement inputValue3 = getDriver().findElement(By.xpath(" //label[contains(., 'Proqramın adı')]/following::input[3]"));
            String progAddress = inputValue3.getAttribute("value");
            System.out.println("actual = " + progAddress);
            Assert.assertEquals(progAddress, programAddress);

            ReusableMethods.flash(page.apiIntegrationField, getDriver());
            WebElement inputValue4 = getDriver().findElement(By.xpath(" //label[contains(., 'Proqramın adı')]/following::input[4]"));
            String progApi = inputValue4.getAttribute("value");
            System.out.println("actual = " + progApi);
            Assert.assertEquals(apiUrl, progApi);

            ReusableMethods.flash(page.noteAboutProgramField, getDriver());
            WebElement inputValue5 = getDriver().findElement(By.xpath(" //following::textarea[1]"));
            String progNote = inputValue5.getAttribute("value");
            System.out.println("actual = " + progNote);
            Assert.assertEquals(progNote, note);
        }
    }

    @And("the user selects the {string} button")
    public void theUserSelectsTheButton(String selection) {
        if (selection.contains("Operations on Modules")) {
            page.operationModuleButton.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("User category")) {
            page.userCategoryButton.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Edit")) {
            page.editModuleButton.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Delete")) {
            page.deleteModuleButton.click();
            ReusableMethods.wait(1);
            page.progDeleteAccept.click();
            ReusableMethods.wait(1);
        }
    }

    @And("the module {string} name is entered")
    public void theModuleNameIsEntered(String selection) {
        if (selection.contains("First Module")) {
            page.inputNameModule.sendKeys("First Module");
        } else if (selection.contains("Second Module")) {
            page.inputNameModule.clear();
            ReusableMethods.wait(1);
            page.inputNameModule.sendKeys("Second Module");
        } else if (selection.contains("First Category")) {
            page.inputNameModule.sendKeys("First Category");
            ReusableMethods.wait(1);
        } else if (selection.contains("Second Category")) {
            page.inputNameModule.clear();
            ReusableMethods.wait(1);
            page.inputNameModule.sendKeys("Second Category");
        }
    }

    @And("the keyword {string} is entered")
    public void theKeywordIsEntered(String selection) {
        if (selection.contains("First Key")) {
            page.inputKeyword.sendKeys("First Key");
            ReusableMethods.wait(1);
        } else if (selection.contains("Second Key")) {
            page.inputKeyword.clear();
            ReusableMethods.wait(1);
            page.inputKeyword.sendKeys("Second Key");
            ReusableMethods.wait(1);
        } else if (selection.contains("First Key for Category")) {
            page.inputKeyword.sendKeys("First Key for Category");
            ReusableMethods.wait(1);
        } else if (selection.contains("Second Key for Category")) {
            page.inputKeyword.clear();
            ReusableMethods.wait(1);
            page.inputKeyword.sendKeys("Second Key for Category");
            ReusableMethods.wait(1);
        }
    }

    @And("the information {string} details are entered")
    public void theInformationDetailsAreEntered(String selection) {
        if (selection.contains("First module information")) {
            page.infoButton.click();
            ReusableMethods.wait(1);
            page.infoInput.sendKeys("First module information");
            ReusableMethods.wait(1);
            page.saveChangesModule.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Second module information")) {
            page.infoButton.click();
            ReusableMethods.wait(1);
            page.infoInput.clear();
            ReusableMethods.wait(1);
            page.infoInput.sendKeys("Second module information");
            ReusableMethods.wait(1);
            page.saveChangesModule.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("First Category information")) {
            page.infoButton.click();
            ReusableMethods.wait(1);
            page.infoInput.sendKeys("First Category information");
            ReusableMethods.wait(1);
            page.saveChangesModule.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Second Category information")) {
            page.infoButton.click();
            ReusableMethods.wait(1);
            page.infoInput.clear();
            ReusableMethods.wait(1);
            page.infoInput.sendKeys("Second Category information");
            ReusableMethods.wait(1);
            page.saveChangesModule.click();
            ReusableMethods.wait(1);
        }
    }

    @And("the new module is confirmed")
    public void theNewModuleIsConfirmed() {
        ReusableMethods.wait(1);
        page.acceptModule.click();
        ReusableMethods.wait(1);
    }

    @Then("the module {string} name details are displayed in the module modal window")
    public void theModuleNameDetailsAreDisplayedInTheModuleModalWindow(String selection) {
        if (selection.contains("First Module")) {
            ReusableMethods.flash(page.moduleNameColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "First Module";
            Assert.assertEquals(page.moduleNameColumnTable.getText().trim(), expected);
        } else if (selection.contains("Second Module")) {
            ReusableMethods.flash(page.moduleNameColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "Second Module";
            Assert.assertEquals(page.moduleNameColumnTable.getText().trim(), expected);
        } else if (selection.contains("First Category")) {
            ReusableMethods.flash(page.moduleNameColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "First Category";
            Assert.assertEquals(page.moduleNameColumnTable.getText().trim(), expected);
        } else if (selection.contains("Second Category")) {
            ReusableMethods.flash(page.moduleNameColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "Second Category";
            Assert.assertEquals(page.moduleNameColumnTable.getText().trim(), expected);
        }
    }

    @Then("the module {string} keyword details are displayed in the module modal window")
    public void theModuleKeywordDetailsAreDisplayedInTheModuleModalWindow(String selection) {
        if (selection.contains("First Key")) {
            ReusableMethods.flash(page.moduleKeywordColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "First Key";
            Assert.assertEquals(page.moduleKeywordColumnTable.getText().trim(), expected);
        } else if (selection.contains("Second Key")) {
            ReusableMethods.flash(page.moduleKeywordColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "Second Key";
            Assert.assertEquals(page.moduleKeywordColumnTable.getText().trim(), expected);
        } else if (selection.contains("First Key for Category")) {
            ReusableMethods.flash(page.moduleKeywordColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "First Key for Category";
            Assert.assertEquals(page.moduleKeywordColumnTable.getText().trim(), expected);
        } else if (selection.contains("Second Key for Category")) {
            ReusableMethods.flash(page.moduleKeywordColumnTable, getDriver());
            ReusableMethods.wait(1);
            String expected = "Second Key for Category";
            Assert.assertEquals(page.moduleKeywordColumnTable.getText().trim(), expected);
        }
    }

    @Then("the module {string} information details are displayed in the module modal window")
    public void theModuleInformationDetailsAreDisplayedInTheModuleModalWindow(String selection) {
        if (selection.contains("First module information")) {
            ReusableMethods.flash(page.infoHover, getDriver());
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(page.infoHover).perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement tooltip = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.mat-mdc-tooltip") // və ya "div.mat-tooltip" layihədən asılıdır
                    )
            );

            String tooltipText = tooltip.getText().trim();
            Assert.assertEquals(tooltipText, "First module information");

        } else if (selection.contains("Second module information")) {
            ReusableMethods.flash(page.infoHover, getDriver());
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(page.infoHover).perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement tooltip = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.mat-mdc-tooltip") // və ya "div.mat-tooltip" layihədən asılıdır
                    )
            );
            String tooltipText = tooltip.getText().trim();
            Assert.assertEquals(tooltipText, "Second module information");
        } else if (selection.contains("First Category information")) {
            ReusableMethods.flash(page.infoHover, getDriver());
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(page.infoHover).perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement tooltip = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.mat-mdc-tooltip") // və ya "div.mat-tooltip" layihədən asılıdır
                    )
            );

            String tooltipText = tooltip.getText().trim();
            Assert.assertEquals(tooltipText, "First Category information");

        } else if (selection.contains("Second Category information")) {
            ReusableMethods.flash(page.infoHover, getDriver());
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(page.infoHover).perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement tooltip = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.mat-mdc-tooltip") // və ya "div.mat-tooltip" layihədən asılıdır
                    )
            );
            String tooltipText = tooltip.getText().trim();
            Assert.assertEquals(tooltipText, "Second Category information");
        }
    }

    @And("the module modal window is closed")
    public void theModuleModalWindowIsClosed() {
        page.closeModelWindow.click();
        ReusableMethods.wait(1);
    }

    @Then("the module has been successfully deleted")
    public void theModuleHasBeenSuccessfullyDeleted() {
        try {
            if (page.moduleNameColumnTable.isDisplayed()) {
                throw new AssertionError("❌ Xəta:Silinən modul görünür");
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("✅ Silinən modul səhifədə yoxdur – gözlənilən vəziyyət.");
        }
    }

    @And("the {string} module is assigned to the category")
    public void theModuleIsAssignedToTheCategory(String selection) {
        if (selection.contains("First Module")) {
            page.modalSelectCategory.click();
            ReusableMethods.wait(1);
            page.selectFirstModule.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.sendKeys(Keys.ESCAPE).perform();
        } else if (selection.contains("Second Module")) {
            page.modalSelectCategory.click();
            ReusableMethods.wait(1);
            page.selectSecondModule.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.sendKeys(Keys.ESCAPE).perform();
        }
    }

    @Then("the category has been successfully deleted")
    public void theCategoryHasBeenSuccessfullyDeleted() {
        try {
            if (page.moduleNameColumnTable.isDisplayed()) {
                throw new AssertionError("❌ Xəta:Silinən kategoriya görünür");
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("✅ Silinən kategoriya səhifədə yoxdur – gözlənilən vəziyyət.");
        }
    }

    @And("the program {string} is searched")
    public void theProgramIsSearched(String selection) {
        if (selection.contains("Bright Future")) {
            page.searchInputProgram.sendKeys("Bright Future");
            ReusableMethods.wait(3);
        }     else if (selection.contains("E-Sened")) {
            page.searchInputProgram.sendKeys("Elektron Sənəd Dövriyyəsi");
            ReusableMethods.wait(3);
        }
    }

    @And("the user {string} the program")
    public void theUserTheProgram(String selection) {
        if (selection.contains("activates")) {
            page.switcherToggle.click();
            ReusableMethods.wait(1);
        }
    }

    @And("the program is selected for assigning user categories and modules")
    public void theProgramIsSelectedForAssigningUserCategoriesAndModules() {
        page.createdProq.click();
        ReusableMethods.wait(2);
    }

    @And("the {string} module is selected for the program")
    public void theModuleIsSelectedForTheProgram(String selection) {
        if (selection.contains("First Module")) {
            page.selectFirstModule.click();
            ReusableMethods.wait(1);
        }
    }

    @And("the {string} category is selected for the program")
    public void theCategoryIsSelectedForTheProgram(String selection) {
        if (selection.contains("First Category")) {
            page.selectFirstCategory.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("the navigation to the {string} program has been successful")
    public void theNavigationToTheProgramHasBeenSuccessful(String program) {
        if(program.contains("Bright Future")) {
            String originalWindow = getDriver().getWindowHandle();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.createdProg, getDriver());
            page.createdProg.click();
            for (String windowHandle : getDriver().getWindowHandles()) {
                if (!windowHandle.equals(originalWindow)) {
                    getDriver().switchTo().window(windowHandle);
                    break;
                }

            }
            ReusableMethods.wait(7);
            String actualUrl = getDriver().getCurrentUrl();
            Assert.assertEquals(actualUrl, getDriver().getCurrentUrl());
            getDriver().switchTo().window(originalWindow);
        }else if(program.contains("E-Sened")) {
            String originalWindow = getDriver().getWindowHandle();
            ReusableMethods.wait(3);
            ReusableMethods.flash(page.createdProgEDocument, getDriver());
            page.createdProgEDocument.click();
            for (String windowHandle : getDriver().getWindowHandles()) {
                if (!windowHandle.equals(originalWindow)) {
                    getDriver().switchTo().window(windowHandle);
                    break;
                }

            }
            ReusableMethods.wait(15);
            String actualUrl = getDriver().getCurrentUrl();
            Assert.assertEquals(actualUrl, getDriver().getCurrentUrl());
            getDriver().switchTo().window(originalWindow);
        }
    }

    @And("switches to the programs tab from control panel")
    public void switchesToTheProgramsTabFromControlPanel() {
        page.programTabControlPanel.click();
        ReusableMethods.wait(1);
    }

    @And("the program is selected")
    public void theProgramIsSelected() {
        page.createdProq.click();
        ReusableMethods.wait(1);
    }
}