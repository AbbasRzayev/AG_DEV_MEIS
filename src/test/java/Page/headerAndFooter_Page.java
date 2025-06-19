package Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class headerAndFooter_Page {
    public headerAndFooter_Page(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//div[@class='mat-ripple hamburger-wrapper ng-tns-c2158961782-6']")
    public WebElement leftSideBarBtn;
    @FindBy(xpath = "/html/body/app-root/div/app-sidebar/div/aside")
    public WebElement leftSideBarBtn2;
    @FindBy(xpath = "/html/body/app-root/div/app-sidebar/div/aside/div")
    public WebElement closeleftSideBar;

    @FindBy(xpath = "//h1[contains(.,'Mərkəzləşdirilmiş Elektron İnformasiya Sistemi')]")
    public WebElement headersText;
    @FindBy(xpath = "//button[@routerlink='/contacts']")
    public WebElement headerContacts;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[2]")
    public WebElement headerNotifaction;
    @FindBy(xpath = "//div[@class='notifications_wrapper']")
    public WebElement closeNote;
    @FindBy(xpath = "//span[@class='fullname']")
    public WebElement headerFullname;
    @FindBy(xpath = "//img[@_ngcontent-ng-c1911744780 and @mattooltip=\"Şəxsi kabinetim\" and @alt=\"toggle\" and @class=\"mat-mdc-tooltip-trigger mat-mdc-menu-trigger avatar\" and @src=\"assets/img/home/user.svg\"]")
    public WebElement headersPersonalCab;
    @FindBy(xpath = "//img[contains(@alt, 'Azərbaycan Respublikasının İqtisadiyyat Nazirliyi yanında Antiinhisar və İstehlak Bazarına Nəzarət Dövlət Xidməti')]")
    public WebElement footerIconFirst;
    @FindBy(xpath = "//body[@class='normal-size']")
    public WebElement footerIconFirstCheck;
    @FindBy(xpath = "(//div[contains(., 'Bütün hüquqlar qorunur')])[4]")
    public WebElement footercopyright;
    @FindBy(xpath = "//img[contains(@alt, 'AISTGroup MMC')]")
    public WebElement footerIconSecond;
    @FindBy(xpath = "/html/body/div[2]/div/section[1]/div")
    public WebElement footerIconSecondCheck;
    @FindBy(xpath = "//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']")
    public WebElement justClick;

}