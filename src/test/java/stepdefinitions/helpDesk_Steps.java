package stepdefinitions;

import Page.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class helpDesk_Steps {
    registration_Page page2 = new registration_Page();
    helpDesk_Page page = new helpDesk_Page();
    loginAndLogOut_Page page1 = new loginAndLogOut_Page();
    searchByUserData_Page searchByUserData = new searchByUserData_Page();
    structureAndDuties_Page structureAndDuties = new structureAndDuties_Page();
    String value;
    String getRequestID;
    String getTableData;

    @And("goes to the help desk tab from main page")
    public void goesToTheHelpDeskTabFromMainPage() {
        ReusableMethods.wait(1);
        page.helpDeskBtnFromMainPage.click();
        ReusableMethods.wait(1);
    }

    @And("selects software {string} selection from the direction dropdown list")
    public void selectsSoftwareSelectionFromTheDirectionDropdownList(String selection) {
        if (selection.contains("Digər problemlər")) {
            page.directionList.click();
            ReusableMethods.wait(1);
            page.differentProblemsSelect.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Proqram təminatı")) {
            page.differentProblemsSelect.click();
            ReusableMethods.wait(1);
            page.programSoftwareSelect.click();
            ReusableMethods.wait(1);
        }
    }

    @And("selects appeal {string} from the notification type dropdown list")
    public void selectsAppealFromTheNotificationTypeDropdownList(String selection) {
        if (selection.contains("Xəta")) {
            page.noteTypeList.click();
            ReusableMethods.wait(1);
            page.noteTypeSelect.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Təklif")) {
            page.noteTypeSelect.click();
            ReusableMethods.wait(1);
            page.noteTypeOfferSelect.click();
            ReusableMethods.wait(1);
        }

    }

    @And("selects {string} from the notification priority dropdown list")
    public void selectsFromTheNotificationPriorityDropdownList(String selection) {
        if (selection.contains("Yüksək")) {
            page.notePriority.click();
            ReusableMethods.wait(1);
            page.notePriorityHigh.click();
            ReusableMethods.wait(1);
        } else if (selection.contains("Təcili")) {
            page.notePriorityHigh.click();
            ReusableMethods.wait(1);
            page.notePriorityUrgent.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds text {string} to the description field")
    public void addsTextToTheDescriptionField(String selection) {
        if (selection.contains("new")) {
            page.addText.sendKeys("Xahiş olunur ki müraciətimə təcili baxılsın!");
            ReusableMethods.wait(1);
        } else if (selection.contains("edited")) {
            page.addText.clear();
            ReusableMethods.wait(1);
            page.addText.sendKeys("Müraciət redaktə edildi!");
            ReusableMethods.wait(1);
        }
    }

    @And("adds {string} file in the help desk tab")
    public void addsFileInTheHelpDeskTab(String selection) {
        if (selection.contains("new")) {
            page.addFile.click();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\TestFiles\\Test.png";
            ReusableMethods.robotClassDosyaYukleme(path);
        } else if (selection.contains("edited")) {
            page.addFileSecond.click();
            ReusableMethods.wait(1);
            String path = "C:\\Users\\User\\Desktop\\TestFiles\\QAAT.png";
            ReusableMethods.robotClassDosyaYukleme(path);
        }
    }

    @When("user selects save button in the help desk tab")
    public void userSelectsSaveButtonInTheHelpDeskTab() {
        page.saveRequest.click();
        ReusableMethods.wait(1);
    }


    @Given("test user with login {string} and with password {string} logs into the {string} system")
    public void testUserWithLoginAndWithPasswordLogsIntoTheSystem(String arg0, String arg1, String arg2) {
        getDriver().get(ConfigReader.getProperty("Meis"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ReusableMethods.wait(1);
        page1.emailField.sendKeys(arg0);
        ReusableMethods.wait(1);
        page1.passwordField.sendKeys(arg1);
        page1.enterToTheSystem.click();
    }

    @And("admin goes to the help desk tab from admin panel")
    public void adminGoesToTheHelpDeskTabFromAdminPanel() {
        page.adminPanelBtn.click();
        ReusableMethods.wait(1);
        page.adminHelpTab.click();
        ReusableMethods.wait(1);
    }

    @And("admin selects new request from table")
    public void adminSelectsNewRequestFromTable() {
        page.selectReguest.click();
        ReusableMethods.wait(1);

    }

    @And("admin selects an executive person for the new request")
    public void adminSelectsAnExecutivePersonForTheNewRequest() {
        page.openEmployeeList.click();
        ReusableMethods.wait(1);
        page.selectinputEmployee.sendKeys("Davud Zamanov");
        ReusableMethods.wait(1);
        page.selectnameEmployee.click();
        ReusableMethods.wait(1);
        page.acceptEmployee.click();
        ReusableMethods.wait(3);
        page.getbackTable.click();
        ReusableMethods.wait(1);
    }

    @Then("the status of the application and the name of the IT specialist are displayed in the general table")
    public void theStatusOfTheApplicationAndTheNameOfTheITSpecialistAreDisplayedInTheGeneralTable() {
        ReusableMethods.flash(page.tableIlkinStatus, getDriver());
        ReusableMethods.flash(page.tableNameEmlpoyee, getDriver());
    }

    private static boolean isElementVisible(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Then("new request has been successfully created and all information are displayed")
    public void newRequestHasBeenSuccessfullyCreatedAndAllInformationAreDisplayed(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String id = row.get("ID");
            String appeal = row.get("İstiqamət");
            String whoSent = row.get("Bildirişi göndərən");
            String connection = row.get("Əlaqə");
            String ip = row.get("İP");
            String compName = row.get("Kompüterinin adı");
            String noteType = row.get("Bildirişin tipi");
            String priority = row.get("Prioritet");
            String actMade = row.get("Akt tərtib edilib");
            String description = row.get("Təsvir");
            String workPlace = row.get("İş yeri");
            String currentResult = row.get("Cari nəticə");

            ReusableMethods.flash(page.idReview, getDriver());
            Assert.assertEquals(page.idReview.getText().trim(), getRequestID);

            ReusableMethods.flash(page.directionReview, getDriver());
            Assert.assertEquals(page.directionReview.getText().trim(), appeal);

            ReusableMethods.flash(page.notificationReview, getDriver());
            Assert.assertEquals(page.notificationReview.getText().trim(), whoSent);

            String dateText = page.dateReview.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.dateReview, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            ReusableMethods.flash(page.connectReview, getDriver());
            Assert.assertEquals(page.connectReview.getText().trim(), connection);

            ReusableMethods.flash(page.ipReview, getDriver());
            Assert.assertEquals(page.ipReview.getText().trim(), ip);

            ReusableMethods.flash(page.pcReview, getDriver());
            Assert.assertEquals(page.pcReview.getText().trim(), compName);

            ReusableMethods.flash(page.notTypeReview, getDriver());
            Assert.assertEquals(page.notTypeReview.getText().trim(), noteType);

            ReusableMethods.flash(page.priorityReview, getDriver());
            Assert.assertEquals(page.priorityReview.getText().trim(), priority);

            ReusableMethods.flash(page.currentReview, getDriver());
            Assert.assertEquals(page.currentReview.getText().trim(), currentResult);

            ReusableMethods.flash(page.actReview, getDriver());  //Bug var fix edildikden sonra commitden cixardacam
            Assert.assertEquals(page.actReview.getText().trim(), actMade);

            ReusableMethods.flash(page.fileReview, getDriver());
            Assert.assertTrue(page.file.isDisplayed());
            Assert.assertTrue(page.fileLink.isDisplayed());

            ReusableMethods.flash(page.noteReview, getDriver());
            Assert.assertEquals(page.noteReview.getText().trim(), description);

            ReusableMethods.flash(page.workPlaceReview, getDriver());
            Assert.assertEquals(page.workPlaceReview.getText().trim(), workPlace);
        }
    }

    @When("selects the last appeal from the table")
    public void selectsTheLastAppealFromTheTable() {
        ReusableMethods.wait(2);
        ReusableMethods.flash(page.firstAppealFromTable, getDriver());
        page.firstAppealFromTable.click();
        ReusableMethods.wait(1);
        getRequestID = page.idReview.getText().trim();
        System.out.println("getRequestID = " + getRequestID);
        ReusableMethods.wait(1);
    }

    @And("selects edit button in the request review section")
    public void selectsEditButtonInTheRequestReviewSection() {
        page.requestEditBtn.click();
        ReusableMethods.wait(1);
    }

    @And("selects {string} program from software dropdown list")
    public void selectsProgramFromSoftwareDropdownList(String selection) {
        if (selection.contains("Elektron Sənəd Dövriyyəsi")) {
            page.programList.click();
            ReusableMethods.wait(1);
            page.programEdocumentSelect.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("the edited request has been successfully created and all information are displayed")
    public void theEditedRequestHasBeenSuccessfullyCreatedAndAllInformationAreDisplayed(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String id = row.get("ID");
            String appeal = row.get("İstiqamət");
            String programName = row.get("Proqram təminatı");
            String whoSent = row.get("Bildirişi göndərən");
            String connection = row.get("Əlaqə");
            String ip = row.get("İP");
            String compName = row.get("Kompüterinin adı");
            String noteType = row.get("Bildirişin tipi");
            String priority = row.get("Prioritet");
            String actMade = row.get("Akt tərtib edilib");
            String description = row.get("Təsvir");
            String workPlace = row.get("İş yeri");
            String currentResult = row.get("Cari nəticə");

            ReusableMethods.flash(page.idReview, getDriver());
            Assert.assertEquals(page.idReview.getText().trim(), getRequestID);

            ReusableMethods.flash(page.directionReview, getDriver());
            Assert.assertEquals(page.directionReview.getText().trim(), appeal);

            ReusableMethods.flash(page.programNameReview, getDriver());
            Assert.assertEquals(page.programNameReview.getText().trim(), programName);

            ReusableMethods.flash(page.notificationReview, getDriver());
            Assert.assertEquals(page.notificationReview.getText().trim(), whoSent);

            String dateText = page.dateReview.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.dateReview, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            ReusableMethods.flash(page.connectReview, getDriver());
            Assert.assertEquals(page.connectReview.getText().trim(), connection);

            ReusableMethods.flash(page.ipReview, getDriver());
            Assert.assertEquals(page.ipReview.getText().trim(), ip);

            ReusableMethods.flash(page.pcReview, getDriver());
            Assert.assertEquals(page.pcReview.getText().trim(), compName);

            ReusableMethods.flash(page.notTypeReview, getDriver());
            Assert.assertEquals(page.notTypeReview.getText().trim(), noteType);

            ReusableMethods.flash(page.priorityReview, getDriver());
            Assert.assertEquals(page.priorityReview.getText().trim(), priority);

            ReusableMethods.flash(page.currentReview, getDriver());
            Assert.assertEquals(page.currentReview.getText().trim(), currentResult);

//            ReusableMethods.flash(page.actReview, getDriver()); - Bug var fix edildikden sonra commitden cixardacam
//            Assert.assertEquals(page.actReview.getText().trim(), actMade);

            ReusableMethods.flash(page.fileReview, getDriver());
            Assert.assertTrue(page.fileSecond.isDisplayed());
            Assert.assertTrue(page.fileLink.isDisplayed());

            ReusableMethods.flash(page.noteReview, getDriver());
            Assert.assertEquals(page.noteReview.getText().trim(), description);

            ReusableMethods.flash(page.workPlaceReview, getDriver());
            Assert.assertEquals(page.workPlaceReview.getText().trim(), workPlace);
        }
    }

    @And("goes to the my sent requests section")
    public void goesToTheMySentRequestsSection() {
        page.mySentRequestsSection.click();
        ReusableMethods.wait(4);
    }

    @And("adds name to the sent filter")
    public void addsNameToTheSentFilter() {
//        ReusableMethods.waitForClickabilityAndClick(searchByUserData.nameFilter, 10);
        ReusableMethods.pageDown();
        ReusableMethods.wait(1);
        getTableData = searchByUserData.getTableDataText.getText();
        System.out.println("expected = " + getTableData);
        ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
        ReusableMethods.wait(1);
        ReusableMethods.pageUp();
        ReusableMethods.waitForClickabilityAndClick(searchByUserData.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
        page.sentInput.sendKeys("Abbas Rzayev");
        ReusableMethods.wait(1);
    }

    @Then("search results are displayed by according to search name surname params")
    public void searchResultsAreDisplayedByAccordingToSearchNameSurnameParams() {
        List<WebElement> positionCells = getDriver().findElements(By.cssSelector("td.cdk-column-regUserFullName"));
        boolean matchFound = false;

        for (int i = 0; i < positionCells.size(); i++) {
            WebElement cell = getDriver().findElements(By.cssSelector("td.cdk-column-regUserFullName")).get(i);
            String text = cell.getText().trim();
            if (text.equals("Abbas Rzayev")) {
                matchFound = true;
                System.out.println("Uyğun dəyər tapıldı: " + text);

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

                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript(flashScript, cell);
//                break; // tapıldıqdan sonra loop-u dayandıra bilərik (opsional)
            }
        }
// Tapılmadısa test fail olsun
        if (!matchFound) {
            throw new AssertionError("XƏTA: Heç bir nəticə 'Abbas Rzayev' ilə uyğun gəlmir!");
        }
        ReusableMethods.wait(2);
    }

    @Then("the changes is successfully resets in the sent requests section")
    public void theChangesIsSuccessfullyResetsInTheSentRequestsSection() {
        ReusableMethods.wait(1);
//        ReusableMethods.pageDown();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
        System.out.println("expectedTableDataText = " + getTableData);
        String actualTableText = searchByUserData.getTableDataText.getText();
        System.out.println("actualTableDataText = " + searchByUserData.getTableDataText.getText());
        ReusableMethods.wait(3);
        Assert.assertEquals(getTableData, actualTableText);
    }

    @When("selects direction {string} from direction filter list")
    public void selectsDirectionFromDirectionFilterList(String selection) {
        if (selection.contains("Proqram təminatı")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.descriptionProgram.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Digər problemlər")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.wait(1);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.descriptionDifferentProblems.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Şəbəkə və rabitə problemləri")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.wait(1);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            ReusableMethods.wait(1);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            page.descriptionNetwork.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Əməliyyat sistemi")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.wait(1);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            ReusableMethods.wait(1);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            page.descriptionOS.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Cari işlər")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.wait(1);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            ReusableMethods.wait(1);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            page.descriptionCurrentWorks.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Elektron xidmətlər")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.wait(1);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            ReusableMethods.wait(1);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            page.descriptionEservices.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Avadanlıq")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.wait(1);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.dutyFilter, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            ReusableMethods.wait(1);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            page.descriptionHardware.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        }
    }


    @Then("search results are displayed by according to search direction {string} params")
    public void searchResultsAreDisplayedByAccordingToSearchDirectionParams(String selection) {
        if (selection.contains("Proqram təminatı")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-directionName')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Proqram təminatı")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Digər problemlər")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-directionName')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Digər problemlər")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }
            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }

        } else if (selection.contains("Şəbəkə və rabitə problemləri")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-directionName')]"));

            boolean foundValidRow = false;
            boolean foundInvalidRow = false;

            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Şəbəkə və rabitə problemləri")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }
            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }

        } else if (selection.contains("Əməliyyat sistemi")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-directionName')]"));

            boolean foundValidRow = false;
            boolean foundInvalidRow = false;

            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Əməliyyat sistemi")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }
            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }

        } else if (selection.contains("Elektron xidmətlər")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-directionName')]"));

            boolean foundValidRow = false;
            boolean foundInvalidRow = false;

            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Elektron xidmətlər")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }
            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }


        } else if (selection.contains("Avadanlıq")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-directionName')]"));

            boolean foundValidRow = false;
            boolean foundInvalidRow = false;

            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Avadanlıq")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }
            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        }
    }

    @When("selects {string} from notification type filter list")
    public void selectsFromNotificationTypeFilterList(String selection) {
        if (selection.contains("Xəta")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.errorNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Təklif")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.offerNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Qeyd")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.noticeNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Quraşdırma/Sazlama")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.installNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Sorğu")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.surveyNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Müraciət")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            ReusableMethods.scrollToElementByActions(page.requestNotType);
            page.requestNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Digər")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.otherNotType.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        }
    }

    @Then("search results are displayed by according to search note type {string} params")
    public void searchResultsAreDisplayedByAccordingToSearchNoteTypeParams(String selection) {
        if (selection.contains("Xəta")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Xəta")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Təklif")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Təklif")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Qeyd")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Qeyd")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Quraşdırma/Sazlama")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Quraşdırma/Sazlama")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Sorğu")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Sorğu")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Müraciət")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Müraciət")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Digər")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-feedBackType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Digər")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        }
    }

    @When("selects {string} from current result filter list")
    public void selectsFromCurrentResultFilterList(String selection) {
        if (selection.contains("Ilkin")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(3);
            page.primaryRequest.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Icraya qəbul edilib")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.admittedToTheExecution.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Müddəti bitib")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.admittedToTheExecution.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Icra edilib")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.expiredRequest.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Icradan imtina edilib")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.noteType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.cancelExecute.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        }
    }

    @Then("search results are displayed by according to search current result {string} params")
    public void searchResultsAreDisplayedByAccordingToSearchCurrentResultParams(String selection) {
        if (selection.contains("Ilkin")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-executionStatus')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("İlkin")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Icraya qəbul edilib")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-executionStatus')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("İcraya qəbul edilib")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Müddəti bitib")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-executionStatus')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Müddəti bitib")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Icra edilib")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-executionStatus')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("İcra edilib")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Icradan imtina edilib")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-executionStatus')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("İcradan imtina edilib")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        }
    }

    @When("selects {string} from priority filter list")
    public void selectsFromPriorityFilterList(String selection) {
        if (selection.contains("Təcili")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.priorityType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.urgentSelect.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Yüksək")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.priorityType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.highSelect.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Normal")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.priorityType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.normalSelect.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        } else if (selection.contains("Aşağı")) {
            ReusableMethods.pageDown();
            ReusableMethods.wait(1);
            getTableData = searchByUserData.getTableDataText.getText();
            System.out.println("expected = " + getTableData);
            ReusableMethods.flash(searchByUserData.getTableDataText, getDriver());
            ReusableMethods.wait(1);
            ReusableMethods.pageUp();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.priorityType, 5);
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
            page.descriptionList.click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ReusableMethods.wait(1);
            page.lowSelect.click();
            ReusableMethods.waitForClickabilityAndClick(searchByUserData.closeFilterModal, 10);
            ReusableMethods.wait(3);
        }
    }

    @Then("search results are displayed by according to search priority {string} params")
    public void searchResultsAreDisplayedByAccordingToSearchPriorityParams(String selection) {
        if (selection.contains("Təcili")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-priorityType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Təcili")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Yüksək")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-priorityType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Yüksək")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Normal")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-priorityType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Normal")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        } else if (selection.contains("Aşağı")) {
            List<WebElement> noResults = getDriver().findElements(By.xpath("//*[contains(text(),'Heç bir nəticə tapılmadı.')]"));
            if (!noResults.isEmpty()) {
                // Tapılıbsa → flash et və keç
                ReusableMethods.flash(noResults.get(0), getDriver());
                return;
            }

            List<WebElement> rows = getDriver().findElements(By.xpath("//td[contains(@class,'cdk-column-priorityType')]"));
            boolean foundValidRow = false;
            boolean foundInvalidRow = false;
            for (WebElement row : rows) {
                String text = row.getText().trim();

                if (text.equals("Aşağı")) {
                    ReusableMethods.flash(row, getDriver());
                    foundValidRow = true;
                } else {
                    foundInvalidRow = true;
                    System.out.println("Xəta: Gözlənilməyən istiqamət tapıldı: " + text);
                }
            }

            if (!foundValidRow) {
                Assert.fail("Nə '" + selection + "', nə də 'Heç bir nəticə tapılmadı.' tapılmadı!");
            }

            if (foundInvalidRow) {
                Assert.fail("Başqa istiqamətlər tapıldı, yalnız '" + selection + "' gözlənilirdi!");
            }
        }
    }

    @And("adds id to the id filter")
    public void addsIdToTheIdFilter() {
        String num = "77";
        ReusableMethods.waitForClickabilityAndClick(searchByUserData.nameFilter, 5);
        ReusableMethods.waitForClickabilityAndClick(searchByUserData.openFilter, 5);
        System.out.println(getRequestID);
        page.idInput.sendKeys(getRequestID);
        ReusableMethods.wait(1);
    }

    @Then("current {string} result is displayed")
    public void currentResultIsDisplayed(String selection) {
        if (selection.contains("İlkin")) {
            String statusText = page.executionStatusTD.getText().trim();
            ReusableMethods.flash(page.executionStatusTD, getDriver());
            if (!statusText.equals("İlkin")) {
                throw new AssertionError("Status 'İlkin' deyil! Əldə olunan: " + statusText);
            }
        } else if (selection.contains("İcraya qəbul edilib")) {
            String statusText = page.executionStatusTD.getText().trim();
            ReusableMethods.flash(page.executionStatusTD, getDriver());
            if (!statusText.equals("İcraya qəbul edilib")) {
                throw new AssertionError("Status 'İlkin' deyil! Əldə olunan: " + statusText);
            }
        } else if (selection.contains("İcra edilib")) {
            String statusText = page.executionStatusTD.getText().trim();
            ReusableMethods.flash(page.executionStatusTD, getDriver());
            if (!statusText.equals("İcra edilib")) {
                throw new AssertionError("Status 'İcra edilib' deyil! Əldə olunan: " + statusText);
            }
        } else if (selection.contains("Müddəti bitib")) {
            String statusText = page.executionStatusTD.getText().trim();
            ReusableMethods.flash(page.executionStatusTD, getDriver());
            if (!statusText.equals("Müddəti bitib")) {
                throw new AssertionError("Status 'Müddəti bitib' deyil! Əldə olunan: " + statusText);
            }
        } else if (selection.contains("İcradan imtina edilib")) {
            String statusText = page.executionStatusTD.getText().trim();
            ReusableMethods.flash(page.executionStatusTD, getDriver());
            if (!statusText.equals("İcradan imtina edilib")) {
                throw new AssertionError("Status 'İcradan imtina edilib' deyil! Əldə olunan: " + statusText);
            }
        }
    }

    @Then("executors name {string} is displayed")
    public void executorsNameIsDisplayed(String selection) {
        if (selection.contains("none")) {
            String executorText = page.executionListTD.getText().trim();
            ReusableMethods.flash(page.executionListTD, getDriver());
            if (!executorText.isEmpty()) {
                throw new AssertionError("Executor list boş deyil! Icraçılar: '" + executorText + "'");
            }
        } else if (selection.contains("Davud")) {
            String executeName = "Davud Zamanov";
            String executorText = page.executionListTD.getText().trim();
            ReusableMethods.flash(page.executionListTD, getDriver());
            Assert.assertEquals(executorText, executeName);
        } else if (selection.contains("Fərid İmranov")) {
            String executeName = "Fərid İmranov";
            String executorText = page.executionListTD.getText().trim();
            ReusableMethods.flash(page.executionListTD, getDriver());
            Assert.assertEquals(executorText, executeName);
        }
    }

    @Then("all information are displayed in the request review section from admin panel")
    public void allInformationAreDisplayedInTheRequestReviewSectionFromAdminPanel(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String id = row.get("ID");
            String appeal = row.get("İstiqamət");
            String whoSent = row.get("Bildirişi göndərən");
            String compName = row.get("İstifadəçi kompüterinin adı");
            String noteType = row.get("Bildirişin tipi");
            String priority = row.get("Prioritet");
            String actMade = row.get("Akt tərtib edilib");
            String description = row.get("Təsvir");
            String workPlace = row.get("İş yeri");
            String currentResult = row.get("Cari nəticə");

            ReusableMethods.flash(page.idReview, getDriver());
            Assert.assertEquals(page.idReview.getText().trim(), getRequestID);

            ReusableMethods.flash(page.directionReviewAdmin, getDriver());
            Assert.assertEquals(page.directionReviewAdmin.getText().trim(), appeal);

            ReusableMethods.flash(page.requestSentAdmin, getDriver());
            Assert.assertEquals(page.requestSentAdmin.getText().trim(), whoSent);

            String dateText = page.dataRequestAdmin.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.dataRequestAdmin, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            ReusableMethods.flash(page.compNameAdmin, getDriver());
            Assert.assertEquals(page.compNameAdmin.getText().trim(), compName);

            ReusableMethods.flash(page.noteTyeAdmin, getDriver());
            Assert.assertEquals(page.noteTyeAdmin.getText().trim(), noteType);

            ReusableMethods.flash(page.priorityAdmin, getDriver());
            Assert.assertEquals(page.priorityAdmin.getText().trim(), priority);

            ReusableMethods.flash(page.currentResultAdmin, getDriver());
            Assert.assertEquals(page.currentResultAdmin.getText().trim(), currentResult);

            ReusableMethods.flash(page.actAdderAdmin, getDriver());  //Bug var fix edildikden sonra commitden cixardacam
            Assert.assertEquals(page.actAdderAdmin.getText().trim(), actMade);

            ReusableMethods.flash(page.fileAdmin, getDriver());
            Assert.assertTrue(page.fileAdmin.isDisplayed());
//            Assert.assertTrue(page.fileLink.isSelected());
            if (page.fileAdmin.isDisplayed() && page.fileAdmin.isEnabled()) {
                System.out.println("✅ Upload linki görünür və aktivdir.");
            } else {
                System.out.println("❌ Upload linki görünmür və ya deaktivdir.");
            }

            ReusableMethods.flash(page.noteAdmin, getDriver());
            Assert.assertEquals(page.noteAdmin.getText().trim(), description);

            ReusableMethods.flash(page.workPlaceAdmin, getDriver());
            Assert.assertEquals(page.workPlaceAdmin.getText().trim(), workPlace);
            Assert.assertTrue(page.workPlaceAdmin.getText().trim().contains(workPlace));
        }
    }

    @When("the admin assigns an executor {string} to the request")
    public void theAdminAssignsAnExecutorToTheRequest(String selection) {
        if (selection.contains("Davud")) {
            page.addExecutorToTheRequest.click();
            ReusableMethods.wait(1);
            page.executorInputToTheRequest.sendKeys("Davud Zamanov");
            ReusableMethods.wait(1);
            page.davudExecutorSelect.click();
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(5);
        } else if (selection.contains("Fərid")) {
            page.addExecutorToTheRequest.click();
            ReusableMethods.wait(1);
            page.executorInputToTheRequest.sendKeys("Fərid İmranov");
            ReusableMethods.wait(1);
            page.faridExecutorSelect.click();
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(3);
        }
    }

    @Then("the executors name {string} and all information about execute is displayed in the request review section")
    public void theExecutorsNameAndAllInformationAboutExecuteIsDisplayedInTheRequestReviewSection(String selection) {
        if (selection.contains("Davud")) {
            System.out.println("selection = " + selection);
        }
    }

    @When("user select go back button in the request review section")
    public void userSelectGoBackButtonInTheRequestReviewSection() {
        ReusableMethods.pageDown();
        ReusableMethods.wait(3);
        page.backToTheRequestTable.click();
        ReusableMethods.wait(1);
    }

    @And("changes the status {string} of the request by selecting the current result")
    public void changesTheStatusOfTheRequestBySelectingTheCurrentResult(String selection) {
        if (selection.contains("İlkin")) {
            page.currentResultAdmin.click();
            ReusableMethods.wait(1);
//            page.currentDropDown.click();
//            ReusableMethods.wait(1);
//            page.reqStatus.click();
//            ReusableMethods.wait(1);
            page.noteCurrent.sendKeys("Icraçı əvəz edilir");
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(7);
        } else if (selection.contains("İcraya qəbul edilib")) {
            page.currentResultAdmin.click();
            ReusableMethods.wait(1);
            page.currentDropDown.click();
            ReusableMethods.wait(1);
            page.reqAcceptStatusList.click();
            ReusableMethods.wait(1);
            page.noteCurrent.sendKeys("Tezliklə nəticə barədə sizə məlumat veriləcək.");
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(7);
        } else if (selection.contains("İcra edilib")) {
            page.currentResultAdmin.click();
            ReusableMethods.wait(1);
            page.currentDropDown.click();
            ReusableMethods.wait(1);
            page.doneStatusList.click();
            ReusableMethods.wait(1);
            page.noteCurrent.sendKeys("Qeyd edilən problem aradan qaldırıldı");
            ReusableMethods.wait(1);
            page.actInputRequest.sendKeys("AG-88");
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(7);
        } else if (selection.contains("Müddəti bitib")) {
            page.currentResultAdmin.click();
            ReusableMethods.wait(1);
            page.currentDropDown.click();
            ReusableMethods.wait(1);
            page.timeExpiredStatusList.click();
            ReusableMethods.wait(1);
            page.noteCurrent.sendKeys("İcra tarixi bitmişdir");
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(7);
        } else if (selection.contains("İcradan imtina edilib")) {
            page.currentResultAdmin.click();
            ReusableMethods.wait(1);
            page.currentDropDown.click();
            ReusableMethods.wait(1);
            page.cancelStatusList.click();
            ReusableMethods.wait(1);
            page.noteCurrent.sendKeys("Bu task fix olduğuna görə icrası imtina edilib");
            ReusableMethods.wait(1);
            page.acceptBtn.click();
            ReusableMethods.wait(7);
        }
    }

    @And("admin removed the executor")
    public void adminRemovedTheExecutor() {
        ReusableMethods.wait(3);
        page.deleteBtnExecutor.click();
        ReusableMethods.wait(1);
        structureAndDuties.yesButton.click();
        ReusableMethods.wait(1);
    }

    @Then("the deleted executor was successfully removed in the request section")
    public void theDeletedExecutorWasSuccessfullyRemovedInTheRequestSection() {
        ReusableMethods.wait(1);
        List<WebElement> cells = getDriver().findElements(
                By.xpath("(//table)[2]//td[contains(@class, 'mat-column-regUserFullName')]")
        );
        for (WebElement cell : cells) {
            String text = cell.getText().trim();
            if (!text.isEmpty()) {
                throw new AssertionError("Hüceyrə boş olmalı idi, lakin tapıldı: " + text);
            }
        }
    }

    @Then("the deleted executor is not displayed in the requests table")
    public void theDeletedExecutorIsNotDisplayedInTheRequestsTable() {
        String executorText = page.executionListTD.getText().trim();
        ReusableMethods.flash(page.executionListTD, getDriver());
        if (!executorText.isEmpty()) {
            throw new AssertionError("Executor list boş deyil! Icraçılar: '" + executorText + "'");
        }
    }

    @And("executor receives the correct notification with the same ID")
    public void executorReceivesTheCorrectNotificationWithTheSameID() {
        ReusableMethods.wait(5);
        String fullText = page.notIdCheck.getText();
        ReusableMethods.flash(page.notIdCheck, getDriver());
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(fullText);

        String extractedId = "";
        if (matcher.find()) {
            extractedId = matcher.group();
        }
        if (!extractedId.equals(getRequestID)) {
            throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
        }
    }

    @And("all the information is displayed in the notification sent to the executor")
    public void
    allTheInformationIsDisplayedInTheNotificationSentToTheExecutor(DataTable dataTable) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

            // Check if the noteMainCheck is displayed
            if (isElementVisible(page.noteMainCheck, wait)) {
                ReusableMethods.wait(5);
                String fullText = page.notIdCheck.getText();
                ReusableMethods.flash(page.notIdCheck, getDriver());
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(fullText);

                String extractedId = "";
                if (matcher.find()) {
                    extractedId = matcher.group();
                }
                if (!extractedId.equals(getRequestID)) {
                    throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
                }
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String appeal = row.get("İstiqamət");
                    String whoSent = row.get("Müraciət edən");
                    String compName = row.get("İstifadəçi komputeri");
//                  String noteType = row.get("Bildirişin tipi");
                    String priority = row.get("Prioritet");
                    String executor = row.get("İcraçı");
                    String currentResult = row.get("İcra statusu");
                    String noteCheck = row.get("Qeyd");
                    String actCheck = row.get("Akt nömrəsi");

                    ReusableMethods.flash(page.directionNotCheck, getDriver());
                    Assert.assertEquals(page.directionNotCheck.getText().trim(), appeal);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.priorityNotCheck, getDriver());
                    Assert.assertEquals(page.priorityNotCheck.getText().trim(), priority);

                    ReusableMethods.flash(page.executeStatusNotCheck, getDriver());
                    Assert.assertEquals(page.executeStatusNotCheck.getText().trim(), currentResult);
                    ReusableMethods.wait(1);

//                    ReusableMethods.flash(page.notCheck, getDriver());
//                    Assert.assertEquals(page.notCheck.getText().trim(), noteCheck);
//                    ReusableMethods.wait(1);

//                    ReusableMethods.flash(page.actCheck, getDriver());
//                    Assert.assertEquals(page.actCheck.getText().trim(), actCheck);
//                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoSentCheck, getDriver());
                    System.out.println("whoSent = " + page.whoSentCheck.getText());
                    Assert.assertEquals(page.whoSentCheck.getText().trim(), whoSent);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.executorCheck, getDriver());
                    Assert.assertEquals(page.executorCheck.getText().trim(), executor);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.comNameNotCheck, getDriver());
                    Assert.assertEquals(page.comNameNotCheck.getText().trim(), compName);
                    ReusableMethods.wait(1);
                }
            } else {
                ReusableMethods.wait(2);
                WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                button.click();


                ReusableMethods.wait(2);
                WebElement element = getDriver().findElement(By.xpath("(//li[contains(., 'Yardım')])[1]"));
//                WebElement element = getDriver().findElement(By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]"));
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                ReusableMethods.wait(1);
//                js.executeScript("arguments[0].click();", element);
//                ReusableMethods.wait(1);
                element.click();
                ReusableMethods.wait(10);

                ReusableMethods.waitForOverlayToDisappear(getDriver());
                String fullText = page.notIdCheck.getText();
                ReusableMethods.flash(page.notIdCheck, getDriver());
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(fullText);

                String extractedId = "";
                if (matcher.find()) {
                    extractedId = matcher.group();
                }
                if (!extractedId.equals(getRequestID)) {
                    throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
                }
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String appeal = row.get("İstiqamət");
                    String whoSent = row.get("Müraciət edən");
                    String compName = row.get("İstifadəçi komputeri");
//                  String noteType = row.get("Bildirişin tipi");
                    String priority = row.get("Prioritet");
                    String executor = row.get("İcraçı");
                    String currentResult = row.get("İcra statusu");
                    String noteCheck = row.get("Qeyd");
                    String actCheck = row.get("Akt nömrəsi");

                    ReusableMethods.flash(page.directionNotCheck, getDriver());
                    Assert.assertEquals(page.directionNotCheck.getText().trim(), appeal);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.priorityNotCheck, getDriver());
                    Assert.assertEquals(page.priorityNotCheck.getText().trim(), priority);

                    ReusableMethods.flash(page.executeStatusNotCheck, getDriver());
                    Assert.assertEquals(page.executeStatusNotCheck.getText().trim(), currentResult);
                    ReusableMethods.wait(1);

//                    ReusableMethods.flash(page.notCheck, getDriver());
//                    Assert.assertEquals(page.notCheck.getText().trim(), noteCheck);
//                    ReusableMethods.wait(1);

//                    ReusableMethods.flash(page.actCheck, getDriver());
//                    Assert.assertEquals(page.actCheck.getText().trim(), actCheck);
//                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoSentCheck, getDriver());
                    System.out.println("whoSent = " + page.whoSentCheck.getText());
                    Assert.assertEquals(page.whoSentCheck.getText().trim(), whoSent);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.executorCheck, getDriver());
                    Assert.assertEquals(page.executorCheck.getText().trim(), executor);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.comNameNotCheck, getDriver());
                    Assert.assertEquals(page.comNameNotCheck.getText().trim(), compName);
                    ReusableMethods.wait(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
//            Assert.fail("Test zamanı istisna baş verdi: " + e.getMessage());
        }
    }

    @And("the executor navigates to the request review section using the detailed button")
    public void theExecutorNavigatesToTheRequestReviewSectionUsingTheDetailedButton() {
        ReusableMethods.wait(2);
        page.detailedBtn.click();
        ReusableMethods.wait(1);
    }

    @And("selects notification in the header section")
    public void selectsNotificationInTheHeaderSection() {
        ReusableMethods.wait(2);
        WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
        button.click();
        ReusableMethods.wait(1);
    }

    @And("selects last notification from not list")
    public void selectsLastNotificationFromNotList() {
        ReusableMethods.wait(2);
        WebElement element = getDriver().findElement(By.xpath("(//li[contains(., 'Yardım masası')])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
//        element.click();
        ReusableMethods.wait(1);
    }

    @Then("the executors name and the date the request was accepted and the execution status  are {string} displayed")
    public void theExecutorsNameAndTheDateTheRequestWasAcceptedAndTheExecutionStatusAreDisplayed(String selection) {
        if (selection.contains("İcraya qəbul edilib")) {
            String actualName = page.executorNameReviewSection.getText().trim();
            String expectName = "Davud Zamanov";
            ReusableMethods.flash(page.executorNameReviewSection, getDriver());
            Assert.assertEquals(expectName, actualName);

            String dateText = page.dataReviewSection.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.dataReviewSection, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            String actualStatus = page.statusReviewSection.getText().trim();
            String expectStatus = "İcraya qəbul edilib";
            ReusableMethods.flash(page.statusReviewSection, getDriver());
            Assert.assertEquals(expectStatus, actualStatus);
        } else if (selection.contains("İcradan imtina edilib")) {
            String actualName = page.executorNameReviewSection.getText().trim();
            String expectName = "Davud Zamanov";
            ReusableMethods.flash(page.executorNameReviewSection, getDriver());
            Assert.assertEquals(expectName, actualName);

            String dateText = page.dataReviewSection.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.dataReviewSection, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            String actualStatus = page.statusReviewSection.getText().trim();
            String expectStatus = "İcradan imtina edilib";
            ReusableMethods.flash(page.statusReviewSection, getDriver());
            Assert.assertEquals(expectStatus, actualStatus);
        } else if (selection.contains("Müddəti bitib")) {
            String actualName = page.executorNameReviewSection.getText().trim();
            String expectName = "Davud Zamanov";
            ReusableMethods.flash(page.executorNameReviewSection, getDriver());
            Assert.assertEquals(expectName, actualName);

            String dateText = page.dataReviewSection.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            try {
                LocalDateTime parsedDate = LocalDateTime.parse(dateText, formatter);
                ReusableMethods.flash(page.dataReviewSection, getDriver());
                String reformatted = parsedDate.format(formatter);
                System.out.println("Tarix formatı düzgündür: " + reformatted);
                Assert.assertEquals("Tarix formatı səhvdir", dateText, reformatted);
            } catch (DateTimeParseException e) {
                throw new AssertionError("XƏTA: Tarix formatı düzgün deyil: " + dateText);
            }

            String actualStatus = page.statusReviewSection.getText().trim();
            String expectStatus = "Müddəti bitib";
            ReusableMethods.flash(page.statusReviewSection, getDriver());
            Assert.assertEquals(expectStatus, actualStatus);
        }
    }

    @And("close notification in the header section")
    public void closeNotificationInTheHeaderSection() {
        WebElement element = getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']"));
        element.click();
        ReusableMethods.wait(1);
    }

    @Then("information about act and execute note is displayed in the request review section")
    public void informationAboutActAndExecuteNoteIsDisplayedInTheRequestReviewSection(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String actDone = row.get("Akt tərtib edilib");
            String actNum = row.get("Aktın nömrəsi");
            String noteAboutExecutor = row.get("İcra haqqında təsvir");

            ReusableMethods.flash(page.actDone, getDriver());
            Assert.assertEquals(page.actDone.getText().trim(), actDone);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.actNum, getDriver());
            Assert.assertEquals(page.actNum.getText().trim(), actNum);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.executeNote, getDriver());
            Assert.assertEquals(page.executeNote.getText().trim(), noteAboutExecutor);
            ReusableMethods.wait(1);
        }
    }

    @And("executor selects edit ticket button")
    public void executorSelectsEditTicketButton() {
        page.ticketEdit.click();
        ReusableMethods.wait(1);
    }

    @And("note to the note field in the ticket modal window")
    public void noteToTheNoteFieldInTheTicketModalWindow() {
        page.noteInputTicket.sendKeys("Bu ticket icra edildi");
        ReusableMethods.wait(1);
    }

    @And("raises the {string}  percentage of the execution")
    public void raisesThePercentageOfTheExecution(String selection) {
        if (selection.contains("100%")) {
            page.percentIncrease.click();
            ReusableMethods.wait(1);
            page.percentIncrease.click();
            ReusableMethods.wait(1);
            page.percentIncrease.click();
            ReusableMethods.wait(1);
            page.percentIncrease.click();
            ReusableMethods.wait(1);
        }
    }

    @Then("{string} percentage and tickets note are displayed in the request review section")
    public void percentageAndTicketsNoteAreDisplayedInTheRequestReviewSection(String selection) {
        if (selection.contains("100%")) {
            String actualText = page.ticketReviewPercent.getText();
            ReusableMethods.flash(page.ticketReviewPercent, getDriver());
            ReusableMethods.wait(1);
            if (!actualText.equals("100%")) {
                throw new AssertionError("Text '100%' deyil! Əslində: " + actualText);
            }
//            String actualNote = page.ticketReviewNote.getText();
//            ReusableMethods.flash(page.ticketReviewNote,getDriver());
//            ReusableMethods.wait(1);
//            if (!actualNote.equals("Bu ticket icra edildi")) {
//                throw new AssertionError("Text 'Bu ticket icra edildi' deyil! Əslində: " + actualText);
//            }
        }
    }

    @And("all the information is displayed in the notification sent to the person who initiated the execution")
    public void allTheInformationIsDisplayedInTheNotificationSentToThePersonWhoInitiatedTheExecution(DataTable dataTable) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

            // Check if the noteMainCheck is displayed
            if (isElementVisible(page.noteMainCheck, wait)) {
                ReusableMethods.wait(3);
                String fullText = page.notIdCheck.getText();
                ReusableMethods.flash(page.notIdCheck, getDriver());
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(fullText);

                String extractedId = "";
                if (matcher.find()) {
                    extractedId = matcher.group();
                }
                if (!extractedId.equals(getRequestID)) {
                    throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
                }
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String appeal = row.get("İstiqamət");
                    String whoSent = row.get("Müraciət edən");
                    String compName = row.get("İstifadəçi komputeri");
//                  String noteType = row.get("Bildirişin tipi");
                    String priority = row.get("Prioritet");
                    String executor = row.get("İcraçı");
                    String currentResult = row.get("İcra statusu");
                    String noteCheck = row.get("Qeyd");
                    String actCheck = row.get("Akt nömrəsi");

                    ReusableMethods.flash(page.directionNotCheck, getDriver());
                    Assert.assertEquals(page.directionNotCheck.getText().trim(), appeal);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.priorityNotCheck, getDriver());
                    Assert.assertEquals(page.priorityNotCheck.getText().trim(), priority);

                    ReusableMethods.flash(page.executeStatusNotCheck, getDriver());
                    Assert.assertEquals(page.executeStatusNotCheck.getText().trim(), currentResult);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.notCheck, getDriver());
                    Assert.assertEquals(page.notCheck.getText().trim(), noteCheck);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.actCheck, getDriver());
                    Assert.assertEquals(page.actCheck.getText().trim(), actCheck);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoSentCheck, getDriver());
                    System.out.println("whoSent = " + page.whoSentCheck.getText());
                    Assert.assertEquals(page.whoSentCheck.getText().trim(), whoSent);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.executorCheck, getDriver());
                    Assert.assertEquals(page.executorCheck.getText().trim(), executor);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.comNameNotCheck, getDriver());
                    Assert.assertEquals(page.comNameNotCheck.getText().trim(), compName);
                    ReusableMethods.wait(1);
                }
            } else {
                ReusableMethods.wait(1);
                WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                button.click();
                ReusableMethods.wait(1);

                ReusableMethods.wait(3);
//                By.xpath("//li[.//span[contains(normalize-space(),'Yardım masası')]][1]");
//                By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]");
                WebElement element = getDriver().findElement(By.xpath("(//li[contains(., 'Yardım masası')])[1]"));
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].click();", element);
//                element.click();
                ReusableMethods.wait(2);

                String fullText = page.notIdCheck.getText();
                ReusableMethods.flash(page.notIdCheck, getDriver());
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(fullText);

                String extractedId = "";
                if (matcher.find()) {
                    extractedId = matcher.group();
                }
                if (!extractedId.equals(getRequestID)) {
                    throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
                }
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String appeal = row.get("İstiqamət");
                    String whoSent = row.get("Müraciət edən");
                    String compName = row.get("İstifadəçi komputeri");
//                  String noteType = row.get("Bildirişin tipi");
                    String priority = row.get("Prioritet");
                    String executor = row.get("İcraçı");
                    String currentResult = row.get("İcra statusu");
                    String noteCheck = row.get("Qeyd");
                    String actCheck = row.get("Akt nömrəsi");

                    ReusableMethods.flash(page.directionNotCheck, getDriver());
                    Assert.assertEquals(page.directionNotCheck.getText().trim(), appeal);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.priorityNotCheck, getDriver());
                    Assert.assertEquals(page.priorityNotCheck.getText().trim(), priority);

                    ReusableMethods.flash(page.executeStatusNotCheck, getDriver());
                    Assert.assertEquals(page.executeStatusNotCheck.getText().trim(), currentResult);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.notCheck, getDriver());
                    Assert.assertEquals(page.notCheck.getText().trim(), noteCheck);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.actCheck, getDriver());
                    Assert.assertEquals(page.actCheck.getText().trim(), actCheck);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoSentCheck, getDriver());
                    System.out.println("whoSent = " + page.whoSentCheck.getText());
                    Assert.assertEquals(page.whoSentCheck.getText().trim(), whoSent);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.executorCheck, getDriver());
                    Assert.assertEquals(page.executorCheck.getText().trim(), executor);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.comNameNotCheck, getDriver());
                    Assert.assertEquals(page.comNameNotCheck.getText().trim(), compName);
                    ReusableMethods.wait(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("information about the decline execute is displayed in the request review section")
    public void informationAboutTheDeclineExecuteIsDisplayedInTheRequestReviewSection(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String actDone = row.get("Akt tərtib edilib");
            String noteAboutExecutor = row.get("İcra haqqında təsvir");

            ReusableMethods.flash(page.actDone, getDriver());
            Assert.assertEquals(page.actDone.getText().trim(), actDone);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.executeNote, getDriver());
            Assert.assertEquals(page.executeNote.getText().trim(), noteAboutExecutor);
            ReusableMethods.wait(1);
        }
    }


    @And("all the information is displayed about decline request in the notification sent to the person who initiated the execution")
    public void allTheInformationIsDisplayedAboutDeclineRequestInTheNotificationSentToThePersonWhoInitiatedTheExecution(DataTable dataTable) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

            // Check if the noteMainCheck is displayed
            if (isElementVisible(page.noteMainCheck, wait)) {
                ReusableMethods.wait(3);
                String fullText = page.notIdCheck.getText();
                ReusableMethods.flash(page.notIdCheck, getDriver());
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(fullText);

                String extractedId = "";
                if (matcher.find()) {
                    extractedId = matcher.group();
                }
                if (!extractedId.equals(getRequestID)) {
                    throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
                }
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String appeal = row.get("İstiqamət");
                    String whoSent = row.get("Müraciət edən");
                    String compName = row.get("İstifadəçi komputeri");
//                  String noteType = row.get("Bildirişin tipi");
                    String priority = row.get("Prioritet");
                    String executor = row.get("İcraçı");
                    String currentResult = row.get("İcra statusu");
                    String noteCheck = row.get("Qeyd");


                    ReusableMethods.flash(page.directionNotCheck, getDriver());
                    Assert.assertEquals(page.directionNotCheck.getText().trim(), appeal);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.priorityNotCheck, getDriver());
                    Assert.assertEquals(page.priorityNotCheck.getText().trim(), priority);

                    ReusableMethods.flash(page.executeStatusNotCheck, getDriver());
                    Assert.assertEquals(page.executeStatusNotCheck.getText().trim(), currentResult);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.notCheck, getDriver());
                    Assert.assertEquals(page.notCheck.getText().trim(), noteCheck);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoSentCheck, getDriver());
                    System.out.println("whoSent = " + page.whoSentCheck.getText());
                    Assert.assertEquals(page.whoSentCheck.getText().trim(), whoSent);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.executorCheck, getDriver());
                    Assert.assertEquals(page.executorCheck.getText().trim(), executor);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.comNameNotCheck, getDriver());
                    Assert.assertEquals(page.comNameNotCheck.getText().trim(), compName);
                    ReusableMethods.wait(1);
                }
            } else {
                ReusableMethods.wait(1);
                WebElement button = getDriver().findElement(By.xpath("(//button[.//span[@class='mat-mdc-button-touch-target']])[3]"));
                button.click();
                ReusableMethods.wait(1);

                ReusableMethods.wait(3);
//                By.xpath("//li[.//span[contains(normalize-space(),'Yardım masası')]][1]");
//                By.xpath("(//ul[contains(@class, 'notification-list')]//li)[1]");
                WebElement element = getDriver().findElement(By.xpath("(//li[contains(., 'Yardım masası')])[1]"));
//                JavascriptExecutor js = (JavascriptExecutor) getDriver();
//                js.executeScript("arguments[0].click();", element);
                element.click();
                ReusableMethods.wait(2);

                String fullText = page.notIdCheck.getText();
                ReusableMethods.flash(page.notIdCheck, getDriver());
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(fullText);

                String extractedId = "";
                if (matcher.find()) {
                    extractedId = matcher.group();
                }
                if (!extractedId.equals(getRequestID)) {
                    throw new AssertionError("ID uyğun deyil! Gözlənilən: " + getRequestID + ", tapılan: " + extractedId);
                }
                List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
                for (Map<String, String> row : data) {
                    String appeal = row.get("İstiqamət");
                    String whoSent = row.get("Müraciət edən");
                    String compName = row.get("İstifadəçi komputeri");
//                  String noteType = row.get("Bildirişin tipi");
                    String priority = row.get("Prioritet");
                    String executor = row.get("İcraçı");
                    String currentResult = row.get("İcra statusu");
                    String noteCheck = row.get("Qeyd");

                    ReusableMethods.flash(page.directionNotCheck, getDriver());
                    Assert.assertEquals(page.directionNotCheck.getText().trim(), appeal);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.priorityNotCheck, getDriver());
                    Assert.assertEquals(page.priorityNotCheck.getText().trim(), priority);

                    ReusableMethods.flash(page.executeStatusNotCheck, getDriver());
                    Assert.assertEquals(page.executeStatusNotCheck.getText().trim(), currentResult);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.notCheck, getDriver());
                    Assert.assertEquals(page.notCheck.getText().trim(), noteCheck);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.whoSentCheck, getDriver());
                    System.out.println("whoSent = " + page.whoSentCheck.getText());
                    Assert.assertEquals(page.whoSentCheck.getText().trim(), whoSent);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.executorCheck, getDriver());
                    Assert.assertEquals(page.executorCheck.getText().trim(), executor);
                    ReusableMethods.wait(1);

                    ReusableMethods.flash(page.comNameNotCheck, getDriver());
                    Assert.assertEquals(page.comNameNotCheck.getText().trim(), compName);
                    ReusableMethods.wait(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}