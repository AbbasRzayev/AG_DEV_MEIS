package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class calendar_Page {

    public calendar_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(.,'Təqvim')]")
    public WebElement calendarPage;
    @FindBy(xpath = "//span[contains(.,' Yeni tədbir ')]")
    public WebElement newEventBtn;
    @FindBy(id = "mat-input-2")
    public WebElement eventNameInput;
    @FindBy(id = "mat-input-8")
    public WebElement eventCopyNameInput;
    @FindBy(id = "mat-input-3")
    public WebElement eventStartDateInput;
    @FindBy(id = "mat-input-4")
    public WebElement eventEndDateInput;
    @FindBy(id = "mat-input-8")
    public WebElement eventUrlInput;
    @FindBy(xpath = "//div[@class='mat-mdc-select-trigger ng-tns-c3393473648-19']")
    public WebElement notChoose;
    @FindBy(xpath = "(//span[text()='Ünvanlanmış şəxslərə görə'])[2]")
    public WebElement notChooseForPerson;
    @FindBy(xpath = "//span[text()='Struktur bölmə daxilində']")
    public WebElement notChooseStructure;
    @FindBy(id = "mat-input-10")
    public WebElement ChoosePersonInput;
    @FindBy(xpath = "//label[contains(.,'Musa Rzayev')]")
    public WebElement ChoosePersonAbbas;
    @FindBy(xpath = "//div[@class='mat-mdc-select-trigger ng-tns-c3393473648-21']")
    public WebElement chooseCalendarWhoWillSee;
    @FindBy(xpath = "//div[@class='cdk-overlay-connected-position-bounding-box']//span[text()='Ünvanlanmış şəxslərə görə']")
    public WebElement calendarVisabilityForPerson;
    @FindBy(xpath = "//div[@class='cdk-overlay-connected-position-bounding-box']//span[text()='Struktur bölmə daxilində']")
    public WebElement calendarVisabilityStructure;
    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-22']")
    public WebElement categoryList;
    @FindBy(xpath = "//span[text()='İcazə']")
    public WebElement categoryPermitList;
    @FindBy(xpath = "//div[@class='mat-mdc-select-trigger ng-tns-c3393473648-25']")
    public WebElement eventPlace;
    @FindBy(xpath = "//span[contains(.,'Digər')]")
    public WebElement placeSelect;
    @FindBy(xpath = "//div[@class='mat-mdc-select-value ng-tns-c3393473648-27']")
    public WebElement eventOrganizer;
    @FindBy(xpath = "//span[text()=' Şəxs']")
    public WebElement organizerPerson;
    @FindBy(id = "mat-input-13")
    public WebElement AddNamePersonInput;
    @FindBy(id = "mat-input-14")
    public WebElement AddNameStrukPersonInput;
    @FindBy(xpath = "//span[contains(.,' Fərid İmranov ')]")
    public WebElement addFerid;
    @FindBy(xpath = "//span[contains(.,'Şəkil əlavə edin')]")
    public WebElement addPhoto;
    @FindBy(id = "mat-input-9")
    public WebElement addDescription;
    @FindBy(xpath = "//span[contains(.,'Təsdiq et')]")
    public WebElement acceptBtn;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']")
    public WebElement mainNote;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[2]")
    public WebElement noteBtn;
    @FindBy(xpath = "//div[@class='notifications_wrapper']")
    public WebElement findEventList;
    @FindBy(xpath = "(//span[@class='mat-mdc-list-item-unscoped-content'])[8]")
    public WebElement calTab;
    @FindBy(xpath = "//span[contains(.,'AT_TesT')]")
    public WebElement findEvent;
    @FindBy(xpath = "//span[contains(.,'AT_TesT_Structure')]")
    public WebElement findEvent1;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
    public WebElement closeModalWindow;
    @FindBy(xpath = "//span[contains(.,'Struktur bölmə daxilində')]")
    public WebElement selectStructureList;
    @FindBy(xpath = "//mat-label[contains(.,'Struktur bölmə')]")
    public WebElement selectDivision;
    @FindBy(xpath = "(//mat-label[contains(.,'Struktur bölmə')])[2]")
    public WebElement selectSecondDivision;
    @FindBy(xpath = "(//div[@class='parent_wrapper']//img[@class='ng-star-inserted'])[1]")
    public WebElement openListStructure;
    @FindBy(xpath = "//label[text()='Antiinhisar və İstehlak Bazarlarına Nəzarət Dövlət Xidməti']")
    public WebElement selectStructure;
    @FindBy(xpath = "(//span[contains(., 'Təsdiq et')])[2]")
    public WebElement accceptStructure;
    @FindBy(xpath = "//span[text()='Surətini çıxar']")
    public WebElement copyEventBtn;
    @FindBy(xpath = "(//span[text()='Sil'])[1]")
    public WebElement EventDeleteBtn;
    @FindBy(xpath = "//a[contains(.,'Təqvim')]")
    public WebElement calTabAdmin;
    @FindBy(xpath = "//span[contains(.,'Bəli')]")
    public WebElement yesBtn;
    @FindBy(xpath = "//p[contains(.,'AT_TesT_Structure_Copy')]")
    public WebElement strukCopyText;
    @FindBy(xpath = "//p[contains(.,'AT_TesT_Structure')]")
    public WebElement strukCopy;
    @FindBy(xpath = "//p[text()='AT_TesT']")
    public WebElement personEventCheck;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']")
    public WebElement eventNotAppears;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[11]")
    public WebElement closeModal;

}