package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class leftSIdeBarMenu_Page {
    public leftSIdeBarMenu_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[.//mat-icon[text()=\"menu\"]]")
    public WebElement leftSideBarBtn;
    @FindBy(xpath = "//span[text()='Əsas səhifə']")
    public WebElement mainPage;
    @FindBy(xpath = "//span[text()='Şəxsi kabinetim']")
    public WebElement personalCabinet;
    @FindBy(xpath = "//span[text()='Proqramlarım']")
    public WebElement programs;
    @FindBy(xpath = "//span[text()='Elan və təbriklər']")
    public WebElement congrats;
    @FindBy(xpath = "//span[text()='İdea bankı']")
    public WebElement idea;
    @FindBy(xpath = "//span[text()='Hüquqi baza']")
    public WebElement base;
    @FindBy(xpath = "//span[text()='Elektron kitabxana']")
    public WebElement libery;
    @FindBy(xpath = "//span[text()='Təqvim']")
    public WebElement calendar;
    @FindBy(xpath = "//span[text()='İdarəetmə']")
    public WebElement adminpanel;
    @FindBy(xpath = "//span[text()='Yardım masası']")
    public WebElement helpDesk;
    @FindBy(xpath = "//span[text()='Çıxış']")
    public WebElement logOut;
    @FindBy(xpath = "//h1[@class='title']")
    public WebElement mainLogo;
    @FindBy(xpath = "//h5[text()='Proqramlarım']")
    public WebElement progLogo;
    @FindBy(xpath = "//h5[text()='İdea bankı']")
    public WebElement ideaLogo;
    @FindBy(xpath = "//h5[text()='Hüquqi baza']")
    public WebElement baseLogo;
    @FindBy(xpath = "//h5[text()=\"Təlim materialları\"]")
    public WebElement libaryLogo;
    @FindBy(xpath = "//h5[text()='İdarəetmə - İstifadəçilər']")
    public WebElement adminLogo;
    @FindBy(xpath = "//h5[text()='Yardım masası - Yeni müraciət']")
    public WebElement helpDeskLogo;
    @FindBy(xpath = "//span[text()=\" Bəli \"]")
    public WebElement yesBtn;
}