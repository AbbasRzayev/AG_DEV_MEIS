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
    @FindBy(xpath = "//input[@formcontrolname='shortNote']")
    public WebElement eventNameInput;
    @FindBy(id = "mat-input-8")
    public WebElement eventCopyNameInput;
    @FindBy(xpath = "//input[@formcontrolname='startDate']")
    public WebElement eventStartDateInput;
    @FindBy(xpath = "//input[@formcontrolname='endDate']")
    public WebElement eventEndDateInput;
    @FindBy(xpath = "//input[@formcontrolname='url']")
    public WebElement eventUrlInput;
    @FindBy(xpath = "//div[@class='mat-mdc-select-trigger ng-tns-c3393473648-19']")
    public WebElement notChoose;
    @FindBy(xpath = "(//span[text()='Ünvanlanmış şəxslərə görə'])[2]")
    public WebElement notChooseForPerson;
    @FindBy(xpath = "//span[text()='Struktur bölmə daxilində']")
    public WebElement notChooseStructure;
    @FindBy(xpath = "(//input[contains(@class, 'search-input')])[1]")
    public WebElement choosePersonInput;
    @FindBy(xpath = "(//input[contains(@class, 'search-input')])[2]")
    public WebElement choosePersonInputSecond;
    @FindBy(xpath = "//div[contains(normalize-space(.), 'Musa Rzayev')]/span[contains(@class, 'emptyBox')]")
    public WebElement choosePersonMusa;
    @FindBy(xpath = "//div[contains(normalize-space(.), 'İbrahim Rzayev')]/span[contains(@class, 'emptyBox')]")
    public WebElement choosePersonIbrahim;
    @FindBy(xpath = "//div[@class='mat-mdc-tooltip-trigger manual-option ng-star-inserted' and contains(., 'Musa Rzayev')]")
    public WebElement cancelMusaPerson;
    @FindBy(xpath = "//div[@class='mat-mdc-tooltip-trigger manual-option ng-star-inserted' and contains(., 'İbrahim Rzayev')]")
    public WebElement cancelIbrahimPerson;
    @FindBy(xpath = "(//div[contains(normalize-space(.), 'Davud Zamanov')])[5]")
    public WebElement choosePersonDavud;
    @FindBy(xpath = "//span[text()='Ümumi açıq']")
    public WebElement chooseCalendarWhoWillSee;
    @FindBy(xpath = "//div[@class='cdk-overlay-connected-position-bounding-box']//span[text()='Ünvanlanmış şəxslərə ']")
    public WebElement calendarVisibilityForPerson;
    @FindBy(xpath = "//div[@class='cdk-overlay-connected-position-bounding-box']//span[text()='Struktur bölmə daxilində']")
    public WebElement calendarVisabilityStructure;
    @FindBy(xpath = "//mat-label[text()='Tədbirin keçiriləcəyi yer']/ancestor::div[contains(@class, 'mat-mdc-form-field-infix')]//mat-select")
    public WebElement eventPlace;
    @FindBy(xpath = "//span[contains(.,'671 nömrəli otaq')]")
    public WebElement placeSelectRoom671;
    @FindBy(xpath = "//span[contains(.,'İclas zalı')]")
    public WebElement placeSelectMeetingRoom;
    @FindBy(xpath = "//span[contains(.,'Automation event place')]")
    public WebElement  automationEventPlace;
    @FindBy(xpath = "//input[@placeholder='Şəxs']")
    public WebElement eventOrganizer;
    @FindBy(xpath = "(//div[contains(.,' Abbas Rzayev ')])[5]")
    public WebElement addAbbas;
    @FindBy(xpath = "(//div[contains(.,' Davud Zamanov ')])[5]")
    public WebElement addDavud;
    @FindBy(xpath = "//p[text()='Şəkil əlavə edin']")
    public WebElement addPhoto;
    @FindBy(xpath = "//mat-icon[text()='change_circle']")
    public WebElement changePhoto;
    @FindBy(xpath = "//p[text()='Fayl əlavə edin']")
    public WebElement addFileNew;
    @FindBy(xpath = "//mat-icon[text()='add_circle']")
    public WebElement changeFile;
    @FindBy(xpath= "//textarea[@formcontrolname='description']")
    public WebElement addDescription;
    @FindBy(xpath = "//span[contains(.,'Təsdiq et')]")
    public WebElement acceptBtn;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']")
    public WebElement mainNote;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[2]")
    public WebElement noteBtn;
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
    @FindBy(xpath = "//span[contains(.,'Təqvim')]")
    public WebElement calTabAdmin;
    @FindBy(xpath = "//span[contains(.,'Bəli')]")
    public WebElement yesBtn;
    @FindBy(xpath = "//p[contains(.,'AT_TesT_Structure_Copy')]")
    public WebElement strukCopyText;
    @FindBy(xpath = "//p[contains(.,'AT_TesT_Structure')]")
    public WebElement strukCopy;
    @FindBy(xpath = "//p[text()='AT_TesT']")
    public WebElement personEventCheck;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[11]")
    public WebElement closeModal;
    @FindBy(xpath = "//mat-select[@formcontrolname='eventCategoryId']")
    public WebElement categorySelect;
    @FindBy(xpath = "(//span[normalize-space()='Elan'])[1]")
    public WebElement categoryAnnouncementSelect;
    @FindBy(xpath = "(//span[normalize-space()='İcazə'])[1]")
    public WebElement categoryBusinessTripSelect;
    @FindBy(xpath = "(//span[normalize-space()='Automation category'])[1]")
    public WebElement categoryAutomation;
    @FindBy(xpath = "//input[@formcontrolname='MHour']")
    public WebElement startTimeInput;
    @FindBy(xpath = "//input[@formcontrolname='endHour']")
    public WebElement endTimeInput;
    @FindBy(xpath = "//input[@formcontrolname='notificationOffsetMinutes']")
    public WebElement reminderInput;
    @FindBy(xpath = "(//p[@class='shortNote'])[1]")
    public WebElement eventName;
    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    public WebElement eventStatus;
    @FindBy(xpath = "//span[normalize-space(.)='Vaxt']/following-sibling::p[1]")
    public WebElement eventDataTime;

    @FindBy(xpath = "//h5[contains(@class, 'dialog__title')]")
    public WebElement  notTextCheck;
    @FindBy(xpath = "//div[span[text()='Kateqoriya']]/p")
    public WebElement categoryName;
    @FindBy(xpath = "//div[span[text()='Tədbirin keçiriləcəyi yer']]/p")
    public WebElement eventPLace;
    @FindBy(xpath = "//div[span[text()='Tədbiri təşkil edən']]/p")
    public WebElement eventOrganizerName;
    @FindBy(xpath = "//div[span[text()='Tərtib edən']]/p")
    public WebElement whoCreate;
    @FindBy(xpath = "//div[span[text()='Bildiriş statusu']]/p")
    public WebElement notStatus;
    @FindBy(xpath = "//div[span[text()='Baxış statusu']]/p")
    public WebElement viewStatus;
    @FindBy(xpath = "//div[span[text()='Şəxslər']]/p")
    public WebElement persons;
    @FindBy(xpath = "//div[span[text()='Başlama tarixi']]/p")
    public WebElement startDataInfo;
    @FindBy(xpath = "//div[span[text()='Başlama vaxtı']]/p")
    public WebElement startTimeInfo;
    @FindBy(xpath = "//div[span[text()='Bitmə vaxtı']]/p")
    public WebElement endTime;
    @FindBy(xpath = "//div[span[text()='Url']]/p")
    public WebElement urlInfo;
    @FindBy(xpath = "//div[span[text()='Tip']]/p")
    public WebElement typeInfo;
    @FindBy(xpath = "//div[span[text()='Təsvir']]/p")
    public WebElement descriptionInfo;
    @FindBy(xpath = "//span[text()='Bağla']")
    public WebElement closeButtonNotificationModal;
    @FindBy(xpath = "//img[@alt='Təqvim']/ancestor::mat-list-item")
    public WebElement calendarLeftSideBar;
    @FindBy(xpath = "(//span[text()='AT_TesT'])[1]")
    public WebElement eventNameCalendar;
    @FindBy(xpath = "(//span[text()='AT_Edited'])[1]")
    public WebElement eventEditNameCalendar;
    @FindBy(xpath = "(//span[text()='AT_Delete'])[1]")
    public WebElement eventEditNameCalendarDelete;
    @FindBy(xpath = "(//span[text()='AT_Duplicate'])[1]")
    public WebElement eventNameCalendarDuplicate;
    @FindBy(xpath = "//h5[contains(@_ngcontent, '')]")
    public WebElement eventNameCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[1]")
    public WebElement categoryNameCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[2]")
    public WebElement eventPLaceCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[3]")
    public WebElement eventOrganizerNameCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[4]")
    public WebElement whoCreateCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[5]")
    public WebElement notStatusCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[7]")
    public WebElement viewStatusCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[8]")
    public WebElement personsCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[9]")
    public WebElement startDataInfoCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[11]")
    public WebElement startTimeInfoCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[13]")
    public WebElement endTimeCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[14]")
    public WebElement urlInfoCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[15]")
    public WebElement typeInfoCal;
    @FindBy(xpath = "(//strong/ancestor::div[1]/p)[16]")
    public WebElement descriptionInfoCal;
    @FindBy(xpath = "(//span[text()='Düzəliş et'])[1]")
    public WebElement editBtnEvent;
    @FindBy(xpath = "(//span[text()='Sil'])[1]")
    public WebElement deleteBtnEvent;
    @FindBy(xpath = "//span[text()='Surətini çıxar']")
    public WebElement duplicateBtnEvent;
}