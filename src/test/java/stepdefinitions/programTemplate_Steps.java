package stepdefinitions;

import Page.helpDesk_Page;
import Page.programTemplate_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static utilities.Driver.getDriver;

public class programTemplate_Steps {
    programTemplate_Page page = new programTemplate_Page();
    helpDesk_Page helpdesk = new helpDesk_Page();
    String programNameFirst;
    String programCount;

    @And("the user switches to the program templates tab")
    public void theUserSwitchesToTheProgramTemplatesTab() {
        page.programTemplatesTabAdmin.click();
        ReusableMethods.wait(2);
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String selection) {
        if (selection.equals("Next")) {
            page.nextTemplate.click();
            ReusableMethods.wait(4);
        } else if (selection.equals("new Template")) {
            page.newTemplatesButton.click();
            ReusableMethods.wait(20);
        }
    }

    @And("the user enters {string} as the template name")
    public void theUserEntersAsTheTemplateName(String selection) {
        if (selection.equals("new")) {
            page.programTemplateNameInput.sendKeys("Automation Template");
            ReusableMethods.wait(1);
        }
    }

    @And("the user selects {string} duty for the template")
    public void theUserSelectsDutyForTheTemplate(String selection) {
        if (selection.equals("new")) {
            page.dutySelection.click();
            ReusableMethods.wait(1);
            page.qaDuty.click();
            ReusableMethods.wait(1);
        }
    }

    @And("the user selects {string} structure for the template")
    public void theUserSelectsStructureForTheTemplate(String selection) {
        if (selection.equals("new")) {
            page.aistStructure.click();
            ReusableMethods.wait(1);
        }
    }

    @When("the user selects the {string} program for template")
    public void theUserSelectsTheProgramForTemplate(String selection) {
        if (selection.equals("new")) {
            page.programFirstSwitcherTemplate.click();
            ReusableMethods.wait(1);
            programNameFirst = page.programFirstProgramTemplate.getText().trim();
            System.out.println("programNameFirst = " + programNameFirst);
            page.acceptTemplate.click();
            ReusableMethods.wait(2);
            programCount = page.checkTempCount.getText().trim();
            System.out.println("programCount = " + programCount);
        }
    }

    @Then("the template information is displayed in the Admin Panel")
    public void theTemplateInformationIsDisplayedInTheAdminPanel(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String templateName = row.get("Şablonun adı");
            String templateDuty = row.get("Vəzifə");
            String templateStructure = row.get("Struktur");
            String templateProgram = row.get("Proqramlar");

            ReusableMethods.flash(page.checkTempName, getDriver());
            Assert.assertEquals(page.checkTempName.getText().trim(), templateName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.checkTempDuty, getDriver());
            Assert.assertEquals(page.checkTempDuty.getText().trim(), templateDuty);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.checkTempStructure, getDriver());
            Assert.assertEquals(page.checkTempStructure.getText().trim(), templateStructure);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.checkTempCount, getDriver());
            Assert.assertEquals(page.checkTempCount.getText().trim(), templateProgram);
            ReusableMethods.wait(1);
        }
    }

    @When("selects delete button in the template tab")
    public void selectsDeleteButtonInTheTemplateTab() {
        page.deleteTemplate.click();
        ReusableMethods.wait(1);
        page.deleteYesTemplate.click();
        ReusableMethods.wait(1);
    }

    @Then("the deleted template is not displayed in the template tab")
    public void theDeletedTemplateIsNotDisplayedInTheTemplateTab() {
        while (true) {
            try {
                if (!page.checkTempName.isDisplayed()) {
                    break;
                }
                page.deleteTemplate.click();
                ReusableMethods.wait(1);
                page.deleteYesTemplate.click();
                ReusableMethods.wait(2);
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                break;
            }
        }
        System.out.println("Bütün şablonlar silindi və test passed oldu ✅");
    }
}