package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ideaBank_Page {
    public ideaBank_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(., 'İdea bankı')]")
    public WebElement ideaBankMainPage;
    @FindBy(xpath = "//span[contains(@class, 'mdc-button__label')]")
    public WebElement newIdeaAddBtn;
    @FindBy(xpath = "//mat-select[@formcontrolname='ideaDirectionId']")
    public WebElement directionDropDown;
    @FindBy(xpath = "//span[text()='Digər']")
    public WebElement otherSelectFromList;
    @FindBy(xpath = "//textarea[@formcontrolname='text']")
    public WebElement ideaInput;
    @FindBy(xpath = "//span[contains(., 'Yadda saxla')]")
    public WebElement saveBtn;
    @FindBy(css = "button[mattooltip='Göndərmək']")
    public WebElement sendComment;
    @FindBy(xpath = "//img[contains(@alt, 'İdarəetmə')]")
    public WebElement adminSidebare;
    @FindBy(xpath = "//span[text()='İdea bankı']")
    public WebElement adminPanelIdeaBankTab;
    @FindBy(xpath = "//span[normalize-space()='Cari vəziyyətini dəyişmək']")
    public WebElement openSort;
    @FindBy(xpath = "(//ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//mat-select)[3]")
    public WebElement statusList;
    @FindBy(xpath = "//span[contains(., 'Təsdiqlənmiş')]")
    public WebElement selectStatusAcceptedBtn;
    @FindBy(xpath = "//span[contains(., 'Ləğv edilmiş')]")
    public WebElement selectStatusCanceledBtn;
    @FindBy(css = "textarea.text_field")
    public WebElement reasonInput;
    @FindBy(xpath = "//img[contains(@alt, 'İdea bankı')]")
    public WebElement ideaBankSidebare;
    @FindBy(xpath = "//h6[starts-with(normalize-space(.), 'Bütün fikirlər')]")
    public WebElement allCounter;
    @FindBy(xpath = "//h6[starts-with(normalize-space(.), 'Gözləmədə olanlar')]")
    public WebElement pendingCounter;
    @FindBy(xpath = "//h6[starts-with(normalize-space(.), 'Qəbul edilənlər')]")
    public WebElement acceptedCounter;
    @FindBy(xpath = "//h6[starts-with(normalize-space(.), 'Ləğv edilənlər')]")
    public WebElement canceledCounter;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
    public WebElement likeBtn;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[7]")
    public WebElement unlikeBtn;
    @FindBy(xpath = "//span[text()='Ətraflı']")
    public WebElement detailedBtn;
    @FindBy(css = "textarea.mat-mdc-input-element[matinput]")
    public WebElement commentInput;
    @FindBy(xpath = "(//button[@color='primary']/following-sibling::span)[1]")
    public WebElement flashLike;
    @FindBy(xpath = "(//button[@color='warn']/following-sibling::span)[1]")
    public WebElement flashUnLike;
    @FindBy( xpath = "//span[contains(@class,'comment-count')]")
    public WebElement flashCom;
    @FindBy( xpath = "//button[@mat-dialog-close]")
    public WebElement closeCommentModal;
    @FindBy(xpath = "(//span[text()='Fikri sil'])[1]")
    public WebElement ideaDeleteBtn;
    @FindBy(xpath = "//span[contains(.,'Bəli')]")
    public WebElement confirmDeleteBtn;
    @FindBy(xpath = "//following-sibling::p[1]")
    public WebElement direction;
    @FindBy(xpath = "//following-sibling::p[2]")
    public WebElement whoIsIdea;
    @FindBy(xpath = "//following-sibling::p[3]")
    public WebElement structureIdea;
    @FindBy(xpath = "(//following-sibling::p[4])[1]")
    public WebElement statusIdea;
    @FindBy(xpath = "(//div[contains(@class,'text')])[3]")
    public WebElement noteIdea;
    @FindBy(xpath = "(//img[contains(@src,'calendar.svg')]/preceding-sibling::span[1])[1]")
    public WebElement ideaData;
    @FindBy(css = ".comment-list .comment p")
    public WebElement commentDisplay;
}