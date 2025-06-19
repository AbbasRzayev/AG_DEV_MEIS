package stepdefinitions;

import Page.contactInformationEditing_Page;
import Page.programs_Page;
import Page.structureAndDuties_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class programs_Steps {
    programs_Page page = new programs_Page();

    @And("switches to the my programs tab")
    public void switchesToTheMyProgramsTab() {
        page.programTab.click();
    }

    contactInformationEditing_Page userPer = new contactInformationEditing_Page();
    structureAndDuties_Page somePage = new structureAndDuties_Page();

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

    @And("added data to the program adress field")
    public void addedDataToTheProgramAdressField(DataTable dataTable) {
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
        String notes = table.cell(0,0);
        page.apiIntegrationField.sendKeys(notes);
    }

    @And("added program icon")
    public void addedProgramIcon() {
        String photoPath = "C:\\Users\\User\\TestFiles\\Test.png";
        page.IconButton.click();
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
        ReusableMethods.wait(1);
        page.saveButton.click();
        //ReusableMethods.clickByJavaScript(page.saveButton);
        //ReusableMethods.waitForClickabilityAndClick(page.saveButton,2);
        //ReusableMethods.clickJSElementWithJavaScript(String.valueOf(page.saveButton));
    }

    @Then("the program successfully created")
    public void theProgramSuccessfullyCreated() {
        page.searchInput.sendKeys("Bright Future");
        ReusableMethods.wait(2);
        ReusableMethods.flash(page.createdProq, getDriver());
        ReusableMethods.wait(1);
        page.createdProq.click();
        ReusableMethods.wait(1);
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
        somePage.searchButton.click();
        ReusableMethods.wait(1);
        userPer.foundedUser.click();
        ReusableMethods.wait(1);
    }

    @And("switches to the user programs tab")
    public void switchesToTheUserProgramsTab() {
        page.switchProgramTab.click();
        ReusableMethods.wait(3);
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
            page.IconButton.click();
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
        String exproqApi="https://aist.group/az/about-us";
        ReusableMethods.flash(page.programNameField,getDriver());
        ReusableMethods.flash(page.kewwordField,getDriver());
        ReusableMethods.flash(page.programAdressField,getDriver());
        ReusableMethods.flash(page.noteAboutProgramField,getDriver());
        ReusableMethods.flash(page.apiIntegrationField,getDriver());
        ReusableMethods.flash(page.IconButton,getDriver());
    }

    @When("user selects delete button to delete the program")
    public void userSelectsDeleteButtonToDeleteTheProgram() {
        page.progDelete.click();
        ReusableMethods.wait(1);
        page.progDeleteAccept.click();
        ReusableMethods.wait(1);
    }
    @Then("the program is successfully deleted")
    public void theProgramIsSuccessfullyDeleted() {
        page.searchInput.sendKeys("AistGroup");
        ReusableMethods.wait(1);
        ReusableMethods.assertElementNotDisplayed(page.createdProqNew);
    }
}