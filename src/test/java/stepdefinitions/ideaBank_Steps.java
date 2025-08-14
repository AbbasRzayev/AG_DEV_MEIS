package stepdefinitions;

import Page.ideaBank_Page;
import Page.structureAndDuties_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.changeColor;

public class ideaBank_Steps {
    ideaBank_Page page = new ideaBank_Page();
    structureAndDuties_Page structure = new structureAndDuties_Page();

    String expectAll;
    String expectPending;
    String expectAccept;
    String expectCancel;

    int expectLike;
    int expectUnlike;
    int expCommentCount;


    @And("goes to the idea bank tab from main page")
    public void goesToTheIdeaBankTabFromMainPage() {
        ReusableMethods.wait(2);
        page.ideaBankMainPage.click();
        ReusableMethods.wait(1);
        expectAll = page.allCounter.getText();
        System.out.println(expectAll);
        expectPending = page.pendingCounter.getText();
        System.out.println(expectPending);
        expectAccept = page.acceptedCounter.getText();
        System.out.println(expectAccept);
        expectCancel = page.canceledCounter.getText();
        System.out.println(expectCancel);
//        page.ideaBankClick.click();
//        ReusableMethods.wait(1);
    }


    @And("selects add new idea button")
    public void selectsAddNewIdeaButton() {
        page.newIdeaAddBtn.click();
        ReusableMethods.wait(1);
    }

    @When("user adds new idea by selecting save button")
    public void addsNewIdeaBySelectingSaveButton() throws InterruptedException {
        page.directionDropDown.click();
        ReusableMethods.wait(1);
        page.otherSelectFromList.click();
        ReusableMethods.wait(1);
        page.ideaInput.sendKeys("Yeni idea bankı üçün qeyd əlavə edilmişdir");
        page.saveBtn.click();
        ReusableMethods.wait(1);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement popupMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(., 'Təsdiq edildi')]  ")));
        String messageText = popupMessage.getText();
        System.out.println("Popup message text is: " + messageText);

        String elementColor = popupMessage.getCssValue("backgroundColor"); //elementin arka rengini alir
        for (int i = 0; i < 10; i++) {
            // changeColor("rgb(0,0,0)", element, driver);// elemente siyah ren verir
            changeColor("rgb(0, 0, 0)", popupMessage, getDriver());// elemente kirmizi ren verir
            //changeColor("rgb(0,255,0)", element, driver);// elemente yesil ren verir
            changeColor(elementColor, popupMessage, getDriver());
        }
    }

    @Then("the all ideas and pending status counters are updated and displayed correctly")
    public void theAllIdeasAndPendingStatusCountersAreUpdatedAndDisplayedCorrectly() {
        ReusableMethods.flash(page.allCounter, getDriver());
        String elementText = page.allCounter.getText();
        String[] parts1 = elementText.split(":");
        int actualAll = Integer.parseInt(parts1[1].trim());

        String[] parts = expectAll.split(":");
        int expectAll = Integer.parseInt(parts[1].trim());
        int plus = expectAll + 1;

        System.out.println("expectedAll = " + plus);
        System.out.println("actualAll = " + actualAll);
        assertEquals(plus, actualAll);

        ReusableMethods.flash(page.pendingCounter, getDriver());
        String elementTextPending = page.pendingCounter.getText();
        String[] parts2 = elementTextPending.split(":");
        int actualPending = Integer.parseInt(parts2[1].trim());

        String[] partsPending = expectPending.split(":");
        int expectPending = Integer.parseInt(partsPending[1].trim());
        int exPending = expectPending + 1;

        System.out.println("expectedAll = " + exPending);
        System.out.println("actualAll = " + actualAll);
        assertEquals(exPending, actualPending);
    }

    @And("switches to the idea bank tab from admin panel")
    public void switchesToTheIdeaBankTabFromAdminPanel() {
        structure.controlPanel.click();
        ReusableMethods.wait(1);
        page.adminPanelIdeaBankTab.click();
        ReusableMethods.wait(1);
    }

    @When("user switches to the idea tab from sidebar")
    public void userSwitchesToTheIdeaTabFromSidebar() {
        page.ideaBankSidebare.click();
        ReusableMethods.wait(1);
    }

    @And("user with role admin changes the status of the idea to accepted status")
    public void userWithRoleAdminChangesTheStatusOfTheIdeaToAcceptedStatus() {
        page.ideaData.click();
        page.openSort.click();
        ReusableMethods.wait(1);
        page.statusList.click();
        ReusableMethods.wait(1);
        page.selectStatusAcceptedBtn.click();
        ReusableMethods.wait(1);
        page.reasonInput.sendKeys("Accepted.");
        ReusableMethods.wait(1);
        page.saveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the idea has successfully changed to accepted status and the accepted status counter is displayed correctly")
    public void theStatusOfTheIdeaHasSuccessfullyChangedToAcceptedStatusAndThePendingStatusCounterIsDisplayedCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String status = row.get("Status");

            ReusableMethods.flash(page.acceptedCounter, getDriver());
            String elementText = page.acceptedCounter.getText();
            String[] parts1 = elementText.split(":");
            int actualAccepted = Integer.parseInt(parts1[1].trim());

            String[] parts = expectAccept.split(":");
            int expectAcc = Integer.parseInt(parts[1].trim());
            int exAccepted = expectAcc + 1;

            System.out.println("expectedAll = " + exAccepted);
            System.out.println("actualAll = " + actualAccepted);
            assertEquals(exAccepted, actualAccepted);

            ReusableMethods.flash(page.statusIdea, getDriver());
            Assert.assertEquals(page.statusIdea.getText().trim(), status);
            ReusableMethods.wait(1);
        }
    }

    @And("user with role admin changes the status of the idea to canceled status")
    public void userWithRoleAdminChangesTheStatusOfTheIdeaToCanceledStatus() {
        page.ideaData.click();
        page.openSort.click();
        ReusableMethods.wait(1);
        page.statusList.click();
        ReusableMethods.wait(1);
        page.selectStatusCanceledBtn.click();
        ReusableMethods.wait(1);
        page.reasonInput.sendKeys("Canceled.");
        ReusableMethods.wait(1);
        page.saveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the idea has successfully changed to canceled status and the canceled status counter is displayed correctly")
    public void theStatusOfTheIdeaHasSuccessfullyChangedToCanceledStatusAndTheCanceledStatusCounterIsDisplayedCorrectly(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> row : data) {
            String status = row.get("Status");

            ReusableMethods.flash(page.canceledCounter, getDriver());
            String elementText = page.canceledCounter.getText();
            String[] parts1 = elementText.split(":");
            int actualAccepted = Integer.parseInt(parts1[1].trim());

            String[] parts = expectCancel.split(":");
            int expectAcc = Integer.parseInt(parts[1].trim());
            int exAccepted = expectAcc + 1;

            System.out.println("expectedAll = " + exAccepted);
            System.out.println("actualAll = " + actualAccepted);
            assertEquals(exAccepted, actualAccepted);

            ReusableMethods.flash(page.statusIdea, getDriver());
            Assert.assertEquals(page.statusIdea.getText().trim(), status);
            ReusableMethods.wait(1);
        }
    }

    @When("user selects like button")
    public void userSelectsLikeButton() {
        page.ideaData.click();
        ReusableMethods.wait(1);
        expectLike = Integer.parseInt(page.flashLike.getText().trim());
        System.out.println("expectLike = " + expectLike);
        expectUnlike = Integer.parseInt(page.flashUnLike.getText().trim());
        System.out.println("expectUnlike = " + expectUnlike);
        expCommentCount = Integer.parseInt(page.flashCom.getText().trim());
        System.out.println("expCommentCount = " + expCommentCount);
        page.likeBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the like buttons counter is displayed correctly")
    public void theLikeButtonsCounterIsDisplayedCorrectly() {
        String valueText = page.flashLike.getText().trim();
        System.out.println("value = " + valueText);
        int actLike = Integer.parseInt(valueText.trim());
        System.out.println("actLike = " + actLike);
        ReusableMethods.flash(page.flashLike,getDriver());
        int exLike = expectLike + 1;
        assertEquals(exLike, actLike);
    }

    @When("user selects unlike button")
    public void userSelectsUnlikeButton() {
        page.unlikeBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the unlike buttons counter is displayed correctly")
    public void theUnlikeButtonsCounterIsDisplayedCorrectly() {
        String valueText = page.flashUnLike.getText().trim();
        System.out.println("value = " + valueText);
        int actUnLike = Integer.parseInt(valueText.trim());
        System.out.println("actLike = " + actUnLike);
        ReusableMethods.flash(page.flashUnLike,getDriver());
        int exUnLike = expectLike + 1;
        assertEquals(exUnLike, actUnLike);
    }

    @When("user adds comment")
    public void userAddsComment() {
//        page.ideaData.click();
        page.detailedBtn.click();
        ReusableMethods.wait(1);
        page.commentInput.sendKeys("Maraqlı təklifdir");
        ReusableMethods.wait(1);
        page.sendComment.click();
        ReusableMethods.wait(1);
    }

    @Then("added comment is displayed correctly")
    public void addedCommentIsDisplayedCorrectly(DataTable dataTable) {
     List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for  (Map<String,String> row : data) {
            String comment = row.get("Rəy");
            ReusableMethods.flash(page.commentDisplay, getDriver());
            Assert.assertEquals(page.commentDisplay.getText().trim(), comment);
            ReusableMethods.wait(1);
        }
    }

    @When("user deletes idea bank by selecting delete button")
    public void userDeletesIdeaBankBySelectingDeleteButton() {
        page.ideaData.click();
        ReusableMethods.wait(1);
        page.ideaDeleteBtn.click();
        ReusableMethods.wait(1);
        page.confirmDeleteBtn.click();
        ReusableMethods.wait(1);

    }

    @Then("the idea has successfully deleted in the admin panel")
    public void theIdeaHasSuccessfullyDeletedInTheAdminPanel() {
        while (true) {
            try {
                if (!page.ideaData.isDisplayed()) {
                    break;
                }
                page.ideaData.click();
                ReusableMethods.wait(1);
                page.ideaDeleteBtn.click();
                ReusableMethods.wait(1);
                page.confirmDeleteBtn.click();
                ReusableMethods.wait(1);
            } catch (NoSuchElementException noSuchElementException) {
                break;
            }
        }
    }

    @And("switches to the idea bank tab from the admin panel")
    public void switchesToTheIdeaBankTabFromTheAdminpanel() {
        page.adminSidebare.click();
        ReusableMethods.wait(1);
        page.adminPanelIdeaBankTab.click();
        ReusableMethods.wait(1);
        page.openSort.click();
        ReusableMethods.wait(1);
        page.statusList.click();
        ReusableMethods.wait(1);
    }

    @Then("the information about new idea is displayed correctly in the idea bank section")
    public void theInformationAboutNewIdeaIsDisplayedCorrectlyInTheIdeaBankSection(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String direction = row.get("İstiqamət");
            String whoIsIdea = row.get("Fikir bildirən");
            String structure = row.get("Struktur");
            String status = row.get("Status");
            String note = row.get("Qeyd");

            ReusableMethods.flash(page.direction, getDriver());
            Assert.assertEquals(page.direction.getText().trim(), direction);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.whoIsIdea, getDriver());
            Assert.assertEquals(page.whoIsIdea.getText().trim(), whoIsIdea);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.structureIdea, getDriver());
            Assert.assertEquals(page.structureIdea.getText().trim(), structure);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.statusIdea, getDriver());
            Assert.assertEquals(page.statusIdea.getText().trim(), status);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.ideaData, getDriver());
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = today.format(formatter);
            Assert.assertEquals(page.ideaData.getText().trim(), formattedDate);
            ReusableMethods.wait(1);
            page.ideaData.click();
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.noteIdea, getDriver());
            Assert.assertEquals(page.noteIdea.getText().trim(), note);
            ReusableMethods.wait(1);
        }
    }

    @Then("the comment counter is displayed correctly")
    public void theCommentCounterIsDisplayedCorrectly() {
        page.closeCommentModal.click();
        ReusableMethods.wait(1);

//        getDriver().navigate().refresh();
//        page.ideaData.click();
//        ReusableMethods.wait(1);
//        Bug var

        String valueText = page.flashCom.getText().trim();
        System.out.println("value = " + valueText);
        int actComment = Integer.parseInt(valueText.trim());
        System.out.println("actLike = " + actComment);
        ReusableMethods.flash(page.flashCom,getDriver());
        int exUnLike = expCommentCount + 1;
        assertEquals(exUnLike, actComment);
    }

    @Then("the deleted idea is not displayed in the idea tab from sidebar")
    public void theDeletedIdeaIsNotDisplayedInTheIdeaTabFromSidebar() {
        ReusableMethods.wait(1);
        ReusableMethods.assertElementNotDisplayed(page.ideaData);
    }
}