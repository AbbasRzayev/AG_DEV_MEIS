package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class structureAndDuties_Page {
    public structureAndDuties_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='mat-mdc-list-item-unscoped-content'])[9]")
    public WebElement controlPanel;
    @FindBy(xpath = "//a[@class='mat-ripple ng-star-inserted active']")
    public WebElement userTab;
    @FindBy(xpath = "//mat-label[text()='Ad']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement nameField;
    @FindBy(xpath = "//mat-label[text()='FİN']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement finField;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    public WebElement searchButton;
    @FindBy(xpath = "(//tr[@role='row'])[2]")
    public WebElement foundedUser;
    @FindBy(xpath = "//span[text()='Struktur və vəzifə dəyişdirilməsi']")
    public WebElement structureAndDutiesChangePage;
    @FindBy(xpath = "//span[text()='Bu şəxsin adından sistemə giriş etmək']")
    public WebElement enterToTheSystemFromAdminPanel;

    @FindBy(xpath = "//h6[contains(text(),'Keyfiyyətə Nəzarət(AT)')]/preceding::button[.//img[contains(@src,'next.svg')]][1]")
    public WebElement openQualityControlStructureParentList;

    @FindBy(xpath = "//h6[contains(text(),'Avtomatlaşdırılma və manual testlər')]")
    public WebElement ATAndManualSector;

    @FindBy(xpath = "//h6[contains(text(),'AISTGroup MMC')]")
    public WebElement openAISTMMCStructureParentList;

    @FindBy(xpath = "//button[.//mat-icon[text()='expand_more']]")
    public WebElement dutiesSearchField;

    @FindBy(xpath = "//div[contains(text(),' Şöbə Müdiri ')]")
    public WebElement selectSectionDirector;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement againNameField;

    @FindBy(xpath = "(//span[@class='mat-mdc-list-item-unscoped-content'])[2]")
    public WebElement perCabinet;

    @FindBy(xpath = "//input[@placeholder='Vəzifə seçin']")
    public WebElement dutyInput;

    @FindBy(xpath = "//span[text()='Strukturda yerim və vəzifəm']")
    public WebElement strucAndDutyTab;

    @FindBy(xpath = "//label[@class='item_title active no_child']")
    public WebElement sturckCheck;

    @FindBy(xpath = "//label[text()='İnformasiya texnologiyaları və elektron idarəetmə sektoru']")
    public WebElement informationStruck;
    @FindBy(xpath = "//span[text()=' Sektor müdiri ']")
    public WebElement sectorDirector;
    @FindBy(xpath = "//div[text()=' QA_AT ']")
    public WebElement qaAtPosition;
    @FindBy(xpath = "//span[text()='Bu şəxsin adından sistemə giriş etmək']")
    public WebElement logInWithThisPerson;
    @FindBy(xpath = "//span[text()='Struktur və vəzifə']")
    public WebElement sdTab;
    @FindBy(xpath = "//button[@class='add-org']")
    public WebElement plusStructur;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement nameStruc;
    @FindBy(xpath = "//input[@formcontrolname='shortName']")
    public WebElement shortNameStruc;
    @FindBy(xpath = "//input[@formcontrolname='orgCode']")
    public WebElement depCode;
    @FindBy(xpath = "//input[@formcontrolname='priority']")
    public WebElement prioField;
    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    public WebElement detailInfo;
    @FindBy(xpath = "//span[text()='Yadda saxla']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Problemli sınaq şöbələr(test)']")
    public WebElement newStructure;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-control/div/ng-component/app-structure-tab/mat-card/app-recursive-structure/div/div[6]/div/mat-icon")
    public WebElement openMenu;

    @FindBy(xpath = "//span[text()='Sil']")
    public WebElement deleteButton;

    @FindBy(id = "mat-input-16")
    public WebElement addReason;

    @FindBy(xpath = "(//span[@class='mdc-button__label'])[2]")
    public WebElement acceptDelete;

    @FindBy(xpath = "//a[@class='mat-ripple ng-star-inserted active']")
    public WebElement programsPanel;
    @FindBy(xpath = "//span[text()='Vəzifə']")
    public WebElement dutyTab;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
    public WebElement dutyPLus;
    @FindBy(id = "mat-input-10")
    public WebElement dutyNameInput;
    @FindBy(id = "mat-input-9")
    public WebElement dutySearchField;
    @FindBy(xpath = "//span[text()=' Axtar ']")
    public WebElement dutySearchButton;
    @FindBy(xpath = "//span[text()=' Əlavə et ']")
    public WebElement dutyAdd;
    @FindBy(xpath = "//td[text()=\"Keyfiyyətə nəzarət(test)\"]")
    public WebElement dutyBackground;
    //label[contains(@class,'QA')] - elementin icinde element axtarishi
    @FindBy(xpath = "//span[text()='Bəli']")
    public WebElement yesButton;
    @FindBy(xpath = "//span[text()=' Təsdiqlə ']")
    public WebElement structureAndDutiesSubmit;
    @FindBy(xpath = "//td[text()=' Keyfiyyətə Nəzarət(AT) ']")
    public WebElement QualityControlStructureCheck;
    @FindBy(xpath = "//td[text()=' QA_AT ']")
    public WebElement qaAtPositionTableCheck;
    @FindBy(xpath = "//td[text()=' Şöbə Müdiri ']")
    public WebElement sectorDirectorPositionTableCheck;
    @FindBy(xpath = "//td[text()=' AISTGroup MMC ']")
    public WebElement aistMMCStructureCheck;
    @FindBy(xpath = "//span[text()='Strukturda yerim və vəzifəm']")
    public WebElement mYStructureAndPositionTab;
    @FindBy(xpath = "//h6[contains(., 'Keyfiyyətə Nəzarət(AT)')]")
    public WebElement qaATstructureProfilePage;
    @FindBy(xpath = "//h6[contains(., 'AISTGroup MMC')]")
    public WebElement aistMMCstructureProfilePage;
    @FindBy(xpath = "//h6[contains(., 'Avtomatlaşdırılma və manual testlər')]")
    public WebElement structureSectorProfilePage;
    @FindBy(xpath = "//button[.//img[@alt='openChild' and contains(@src, 'next.svg')]]")
    public WebElement openStructureSectorProfilePage;
    @FindBy(xpath = "//p[contains(., 'Şöbə Müdiri')]")
    public WebElement sectorDirecotrPositionProfilePage;
    @FindBy(xpath = "//p[contains(., 'QA_AT')]")
    public WebElement qaAtPositionProfilePage;
}