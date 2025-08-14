package stepdefinitions;

import Page.registration_Page;
import Page.searchByUserData_Page;
import Page.structureAndDuties_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class structureAndDuties_Steps {
    structureAndDuties_Page page = new structureAndDuties_Page();
    searchByUserData_Page searchByUserDataPage = new searchByUserData_Page();


    String getTableData;

    @And("goes to the control panel")
    public void goesToTheControlPanel() {
        ReusableMethods.wait(2);
        page.controlPanel.click();
        ReusableMethods.wait(1);
    }

    @And("adds name {string} and fin to the name and fin fields")
    public void addsNameAndFinToTheNameAndFinFields(String name) {
        String fakePinuu = "7732248";
//        String fakeSerialNumuu ="AZ5679968";
        if (name.contains("Abbas")) {
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 10);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 5);
            ReusableMethods.wait(3);
            searchByUserDataPage.openFilter.click();
            ReusableMethods.wait(1);
            page.nameField.sendKeys("Abbas");
            ReusableMethods.wait(1);
            page.finField.sendKeys("19HSHLC");
            ReusableMethods.wait(1);
        }
        else if (name.contains("Zamanov")) {
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 10);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
            page.nameField.sendKeys("Abbas");
            ReusableMethods.wait(1);
//            page.finField.sendKeys(fakePinuu);
            page.finField.sendKeys(registration_Steps.fakePin);
            ReusableMethods.wait(1);

        }    else if (name.contains("Musab")) {
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 10);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
            page.nameField.sendKeys("Musab");
            ReusableMethods.wait(1);
            page.finField.sendKeys("19HLOII");
            ReusableMethods.wait(1);
        }

    }

    @And("switches to the user change structure and duties tab")
    public void switchesToTheUserChangeStructureAndDutiesTab() {
        ReusableMethods.wait(2);
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

        } else if (structure.contains("Keyfiyyətə Nəzarət(AT)")) {
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
        } else if (duties.contains("QA_AT")) {
            ReusableMethods.wait(1);
//            page.dutiesSearchField.click();
            page.dutyInput.clear();
            ReusableMethods.wait(1);
            page.dutyInput.sendKeys("QA_AT");
            ReusableMethods.wait(1);
            page.qaAtPosition.click();
            ReusableMethods.wait(1);
        } else if (duties.contains("IT Mühəndis(QA)")) {
            ReusableMethods.wait(1);
//            page.dutiesSearchField.click();
            page.dutyInput.clear();
            ReusableMethods.wait(1);
            page.dutyInput.sendKeys("IT Mühəndis(QA)");
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
        ReusableMethods.wait(2);
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
        ReusableMethods.wait(1);
        page.plusStructur.click();
        ReusableMethods.wait(1);
    }

    @And("adds information to the structure fields")
    public void addsInformationToTheStructureFields(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");
            page.nameStruc.sendKeys(structureName);
            ReusableMethods.wait(1);
            page.shortNameStruc.sendKeys(shortName);
            ReusableMethods.wait(1);
            page.depCode.sendKeys(companyCode);
            ReusableMethods.wait(1);
            page.prioField.sendKeys(priority);
            ReusableMethods.wait(1);
            page.sunInfo.sendKeys(sun);
            ReusableMethods.wait(1);
            page.tinInfo.sendKeys(tin);
            ReusableMethods.wait(1);
            page.addressInfo.sendKeys(address);
            ReusableMethods.wait(1);
            page.detailInfo.sendKeys(details);
        }
    }

    @When("user select the save button in the structure modal window")
    public void userSelectTheSaveButtonInTheStructureModalWindow() {
        page.saveButton.click();
        ReusableMethods.wait(1);
    }

    @And("switches to the duties tab")
    public void switchesToTheDutiesTab() {
        ReusableMethods.wait(1);
        page.dutyTab.click();
        ReusableMethods.wait(1);
    }

    @And("selects plus button for adding new duty")
    public void selectsPlusButtonForAddingNewDuty() {
        ReusableMethods.wait(1);
        page.dutyPLus.click();
    }

    @And("adds duties name to the duty name field")
    public void addsDutiesNameToTheDutyNameField() {
        ReusableMethods.wait(1);
        page.dutyNameInput.sendKeys("IT Mühəndis(QA)");
    }

    @When("user selects add button")
    public void userSelectsAddButton() {
        page.dutyAdd.click();
        ReusableMethods.wait(3);
        page.dutySearchField.sendKeys("Keyfiyyətə nəzarət(test)");
        page.dutySearchButton.click();
        ReusableMethods.wait(2);

    }

    public void clickMatIconInsideTable(String tableText) {
        WebElement label = getDriver().findElement(By.xpath("//td[text()='" + tableText + "']"));
        label.click();
        WebElement deleteButton = label.findElement(By.xpath(".//following::td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-delete mat-column-delete ng-star-inserted']/mat-icon"));
        deleteButton.click();
    }

    @And("user deletes the newly added duty using the delete button")
    public void userDeletesTheNewlyAddedDutyUsingTheDeleteButton() {
        ReusableMethods.wait(1);
        page.deleteBtn.click();
        ReusableMethods.wait(1);
        page.yesButton.click();
    }

    @Then("newly duty has been deleted successfully")
    public void newlyDutyHasBeenDeletedSuccessfully() {
        ReusableMethods.wait(2);
        try {
            if (page.ITEditedDuty.isDisplayed()) {
                throw new AssertionError("❌ Xəta:Silinən vəzifə görünür");
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("✅ Silinən vəzifə səhifədə yoxdur – gözlənilən vəziyyət.");
        }
    }

    @Then("after the first changes for structure and position are successfully updated in the users table")
    public void afterTheFirstChangesForStructureAndPositionAreSuccessfullyUpdatedInTheUsersTable() {
        ReusableMethods.flash(page.sectorDirectorPositionTableCheck, getDriver());
        ReusableMethods.wait(1);
        String expectedPosition = "Şöbə Müdiri";
        Assert.assertEquals(page.sectorDirectorPositionTableCheck.getText().trim(), expectedPosition);

        ReusableMethods.flash(page.QualityControlStructureCheck, getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "Keyfiyyətə Nəzarət(AT)";
        Assert.assertEquals(page.QualityControlStructureCheck.getText().trim(), expectedStructure);
    }

    @When("user goes to the my structure and position tab")
    public void userGoesToTheMyStructureAndPositionTab() {
        page.mYStructureAndPositionTab.click();
        ReusableMethods.wait(1);
    }

    @Then("after the first changes for structure and position are successfully updated in the my structure and position tab")
    public void afterTheFirstChangesForStructureAndPositionAreSuccessfullyUpdatedInTheMyStructureAndPositionTab() {
        ReusableMethods.flash(page.qaATstructureProfilePage, getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "Keyfiyyətə Nəzarət(AT)";
        Assert.assertEquals(page.qaATstructureProfilePage.getText().trim(), expectedStructure);
        page.openStructureSectorProfilePage.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.structureSectorProfilePage, getDriver());
        String expectedStructurePosition = "Avtomatlaşdırılma və manual testlər";
        ReusableMethods.wait(1);
        Assert.assertEquals(page.structureSectorProfilePage.getText().trim(), expectedStructurePosition);

        ReusableMethods.flash(page.sectorDirecotrPositionProfilePage, getDriver());
        ReusableMethods.wait(1);
        String positionExpected = "Şöbə Müdiri";
        Assert.assertEquals(page.sectorDirecotrPositionProfilePage.getText().trim(), positionExpected);

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
        ReusableMethods.flash(page.qaAtPositionTableCheck, getDriver());
        ReusableMethods.wait(1);
        String expectedPosition = "QA_AT";
        Assert.assertEquals(page.qaAtPositionTableCheck.getText().trim(), expectedPosition);

        ReusableMethods.flash(page.aistMMCStructureCheck, getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "AISTGroup MMC";
        Assert.assertEquals(page.aistMMCStructureCheck.getText().trim(), expectedStructure);
    }

    @Then("after the second changes for structure and position are successfully updated in the my structure and position tab")
    public void afterTheSecondChangesForStructureAndPositionAreSuccessfullyUpdatedInTheMyStructureAndPositionTab() {
        ReusableMethods.flash(page.aistMMCstructureProfilePage, getDriver());
        ReusableMethods.wait(1);
        String expectedStructure = "AISTGroup MMC";
        Assert.assertEquals(page.aistMMCstructureProfilePage.getText().trim(), expectedStructure);

        ReusableMethods.flash(page.qaAtPositionProfilePage, getDriver());
        ReusableMethods.wait(1);
        String positionExpected = "QA_AT";
        Assert.assertEquals(page.qaAtPositionProfilePage.getText().trim(), positionExpected);
    }

    @Then("new structural is successfully added in the admin panel of the structure and position tab")
    public void newStructuralIsSuccessfullyAddedInTheAdminPanelOfTheStructureAndPositionTab() {
        ReusableMethods.flash(page.firstStructureName, getDriver());
        String firstStructureName = "Avtomatlaşdırılmış Testlər";
        Assert.assertEquals(page.firstStructureName.getText().trim(), firstStructureName);
    }

    @Then("all information about the new structural is displayed in the structure preview section in the admin panel of the structure and position tab")
    public void allInformationAboutTheNewStructuralIsDisplayedInTheStructurePreviewSectionInTheAdminPanelOfTheStructureAndPositionTab(DataTable dataTable) {
        page.firstStructureSelect.click();
        ReusableMethods.wait(1);
        page.firstStructurePreviewSection.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            ReusableMethods.flash(page.firstStructurePreviewSectionName, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionName.getText(), structureName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionShort, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionShort.getText(), shortName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionCode, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionCode.getText(), companyCode);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionPriority, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionPriority.getText(), priority);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionSun, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionSun.getText(), sun);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionTin, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionTin.getText(), tin);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionStructureAddress, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionStructureAddress.getText(), address);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionDetail, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionDetail.getText(), details);
            ReusableMethods.wait(1);

            page.closeStructurePreviewModal.click();
            ReusableMethods.wait(1);

        }
    }

    @When("user edit all information for the new structure")
    public void userEditAllInformationForTheNewStructure(DataTable dataTable) {
        page.firstStructureSelect.click();
        ReusableMethods.wait(1);
        page.StructureEdit.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            page.nameStruc.clear();
            ReusableMethods.wait(1);
            page.nameStruc.sendKeys(structureName);
            ReusableMethods.wait(1);
            page.shortNameStruc.clear();
            ReusableMethods.wait(1);
            page.shortNameStruc.sendKeys(shortName);
            ReusableMethods.wait(1);
            page.depCode.clear();
            ReusableMethods.wait(1);
            page.depCode.sendKeys(companyCode);
            ReusableMethods.wait(1);
            page.prioField.clear();
            ReusableMethods.wait(1);
            page.prioField.sendKeys(priority);
            ReusableMethods.wait(1);
            page.sunInfo.clear();
            ReusableMethods.wait(1);
            page.sunInfo.sendKeys(sun);
            ReusableMethods.wait(1);
            page.tinInfo.clear();
            ReusableMethods.wait(1);
            page.tinInfo.sendKeys(tin);
            ReusableMethods.wait(1);
            page.addressInfo.clear();
            ReusableMethods.wait(1);
            page.addressInfo.sendKeys(address);
            ReusableMethods.wait(1);
            page.detailInfo.clear();
            ReusableMethods.wait(1);
            page.detailInfo.sendKeys(details);
        }
    }

    @Then("new structural is successfully edited in the admin panel of the structure and position tab")
    public void newStructuralIsSuccessfullyEditedInTheAdminPanelOfTheStructureAndPositionTab() {
        ReusableMethods.flash(page.secondStructureName, getDriver());
        String secondStructureName = "Keyfiyyət mütəxəsisləri";
        Assert.assertEquals(page.secondStructureName.getText().trim(), secondStructureName);
    }

    @Then("all information about the new structural is displayed after edition in the structure preview section in the admin panel of the structure and position tab")
    public void allInformationAboutTheNewStructuralIsDisplayedAfterEditionInTheStructurePreviewSectionInTheAdminPanelOfTheStructureAndPositionTab(DataTable dataTable) {
        page.secondStructureSelect.click();
        ReusableMethods.wait(1);
        page.firstStructurePreviewSection.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            ReusableMethods.flash(page.firstStructurePreviewSectionName, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionName.getText(), structureName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionShort, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionShort.getText(), shortName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionCode, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionCode.getText(), companyCode);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionPriority, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionPriority.getText(), priority);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionSun, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionSun.getText(), sun);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionTin, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionTin.getText(), tin);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionStructureAddress, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionStructureAddress.getText(), address);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionDetail, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionDetail.getText(), details);
            ReusableMethods.wait(1);

            page.closeStructurePreviewModal.click();
            ReusableMethods.wait(1);
        }
    }

    @And("user adds new department to the structure")
    public void userAddsNewDepartmentToTheStructure(DataTable dataTable) {
        page.secondStructureSelect.click();
        ReusableMethods.wait(1);
        page.StructureNew.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            page.nameStruc.clear();
            ReusableMethods.wait(1);
            page.nameStruc.sendKeys(structureName);
            ReusableMethods.wait(1);
            page.shortNameStruc.clear();
            ReusableMethods.wait(1);
            page.shortNameStruc.sendKeys(shortName);
            ReusableMethods.wait(1);
            page.depCode.clear();
            ReusableMethods.wait(1);
            page.depCode.sendKeys(companyCode);
            ReusableMethods.wait(1);
            page.prioField.clear();
            ReusableMethods.wait(1);
            page.prioField.sendKeys(priority);
            ReusableMethods.wait(1);
            page.sunInfo.clear();
            ReusableMethods.wait(1);
            page.sunInfo.sendKeys(sun);
            ReusableMethods.wait(1);
            page.tinInfo.clear();
            ReusableMethods.wait(1);
            page.tinInfo.sendKeys(tin);
            ReusableMethods.wait(1);
            page.addressInfo.clear();
            ReusableMethods.wait(1);
            page.addressInfo.sendKeys(address);
            ReusableMethods.wait(1);
            page.detailInfo.clear();
            ReusableMethods.wait(1);
            page.detailInfo.sendKeys(details);
        }
    }

    @Then("new department is successfully added in the admin panel of the structure and position tab")
    public void newDepartmentIsSuccessfullyAddedInTheAdminPanelOfTheStructureAndPositionTab() {
        ReusableMethods.wait(1);
        page.openStructureList.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.departmentNameCheckAdmin, getDriver());
        String secondStructureName = "Nəzarət şöbəsi";
        Assert.assertEquals(page.departmentNameCheckAdmin.getText().trim(), secondStructureName);
    }

    @Then("all information about the new department is displayed in the structure preview section in the admin panel of the structure and position tab")
    public void allInformationAboutTheNewDepartmentIsDisplayedInTheStructurePreviewSectionInTheAdminPanelOfTheStructureAndPositionTab(DataTable dataTable) {
        page.departmentSelect.click();
        ReusableMethods.wait(1);
        page.firstStructurePreviewSection.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            ReusableMethods.flash(page.firstStructurePreviewSectionName, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionName.getText(), structureName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionShort, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionShort.getText(), shortName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionCode, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionCode.getText(), companyCode);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionPriority, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionPriority.getText(), priority);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionSun, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionSun.getText(), sun);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionTin, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionTin.getText(), tin);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionStructureAddress, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionStructureAddress.getText(), address);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionDetail, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionDetail.getText(), details);
            ReusableMethods.wait(1);

            page.closeStructurePreviewModal.click();
            ReusableMethods.wait(1);

        }
    }

    @And("user adds new sector to the department")
    public void userAddsNewSectorToTheDepartment(DataTable dataTable) {
//        page.openStructureList.click();
//        ReusableMethods.wait(2);
        page.departmentSelect.click();
        ReusableMethods.wait(1);
        page.StructureNew.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            page.nameStruc.clear();
            ReusableMethods.wait(1);
            page.nameStruc.sendKeys(structureName);
            ReusableMethods.wait(1);
            page.shortNameStruc.clear();
            ReusableMethods.wait(1);
            page.shortNameStruc.sendKeys(shortName);
            ReusableMethods.wait(1);
            page.depCode.clear();
            ReusableMethods.wait(1);
            page.depCode.sendKeys(companyCode);
            ReusableMethods.wait(1);
            page.prioField.clear();
            ReusableMethods.wait(1);
            page.prioField.sendKeys(priority);
            ReusableMethods.wait(1);
            page.sunInfo.clear();
            ReusableMethods.wait(1);
            page.sunInfo.sendKeys(sun);
            ReusableMethods.wait(1);
            page.tinInfo.clear();
            ReusableMethods.wait(1);
            page.tinInfo.sendKeys(tin);
            ReusableMethods.wait(1);
            page.addressInfo.clear();
            ReusableMethods.wait(1);
            page.addressInfo.sendKeys(address);
            ReusableMethods.wait(1);
            page.detailInfo.clear();
            ReusableMethods.wait(1);
            page.detailInfo.sendKeys(details);
        }
    }

    @Then("new sector is successfully added in the admin panel of the structure and position tab")
    public void newSectorIsSuccessfullyAddedInTheAdminPanelOfTheStructureAndPositionTab() {
//        page.openStructureList.click();
//        ReusableMethods.wait(1);
        page.openDepartmentList.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.sectorNameCheckAdmin, getDriver());
        String secondStructureName = "Avtomalaşdırma sektoru";
        Assert.assertEquals(page.sectorNameCheckAdmin.getText().trim(), secondStructureName);
    }

    @Then("all information about the new sector is displayed in the structure preview section in the admin panel of the structure and position tab")
    public void allInformationAboutTheNewSectorIsDisplayedInTheStructurePreviewSectionInTheAdminPanelOfTheStructureAndPositionTab(DataTable dataTable) {
        page.sectorSelect.click();
        ReusableMethods.wait(1);
        page.firstStructurePreviewSection.click();
        ReusableMethods.wait(1);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String structureName = row.get("STRUCTURE NAME");
            String shortName = row.get("SHORT NAME");
            String companyCode = row.get("COMPANY CODE");
            String priority = row.get("PRIORITY");
            String sun = row.get("SUN");
            String tin = row.get("TIN");
            String address = row.get("ADDRESS");
            String details = row.get("DETAILED INFORMATION ABOUT THE STRUCTURE");

            ReusableMethods.flash(page.firstStructurePreviewSectionName, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionName.getText(), structureName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionShort, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionShort.getText(), shortName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionCode, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionCode.getText(), companyCode);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionPriority, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionPriority.getText(), priority);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionSun, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionSun.getText(), sun);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionTin, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionTin.getText(), tin);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionStructureAddress, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionStructureAddress.getText(), address);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.firstStructurePreviewSectionDetail, getDriver());
            Assert.assertEquals(page.firstStructurePreviewSectionDetail.getText(), details);
            ReusableMethods.wait(1);

            page.closeStructurePreviewModal.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("the new structure is successfully displayed in the my structure and position tab")
    public void theNewStructureIsSuccessfullyDisplayedInTheMyStructureAndPositionTab() {
        ReusableMethods.flash(page.secondStructureName, getDriver());
        String secondStructureName = "Keyfiyyət mütəxəsisləri";
        Assert.assertEquals(page.secondStructureName.getText().trim(), secondStructureName);
    }

    @Then("the new department is successfully displayed in the my structure and position tab")
    public void theNewDepartmentIsSuccessfullyDisplayedInTheMyStructureAndPositionTab() {
        page.openStructureList.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.departmentNameCheckAdmin, getDriver());
        String secondStructureName = "Nəzarət şöbəsi";
        Assert.assertEquals(page.departmentNameCheckAdmin.getText().trim(), secondStructureName);
    }

    @Then("the new sector is successfully displayed in the my structure and position tab")
    public void theNewSectorIsSuccessfullyDisplayedInTheMyStructureAndPositionTab() {
        page.openDepartmentList.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.sectorNameCheckAdmin, getDriver());
        String secondStructureName = "Avtomalaşdırma sektoru";
        Assert.assertEquals(page.sectorNameCheckAdmin.getText().trim(), secondStructureName);
    }

    @When("user deletes the newly added sector using the delete button")
    public void userDeletesTheNewlyAddedSectorUsingTheDeleteButton() {
        page.openStructureList.click();
        ReusableMethods.wait(1);
        page.openDepartmentList.click();
        ReusableMethods.wait(1);
        page.sectorSelect.click();
        ReusableMethods.wait(1);
        page.StructureDelete.click();
        ReusableMethods.wait(1);
        page.StructureDeleteInput.sendKeys("Test məqsədi ilə silir");
        ReusableMethods.wait(1);
        page.StructureDeleteAccept.click();
        ReusableMethods.wait(1);
    }

    @Then("the sector has been deleted successfully")
    public void theSectorHasBeenDeletedSuccessfully() {
        page.openStructureList.click();
        ReusableMethods.wait(1);
//        page.openDepartmentList.click();
//        ReusableMethods.wait(1);
        if (!page.sectorNameCheck.isEmpty()) {
            throw new AssertionError("❌ XƏTA: 'Avtomalaşdırma sektoru' səhifədə mövcuddur!");
        } else {
            System.out.println("✅ OK: 'Avtomalaşdırma sektoru' tapılmadı – hər şey qaydasındadır.");
        }
    }

    @When("user deletes the newly added department using the delete button")
    public void userDeletesTheNewlyAddedDepartmentUsingTheDeleteButton() {
//        page.openStructureList.click();
//        ReusableMethods.wait(1);
//        page.openDepartmentList.click();
//        ReusableMethods.wait(1);
        page.departmentSelect.click();
        ReusableMethods.wait(1);
        page.StructureDelete.click();
        ReusableMethods.wait(1);
        page.StructureDeleteInput.sendKeys("Test məqsədi ilə silir");
        ReusableMethods.wait(1);
        page.StructureDeleteAccept.click();
        ReusableMethods.wait(1);
    }

    @Then("the department has been deleted successfully")
    public void theDepartmentHasBeenDeletedSuccessfully() {
        page.openStructureList.click();
        ReusableMethods.wait(1);
//        page.openDepartmentList.click();
//        ReusableMethods.wait(1);
        if (!page.departmentNameCheck.isEmpty()) {
            throw new AssertionError("❌ XƏTA: 'Avtomalaşdırma sektoru' səhifədə mövcuddur!");
        } else {
            System.out.println("✅ OK: 'Avtomalaşdırma sektoru' tapılmadı – hər şey qaydasındadır.");
        }
    }

    @When("user deletes the newly added structure using the delete button")
    public void userDeletesTheNewlyAddedStructureUsingTheDeleteButton() {
//        page.openStructureList.click();
//        ReusableMethods.wait(1);
        page.secondStructureSelect.click();
        ReusableMethods.wait(1);

        page.StructureDelete.click();
        ReusableMethods.wait(1);
        page.StructureDeleteInput.sendKeys("Test məqsədi ilə silir");
        ReusableMethods.wait(1);
        page.StructureDeleteAccept.click();
        ReusableMethods.wait(1);
    }

    @Then("the structure has been deleted successfully")
    public void theStructureHasBeenDeletedSuccessfully() {
//        page.openStructureList.click();
//        ReusableMethods.wait(1);
//        page.openDepartmentList.click();
//        ReusableMethods.wait(1);
        if (!page.sectorNameCheckinDelete.isEmpty()) {
            throw new AssertionError("❌ XƏTA: 'Avtomalaşdırma sektoru' səhifədə mövcuddur!");
        } else {
            System.out.println("✅ OK: 'Avtomalaşdırma sektoru' tapılmadı – hər şey qaydasındadır.");
        }
    }

    @And("adds priority name to the priority name field")
    public void addsPriorityNameToThePriorityNameField() {
        page.priorityInput.sendKeys("88");
        ReusableMethods.wait(1);
    }

    @And("user {string} the duty")
    public void userTheDuty(String duty) {
        if (duty.contains("deactivated")) {
            page.newDutyToggleBtn.click();
            ReusableMethods.wait(1);

        } else if (duty.contains("activated")) {
            page.ToggleBtn.click();
            ReusableMethods.wait(1);
        }
    }

    @When("adds duties name to the duties name field in the filter")
    public void addsDutiesNameToTheDutiesNameFieldInTheFilter() {
        ReusableMethods.wait(1);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        ReusableMethods.wait(1);
        getTableData = searchByUserDataPage.getTableDataText.getText();
        System.out.println("expected = " + getTableData);
        ReusableMethods.flash(searchByUserDataPage.getTableDataText, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.dutyFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
        page.dutyInputDutyTab.sendKeys("IT Mühəndis(QA)");
        ReusableMethods.wait(1);
    }

    @When("user selects enter in the duties tab")
    public void userSelectsEnterInTheDutiesTab() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(1);
    }

    String getDutyIdText;

    @Then("search results by name and new duty is displayed in the admin panel")
    public void searchResultsByNameAndNewDutyIsDisplayedInTheAdminPanel() {
        ReusableMethods.flash(page.ITDuty, getDriver());
        ReusableMethods.wait(1);
        String iTDuty = "IT Mühəndis(QA)";
        Assert.assertEquals(page.ITDuty.getText(), iTDuty);
        getDutyIdText = page.getDutyID.getText();
        System.out.println("getDutyIdText = " + getDutyIdText);
    }

    @Then("the changes is successfully resets in the duty tab")
    public void theChangesIsSuccessfullyResetsInTheDutyTab() {
        ReusableMethods.wait(1);
//        ReusableMethods.pageDown();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        ReusableMethods.flash(searchByUserDataPage.getTableDataText, getDriver());
        System.out.println("expectedTableDataText = " + getTableData);
        String actualTableText = searchByUserDataPage.getTableDataText.getText();
        System.out.println("actualTableDataText = " + searchByUserDataPage.getTableDataText.getText());
        ReusableMethods.wait(2);
        Assert.assertEquals(getTableData, actualTableText);
    }


    @When("adds duties id to the duties id field in the filter")
    public void addsDutiesIdToTheDutiesIdFieldInTheFilter() {
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
        page.dutyInputDutyIDTab.sendKeys(getDutyIdText);
        ReusableMethods.wait(1);
    }

    @Then("search results by id and new duty is displayed in the admin panel")
    public void searchResultsByIdAndNewDutyIsDisplayedInTheAdminPanel() {
        ReusableMethods.flash(page.getDutyID, getDriver());
        Assert.assertEquals(page.getDutyID.getText(), getDutyIdText);
    }

    @And("user search for a deactivated duty")
    public void userSearchForADeactivatedDuty() {
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.structureFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
        page.selectStatusDuty.click();
        ReusableMethods.wait(1);
        page.selectDeActiveDuty.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.closeFilterModal, 5);
        ReusableMethods.wait(2);

    }

    @Then("search results by deactivated duty is displayed in the admin panel")
    public void searchResultsByDeactivatedDutyIsDisplayedInTheAdminPanel() {
        ReusableMethods.flash(page.ITDuty, getDriver());
        ReusableMethods.wait(1);
        String iTDuty = "IT Mühəndis(QA)";
        Assert.assertEquals(page.ITDuty.getText(), iTDuty);
    }

    @When("user reset the changes for id duty")
    public void userResetTheChangesForIdDuty() {
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.restTheChanges, 5);
        ReusableMethods.wait(1);
        while (true) {
            try {
                if (!searchByUserDataPage.filterModal.isDisplayed()) {
                    break;
                }
                ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.closeFilterModal, 5);
                ReusableMethods.wait(1);
            } catch (NoSuchElementException noSuchElementException) {
                break;
            }
        }
    }

    @When("user reset the changes for status duty")
    public void userResetTheChangesForStatusDuty() {
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.structureFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.restTheChanges, 5);
        ReusableMethods.wait(1);
        while (true) {
            try {
                if (!searchByUserDataPage.filterModal.isDisplayed()) {
                    break;
                }
                ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.closeFilterModal, 5);
                ReusableMethods.wait(1);
            } catch (NoSuchElementException noSuchElementException) {
                break;
            }
        }
    }

    @Then("the deactivated duty is not displayed in the duty selection list")
    public void theDeactivatedDutyIsNotDisplayedInTheDutySelectionList() {
        ReusableMethods.wait(1);
        try {
            if (page.ITPosition.isDisplayed()) {
                throw new AssertionError("❌ Xəta:Deaktiv ITPosition elementi səhifədə görünür");
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("✅ Deaktiv ITPosition elementi səhifədə yoxdur – gözlənilən vəziyyət.");
        }

//        List<WebElement> itElements = getDriver().findElements(By.xpath("//div[normalize-space(text())='IT Mühəndis(QA)']"));
//        if (!itElements.isEmpty() && itElements.get(0).isDisplayed()) {
//            throw new AssertionError("❌ Xəta: Deaktiv ITPosition elementi səhifədə görünür");
//        } else {
//            System.out.println("✅ Deaktiv ITPosition elementi səhifədə yoxdur – gözlənilən vəziyyət.");
//        }

    }

    @And("user selects add duty button")
    public void userSelectsAddDutyButton() {
        page.dutyAdd.click();
        ReusableMethods.wait(1);
    }

    @And("user search for a activate duty")
    public void userSearchForAActivateDuty() {
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.structureFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.openFilter, 5);
        page.selectStatusDuty.click();
        ReusableMethods.wait(1);
        page.selectActiveDuty.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForClickabilityAndClick(searchByUserDataPage.closeFilterModal, 5);
        ReusableMethods.wait(2);
    }

    @Then("search results by activated duty is displayed in the admin panel")
    public void searchResultsByActivatedDutyIsDisplayedInTheAdminPanel() {
        ReusableMethods.wait(1);
        List<WebElement> activeToggles = getDriver().findElements(
                By.cssSelector("td .toggle-switch.toggled")
        );

        System.out.println("Aktiv toggle sayı: " + activeToggles.size());

        // 2. JavaScript ilə hamısını eyni anda flash (yaşıl) et
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (WebElement toggle : activeToggles) {
            // Parent td-ni tapırıq
            WebElement td = toggle.findElement(By.xpath("./ancestor::td"));

            js.executeScript(
                    "arguments[0].style.border='2px solid lime'; arguments[0].style.backgroundColor='palegreen';",
                    td
            );
        }

    }

    @Then("the active duty is displayed in the duty selection list")
    public void theActiveDutyIsDisplayedInTheDutySelectionList() {
        try {
            if (page.ITPosition.isDisplayed()) {
                System.out.println("✅ ITPosition elementi səhifədə görünür – gözlənilən vəziyyət.");
            } else {
                throw new AssertionError("❌ Xəta: ITPosition elementi səhifədə tapılmadı.");
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            throw new AssertionError("❌ Xəta: ITPosition elementi səhifədə tapılmadı – gözlənilirdi ki, görünsün.");
        }
    }

    @And("changes name and priority from edit modal window")
    public void changesNameAndPriorityFromEditModalWindow() {
        page.dutyEditBtn.click();
        ReusableMethods.wait(1);
        page.dutyNameInput.clear();
        ReusableMethods.wait(1);
        page.dutyNameInput.sendKeys("IT(edited)");
        page.priorityInput.clear();
        ReusableMethods.wait(1);
        page.priorityInput.sendKeys("77(edited)");
        ReusableMethods.wait(1);
        page.saveEdit.click();
        ReusableMethods.wait(1);
    }

    @Then("new duty is successfully edited")
    public void newDutyIsSuccessfullyEdited() {
        ReusableMethods.flash(page.ITEditedDuty, getDriver());
        ReusableMethods.wait(1);
        String iTDuty = "IT(edited)";
        Assert.assertEquals(page.ITEditedDuty.getText(), iTDuty);

    }

    @And("page is reloaded")
    public void pageIsReloaded() {
        ReusableMethods.wait(3);
        getDriver().navigate().refresh();
        ReusableMethods.wait(1);
    }
}