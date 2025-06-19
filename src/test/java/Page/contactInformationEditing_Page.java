package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class contactInformationEditing_Page {
    public contactInformationEditing_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Əlaqə məlumatları']")
    public WebElement contacInfoTab;
    @FindBy(xpath = "//span[text()=' Redaktə et ']")
    public WebElement editBTn;
    @FindBy(id = "mat-input-5")
    public WebElement roomField;
    @FindBy(id = "mat-input-6")
    public WebElement ipPhoneField;
    @FindBy(id = "mat-input-7")
    public WebElement stasNumField;
    @FindBy(id = "mat-input-8")
    public WebElement mobNumField;
    @FindBy(id = "mat-input-9")
    public WebElement userCompField;
    @FindBy(id = "mat-input-10")
    public WebElement LDAPfield;
    @FindBy(xpath = "//span[text()='Yadda saxla']")
    public WebElement saveBtn;
    @FindBy(xpath = "(//div[@class='field']/p)[1]")
    public WebElement actualRoom;
    @FindBy(xpath = "(//div[@class='field']/p)[2]")
    public WebElement actualIp;
    @FindBy(xpath = "(//div[@class='field']/p)[3]")
    public WebElement actualStasNum;
    @FindBy(xpath = "(//div[@class='field']/p)[4]")
    public WebElement actualMob;
    @FindBy(xpath = "(//div[@class='field']/p)[6]")
    public WebElement actualPC;
    @FindBy(xpath = "(//div[@class='field']/p)[7]")
    public WebElement actualLDAP;
    @FindBy(xpath = "//td[text()='Abbas Rzayev']")
    public WebElement foundedUser;
    @FindBy(id = "mat-input-8")
    public WebElement adminName;
    @FindBy(id = "mat-input-9")
    public WebElement adminSurname;
    @FindBy(xpath = "//input[@formcontrolname='patronymic']")
    public WebElement adminFathersName;
    @FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
    public WebElement birthDate;
    @FindBy(xpath = "//button[@aria-label='14 aprel 1988']")
    public WebElement birthdaySelectFirst;
    @FindBy(xpath = "//button[@aria-label='22 aprel 1988']")
    public WebElement birthdaySelectSecond;

    @FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
    public WebElement validityPeriod;
    @FindBy(xpath = "//button[@aria-label='7 oktyabr 2030']")
    public WebElement validitySelectFirst;
    @FindBy(xpath = "//button[@aria-label='29 oktyabr 2030']")
    public WebElement validitySelectSecond;


    @FindBy(id = "mat-input-13")
    public WebElement adminRoom;
    @FindBy(id = "mat-input-14")
    public WebElement adminIp;
    @FindBy(id = "mat-input-15")
    public WebElement adminStas;
    @FindBy(id = "mat-input-16")
    public WebElement adminMob;
    @FindBy(id = "mat-input-17")
    public WebElement adminUserPc;
    @FindBy(id = "mat-input-18")
    public WebElement adminEmail;
    @FindBy(id = "(//div[@class='field-preview ng-star-inserted']/p)[1]")
    public WebElement adminActualName;
    @FindBy(id = "(//div[@class='field-preview ng-star-inserted']/p)[2]")
    public WebElement adminActualSurname;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[5]")
    public WebElement adminActualFathersName;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[6]")
    public WebElement adminActualBirthDate;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[8]")
    public WebElement adminActualVerifyDate;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[9]")
    public WebElement adminActualRoom;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[10]")
    public WebElement adminActualIp;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[11]")
    public WebElement adminActualStas;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[12]")
    public WebElement adminActualMob;
    @FindBy(xpath = "(//div[@class='field-preview ng-star-inserted']/p)[13]")
    public WebElement adminActualEmail;
    @FindBy(xpath = "//span[text()=' Redaktə et ']")
    public WebElement editBTnAdmin;

}