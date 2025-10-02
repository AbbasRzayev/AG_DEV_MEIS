package stepdefinitions;

import Page.legalBasis_Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class legelBasis_Steps {

    legalBasis_Page page = new legalBasis_Page();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));

    @And("goes to the legal basis tab from admin panel")
    public void goesToTheLegalBasisTabFromAdminPanel() {
        page.lagalBasis.click();
        ReusableMethods.wait(2);

    }

    @And("selects new document button for adding new document in the legal basis tab")
    public void selectsNewDocumentButtonForAddingNewDocumentInTheLegalBasisTab() {
        page.plusBtnNewDocument.click();
        ReusableMethods.wait(1);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @And("adds {string} name in the legal basis tab")
    public void addsNameInTheLegalBasisTab(String status) {
        if (status.contains("new")) {
            page.nameForFirstDocument.sendKeys("New Data");
            ReusableMethods.wait(1);
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } else if (status.contains("Document according to addressees")) {
            page.nameForFirstDocument.sendKeys(status);
            ReusableMethods.wait(1);
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } else if (status.contains("Document according to structure")) {
            page.nameForFirstDocument.sendKeys(status);
            ReusableMethods.wait(1);
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
    }

    @And("adds {string} number to the number field")
    public void addsNumberToTheNumberField(String number) {
        if (number.contains("7788")) {
            page.numberField.sendKeys("7788");
            ReusableMethods.wait(1);
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }

    }

    @And("adds state registration {string} number")
    public void addsStateRegistrationNumber(String number) {
        if (number.contains("AG-88")) {
            page.stateNumber.sendKeys("AG-88");
            ReusableMethods.wait(1);
        }
    }

    @And("selects type {string} of document")
    public void selectsTypeOfDocument(String type) {
        if (type.contains("Əsasnamə")) {
            page.docTypeBtn.click();
            ReusableMethods.wait(1);
            page.docType.click();
        }
    }

    @And("adds the {string} receiving authority")
    public void addsTheReceivingAuthority(String text) {
        if (text.contains("new")) {
            page.acceptedOrgan.sendKeys("IT Product");
            ReusableMethods.wait(1);
        }

    }

    String formattedDate;

    LocalDate expirationDate;
    LocalDate admissionDate;

    @And("adds effective date")
    public void addsEffectiveDate() {
        LocalDate effectiveDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formattedDate = effectiveDate.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.effectiveDate.sendKeys(formattedDate);
        ReusableMethods.wait(1);

    }

    @And("adds expiration date")
    public void addsExpirationDate() {
        expirationDate = LocalDate.now().plusDays(50);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = expirationDate.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.expirationDate.sendKeys(formattedDate);
        ReusableMethods.wait(1);
    }

    @And("adds date of admission")
    public void addsDateOfAdmission() {
        admissionDate = LocalDate.now().plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = admissionDate.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.admissonDate.sendKeys(formattedDate);
        ReusableMethods.wait(1);
    }


    @And("adds {string} status of document")
    public void addsStatusOfDocument(String text) {
        if (text.contains("new")) {
            page.status.click();
            ReusableMethods.wait(1);
            page.statusSelect.click();
            ReusableMethods.wait(1);
        }
    }

    @And("adds link to the link field")
    public void addsLinkToTheLinkField() {
        page.linkField.sendKeys("https://aist.group/");
        ReusableMethods.wait(1);
    }

    @And("adds file for document")
    public void addsFileForDocument() {
        String path = "C:\\Users\\User\\TestFiles\\AutomationTest.pdf";
        page.addFile.click();
        ReusableMethods.wait(1);
        ReusableMethods.robotClassDosyaYukleme(path);
    }

    @And("selects {string} for document")
    public void selectsForDocument(String docStatus) {
        if (docStatus.contains("Ümumi açıq")) {
            System.out.println("docStatus: = " + docStatus);
        } else if (docStatus.contains("Ünvanlanmış şəxslərə görə")) {
            page.statusList.click();
            page.statusByPerson.click();
            page.personList.sendKeys("Musa");
            ReusableMethods.wait(1);
            page.selectMusa.click();
            ReusableMethods.wait(1);
        } else if (docStatus.contains("Struktur bölmə daxilində")) {
            page.statusList.click();
            page.statusByStructure.click();
            page.statusByStructureList.click();
            page.statusByStructureSelect.click();
            page.acceptStructure.click();
            ReusableMethods.wait(1);
        }
    }

    @And("selects save button")
    public void selectsSaveButton() {
        page.yestBtn.click();
        ReusableMethods.wait(2);
        ReusableMethods.pageDown();
    }

    @When("goes to the congratulations tab from sidebar")
    public void goesToTheCongratulationsTabFromSidebar() {
        page.legalBasisSIdeBar.click();
        ReusableMethods.wait(2);
    }

    @Then("new {string} is successfully added")
    public void newIsSuccessfullyAdded(String newDocument) {
        if (newDocument.contains("Document for public open")) {
            ReusableMethods.pageDown();
            WebElement firstRow = page.tableFirstElement;
            WebElement titleCell1 = firstRow.findElement(By.xpath(".//td[contains(text(), 'Document for public open')]"));
            WebElement titleCell2 = firstRow.findElement(By.xpath("//td[contains(text(), '778899')]"));
            WebElement titleCell3 = firstRow.findElement(By.xpath("//td[contains(text(), 'Əsasnamə')]"));
            WebElement titleCell4 = firstRow.findElement(By.xpath("//td[contains(text(), 'IT Product')]"));
            WebElement titleCell5 = firstRow.findElement(By.xpath("//td[contains(text(), 'Qüvvədə olan')]"));

            WebElement titleCell6 = getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7 = getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8 = getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

            String actualEffective = titleCell6.getText();
            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("actual = " + actualEffective);
            Assert.assertEquals(formattedDate, actualEffective);
            System.out.println("formattedDate = " + formattedDate);

            String actualExpiration = titleCell7.getText();
            expirationDate = LocalDate.now().plusDays(50);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateExpration = expirationDate.format(formatter1);
            System.out.println("formattedDateExpration = " + formattedDateExpration);
            Assert.assertEquals(formattedDateExpration, actualExpiration);

            String actualAdmission = titleCell8.getText();
            admissionDate = LocalDate.now().plusDays(5);
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateAdmission = admissionDate.format(formatter3);
            System.out.println("formattedDateAdmission = " + formattedDateAdmission);
            Assert.assertEquals(formattedDateAdmission, actualAdmission);

            Assert.assertTrue("Text 'Document for public open' should be displayed", titleCell1.isDisplayed());
            Assert.assertTrue("Text '778899", titleCell2.isDisplayed());
            Assert.assertTrue("Text 'Əsasnamə", titleCell3.isDisplayed());
            Assert.assertTrue("Text 'IT Product", titleCell4.isDisplayed());
            Assert.assertTrue("Text 'Qüvvədə olan", titleCell5.isDisplayed());
            ReusableMethods.flash(page.tableFirstElement, getDriver());
            ReusableMethods.wait(1);
        } else if (newDocument.contains("Document according to addressees")) {
            ReusableMethods.pageDown();
            WebElement firstRow = page.tableFirstElement;
            WebElement titleCell1 = firstRow.findElement(By.xpath(".//td[contains(text(), 'Document according to addressees')]"));
            WebElement titleCell2 = firstRow.findElement(By.xpath("//td[contains(text(), '778899')]"));
            WebElement titleCell3 = firstRow.findElement(By.xpath("//td[contains(text(), 'Əsasnamə')]"));
            WebElement titleCell4 = firstRow.findElement(By.xpath("//td[contains(text(), 'IT Product')]"));
            WebElement titleCell5 = firstRow.findElement(By.xpath("//td[contains(text(), 'Qüvvədə olan')]"));
            WebElement titleCell6 = getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7 = getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8 = getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

            String actualEffective = titleCell6.getText();
            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("actual = " + actualEffective);
            Assert.assertEquals(formattedDate, actualEffective);
            System.out.println("formattedDate = " + formattedDate);

            String actualExpiration = titleCell7.getText();
            expirationDate = LocalDate.now().plusDays(50);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateExpration = expirationDate.format(formatter1);
            System.out.println("formattedDateExpration = " + formattedDateExpration);
            Assert.assertEquals(formattedDateExpration, actualExpiration);

            String actualAdmission = titleCell8.getText();
            admissionDate = LocalDate.now().plusDays(5);
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateAdmission = admissionDate.format(formatter3);
            System.out.println("formattedDateAdmission = " + formattedDateAdmission);
            Assert.assertEquals(formattedDateAdmission, actualAdmission);

            Assert.assertTrue("Text 'Document according to addressees' should be displayed", titleCell1.isDisplayed());
            Assert.assertTrue("Text '778899", titleCell2.isDisplayed());
            Assert.assertTrue("Text 'Əsasnamə", titleCell3.isDisplayed());
            Assert.assertTrue("Text 'IT Product", titleCell4.isDisplayed());
            Assert.assertTrue("Text 'Qüvvədə olan", titleCell5.isDisplayed());
            ReusableMethods.flash(page.tableFirstElement, getDriver());
            ReusableMethods.wait(1);
        } else if (newDocument.contains("Document according to structure")) {
            ReusableMethods.pageDown();
            WebElement firstRow = page.tableFirstElement;
            WebElement titleCell1 = firstRow.findElement(By.xpath(".//td[contains(text(), 'Document according to structure')]"));
            WebElement titleCell2 = firstRow.findElement(By.xpath("//td[contains(text(), '778899')]"));
            WebElement titleCell3 = firstRow.findElement(By.xpath("//td[contains(text(), 'Əsasnamə')]"));
            WebElement titleCell4 = firstRow.findElement(By.xpath("//td[contains(text(), 'IT Product')]"));
            WebElement titleCell5 = firstRow.findElement(By.xpath("//td[contains(text(), 'Qüvvədə olan')]"));
            WebElement titleCell6 = getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7 = getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8 = getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

            String actualEffective = titleCell6.getText();
            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("actual = " + actualEffective);
            Assert.assertEquals(formattedDate, actualEffective);
            System.out.println("formattedDate = " + formattedDate);

            String actualExpiration = titleCell7.getText();
            expirationDate = LocalDate.now().plusDays(50);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateExpration = expirationDate.format(formatter1);
            System.out.println("formattedDateExpration = " + formattedDateExpration);
            Assert.assertEquals(formattedDateExpration, actualExpiration);

            String actualAdmission = titleCell8.getText();
            admissionDate = LocalDate.now().plusDays(5);
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateAdmission = admissionDate.format(formatter3);
            System.out.println("formattedDateAdmission = " + formattedDateAdmission);
            Assert.assertEquals(formattedDateAdmission, actualAdmission);

            Assert.assertTrue("Text 'Document according to structure' should be displayed", titleCell1.isDisplayed());
            Assert.assertTrue("Text '778899", titleCell2.isDisplayed());
            Assert.assertTrue("Text 'Əsasnamə", titleCell3.isDisplayed());
            Assert.assertTrue("Text 'IT Product", titleCell4.isDisplayed());
            Assert.assertTrue("Text 'Qüvvədə olan", titleCell5.isDisplayed());
            ReusableMethods.flash(page.tableFirstElement, getDriver());
            ReusableMethods.wait(1);
        }
    }

    @Then("document and information is {string} in the legal basis page")
    public void documentAndInformationIsInTheLegalBasisPage(String docCase) {
        if (docCase.contains("FirstCase")) {
            ReusableMethods.pageDown();
            WebElement firstRow = page.tableFirstElement;
            WebElement titleCell1 = firstRow.findElement(By.xpath(".//td[contains(text(), 'Document for public open')]"));
            WebElement titleCell2 = firstRow.findElement(By.xpath("//td[contains(text(), '778899')]"));
            WebElement titleCell3 = firstRow.findElement(By.xpath("//td[contains(text(), 'Əsasnamə')]"));
            WebElement titleCell4 = firstRow.findElement(By.xpath("//td[contains(text(), 'IT Product')]"));
            WebElement titleCell5 = firstRow.findElement(By.xpath("//td[contains(text(), 'Qüvvədə olan')]"));
            WebElement titleCell6 = getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7 = getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8 = getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

            String actualEffective = titleCell6.getText();
            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("actual = " + actualEffective);
            Assert.assertEquals(formattedDate, actualEffective);
            System.out.println("formattedDate = " + formattedDate);

            String actualExpiration = titleCell7.getText();
            expirationDate = LocalDate.now().plusDays(50);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateExpration = expirationDate.format(formatter1);
            System.out.println("formattedDateExpration = " + formattedDateExpration);
            Assert.assertEquals(formattedDateExpration, actualExpiration);

            String actualAdmission = titleCell8.getText();
            admissionDate = LocalDate.now().plusDays(5);
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateAdmission = admissionDate.format(formatter3);
            System.out.println("formattedDateAdmission = " + formattedDateAdmission);
            Assert.assertEquals(formattedDateAdmission, actualAdmission);

            Assert.assertTrue("Text 'Document for public open' should be displayed", titleCell1.isDisplayed());
            Assert.assertTrue("Text '778899", titleCell2.isDisplayed());
            Assert.assertTrue("Text 'Əsasnamə", titleCell3.isDisplayed());
            Assert.assertTrue("Text 'IT Product", titleCell4.isDisplayed());
            Assert.assertTrue("Text 'Qüvvədə olan", titleCell5.isDisplayed());
            ReusableMethods.flash(page.tableFirstElement, getDriver());
            ReusableMethods.wait(1);
            page.tableFirstElement.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.numCheck, getDriver());
            ReusableMethods.flash(page.headCheck, getDriver());
            ReusableMethods.flash(page.docTypeCheck, getDriver());
            ReusableMethods.flash(page.acceptOrganCheck, getDriver());
            ReusableMethods.flash(page.effeCheck, getDriver());
            ReusableMethods.flash(page.statusCheck, getDriver());
            page.linkGo.click();
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
        } else if (docCase.contains("SecondCase")) {
            ReusableMethods.pageDown();
            WebElement firstRow = page.tableFirstElement;
            WebElement titleCell1 = firstRow.findElement(By.xpath(".//td[contains(text(), 'Document according to addressees')]"));
            WebElement titleCell2 = firstRow.findElement(By.xpath("//td[contains(text(), '778899')]"));
            WebElement titleCell3 = firstRow.findElement(By.xpath("//td[contains(text(), 'Əsasnamə')]"));
            WebElement titleCell4 = firstRow.findElement(By.xpath("//td[contains(text(), 'IT Product')]"));
            WebElement titleCell5 = firstRow.findElement(By.xpath("//td[contains(text(), 'Qüvvədə olan')]"));
            WebElement titleCell6 = getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7 = getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8 = getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

            String actualEffective = titleCell6.getText();
            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("actual = " + actualEffective);
            Assert.assertEquals(formattedDate, actualEffective);
            System.out.println("formattedDate = " + formattedDate);

            String actualExpiration = titleCell7.getText();
            expirationDate = LocalDate.now().plusDays(50);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateExpration = expirationDate.format(formatter1);
            System.out.println("formattedDateExpration = " + formattedDateExpration);
            Assert.assertEquals(formattedDateExpration, actualExpiration);

            String actualAdmission = titleCell8.getText();
            admissionDate = LocalDate.now().plusDays(5);
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateAdmission = admissionDate.format(formatter3);
            System.out.println("formattedDateAdmission = " + formattedDateAdmission);
            Assert.assertEquals(formattedDateAdmission, actualAdmission);

            Assert.assertTrue("Text 'Document according to addressees", titleCell1.isDisplayed());
            Assert.assertTrue("Text '778899", titleCell2.isDisplayed());
            Assert.assertTrue("Text 'Əsasnamə", titleCell3.isDisplayed());
            Assert.assertTrue("Text 'IT Product", titleCell4.isDisplayed());
            Assert.assertTrue("Text 'Qüvvədə olan", titleCell5.isDisplayed());
            ReusableMethods.flash(page.tableFirstElement, getDriver());
            ReusableMethods.wait(1);
            page.tableFirstElement.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.numCheck, getDriver());
            ReusableMethods.flash(page.headCheckPerson, getDriver());
            ReusableMethods.flash(page.docTypeCheck, getDriver());
            ReusableMethods.flash(page.acceptOrganCheck, getDriver());
            ReusableMethods.flash(page.effeCheck, getDriver());
            ReusableMethods.flash(page.statusCheck, getDriver());
            page.linkGo.click();
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

        } else if (docCase.contains("ThirdCase")) {
            ReusableMethods.pageDown();
            WebElement firstRow = page.tableFirstElement;
            WebElement titleCell1 = firstRow.findElement(By.xpath(".//td[contains(text(), 'Document according to structure')]"));
            WebElement titleCell2 = firstRow.findElement(By.xpath("//td[contains(text(), '778899')]"));
            WebElement titleCell3 = firstRow.findElement(By.xpath("//td[contains(text(), 'Əsasnamə')]"));
            WebElement titleCell4 = firstRow.findElement(By.xpath("//td[contains(text(), 'IT Product')]"));
            WebElement titleCell5 = firstRow.findElement(By.xpath("//td[contains(text(), 'Qüvvədə olan')]"));
            WebElement titleCell6 = getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7 = getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8 = getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

            String actualEffective = titleCell6.getText();
            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("actual = " + actualEffective);
            Assert.assertEquals(formattedDate, actualEffective);
            System.out.println("formattedDate = " + formattedDate);

            String actualExpiration = titleCell7.getText();
            expirationDate = LocalDate.now().plusDays(50);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateExpration = expirationDate.format(formatter1);
            System.out.println("formattedDateExpration = " + formattedDateExpration);
            Assert.assertEquals(formattedDateExpration, actualExpiration);

            String actualAdmission = titleCell8.getText();
            admissionDate = LocalDate.now().plusDays(5);
            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateAdmission = admissionDate.format(formatter3);
            System.out.println("formattedDateAdmission = " + formattedDateAdmission);
            Assert.assertEquals(formattedDateAdmission, actualAdmission);

            Assert.assertTrue("Text 'Document according to structure", titleCell1.isDisplayed());
            Assert.assertTrue("Text '778899", titleCell2.isDisplayed());
            Assert.assertTrue("Text 'Əsasnamə", titleCell3.isDisplayed());
            Assert.assertTrue("Text 'IT Product", titleCell4.isDisplayed());
            Assert.assertTrue("Text 'Qüvvədə olan", titleCell5.isDisplayed());
            ReusableMethods.flash(page.tableFirstElement, getDriver());
            ReusableMethods.wait(1);
            page.tableFirstElement.click();
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.numCheck, getDriver());
            ReusableMethods.flash(page.headCheckStructure, getDriver());
            ReusableMethods.flash(page.docTypeCheck, getDriver());
            ReusableMethods.flash(page.acceptOrganCheck, getDriver());
            ReusableMethods.flash(page.effeCheck, getDriver());
            ReusableMethods.flash(page.statusCheck, getDriver());
            page.linkGo.click();
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
        }
    }

    @And("selects status {string} for view")
    public void selectsStatusForView(String selection) {
        if (selection.contains("addressed person")) {
            page.statusView.click();
            ReusableMethods.wait(1);
            page.addressedPerson.click();
            ReusableMethods.wait(2);
            page.addressedPersonInput.sendKeys("Musa Rzayev");
            ReusableMethods.wait(2);
            page.selectMusaPerson.click();
            ReusableMethods.wait(1);
            Actions actions = new Actions(getDriver());
            actions.moveByOffset(5, 5).click().build().perform();
        }
    }

    @Then("all information about legal basis is displayed in the legal base page")
    public void allInformationAboutLegalBasisIsDisplayedInTheLegalBasePage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String legalName = row.get("Başlıq");
            String legalNumber = row.get("Nömrəsi");
            String legalDocType = row.get("Sənədin növü");
            String legalAcceptOrgan = row.get("Qəbul edən orqan");
            String statusLegal = row.get("Status");


            ReusableMethods.flash(page.legalNameCheck, getDriver());
            Assert.assertEquals(page.legalNameCheck.getText().trim(), legalName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.legalNumberCheck, getDriver());
            Assert.assertEquals(page.legalNumberCheck.getText().trim(), legalNumber);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.legalTypeCheck, getDriver());
            Assert.assertEquals(page.legalTypeCheck.getText().trim(), legalDocType);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.legalAcceptOrganCheck, getDriver());
            Assert.assertEquals(page.legalAcceptOrganCheck.getText().trim(), legalAcceptOrgan);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.legalStatusCheck, getDriver());
            Assert.assertEquals(page.legalStatusCheck.getText().trim(), statusLegal);
            ReusableMethods.wait(1);

//            LocalDate effectiveDate = LocalDate.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//            formattedDate = effectiveDate.format(formatter);
//            System.out.println("formattedDate = " + formattedDate);
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.legalStartDateCheck,getDriver());
//            Assert.assertEquals(page.legalStartDateCheck.getText().trim(), formattedDate);
//
//            expirationDate = LocalDate.now().plusDays(50);
//            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//            String formattedDate2 = expirationDate.format(formatter1);
//            System.out.println("formattedDate = " + formattedDate);
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.legalEndCheck,getDriver());
//            Assert.assertEquals(page.legalEndCheck.getText().trim(), formattedDate2);
//
//            admissionDate = LocalDate.now().plusDays(5);
//            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//            String formattedDate3 = admissionDate.format(formatter3);
//            System.out.println("formattedDate = " + formatter3);
//            ReusableMethods.wait(1);
//            ReusableMethods.flash(page.legalAcceptDateCheck,getDriver());
//            Assert.assertEquals(page.legalAcceptDateCheck.getText().trim(), formattedDate3);

        }
    }

    @When("selects legal basis from table in the legal base page")
    public void selectsLegalBasisFromTableInTheLegalBasePage() {
        page.legalNameCheck.click();
        ReusableMethods.wait(2);
    }

    @Then("all information about legal basis is displayed in the legal base modal window")
    public void allInformationAboutLegalBasisIsDisplayedInTheLegalBaseModalWindow(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String legalName = row.get("Başlıq");
            String legalNumber = row.get("Nömrəsi");
            String legalDocType = row.get("Sənədin növü");
            String legalAcceptOrgan = row.get("Qəbul edən orqan");
            String statusLegal = row.get("Status");

            ReusableMethods.flash(page.nameModal, getDriver());
            Assert.assertEquals(page.nameModal.getText().trim(), legalName);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.numberModal, getDriver());
            Assert.assertEquals(page.numberModal.getText().trim(), legalNumber);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.docTypeModal, getDriver());
            Assert.assertEquals(page.docTypeModal.getText().trim(), legalDocType);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.acceptOrganModal, getDriver());
            Assert.assertEquals(page.acceptOrganModal.getText().trim(), legalAcceptOrgan);
            ReusableMethods.wait(1);

            LocalDate effectiveDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formattedDate = effectiveDate.format(formatter);
            System.out.println("formattedDate = " + formattedDate);
            ReusableMethods.wait(1);
            ReusableMethods.flash(page.acceptDateModal, getDriver());
            Assert.assertEquals(page.acceptDateModal.getText().trim(), formattedDate);
            ReusableMethods.wait(1);

            ReusableMethods.flash(page.statusModal, getDriver());
            Assert.assertEquals(page.statusModal.getText().trim(), statusLegal);
            ReusableMethods.wait(1);

            String original = getDriver().getWindowHandle();
            page.urlModal.click();
            new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String handle : getDriver().getWindowHandles()) {
                if (!handle.equals(original)) {
                    getDriver().switchTo().window(handle);
                    break;
                }
            }
            Assert.assertEquals(getDriver().getCurrentUrl().trim(), "https://aist.group/");
            getDriver().close();
            getDriver().switchTo().window(original);
        }
    }
}