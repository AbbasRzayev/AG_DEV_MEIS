package stepdefinitions;

import Page.announcementsAndCongratulations_Page;
import Page.questionnaires_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class questionnaires_Steps {
    questionnaires_Page page = new questionnaires_Page();
    announcementsAndCongratulations_Page announce = new announcementsAndCongratulations_Page();

    @And("goes to the questionnaires tab")
    public void goesToTheQuestionnairesTab() {
        page.questionnairesTab.click();
        ReusableMethods.wait(3);
    }

    @And("selects the edit button for {string} in the questionnaires tab")
    public void selectsTheEditButtonForOnTheNewlyCreatedAd(String choose) {
        if(choose.contains("edit-announce")) {
            String text = "ManualQA news";
            ReusableMethods.clickEditButtonForItem(text);
            ReusableMethods.wait(2);
        }   else if(choose.contains("edit-congratulation")) {
            String text = "Manual progress";
            ReusableMethods.clickEditButtonForItem(text);
            ReusableMethods.wait(2);
        } else if(choose.contains("edit-event place")) {
            String text = "Manual event place";
            ReusableMethods.clickEditButtonForItem(text);
            ReusableMethods.wait(2);
        }else if(choose.contains("edit-category")) {
            String text = "Manual category";
            ReusableMethods.clickEditButtonForItem(text);
            ReusableMethods.wait(2);
        }
    }

    @When("user edits new {string}")
    public void userEditsNew(String choose) {
        if(choose.contains("announce")) {
            ReusableMethods.wait(1);
            page.adTypeInput.clear();
            ReusableMethods.wait(1);
            page.adTypeInput.sendKeys("AutomationQA news");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        } else if(choose.contains("congratulation")) {
            ReusableMethods.wait(1);
            page.adTypeInput.clear();
            ReusableMethods.wait(1);
            page.adTypeInput.sendKeys("Automation progress");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }else if(choose.contains("event")) {
            ReusableMethods.wait(1);
            page.adTypeInput.clear();
            ReusableMethods.wait(1);
            page.adTypeInput.sendKeys("Automation event place");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }else if(choose.contains("category")) {
            ReusableMethods.wait(1);
            page.adTypeInput.clear();
            ReusableMethods.wait(1);
            page.adTypeInput.sendKeys("Automation category");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }
    }

    @When("user selects the delete button for the {string}")
    public void userSelectsTheDeleteButtonForThe(String choose) {
        if(choose.contains("delete-announce")) {
            String text = "AutomationQA news";
            ReusableMethods.clickDeleteButtonForItem(text);
            ReusableMethods.wait(1);
            page.deleteYes.click();
            ReusableMethods.wait(2);
        } else if(choose.contains("delete-congratulation")) {
            String text = "Automation progress";
            ReusableMethods.clickDeleteButtonForItem(text);
            ReusableMethods.wait(1);
            page.deleteYes.click();
            ReusableMethods.wait(2);
        }else if(choose.contains("delete-event place")) {
            String text = "Automation event place";
            ReusableMethods.clickDeleteButtonForItem(text);
            ReusableMethods.wait(1);
            page.deleteYes.click();
            ReusableMethods.wait(2);
        }else if(choose.contains("delete-category")) {
            String text = "Automation category";
            ReusableMethods.clickDeleteButtonForItem(text);
            ReusableMethods.wait(1);
            page.deleteYes.click();
            ReusableMethods.wait(2);
        }
    }

    @And("user switches to the calendar tab")
    public void userSwitchesToTheCalendarTab() {
        page.calendarTab.click();
        ReusableMethods.wait(2);
    }

    @And("opens places where the event will be held option")
    public void opensPlacesWhereTheEventWillBeHeldOption() {
        page.places.click();
        ReusableMethods.wait(1);
    }

    @And("selects add place button")
    public void selectsAddPlaceButton() {
        page.addPlaceBtn.click();
        ReusableMethods.wait(1);
    }

    @And("user enters place name after selects create button")
    public void userEntersPlaceNameAfterSelectsCreateButton() {
        page.placeInput.sendKeys("8888 room");
        ReusableMethods.wait(1);
        page.createBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("new place successfully adds")
    public void newPlaceSuccessfullyAdds() {
        ReusableMethods.scrollToElementByActions(page.checkPlace);
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPlace, getDriver());
        assertTrue(page.checkPlace.isDisplayed());
    }

    @And("selects the edit button on the newly created place")
    public void selectsTheEditButtonOnTheNewlyCreatedPlace() {
        String text = "8888 room";
        ReusableMethods.wait(1);
        ReusableMethods.clickEditButtonForItem(text);
    }

    @When("user edits new place")
    public void userEditsNewPlace() {
        ReusableMethods.wait(1);
        page.placeInputSecond.clear();
        page.placeInputSecond.sendKeys("9999 room");
        page.saveBtn.click();
    }

    @Then("new place successfully edits")
    public void newPlaceSuccessfullyEdits() {
        ReusableMethods.scrollToElementByActions(page.checkEditPlace);
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkEditPlace, getDriver());
        assertTrue(page.checkEditPlace.isDisplayed());
    }

    @When("user selects the delete button on the newly created place")
    public void userSelectsTheDeleteButtonOnTheNewlyCreatedPlace() {
        String text = "9999 room";
        ReusableMethods.clickDeleteButtonForItem(text);
        ReusableMethods.wait(1);
        page.deleteYes.click();
        ReusableMethods.wait(1);

    }

    @Then("new place successfully deletes")
    public void newPlaceSuccessfullyDeletes() {
        ReusableMethods.assertElementNotDisplayed(page.checkEditPlace);
    }

    @And("opens event categories option")
    public void opensEventCategoriesOption() {
        ReusableMethods.scrollEndByJavascript();
        page.categoria.click();
        ReusableMethods.wait(1);
    }

    @And("selects add category button")
    public void selectsAddCategoryButton() {
        page.addCategBtn.click();
        ReusableMethods.wait(1);
    }

    @When("user enters category name after selects create button")
    public void userEntersCategoryNameAfterSelectsCreateButton() {
        page.cateInput.sendKeys("Work day");
        page.createBtn.click();
        ReusableMethods.wait(1);


    }

    @Then("new category successfully adds")
    public void newCategorySuccessfullyAdds() {
        ReusableMethods.scrollEndByJavascript();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkCat, getDriver());
        assertTrue(page.checkCat.isDisplayed());

    }

    @And("selects the edit button on the newly created category")
    public void selectsTheEditButtonOnTheNewlyCreatedCategory() {
        ReusableMethods.wait(1);
        String text = "Work day";
        clickEditButtonForWorkDay();
        ReusableMethods.wait(1);
        //row = table.find_element(By.XPATH, f".//tr[contains(., 'Work day')]")
        // ReusableMethods.clickEditTwoButtonForItem(text);

    }

    @When("user edits new category")
    public void userEditsNewCategory() {
        page.cateInputSec.clear();
        ReusableMethods.wait(2);
        ReusableMethods.sendKeysJS("Friday", page.cateInputSec);
        //page.cateInputSec.sendKeys("Friday");
        page.saveBtn.click();
        ReusableMethods.wait(2);
    }

    @Then("new category successfully edits")
    public void newCategorySuccessfullyEdits() {
        ReusableMethods.scrollToElementByActions(page.checkCatSecond);
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkCatSecond, getDriver());
        assertTrue(page.checkCatSecond.isDisplayed());
    }

    @When("user selects the delete button on the newly created category")
    public void userSelectsTheDeleteButtonOnTheNewlyCreatedCategory() {
        String text = "Friday";
        ReusableMethods.clickDeleteButtonForItem(text);
        ReusableMethods.wait(1);
        page.deleteYes.click();
        ReusableMethods.wait(3);
    }

    @Then("new category successfully deletes")
    public void newCategorySuccessfullyDeletes() {
        ReusableMethods.assertElementNotDisplayed(page.checkCatSecond);
        ReusableMethods.wait(1);
    }

    public static void clickEditButtonForWorkDay() {
        // Find the row containing the text "Work day"
        WebElement row = getDriver().findElement(By.xpath("//td[contains(text(), 'Work day')]//ancestor::tr"));
        System.out.println(row);
        ReusableMethods.wait(1);
        // Find the edit button within the row
        WebElement editButton = row.findElement(By.xpath(".//td[contains(@class, 'mat-column-edit')]//button"));
        System.out.println("editButton = " + editButton);
        editButton.click();
    }

    @And("user switches to the Congratulations tab")
    public void userSwitchesToTheCongratulationsTab() {
        page.congTab.click();
        ReusableMethods.wait(2);

    }

    @And("opens congratulations types option")
    public void opensCongratulationsTypesOption() {
        page.congOption.click();
        ReusableMethods.wait(1);
    }

    @And("selects add congratulation types button")
    public void selectsAddCongratulationTypesButton() {
        page.congAdBtn.click();
        ReusableMethods.wait(1);
    }

    @When("user enters congratulation name after selects create button")
    public void userEntersCongratulationNameAfterSelectsCreateButton() {
        page.congInput.sendKeys("Abbas Təbriklər");
        ReusableMethods.wait(1);
        page.saveBtn.click();
    }

    @Then("new congratulation successfully adds")
    public void newCongratulationSuccessfullyAdds() {
        ReusableMethods.flash(page.checkCong, getDriver());
        assertTrue(page.checkCong.isDisplayed());
    }

    @And("selects the edit button on the newly created congratulation")
    public void selectsTheEditButtonOnTheNewlyCreatedCongratulation() {
        String text = "Abbas Təbriklər";
        ReusableMethods.clickEditButtonForItem(text);
        ReusableMethods.wait(1);
    }

    @When("user edits new congratulation")
    public void userEditsNewCongratulation() {
        page.congEditInput.clear();
        page.congEditInput.sendKeys("Never give up");
        page.saveBtn.click();
    }

    @Then("new congratulation successfully edits")
    public void newCongratulationSuccessfullyEdits() {
        ReusableMethods.flash(page.checkEditCong, getDriver());
        assertTrue(page.checkEditCong.isDisplayed());
    }

    @When("user selects the delete button on the newly created congratulation")
    public void userSelectsTheDeleteButtonOnTheNewlyCreatedCongratulation() {
        String text = "Never give up";
        ReusableMethods.clickDeleteButtonForItem(text);
        ReusableMethods.wait(1);
        page.deleteYes.click();

    }

    @Then("new congratulation successfully deletes")
    public void newCongratulationSuccessfullyDeletes() {
        ReusableMethods.wait(1);
        ReusableMethods.assertElementNotDisplayed(page.checkEditCong);
        ReusableMethods.wait(1);
    }

    @When("user adds {string} to the name input in the questionnaires tab")
    public void userAddsToTheNameInputInTheQuestionnairesTab(String selection) {
        if (selection.contains("new-announcement")) {
            ReusableMethods.scrollEndByJavascript();
            page.adTypeInput.sendKeys("ManualQA news");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        } else if (selection.contains("edit-announcement")) {
            ReusableMethods.scrollEndByJavascript();
            page.adTypeInput.sendKeys("AutomationQA news");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }else if (selection.contains("new-congratulation")) {
            ReusableMethods.scrollEndByJavascript();
            page.adTypeInput.sendKeys("Manual progress");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }else if (selection.contains("new-event place")) {
            ReusableMethods.scrollEndByJavascript();
            page.adTypeInput.sendKeys("Manual event place");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }else if (selection.contains("new-category")) {
            ReusableMethods.scrollEndByJavascript();
            page.adTypeInput.sendKeys("Manual category");
            ReusableMethods.wait(1);
            page.saveBtn.click();
            ReusableMethods.wait(2);
        }
    }

    @Then("new {string} is displayed in the questionnaires tab")
    public void newIsDisplayedInTheQuestionnairesTab(String selection,DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        if (selection.equalsIgnoreCase("new-announcement")) {
            String expected = rows.get(0).get("announcement");
            ReusableMethods.flash(page.checkNewAd, getDriver());
            assertTrue(page.checkNewAd.isDisplayed());
            assertEquals(expected, page.checkNewAd.getText().trim());
            ReusableMethods.wait(1);
        } else if (selection.equalsIgnoreCase("new-congratulation")) {
            String expected = rows.get(0).get("congratulation");
            ReusableMethods.flash(page.checkNewCong, getDriver());
            assertTrue(page.checkNewCong.isDisplayed());
            assertEquals(expected, page.checkNewCong.getText().trim());
            ReusableMethods.wait(1);
        }else if (selection.equalsIgnoreCase("edited-announcement")) {
            String expected = rows.get(0).get("announcement");
            ReusableMethods.flash(page.checkNewSecond, getDriver());
            assertTrue(page.checkNewSecond.isDisplayed());
            assertEquals(expected, page.checkNewSecond.getText().trim());
            ReusableMethods.wait(1);
        }else if (selection.equalsIgnoreCase("edited-congratulation")) {
            String expected = rows.get(0).get("congratulation");
            ReusableMethods.flash(page.checkSecondCong, getDriver());
            assertTrue(page.checkSecondCong.isDisplayed());
            assertEquals(expected, page.checkSecondCong.getText().trim());
            ReusableMethods.wait(1);
        }else if (selection.equalsIgnoreCase("new-event place")) {
            String expected = rows.get(0).get("event place");
            ReusableMethods.flash(page.checkNewEvent, getDriver());
            assertTrue(page.checkNewEvent.isDisplayed());
            assertEquals(expected, page.checkNewEvent.getText().trim());
            ReusableMethods.wait(1);
        }else if (selection.equalsIgnoreCase("new-category")) {
            String expected = rows.get(0).get("category");
            ReusableMethods.flash(page.checkNewCategory, getDriver());
            assertTrue(page.checkNewCategory.isDisplayed());
            assertEquals(expected, page.checkNewCategory.getText().trim());
            ReusableMethods.wait(1);
        }else if (selection.equalsIgnoreCase("edited-event place")) {
            String expected = rows.get(0).get("event place");
            ReusableMethods.flash(page.checkSecondEvent, getDriver());
            assertTrue(page.checkSecondEvent.isDisplayed());
            assertEquals(expected, page.checkSecondEvent.getText().trim());
            ReusableMethods.wait(1);
        }else if (selection.equalsIgnoreCase("edited-category")) {
            String expected = rows.get(0).get("category");
            ReusableMethods.flash(page.checkNewCategorySec, getDriver());
            assertTrue(page.checkNewCategorySec.isDisplayed());
            assertEquals(expected, page.checkNewCategorySec.getText().trim());
            ReusableMethods.wait(1);
        }
    }

    @Then("the new {string} is successfully deletes in the questionnaires tab")
    public void theNewIsSuccessfullyDeletesInTheQuestionnairesTab(String choose) {
        if (choose.contains("announce")) {
            while (true) {
                try {
                    if (!page.checkNewSecond.isDisplayed()) {
                        break;
                    }
                    String text = "AutomationQA news";
                    ReusableMethods.clickDeleteButtonForItem(text);
                    ReusableMethods.wait(1);
                    page.deleteYes.click();
                    ReusableMethods.wait(2);
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    break;
                }
            }
            System.out.println("Soraqçalardan elan tipi silindi və test passed oldu ✅");
        } else if (choose.contains("congratulation")) {
            while (true) {
                try {
                    if (!page.checkSecondCong.isDisplayed()) {
                        break;
                    }
                    String text = "Automation progress";
                    ReusableMethods.clickDeleteButtonForItem(text);
                    ReusableMethods.wait(1);
                    page.deleteYes.click();
                    ReusableMethods.wait(2);
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    break;
                }
            }
            System.out.println("Soraqçalardan təbrik tipi silindi və test passed oldu ✅");
        }else if (choose.contains("event place")) {
            while (true) {
                try {
                    if (!page.checkSecondEvent.isDisplayed()) {
                        break;
                    }
                    String text = "Automation event place";
                    ReusableMethods.clickDeleteButtonForItem(text);
                    ReusableMethods.wait(1);
                    page.deleteYes.click();
                    ReusableMethods.wait(2);
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    break;
                }
            }
            System.out.println("Soraqçalardan tədbir tipi silindi və test passed oldu ✅");
        }else if (choose.contains("category")) {
            while (true) {
                try {
                    if (!page.checkNewCategorySec.isDisplayed()) {
                        break;
                    }
                    String text = "Automation category";
                    ReusableMethods.clickDeleteButtonForItem(text);
                    ReusableMethods.wait(1);
                    page.deleteYes.click();
                    ReusableMethods.wait(2);
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    break;
                }
            }
            System.out.println("Soraqçalardan kategoriya tipi silindi və test passed oldu ✅");
        }
    }

    @And("selects add new {string} type name button")
    public void selectsAddNewTypeNameButton(String selection) {
        if (selection.contains("announce")) {
            page.adAnnounceType.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("congratulation")) {
            page.congratsType.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("event place")) {
            page.places.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("category")) {
            page.categoryBtn.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("new {string} is displayed in the calendar tab")
    public void newIsDisplayedInTheCalendarTab(String choose) {
        if (choose.contains("Automation category")) {
            ReusableMethods.flash(announce.calendarAutomation, getDriver());
            ReusableMethods.wait(1);
            String expected = "Automation category";
            assertEquals(announce.calendarAutomation.getText().trim(), expected);
            ReusableMethods.wait(1);
        }else if (choose.contains("event place")) {
            ReusableMethods.flash(announce.calenderEventCheck, getDriver());
            ReusableMethods.wait(1);
            String expected = "Automation event place";
            assertEquals(announce.calenderEventCheck.getText().trim(), expected);
            ReusableMethods.wait(1);
        }
    }
}