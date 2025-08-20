package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class changePassword_Page {
    public changePassword_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@alt='Şəxsi kabinetim']")
    public WebElement personalCabinet;
    @FindBy(xpath = "//span[contains(text(), \"Şifrəni dəyiş\")]")
    public WebElement changePasswordTab;
    @FindBy(xpath = "//input[@name='oldPassword']")
    public WebElement oldPassword;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement newPassword;
    @FindBy(xpath = "//input[@name='repeatPassword']")
    public WebElement repeatNewPassword;
    @FindBy(xpath = "//span[contains(text(), \" Yadda saxlayın \")]")
    public WebElement subPassword;
    @FindBy(xpath = "//button[@disabled='true']")
    public WebElement disabledLoc;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
    public WebElement openNew;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[7]")
    public WebElement openReapet;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[5]")
    public WebElement openOld;
}