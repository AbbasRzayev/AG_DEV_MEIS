package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class helpDesk_Page {
    public helpDesk_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(.,'Yardım masası')]")
    public WebElement helpDeskBtnFromMainPage;

    @FindBy(xpath = "//*[@id='mat-select-value-1']")
    public WebElement directionList;

    @FindBy(xpath = "//span[contains(.,'Digər problemlər')]")
    public WebElement differentProblemsSelect;

    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-13']")
    public WebElement sowftwareSelectasd;

    @FindBy(xpath = "//span[contains(.,' Şifrənin dəyişdirilməsi ')]")
    public WebElement changePass;

    @FindBy(xpath = "//mat-select[@formcontrolname='feedBackType']//span[contains(@class, 'mat-mdc-select-placeholder')]")
    public WebElement noteTypeList;

    @FindBy(xpath = "//span[contains(.,'Xəta')]")
    public WebElement noteTypeSelect;

    @FindBy(xpath = "//mat-select[@formcontrolname='priorityType']")
    public WebElement notePriority;

    @FindBy(xpath = "//span[contains(.,'Yüksək')]")
    public WebElement notePriorityHigh;

    @FindBy(id = "mat-input-2")
    public WebElement addText;

    @FindBy(xpath = "//p[contains(., 'Fayl əlavə edin')]")
    public WebElement addFile;

    @FindBy(xpath = "//span[normalize-space()='Yadda saxla']")
    public WebElement saveRequest;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[1]")
    public WebElement check1;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
    public WebElement check2;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[3]")
    public WebElement check3;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[4]")
    public WebElement check4;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[5]")
    public WebElement check5;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[6]")
    public WebElement check6;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[7]")
    public WebElement check7;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[8]")
    public WebElement check8;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[9]")
    public WebElement check9;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[10]")
    public WebElement check10;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[11]")
    public WebElement check11;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[12]")
    public WebElement check12;
    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[13]")
    public WebElement check13;
    @FindBy(xpath = "//a[@class='ng-star-inserted']")
    public WebElement check14;
    @FindBy(xpath = "(//span[@class='mdc-list-item__content'])[9]")
    public WebElement adminPanelBtn;
    @FindBy(xpath = "//span[contains(., 'Yardım masası')]")
    public WebElement adminHelpTab;
    @FindBy(xpath = "(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-regUserFullName mat-column-regUserFullName ng-star-inserted'])[1]")
    public WebElement selectReguest;
    @FindBy(xpath = "//span[contains(., ' İcra edilməsi üçün təyinat etmək ')]")
    public WebElement openEmployeeList;
    @FindBy(id = "mat-input-11")
    public WebElement selectinputEmployee;
    @FindBy(xpath = "//span[text()=' Davud Zamanov ']")
    public WebElement selectnameEmployee;
    @FindBy(xpath = "//span[text()='Təsdiq et']")
    public WebElement acceptEmployee;
    @FindBy(xpath = "//span[text()=' Düzəliş et ']")
    public WebElement acceptReguest;
    @FindBy(xpath = "//span[contains(.,' Geri ')]")
    public WebElement getbackTable;
    @FindBy(xpath = "(//td[text()='İlkin'])[1]")
    public WebElement tableIlkinStatus;
    @FindBy(xpath = "(//td[text()='Davud Zamanov'])[1]")
    public WebElement tableNameEmlpoyee;
    @FindBy(xpath = "//div[@class='mdc-dialog__container']")
    public WebElement noteMainCheck;
    @FindBy(xpath = "(//span[@class='mdc-list-item__content'])[11]")
    public WebElement exitBtn;
    @FindBy(xpath = "//span[text()='Bəli']")
    public WebElement acceptExitBtn;
    @FindBy(xpath = "//p[contains(., 'Digər problemlər')]")
    public WebElement firstNoteCheck;
    @FindBy(xpath = "//p[contains(., 'Yüksək')]")
    public WebElement secondNoteCheck;
    @FindBy(xpath = "//p[contains(., 'İcra edilib')]")
    public WebElement doneNoteCheck;
    @FindBy(xpath = "//p[contains(., 'Müvəffəqiyyətlə icra edildi')]")
    public WebElement NoteCheck;
    @FindBy(xpath = "//p[contains(., 'Akt-8888')]")
    public WebElement actNoteCheck;
    @FindBy(xpath = "//p[contains(., 'İlkin')]")
    public WebElement thirdNoteCheck;
    @FindBy(xpath = "//p[contains(., 'ibrahim Rzayev')]")
    public WebElement fourthNoteCheck;
    @FindBy(xpath = "//p[contains(., 'Davud Zamanov')]")
    public WebElement fifthNoteCheck;
    @FindBy(xpath = "//p[contains(., 'PC_İbrahim')]")
    public WebElement sevenNoteCheck;
    @FindBy(xpath = "//p[contains(., '111111111')]")
    public WebElement sixthNoteCheck;
    @FindBy(xpath = "//span[contains(., 'Ətraflı')]")
    public WebElement moreIntormationBtn;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[2]")
    public WebElement systemNotBtn;
    @FindBy(xpath = "//p[@class='mat-ripple notification-item new ng-star-inserted']")
    public WebElement selectNotBtn;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement mailUsername;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement mailPassword;
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signIn;
    @FindBy(xpath = "//*[@id=\"ph-whiteline\"]/div/div[1]/div/div/div[2]/div/div")
    public WebElement searchInputMailRuClick;
    @FindBy(xpath = "//input[@class='mail-operands_dynamic-input__input--Ckq58 _1XeZVjWI3S6j3SYMYdnVbj _1V_JAvJOg6UG9bdtsIgWBR']")
    public WebElement searchInputMailRu;
    @FindBy(xpath = "(//div[@class='letter__attach-list'])[1]")
    public WebElement checkFIleMailRu;
    @FindBy(xpath = "//div[@class='thread__header']")
    public WebElement checkNumHedaerMailRu;
    @FindBy(xpath = "(//div[@class='js-helper js-readmsg-msg'])[1]")
    public WebElement checkalltextMailRu;
    @FindBy(xpath = "//span[text()=' İlkin ']")
    public WebElement reqStatus;
    @FindBy(xpath = "//span[text()='İlkin']")
    public WebElement reqStatusList;
    @FindBy(xpath = "//span[text()='İcra edilib']")
    public WebElement reqStatusListDone;
    @FindBy(xpath = "//span[text()='İcraya qəbul edilib']")
    public WebElement reqAcceptStatusList;
    @FindBy(xpath = "//span[text()='Təsdiq et']")
    public WebElement acceptStatusNote;
    @FindBy(xpath = "//textarea[@id='mat-input-17']")
    public WebElement noteInput;
    @FindBy(xpath = "//div[@class='tables-wrapper']")
    public WebElement checkNote;
    @FindBy(xpath = "(//td[text()='İcraya qəbul edilib'])[1]")
    public WebElement checkStatusTableInWork;

    @FindBy(id = "mat-input-11")
    public WebElement doneInput;
    @FindBy(id = "mat-input-12")
    public WebElement actInput;
    @FindBy(id = "mat-input-13")
    public WebElement statInput;

    @FindBy(xpath = "//span[contains(., \" İcraya qəbul edilib \")]")
    public WebElement inProqressBtn;

    @FindBy(xpath = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-execution-status-dialog/mat-card/mat-card-content/mat-form-field[1]/div[1]/div[2]/div")
    public WebElement statList;
    @FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), 'İcra edilib')]")
    public WebElement setDoneList;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-helpdesk-control-view/div[3]/div[2]/div/div/mat-icon[1]")
    public WebElement editStat;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[8]")
    public WebElement perscentDone;
    @FindBy(xpath = "//p[text()='Davud Zamanov']")
    public WebElement nameCheckReq;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-helpdesk-control-view/div[3]/div[2]/div/p[2]")
    public WebElement dateCheckReq;
    @FindBy(xpath = "//p[text()='İcra edildi, icra faizi 100%']")
    public WebElement noteCheckReq;
    @FindBy(xpath = "(//td[text()='İcra edilib'])[1]")
    public WebElement checkDoneStatusTable;





}