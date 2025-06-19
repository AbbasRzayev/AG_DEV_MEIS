package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ideaBank_Page {
    public ideaBank_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(., 'Fikir bankı')]")
    public WebElement ideaBankMainPage;
    @FindBy(xpath = "//span[contains(@class, 'mdc-button__label')]")
    public WebElement newIdeaAddBtn;
    @FindBy(xpath = "//div[@class='mat-mdc-select-trigger ng-tns-c3393473648-11']")
    public WebElement directionDropDown;
    @FindBy(xpath = "//span[text()='Digər']")
    public WebElement otherSelectFromList;
    @FindBy(id = "mat-input-2")
    public WebElement ideaInput;
    @FindBy(xpath = "//span[contains(., 'Yadda saxla')]")
    public WebElement saveBtn;
    @FindBy(xpath = "//img[contains(@alt, 'İdarəetmə')]")
    public WebElement adminSidebare;
    @FindBy(xpath = "//a[@class='mat-ripple ng-star-inserted']//span[text()='Fikir bankı']")
    public WebElement adminPanelIdeaBankTab;
    @FindBy(xpath = "(//div[@class='header'])[1]")
    public WebElement ideaBankClick;
    @FindBy(xpath = "//span[text()='Bəyənmə sayına görə']")
    public WebElement openSort;
    @FindBy(xpath = "//span[text()='Tarixə görə']")
    public WebElement selectSortByDate;
    @FindBy(xpath = "//span[contains(., 'Cari vəziyyətini dəyişmək')]")
    public WebElement actualStatusBtn;
    @FindBy(xpath = "//label[.//mat-label[text()='Status']]/following-sibling::mat-select")
    public WebElement changeStatusBtn;
    @FindBy(xpath = "//label[.//mat-label[text()='Status']]/following-sibling::mat-select")
    public WebElement changeStatusBtn3;
    @FindBy(xpath = "//label[.//mat-label[text()='Status']]/following-sibling::mat-select")
    public WebElement changeStatusBtn4;
    @FindBy(xpath = "(//span[contains(., 'Gözləmədə olan')])[2]")
    public WebElement selectStatusBtn;
    @FindBy(xpath = "//span[contains(., 'Təsdiqlənmiş')]")
    public WebElement selectStatusAcceptedBtn;
    @FindBy(xpath = "//span[contains(., 'Ləğv edilmiş')]")
    public WebElement selectStatusCanceledBtn;
    @FindBy(id = "mat-input-11")
    public WebElement reasonInput;
    @FindBy(id = "mat-input-20")
    public WebElement reasonInput3;
    @FindBy(id = "mat-input-29")
    public WebElement reasonInput4;
    @FindBy(xpath = "//img[contains(@alt, 'Fikir bankı')]")
    public WebElement ideaBankSidebare;
    @FindBy(css = "span.green.ng-star-inserted")
    public WebElement scetcik;
    @FindBy(css = "span.warn.ng-star-inserted")
    public WebElement scetcikPending;
    @FindBy(css = "span.blue.ng-star-inserted")
    public WebElement scetcikAccepted;
    @FindBy(css = "span.red.ng-star-inserted")
    public WebElement scetcikCanceled;
    @FindBy(xpath = "(//div[@class='idea ng-star-inserted expanded']//div[contains(.,\" Test message \")])[2]")
    public WebElement ideaTextCheck;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
    public WebElement likeBtn;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[5]")
    public WebElement unlikeBtn;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
    public WebElement commentBtn;
    @FindBy(id = "mat-input-30")
    public WebElement commentIntput;
    @FindBy(xpath = "/html/body/app-root/div/div/main/ng-component/div/div[1]/div/div[5]/div[1]/button/span[3]")
    public WebElement flashLike;
    @FindBy(xpath = "/html/body/app-root/div/div/main/ng-component/div/div[1]/div/div[5]/div[2]/button/span[1]")
    public WebElement flashUnLike;
    @FindBy(xpath = "/html/body/app-root/div/div/main/ng-component/div/div[1]/div/div[5]/div[3]/button/span[3]")
    public WebElement flashCom;

   @FindBy(xpath = "(//div[@class='text'])[2]")
    public WebElement flashComment;
   @FindBy(xpath = "(//div[@class='text'])[2]")
    public WebElement commentText;
   @FindBy(xpath = "//span[text()='Fikri sil']")
    public WebElement ideaDeleteBtn;
   @FindBy(xpath = "//span[contains(.,'Bəli')]")
    public WebElement confirmDeleteBtn;
}