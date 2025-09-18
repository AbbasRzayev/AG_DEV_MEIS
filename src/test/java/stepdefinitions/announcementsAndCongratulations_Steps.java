package stepdefinitions;

import Page.announcementsAndCongratulations_Page;
import Page.registration_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class announcementsAndCongratulations_Steps {
    announcementsAndCongratulations_Page page = new announcementsAndCongratulations_Page();
    registration_Page page1 = new registration_Page();

    @And("goes to the announcements tab from admin panel")
    public void goesToTheAnnouncementsTabFromAdminPanel() {
        page.announcementTabAdminPanel.click();
        ReusableMethods.wait(15);
    }

    @And("selects plus button for adding new {string}")
    public void selectsPlusButtonForAddingNewAnnouncement(String scenario) {
        if (scenario.equalsIgnoreCase("announcement")) {
            page.newAnnouncement.click();
            ReusableMethods.wait(10);
        } else if (scenario.equalsIgnoreCase("congratulation")) {
            page.newCongratulation.click();
            ReusableMethods.wait(10);
        }
    }

    @And("adds {string} name")
    public void addsName(String arg0) {
        page.announcementName.sendKeys(arg0);
        ReusableMethods.wait(1);
    }

    @And("adds {string} description")
    public void addsDescription(String arg0) {
        page.announcementDesciption.sendKeys(arg0);
        ReusableMethods.wait(1);

    }

    @And("adds url for announcement")
    public void addsUrlForAnnouncement() {
        page.announcementUrl.sendKeys("https://aist.group/");
        ReusableMethods.wait(1);
    }

    @And("selects announcement type {string}")
    public void selectsAnnouncementType(String choose) {
        if (choose.contains("edited-announcement")) {
            page.announcementType.click();
            ReusableMethods.wait(1);
            page.announcementEditedTypeSelect.click();
            ReusableMethods.wait(1);
        } else if (choose.contains("edited-congratulation")) {
            page.announcementType.click();
            ReusableMethods.wait(1);
            page.congratsEditedTypeSelect.click();
            ReusableMethods.wait(1);
        }
    }

    @And("selects the status of the announcement according to the addressees")
    public void selectsTheStatusOfTheAnnouncementAccordingToTheAddressees() {
        page.announcementStatus.click();
        ReusableMethods.wait(1);
        page.announcementStatusForPerson.click();
        ReusableMethods.wait(1);
        page.announcementPersonName.sendKeys("Musa");
        ReusableMethods.wait(1);
        page.announcementMusaSelect.click();
        ReusableMethods.wait(1);
        page.closeSearchList.click();
    }

    @And("adds main picture for announcement")
    public void addsMainPictureForAnnouncement() {
        String path = "C:\\Users\\User\\TestFiles\\Test.png";
        page.announcementMainPictureOne.click();
        ReusableMethods.robotClassDosyaYukleme(path);
    }


    @And("adds video for announcement")
    public void addsVideoForAnnouncement() {
        ReusableMethods.wait(1);
        page.announcementPictureTwo.click();
        ReusableMethods.wait(1);
        page.videoUrlPerson.sendKeys("https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz");
        ReusableMethods.wait(1);
        page.acceptVideo.click();
    }

    @When("user selects save button")
    public void userSelectsSaveButton() {
        ReusableMethods.wait(4);
        page.saveBtn.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ReusableMethods.wait(15);
    }

    @Then("new announcement according to the addressees successfully added")
    public void newAnnouncementAccordingToTheAddresseesSuccessfullyAdded() {
        ReusableMethods.flash(page.announcementCheckPerson, getDriver());
        Assert.assertTrue(page.announcementCheckPerson.isDisplayed());
    }

    private static boolean isElementVisible(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Then("the system notification and information about announcements according to the address  is displayed")
    public void theSystemNotificationAndInformationAboutAnnouncementsAccordingToTheAddressIsDisplayed() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.announModalExcist, wait)) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.announcementNotCheck, getDriver());
            Assert.assertTrue(page.announcementNotCheck.isDisplayed());
            page.announCloseNote.click();
        } else {
            page.announcementNotBtn.click();
            page.announcementNotSelect.click();
            ReusableMethods.flash(page.announcementNotCheck, getDriver());
            Assert.assertTrue(page.announcementNotCheck.isDisplayed());
            page.announCloseNote.click();
        }
    }

    @When("user goes to the announcements tab from side bare")
    public void userGoesToTheAnnouncementsTabFromSidebare() {
        ReusableMethods.wait(1);
        page.announTabSideBar.click();
        ReusableMethods.wait(1);
    }

    @Then("announcement according to the address and information about it is displayed")
    public void announcementAccordingToTheAddressAndInformationAboutItIsDisplayed() {
        ReusableMethods.flash(page.announcementCheckPerson, getDriver());
        Assert.assertTrue(page.announcementCheckPerson.isDisplayed());
        page.announcementCheckPerson.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.checkHeadNAmeAn, getDriver());
        ReusableMethods.flash(page.checkDescAn, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadNAmeAn.isDisplayed());
        Assert.assertTrue(page.checkDescAn.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());
    }

    @Then("email about the new announcement according to the address is sent to the e-mail address and the information about new is announcement displayed")
    public void emailAboutTheNewAnnouncementAccordingToTheAddressIsSentToTheEMailAddressAndTheInformationAboutNewIsAnnouncementDisplayed() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page1.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page1.googleNextButton.click();
        ReusableMethods.wait(3);
        page1.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page1.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        String text = "TestElanForPerson";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'TestElanForPerson')])[5]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("(//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4'])[1]"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }

        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());
        ReusableMethods.wait(1);
        WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        WebElement fayl = getDriver().findElement(By.xpath("(//div[@class='aQH'])[1]"));
        ReusableMethods.wait(1);
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.flash(fayl, getDriver());
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                "TestElanForPerson",
                "Fərid İmranov",
                "Fərid İmranov",
                "Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur.",
                "Ünvanlanmış şəxslərə görə",
                "Musa Rzayev, Fərid İmranov",
                "https://aist.group/",
                "https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz",
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }
        ReusableMethods.wait(1);
    }

    @When("user deletes announcements for person from admin panel")
    public void userDeletesAnnouncementsForPersonFromAdminPanel() {
        if (page.checkForDeleteForPerson.isDisplayed()) {
            page.deleteForPerson.click();
            ReusableMethods.wait(1);
            page.yesDeleteForPerson.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("announcements for person is deleted successfully")
    public void announcementsForPersonIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.checkForDeleteForPerson);
    }

    @And("selects the status of the announcement according to the structure")
    public void selectsTheStatusOfTheAnnouncementAccordingToTheStructure() {
        page.announcementStatus.click();
        ReusableMethods.wait(1);
        page.announcementStatusForStructure.click();
        ReusableMethods.wait(1);
        page.announcementStructureList.click();
//        ReusableMethods.wait(1);
//        page.announcementOpenStructureList.click();
        ReusableMethods.wait(1);
        page.announcementSelectStructureList.click();
        ReusableMethods.wait(2);
        page.accceptStructure.click();
        ReusableMethods.wait(3);
    }

    @Then("new announcement according to the structure successfully added")
    public void newAnnouncementAccordingToTheStructureSuccessfullyAdded() {
        ReusableMethods.flash(page.announcementCheckForStructure, getDriver());
        Assert.assertTrue(page.announcementCheckForStructure.isDisplayed());
    }

    @Then("the system notification and information about announcements to the structure is displayed")
    public void theSystemNotificationAndInformationAboutAnnouncementsToTheStructureIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.announModalExcist, wait)) {
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.announcemenStructNotCheck, getDriver());

            Assert.assertTrue(page.announcemenStructNotCheck.isDisplayed());
            page.announCloseNote.click();
        } else {
            page.announcementNotBtn.click();
            page.announcemenStrutNotSelect.click();
            ReusableMethods.flash(page.announcemenStructNotCheck, getDriver());
            Assert.assertTrue(page.announcemenStructNotCheck.isDisplayed());
            page.announCloseNote.click();
        }
    }

    @Then("announcement according to the structure and information about it is displayed")
    public void announcementAccordingToTheStructureAndInformationAboutItIsDisplayed() {
        ReusableMethods.flash(page.announcementCheckStructure, getDriver());
        Assert.assertTrue(page.announcementCheckStructure.isDisplayed());
        page.announcementCheckStructure.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.checkHeadNAmeStr, getDriver());
        ReusableMethods.flash(page.checkDescAn, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadNAmeStr.isDisplayed());
        Assert.assertTrue(page.checkDescAn.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());
    }

    @Then("email about the new announcement according to the structure is sent to the e-mail address and the information is announcement displayed")
    public void emailAboutTheNewAnnouncementAccordingToTheStructureIsSentToTheEMailAddressAndTheInformationIsAnnouncementDisplayed() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page1.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page1.googleNextButton.click();
        ReusableMethods.wait(3);
        page1.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page1.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        String text = "TestElanForStructure";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'TestElanForStructure')])[5]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("(//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4'])[1]"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }

        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());
        WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        ReusableMethods.wait(2);
        WebElement fayl = getDriver().findElement(By.xpath("//div[@class='aQH']"));
        ReusableMethods.wait(2);
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.wait(2);
        ReusableMethods.pageDown();
        ReusableMethods.flash(fayl, getDriver());
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                "TestElanForStructure",
                "Fərid İmranov",
                "Fərid İmranov",
                "Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur.",
                "Struktur bölmə daxilində",
                "https://aist.group/",
                "https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz",
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }
        ReusableMethods.wait(1);
    }

    @When("user deletes according to the structure from admin panel")
    public void userDeletesAccordingToTheStructureFromAdminPanel() {
        if (page.checkForDeleteForStructure.isDisplayed()) {
            page.deleteForPerson.click();
            ReusableMethods.wait(1);
            page.yesDeleteForPerson.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("according to the structure is deleted successfully")
    public void accordingToTheStructureIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.checkForDeleteForStructure);
    }

    @Then("new announcement according to the public open successfully added")
    public void newAnnouncementAccordingToThePublicOpenSuccessfullyAdded() {
        ReusableMethods.flash(page.announcementCheckPublicOpen, getDriver());
        Assert.assertTrue(page.announcementCheckPublicOpen.isDisplayed());
    }

    @And("adds url for announcement for public open")
    public void addsUrlForAnnouncementForPublicOpen() {
        page.announcementUrlOpenPublic.sendKeys("https://aist.group/");
        ReusableMethods.wait(1);
    }

    @And("adds video for announcement for public open")
    public void addsVideoForAnnouncementForPublicOpen() {
        ReusableMethods.wait(1);
        page.announcementPictureTwo.click();
        ReusableMethods.wait(1);
        page.videoUrlPublic.sendKeys("https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz");
        ReusableMethods.wait(1);
        page.acceptVideo.click();
    }

    @Then("the system notification and information about announcements according to the public open is displayed")
    public void theSystemNotificationAndInformationAboutAnnouncementsAccordingToThePublicOpenIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.announModalExcist, wait)) {
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.announcemenPublicOpenNotCheck, getDriver());

            Assert.assertTrue(page.announcemenPublicOpenNotCheck.isDisplayed());
            page.announCloseNote.click();
        } else {
            page.announcementNotBtn.click();
            page.announcemenPublicOpenNotSelect.click();
            ReusableMethods.flash(page.announcemenPublicOpenNotCheck, getDriver());
            Assert.assertTrue(page.announcemenPublicOpenNotCheck.isDisplayed());
            page.announCloseNote.click();
        }
    }

    @Then("announcement according to the public open and information about it is displayed")
    public void announcementAccordingToThePublicOpenAndInformationAboutItIsDisplayed() {
        ReusableMethods.flash(page.annmentCheckPublicOpen, getDriver());
        Assert.assertTrue(page.annmentCheckPublicOpen.isDisplayed());
        page.annmentCheckPublicOpen.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.checkHeadPublic, getDriver());
        ReusableMethods.flash(page.checkDescAn, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadPublic.isDisplayed());
        Assert.assertTrue(page.checkDescAn.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());
    }

    @Then("email about the new announcement according to the public open is sent to the e-mail address and the information is announcement displayed")
    public void emailAboutTheNewAnnouncementAccordingToThePublicOpenIsSentToTheEMailAddressAndTheInformationIsAnnouncementDisplayed() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page1.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page1.googleNextButton.click();
        ReusableMethods.wait(3);
        page1.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page1.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        String text = "TestElanForPublicOpen";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'TestElanForPublicOpen')])[5]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("(//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4'])[1]"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }

        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());
        WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        WebElement fayl = getDriver().findElement(By.xpath("(//div[@class='aQH'])[1]"));
        ReusableMethods.wait(1);
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(fayl, getDriver());
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                "TestElanForPublicOpen",
                "Fərid İmranov",
                "Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur.",
                "Ümumi açıq",
                "https://aist.group/",
                "https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz",
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }
        ReusableMethods.wait(1);
    }

    @When("user goes to the announcements tab from authorization page")
    public void userGoesToTheAnnouncementsTabFromAuthorizationPage() {
        getDriver().get(ConfigReader.getProperty("Meis"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ReusableMethods.wait(1);
        page.autorizationAnn.click();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.announcementCheckPublicOpen, getDriver());
        Assert.assertTrue(page.announcementCheckPublicOpen.isDisplayed());
        page.announcementCheckPublicOpen.click();
        ReusableMethods.wait(1);
    }

    @Then("announcement according to the public open and information about it is displayed in the authorization page")
    public void announcementAccordingToThePublicOpenAndInformationAboutItIsDisplayedInTheAuthorizationPage() {
        ReusableMethods.flash(page.checkHeadPublic, getDriver());
        ReusableMethods.flash(page.checkDescAn, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadPublic.isDisplayed());
        Assert.assertTrue(page.checkDescAn.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());

    }

    @When("user deletes according to the public open from admin panel")
    public void userDeletesAccordingToThePublicOpenFromAdminPanel() {
        if (page.announcementCheckPublicOpen.isDisplayed()) {
            page.deleteForPerson.click();
            ReusableMethods.wait(1);
            page.yesDeleteForPerson.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("according to the public open is deleted successfully")
    public void accordingToThePublicOpenIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.announcementCheckPublicOpen);
    }

    @And("goes to the congratulations tab from admin panel")
    public void goesToTheCongratulationsTabFromAdminPanel() {
        page.congratulationsTabAdminPanel.click();
        ReusableMethods.wait(1);
    }

    @And("adds url for congratulations")
    public void addsUrlForCongratulations() {
        page.announcementUrl.sendKeys("https://aist.group/");
        ReusableMethods.wait(1);
    }

    @And("selects congratulations type")
    public void selectsCongratulationsType() {
        page.announcementType.click();
        ReusableMethods.wait(1);
        page.announcementTypeSelect.click();
        ReusableMethods.wait(1);
    }

    @And("selects the status of the congratulations according to the addressees")
    public void selectsTheStatusOfTheCongratulationsAccordingToTheAddressees() {
        page.announcementStatus.click();
        ReusableMethods.wait(1);
        page.announcementStatusForPerson.click();
        ReusableMethods.wait(1);
        page.announcementPersonName.sendKeys("Musa");
        ReusableMethods.wait(1);
        page.announcementMusaSelect.click();
        ReusableMethods.wait(1);
        page.closeSearchList.click();
    }

    @And("adds main picture for congratulations")
    public void addsMainPictureForCongratulations() {
        String path = "C:\\Users\\User\\TestFiles\\Test.png";
        page.announcementMainPictureOne.click();
        ReusableMethods.robotClassDosyaYukleme(path);
    }

    @And("adds video for congratulations")
    public void addsVideoForCongratulations() {
        ReusableMethods.wait(1);
        page.announcementPictureTwo.click();
        ReusableMethods.wait(1);
        page.videoUrlPerson.sendKeys("https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz");
        ReusableMethods.wait(1);
        page.acceptVideo.click();
    }

    @Then("new congratulations according to the addressees successfully added")
    public void newCongratulationsAccordingToTheAddresseesSuccessfullyAdded() {
        ReusableMethods.flash(page.congratsCheckPerson, getDriver());
        Assert.assertTrue(page.congratsCheckPerson.isDisplayed());
    }

    @Then("the system notification and information about congratulations according to the address  is displayed")
    public void theSystemNotificationAndInformationAboutCongratulationsAccordingToTheAddressIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.announModalExcist, wait)) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.congratsNotCheck, getDriver());
            Assert.assertTrue(page.congratsNotCheck.isDisplayed());
            page.congratsCloseNote.click();
        } else {
            page.announcementNotBtn.click();
            page.congratNotSelect.click();
            ReusableMethods.flash(page.congratsNotCheck, getDriver());
            Assert.assertTrue(page.congratsNotCheck.isDisplayed());
            page.congratsCloseNote.click();
        }
    }

    @When("user goes to the congratulations tab from side bare")
    public void userGoesToTheCongratulationsTabFromSideBare() {
        ReusableMethods.wait(1);
        page.announTabSideBar.click();
        ReusableMethods.wait(1);
        page.congratstab.click();
    }

    @Then("congratulations according to the address and information about it is displayed")
    public void congratulationsAccordingToTheAddressAndInformationAboutItIsDisplayed() {
        ReusableMethods.flash(page.congratsCheckPerson, getDriver());
        Assert.assertTrue(page.congratsCheckPerson.isDisplayed());
        page.congratsCheckPerson.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.checkHeadNAmeCong, getDriver());
        ReusableMethods.flash(page.checkDescCong, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadNAmeCong.isDisplayed());
        Assert.assertTrue(page.checkDescCong.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());
    }

    @Then("email about the new congratulations according to the address is sent to the e-mail address and the information about new congratulations is displayed")
    public void emailAboutTheNewCongratulationsAccordingToTheAddressIsSentToTheEMailAddressAndTheInformationAboutNewCongratulationsIsDisplayed() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page1.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page1.googleNextButton.click();
        ReusableMethods.wait(3);
        page1.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page1.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        String text = "Congratulations according to the addressees";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'Congratulations according to the addressees')])[1]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("(//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4'])[1]"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }

        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());
        WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        WebElement fayl = getDriver().findElement(By.xpath("(//div[@class='aQH'])[1]"));
        ReusableMethods.wait(1);
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(fayl, getDriver());
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                "Congratulations according to the addressees",
                "Fərid İmranov",
                "Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process.",
                "Ünvanlanmış şəxslərə görə",
                "Musa Rzayev, Fərid İmranov",
                "https://aist.group/",
                "https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz",
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }
        ReusableMethods.wait(1);
    }

    @When("user deletes congratulations for person from admin panel")
    public void userDeletesCongratulationsForPersonFromAdminPanel() {
        if (page.checkForDeleteForPersonCongrat.isDisplayed()) {
            page.deleteForPerson.click();
            ReusableMethods.wait(1);
            page.yesDeleteForPerson.click();
            ReusableMethods.wait(1);
        }

    }

    @Then("congratulations for person is deleted successfully")
    public void congratulationsForPersonIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.checkForDeleteForPersonCongrat);
    }

    @And("selects plus button for adding new congratulations")
    public void selectsPlusButtonForAddingNewCongratulations() {
        page.newCongrats.click();
        ReusableMethods.wait(1);
    }

    @And("selects the status of the congratulations according to the structure")
    public void selectsTheStatusOfTheCongratulationsAccordingToTheStructure() {
        page.announcementStatus.click();
        ReusableMethods.wait(1);
        page.announcementStatusForStructure.click();
        ReusableMethods.wait(1);
        page.announcementStructureList.click();
//        ReusableMethods.wait(1);
//        page.announcementOpenStructureList.click();
        ReusableMethods.wait(1);
        page.announcementSelectStructureList.click();
        ReusableMethods.wait(2);
        page.accceptStructure.click();
        ReusableMethods.wait(3);
    }

    @Then("new congratulations according to the structure successfully added")
    public void newCongratulationsAccordingToTheStructureSuccessfullyAdded() {
        ReusableMethods.flash(page.congratsCheckStructure, getDriver());
        Assert.assertTrue(page.congratsCheckStructure.isDisplayed());
    }

    @Then("the system notification and information about congratulations to the structure is displayed")
    public void theSystemNotificationAndInformationAboutCongratulationsToTheStructureIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.announModalExcist, wait)) {
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.congratsNotCheck, getDriver());
            Assert.assertTrue(page.congratsNotCheck.isDisplayed());
            page.congratsCloseNote.click();
        } else {
            page.announcementNotBtn.click();
            page.congratStrucNotSelect.click();
            ReusableMethods.flash(page.congratsNotCheck, getDriver());
            Assert.assertTrue(page.congratsNotCheck.isDisplayed());
            page.congratsCloseNote.click();
        }
    }

    @Then("congratulations according to the structure and information about it is displayed")
    public void congratulationsAccordingToTheStructureAndInformationAboutItIsDisplayed() {
        ReusableMethods.flash(page.congratsCheckStruce, getDriver());
        Assert.assertTrue(page.congratsCheckStruce.isDisplayed());
        page.congratsCheckStruce.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.checkHeadStruceCong, getDriver());
        ReusableMethods.flash(page.checkDescCong, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadStruceCong.isDisplayed());
        Assert.assertTrue(page.checkDescCong.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());
    }

    @Then("email about the new congratulations according to the structure is sent to the e-mail address and the information about new congratulations is displayed")
    public void emailAboutTheNewCongratulationsAccordingToTheStructureIsSentToTheEMailAddressAndTheInformationAboutNewCongratulationsIsDisplayed() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page1.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page1.googleNextButton.click();
        ReusableMethods.wait(3);
        page1.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page1.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        String text = "Congratulations according to the structure";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'Congratulations according to the structure')])[1]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("(//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4'])[1]"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }

        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());
        WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        WebElement fayl = getDriver().findElement(By.xpath("(//div[@class='aQH'])[1]"));
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.pageDown();
        ReusableMethods.flash(fayl, getDriver());
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                " Congratulations according to the structure",
                " Fərid İmranov",
                " Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process.",
                " Struktur bölmə daxilində",
                "https://aist.group/",
                "https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz",
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }
        ReusableMethods.wait(1);
    }

    @When("user deletes congratulations according to the structure from admin panel")
    public void userDeletesCongratulationsAccordingToTheStructureFromAdminPanel() {
        if (page.checkForDeleteForStructureCongrat.isDisplayed()) {
            page.deleteForPerson.click();
            ReusableMethods.wait(1);
            page.yesDeleteForPerson.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("congratulations according to the structure is deleted successfully")
    public void congratulationsAccordingToTheStructureIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.checkForDeleteForStructureCongrat);
    }

    @Then("new congratulations according to the public open successfully added")
    public void newCongratulationsAccordingToThePublicOpenSuccessfullyAdded() {
        ReusableMethods.flash(page.congratsCheckPublicOPen, getDriver());
        Assert.assertTrue(page.congratsCheckPublicOPen.isDisplayed());

    }

    @And("adds url for congratulations for public open")
    public void addsUrlForCongratulationsForPublicOpen() {
        page.announcementUrlOpenPublic.sendKeys("https://aist.group/");
        ReusableMethods.wait(1);
    }

    @And("adds video for congratulations for public open")
    public void addsVideoForCongratulationsForPublicOpen() {
        ReusableMethods.wait(1);
        page.announcementPictureTwo.click();
        ReusableMethods.wait(1);
        page.videoUrlPublic.sendKeys("https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz");
        ReusableMethods.wait(1);
        page.acceptVideo.click();
    }

    @Then("the system notification and information about congratulations according to the public open is displayed")
    public void theSystemNotificationAndInformationAboutCongratulationsAccordingToThePublicOpenIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.announModalExcist, wait)) {
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.congratsNotCheck, getDriver());

            // Assert.assertTrue(page.congratPublicOpenNotSelect.isDisplayed());
            page.announCloseNote.click();
        } else {
            page.announcementNotBtn.click();
            page.congratPublicOpenNotSelect.click();
            ReusableMethods.flash(page.congratsNotCheck, getDriver());
            // Assert.assertTrue(page.congratPublicOpenNotSelect.isDisplayed());
            page.announCloseNote.click();
        }
    }

    @Then("congratulations according to the public open and information about it is displayed")
    public void congratulationsAccordingToThePublicOpenAndInformationAboutItIsDisplayed() {
        ReusableMethods.flash(page.congratPublicOpenSelect, getDriver());
        Assert.assertTrue(page.congratPublicOpenSelect.isDisplayed());
        page.congratPublicOpenSelect.click();
        ReusableMethods.wait(1);

        ReusableMethods.flash(page.checkHeadPulicCong, getDriver());
        ReusableMethods.flash(page.checkDescCong, getDriver());
        ReusableMethods.flash(page.checkTypeAn, getDriver());
        ReusableMethods.flash(page.checkUrlAn, getDriver());
        page.checkUrlAn.click();
        String originalWindowHandle = getDriver().getWindowHandle(); // Store the original window handle
        ReusableMethods.wait(1);

        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                getDriver().switchTo().window(handle); // Switch to the new window
                ReusableMethods.flash(page.checkurlLink, getDriver());
                getDriver().close();
                getDriver().switchTo().window(originalWindowHandle); // Switch back to the original window
                break; // Exit the loop after switching back to the original window
            }
        }
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkPictureAn, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.flash(page.checkVideoAn, getDriver());
        Assert.assertTrue(page.checkHeadPulicCong.isDisplayed());
        Assert.assertTrue(page.checkDescCong.isDisplayed());
        Assert.assertTrue(page.checkTypeAn.isDisplayed());
        Assert.assertTrue(page.checkUrlAn.isDisplayed());
        Assert.assertTrue(page.checkPictureAn.isDisplayed());
        Assert.assertTrue(page.checkVideoAn.isDisplayed());
    }

    @Then("email about the new congratulations according to the public open is sent to the e-mail address and the information is displayed")
    public void emailAboutTheNewCongratulationsAccordingToThePublicOpenIsSentToTheEMailAddressAndTheInformationIsDisplayed() {
        getDriver().get("https://gmail.com/");
        ReusableMethods.wait(3);
        page1.googleEmail.sendKeys("rzayevmusa1234@gmail.com");
        ReusableMethods.wait(2);
        page1.googleNextButton.click();
        ReusableMethods.wait(3);
        page1.googlepasswordField.sendKeys("!!rzayevmusa88");
        ReusableMethods.wait(3);
        page1.googleNextButton.click();
        ReusableMethods.wait(2);
        WebElement spanElement2 = getDriver().findElement(By.xpath("//input[@aria-label='Search mail']"));
        String text = "Congratulations according to the public open";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'Congratulations according to the public open')])[1]"));
        if (row != null) {
            // Click on another element based on condition
            WebElement elementToClick = getDriver().findElement(By.xpath("(//div[@class='ae4 UI aZ6 id']//td[@class='yX xY ']//div[@class='yW']//span[@class='bA4'])[1]"));
            elementToClick.click();
            System.out.println("Clicked on element with text 'meis'");
        } else {
            System.out.println("Row with 'yaradılıb' not found.");
        }

        WebElement headerText = getDriver().findElement(By.xpath("//div[@class='V8djrc byY']"));
        ReusableMethods.flash(headerText, getDriver());
        ReusableMethods.wait(1);
        WebElement alltext = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
        ReusableMethods.wait(1);
        WebElement fayl = getDriver().findElement(By.xpath("(//div[@class='aQH'])[1]"));
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.pageDown();
        ReusableMethods.flash(fayl, getDriver());
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                " Congratulations according to the public open",
                " Fərid İmranov",
                " Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process.",
                " Ümumi açıq",
                "https://aist.group/",
                "https://www.youtube.com/watch?v=exzJoArl0h0&list=PLFGoYjJG_fqr84PKCp88iPkQDWJSfzaqz",
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }
        ReusableMethods.wait(1);
    }

    @When("user deletes congratulations to the public open from admin panel")
    public void userDeletesCongratulationsToThePublicOpenFromAdminPanel() {
        if (page.congratPublicOpenSelect.isDisplayed()) {
            page.deleteForPerson.click();
            ReusableMethods.wait(1);
            page.yesDeleteForPerson.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("congratulations to the public open is deleted successfully")
    public void congratulationsToThePublicOpenIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.congratPublicOpenSelect);
    }

    @Then("new {string} is displayed in the announcement tab")
    public void newIsDisplayedInTheAnnouncementTab(String choose) {
        if (choose.contains("edited-announcement")) {
            ReusableMethods.flash(page.announcementEditedTypeSelect, getDriver());
            ReusableMethods.wait(1);
            String expected = "AutomationQA news";
            assertEquals(page.announcementEditedTypeSelect.getText().trim(), expected);
            ReusableMethods.wait(1);
        } else if (choose.contains("edited-congratulation")) {
            ReusableMethods.flash(page.congratsEditedTypeSelect, getDriver());
            ReusableMethods.wait(1);
            String expected = "Automation progress";
            assertEquals(page.congratsEditedTypeSelect.getText().trim(), expected);
            ReusableMethods.wait(1);
        }
    }
}