package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class electronLibrary_Page {
    public electronLibrary_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[text()=' Yeni təlim ']")
    public WebElement newTrainingBtn;
    @FindBy(id = "mat-input-2")
    public WebElement traningName;
    @FindBy(xpath = "//input[@formcontrolname='trainingDate']")
    public WebElement dateInput;
    @FindBy(id = "mat-input-4")
    public WebElement dateInputEJ;
    @FindBy(xpath = "(//button[./mat-icon[text()='delete']])[1]")
    public WebElement fileDelete;
    @FindBy(xpath = "//span[text()='Fayl əlavə edin']")
    public WebElement addFileBtn;
    @FindBy(xpath = "//textarea[@formcontrolname ='description']")
    public WebElement noteInput;
    @FindBy(xpath = "(//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-23']//input)[1]")
    public WebElement selectNotPersomForElectronJournal;
    @FindBy(xpath = "//span[text()='Ümumi açıq']")
    public WebElement selectPersomForWhoSees;
    @FindBy(xpath = "//span[text()='Təsdiq et']")
    public WebElement acceptBtn;
    @FindBy(xpath = "//span[normalize-space()='Bəli']")
    public WebElement deleteYes;
    @FindBy(xpath = "//span[text()='Elektron kitabxana']")
    public WebElement electronicLibraryTabAdmin;

    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public WebElement inner;
    @FindBy(xpath = "//input[@id='mat-radio-3-input']")
    public WebElement foregin;
    @FindBy(className = "add-button")
    public WebElement plusBtn;
    @FindBy(xpath = "//input[@formcontrolname='externalTrainerName']")
    public WebElement instructorNameInput;
    @FindBy(xpath = "(//input[@name='mat-radio-group-0'])[2]")
    public WebElement checkboxTraining;
    @FindBy(xpath = "//span[contains(@class, 'tab-title') and contains(., 'Faydalı məlumatlar')]")
    public WebElement usefulInformation;
    @FindBy(xpath = "//span[contains(@class, 'tab-title') and contains(., 'Elektron jurnal')]")
    public WebElement electronJournal;
    @FindBy(xpath = "//span[contains(@class, 'mdc-button__label') and contains(., ' Faydalı məlumat əlavə et ')]")
    public WebElement usefulPlusBtn;
    @FindBy(xpath = "//span[contains(@class, 'mdc-button__label') and contains(., ' Elektron jurnal əlavə et ')]")
    public WebElement electronJournalPlusBtn;
    @FindBy(id = "mat-input-2")
    public WebElement tittleInput;
    @FindBy(xpath = "//span[contains(., 'Fayl əlavə edin')]")
    public WebElement addUsefulFile;
    @FindBy(xpath = "//span[contains(., 'Yadda saxla')]")
    public WebElement usefulSaveBtn;
    @FindBy(xpath = "//td[contains(., 'Grow uP')]")
    public WebElement checkUseful;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement nameEJ;
    @FindBy(xpath = "//input[@formcontrolname='number']")
    public WebElement numberEJ;

    @FindBy(xpath = "(//td[contains(@class,'mat-column-title')]//span[contains(@class,'mat-mdc-tooltip-trigger')])[1]")
    public WebElement trainingNameTable;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-executors')])[1]")
    public WebElement trainingTeachersNameTable;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-trainingDate')])[1]")
    public WebElement trainingTimeTable;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-pdfUrl')])[1]")
    public WebElement trainingMaterialsTable;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-viewCount')])[1]")
    public WebElement viewCountsTable;
    @FindBy(xpath = "//div[contains(@class,'mat-mdc-dialog-surface')]")
    public WebElement trainingNoteModal;
    @FindBy(xpath = "//h5[contains(@class,'mat-mdc-dialog-title')]")
    public WebElement trainingNameModal;
    @FindBy(xpath = "//p[text()='Elektron kitabxana']")
    public WebElement electronicMainPage;
    @FindBy(xpath = "//a[text()=' Fayl ']")
    public WebElement fileDocumentModal;
    @FindBy(xpath = "(//button[@mattooltip='Redaktə et' and @mat-icon-button])[1]")
    public WebElement editButton;
    @FindBy(xpath = "(//button[@mattooltip='Sil' and @mat-icon-button])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "//span[normalize-space()='Redaktə et']")
    public WebElement editBtn;
    @FindBy(xpath = "//input[@autocomplete='username']")
    public WebElement emailUsername;
    @FindBy(xpath = "//input[@autocomplete='current-password']")
    public WebElement emailPassword;
    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement enterEmail;
    @FindBy(xpath = "(//span[contains(.,'Daxili təlim')])[1]")
    public WebElement selectsTrainingMaterialEmailNot;
    @FindBy(xpath = "(//span[contains(.,'Təqvim: AT_TesT')])[1]")
    public WebElement selectsEventEmailNot;
    @FindBy(xpath = "(//span[contains(.,'Hesab Təsdiqi')])[1]")
    public WebElement selectsOTTPNot;
    @FindBy(xpath = "(//div[contains(.,'Qeydiyyat üçün təsdiq kodunuz aşağıdakıdır:')]/b)[1]")
    public WebElement OTTPCode;
    @FindBy(xpath = "//strong[contains(text(),'Təsvir:')]/parent::*")
    public WebElement headingElement;
    @FindBy(xpath = "(//span[contains(text(), '.pdf')])[1]")
    public WebElement trainingMaterialFile;

}