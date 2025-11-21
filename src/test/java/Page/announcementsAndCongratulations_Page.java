package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class announcementsAndCongratulations_Page {

    public announcementsAndCongratulations_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Elanlar']")
    public WebElement announcementTabAdminPanel;

    @FindBy(xpath = "//span[text()='Təbriklər']")
    public WebElement congratulationsTabAdminPanel;
    @FindBy(xpath = "//span[normalize-space()='Yeni elan']")
    public WebElement newAnnouncement;
    @FindBy(xpath = "//span[normalize-space()='Yeni təbrik']")
    public WebElement newCongratulation;
    @FindBy(xpath = "//button[@class='new_news']")
    public WebElement newEventCalendarBtn;
    @FindBy(xpath = "//span[normalize-space()='Yeni təbrik']")
    public WebElement newCongrats;
    @FindBy(xpath = "//input[@formcontrolname='title']")
    public WebElement announcementName;
    @FindBy(id = "mat-input-52")
    public WebElement congratsName;
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    public WebElement announcementDesciption;
    @FindBy(xpath = "//div[@class='ql-editor']")
    public WebElement announcementDesc;
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    public WebElement congratsDesciption;
    @FindBy(xpath = "//input[@formcontrolname='mlsppUrl']")
    public WebElement announcementUrl;
    @FindBy(id = "mat-input-9")
    public WebElement announcementUrlOpenPublic;
    @FindBy(id = "mat-input-53")
    public WebElement congratsUrl;
    @FindBy(xpath = "//mat-select[@formcontrolname='typeId']")
    public WebElement announcementType;
    @FindBy(xpath = "//span[text()='Maraqlı məlumatlar']")
    public WebElement announcementTypeSelect;
    @FindBy(xpath = "//span[text()='AutomationQA news']")
    public WebElement announcementEditedTypeSelect;
    @FindBy(xpath = "//span[text()='Automation progress']")
    public WebElement congratsEditedTypeSelect;
    @FindBy(xpath = "//p[text()='Əlavə şəkil']")
    public WebElement anotherFile;
    @FindBy(xpath = "//span[text()='Elanlar']")
    public WebElement announcementNewTypeSelect;
    @FindBy(xpath = "//span[text()='Məzuniyyət']")
    public WebElement announcementVaTypeSelect;
    @FindBy(xpath = "//span[text()='Automation category']")
    public WebElement calendarAutomation;
    @FindBy(xpath = "//span[text()='Automation event place']")
    public WebElement calenderEventCheck;
    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-172']")
    public WebElement congratsType;
    @FindBy(xpath = "//span[text()='Maraqlı məlumatlar']")
    public WebElement congratsTypeSelect;
    @FindBy(xpath = "//span[text()='Ümumi açıq']")
    public WebElement announcementStatus;
    @FindBy(xpath = "//span[text()='Ünvanlanmış şəxslərə görə ']")
    public WebElement announcementStatusForPerson;
    @FindBy(xpath = "//span[text()='Struktur bölmə daxilində']")
    public WebElement announcementStatusForStructure;
    @FindBy(css = "input.search-input")
    public WebElement announcementPersonName;
    @FindBy(xpath = "//span[contains(., 'Təsdiq et')]")
    public WebElement accceptStructure;
    @FindBy(xpath = "//mat-label[contains(.,'Struktur bölmə')]")
    public WebElement announcementStructureList;
    @FindBy(xpath = "//label[text()='Antiinhisar və İstehlak Bazarlarına Nəzarət Dövlət Xidməti']")
    public WebElement announcementSelectStructureList;
    @FindBy(xpath = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-recursive-structure-dialog/mat-card/mat-card-content/app-recursive-structure/div/div[1]/div/img")
    public WebElement announcementOpenStructureList;

    @FindBy(xpath = "//span[text()='Ümumi açıq']")
    public WebElement congratsStatus;
    @FindBy(xpath = "//div[text()=' Musa Rzayev ']")
    public WebElement announcementMusaSelect;
    @FindBy(xpath = "//div[text()=' Abbas Rzayev FUAD ']")
    public WebElement announcementAbbasSelect;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
    public WebElement closeSearchList;

    @FindBy(xpath = "//span[text()='Ünvanlanmış şəxslərə görə']")
    public WebElement congratstStatusForPerson;
    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-207']")
    public WebElement congratsStatusForPerson;
    @FindBy(xpath = "//p[text()='Elanlarla bağlı əsas şəkil']")
    public WebElement announcementMainPictureOne;
    @FindBy(xpath = "//p[text()='Təbriklərlə bağlı əsas şəkil']")
    public WebElement congratsMainPictureOne;
    @FindBy(xpath = "//img[@alt='Əsas şəkil']")
    public WebElement mainPictureEdit;
    @FindBy(xpath = "//p[text()='Video']")
    public WebElement announcementPictureTwo;
    @FindBy(xpath = "(//mat-label[normalize-space()='URL']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input[@matinput])[2]")
    public WebElement videoUrlPerson;
    @FindBy(id = "mat-input-10")
    public WebElement videoUrlPublic;
    @FindBy(xpath = "//span[text()=' Təsdiq et ']")
    public WebElement acceptVideo;
    @FindBy(xpath = "//span[text()=' Yadda saxla ']")
    public WebElement saveBtn;
    @FindBy(xpath = "//span[text()='TestElanForPerson']")
    public WebElement announcementCheckPerson;
    @FindBy(xpath = "//p[text()='Congratulations according to the addressees']")
    public WebElement congratsCheckPerson;
    @FindBy(xpath = "//p[text()='Congratulations according to the structure']")
    public WebElement congratsCheckStruce;
    @FindBy(xpath = "//p[text()='Congratulations according to the structure']")
    public WebElement congratsCheckStructure;
    @FindBy(xpath = "//p[text()='Congratulations according to the public open']")
    public WebElement congratsCheckPublicOPen;
    @FindBy(xpath = "//p[text()='TestElanForStructure']")
    public WebElement announcementCheckStructure;
    @FindBy(xpath = "//p[text()='TestElanForPublicOpen']")
    public WebElement annmentCheckPublicOpen;
    @FindBy(xpath = "//p[text()='TestElanForStructure']")
    public WebElement announcementCheckForStructure;
    @FindBy(xpath = "//p[text()='TestElanForPublicOpen']")
    public WebElement announcementCheckPublicOpen;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[2]")
    public WebElement announcementNotBtn;
    @FindBy(xpath = "(//p[contains(.,' TestElanForPerson başlıqlı Elan yaradıldı ')])[1]")
    public WebElement announcementNotSelect;
    @FindBy(xpath = "(//p[contains(.,' Congratulations according to the addressees  başlıqlı Təbrik yaradıldı ')])[1]")
    public WebElement congratNotSelect;
    @FindBy(xpath = "(//p[contains(.,'Congratulations according to the structure başlıqlı Təbrik yaradıldı')])[1]")
    public WebElement congratStrucNotSelect;
    @FindBy(xpath = "(//p[contains(.,'Congratulations according to the public open başlıqlı Təbrik yaradıldı')])[1]")
    public WebElement congratPublicOpenNotSelect;
    @FindBy(xpath = "//p[contains(.,'Congratulations according to the public open')]")
    public WebElement congratPublicOpenSelect;
    @FindBy(xpath = "(//p[contains(.,' TestElanForStructure başlıqlı Elan yaradıldı ')])[1]")
    public WebElement announcemenStrutNotSelect;
    @FindBy(xpath = "(//p[contains(.,' TestElanForPublicOpen başlıqlı Elan yaradıldı ')])[1]")
    public WebElement announcemenPublicOpenNotSelect;
    @FindBy(xpath = "//span[text()='TestElanForPerson başlıqlı Elan yaradıldı']")
    public WebElement announcementNotCheck;
    @FindBy(xpath = "//mat-card-header[@class='mat-mdc-card-header header']")
    public WebElement congratsNotCheck;
    @FindBy(xpath = "//span[text()='TestElanForStructure başlıqlı Elan yaradıldı']")
    public WebElement announcemenStructNotCheck;
    @FindBy(xpath = "//span[text()='TestElanForPublicOpen başlıqlı Elan yaradıldı']")
    public WebElement announcemenPublicOpenNotCheck;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']")
    public WebElement announModalExcist;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
    public WebElement announCloseNote;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
    public WebElement congratsCloseNote;
    @FindBy(xpath = "(//span[@class='mdc-list-item__content'])[4]")
    public WebElement announTabSideBar;
    @FindBy(xpath = "//h5[contains(.,'TestElanForPerson')]")
    public WebElement checkHeadNAmeAn;
    @FindBy(xpath = "//h5[contains(.,'Congratulations according to the addressees')]")
    public WebElement checkHeadNAmeCong;
    @FindBy(xpath = "//h5[contains(.,'Congratulations according to the structure')]")
    public WebElement checkHeadStruceCong;
    @FindBy(xpath = "//h5[contains(.,'Congratulations according to the public open')]")
    public WebElement checkHeadPulicCong;
    @FindBy(xpath = "//span[contains(., 'Təbriklər')]")
    public WebElement congratstab;
    @FindBy(xpath = "//span[contains(., 'Congratulations according to the public open')]")
    public WebElement congracheckHeadNAme;
    @FindBy(xpath = "//h5[contains(.,'TestElanForStructure')]")
    public WebElement checkHeadNAmeStr;
    @FindBy(xpath = "//h5[contains(.,'TestElanForPublicOpen')]")
    public WebElement checkHeadPublic;
    @FindBy(xpath = "//p[contains(.,'Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur.')]")
    public WebElement checkDescAn;
    @FindBy(xpath = "//p[contains(.,'Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process.')]")
    public WebElement checkDescCong;
    @FindBy(xpath = "//p[contains(.,'Maraqlı məlumatlar')]")
    public WebElement checkTypeAn;
    @FindBy(xpath = "//a[@class='source-link ng-star-inserted']")
    public WebElement checkUrlAn;
    @FindBy(xpath = "//img[@class='ng-star-inserted']")
    public WebElement checkPictureAn;
    @FindBy(xpath = "//div[@class='gallery-wrapper ng-star-inserted']")
    public WebElement checkVideoAn;
    @FindBy(xpath = "//div[@class='container position-relative z-index-1 pt-5 mt-5']")
    public WebElement checkurlLink;
    @FindBy(xpath = "//p[text()='TestElanForPerson']")
    public WebElement checkForDeleteForPerson;
    @FindBy(xpath = "//p[text()='Congratulations according to the addressees']")
    public WebElement checkForDeleteForPersonCongrat;
    @FindBy(xpath = "//p[text()='Congratulations according to the structure']")
    public WebElement checkForDeleteForStructureCongrat;
    @FindBy(xpath = "//p[text()='TestElanForStructure']")
    public WebElement checkForDeleteForStructure;
    @FindBy(xpath = "//span[text()='Sil']")
    public WebElement deleteForPerson;
    @FindBy(xpath = "//span[normalize-space()='Bəli']")
    public WebElement yesDeleteForPerson;
    @FindBy(xpath = "//p[text()='Elanlar']")
    public WebElement autorizationAnn;
    @FindBy(xpath = "(//div[contains(@class,'post-content')]//h6)[1]")
    public WebElement announcmentNameAdmin;
    @FindBy(xpath = "//div[@class='main-texts']//h5")
    public WebElement announcementNameSideBar;
    @FindBy(xpath = "(//div[contains(@class,'post-content')]//p)[1]")
    public WebElement announcementDescriptionAdmin;
    @FindBy(xpath = "//div[@class='ql-editor']//p")
    public WebElement announcementDescriptionLeftSideBar;
    @FindBy(xpath = "(//div[contains(@class,'post-item')]//div[contains(@class,'datetime')]/p[1])[1]")
    public WebElement announcementDateAdmin;
    @FindBy(xpath = "(//div[contains(@class,'post-item')]//div[contains(@class,'datetime')]/p[2])[1]")
    public WebElement announcementTimeAdmin;
    @FindBy(xpath = "//img[contains(@class,'main-image')]")
    public WebElement announcementMainPictureCheck;
    @FindBy(xpath = "//div[contains(@class,'meta-info')]//p[starts-with(normalize-space(.), 'Elanın tipi')]/strong")
    public WebElement announcementTypeCheck;
    @FindBy(xpath = "//div[contains(@class,'meta-info')]//p[starts-with(normalize-space(.), 'Təbrikin tipi')]/strong")
    public WebElement congratsTypeCheck;
    @FindBy(xpath = "(//div[@class='texts']//p)[1]")
    public WebElement announcementDataTimeCheck;
    @FindBy(xpath = "//img[@alt='Video' and contains(@src,'img.youtube.com')]")
    public WebElement announcementVideoCheck;
    @FindBy(xpath = "//div[contains(@class,'external-url')]//a[contains(@class,'source-link')]")
    public WebElement announcementUrlCheck;
    @FindBy(xpath = "//span[text()='Bağla']")
    public WebElement closeNoteWindow;
    @FindBy(xpath = "(//ul[contains(@class, 'notification-list')]//li)[1]")
    public WebElement firstNote;
    @FindBy(xpath = "//div[contains(@class,'mat-mdc-dialog-surface')]")
    public WebElement announcementModalWindow;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']//h5")
    public WebElement announceNameModalCheck;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']//p")
    public WebElement announceDescModalCheck;
    @FindBy(css = "img.post-img")
    public WebElement imgCheckModal;
    @FindBy(xpath = "//span[normalize-space()='Sil']")
    public WebElement deleteBtn;
    @FindBy(xpath = "//span[text()='Düzəliş et']")
    public WebElement editAnnouncement;
    @FindBy(xpath = "//h6[normalize-space()='Təbriklər']")
    public WebElement congratsTabSideBar;

}