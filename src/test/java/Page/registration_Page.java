package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class registration_Page {
    public registration_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()=' Yeni istifadəçi ']")
    public WebElement newUserButton;
    @FindBy(id = "mat-input-2")
    public WebElement finRegField;
    @FindBy(id = "mat-input-3")
    public WebElement serialNumField;
    @FindBy(id = "mat-input-4")
    public WebElement emailField;
    @FindBy(id = "mat-mdc-checkbox-1-input")
    public WebElement domenCheckboxs;
    @FindBy(xpath = "//span[normalize-space()='Növbəti']")
    public WebElement firstNextButton;
    @FindBy(id = "mat-input-5")
    public WebElement regNameField;
    @FindBy(id = "mat-input-7")
    public WebElement regFatherName;
    @FindBy(id = "mat-input-6")
    public WebElement regSurnameField;
    @FindBy(id = "mat-input-8")
    public WebElement regBirthData;
    @FindBy(id = "mat-input-9")
    public WebElement regLastData;
    @FindBy(id = "mat-input-10")
    public WebElement regAddress;
    @FindBy(id = "mat-input-18")
    public WebElement regNewPass;
    @FindBy(id = "mat-input-19")
    public WebElement regRepPass;
    @FindBy(id = "mat-input-11")
    public WebElement regRoom;
    @FindBy(id = "mat-input-12")
    public WebElement regIp;
    @FindBy(id = "mat-input-13")
    public WebElement regMob;
    @FindBy(id = "mat-input-14")
    public WebElement regStasNum;
    @FindBy(xpath = "//span[text()=' Növbəti ']")
    public WebElement fourthNext;
    @FindBy(id = "mat-input-16")
    public WebElement regDuty;
    @FindBy(xpath = "//div[text()=' QA_AT ']")
    public WebElement regQA;
    @FindBy(xpath = "//h6[text()='AISTGroup MMC']")
    public WebElement regStructure;
    @FindBy(xpath = "//input[@placeholder='Təlimatlandırılan şəxs']")
    public WebElement instructorSelect;
    @FindBy(id = "mat-input-21")
    public WebElement regSearchInstructor;
    @FindBy(xpath = "//div[text()=' Abbas Rzayev ']")
    public WebElement addInsttructor;
    @FindBy(xpath = "//span[text()='Qeydiyyatı tamamla']")
    public WebElement confirmButton;
    @FindBy(id = "identifierId")
    public WebElement googleEmail;

    @FindBy(xpath = "//span[text()='Next']")
    public WebElement googleNextButton;
    @FindBy(xpath = "//input[@type='image']")
    public WebElement enterToTheMail;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement googlepasswordField;
    @FindBy(xpath = "//input[@name='secretkey']")
    public WebElement mailAzPasswordField;

    @FindBy(xpath = "//div[@role='checkbox']")
    public WebElement googleChechboxs;
    @FindBy(xpath = "//div[@act='10']")
    public WebElement googleDeletebutton;
    @FindBy(xpath = "//input[@id='code']")
    public WebElement addCodeInput;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    public WebElement searchButton;

    @FindBy(xpath = "//td[normalize-space()='Musab İyad']")
    public WebElement foundedUser;
    @FindBy(xpath = "//h6[text()='Heç bir nəticə tapılmadı.']")
    public WebElement noResult;

    @FindBy(xpath = "//span[text()='Səlahiyyətləri']")
    public WebElement userPermissionsTab;
    @FindBy(xpath = "//label[text()='İnzibatçının təsdiqi']")
    public WebElement instructorConfirm;
    @FindBy(xpath = "//label[text()='Hesabın cari statusu']")
    public WebElement currrentStatus;

    @FindBy(xpath = "//label[text()=' Bütün əməliyyatların aparılması ']")
    public WebElement selectAllPremissons;

    @FindBy(xpath = "(//div[@class='action__buttons']//span[@class='mdc-button__label'])[1]")
    public WebElement saveChanges;
    @FindBy(xpath = "(//span[text()='Dəyişiklikləri yadda saxla'])[2]")
    public WebElement savePrem;
    @FindBy(xpath = "//span[text()='İstifadəçini arxivləşdir']")
    public WebElement archiveUser;
    @FindBy(xpath = "//span[normalize-space()='Bəli']")
    public WebElement yesArchiveUser;
    @FindBy(id = "mat-input-8")
    public WebElement agnameField;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[11]")
    public WebElement closeModalWindow;
    @FindBy(xpath = "//td[normalize-space()='Abbas Zamanov']")
    public WebElement zamanovCheckTab;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[1]")
    public WebElement checkPersonalPin;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[2]")
    public WebElement checkPersonalSerialNumber;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[3]")
    public WebElement checkPersonalName;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[4]")
    public WebElement checkPersonalSurname;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[5]")
    public WebElement checkPersonalFatherName;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[6]")
    public WebElement checkPersonalBirthData;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[7]")
    public WebElement checkPersonalGender;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[8]")
    public WebElement checkPersonalValidData;
    @FindBy(xpath = "(//span[text()='Otaq']/following-sibling::p)")
    public WebElement checkPersonalRoom;
    @FindBy(xpath = "(//span[text()='İp telefon nömrəsi']/following-sibling::p)")
    public WebElement checkPersonalIp;
    @FindBy(xpath = "(//span[text()='İP telefon nömrəsi']/following-sibling::p)")
    public WebElement checkPersonalIP;
    @FindBy(xpath = "(//span[text()='Stasionar nömrə']/following-sibling::p)")
    public WebElement checkPersonalStatNum;
    @FindBy(xpath = "(//span[text()='Mobil nömrə']/following-sibling::p)")
    public WebElement checkPersonalMobileNumber;
    @FindBy(xpath = "(//span[text()='Email']/following-sibling::p)")
    public WebElement checkPersonalEmail;
    @FindBy(xpath = "(//span[text()='Elektron poçt']/following-sibling::p)")
    public WebElement checkPersonalEMAIL;
    @FindBy(xpath = "(//span[text()='İstifadəçi komputeri']/following-sibling::p)")
    public WebElement checkPersonalComputer;

    @FindBy(xpath = "(//span[text()='Ad']/following-sibling::p)")
    public WebElement checkPersonalNameInfo;
    @FindBy(xpath = "(//span[text()='Soyad']/following-sibling::p)")
    public WebElement checkPersonalSurnameInfo;
    @FindBy(xpath = "(//span[text()='Ata adı']/following-sibling::p)")
    public WebElement checkPersonalFatherNameInfo;
    @FindBy(xpath = "(//span[text()='Cins']/following-sibling::p)")
    public WebElement checkPersonalGenderInfo;
    @FindBy(xpath = "(//span[text()='FİN']/following-sibling::p)")
    public WebElement checkPersonalPinInfo;
    @FindBy(xpath = "(//span[text()='SV seriya və nömrəsi']/following-sibling::p)")
    public WebElement checkPersonalSerialNumInfo;
    @FindBy(xpath = "(//span[text()='Doğum tarixi']/following-sibling::p)")
    public WebElement checkPersonalBirthDataInfo;
    @FindBy(xpath = "(//span[text()='Etibarlılıq']/following-sibling::p)")
    public WebElement checkPersonalValidInfo;

    @FindBy(xpath = "//span[normalize-space()='Redaktə et']")
    public WebElement personalInfoEdit;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement nameEdit;
    @FindBy(xpath = "//input[@formcontrolname='surname']")
    public WebElement surNameEdit;
    @FindBy(xpath = "//input[@formcontrolname='patronymic']")
    public WebElement fatherNameEdit;
    @FindBy(xpath = "//input[@formcontrolname='dateOfBirthStr']")
    public WebElement birthDataEdit;
    @FindBy(xpath = "//input[@formcontrolname='pin']")
    public WebElement piNEdit;
    @FindBy(xpath = "//input[@formcontrolname='docNumber']")
    public WebElement serialNumberEdit;
    @FindBy(xpath = "//input[@formcontrolname='expirationDate']")
    public WebElement validDataEdit;
    @FindBy(xpath = "//input[@formcontrolname='innerPhone']")
    public WebElement roomEdit;
    @FindBy(xpath = "//input[@formcontrolname='ipPhone']")
    public WebElement ipEdit;
    @FindBy(xpath = "//input[@formcontrolname='stationaryNumber']")
    public WebElement statEdit;
    @FindBy(xpath = "//input[@formcontrolname='mobileNumber']")
    public WebElement mobileEdit;
    @FindBy(xpath = "//input[@formcontrolname='computerName']")
    public WebElement userCompEdit;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement emailEdit;
    @FindBy(xpath = "//span[normalize-space()='Yadda saxla']")
    public WebElement saveAfterEdit;
    @FindBy(xpath = "(//div[@class='toggle-switch'])[1]")
    public WebElement adminPerToggle;
    @FindBy(xpath = "//div[@class='toggle-switch']")
    public WebElement statusToggle;
    @FindBy(xpath = "//label[normalize-space()='Bütün əməliyyatların aparılması']")
    public WebElement allPermission;
    @FindBy(xpath = "(//span[normalize-space()='Yadda saxla'])[1]")
    public WebElement saveRights;
    @FindBy(xpath = "(//span[normalize-space()='Yadda saxla'])[2]")
    public WebElement savePermission;
    @FindBy(xpath = "//td[contains(@class,'cdk-column-isConfirmedByAdmin')]//mat-icon")
    public WebElement adminControlIcon;
    @FindBy(xpath = "//td[contains(@class,'cdk-column-statusType')]//mat-icon")
    public WebElement statusIcon;
    @FindBy(xpath = "//span[text()='ŞV-məlumatları']")
    public WebElement personalInfoInThePersonalCabinet;
    @FindBy(xpath = "//span[text()='Əlaqə məlumatları']")
    public WebElement connectInfoInThePersonalCabinet;
}