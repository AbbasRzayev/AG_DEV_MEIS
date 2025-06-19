package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class usersPermissions_Page {
    public usersPermissions_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    ;

    @FindBy(xpath = "//label[contains(., ' Bütün əməliyyatların aparılması ')]")
    public WebElement allPermissons;
    @FindBy(xpath = "//label[contains(., ' Bütün istifadəçilərlə əməliyyatların aparılması ')]")
    public WebElement usersAllOperations;
    @FindBy(xpath = "(//span[contains(., 'Dəyişiklikləri yadda saxla')])[2]")
    public WebElement saveAllChangesBtn;
    @FindBy(xpath = "//mat-list-item[@aria-describedby='cdk-describedby-message-ng-1-55']//span[@class='mat-mdc-list-item-unscoped-content']")
    public WebElement exitBTn;
    @FindBy(xpath = "//span[text()='Bəli']")
    public WebElement yesBTn;
    @FindBy(xpath = "//span[text()='Bu şəxsin adından sistemə giriş etmək']")
    public WebElement enterWithNameUser;
    @FindBy(xpath = "//span[text()='İdarəetmə']")
    public WebElement adminPanelBtn;
    @FindBy(xpath = "//h2[contains(., 'İstifadəçilər')]")
    public WebElement userTittle;
    @FindBy(xpath = "/html/body/app-root/div/app-sidebar/div/aside/div")
    public WebElement leftSideBare;
    @FindBy(xpath = "//label[contains(.,' Şəxsin adından sistemə giriş etmək ')]")
    public WebElement logWithUserName;
    @FindBy(xpath = "//span[contains(.,'Abbas Rzayev')]")
    public WebElement checkUserName;
    @FindBy(xpath = "//span[contains(.,'Struktur və vəzifə')]")
    public WebElement sturctireAndDutyTab;
    @FindBy(xpath = "//label[contains(.,' Strukturda əməliyyatların aparılması ')]")
    public WebElement sturctireAndDutyCheck;
    @FindBy(xpath = "//label[contains(.,' Təyin edilmiş proqramlardan istifadə ')]")
    public WebElement programUseCheck;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-home/div[2]/app-menu-item[3]/div")
    public WebElement mainProqramBtnk;
    @FindBy(xpath = "//span[text()='Proqramlarım']")
    public WebElement leftSideBareProgram;
    @FindBy(xpath = "//h2[contains(., 'Proqramlarım')]")
    public WebElement programTittle;
    @FindBy(xpath = "//label[contains(.,' Elanlar modulunun idarə edilməsi ')]")
    public WebElement elanCheck;
    @FindBy(xpath = "//span[contains(.,'Elanlar')]")
    public WebElement elanAdmin;
    @FindBy(xpath = "//span[contains(.,'Təbriklər')]")
    public WebElement tebrikAdmin;
    @FindBy(xpath = "//span[contains(.,'Soraqçalar')]")
    public WebElement soraqAdmin;
    @FindBy(xpath = "//label[contains(.,' Yardım masası modulunun idarəedilməsi ')]")
    public WebElement proqITSpecCheck;
    @FindBy(xpath = "//span[text()='Yardım masası']")
    public WebElement helpAdminFlash;
    @FindBy(xpath = "(//span[text()='Yardım masası'])[2]")
    public WebElement helpAdminFlash2;
    @FindBy(xpath = "//label[contains(.,' Fikir bankı modulunun idarə edilməsi ')]")
    public WebElement ideaCheck;
    @FindBy(xpath = "(//span[contains(.,'Fikir bankı')])[4]")
    public WebElement ideaAdmin;
    @FindBy(xpath = "//span[@class='mdc-tab__text-label']")
    public WebElement ideaSoraq;
    @FindBy(xpath = "//p[contains(.,'Təqvim')]")
    public WebElement mainCalendar;
    @FindBy(xpath = "(//span[contains(.,'Təqvim')])[3]")
    public WebElement leftSideCalendar;
    @FindBy(xpath = "(//span[contains(.,'Təqvim')])[4]")
    public WebElement adminCalendar;
    @FindBy(xpath = "//label[contains(.,' Təqvimə baxış imkanı ')]")
    public WebElement calendarCheck;
    @FindBy(xpath = "//label[contains(.,' Təqvim modulunun idarəedilməsi ')]")
    public WebElement calenEditCheck;
    @FindBy(xpath = "//label[contains(.,' Yardım masası modulunun idarəedilməsi ')]")
    public WebElement helpDeskEditCheck;
    @FindBy(xpath = "(//span[contains(.,'Yardım masası')])[4]")
    public WebElement helpDeskAdmin;
    @FindBy(xpath = "//label[contains(.,'Yardım masasına göndərilən müraciətlərə baxış')]")
    public WebElement helpDeskVisionCheck;
    @FindBy(xpath = "//h2[contains(.,'Yardım masası')]")
    public WebElement helpDeskVisionAdin;
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
    @FindBy(xpath = "//label[contains(.,' Faydalı məlumatlar modulunun idarə edilməsi ')]")
    public WebElement usefullEditCheck;
    @FindBy(xpath = "//span[contains(.,'Təlim materialları')]")
    public WebElement studyAdminFlash;
    @FindBy(xpath = "(//span[contains(.,'Elektron kitabxana')])[1]")
    public WebElement elanSideBare;
    @FindBy(xpath = "//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple']")
    public WebElement newUsefull;
    @FindBy(xpath = "//span[contains(.,'Təbriklər')]")
    public WebElement congratAdmin;
    @FindBy(xpath = "(//span[contains(.,'Hüquqi baza')])[4]")
    public WebElement bazaAdmin;
    @FindBy(xpath = "//span[contains(.,'Şablonlar')]")
    public WebElement shablonAdmin;
    @FindBy(xpath = "(//span[contains(.,'Proqramlar')])")
    public WebElement proqAdmin;
    @FindBy(xpath = "//span[contains(.,'Elektron kitabxana')]")
    public WebElement electronBookLeftside;
    @FindBy(xpath = "(//span[contains(.,'Faydalı məlumatlar')])[1]")
    public WebElement usefullFlash;
    @FindBy(xpath = "//a[@class='mat-ripple ng-star-inserted']//span[contains(.,'Elektron kitabxana')]")
    public WebElement electronBookAdmin;
    @FindBy(xpath = "//span[contains(.,' Faydalı məlumat əlavə et ')]")
    public WebElement usefullAddBtn;
    @FindBy(xpath = "//p[contains(.,'Əsas səhifə')]")
    public WebElement mainEsas;
    @FindBy(xpath = "//p[contains(.,'Şəxsi kabinetim')]")
    public WebElement mainPersonalCab;
    @FindBy(xpath = "//p[contains(.,'Proqramlarım')]")
    public WebElement mainProg;
    @FindBy(xpath = "//p[contains(.,'Elan və təbriklər')]")
    public WebElement mainElan;
    @FindBy(xpath = "//p[contains(.,'Fikir bankı')]")
    public WebElement mainFikir;
    @FindBy(xpath = "//p[contains(.,'Hüquqi baza')]")
    public WebElement mainBaza;
    @FindBy(xpath = "//p[contains(.,'Elektron kitabxana')]")
    public WebElement mainElectronBook;
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

//    @FindBy(xpath = "(//span[contains(.,'Hüquqi baza')])[1]")
//    public WebElement leftELecLibary;
    @FindBy(xpath = "(//span[contains(.,'Təqvim')])[1]")
    public WebElement leftcal;
    @FindBy(xpath = "(//span[contains(.,'İdarəetmə')])[1]")
    public WebElement leftAdmin;
    @FindBy(xpath = "(//span[contains(.,'Yardım masası')])[1]")
    public WebElement leftHelp;
    @FindBy(xpath = "(//span[contains(.,'Çıxış')])[1]")
    public WebElement leftExit;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'İstifadəçilər')]")
    public WebElement adminUsers;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Şablonlar')]")
    public WebElement adminShablon;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Proqramlar')]")
    public WebElement adminProqram;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Struktur və vəzifə')]")
    public WebElement adminStrukturDuty;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Elanlar')]")
    public WebElement adminElan;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Təbriklər')]")
    public WebElement adminCongrats;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Fikir bankı')]")
    public WebElement adminIdea;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Hüquqi baza')]")
    public WebElement adminBaza;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Elektron kitabxana')]")
    public WebElement adminElectrLibary;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Təqvim')]")
    public WebElement adminCal;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Yardım masası')]")
    public WebElement adminHelpDesk;
    @FindBy(xpath = "//div[@class='control_wrapper']//span[contains(.,'Soraqçalar')]")
    public WebElement adminQuestionnaires;
}