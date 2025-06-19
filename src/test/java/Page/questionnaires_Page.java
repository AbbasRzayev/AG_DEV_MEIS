package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class questionnaires_Page {

    public questionnaires_Page() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//span[text()='Soraqçalar']")
    public WebElement questionnairesTab;
    @FindBy(xpath = "//span[text()='Elan tipləri']")
    public WebElement adType;
    @FindBy(xpath = "//span[text()='Elan tipi əlavə et']")
    public WebElement addAdType;
    @FindBy(id = "mat-input-8")
    public WebElement adTypeInput;
    @FindBy(xpath = "//span[text()='Yadda saxla']")
    public WebElement saveBtn;
    @FindBy(xpath = "//td[text()='AutomationTest']")
    public WebElement checkNewAd;
    @FindBy(xpath = "//td[text()='GoodQuality']")
    public WebElement checkEditAd;
    @FindBy(xpath = "//span[text()='Bəli']")
    public WebElement deleteYes;
    @FindBy(id = "mat-input-9")
    public WebElement adTypeInputTwo;

    @FindBy(xpath = "(//span[@class='mdc-tab__text-label'])[2]")
    public WebElement calendar;
    @FindBy(xpath = "//span[text()='Tədbir keçiriləcəyi yerlər']")
    public WebElement places;@FindBy(xpath = "//span[text()='Tədbir kateqoriyaları']")
    public WebElement categoria;
    @FindBy(xpath = "//span[text()='Məkan əlavə et']")
    public WebElement addPlaceBtn;
    @FindBy(xpath = "//span[text()='Kateqoriya əlavə et']")
    public WebElement addCategBtn;
    @FindBy(id= "mat-input-10")
    public WebElement placeInput;
    @FindBy(id= "mat-input-12")
    public WebElement cateInput;
    @FindBy(id= "mat-input-8")
    public WebElement cateInputSecond;
    @FindBy(id= "mat-input-13")
    public WebElement cateInputSec;
    @FindBy(id= "mat-input-11")
    public WebElement placeInputSecond;
    @FindBy(xpath = "//span[text()='Yarat']")
    public WebElement createBtn;
    @FindBy(xpath = "//td[text()='8888 room']")
    public WebElement checkPlace;
    @FindBy(xpath = "//td[contains(text(), 'Work day')]")
    public WebElement checkCat;
    @FindBy(xpath = "//td[contains(text(), 'Friday')]")
    public WebElement checkCatSecond;
    @FindBy(xpath = "//td[text()='9999 room']")
    public WebElement checkEditPlace;
    @FindBy(xpath = "(//span[text()='Təbriklər'])[2]")
    public WebElement congTab;
    @FindBy(xpath = "//span[text()='Təbrik tipləri']")
    public WebElement congOption;
    @FindBy(xpath = "//span[text()='Təbrik tipi əlavə et']")
    public WebElement congAdBtn;
    @FindBy(xpath = "//td[text()='Abbas Təbriklər']")
    public WebElement checkCong;
    @FindBy(id = "mat-input-12")
    public WebElement congInput;
    @FindBy(id = "mat-input-13")
    public WebElement congEditInput;
    @FindBy(xpath = "//td[text()='Never give up']")
    public WebElement checkEditCong;









//    @FindBy(xpath = " ")
//    public WebElement ;
//    @FindBy(xpath = " ")
//    public WebElement ;
//    @FindBy(xpath = " ")
//    public WebElement ;
}
