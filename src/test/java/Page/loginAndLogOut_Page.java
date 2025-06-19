package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class loginAndLogOut_Page {
    public loginAndLogOut_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//span[contains(.,'Daxil ol')]")
    public WebElement enterToTheSystem;

    @FindBy(xpath = "//mat-icon[normalize-space(text())='logout']")
    public WebElement exitBtn;

    @FindBy(xpath = "//span[text()=' Bəli ']")
    public WebElement yesExit;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
    public WebElement personalCabinetBtn;

    @FindBy(xpath = "//span[text()='Çıxış']")
    public WebElement personalCabinetExitBtn;
}