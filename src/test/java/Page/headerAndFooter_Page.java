package Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class headerAndFooter_Page {
    public headerAndFooter_Page(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//button[.//mat-icon[text()='menu']]")
    public WebElement leftSideBarBtn;
    @FindBy(xpath = "//mat-nav-list[@role='navigation']")
    public WebElement leftSideBarBtn2;
    @FindBy(xpath = "//button[.//mat-icon[text()='close']]")
    public WebElement closeLeftSideBar;

    @FindBy(xpath = "//h1[contains(.,'Mərkəzləşdirilmiş Elektron İnformasiya Sistemi')]")
    public WebElement headersText;
    @FindBy(xpath = "//button[@routerlink='/contacts']")
    public WebElement headerContacts;
    @FindBy(xpath = "//button[@mattooltip='Bildirişlər']")
    public WebElement headerNotifaction;
    @FindBy(xpath = "//div[contains(@class, 'cdk-overlay-backdrop') and contains(@class, 'cdk-overlay-backdrop-showing')]")
    public WebElement closeNote;
    @FindBy(xpath = "//span[@class='fullname']")
    public WebElement headerFullname;
    @FindBy(css = "button[mattooltip='Şəxsi kabinetim']")
    public WebElement personalCabinetHeader;
    @FindBy(xpath = "//span[text()='Şəxsi kabinetim']")
    public WebElement personalCabinetLink;
    @FindBy(xpath = "(//div[contains(., 'Bütün hüquqlar qorunur')])[4]")
    public WebElement footercopyright;
    @FindBy(xpath = "//img[contains(@alt, 'AISTGroup MMC')]")
    public WebElement footerIconSecond;
    @FindBy(xpath = "/html/body/div[2]/div/section[1]/div")
    public WebElement footerIconSecondCheck;

}