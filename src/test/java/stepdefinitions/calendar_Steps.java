package stepdefinitions;

import Page.calendar_Page;
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
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class calendar_Steps {
    calendar_Page page = new calendar_Page();
    registration_Page page1 = new registration_Page();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));


    @And("goes to the calendar tab")
    public void goesToTheCalendarTab() {
        ReusableMethods.waitForClickability(page.calendarPage, 1);
        ReusableMethods.wait(1);
        page.calendarPage.click();
    }

    @And("selects new event button")
    public void selectsNewEventButton() {
        ReusableMethods.waitForClickability(page.newEventBtn, 1);
        ReusableMethods.wait(1);
        page.newEventBtn.click();
    }

    @And("adds name for new event")
    public void addsNameForNewEvent() {
        ReusableMethods.wait(1);
        page.eventNameInput.sendKeys("AT_TesT");
    }

    @And("adds start date for new event")
    public void addsStartdateForNewEvent() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = today.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.eventStartDateInput.sendKeys(formattedDate);
    }

    @And("adds end date for new event")
    public void addsEnddateForNewEvent() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = tomorrow.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.eventEndDateInput.sendKeys(formattedDate);
    }

    @And("adds url for new event")
    public void addsUrlForNewEvent() {
        ReusableMethods.wait(1);
        page.eventUrlInput.sendKeys("http://test.meis.competition.gov.az/");
    }

    @And("selects users for new event notification")
    public void selectsUsersForNewEventNotification() {
        ReusableMethods.wait(1);
        page.notChoose.click();
        ReusableMethods.wait(1);
        page.notChooseForPerson.click();
        ReusableMethods.wait(1);
        page.ChoosePersonInput.sendKeys("Musa");
        ReusableMethods.wait(2);
        page.ChoosePersonAbbas.click();
        ReusableMethods.wait(1);
    }

    @And("chooses whose calendar the event will appear on")
    public void choosesWhoseCalendarTheEventWillAppearOn() {
        page.chooseCalendarWhoWillSee.click();
        ReusableMethods.wait(1);
        page.calendarVisabilityForPerson.click();
        ReusableMethods.wait(1);
    }

    @And("sets the category for the new event")
    public void setsTheCategoryForTheNewEvent() {
        page.categoryList.click();
        ReusableMethods.wait(1);
        page.categoryPermitList.click();
        ReusableMethods.wait(1);
    }

    @And("determines where the event will be held")
    public void determinesWhereTheEventWillBeHeld() {
        page.eventPlace.click();
        ReusableMethods.wait(1);
        page.placeSelect.click();
        ReusableMethods.wait(1);
    }

    @And("adds the person who organized the new event")
    public void addsThePersonWhoOrganizedTheNewEvent() {
        page.eventOrganizer.click();
        ReusableMethods.wait(1);
        page.organizerPerson.click();
        ReusableMethods.wait(1);
        page.AddNamePersonInput.sendKeys("Fərid İmranov");
        ReusableMethods.wait(1);
        page.addFerid.click();
    }

    @And("adds the picture for the new event")
    public void addsThePictureForTheNewEvent() {
        page.addPhoto.click();
        String path = "C:\\Users\\User\\TestFiles\\Test.png";
        ReusableMethods.robotClassDosyaYukleme(path);
    }

    @And("adds the description for the new event")
    public void addsTheDescriptionForTheNewEvent() {
        page.addDescription.sendKeys("Bu tədbirin məqsədi layihələrimizin daha keyfiyyətli icra edilməsi üçün səbəblərin müzakirəsidir");
    }

    @And("selects submit button for the new event")
    public void selectsSubmitButtonForTheNewEvent() {
        page.acceptBtn.click();
        ReusableMethods.wait(1);
    }

    @Then("new event successfully created")
    public void newEventSuccessfullyCreated() {
        WebElement calTab = getDriver().findElement(By.xpath("//span[text()='Təqvim']"));
        calTab.click();
        ReusableMethods.wait(1);
        WebElement element = getDriver().findElement(By.xpath("//p[contains(.,'AT_TesT')]"));
        if (element.isDisplayed()) {
            WebElement event = getDriver().findElement(By.xpath("(//mat-card[@class='mat-mdc-card mdc-card item-wrapper ng-star-inserted'])[1]"));
            ReusableMethods.flash(event, getDriver());
        } else {
            System.out.println("element gorsenmedi");
        }
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

    @And("adds the person the new event who organized")
    public void addsThePersonTheNewEventWhoOrganized() {
        page.eventOrganizer.click();
        ReusableMethods.wait(1);
        page.organizerPerson.click();
        ReusableMethods.wait(1);
        page.AddNameStrukPersonInput.sendKeys("Fərid İmranov");
        ReusableMethods.wait(1);
        page.addFerid.click();
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
        if(isElementVisible(page.mainNote, wait))
        {
            page.closeModal.click();
            ReusableMethods.wait(1);
            page.calTabAdmin.click();
            ReusableMethods.wait(1);
            WebElement elem = getDriver().findElement(By.xpath("//p[contains(.,'AT_TesT_Structure_Copy')]"));
            ReusableMethods.flash(elem, getDriver());
            String text = "AT_TesT_Structure_Copy";
            System.out.println("elem = " + elem.getText());
            Assert.assertEquals(text, elem.getText());
        }
        else {
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
        if(page.strukCopyText.isDisplayed())
        {
            page.EventDeleteBtn.click();
            ReusableMethods.wait(1);
            page.yesBtn.click();
            ReusableMethods.wait(4);
        }
        if(page.strukCopy.isDisplayed()) {
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
}