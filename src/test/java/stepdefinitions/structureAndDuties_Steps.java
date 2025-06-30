package stepdefinitions;

import Page.searchByUserData_Page;
import Page.structureAndDuties_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class structureAndDuties_Steps {
    structureAndDuties_Page page = new structureAndDuties_Page();
    searchByUserData_Page searchByUserDataPage = new searchByUserData_Page();
    private WebDriverWait wait;

    @And("goes to the control panel")
    public void goesToTheControlPanel() {
        page.controlPanel.click();
        ReusableMethods.wait(1);
    }

    @And("adds name {string} and fin to the name and fin fields")
    public void addsNameAndFinToTheNameAndFinFields(String name) {
        if(name.contains("Abbas")) {
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 10);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
            page.nameField.sendKeys("Abbas");
            ReusableMethods.wait(1);
            page.finField.sendKeys("19HSHLY");
            ReusableMethods.wait(1);
        }
    }

    @And("switches to the user change structure and duties tab")
    public void switchesToTheUserChangeStructureAndDutiesTab() {
        page.foundedUser.click();
        ReusableMethods.wait(2);
        page.structureAndDutiesChangePage.click();
        ReusableMethods.wait(1);
    }

    @And("user selects new {string} position")
    public void userSelectsNewPosition(String structure) {
        if (structure.contains("AISTGroup MMC")) {
            page.openQualityControlStructureParentList.click();
            ReusableMethods.wait(1);
            page.ATAndManualSector.click();
            ReusableMethods.wait(1);

        } else if(structure.contains("Keyfiyyətə Nəzarət(AT)")) {
            page.openAISTMMCStructureParentList.click();
            ReusableMethods.wait(1);
        }
    }

    @And("selects new {string}")
    public void selectsNew(String duties) {
        if (duties.contains("Şöbə Müdiri")) {
            ReusableMethods.wait(1);
//            page.dutiesSearchField.click();
            page.dutyInput.clear();
            ReusableMethods.wait(1);
            page.dutyInput.sendKeys("Şöbə Müdiri");
            ReusableMethods.wait(1);
            page.selectSectionDirector.click();
            ReusableMethods.wait(2);
        } else if (duties.contains("QA_AT")){
            ReusableMethods.wait(1);
//            page.dutiesSearchField.click();
            page.dutyInput.clear();
            ReusableMethods.wait(1);
            page.dutyInput.sendKeys("QA_AT");
            ReusableMethods.wait(1);
            page.qaAtPosition.click();
            ReusableMethods.wait(1);
        }

    }

    @And("selects submit button to change structure and duties")
    public void selectsSubmitButtonToChangeStructureAndDuties() {
        page.structureAndDutiesSubmit.click();
        ReusableMethods.wait(1);
    }

    @And("adds again name {string} and fin {string} to the name and fin fields")
    public void addsAgainNameAndFinToTheNameAndFinFields(String name, String fin) {
        page.againNameField.sendKeys(name);
        ReusableMethods.wait(1);
        page.finField.sendKeys(fin);
    }

    @And("selects search button for results")
    public void selectsSearchButtonForResults() {
        page.searchButton.click();
        ReusableMethods.wait(1);
    }

    @And("selects search button and switches to his page")
    public void selectsSearchButtonAndSwitchesToHisPage() {
        page.searchButton.click();
        ReusableMethods.wait(1);
        page.foundedUser.click();
        ReusableMethods.wait(1);
        page.logInWithThisPerson.click();
        ReusableMethods.wait(1);
    }

    @And("user goes to the personal cabinet")
    public void userGoesToThePersonalCabinet() {
        page.perCabinet.click();
        ReusableMethods.wait(1);
    }

    @When("user switches to my position in the structure tab")
    public void userSwitchesToMyPositionInTheStructureTab() {
        page.strucAndDutyTab.click();
        ReusableMethods.wait(1);
    }


    @Then("users {string} position has been changed successfully")
    public void usersPostionHasBeenChangedSuccessfully(String structure) {
        if (structure.contains("Bakı şəhər şöbəsi")) {
            String expectedStruck = "Bakı şəhər şöbəsi";
            ReusableMethods.flash(page.sturckCheck, getDriver());
            assertEquals(expectedStruck, page.sturckCheck.getText());
        } else {
            String expectedStruck = "İnformasiya texnologiyaları və elektron idarəetmə sektoru";
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.sturckCheck, getDriver());
            assertEquals(expectedStruck, page.sturckCheck.getText());
        }
    }

    @And("switches to the structure and duties tab")
    public void switchesToTheStructureAndDutiesTab() {
        page.sdTab.click();
        ReusableMethods.wait(1);
    }

    @And("selects plus button for adding new structure")
    public void selectsPlusButtonForAddingNewStructure() {
        page.plusStructur.click();
        ReusableMethods.wait(1);
    }

    @And("adds information to the structure fields")
    public void addsInformationToTheStructureFields(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("structure name");
            String shortName = row.get("short name");
            String companyCode = row.get("company code");
            String priority = row.get("priority");
            String diats = row.get("Detailed information about the structure");
            page.nameStruc.sendKeys(structureName);
            ReusableMethods.wait(1);
            page.shortNameStruc.sendKeys(shortName);
            ReusableMethods.wait(1);
            page.depCode.sendKeys(companyCode);
            ReusableMethods.wait(1);
            page.prioField.sendKeys(priority);
            ReusableMethods.wait(1);
            page.detailInfo.sendKeys(diats);
            ReusableMethods.wait(1);
        }
    }

    @When("user adds new structure by using save button")
    public void userAddsNewStructureByUsingSaveButton() {
        page.saveButton.click();
        ReusableMethods.wait(1);
    }


    @Then("new structure has been added successfully")
    public void newStructureHasBeenAddedSuccessfully() {
        ReusableMethods.flash(page.newStructure, getDriver());
        assertTrue(page.newStructure.isDisplayed());
    }

    @When("user deletes the newly added structure using the delete button")
    public void userDeletesTheNewlyAddedStructureUsingTheDeleteButton() {
        ReusableMethods.wait(2);
        String labelText = "Problemli sınaq şöbələr(test)";
        ReusableMethods.wait(1);
        clickMatIconInsideLabel(labelText);
        ReusableMethods.waitForClickability(page.deleteButton,10);
        page.deleteButton.click();
        ReusableMethods.wait(2);
        page.addReason.sendKeys("Just for testing nothing personal.");
        ReusableMethods.wait(2);
        page.acceptDelete.click();
    }

    @Then("newly structure has been deleted successfully")
    public void newlyStructureHasBeenDeletedSuccessfully() {
//        ReusableMethods.wait(1);
//        page.programsPanel.click();
        ReusableMethods.wait(1);
        // page.sdTab.click();
        ReusableMethods.wait(1);
        ReusableMethods.assertElementNotDisplayed(page.newStructure);
    }

    public void clickMatIconInsideLabel(String labelText) {
        WebElement label = getDriver().findElement(By.xpath("//label[text()='" + labelText + "']"));
        label.click();
        WebElement matIcon = label.findElement(By.xpath(".//following-sibling::mat-icon[contains(text(), 'more_vert')]"));
        matIcon.click();
    }

    @And("switches to the duties tab")
    public void switchesToTheDutiesTab() {
        page.sdTab.click();
        ReusableMethods.wait(1);
        page.dutyTab.click();
    }

    @And("selects plus button for adding new duty")
    public void selectsPlusButtonForAddingNewDuty() {
        ReusableMethods.wait(1);
        page.dutyPLus.click();
    }

    @And("adds duties name to the duty name field")
    public void addsDutiesNameToTheDutyNameField() {
        ReusableMethods.wait(1);
        page.dutyNameInput.sendKeys("Keyfiyyətə nəzarət(test)");
    }

    @When("user selects add button")
    public void userSelectsAddButton() {
        page.dutyAdd.click();
        ReusableMethods.wait(3);
        page.dutySearchField.sendKeys("Keyfiyyətə nəzarət(test)");
        page.dutySearchButton.click();
        ReusableMethods.wait(2);

    }

    @Then("new duty has been added successfully")
    public void newDutyHasBeenAddedSuccessfully() {
        ReusableMethods.flash(page.dutyBackground, getDriver());
        assertTrue(page.dutyBackground.isDisplayed());
        ReusableMethods.wait(1);
    }

    public void clickMatIconInsideTable(String tableText) {
        WebElement label = getDriver().findElement(By.xpath("//td[text()='" + tableText + "']"));
        label.click();
        WebElement deleteButton = label.findElement(By.xpath(".//following::td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-delete mat-column-delete ng-star-inserted']/mat-icon"));
        deleteButton.click();
    }

    @And("user deletes the newly added duty using the delete button")
    public void userDeletesTheNewlyAddedDutyUsingTheDeleteButton() {
        String dutyText = "Keyfiyyətə nəzarət(test)";
        clickMatIconInsideTable(dutyText);
        ReusableMethods.wait(1);
        page.yesButton.click();
    }

    @Then("newly duty has been deleted successfully")
    public void newlyDutyHasBeenDeletedSuccessfully() {
//        ReusableMethods.wait(1);
//        page.dutySearchField.sendKeys("test3");
        // ReusableMethods.wait(1);
        // page.dutySearchButton.click();
        ReusableMethods.wait(3);
//        ReusableMethods.setElementVisible(page.dutyBackground);
//        System.out.println(page.dutyBackground.isDisplayed());
//        assertTrue(page.dutyBackground.isDisplayed());
        assertElementNotDisplayed(page.dutyBackground);
    }

    public void assertElementNotDisplayed(WebElement element) {
        try {
            assertFalse(element.isDisplayed());
            System.out.println("Element is not displayed as expected.");
        } catch (NoSuchElementException e) {
            System.out.println("Element is not found. Test passed.");
        }
    }

    @Then("after the first changes for structure and position are successfully updated in the users table")
    public void afterTheFirstChangesForStructureAndPositionAreSuccessfullyUpdatedInTheUsersTable() {
        ReusableMethods.flash(page.sectorDirectorPositionTableCheck,getDriver());
        ReusableMethods.wait(1);
        String expectedPosition = "Şöbə Müdiri";
        Assert.assertEquals(page.sectorDirectorPositionTableCheck.getText().trim(),expectedPosition);

        ReusableMethods.flash(page.QualityControlStructureCheck,getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "Keyfiyyətə Nəzarət(AT)";
        Assert.assertEquals(page.QualityControlStructureCheck.getText().trim(),expectedStructure);
    }

    @When("user goes to the my structure and position tab")
    public void userGoesToTheMyStructureAndPositionTab() {
        page.mYStructureAndPositionTab.click();
        ReusableMethods.wait(1);
    }

    @Then("after the first changes for structure and position are successfully updated in the my structure and position tab")
    public void afterTheFirstChangesForStructureAndPositionAreSuccessfullyUpdatedInTheMyStructureAndPositionTab() {
        ReusableMethods.flash(page.qaATstructureProfilePage,getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "Keyfiyyətə Nəzarət(AT)";
        Assert.assertEquals(page.qaATstructureProfilePage.getText().trim(),expectedStructure);
        page.openStructureSectorProfilePage.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.structureSectorProfilePage,getDriver());
        String expectedStructurePosition = "Avtomatlaşdırılma və manual testlər";
        ReusableMethods.wait(1);
        Assert.assertEquals(page.structureSectorProfilePage.getText().trim(),expectedStructurePosition);

        ReusableMethods.flash(page.sectorDirecotrPositionProfilePage,getDriver());
        ReusableMethods.wait(1);
        String positionExpected = "Şöbə Müdiri";
        Assert.assertEquals(page.sectorDirecotrPositionProfilePage.getText().trim(),positionExpected);

    }
    @And("user enters the system from admin panel by using entrance by user name button")
    public void userEntersTheSystemFromAdminPanelByUsingEntranceByUserNameButton() {
        ReusableMethods.wait(1);
        page.foundedUser.click();
        ReusableMethods.wait(2);
        page.enterToTheSystemFromAdminPanel.click();
        ReusableMethods.wait(1);
    }

    @Then("after the second changes for structure and position are successfully updated in the users table")
    public void afterTheSecondChangesForStructureAndPositionAreSuccessfullyUpdatedInTheUsersTable() {
        ReusableMethods.flash(page.qaAtPositionTableCheck,getDriver());
        ReusableMethods.wait(1);
        String expectedPosition = "QA_AT";
        Assert.assertEquals(page.qaAtPositionTableCheck.getText().trim(),expectedPosition);

        ReusableMethods.flash(page.aistMMCStructureCheck,getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "AISTGroup MMC";
        Assert.assertEquals(page.aistMMCStructureCheck.getText().trim(),expectedStructure);
    }

    @Then("after the second changes for structure and position are successfully updated in the my structure and position tab")
    public void afterTheSecondChangesForStructureAndPositionAreSuccessfullyUpdatedInTheMyStructureAndPositionTab() {
        ReusableMethods.flash(page.aistMMCstructureProfilePage,getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "AISTGroup MMC";
        Assert.assertEquals(page.aistMMCstructureProfilePage.getText().trim(),expectedStructure);

        ReusableMethods.flash(page.qaAtPositionProfilePage,getDriver());
        ReusableMethods.wait(1);
        String positionExpected = "QA_AT";
        Assert.assertEquals(page.qaAtPositionProfilePage.getText().trim(),positionExpected);
    }
}