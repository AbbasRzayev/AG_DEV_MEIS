package stepdefinitions;

import Page.questionnaires_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class questionnaires_Steps {
    questionnaires_Page page = new questionnaires_Page();

    @And("goes to the questionnaires tab")
    public void goesToTheQuestionnairesTab() {
        page.questionnairesTab.click();
        ReusableMethods.wait(1);
    }

    @And("selects ad type name button")
    public void selectsAdTypeNameButton() {
        page.adType.click();
        ReusableMethods.wait(1);
    }

    @When("user enters ad name after selects create button")
    public void userEntersAdNameAfterSelectsCreateButton() {
        ReusableMethods.scrollEndByJavascript();
        page.addAdType.click();
        page.adTypeInput.sendKeys("AutomationTest");
        ReusableMethods.wait(1);
        page.saveBtn.click();
    }

    @Then("new ad successfully adds")
    public void newAdSuccessfullyAdds() {
        ReusableMethods.flash(page.checkNewAd, getDriver());
        assertTrue(page.checkNewAd.isDisplayed());
        ReusableMethods.wait(1);
    }

    @And("selects the edit button on the newly created ad")
    public void selectsTheEditButtonOnTheNewlyCreatedAd() {
        String text = "AutomationTest";
        ReusableMethods.clickEditButtonForItem(text);
    }

    @When("user edits new add")
    public void userEditsNewAdd() {
        ReusableMethods.wait(1);
        page.adTypeInputTwo.clear();
        page.adTypeInputTwo.sendKeys("GoodQuality");
        page.saveBtn.click();
    }

    @Then("new ad successfully edits")
    public void newAdSuccessfullyEdits() {
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkEditAd, getDriver());
        assertTrue(page.checkEditAd.isDisplayed());
        ReusableMethods.wait(1);
    }

    @When("user selects the delete button on the newly created ad")
    public void userSelectsTheDeleteButtonOnTheNewlyCreatedAd() {
        String text = "GoodQuality";
        ReusableMethods.clickDeleteButtonForItem(text);
        ReusableMethods.wait(1);
        page.deleteYes.click();
    }

    @Then("new ad successfully deletes")
    public void newAdSuccessfullyDeletes() {
        ReusableMethods.wait(1);
        ReusableMethods.assertElementNotDisplayed(page.checkEditAd);
    }

    @And("user switches to the calendar tab")
    public void userSwitchesToTheCalendarTab() {
        page.calendar.click();
        ReusableMethods.wait(1);
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
        ReusableMethods.sendKeysJS("Friday",page.cateInputSec);
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
        ReusableMethods.wait(1);

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
      String text ="Abbas Təbriklər";
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
}