package stepdefinitions;


import Page.leftSIdeBarMenu_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ReusableMethods;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static utilities.Driver.getDriver;

public class leftSIdeBarMenu_Steps {

leftSIdeBarMenu_Page page =new leftSIdeBarMenu_Page();

    @And("user selects left sidebar button")
    public void userSelectsLeftSidebarButton() {
        page.leftSideBarBtn.click();
        ReusableMethods.wait(1);
    }

    @When("user selects main page from left sidebar")
    public void userSelectsMainPageFromLeftSidebar() {
        page.mainPage.click();
        ReusableMethods.wait(1);
    }
    @Then("user successfully switches to the main page")
    public void userSuccessfullySwitchesToTheMainPage() {
        ReusableMethods.flash(page.mainLogo,getDriver());
        String tittle = "Ana səhifə | MEIS";
        assertEquals(tittle,getDriver().getTitle());
        ReusableMethods.wait(2);
    }
    @When("user selects personal cabinet from left sidebar")
    public void userSelectsPersonalCabinetFromLeftSidebar() {
        page.personalCabinet.click();
        ReusableMethods.wait(1);
    }
    @Then("user successfully switches to the personal cabinet tab")
    public void userSuccessfullySwitchesToThePersonalCabinetTab() {
        ReusableMethods.flash(page.mainLogo,getDriver());
        String tittle = "Şəxsi kabinetim | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects programs from left sidebar")
    public void userSelectsProgramsFromLeftSidebar() {
        page.programs.click();
        ReusableMethods.wait(1);
    }


    @Then("user successfully switches to the program tab")
    public void userSuccessfullySwitchesToTheProgramTab() {
        ReusableMethods.flash(page.progLogo,getDriver());
        String tittle = "Proqramlarım | MEIS";
        ReusableMethods.wait(30);
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects announcement and congratulations from left sidebar")
    public void userSelectsAnnouncementAndCongratulationsFromLeftSidebar() {
        page.congrats.click();
        ReusableMethods.wait(15);

    }

    @Then("user successfully switches to the announcement and congratulations page")
    public void userSuccessfullySwitchesToTheAnnouncementAndCongratulationsPage() {
//        ReusableMethods.flash(page.congLogo,getDriver());
        String tittle = "Elan və təbriklər | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects idea bank from left sidebar")
    public void userSelectsIdeaBankFromLeftSidebar() {
        page.idea.click();
        ReusableMethods.wait(2);
    }

    @Then("user successfully switches to the idea bank page")
    public void userSuccessfullySwitchesToTheIdeaBankPage() {
        ReusableMethods.flash(page.ideaLogo,getDriver());
        String tittle = "İdea bankı | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects legal basis from left sidebar")
    public void userSelectsLegalBasisFromLeftSidebar() {
        page.base.click();
        ReusableMethods.wait(1);
    }

    @Then("user successfully switches to the legal basis page")
    public void userSuccessfullySwitchesToTheLegalBasisPage() {
        ReusableMethods.flash(page.baseLogo,getDriver());
        String tittle = "Hüquqi baza | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects electronic library from left sidebar")
    public void userSelectsElectronicLibraryFromLeftSidebar() {
        page.libery.click();
        ReusableMethods.wait(1);
    }

    @Then("user successfully switches to the electronic library")
    public void userSuccessfullySwitchesToTheElectronicLibrary() {
        ReusableMethods.flash(page.libaryLogo,getDriver());
        String tittle = "Elektron kitabxana | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects Calendar from left sidebar")
    public void userSelectsCalendarFromLeftSidebar() {
        page.calendar.click();
        ReusableMethods.wait(1);
    }

    @Then("user successfully switches to the calendar page")
    public void userSuccessfullySwitchesToTheCalendarPage() {
        //ReusableMethods.flash(page.calendarLogo,getDriver());
        String tittle ="Təqvim | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects admin panel from left sidebar")
    public void userSelectsAdminPanelFromLeftSidebar() {
        page.adminpanel.click();
        ReusableMethods.wait(1);
    }

    @Then("user successfully switches to the admin panel")
    public void userSuccessfullySwitchesToTheAdminPanel() {
        ReusableMethods.flash(page.adminLogo,getDriver());
        String tiitle = "İstifadəçilər | MEIS";
        assertEquals(tiitle,getDriver().getTitle());
    }

    @When("user selects  help desk from left sidebar")
    public void userSelectsHelpDeskFromLeftSidebar() {
        page.helpDesk.click();
        ReusableMethods.wait(1);
    }

    @Then("user successfully switches to the help desk page")
    public void userSuccessfullySwitchesToTheHelpDeskPage() {
        ReusableMethods.flash(page.helpDeskLogo,getDriver());
        String tittle = "Yardım masası | MEIS";
        assertEquals(tittle,getDriver().getTitle());
    }

    @When("user selects  log out from left sidebar")
    public void userSelectsLogOutFromLeftSidebar() {
        page.logOut.click();
        ReusableMethods.wait(1);
        page.yesBtn.click();
        ReusableMethods.wait(2);
//        ReusableMethods.flash(page.tittleText,getDriver());
    }

    @Then("user successfully log out from {string} system")
    public void userSuccessfullyLogOutFromSystem(String environment) {
        if(environment.contains("AG-MEIS")) {
            ReusableMethods.wait(1);
            String logOutUrl = "auth";
            String actualUrl= ReusableMethods.getPathSegment(logOutUrl);
            assertEquals(logOutUrl,actualUrl);
        }
    }
}