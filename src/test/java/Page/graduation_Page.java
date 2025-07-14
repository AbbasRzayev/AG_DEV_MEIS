package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class graduation_Page {
    public  graduation_Page(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "(//div[@class='toggle-thumb'])[1]")
    public WebElement adminApprovalSwitcher;
    @FindBy(xpath = "(//div[@class='toggle-thumb'])[2]")
    public  WebElement currentAccountStatusSwticher;
    @FindBy(xpath = "//span[normalize-space()='Yadda saxla']")
    public  WebElement saveChangesBtn;
    @FindBy(xpath = "//input[@formcontrolname='vacationStartDate']")
    public  WebElement graduationTodayDate;
    @FindBy(xpath = "//input[@formcontrolname='vacationEndDate']")
    public  WebElement graduationLastDate;
    @FindBy(xpath = "(//td[@role='cell'])[5]")
    public  WebElement adminApprovalResultTable;
    @FindBy(xpath = "(//td[@role='cell'])[6]")
    public  WebElement currentAccountResultTable;
    @FindBy(xpath = "//textarea[@formcontrolname='deactivationNote']")
    public  WebElement graduationNote;

}