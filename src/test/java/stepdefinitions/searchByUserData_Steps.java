package stepdefinitions;

import Page.registration_Page;
import Page.searchByUserData_Page;
import Page.structureAndDuties_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class searchByUserData_Steps {
    searchByUserData_Page page = new searchByUserData_Page();
    registration_Page regPage = new registration_Page();
    structureAndDuties_Page somePage = new structureAndDuties_Page();

    @And("adds name to the name field")
    public void addsNameToTheNameField() {
        somePage.nameField.sendKeys("Abbas");
        ReusableMethods.wait(1);
        somePage.searchButton.click();
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to search name params")
    public void searchResultsAreDisplayedByAccordingToSearchNameParams() {
        String text = page.name.getText();
        System.out.println("text = " + text);
        ReusableMethods.flash(page.name, getDriver());
        assertTrue(text.contains("Abbas"));
        page.clearFields.click();
    }

    @And("adds surname to the surname field")
    public void addsSurnameToTheSurnameField() {
        somePage.nameField.sendKeys("Abbas");
        page.surename.sendKeys("RZAYEV");
        ReusableMethods.wait(1);
        somePage.searchButton.click();
    }

    @Then("search results are displayed by according to search surname params")
    public void searchResultsAreDisplayedByAccordingToSearchSurnameParams() {
        String text = page.name.getText();
        System.out.println("text = " + text);
        ReusableMethods.flash(page.name, getDriver());
        assertTrue(text.contains("Rzayev"));
        page.clearFields.click();

    }


    @And("selects unverified from verification status dropdown list")
    public void selectsUnverifiedFromVerificationStatusDropdownList() {
        page.dropDown.click();
        ReusableMethods.wait(1);
        page.unverifiedList.click();
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to verification status")
    public void searchResultsAreDisplayedByAccordingToVerificationStatus() {
        ReusableMethods.flash(page.unverified, getDriver());
        assertTrue(page.unverified.isDisplayed());
        page.clearFields.click();
    }

    @And("selects admin confirmed from verification status dropdown list")
    public void selectsAdminConfirmedFromVerificationStatusDropdownList() {
        page.dropDown.click();
        ReusableMethods.wait(1);
        page.inspectAcc.click();
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to the verification status")
    public void searchResultsAreDisplayedByAccordingToTheVerificationStatus() {
        ReusableMethods.flash(page.inspectorAccept, getDriver());
        assertTrue(page.inspectorAccept.isDisplayed());
        page.clearFields.click();
    }

    @And("adds fathers name to the fathers name field")
    public void addsFathersnameToTheFathersnameField() {
        page.fatherNameField.sendKeys("Fuad");
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to search fathersname params")
    public void searchResultsAreDisplayedByAccordingToSearchFathersnameParams() {
        page.foundName.click();
        ReusableMethods.wait(1);
        String text = page.fatherNameText.getText();
        System.out.println(page.fatherNameText);
        ReusableMethods.flash(page.fatherNameText, getDriver());
        assertTrue(text.contains("FUAD"));
        getDriver().navigate().back();
        ReusableMethods.wait(1);
    }

    @And("adds pin to the pin field")
    public void addsPinToThePinField() {
        page.finField.sendKeys("19HSHLY");
        ReusableMethods.wait(1);

    }

    @Then("search results are displayed by according to search pin params")
    public void searchResultsAreDisplayedByAccordingToSearchPinParams() {
        page.foundName.click();
        ReusableMethods.wait(1);
        System.out.println(page.fintext.getText());
        String text = page.fintext.getText();
        ReusableMethods.flash(page.fintext, getDriver());
        assertTrue(text.contains("19HSHLY"));
        getDriver().navigate().back();
        ReusableMethods.wait(1);
    }

    @And("adds workplace to the workplace field")
    public void addsWorkplaceToTheWorkplaceField() {

        ReusableMethods.wait(1);
        page.clearFields.click();
        //ReusableMethods.sendKeysJS("Azərbaycan Metrologiya İnstitutu",page.workPlaceInput);
        page.workPlaceInput.sendKeys("Azərbaycan Metrologiya İnstitutu");
        ReusableMethods.wait(1);
    }

    @When("user selects search button in the users tab")
    public void userSelectsSearchButtonInTheUsersTab() {
        page.searchBtn.click();
        // ReusableMethods.clickByJavaScript(page.searchBtn);
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to search workplace params")
    public void searchResultsAreDisplayedByAccordingToSearchWorkplaceParams() {
//        ReusableMethods.flash(page.workPlace,getDriver());
//        assertTrue(page.workPlace.isDisplayed());
        ReusableMethods.wait(1);
        String orgName = "Azərbaycan Metrologiya İnstitutu";
        List<WebElement> rows = getDriver().findElements(By.xpath("//tbody[@class='mdc-data-table__content']"));
        int count = 0;
        for (WebElement row : rows) {
            // Find the <td> element containing the organization text
            //WebElement organizationElement = row.findElement(By.cssSelector("td.mat-column-organization"));
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                String cellText = cell.getText();
                if (cellText.contains("Azərbaycan Metrologiya İnstitutu")) {
                    ReusableMethods.flash(cell,getDriver());
                    count++;
                    //break;
                }
            }
        }
        System.out.println("Total occurrences found: " + count);
    }
}
            // Get the text from the organization element
            //String organizationText = organizationElement.getText();

            // Check if the organization text matches the desired text
//            if (organizationText.contains("Azərbaycan Metrologiya İnstitutu")) {
//                // Flash the matching element
//                ReusableMethods.flash(organizationElement, getDriver());
//                count++;
//            }
//        }
//        return count;