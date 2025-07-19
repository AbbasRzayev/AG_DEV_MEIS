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

    @FindBy(xpath = "(//span[contains(.,'Digər problemlər')])[1]")
    public WebElement differentProblemsSelect;

    @FindBy(xpath = "//span[contains(.,'Proqram təminatı')]")
    public WebElement programSoftwareSelect;
    @FindBy(xpath = "//span[normalize-space()='Elektron Sənəd Dövriyyəsi']")
    public WebElement programEdocumentSelect;

    @FindBy(xpath = "//mat-label[normalize-space()='Proqram təminatı*']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//mat-select")
    public WebElement programList;

    @FindBy(xpath = "//mat-select[@formcontrolname='feedBackType']//span[contains(@class, 'mat-mdc-select-placeholder')]")
    public WebElement noteTypeList;

    @FindBy(xpath = "(//span[contains(.,'Xəta')])[1]")
    public WebElement noteTypeSelect;
    @FindBy(xpath = "//span[contains(.,'Təklif')]")
    public WebElement noteTypeOfferSelect;

    @FindBy(xpath = "//mat-select[@formcontrolname='priorityType']")
    public WebElement notePriority;

    @FindBy(xpath = "(//span[contains(.,'Yüksək')])[1]")
    public WebElement notePriorityHigh;
    @FindBy(xpath = "//span[contains(.,'Təcili')]")
    public WebElement notePriorityUrgent;

    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    public WebElement addText;

    @FindBy(xpath = "//p[contains(., 'Fayl əlavə edin')]")
    public WebElement addFile;
    @FindBy(xpath = "//mat-icon[normalize-space()='change_circle']")
    public WebElement addFileSecond;

    @FindBy(xpath = "//span[normalize-space()='Yadda saxla']")
    public WebElement saveRequest;

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

    @FindBy(xpath = "//span[normalize-space(text())='ID']/following-sibling::p/span[normalize-space(text())]")
    public WebElement idReview;
    @FindBy(xpath = "//span[normalize-space(text())='Proqram təminatı']/following-sibling::p/span[normalize-space(text())]")
    public WebElement programNameReview;
    @FindBy(xpath = "//span[normalize-space(text())='İstiqamət']/following-sibling::p/span[normalize-space(text())]")
    public WebElement directionReview;
    @FindBy(xpath = "//span[normalize-space(text())='Bildirişi göndərən']/following-sibling::p/span[normalize-space(text())]")
    public WebElement notificationReview;
    @FindBy(xpath = "//span[normalize-space(text())='Tarix']/following-sibling::p/span[normalize-space(text())]")
    public WebElement dateReview;
    @FindBy(xpath = "//span[normalize-space(text())='Əlaqə']/following-sibling::p/span[normalize-space(text())]")
    public WebElement connectReview;
    @FindBy(xpath = "//span[normalize-space(text())='İP telefon nömrəsi']/following-sibling::p/span[normalize-space(text())]")
    public WebElement ipReview;
    @FindBy(xpath = "//span[normalize-space(text())='İstifadəçi kompüterinin adı']/following-sibling::p/span[normalize-space(text())]")
    public WebElement pcReview;
    @FindBy(xpath = "//span[normalize-space(text())='Bildirişin tipi']/following-sibling::p/span[normalize-space(text())]")
    public WebElement notTypeReview;
    @FindBy(xpath = "//span[normalize-space(text())='Prioritet']/following-sibling::p/span[normalize-space(text())]")
    public WebElement priorityReview;
    @FindBy(xpath = "//span[normalize-space(text())='Cari nəticə']/following-sibling::p/span[normalize-space(text())]")
    public WebElement currentReview;
    @FindBy(xpath = "//span[normalize-space(text())='Akt tərtib edilib']/following-sibling::p/span[normalize-space(text())]")
    public WebElement actReview;
    @FindBy(xpath = "//span[normalize-space(text())='Fayl']/following-sibling::a")
    public WebElement fileReview;
    @FindBy(xpath = "//following::a[@download='Test.png']")
    public WebElement file;
    @FindBy(xpath = "//following::a[@download='QAAT.png']")
    public WebElement fileSecond;
    @FindBy(xpath = "//following::a[contains(@href, 'data:/image/png')]")
    public WebElement fileLink;
    @FindBy(xpath = "//span[normalize-space(text())='İcra edənin qeydi']/following-sibling::p/span[normalize-space(text())]")
    public WebElement noteReview;
    @FindBy(xpath = "//span[normalize-space(text())='İş yeri']/following-sibling::p/span[normalize-space(text())]")
    public WebElement workPlaceReview;
    @FindBy(xpath = "(//tr[@role='row'])[2]")
    public WebElement firstAppealFromTable;
    @FindBy(xpath = "//span[text()='Düzəliş et']")
    public WebElement requestEditBtn;
    @FindBy(xpath = "//span[normalize-space()='Göndərdiyim müraciətlər']")
    public WebElement mySentRequestsSection;
    @FindBy(xpath = "//mat-label[text()='Göndərən']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement sentInput;
    @FindBy(xpath = "//ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//mat-select")
    public WebElement descriptionList;
    @FindBy(xpath = "//span[text()='Proqram təminatı']")
    public WebElement descriptionProgram;
    @FindBy(xpath = "//span[text()='Digər problemlər']")
    public WebElement descriptionDifferentProblems;
    @FindBy(xpath = "//span[text()='Şəbəkə və rabitə problemləri']")
    public WebElement descriptionNetwork;
    @FindBy(xpath = "//span[text()='Əməliyyat sistemi']")
    public WebElement descriptionOS;
    @FindBy(xpath = "//span[text()='Cari işlər']")
    public WebElement descriptionCurrentWorks;
    @FindBy(xpath = "//span[text()='Elektron xidmətlər']")
    public WebElement descriptionEservices;
    @FindBy(xpath = "//span[text()='Avadanlıq']")
    public WebElement descriptionHardware;

}