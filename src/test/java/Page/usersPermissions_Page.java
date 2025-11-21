package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class usersPermissions_Page {
    public usersPermissions_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[contains(., ' Bütün əməliyyatların aparılması ')]")
    public WebElement allPermissions;
    @FindBy(xpath = "//label[contains(., ' Bütün istifadəçilərlə əməliyyatların aparılması ')]")
    public WebElement usersAllOperations;
    @FindBy(xpath = "(//span[contains(., 'Yadda saxla')])[2]")
    public WebElement saveAllChangesBtn;
    @FindBy(xpath = "//span[text()='Bu şəxsin adından sistemə giriş etmək']")
    public WebElement enterWithNameUser;
    @FindBy(xpath = "//span[text()='İdarəetmə']")
    public WebElement adminPanelBtn;
    @FindBy(xpath = "//label[contains(.,' Şəxsin adından sistemə giriş etmək ')]")
    public WebElement logWithUserName;
    @FindBy(xpath = "//label[contains(.,' Strukturda əməliyyatların aparılması ')]")
    public WebElement sturctireAndDutyCheck;
    @FindBy(xpath = "//label[contains(.,' Təyin edilmiş proqramlardan istifadə ')]")
    public WebElement programUseCheck;
    @FindBy(xpath = "//label[contains(.,' Elanlar modulunun idarə edilməsi ')]")
    public WebElement elanCheck;
    @FindBy(xpath = "//label[contains(.,' Yardım masası modulunun idarəedilməsi ')]")
    public WebElement proqITSpecCheck;
    @FindBy(xpath = "//label[contains(.,' Proqramçı & IT mütəxəssis ')]")
    public WebElement proqITHelpSpecCheck;
    @FindBy(xpath = "//label[contains(.,' İdea bankı modulunun idarə edilməsi ')]")
    public WebElement ideaCheck;
    @FindBy(xpath = "//label[contains(.,' Təqvimə baxış imkanı ')]")
    public WebElement calendarCheck;
    @FindBy(xpath = "//label[contains(.,' Təqvim modulunun idarəedilməsi ')]")
    public WebElement calenEditCheck;
    @FindBy(xpath = "//label[contains(.,' Yardım masası modulunun idarəedilməsi ')]")
    public WebElement helpDeskEditCheck;
    @FindBy(xpath = "//label[contains(.,'Yardım masasına göndərilən müraciətlərə baxış')]")
    public WebElement helpDeskVisionCheck;
    @FindBy(xpath = "//label[contains(.,' Təlimlər moduluna baxış ')]")
    public WebElement studyVisionCheck;
    @FindBy(xpath = "//label[contains(.,' Təlimlər modulunun idarə edilməsi ')]")
    public WebElement studyEditCheck;
    @FindBy(xpath = "//label[contains(.,' Təbriklər modulunun idarə edilməsi ')]")
    public WebElement congratsCheck;
    @FindBy(xpath = "//label[contains(.,' Hüquqi baza modulunun idarə edilməsi ')]")
    public WebElement bazaCheck;
    @FindBy(xpath = "//label[contains(.,' Proqramlar modulunun idarə edilməsi ')]")
    public WebElement programEditCheck;
    @FindBy(xpath = "//label[contains(.,' Faydalı məlumatlar moduluna baxış ')]")
    public WebElement usefullCheck;
    @FindBy(xpath = "//label[contains(.,' Elektron jurnallara baxış ')]")
    public WebElement electronicJournal;
    @FindBy(xpath = "//label[contains(.,' Elektron jurnalların idarə edilməsi ')]")
    public WebElement electronicJournalEdit;
    @FindBy(xpath = "//label[contains(.,' Faydalı məlumatlar modulunun idarə edilməsi ')]")
    public WebElement usefullEditCheck;
    @FindBy(xpath = "//p[contains(.,'Proqramlarım')]")
    public WebElement mainProg;
    @FindBy(xpath = "//p[contains(.,'Elan və təbriklər')]")
    public WebElement mainAnnouncements;
    @FindBy(xpath = "//p[contains(.,'İdea bankı')]")
    public WebElement mainIdea;
    @FindBy(xpath = "//p[contains(.,'Hüquqi baza')]")
    public WebElement mainLegalBasis;
    @FindBy(xpath = "//p[contains(.,'Elektron kitabxana')]")
    public WebElement mainElectronLibrary;
    @FindBy(xpath = "//p[contains(.,'Təqvim')]")
    public WebElement mainCal;
    @FindBy(xpath = "//p[contains(.,'İdarəetmə')]")
    public WebElement mainAdminPanel;
    @FindBy(xpath = "//p[contains(.,'Yardım masası')]")
    public WebElement mainHelpDesk;
    @FindBy(xpath = "//p[contains(.,'Çıxış')]")
    public WebElement mainExit;

    //LeftSideBare
    @FindBy(xpath = "(//span[contains(.,'Əsas səhifə')])[1]")
    public WebElement leftMain;
    @FindBy(xpath = "(//span[contains(.,'Şəxsi kabinetim')])[1]")
    public WebElement leftPer;
    @FindBy(xpath = "(//span[contains(.,'Proqramlarım')])[1]")
    public WebElement leftProq;
    @FindBy(xpath = "(//span[contains(.,'Elan və təbriklər')])[1]")
    public WebElement leftElm;
    @FindBy(xpath = "(//span[contains(.,'Fikir bankı')])[1]")
    public WebElement leftIdea;
    @FindBy(xpath = "(//span[contains(.,'Hüquqi baza')])[1]")
    public WebElement leftBaza;
    @FindBy(xpath = "(//span[contains(.,'Elektron kitabxana')])[1]")
    public WebElement leftELecLibary;


    @FindBy(xpath = "(//span[contains(.,'Təqvim')])[1]")
    public WebElement leftcal;
    @FindBy(xpath = "(//span[contains(.,'İdarəetmə')])[1]")
    public WebElement leftAdmin;
    @FindBy(xpath = "(//span[contains(.,'Yardım masası')])[1]")
    public WebElement leftHelp;
    @FindBy(xpath = "(//span[contains(.,'Çıxış')])[1]")
    public WebElement leftExit;
    @FindBy(xpath = "//span[contains(.,'İstifadəçilər')]")
    public WebElement adminUsers;
    @FindBy(xpath = "//span[contains(.,'Şablonlar')]")
    public WebElement adminShablon;
    @FindBy(xpath = "//span[contains(.,'Proqramlar')]")
    public WebElement adminProqram;
    @FindBy(xpath = "//span[contains(.,'Struktur və vəzifə')]")
    public WebElement adminStrukturDuty;
    @FindBy(xpath = "//span[contains(.,'Elanlar')]")
    public WebElement adminElan;
    @FindBy(xpath = "//span[text()='Elektron jurnal']")
    public WebElement adminElectronJournal;
    @FindBy(xpath = "//span[text()='Faydalı məlumatlar']")
    public WebElement adminUsefulInfor;
    @FindBy(xpath = "//span[contains(.,'Təbriklər')]")
    public WebElement adminCongrats;
    @FindBy(xpath = "//span[contains(.,'İdea bankı')]")
    public WebElement adminIdea;
    @FindBy(xpath = "//span[contains(.,'Hüquqi baza')]")
    public WebElement adminBaza;
    @FindBy(xpath = "//h6[contains(.,'Elanlar')]")
    public WebElement announceTittle;
    @FindBy(xpath = "//span[contains(.,'Elektron kitabxana')]")
    public WebElement adminElectrLibary;
    @FindBy(xpath = "//span[contains(.,'Təlim materialları')]")
    public WebElement adminElectrLibaryStudy;
    @FindBy(xpath = "//span[contains(.,'Təqvim')]")
    public WebElement adminCal;
    @FindBy(xpath = "//span[contains(.,'Yardım masası')]")
    public WebElement adminHelpDesk;
    @FindBy(xpath = "//span[contains(.,'Soraqçalar')]")
    public WebElement adminQuestionnaires;
}