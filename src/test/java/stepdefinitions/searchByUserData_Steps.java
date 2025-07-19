package stepdefinitions;

import Page.registration_Page;
import Page.searchByUserData_Page;
import Page.structureAndDuties_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class searchByUserData_Steps {
    searchByUserData_Page page = new searchByUserData_Page();
    registration_Page regPage = new registration_Page();
    structureAndDuties_Page structureAndDuties = new structureAndDuties_Page();
    String getTableData;

    @And("adds name to the name field in the filter")
    public void addsNameToTheNameFieldInTheFilter() {
        ReusableMethods.waitForClickabilityAndClick(page.nameFilter, 10);
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        getTableData = page.getTableDataText.getText();
        System.out.println("expected = " + getTableData);
        ReusableMethods.flash(page.getTableDataText, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(page.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        structureAndDuties.nameField.sendKeys("Abbas");
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to search name params")
    public void searchResultsAreDisplayedByAccordingToSearchNameParams() {
        String text = page.name.getText();
        System.out.println("text = " + text);
        ReusableMethods.flash(page.name, getDriver());
        assertTrue(text.contains("Abbas Rzayev"));
    }

    @And("adds surname to the surname field in the filter")
    public void addsSurnameToTheSurnameFieldInTheFilter() {
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(page.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        structureAndDuties.nameField.sendKeys("Abbas");
        ReusableMethods.wait(1);
        page.surname.sendKeys("RZAYEV");
    }

    @Then("search results are displayed by according to search surname params")
    public void searchResultsAreDisplayedByAccordingToSearchSurnameParams() {
        String text = page.name.getText();
        System.out.println("text = " + text);
        ReusableMethods.flash(page.name, getDriver());
        assertTrue(text.contains("Rzayev"));

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

    @And("adds pin to the pin field in the filter")
    public void addsPinToThePinFieldInTheFilter() {
        ReusableMethods.waitForClickabilityAndClick(page.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        page.finField.sendKeys("19HSHLY");
    }

    @Then("search results are displayed by according to search pin params")
    public void searchResultsAreDisplayedByAccordingToSearchPinParams() {
        page.foundName.click();
        ReusableMethods.wait(1);
        System.out.println(page.pinText.getText());
        String text = page.pinText.getText();
        ReusableMethods.flash(page.pinText, getDriver());
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
        ReusableMethods.wait(1);
        String orgName = "Keyfiyyətə Nəzarət(AT)";
        List<WebElement> rows = getDriver().findElements(By.xpath("//tbody[@class='mdc-data-table__content']"));
        int count = 0;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                String cellText = cell.getText();
                if (cellText.contains("Keyfiyyətə Nəzarət(AT)")) {
                    ReusableMethods.flash(cell, getDriver());
                    count++;
                    //break;
                }
            }
        }
        System.out.println("Total occurrences found: " + count);
    }

    @When("user selects enter in the users tab")
    public void userSelectsEnterInTheUsersTab() {
        getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
    }

    @When("user reset the changes")
    public void userResetTheChanges() {
        ReusableMethods.waitForClickabilityAndClick(page.nameFilter, 10);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 10);
        ReusableMethods.waitForClickabilityAndClick(page.restTheChanges, 10);
        ReusableMethods.wait(1);
        while (true) {
            try {
                if (!page.filterModal.isDisplayed()) {
                    break;
                }
                ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 10);
                ReusableMethods.wait(1);
            } catch (NoSuchElementException noSuchElementException) {
                break;
            }
        }
    }

    @When("user reset the changes for {string}")
    public void userResetTheChangesFor(String selection) {
        if(selection.contains("duty")) {
            ReusableMethods.waitForClickabilityAndClick(page.dutyInputSecond, 5);
            ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.restTheChanges, 5);
            ReusableMethods.wait(1);
            while (true) {
                try {
                    if (!page.filterModal.isDisplayed()) {
                        break;
                    }
                    ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 5);
                    ReusableMethods.wait(1);
                } catch (NoSuchElementException noSuchElementException) {
                    break;
                }
            }
        }
        else if(selection.contains("direction")) {
            ReusableMethods.waitForClickabilityAndClick(page.dutyInputSecond, 5);
            ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.restTheChanges, 5);
            ReusableMethods.wait(1);
            while (true) {
                try {
                    if (!page.filterModal.isDisplayed()) {
                        break;
                    }
                    ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 5);
                    ReusableMethods.wait(1);
                } catch (NoSuchElementException noSuchElementException) {
                    break;
                }
            }
        }
    }

    @Then("the changes is successfully resets")
    public void theChangesIsSuccessfullyResets() {
        ReusableMethods.wait(1);
//        ReusableMethods.pageDown();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        ReusableMethods.flash(page.getTableDataText, getDriver());
        System.out.println("expectedTableDataText = " + getTableData);
        String actualTableText = page.getTableDataText.getText();
        System.out.println("actualTableDataText = " + page.getTableDataText.getText());
        ReusableMethods.wait(2);
        Assert.assertEquals(getTableData, actualTableText);
    }

    @And("adds duty to the duty field in the filter")
    public void addsDutyToTheDutyFieldInTheFilter() {
//        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        ReusableMethods.wait(1);
        getTableData = page.getTableDataText.getText();
        System.out.println("expected = " + getTableData);
        ReusableMethods.flash(page.getTableDataText, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(page.dutyFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        page.dutyInput.sendKeys("QA_AT");
        ReusableMethods.wait(1);
        ReusableMethods.waitForClickabilityAndClick(page.dutyQASelect, 10);
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to search duty params")
    public void searchResultsAreDisplayedByAccordingToSearchDutyParams() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        boolean matchFound = false;
        int retries = 3;

        for (int attempt = 0; attempt < retries; attempt++) {
            try {
                List<WebElement> positionCells = getDriver().findElements(By.cssSelector("td.cdk-column-organizationPosition"));

                for (WebElement cell : positionCells) {
                    String text = cell.getText().trim();
                    if (text.equals("QA_AT")) {
                        System.out.println("Uyğunsuz dəyər tapıldı: " + text);
                        matchFound = true;

                        String flashScript =
                                "let element = arguments[0];" +
                                        "let originalColor = element.style.backgroundColor;" +
                                        "let i = 0;" +
                                        "let interval = setInterval(() => {" +
                                        "  element.style.backgroundColor = (element.style.backgroundColor === 'green' ? originalColor : 'green');" +
                                        "  i++;" +
                                        "  if(i === 6) {" +
                                        "    clearInterval(interval);" +
                                        "    element.style.backgroundColor = originalColor;" +
                                        "  }" +
                                        "}, 300);";
                        js.executeScript(flashScript, cell);
                        break; // uğurla tapıldısa, artıq təkrar yox
                    }
                }
//                break; // uğurla bitdisə, artıq retry etmə
            } catch (StaleElementReferenceException e) {
                System.out.println("DOM dəyişdi, yenidən yoxlanır... Attempt " + (attempt + 1));
                ReusableMethods.wait(1); // kiçik gözləmə
            }
        }

        ReusableMethods.wait(2);
        if (!matchFound) {
            throw new AssertionError("XƏTA: Heç bir nəticə 'QA_AT' ilə uyğun gəlmir!");
        }
    }

    @When("user selects enter in the users tab for duty")
    public void userSelectsEnterInTheUsersTabForDuty() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
//        WebElement element = getDriver().findElement(By.xpath("//div[@class='content-heading']"));
//        element.click();
//        ReusableMethods.wait(1);
//        element.click();
//        Actions actions = new Actions(getDriver());
//        actions.moveByOffset(10, 10).click().perform();
//        page.closeFilterModal.click();
//        ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 5);
//        ReusableMethods.wait(2);
    }

    @And("adds workplace {string} to the workplace field in the filter")
    public void addsWorkplaceToTheWorkplaceFieldInTheFilter(String workPlace) {
        if (workPlace.contains("Keyfiyyətə Nəzarət(AT)")) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            getTableData = page.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(page.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(page.structureFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
            page.structureInput.sendKeys("Keyfiyyətə Nəzarət(AT)");
        }
    }

    @When("user reset the changes for workplace")
    public void userResetTheChangesForWorkplace() {
        ReusableMethods.waitForClickabilityAndClick(page.structureFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.restTheChanges, 5);
        ReusableMethods.wait(1);
        while (true) {
            try {
                if (!page.filterModal.isDisplayed()) {
                    break;
                }
                ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 5);
                ReusableMethods.wait(1);
            } catch (NoSuchElementException noSuchElementException) {
                break;
            }
        }
    }

    @And("selects verification of the situation where the administrator approves in the filter")
    public void selectsVerificationOfTheSituationWhereTheAdministratorApprovesInTheFilter() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        getTableData = page.getTableDataText.getText();
        ReusableMethods.flash(page.getTableDataText, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(page.adminConfirmedFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.adminApprovalList, 5);
        ReusableMethods.waitForClickabilityAndClick(page.selectAdminApproval, 5);
        ReusableMethods.wait(2);
    }
    @And("selects verification of the situation where the administrator {string} in the filter")
    public void selectsVerificationOfTheSituationWhereTheAdministratorInTheFilter(String approval) {
        if(approval.contains("applied")){
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(2);
            getTableData = page.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(page.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(page.adminConfirmedFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.adminApprovalList, 5);
            ReusableMethods.waitForClickabilityAndClick(page.selectAdminApproval, 5);
            ReusableMethods.wait(2);
        }
        else if (approval.contains("not")) {
            System.out.println("im here");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(2);
            getTableData = page.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(page.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(page.adminConfirmedFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(page.adminApprovalList, 5);
            ReusableMethods.waitForClickabilityAndClick(page.selectAdminNotApproval, 5);
            ReusableMethods.wait(2);
        }
    }

    @When("user selects enter in the users tab for admin approval")
    public void userSelectsEnterInTheUsersTabForAdminApproval() {
        ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 5);
        ReusableMethods.wait(2);
    }

    @Then("search results are displayed by according to admin approval params")
    public void searchResultsAreDisplayedByAccordingToAdminApprovalParams() {
        List<WebElement> statusCells = getDriver().findElements(By.cssSelector("td.cdk-column-isConfirmedByAdmin"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        for (WebElement cell : statusCells) {
            String iconText = "";
            try {
                // Hüceyrənin içindəki <mat-icon> textini al
                WebElement icon = cell.findElement(By.tagName("mat-icon"));
                iconText = icon.getText().trim();
            } catch (Exception e) {
                System.out.println("mat-icon tapılmadı: " + e.getMessage());
                continue;
            }

            if (iconText.equals("check") || iconText.equals("close")) {
                System.out.println("Uyğun status tapıldı: " + iconText);
                String flashScript =
                        "let element = arguments[0];" +
                                "let originalColor = element.style.backgroundColor;" +
                                "let i = 0;" +
                                "let interval = setInterval(() => {" +
                                "  element.style.backgroundColor = (element.style.backgroundColor === 'green' ? originalColor : 'green');" +
                                "  i++;" +
                                "  if(i === 6) {" +
                                "    clearInterval(interval);" +
                                "    element.style.backgroundColor = originalColor;" +
                                "  }" +
                                "}, 300);";
                js.executeScript(flashScript, cell);
            }
        }
        ReusableMethods.wait(2);
    }

    @When("user reset the changes for admin approval")
    public void userResetTheChangesForAdminApproval() {
        ReusableMethods.waitForClickabilityAndClick(page.adminConfirmedFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.openFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(page.restTheChanges, 5);
        ReusableMethods.wait(1);
        while (true) {
            try {
                if (!page.filterModal.isDisplayed()) {
                    break;
                }
                ReusableMethods.waitForClickabilityAndClick(page.closeFilterModal, 5);
                ReusableMethods.wait(1);
            } catch (NoSuchElementException noSuchElementException) {
                break;
            }
        }
    }
}