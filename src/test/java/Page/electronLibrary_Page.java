package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class electronLibrary_Page {
    public electronLibrary_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//p[text()='Elektron kitabxana']")
//    public WebElement electronicLibTab;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-home/div[2]/app-menu-item[7]/div")
    public WebElement electronicLibTab;
    @FindBy(xpath = "//span[text()=' Yeni təlim ']")
    public WebElement newTraningBtn;
    @FindBy(id = "mat-input-2")
    public WebElement traningName;
    @FindBy(id = "mat-input-6")
    public WebElement traningEditName;
    @FindBy(xpath = "//label[text()='Daxili təlimçi']")
    public WebElement checkBoxesInnerTraniner;
    @FindBy(xpath = "//label[text()='Kənardan təlimçi']")
    public WebElement checkBoxesExternalTrainer;
    @FindBy(xpath = "//mat-label[text()='Təlimçi axtar']")
    public WebElement trainSearch;
    @FindBy(xpath = "//label[contains(text(),'Abbas')]")
    public WebElement chooseFromList;
    @FindBy(xpath = "//label[text()='Fərid İmranov - PHŞ: Mühafizə ']")
    public WebElement chooseEditFromList;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
    public WebElement closeList;
    @FindBy(id = "mat-input-3")
    public WebElement dateInput;
    @FindBy(id = "mat-input-4")
    public WebElement dateInputEJ;
    @FindBy(id = "mat-input-7")
    public WebElement dateEditInput;
    @FindBy(xpath = "//span[text()='Fayl əlavə edin']")
    public WebElement addFileBtn;
    @FindBy(xpath = "//span[text()='Daxili təlim']")
    public WebElement addEditFileBtn;
    @FindBy(id = "mat-input-4")
    public WebElement noteInput;
    @FindBy(xpath = "(//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-24']//input)[1]")
    public WebElement selectNotPersomForTrain;
    @FindBy(xpath = "(//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-23']//input)[1]")
    public WebElement selectNotPersomForElectronJournal;
    @FindBy(xpath = "//span[text()='Ümumi açıq']")
    public WebElement selectPersomForWhoSees;
    @FindBy(xpath = "//span[text()='Yadda saxla']")
    public WebElement saveBtn;
    @FindBy(xpath = "//span[text()='Təsdiq et']")
    public WebElement acceptBtn;
    @FindBy(xpath = "//span[text()='Redaktə et']")
    public WebElement editYesBtn;
    @FindBy(xpath = "//td[text()='Daxili təlim']")
    public WebElement checkİnnerName;
    @FindBy(xpath = "//span[text()='Bəli']")
    public WebElement deleteYes;

    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public WebElement inner;
    @FindBy(xpath = "//input[@id='mat-radio-3-input']")
    public WebElement foregin;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
    public WebElement plusBtn;
    @FindBy(id = "mat-input-7")
    public WebElement instructorNameInput;
    @FindBy(xpath = "//td[text()='Kənardan təlim']")
    public WebElement checkForein;
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
    @FindBy(xpath = "//span[contains(., 'Bəli')]")
    public WebElement usefulYesBtn;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement nameEJ;
    @FindBy(xpath = "//input[@formcontrolname='number']")
    public WebElement numberEJ;

}