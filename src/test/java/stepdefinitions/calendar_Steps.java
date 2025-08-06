package stepdefinitions;

import Page.calendar_Page;
import Page.helpDesk_Page;
import Page.registration_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class calendar_Steps {
    calendar_Page page = new calendar_Page();
    registration_Page page1 = new registration_Page();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
    helpDesk_Page helpDeskPage = new helpDesk_Page();

    @And("goes to the calendar tab")
    public void goesToTheCalendarTab() {
        ReusableMethods.wait(1);
        ReusableMethods.waitForClickability(page.calendarPage, 1);
        ReusableMethods.wait(1);
        page.calendarPage.click();
    }

    @And("selects new event button")
    public void selectsNewEventButton() {
        ReusableMethods.waitForClickability(page.newEventBtn, 1);
        ReusableMethods.wait(1);
        page.newEventBtn.click();
        ReusableMethods.wait(1);
        getDriver().navigate().refresh();
    }

    @And("selects submit button for the new event")
    public void selectsSubmitButtonForTheNewEvent() {
        page.acceptBtn.click();
        ReusableMethods.wait(2);
    }

    private static boolean isElementVisible(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Then("the system notification and information about new event is displayed")
    public void theSystemNotificationAndInformationAboutNewEventIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            if (isElementVisible(page.mainNote, wait)) {
                List<String> textsToFind = Arrays.asList(
                        "AT_TesT",
                        "İcazə",
                        // "Digər",
                        "Fərid İmranov",
                        "Ünvanlanmış şəxslərə görə",
                        "Musa Rzayev",
                        "http://test.meis.competition.gov.az/",
                        "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"
                );
                for (String text : textsToFind) {
                    boolean isTextPresent = page.mainNote.getText().contains(text);
                    System.out.println("Text \"" + text + "\" is present: " + isTextPresent);
                    assert isTextPresent : "Text \"" + text + "\" is not present!";
                    if (text.contains("AT_Test")) {
                        WebElement Attest = getDriver().findElement(By.xpath("//span[contains(.,'AT_TesT')]"));
                        ReusableMethods.flash(Attest, getDriver());
                    } else if (text.contains("Fərid İmranov")) {
                        WebElement tertibTeshkil = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[1]"));
                        WebElement terdibEden = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[2]"));
                        ReusableMethods.flash(tertibTeshkil, getDriver());
                        ReusableMethods.flash(terdibEden, getDriver());
                    } else if (text.contains("İcazə")) {
                        WebElement icaze = getDriver().findElement(By.xpath("//p[contains(.,'İcazə')]"));
                        ReusableMethods.flash(icaze, getDriver());
                    } else if (text.contains("Ünvanlanmış şəxslərə görə")) {
                        WebElement selectPerson1 = getDriver().findElement(By.xpath("(//p[contains(.,'Ünvanlanmış şəxslərə görə')])[1]"));
                        WebElement selectPerson2 = getDriver().findElement(By.xpath("(//p[contains(.,'Ünvanlanmış şəxslərə görə')])[2]"));
                        ReusableMethods.flash(selectPerson1, getDriver());
                        ReusableMethods.flash(selectPerson2, getDriver());
                    } else if (text.contains("Musa Rzayev")) {
                        WebElement musa = getDriver().findElement(By.xpath("//p[contains(.,'Musa Rzayev')]"));
                        ReusableMethods.flash(musa, getDriver());
                        // Locate the modal container
                        WebElement modalContainer = getDriver().findElement(By.cssSelector(".mdc-dialog__container .mat-mdc-dialog-surface"));
                        ReusableMethods.scrollModalWindow(modalContainer);
                        // Scroll down within the modal
//                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//                        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", modalContainer);
                    } else if (text.contains("http://test.meis.competition.gov.az")) {
                        WebElement url = getDriver().findElement(By.xpath("//p[contains(.,'http://test.meis.competition.gov.az/')]"));
                        ReusableMethods.flash(url, getDriver());
                    } else if (text.contains("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir")) {
                        WebElement text1 = getDriver().findElement(By.xpath("//p[contains(.,'Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir')]"));
                        ReusableMethods.flash(text1, getDriver());
                    }
                }
            } else {
                page.noteBtn.click();
                ReusableMethods.wait(1);
                List<WebElement> notifications = getDriver().findElements(By.xpath("//div[@class='notifications_wrapper']"));
                for (WebElement notification : notifications) {
                    if (notification.getText().contains("AT_TesT")) {
                        notification.click();
                        System.out.println("Clicked on notification: " + notification.getText());
                        break;
                    }
                }
                List<String> textsToFind = Arrays.asList(
                        "AT_TesT",
                        "İcazə",
                        // "Digər",
                        "Fərid İmranov",
                        "Ünvanlanmış şəxslərə görə",
                        "Musa Rzayev",
                        "http://test.meis.competition.gov.az/",
                        "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"
                );
                for (String text : textsToFind) {
                    boolean isTextPresent = page.mainNote.getText().contains(text);
                    System.out.println("Text \"" + text + "\" is present: " + isTextPresent);
                    assert isTextPresent : "Text \"" + text + "\" is not present!";
                    if (text.contains("AT_Test")) {
                        WebElement Attest = getDriver().findElement(By.xpath("//span[contains(.,'AT_TesT')]"));
                        ReusableMethods.flash(Attest, getDriver());
                    } else if (text.contains("Fərid İmranov")) {
                        WebElement tertibTeshkil = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[1]"));
                        WebElement terdibEden = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[2]"));
                        ReusableMethods.flash(tertibTeshkil, getDriver());
                        ReusableMethods.flash(terdibEden, getDriver());
                    } else if (text.contains("İcazə")) {
                        WebElement icaze = getDriver().findElement(By.xpath("//p[contains(.,'İcazə')]"));
                        ReusableMethods.flash(icaze, getDriver());
                    } else if (text.contains("Ünvanlanmış şəxslərə görə")) {
                        WebElement selectPerson1 = getDriver().findElement(By.xpath("(//p[contains(.,'Ünvanlanmış şəxslərə görə')])[1]"));
                        WebElement selectPerson2 = getDriver().findElement(By.xpath("(//p[contains(.,'Ünvanlanmış şəxslərə görə')])[2]"));
                        ReusableMethods.flash(selectPerson1, getDriver());
                        ReusableMethods.flash(selectPerson2, getDriver());
                    } else if (text.contains("Musa Rzayev")) {
                        WebElement musa = getDriver().findElement(By.xpath("//p[contains(.,'Musa Rzayev')]"));
                        ReusableMethods.flash(musa, getDriver());
                        // Locate the modal container
                        WebElement modalContainer = getDriver().findElement(By.cssSelector(".mdc-dialog__container .mat-mdc-dialog-surface"));
                        ReusableMethods.scrollModalWindow(modalContainer);
                        // Scroll down within the modal
//                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//                        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", modalContainer);
                    } else if (text.contains("http://test.meis.competition.gov.az")) {
                        WebElement url = getDriver().findElement(By.xpath("//p[contains(.,'http://test.meis.competition.gov.az/')]"));
                        ReusableMethods.flash(url, getDriver());
                    } else if (text.contains("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir")) {
                        WebElement text1 = getDriver().findElement(By.xpath("//p[contains(.,'Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir')]"));
                        ReusableMethods.flash(text1, getDriver());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("user goes to the calendar tab from sidebar")
    public void userGoesToTheCalendarTabFromSidebar() {
        page.closeModalWindow.click();
        page.calTab.click();
        ReusableMethods.wait(1);
    }

    @When("user selects new event from calendar")
    public void userSelectsNewEventFromCalendar() {
        ReusableMethods.flash(page.findEvent, getDriver());
        page.findEvent.click();
        ReusableMethods.wait(1);
    }

    @Then("new event modal window and information is displayed")
    public void newEventModalWindowAndInformationIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.mainNote, wait)) {
            List<String> textsToFind = Arrays.asList(
                    "AT_TesT",
                    "İcazə",
                    //"Digər",
                    "Fərid İmranov",
                    "Ünvanlanmış şəxslərə görə",
                    "Musa Rzayev",
                    "http://test.meis.competition.gov.az/",
                    "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"
            );
            for (String text : textsToFind) {
                boolean isTextPresent = page.mainNote.getText().contains(text);
                System.out.println("Text \"" + text + "\" is present: " + isTextPresent);
                assert isTextPresent : "Text \"" + text + "\" is not present!";
                if (text.contains("AT_Test")) {
                    WebElement Attest = getDriver().findElement(By.xpath("//span[contains(.,'AT_TesT')]"));
                    ReusableMethods.flash(Attest, getDriver());
                } else if (text.contains("Fərid İmranov")) {
                    WebElement tertibTeshkil = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[1]"));
                    WebElement terdibEden = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[2]"));
                    ReusableMethods.flash(tertibTeshkil, getDriver());
                    ReusableMethods.flash(terdibEden, getDriver());
                } else if (text.contains("İcazə")) {
                    WebElement icaze = getDriver().findElement(By.xpath("//p[contains(.,'İcazə')]"));
                    ReusableMethods.flash(icaze, getDriver());
                } else if (text.contains("Ünvanlanmış şəxslərə görə")) {
                    WebElement selectPerson1 = getDriver().findElement(By.xpath("(//p[contains(.,'Ünvanlanmış şəxslərə görə')])[1]"));
                    WebElement selectPerson2 = getDriver().findElement(By.xpath("(//p[contains(.,'Ünvanlanmış şəxslərə görə')])[2]"));
                    ReusableMethods.flash(selectPerson1, getDriver());
                    ReusableMethods.flash(selectPerson2, getDriver());
                } else if (text.contains("Musa Rzayev")) {
                    WebElement musa = getDriver().findElement(By.xpath("//p[contains(.,'Musa Rzayev')]"));
                    ReusableMethods.flash(musa, getDriver());
                    // Locate the modal container
                    WebElement modalContainer = getDriver().findElement(By.xpath("//div[@class='content_wrapper']"));
                    ReusableMethods.scrollModalWindow(modalContainer);
                } else if (text.contains("http://test.meis.competition.gov.az")) {
                    WebElement url = getDriver().findElement(By.xpath("//p[contains(.,'http://test.meis.competition.gov.az/')]"));
                    ReusableMethods.flash(url, getDriver());
                } else if (text.contains("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir")) {
                    WebElement text1 = getDriver().findElement(By.xpath("//p[contains(.,'Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir')]"));
                    ReusableMethods.flash(text1, getDriver());
                }
            }
        }
    }

    @Then("an email about the new event is sent to the e-mail address and the information about new event is displayed")
    public void anEmailAboutTheNewEventIsSentToTheEMailAddressAndTheInformationAboutNewEventIsDisplayed() {
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
        WebElement spanElement2 = getDriver().findElement(By.xpath("(//input[@class='gb_je aJh'])[1]"));
        String text = "AT_TesT";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'AT_TesT')])[5]"));
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
        WebElement fayl = getDriver().findElement(By.xpath("//div[@class='aQH']"));
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.flash(fayl, getDriver());

//        WebElement divElement = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
//        List<WebElement> childElements = divElement.findElements(By.xpath("//div[@class='a3s aiL ']"));
//        for (WebElement element : childElements) {
//            String text1 = element.getText().trim();
//            System.out.println("text1 = " + text1);
//            //assertTrue(text1.contains(" İcazə"));
//            //assertTrue(text1.contains(" 09.07.2024"));
//            assertTrue(text1.contains(" AT_TesT"));
//            assertTrue(text1.contains(" Fərid İmranov"));
//            assertTrue(text1.contains(" Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"));
//            assertTrue(text1.contains(" Ünvanlanmış şəxslərə görə"));
//            assertTrue(text1.contains(" Musa Rzayev Davud"));
//            assertTrue(text1.contains(" http://test.meis.competition.gov.az/"));
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                "İcazə",
                "AT_TesT",
                "Fərid İmranov",
                "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir",
                "Ünvanlanmış şəxslərə görə",
                "Musa Rzayev Davud",
                "http://test.meis.competition.gov.az/"
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }

        ReusableMethods.wait(1);
    }

    @And("selects user for new event notification according to structure division")
    public void selectsUserForNewEventNotificationAccordingToStructureDivision() {
        ReusableMethods.wait(1);
        page.notChoose.click();
        ReusableMethods.wait(1);
        page.selectStructureList.click();
        ReusableMethods.wait(1);
        page.selectDivision.click();
        ReusableMethods.wait(1);
        //ReusableMethods.clickByJavaScript(page.openListStructure);
        ReusableMethods.waitForClickabilityAndClick(page.openListStructure, 5);
        //page.openListStructure.click();
        ReusableMethods.wait(1);
        page.selectStructure.click();
        ReusableMethods.wait(1);
        page.accceptStructure.click();
    }

    @And("selects the event to be displayed in the calendar of selected persons within the structural unit")
    public void selectsTheEventToBeDisplayedInTheCalendarOfSelectedPersonsWithinTheStructuralUnit() {
        page.chooseCalendarWhoWillSee.click();
        ReusableMethods.wait(1);
        page.calendarVisabilityStructure.click();
        ReusableMethods.wait(1);
        page.selectSecondDivision.click();
        ReusableMethods.waitForClickabilityAndClick(page.openListStructure, 5);
        ReusableMethods.wait(1);
        page.selectStructure.click();
        ReusableMethods.wait(1);
        page.accceptStructure.click();
    }

    @Then("the system notification and information about structure event is displayed")
    public void theSystemNotificationAndInformationAboutStructureEventIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            if (isElementVisible(page.mainNote, wait)) {
                List<String> textsToFind = Arrays.asList(
                        "AT_TesT_Structure",
                        "İcazə",
                        // "Digər",
                        "Fərid İmranov",
                        "Struktur bölmə daxilində",
                        // "Musa Rzayev",
                        "http://test.meis.competition.gov.az/",
                        "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"
                );
                for (String text : textsToFind) {
                    boolean isTextPresent = page.mainNote.getText().contains(text);
                    System.out.println("Text \"" + text + "\" is present: " + isTextPresent);
                    assert isTextPresent : "Text \"" + text + "\" is not present!";
                    if (text.contains("AT_TesT_Structure")) {
                        WebElement Attest = getDriver().findElement(By.xpath("//span[contains(.,'AT_TesT_Structure')]"));
                        ReusableMethods.flash(Attest, getDriver());
                    } else if (text.contains("Fərid İmranov")) {
                        WebElement tertibTeshkil = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[1]"));
                        WebElement terdibEden = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[2]"));
                        ReusableMethods.flash(tertibTeshkil, getDriver());
                        ReusableMethods.flash(terdibEden, getDriver());
                    } else if (text.contains("İcazə")) {
                        WebElement icaze = getDriver().findElement(By.xpath("//p[contains(.,'İcazə')]"));
                        ReusableMethods.flash(icaze, getDriver());
                    } else if (text.contains("Struktur bölmə daxilində")) {
                        WebElement selectPerson1 = getDriver().findElement(By.xpath("(//p[contains(.,'Struktur bölmə daxilində')])[1]"));
                        WebElement selectPerson2 = getDriver().findElement(By.xpath("(//p[contains(.,'Struktur bölmə daxilində')])[2]"));
                        ReusableMethods.flash(selectPerson1, getDriver());
                        ReusableMethods.flash(selectPerson2, getDriver());
//                    } else if (text.contains("Musa Rzayev")) {
//                        WebElement musa = getDriver().findElement(By.xpath("//p[contains(.,'Musa Rzayev')]"));
//                        ReusableMethods.flash(musa, getDriver());
//                        // Locate the modal container
//                        WebElement modalContainer = getDriver().findElement(By.cssSelector(".mdc-dialog__container .mat-mdc-dialog-surface"));
//                        ReusableMethods.scrollModalWindow(modalContainer);
//                        // Scroll down within the modal
////                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
////                        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", modalContainer);
                    } else if (text.contains("http://test.meis.competition.gov.az")) {
                        WebElement url = getDriver().findElement(By.xpath("//p[contains(.,'http://test.meis.competition.gov.az/')]"));
                        ReusableMethods.flash(url, getDriver());
                    } else if (text.contains("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir")) {
                        WebElement text1 = getDriver().findElement(By.xpath("//p[contains(.,'Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir')]"));
                        ReusableMethods.flash(text1, getDriver());
                    }
                }
            } else {
                page.noteBtn.click();
                ReusableMethods.wait(1);
                List<WebElement> notifications = getDriver().findElements(By.xpath("//div[@class='notifications_wrapper']"));
                for (WebElement notification : notifications) {
                    if (notification.getText().contains("AT_TesT_Structure")) {
                        notification.click();
                        System.out.println("Clicked on notification: " + notification.getText());
                        break;
                    }
                }
                List<String> textsToFind = Arrays.asList(
                        "AT_TesT_Structure",
                        "İcazə",
                        // "Digər",
                        "Fərid İmranov",
                        "Struktur bölmə daxilində",
                        //"Musa Rzayev",
                        "http://test.meis.competition.gov.az/",
                        "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"
                );
                for (String text : textsToFind) {
                    boolean isTextPresent = page.mainNote.getText().contains(text);
                    System.out.println("Text \"" + text + "\" is present: " + isTextPresent);
                    assert isTextPresent : "Text \"" + text + "\" is not present!";
                    if (text.contains("AT_TesT_Structure")) {
                        WebElement Attest = getDriver().findElement(By.xpath("//span[contains(.,'AT_TesT_Structure')]"));
                        ReusableMethods.flash(Attest, getDriver());
                    } else if (text.contains("Fərid İmranov")) {
                        WebElement tertibTeshkil = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[1]"));
                        WebElement terdibEden = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[2]"));
                        ReusableMethods.flash(tertibTeshkil, getDriver());
                        ReusableMethods.flash(terdibEden, getDriver());
                    } else if (text.contains("İcazə")) {
                        WebElement icaze = getDriver().findElement(By.xpath("//p[contains(.,'İcazə')]"));
                        ReusableMethods.flash(icaze, getDriver());
                    } else if (text.contains("Struktur bölmə daxilində")) {
                        WebElement selectPerson1 = getDriver().findElement(By.xpath("(//p[contains(.,'Struktur bölmə daxilində')])[1]"));
                        WebElement selectPerson2 = getDriver().findElement(By.xpath("(//p[contains(.,'Struktur bölmə daxilində')])[2]"));
                        ReusableMethods.flash(selectPerson1, getDriver());
                        ReusableMethods.flash(selectPerson2, getDriver());
//                    } else if (text.contains("Musa Rzayev")) {
//                        WebElement musa = getDriver().findElement(By.xpath("//p[contains(.,'Musa Rzayev')]"));
//                        ReusableMethods.flash(musa, getDriver());
//                        // Locate the modal container
//                        WebElement modalContainer = getDriver().findElement(By.cssSelector(".mdc-dialog__container .mat-mdc-dialog-surface"));
//                        ReusableMethods.scrollModalWindow(modalContainer);
//                        // Scroll down within the modal
////                        JavascriptExecutor js = (JavascriptExecutor) getDriver();
////                        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", modalContainer);
                    } else if (text.contains("http://test.meis.competition.gov.az")) {
                        WebElement url = getDriver().findElement(By.xpath("//p[contains(.,'http://test.meis.competition.gov.az/')]"));
                        ReusableMethods.flash(url, getDriver());
                    } else if (text.contains("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir")) {
                        WebElement text1 = getDriver().findElement(By.xpath("//p[contains(.,'Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir')]"));
                        ReusableMethods.flash(text1, getDriver());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("event modal window and information is displayed")
    public void eventModalWindowAndInformationIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        if (isElementVisible(page.mainNote, wait)) {
            List<String> textsToFind = Arrays.asList(
                    "AT_TesT_Structure",
                    "İcazə",
                    //"Digər",
                    "Fərid İmranov",
                    "Struktur bölmə daxilində",
                    //"Musa Rzayev",
                    "http://test.meis.competition.gov.az/",
                    "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"
            );
            for (String text : textsToFind) {
                boolean isTextPresent = page.mainNote.getText().contains(text);
                System.out.println("Text \"" + text + "\" is present: " + isTextPresent);
                assert isTextPresent : "Text \"" + text + "\" is not present!";
                if (text.contains("AT_TesT_Structure")) {
                    WebElement Attest = getDriver().findElement(By.xpath("//span[contains(.,'AT_TesT_Structure')]"));
                    ReusableMethods.flash(Attest, getDriver());
                } else if (text.contains("Fərid İmranov")) {
                    WebElement tertibTeshkil = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[1]"));
                    WebElement terdibEden = getDriver().findElement(By.xpath("(//p[contains(.,'Fərid İmranov')])[2]"));
                    ReusableMethods.flash(tertibTeshkil, getDriver());
                    ReusableMethods.flash(terdibEden, getDriver());
                } else if (text.contains("İcazə")) {
                    WebElement icaze = getDriver().findElement(By.xpath("//p[contains(.,'İcazə')]"));
                    ReusableMethods.flash(icaze, getDriver());
                } else if (text.contains("Struktur bölmə daxilində")) {
                    WebElement selectPerson1 = getDriver().findElement(By.xpath("(//p[contains(.,'Struktur bölmə daxilində')])[1]"));
                    WebElement selectPerson2 = getDriver().findElement(By.xpath("(//p[contains(.,'Struktur bölmə daxilində')])[2]"));
                    ReusableMethods.flash(selectPerson1, getDriver());
                    ReusableMethods.flash(selectPerson2, getDriver());
//                } else if (text.contains("Musa Rzayev")) {
//                    WebElement musa = getDriver().findElement(By.xpath("//p[contains(.,'Musa Rzayev')]"));
//                    ReusableMethods.flash(musa, getDriver());
//                    // Locate the modal container
//                    WebElement modalContainer = getDriver().findElement(By.xpath("//div[@class='content_wrapper']"));
//                    ReusableMethods.scrollModalWindow(modalContainer);
                } else if (text.contains("http://test.meis.competition.gov.az")) {
                    WebElement url = getDriver().findElement(By.xpath("//p[contains(.,'http://test.meis.competition.gov.az/')]"));
                    ReusableMethods.flash(url, getDriver());
                } else if (text.contains("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir")) {
                    WebElement text1 = getDriver().findElement(By.xpath("//p[contains(.,'Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir')]"));
                    ReusableMethods.flash(text1, getDriver());
                }
            }
        }
    }

    @Then("email about the new event is sent to the e-mail address and the information about new event is displayed")
    public void emailAboutTheNewEventIsSentToTheEMailAddressAndTheInformationAboutNewEventIsDisplayed() {
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
        WebElement spanElement2 = getDriver().findElement(By.xpath("(//input[@class='gb_je aJh'])[1]"));
        String text = "AT_TesT_Structure";
        spanElement2.sendKeys(text);
        spanElement2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        WebElement row = getDriver().findElement(By.xpath("(//span[contains(text(), 'AT_TesT_Structure')])[5]"));
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
        WebElement fayl = getDriver().findElement(By.xpath("//div[@class='aQH']"));
        ReusableMethods.flash(alltext, getDriver());
        ReusableMethods.flash(fayl, getDriver());

//        WebElement divElement = getDriver().findElement(By.xpath("//div[@class='a3s aiL ']"));
//        List<WebElement> childElements = divElement.findElements(By.xpath("//div[@class='a3s aiL ']"));
//        for (WebElement element : childElements) {
//            String text1 = element.getText().trim();
//            System.out.println("text1 = " + text1);
//            //assertTrue(text1.contains(" İcazə"));
//            //assertTrue(text1.contains(" 09.07.2024"));
//            assertTrue(text1.contains(" AT_TesT"));
//            assertTrue(text1.contains(" Fərid İmranov"));
//            assertTrue(text1.contains(" Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir"));
//            assertTrue(text1.contains(" Ünvanlanmış şəxslərə görə"));
//            assertTrue(text1.contains(" Musa Rzayev Davud"));
//            assertTrue(text1.contains(" http://test.meis.competition.gov.az/"));
        WebElement mainDiv = getDriver().findElement(By.cssSelector("div.a3s.aiL"));
        String[] textsToAssert = {
                "İcazə",
                "AT_TesT_Structure",
                "Fərid İmranov",
                "Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir",
                "Struktur bölmə daxilində",
                // "Musa Rzayev Davud",
                "http://test.meis.competition.gov.az/"
        };
        for (String text3 : textsToAssert) {
            boolean isTextPresent = (boolean) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].innerText.includes(arguments[1]);", mainDiv, text3);
            assertTrue("Text not found: " + text3, isTextPresent);
            System.out.println("Text found: " + text3);
        }

        ReusableMethods.wait(1);
    }

    @When("user deletes event for person from calendar tab")
    public void userDeletesEventForPersonFromCalendarTab() {
        page.EventDeleteBtn.click();
        ReusableMethods.wait(1);
        page.yesBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("event for person is deleted successfully")
    public void eventForPersonIsDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.personEventCheck);
    }

    @And("goes to the calendar tab from admin panel")
    public void goesToTheCalendarTabFromAdminPanel() {
        page.calTabAdmin.click();
        ReusableMethods.wait(1);
    }

    @And("adds name for new structure event")
    public void addsNameForNewStructureEvent() {
        ReusableMethods.wait(1);
        page.eventNameInput.sendKeys("AT_TesT_Structure");
    }

    @When("makes a copy of the event")
    public void makesACopyOfTheEvent() {
        page.copyEventBtn.click();
        ReusableMethods.wait(1);
        page.eventCopyNameInput.clear();
        page.eventCopyNameInput.sendKeys("AT_TesT_Structure_Copy");
        ReusableMethods.wait(1);
        page.acceptBtn.click();
        ReusableMethods.wait(2);
    }

    @Then("the copy of the event is being carried out successfully")
    public void theCopyOfTheEventIsBeingCarriedOutSuccessfully() {
        if (isElementVisible(page.mainNote, wait)) {
            page.closeModal.click();
            ReusableMethods.wait(1);
            page.calTabAdmin.click();
            ReusableMethods.wait(1);
            WebElement elem = getDriver().findElement(By.xpath("//p[contains(.,'AT_TesT_Structure_Copy')]"));
            ReusableMethods.flash(elem, getDriver());
            String text = "AT_TesT_Structure_Copy";
            System.out.println("elem = " + elem.getText());
            Assert.assertEquals(text, elem.getText());
        } else {
            page.calTabAdmin.click();
            ReusableMethods.wait(1);
            WebElement elem = getDriver().findElement(By.xpath("//p[contains(.,'AT_TesT_Structure_Copy')]"));
            ReusableMethods.flash(elem, getDriver());
            String text = "AT_TesT_Structure_Copy";
            System.out.println("elem = " + elem.getText());
            Assert.assertEquals(text, elem.getText());
        }
    }

    @When("user deletes all structure events from calendar tab")
    public void userDeletesAllStructureEventsFromCalendarTab() {
        if (page.strukCopyText.isDisplayed()) {
            page.EventDeleteBtn.click();
            ReusableMethods.wait(1);
            page.yesBtn.click();
            ReusableMethods.wait(4);
        }
        if (page.strukCopy.isDisplayed()) {
            page.EventDeleteBtn.click();
            ReusableMethods.wait(1);
            page.yesBtn.click();
        }
    }

    @Then("all structure events are deleted successfully")
    public void allStructureEventsAreDeletedSuccessfully() {
        ReusableMethods.assertElementNotDisplayed(page.strukCopyText);
        ReusableMethods.assertElementNotDisplayed(page.strukCopy);
    }

    @When("user selects new event for structure from calendar")
    public void userSelectsNewEventForStructureFromCalendar() {
        ReusableMethods.flash(page.findEvent1, getDriver());
        page.findEvent1.click();
        ReusableMethods.wait(1);
    }

    @And("selects category {string} for a new event")
    public void selectsCategoryForANewEvent(String selection) {
        if (selection.contains("Elan")) {
            page.categorySelect.click();
            ReusableMethods.wait(1);
            page.categoryAnnouncementSelect.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds name {string} for new event")
    public void addsNameForNewEvent(String selection) {
        if (selection.contains("AT_TesT")) {
            ReusableMethods.wait(1);
            page.eventNameInput.sendKeys("AT_TesT");
        }
    }

    @And("adds reminder {string} notification for the event")
    public void addsReminderNotificationForTheEvent(String selection) {
        if (selection.contains("00:15")) {
            page.reminderInput.sendKeys("00:15");
            ReusableMethods.wait(1);
        }
    }

    @And("adds url {string} for new event")
    public void addsUrlForNewEvent(String selection) {
        if (selection.contains("https://aist.group/")) {
            ReusableMethods.wait(1);
            page.eventUrlInput.sendKeys("https://aist.group/");
        }
    }

    @And("selects user {string} for new event notification")
    public void selectsUserForNewEventNotification(String selection) {
        if (selection.contains("Musa")) {
            page.choosePersonInput.sendKeys("Musa Rza");
            ReusableMethods.wait(2);
            page.choosePersonMusa.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveByOffset(5, 5).click().build().perform();
        }
    }

    @And("adds start date and time {string} for new event")
    public void addsStartDateAndTimeForNewEvent(String selection) {
        if (selection.contains("00:30")) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = today.format(formatter);
            System.out.println("formattedDate = " + formattedDate);
            ReusableMethods.wait(1);
            page.eventStartDateInput.sendKeys(formattedDate);
            page.startTimeInput.sendKeys("00:30");
            ReusableMethods.wait(1);
        }
    }

    @And("adds end date and time {string} for new event")
    public void addsEndDateAndTimeForNewEvent(String selection) {
        if (selection.contains("17:00")) {
            LocalDate tomorrow = LocalDate.now().plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = tomorrow.format(formatter);
            System.out.println("formattedDate = " + formattedDate);
            ReusableMethods.wait(1);
            page.eventEndDateInput.sendKeys(formattedDate);
            page.endTimeInput.sendKeys("17:00");
            ReusableMethods.wait(1);
        }
    }

    @And("adds the person {string} who organized the new event")
    public void addsThePersonWhoOrganizedTheNewEvent(String selection) {
        if (selection.contains("Abbas")) {
            page.eventOrganizer.sendKeys("Abbas Rzayev");
            ReusableMethods.wait(1);
            page.addAbbas.click();
            ReusableMethods.wait(1);
        }
    }

    @And("selects user {string} for status view according to the addressees")
    public void selectsUserForStatusViewAccordingToTheAddressees(String selection) {
        if (selection.contains("Musa")) {
            page.chooseCalendarWhoWillSee.click();
            ReusableMethods.wait(1);
            page.calendarVisibilityForPerson.click();
            ReusableMethods.wait(1);
//            page.statusAccordingToPersonSelect.click();
//            ReusableMethods.wait(1);
//            page.choosePersonInput.sendKeys("Davud");
//            ReusableMethods.wait(2);
//            page.choosePersonDavud.click();
//            ReusableMethods.wait(1);
//            Actions actions = new Actions(getDriver());
//            actions.moveByOffset(5, 5).click().build().perform();
        }
    }

    @And("adds the description {string} for the new event")
    public void addsTheDescriptionForTheNewEvent(String selection) {
        if (selection.contains("Tədbir AT elanı məqsədi ilə əlavə edildi!")) {
            // page.addDescription.sendKeys("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir");
            page.addDescription.sendKeys("Tədbir AT elanı məqsədi ilə əlavə edildi!");
        }
    }

    @And("determines where the event {string} will be held")
    public void determinesWhereTheEventWillBeHeld(String selection) {
        if (selection.contains("671 nömrəli otaq")) {
            page.eventPlace.click();
            ReusableMethods.wait(1);
            page.placeSelectRoom671.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds the picture {string} for the new event")
    public void addsThePictureForTheNewEvent(String selection) {
        if (selection.contains("Test")) {
            page.addPhoto.click();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\TestFiles\\Test.png";
            ReusableMethods.robotClassDosyaYukleme(path);
        } else if (selection.contains("QAAT")) {
            page.addPhoto.click();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\QAAT.png";
            ReusableMethods.robotClassDosyaYukleme(path);
        }
    }

    @And("adds the file {string} for the new event")
    public void addsTheFileForTheNewEvent(String selection) {
        if (selection.contains("QaAutomation")) {
            page.addFileNew.click();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\QaAutomation.pdf";
            ReusableMethods.robotClassDosyaYukleme(path);
        } else if (selection.contains("EndToEnd")) {
            page.addFileNew.click();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\EndToEnd.pdf";
            ReusableMethods.robotClassDosyaYukleme(path);
        }
    }

    @Then("new event successfully created and all information is displayed in the control panel")
    public void newEventSuccessfullyCreatedAndAllInformationIsDisplayedInTheControlPanel(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String eventName = row.get("Başlıq");
            String eventStatus = row.get("Status");
            ReusableMethods.flash(page.eventName, getDriver());
            Assert.assertEquals(page.eventName.getText().trim(), eventName);
            ReusableMethods.wait(1);

            String dateText = page.eventDataTime.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.eventDataTime, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            ReusableMethods.flash(page.eventStatus, getDriver());
            Assert.assertEquals(page.eventStatus.getText().trim(), eventStatus);
            ReusableMethods.wait(1);
        }
    }

    @And("all the information about event is displayed in the notification")
    public void allTheInformationAboutEventIsDisplayedInTheNotification(DataTable dataTable) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            if (isElementVisible(helpDeskPage.noteMainCheck, wait)) {
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String eventName = row.get("Tədbirin adı");
                    String category = row.get("Kateqoriya");
                    String eventPLace = row.get("Tədbirin keçiriləcəyi yer");
                    String eventOrganizer = row.get("Tədbiri təşkil edən");
                    String whoCreate = row.get("Tərtib edən");
                    String notStatus = row.get("Bildiriş statusu");
                    String viewStatus = row.get("Baxış statusu");
                    String persons = row.get("Şəxslər");
                    //String startData = row.get("Başlama tarixi");
                    String startTime = row.get("Başlama vaxtı");
                    String endTime = row.get("Bitmə vaxtı");
                    String url = row.get("Url");
                    String type = row.get("Tip");
                    String description = row.get("Təsvir");

                    WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
                    ReusableMethods.waitForOverlayToDisappear(getDriver());

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.notTextCheck, getDriver());
                    Assert.assertEquals(page.notTextCheck.getText().trim(), eventName);
                    ReusableMethods.wait(1);

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.categoryName, getDriver());
                    Assert.assertEquals(page.categoryName.getText().trim(), category);
                    ReusableMethods.wait(1);

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.eventPLace, getDriver());
                    Assert.assertEquals(page.eventPLace.getText().trim(), eventPLace);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.eventOrganizerName, getDriver());
                    Assert.assertEquals(page.eventOrganizerName.getText().trim(), eventOrganizer);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoCreate, getDriver());
                    Assert.assertEquals(page.whoCreate.getText().trim(), whoCreate);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.notStatus, getDriver());
                    Assert.assertEquals(page.notStatus.getText().trim(), notStatus);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.viewStatus, getDriver());
                    Assert.assertEquals(page.viewStatus.getText().trim(), viewStatus);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.persons, getDriver());
                    System.out.println("page.persons.getText() = " + page.persons.getText());
                    Assert.assertEquals(page.persons.getText().trim(), persons);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.startDataInfo);
                    ReusableMethods.flash(page.startDataInfo, getDriver());
                    LocalDate today = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    String formattedDate = today.format(formatter);
                    Assert.assertEquals(page.startDataInfo.getText().trim(), formattedDate);
                    ReusableMethods.wait(1);


                    ReusableMethods.scrollToElementByActions(page.startTimeInfo);
                    ReusableMethods.flash(page.startTimeInfo, getDriver());
                    Assert.assertEquals(page.startTimeInfo.getText().trim(), startTime);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.endTime);
                    ReusableMethods.flash(page.endTime, getDriver());
                    Assert.assertEquals(page.endTime.getText().trim(), endTime);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.urlInfo);
                    ReusableMethods.flash(page.urlInfo, getDriver());
                    Assert.assertEquals(page.urlInfo.getText().trim(), url);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.typeInfo, getDriver());
                    Assert.assertEquals(page.typeInfo.getText().trim(), type);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.descriptionInfo);
                    ReusableMethods.flash(page.descriptionInfo, getDriver());
                    Assert.assertEquals(page.descriptionInfo.getText().trim(), description);
                    ReusableMethods.wait(1);

                    WebElement image = getDriver().findElement(By.xpath("//img[@alt='Şəkil']"));
                    String srcValue = image.getAttribute("src").trim();

                    ReusableMethods.scrollToElementByActions(image);
                    ReusableMethods.flash(image, getDriver());


                    if (srcValue == null || srcValue.isEmpty() || srcValue.equals("data:")) {
                        throw new AssertionError("XƏTA: Şəkil src dəyəri mövcud deyil və ya boşdur!");
                    } else {
                        System.out.println("Şəkil src dəyəri: " + srcValue);
                    }
                }
            } else {
                ReusableMethods.wait(1);
                WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                button.click();
                ReusableMethods.wait(3);
                System.out.println("\"Imhere1\" = " + "Imhere0");
//                By.xpath("//li[.//span[contains(normalize-space(),'Yardım masası')]][1]");
//                By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]");
                WebElement element = getDriver().findElement(By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]"));
//                JavascriptExecutor js = (JavascriptExecutor) getDriver();
//                js.executeScript("arguments[0].click();", element);
                element.click();
                ReusableMethods.wait(5);
                System.out.println("\"Imhere1\" = " + "Imhere1");
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String eventName = row.get("Tədbirin adı");
                    String category = row.get("Kateqoriya");
                    String eventPLace = row.get("Tədbirin keçiriləcəyi yer");
                    String eventOrganizer = row.get("Tədbiri təşkil edən");
                    String whoCreate = row.get("Tərtib edən");
                    String notStatus = row.get("Bildiriş statusu");
                    String viewStatus = row.get("Baxış statusu");
                    String persons = row.get("Şəxslər");
                    String startData = row.get("Başlama tarixi");
                    String startTime = row.get("Başlama vaxtı");
                    String endTime = row.get("Bitmə vaxtı");
                    String url = row.get("Url");
                    String type = row.get("Tip");
                    String description = row.get("Təsvir");

                    WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
                    System.out.println("\"Imhere1\" = " + "Imhere2");
                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.wait(5);
                    ReusableMethods.flash(page.notTextCheck, getDriver());
                    Assert.assertEquals(page.notTextCheck.getText().trim(), eventName);
                    ReusableMethods.wait(1);
                    System.out.println("\"Imhere1\" = " + "Imhere3");

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.categoryName, getDriver());
                    Assert.assertEquals(page.categoryName.getText().trim(), category);
                    ReusableMethods.wait(1);

                    ReusableMethods.waitForOverlayToDisappear(getDriver());
                    ReusableMethods.flash(page.eventPLace, getDriver());
                    Assert.assertEquals(page.eventPLace.getText().trim(), eventPLace);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.eventOrganizerName, getDriver());
                    Assert.assertEquals(page.eventOrganizerName.getText().trim(), eventOrganizer);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoCreate, getDriver());
                    Assert.assertEquals(page.whoCreate.getText().trim(), whoCreate);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.notStatus, getDriver());
                    Assert.assertEquals(page.notStatus.getText().trim(), notStatus);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.viewStatus, getDriver());
                    Assert.assertEquals(page.viewStatus.getText().trim(), viewStatus);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.persons, getDriver());
                    System.out.println("page.persons.getText() = " + page.persons.getText());
                    Assert.assertEquals(page.persons.getText().trim(), persons);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.startDataInfo);
                    ReusableMethods.flash(page.startDataInfo, getDriver());
                    LocalDate today = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    String formattedDate = today.format(formatter);
                    Assert.assertEquals(page.startDataInfo.getText().trim(), formattedDate);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.startTimeInfo);
                    ReusableMethods.flash(page.startTimeInfo, getDriver());
                    Assert.assertEquals(page.startTimeInfo.getText().trim(), startTime);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.endTime);
                    ReusableMethods.flash(page.endTime, getDriver());
                    Assert.assertEquals(page.endTime.getText().trim(), endTime);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.urlInfo);
                    ReusableMethods.flash(page.urlInfo, getDriver());
                    Assert.assertEquals(page.urlInfo.getText().trim(), url);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.typeInfo, getDriver());
                    Assert.assertEquals(page.typeInfo.getText().trim(), type);
                    ReusableMethods.wait(1);

                    ReusableMethods.scrollToElementByActions(page.descriptionInfo);
                    ReusableMethods.flash(page.descriptionInfo, getDriver());
                    Assert.assertEquals(page.descriptionInfo.getText().trim(), description);
                    ReusableMethods.wait(1);

                    WebElement image = getDriver().findElement(By.xpath("//img[@alt='Şəkil']"));
                    String srcValue = image.getAttribute("src").trim();

                    ReusableMethods.scrollToElementByActions(image);
                    ReusableMethods.flash(image, getDriver());

                    if (srcValue == null || srcValue.isEmpty() || srcValue.equals("data:")) {
                        throw new AssertionError("XƏTA: Şəkil src dəyəri mövcud deyil və ya boşdur!");
                    } else {
                        System.out.println("Şəkil src dəyəri: " + srcValue);

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test zamanı istisna baş verdi: " + e.getMessage());
        }
    }

    @And("select close button in the notification modal window")
    public void selectCloseButtonInTheNotificationModalWindow() {
        page.closeButtonNotificationModal.click();
        ReusableMethods.wait(2);
    }

    @And("goes to the calendar tab from left side bar")
    public void goesToTheCalendarTabFromLeftSideBar() {
        getDriver().navigate().refresh();
        ReusableMethods.wait(1);
        page.calendarLeftSideBar.click();
        ReusableMethods.wait(1);
    }

    @Then("event name {string} is shown in the calendar")
    public void eventNameIsShownInTheCalendar(String selection) {
        if (selection.contains("AT_TesT")) {
            ReusableMethods.flash(page.eventNameCalendar, getDriver());
            String expected = "AT_TesT";
            String actual = page.eventNameCalendar.getText().trim();
            Assert.assertEquals(actual, expected);
        }
    }

    @And("select event from calendar")
    public void selectEventFromCalendar() {
        page.eventNameCalendar.click();
        ReusableMethods.wait(1);
    }

    @Then("all the information about event is displayed in the event modal window")
    public void allTheInformationAboutEventIsDisplayedInTheEventModalWindow(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String eventName = row.get("Tədbirin adı");
            String category = row.get("Kateqoriya");
            String eventPLace = row.get("Tədbirin keçiriləcəyi yer");
            String eventOrganizer = row.get("Tədbiri təşkil edən");
            String whoCreate = row.get("Tərtib edən");
            String notStatus = row.get("Bildiriş statusu");
            String viewStatus = row.get("Baxış statusu");
            String persons = row.get("Şəxslər");
            String startTime = row.get("Başlama vaxtı");
            String endTime = row.get("Bitmə vaxtı");
            String url = row.get("Url");
            String type = row.get("Tip");
            String description = row.get("Təsvir");

            ReusableMethods.flash(page.eventNameCal, getDriver());
            Assert.assertEquals(page.eventNameCal.getText().trim(), eventName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.categoryNameCal, getDriver());
            Assert.assertEquals(page.categoryNameCal.getText().trim(), category);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.eventPLaceCal, getDriver());
            Assert.assertEquals(page.eventPLaceCal.getText().trim(), eventPLace);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.eventOrganizerNameCal, getDriver());
            Assert.assertEquals(page.eventOrganizerNameCal.getText().trim(), eventOrganizer);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.whoCreateCal, getDriver());
            Assert.assertEquals(page.whoCreateCal.getText().trim(), whoCreate);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.notStatusCal, getDriver());
            Assert.assertEquals(page.notStatusCal.getText().trim(), notStatus);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.viewStatusCal, getDriver());
            Assert.assertEquals(page.viewStatusCal.getText().trim(), viewStatus);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.personsCal);
            ReusableMethods.flash(page.personsCal, getDriver());
            Assert.assertEquals(page.personsCal.getText().trim(), persons);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.startDataInfoCal);
            ReusableMethods.scrollToElementByActions(page.startDataInfoCal);
            ReusableMethods.flash(page.startDataInfoCal, getDriver());
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = today.format(formatter);
            Assert.assertEquals(page.startDataInfoCal.getText().trim(), formattedDate);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.startTimeInfoCal);
            ReusableMethods.flash(page.startTimeInfoCal, getDriver());
            Assert.assertEquals(page.startTimeInfoCal.getText().trim(), startTime);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.endTimeCal);
            ReusableMethods.flash(page.endTimeCal, getDriver());
            Assert.assertEquals(page.endTimeCal.getText().trim(), endTime);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.urlInfoCal);
            ReusableMethods.flash(page.urlInfoCal, getDriver());
            Assert.assertEquals(page.urlInfoCal.getText().trim(), url);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.typeInfoCal);
            ReusableMethods.flash(page.typeInfoCal, getDriver());
            Assert.assertEquals(page.typeInfoCal.getText().trim(), type);
            ReusableMethods.wait(1);

            ReusableMethods.scrollToElementByActions(page.descriptionInfoCal);
            ReusableMethods.flash(page.descriptionInfoCal, getDriver());
            Assert.assertEquals(page.descriptionInfoCal.getText().trim(), description);
            ReusableMethods.wait(1);
        }
    }
}