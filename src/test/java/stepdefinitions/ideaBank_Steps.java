package stepdefinitions;

import Page.ideaBank_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.changeColor;

public class ideaBank_Steps {
    ideaBank_Page page = new ideaBank_Page();

    String expectAll;
    String expectPending;
    String expectAccept;
    String expectCancel;

    int expectLike;
    int expectUnlike;
    int expCommentCount;


    @And("goes to the idea bank tab from main page")
    public void goesToTheIdeaBankTabFromMainPage() {
        page.ideaBankMainPage.click();
        ReusableMethods.wait(1);
        expectAll=page.scetcik.getText();
        System.out.println(expectAll);
        expectPending=page.scetcikPending.getText();
        System.out.println("expectPending = " + expectPending);
        expectAccept=page.scetcikAccepted.getText();
        System.out.println("expectAccept = " + expectAccept);
        expectCancel=page.scetcikCanceled.getText();
        System.out.println("expectCancel = " + expectCancel);
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
        page.ideaInput.sendKeys("Test message");
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
    @Then("the  all ideas status counter is changed and displayed correctly")
    public void theAllIdeasStatusCounterIsChangedAndDisplayedCorrectly() {
        WebElement allCheck = getDriver().findElement(By.cssSelector("span.green.ng-star-inserted"));
        ReusableMethods.flash(allCheck,getDriver());
        String elementText = allCheck.getText();
        String[] parts1 = elementText.split(":");
        int actualAll = Integer.parseInt(parts1[1].trim());

        String[] parts = expectAll.split(":");
        int expectAll = Integer.parseInt(parts[1].trim());
        int plus = expectAll+1;

        System.out.println("expectedAll = " + plus);
        System.out.println("actualAll = " + actualAll);
        assertEquals(plus,actualAll);

    }

    @And("switches to the idea bank tab from admin panel")
    public void switchesToTheIdeaBankTabFromAdminPanel() {
        page.adminSidebare.click();
        ReusableMethods.wait(1);
        page.adminPanelIdeaBankTab.click();
        ReusableMethods.wait(1);
    }

    @And("user with role admin changes the status of the idea to pending status")
    public void userWithRoleAdminChangesTheStatusOfTheIdeaToPendingStatus() {
        page.ideaBankClick.click();
        ReusableMethods.wait(1);
        page.openSort.click();
        ReusableMethods.wait(1);
        page.selectSortByDate.click();
        ReusableMethods.wait(1);
        page.actualStatusBtn.click();
        ReusableMethods.wait(1);
        ReusableMethods.clickByJavaScript(page.changeStatusBtn);
        //page.changeStatusBtn.click();
        ReusableMethods.wait(1);
        page.selectStatusBtn.click();
        page.reasonInput.sendKeys("Pending...");
        ReusableMethods.wait(1);
        page.saveBtn.click();
        ReusableMethods.wait(1);

        WebElement thumbUpIcon = getDriver().findElement(By.xpath("//mat-icon[text()='thumb_up']"));
        WebElement parentDiv = thumbUpIcon.findElement(By.xpath("./ancestor::div[1]"));
        WebElement valueSpan = parentDiv.findElement(By.xpath("./span[not(@class)]"));
        String valueText = valueSpan.getText().trim();
        System.out.println("value = " + valueText);
        expectLike = Integer.parseInt(valueText.trim());
        System.out.println("like = " + expectLike);

        WebElement thumbdownIcon = getDriver().findElement(By.xpath("//mat-icon[text()='thumb_down']"));
        WebElement parentDiv1 = thumbdownIcon.findElement(By.xpath("./ancestor::div[1]"));
        WebElement valueSpan1 = parentDiv1.findElement(By.xpath("./span[not(@class)]"));
        String valueText1 = valueSpan1.getText().trim();
        System.out.println("value = " + valueText1);
        expectUnlike = Integer.parseInt(valueText1.trim());
        System.out.println("unlike = " + expectUnlike);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement statisticActionDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'statistic-action')])[3]")));
        WebElement commentCountSpan = statisticActionDiv.findElement(By.xpath(".//span[contains(@class, 'comment-count')]"));
        String valcom = commentCountSpan.getText().trim();
        System.out.println("valcom = " + valcom);
        expCommentCount=Integer.parseInt(valcom.trim());
    }

    @When("user switches to the idea tab from sidebar")
    public void userSwitchesToTheIdeaTabFromSidebar() {
        page.ideaBankSidebare.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the idea has successfully changed to pending status and the pending status counter is displayed correctly")
    public void theStatusOfTheIdeaHasSuccessfullyChangedToPendingStatusAndThePendingStatusCounterIsDisplayedCorrectly() {
        page.ideaBankClick.click();
        ReusableMethods.wait(1);
        //ReusableMethods.flash(page.ideaTextCheck,getDriver());
        ReusableMethods.wait(1);

        WebElement pendigCheck = getDriver().findElement(By.cssSelector("span.warn.ng-star-inserted"));
        ReusableMethods.flash(pendigCheck,getDriver());
        String elementText = pendigCheck.getText();
        String[] parts1 = elementText.split(":");
        int actualPen = Integer.parseInt(parts1[1].trim());

        String[] parts = expectPending.split(":");
        int expectPen = Integer.parseInt(parts[1].trim());
        int exPending = expectPen+1;

        System.out.println("expectedAll = " + exPending);
        System.out.println("actualAll = " + actualPen);
        assertEquals(exPending,actualPen);
    }


    @And("user with role admin changes the status of the idea to accepted status")
    public void userWithRoleAdminChangesTheStatusOfTheIdeaToAcceptedStatus() {
        page.openSort.click();
        ReusableMethods.wait(1);
        page.selectSortByDate.click();
        ReusableMethods.wait(1);
        page.ideaBankClick.click();
        ReusableMethods.wait(1);
        page.actualStatusBtn.click();
        ReusableMethods.wait(1);
        page.changeStatusBtn3.click();
        ReusableMethods.wait(1);
        page.selectStatusAcceptedBtn.click();
        ReusableMethods.wait(1);
        page.reasonInput3.sendKeys("Accepted...");
        ReusableMethods.wait(1);
        page.saveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the idea has successfully changed to accepted status and the accepted status counter is displayed correctly")
    public void theStatusOfTheIdeaHasSuccessfullyChangedToAcceptedStatusAndThePendingStatusCounterIsDisplayedCorrectly() {
        page.ideaBankClick.click();
        ReusableMethods.wait(1);
        WebElement acceptedCheck = getDriver().findElement(By.cssSelector("span.blue.ng-star-inserted"));
        ReusableMethods.flash(acceptedCheck,getDriver());
        String elementText = acceptedCheck.getText();
        String[] parts1 = elementText.split(":");
        int actualAccepted = Integer.parseInt(parts1[1].trim());

        String[] parts = expectAccept.split(":");
        int expectAcc = Integer.parseInt(parts[1].trim());
        int exAccepted = expectAcc+1;

        System.out.println("expectedAll = " + exAccepted);
        System.out.println("actualAll = " + actualAccepted);
        assertEquals(exAccepted,actualAccepted);
    }

    @And("user with role admin changes the status of the idea to canceled status")
    public void userWithRoleAdminChangesTheStatusOfTheIdeaToCanceledStatus() {
        page.openSort.click();
        ReusableMethods.wait(1);
        page.selectSortByDate.click();
        ReusableMethods.wait(1);
        page.ideaBankClick.click();
        ReusableMethods.wait(1);
        page.actualStatusBtn.click();
        ReusableMethods.wait(1);
        page.changeStatusBtn4.click();
        ReusableMethods.wait(1);
        page.selectStatusCanceledBtn.click();
        ReusableMethods.wait(1);
        page.reasonInput4.sendKeys("Canceled...");
        ReusableMethods.wait(1);
        page.saveBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the idea has successfully changed to canceled status and the canceled status counter is displayed correctly")
    public void theStatusOfTheIdeaHasSuccessfullyChangedToCanceledStatusAndTheCanceledStatusCounterIsDisplayedCorrectly() {
        page.ideaBankClick.click();
        ReusableMethods.wait(1);
        WebElement canceledCheck = getDriver().findElement(By.cssSelector("span.red.ng-star-inserted"));
        ReusableMethods.flash(canceledCheck,getDriver());
        String elementText = canceledCheck.getText();
        String[] parts1 = elementText.split(":");
        int actualCanceled = Integer.parseInt(parts1[1].trim());

        String[] parts = expectCancel.split(":");
        int expectCan = Integer.parseInt(parts[1].trim());
        int exCanceled = expectCan+1;
        System.out.println("expectedAll = " + exCanceled);
        System.out.println("actualAll = " + actualCanceled);

    }

    @When("user selects like button")
    public void userSelectsLikeButton() {
        page.likeBtn.click();
        ReusableMethods.wait(1);

    }

    @Then("the like buttons counter is displayed correctly")
    public void theLikeButtonsCounterIsDisplayedCorrectly() {
//        getDriver().navigate().refresh();
//        page.ideaBankClick.click();
        WebElement thumbUpIcon = getDriver().findElement(By.xpath("//mat-icon[text()='thumb_up']"));
        WebElement parentDiv = thumbUpIcon.findElement(By.xpath("./ancestor::div[1]"));
        WebElement valueSpan = parentDiv.findElement(By.xpath("./span[not(@class)]"));
        String valueText = valueSpan.getText().trim();
        System.out.println("value = " + valueText);
        int actLike = Integer.parseInt(valueText.trim());
        System.out.println("actLike = " + actLike);

        int exLike = expectLike + 1;
        assertEquals(exLike,actLike);

    }

    @When("user selects unlike button")
    public void userSelectsUnlikeButton() {
        page.unlikeBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("the unlike buttons counter is displayed correctly")
    public void theUnlikeButtonsCounterIsDisplayedCorrectly() {
        WebElement thumbdownIcon = getDriver().findElement(By.xpath("//mat-icon[text()='thumb_down']"));
        WebElement parentDiv1 = thumbdownIcon.findElement(By.xpath("./ancestor::div[1]"));
        WebElement valueSpan1 = parentDiv1.findElement(By.xpath("./span[not(@class)]"));
        String valueText1 = valueSpan1.getText().trim();
        System.out.println("value = " + valueText1);
        int actUnLike = Integer.parseInt(valueText1.trim());
        System.out.println("actUnLike = " + actUnLike);
        int exUnlike = expectUnlike + 1;
        System.out.println("exUnlike = " + exUnlike);
        assertEquals(exUnlike, actUnLike);
    }

    @When("user adds comment")
    public void userAddsComment() {
        page.commentBtn.click();
        page.commentIntput.sendKeys("Check comment...");
        ReusableMethods.wait(3);
        page.saveBtn.click();
        ReusableMethods.wait(1);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement statisticActionDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'action')])[2]")));
        WebElement commentCountSpan = statisticActionDiv.findElement(By.xpath(".//span[contains(@class, 'comment-count')]"));
        String valcom1 = commentCountSpan.getText().trim();
        System.out.println("valcom = " + valcom1);
        int actualCommentCount=Integer.parseInt(valcom1.trim());
        System.out.println("actualCommentCount = " + actualCommentCount);
        int exppectCom = expCommentCount +1;
        System.out.println("exppectCom = " + exppectCom);
        assertEquals(actualCommentCount,exppectCom);

        ReusableMethods.flash(page.flashLike,getDriver());
        ReusableMethods.flash(page.flashUnLike,getDriver());
        ReusableMethods.flash(page.flashCom,getDriver());


    }

    @Then("added comment is displayed correctly")
    public void addedCommentIsDisplayedCorrectly() {
        ReusableMethods.pageDown();
        ReusableMethods.flash(page.flashComment,getDriver());
        String commentEx = "Check comment...";
        String expetText = page.commentText.getText();
        assertEquals(commentEx,expetText);
    }

    @When("user deletes idea bank by selecting delete button")
    public void userDeletesIdeaBankBySelectingDeleteButton() {
        page.ideaDeleteBtn.click();
        ReusableMethods.wait(1);
        page.confirmDeleteBtn.click();
        ReusableMethods.wait(1);

    }

    @Then("the idea has successfully deleted")
    public void theIdeaHasSuccessfullyDeleted() {
        while (true) {
            try {
            if (!page.ideaBankClick.isDisplayed()) {
                break;
            }
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
        page.selectSortByDate.click();
        ReusableMethods.wait(1);
    }
}