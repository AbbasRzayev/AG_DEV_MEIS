package stepdefinitions;

import Page.meisAndProgramLogs_Page;
import Page.structureAndDuties_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static utilities.Driver.getDriver;

public class meisAndProgramLogs_Steps {
    meisAndProgramLogs_Page page = new meisAndProgramLogs_Page();
    structureAndDuties_Page structure = new structureAndDuties_Page();

    @And("switches to the meis and program log tab")
    public void switchesToTheMeisAndProgramLogTab() {
        page.meisProgramLogTab.click();
        ReusableMethods.wait(1);
    }
//    LocalDateTime now = LocalDateTime.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
//    String formattedDateMeis = now.format(formatter);
//
//    DateTimeFormatter formatterDoc = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
//    String formattedDateEDoc = now.format(formatterDoc);

    @And("select founded user in the users tab in the admin panel")
    public void selectFoundedUserInTheUsersTabInTheAdminPanel() {
        structure.foundedUser.click();
        ReusableMethods.wait(3);
    }

    @Then("the users MEIS access log information is displayed correctly")
    public void theUsersMEISAccessLogInformationIsDisplayedCorrectly() {
        ReusableMethods.flash(page.meisDate, getDriver());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime adjusted = now.minusMinutes(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedDate = adjusted.format(formatter);
        ReusableMethods.wait(1);
        Assert.assertEquals(page.meisDate.getText().trim(), formattedDate);
        ReusableMethods.wait(1);
    }

    @Then("the users program access log information for {string} is displayed correctly")
    public void theUsersProgramAccessLogInformationForIsDisplayedCorrectly(String program) {
        if(program.contains("Elektron Sənəd Dövriyyəsi")){
            ReusableMethods.flash(page.programTime, getDriver());
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime adjusted = now.minusMinutes(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            String formattedDate = adjusted.format(formatter);

            ReusableMethods.wait(1);
            By row1InTable2  = By.xpath("(//tbody[contains(@class,'mdc-data-table__content')])[2]//tr[1]");
            By nameCellInRow = By.xpath(".//td[contains(@class,'mat-column-name')]");
            By dateCellInRow = By.xpath(".//td[contains(@class,'mat-column-date')]");
            WebElement row1 = getDriver().findElement(row1InTable2);
            String actualProgram = row1.findElement(nameCellInRow).getText().trim();
            System.out.println("actualProgram = " + actualProgram);
            String actualDateTime = row1.findElement(dateCellInRow).getText().trim();
            String expectedProgram = "Elektron Sənəd Dövriyyəsi";
            Assert.assertEquals(actualProgram, expectedProgram);
            Assert.assertEquals(actualDateTime, formattedDate);
            ReusableMethods.wait(1);
        }
    }
}
