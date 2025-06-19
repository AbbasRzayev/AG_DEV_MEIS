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
    @FindBy(id = "mat-input-8")
    public WebElement finRegField;
    @FindBy(id = "mat-input-9")
    public WebElement serialNumField;
    @FindBy(id = "mat-input-10")
    public WebElement emailField;
    @FindBy(id = "mat-input-11")
    public WebElement ldapField;
    @FindBy(id = "mat-mdc-checkbox-1-input")
    public WebElement domenCheckboxs;
    @FindBy(xpath = "//span[text()='Növbəti']")
    public WebElement firstNextButton;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-control/div/app-registration-tab/div/form/app-custom-stepper/section/div/div/div/div[1]/div[1]/div/mat-icon")
    public WebElement photoButton;
    @FindBy(id = "mat-input-12")
    public WebElement regNameField;
    @FindBy(id = "mat-input-14")
    public WebElement regFatherName;
    @FindBy(id = "mat-input-13")
    public WebElement regSurnameField;
    @FindBy(id = "mat-input-15")
    public WebElement regBirthData;
    @FindBy(id = "mat-input-16")
    public WebElement regLastData;
    @FindBy(id = "mat-input-17")
    public WebElement regAdress;
    @FindBy(xpath = "//span[text()='Növbəti']")
    public WebElement secondNextButton;
    @FindBy(id = "mat-input-24")
    public WebElement regNewPass;
    @FindBy(id = "mat-input-25")
    public WebElement regRepPass;
    @FindBy(id = "mat-input-18")
    public WebElement regRoom;
    @FindBy(id = "mat-input-19")
    public WebElement regIp;
    @FindBy(id = "mat-input-20")
    public WebElement regMob;
    @FindBy(id = "mat-input-21")
    public WebElement regStasnum;
    @FindBy(xpath = "//span[text()=' Növbəti ']")
    public WebElement fourthNext;
    @FindBy(id = "mat-input-23")
    public WebElement regDuty;
    @FindBy(xpath = "//span[text()=' İMEM: Direktorun müavini ']")
    public WebElement regDirector;
    @FindBy(xpath = "//label[text()='Antiinhisar və İstehlak Bazarlarına Nəzarət Dövlət Xidməti']")
    public WebElement regStructure;
    @FindBy(xpath = "//span[text()=' Təlimatlandırılan şəxs ']")
    public WebElement instructorSelect;
    @FindBy(id = "mat-input-27")
    public WebElement regSearchInstructor;
    @FindBy(xpath = "//td[contains(text(), 'Abbas Rzayev')]")
    public WebElement addInsttructor;
    @FindBy(xpath = "//span[text()='Qeydiyyatı tamamla']")
    public WebElement confirmButton;
    @FindBy(id = "identifierId")
    public WebElement googleEmail;
    @FindBy(xpath = "//span[text()='Next']")
    public WebElement googleNextButton;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement googlepasswordField;

    @FindBy(id = ":2d")
    public WebElement googleofficeMail;

    @FindBy(xpath = "//div[@role='checkbox']")
    public WebElement googleChechboxs;
    @FindBy(xpath = "//div[@act='10']")
    public WebElement googleDeletebutton;
    @FindBy(xpath = "//input[@id='code']")
    public WebElement addCodeInput;
    @FindBy(xpath = "//span[text()='Təsdiq et']")
    public WebElement confirmCode;
    @FindBy(xpath = "//div[@class='wrapper']")
    //p[@class='text ng-star-inserted']
    public WebElement regFinished;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='sidebar-wrapper ng-tns-c2158961782-4']")
    public WebElement clickOut;
    @FindBy(xpath = "//td[text()='Abbas Zamanov']")
    public WebElement foundedUser;
    @FindBy(xpath = "(//span[@class='mdc-tab__content'])[2]")
    public WebElement userPermisshonsTab;
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
    @FindBy(xpath = "(//div[@class='action__buttons']//span[@class='mdc-button__label'])[2]")
    public WebElement archiveUser;
    @FindBy(xpath = "//span[text()='Bəli']")
    public WebElement yesArchiveUser;
    @FindBy(id = "mat-input-8")
    public WebElement agnameField;

}