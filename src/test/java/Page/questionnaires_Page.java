package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class questionnaires_Page {

    public questionnaires_Page() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//span[text()='Soraqçalar']")
    public WebElement questionnairesTab;
    @FindBy(xpath = "//span[text()='Elanlar']")
    public WebElement announceTabAdmin;
    @FindBy(xpath = "//span[normalize-space()='+ Elan tipi əlavə et']")
    public WebElement adAnnounceType;
    @FindBy(xpath = "//span[normalize-space()='+ Təbrik tipi əlavə et']")
    public WebElement congratsType;
    @FindBy(xpath = "//span[text()='Elan tipi əlavə et']")
    public WebElement addAdType;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement adTypeInput;
    @FindBy(xpath = "//span[normalize-space()='Yadda saxla']")
    public WebElement saveBtn;
    @FindBy(xpath = "(//td[normalize-space()='ManualQA news'])[1]")
    public WebElement checkNewAd;
    @FindBy(xpath = "(//td[normalize-space()='Manual progress'])[1]")
    public WebElement checkNewCong;
    @FindBy(xpath = "(//td[normalize-space()='Manual event place'])[1]")
    public WebElement checkNewEvent;
    @FindBy(xpath = "(//td[normalize-space()='Manual category'])[1]")
    public WebElement checkNewCategory;
    @FindBy(xpath = "(//td[normalize-space()='Automation category'])[1]")
    public WebElement checkNewCategorySec;
    @FindBy(xpath = "(//td[normalize-space()='Automation event place'])[1]")
    public WebElement checkSecondEvent;
    @FindBy(xpath = "(//td[normalize-space()='AutomationQA news'])[1]")
    public WebElement checkNewSecond;
    @FindBy(xpath = "(//td[normalize-space()='Automation progress'])[1]")
    public WebElement checkSecondCong;
    @FindBy(xpath = "//td[text()='GoodQuality']")
    public WebElement checkEditAd;
    @FindBy(xpath = "//span[normalize-space()='Bəli']")
    public WebElement deleteYes;
    @FindBy(id = "mat-input-9")
    public WebElement adTypeInputTwo;

    @FindBy(xpath = "(//span[@class='mdc-tab__text-label'])[2]")
    public WebElement calendar;
    @FindBy(xpath = "//button[normalize-space()='Təqvim']")
    public WebElement calendarTab;

    @FindBy(xpath = "//span[normalize-space()='+ Məkan əlavə et']")
    public WebElement places;
    @FindBy(xpath = "//span[normalize-space()='+ Kateqoriya əlavə et']")
    public WebElement categoryBtn;
    @FindBy(xpath = "//span[text()='Tədbir kateqoriyaları']")
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
    @FindBy(xpath = "//button[normalize-space()='Təbriklər']")
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

}