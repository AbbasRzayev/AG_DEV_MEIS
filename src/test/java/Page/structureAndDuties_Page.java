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
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement nameField;
    @FindBy(xpath = "//input[contains(@formcontrolname, 'pin')]")
    public WebElement finField;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    public WebElement searchButton;
    @FindBy(xpath = "//td[text()='Abbas Rzayev']")
    public WebElement foundedUser;
    @FindBy(xpath = "//span[text()='Struktur və vəzifə dəyişdirilməsi']")
    public WebElement structureAndDutiesChangePage;
    @FindBy(xpath = "(//div[@class='list_item ng-star-inserted']//img[@src='assets/img/common/next.svg'])[1]")
    public WebElement openChildListStructure;
    @FindBy(xpath = "//label[text()='Bakı şəhər şöbəsi']")
    public WebElement bakuCityStructure;

    @FindBy(xpath = "/html/body/app-root/div/div/main/app-change-position/form/div/input-search-select/div/mat-form-field/div[1]/div[2]/div[1]")
    public WebElement dutiesSearchField;

    @FindBy(xpath = "//span[text()=' Baş məsləhətçi ']")
    public WebElement selectInspecter;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement strucAndDutiesSubmit;

    //td[@role='cell']
    //td[text()='Baş məsləhətçi']
    @FindBy(xpath = "(//td[@role='cell'])[3]")
    public WebElement dutiesCheck;

    @FindBy(id = "mat-input-9")
    public WebElement againNameField;

    @FindBy(xpath = "(//span[@class='mat-mdc-list-item-unscoped-content'])[2]")
    public WebElement perCabinet;

    @FindBy(xpath = "//span[text()='Strukturda yerim və vəzifəm']")
    public WebElement strucAndDutyTab;

    @FindBy(xpath = "//label[@class='item_title active no_child']")
    public WebElement sturckCheck;

    @FindBy(xpath = "//label[text()='İnformasiya texnologiyaları və elektron idarəetmə sektoru']")
    public WebElement informationStruck;
    @FindBy(xpath = "//span[text()=' Sektor müdiri ']")
    public WebElement sectorDirector;
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

}