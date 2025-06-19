package stepdefinitions;

import Page.legalBasis_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        if (status.contains("Document for public open")) {
            page.nameForFirstDocument.sendKeys(status);
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

    @And("adds number to the number field")
    public void addsNumberToTheNumberField() {
        page.numberField.sendKeys("778899");
        ReusableMethods.wait(1);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @And("adds state registration number")
    public void addsStateRegistrationNumber() {
        page.stateNumber.sendKeys("AA8778");
        ReusableMethods.wait(1);
    }

    @And("selects type of document")
    public void selectsTypeOfDocument() {
        page.docTypeBtn.click();
        ReusableMethods.wait(1);
        page.docType.click();
    }

    @And("adds the receiving authority")
    public void addsTheReceivingAuthority() {
        page.acceptedOrgan.sendKeys("IT Product");

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

    }

    @And("adds expiration date")
    public void addsExpirationDate() {
        expirationDate = LocalDate.now().plusDays(50);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = expirationDate.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.expirationDate.sendKeys(formattedDate);
    }

    @And("adds date of admission")
    public void addsDateOfAdmission() {
        admissionDate = LocalDate.now().plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = admissionDate.format(formatter);
        System.out.println("formattedDate = " + formattedDate);
        ReusableMethods.wait(1);
        page.admissonDate.sendKeys(formattedDate);
    }


    @And("adds status of document")
    public void addsStatusOfDocument() {
        page.status.click();
        page.statusSelect.click();
        ReusableMethods.wait(1);
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

            WebElement titleCell6= getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7= getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8= getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

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
            WebElement titleCell6= getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7= getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8= getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

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
            WebElement titleCell6= getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7= getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8= getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

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
            WebElement titleCell6= getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7= getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8= getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

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
            WebElement titleCell6= getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7= getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8= getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

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
            WebElement titleCell6= getDriver().findElement(By.xpath("(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-startDateStr mat-column-startDateStr ng-star-inserted'])[1]"));
            WebElement titleCell7= getDriver().findElement(By.xpath("(//td[@role='cell'])[7]"));
            WebElement titleCell8= getDriver().findElement(By.xpath("(//td[@role='cell'])[8]"));

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
}