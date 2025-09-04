package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class programs_Page {

    public programs_Page() {PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//p[contains(text(),'Proqramlarım')]")
    public WebElement programTab;
    @FindBy(xpath = "//span[text()=' Yeni proqram ']")
    public WebElement newProgramButton;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement programNameField;
    @FindBy(xpath = "//input[@formcontrolname='keyword']")
    public WebElement kewwordField;
    @FindBy(xpath = "//input[@formcontrolname='url']")
    public WebElement programAdressField;
    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    public WebElement noteAboutProgramField;
    @FindBy(xpath = "//input[@formcontrolname='updateUrl']")
    public WebElement apiIntegrationField;
    @FindBy(xpath = "(//following::p)[1]")
    public WebElement iconButton;
    @FindBy(xpath = "//mat-icon[normalize-space(text())='change_circle']")
    public WebElement changeIcon;
    @FindBy(xpath = "(//following::p)[2]")
    public WebElement fileButton;
    @FindBy(xpath = "(//following::p)[3]")
    public WebElement VideoButton;
    @FindBy(xpath = "(//following::p)[4]")
    public WebElement otherFile;
    @FindBy(xpath = "//p[text()='Test.png']")
    public WebElement iconText;
    @FindBy(xpath = "//p[text()='QAAT.png']")
    public WebElement iconTextSecond;
    @FindBy(xpath = "//p[text()='QA.pdf']")
    public WebElement fileText;
    @FindBy(xpath = "//p[text()='EndToEnd.pdf']")
    public WebElement fileTextSecond;
    @FindBy(xpath = "//p[text()='AutomatedTesting.mp4']")
    public WebElement videoText;
    @FindBy(xpath = "//p[text()='programs.mp4']")
    public WebElement videoTextSecond;
    @FindBy(css = "img.file-thumbnail")
    public WebElement programIconCheck;
    @FindBy(xpath = "(//div[contains(@class, 'img-wrap')]//img[@alt='File Type Icon'])[1]")
    public WebElement fileIcon;
    @FindBy(xpath = "(//div[contains(@class, 'img-wrap')]//img[@alt='File Type Icon'])[2]")
    public WebElement videoIcon;
    @FindBy(xpath = "(//div[contains(@class, 'img-wrap')]//img[@alt='File Type Icon'])[3]")
    public WebElement otherIcon;
    @FindBy(xpath = "//p[text()='Video təlimat faylı']")
    public WebElement iconVideoBtn;
    @FindBy(xpath = "//p[text()='Təlimat faylı']")
    public WebElement iconInstructionBtn;
    @FindBy(xpath = "//p[text()='Digər fayl']")
    public WebElement iconAnotherFileBtn;
    @FindBy(xpath = "//span[contains(.,'Yadda saxla')]")
    public WebElement saveButton;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement searchInput;
    @FindBy(xpath = "//p[text()='Bright Future']")
    public WebElement createdProq;
    @FindBy(xpath = "//p[text()='Light Future']")
    public WebElement createdProgSecond;
    @FindBy(xpath = "//img[@alt='Test.png']")
    public WebElement programName;
    @FindBy(xpath = "//img[@alt='QAAT.png']")
    public WebElement programNameSecond;
    @FindBy(xpath = "//p[text()='AistGroup']")
    public WebElement createdProqNew;
    @FindBy(xpath = "//span[contains(., 'Modullar üzərində əməliyyatlar')]")
    public WebElement operationsOnModules;
    @FindBy(xpath = "(//input[@formcontrolname='name'])[2]")
    public WebElement addNameModul;
    @FindBy(xpath = "//input[@formcontrolname='keyWord']")
    public WebElement addKeyWordModul;
    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[9]")
    public WebElement acceptModul;
    @FindBy(xpath = "//span[text()='Bağla']")
    public WebElement closeModul;
    @FindBy(xpath = "//span[contains(., 'İstifadəçi kateqoriyaları əməliyyatlar')]")
    public WebElement userCategoriesOperations;
    @FindBy(xpath = "//*[@id=\"mat-mdc-form-field-label-40\"]")
    public WebElement modulList;
    @FindBy(xpath = "//span[contains(.,'Proqramlaşdırma')]")
    public WebElement modulSelect;
    @FindBy(xpath = "//span//span[contains(.,'Proqramları')]")
    public WebElement switchProgramTab;
    @FindBy(xpath = "//*[@id=\"mat-input-29\"]")
    public WebElement progTabSearchField;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement progTabSearchFieldNew;
    @FindBy(xpath = "//div[@class='mdc-switch__handle']")
    public WebElement activetedProgram;
    @FindBy(xpath = "//p[contains(.,'Bright Future')]")
    public WebElement activetedProgramNew;
    @FindBy(xpath = "//p[contains(.,'Aktiv edildi')]")
    public WebElement activetedText;
    @FindBy(xpath = "//*[@id=\"mat-tab-content-0-2\"]/div/app-user-programs/div/app-program-item/div/div/div/p")
    public WebElement selectProgram;
    @FindBy(xpath = "//*[@id=\"mat-tab-content-0-2\"]/div/app-user-programs/div/app-program-item/div/div/div[2]/div[3]/div[1]/div")
    public WebElement selectModulForProg;
    @FindBy(xpath = "//*[@id=\"mat-tab-content-0-2\"]/div/app-user-programs/div/app-program-item/div/div/div[2]/div[3]/div[2]/div")
    public WebElement selectCategForProg;
    @FindBy(xpath = "//span[contains(.,'Yadda saxla')]")
    public WebElement saveProg;
    @FindBy(xpath = "//p[contains(.,'Proqramlarım')]")
    public WebElement mainProg;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-programs/div/div[4]/div/app-program-item/div")
    public WebElement switchToTheProq;
    @FindBy(xpath = "//div[@class='header-logo']")
    public WebElement aistLogo;
    @FindBy(xpath = "//a//span[contains(.,'Proqramlar')]")
    public WebElement programsControlPanel;
    @FindBy(xpath = "//span[contains(., 'Proqramı sil')]")
    public WebElement progDelete;
    @FindBy(xpath = "//span[contains(., ' Bəli ')]")
    public WebElement progDeleteAccept;
    @FindBy(xpath = "(//div[contains(@class,'action-icon') and contains(@class,'delete')])[1]")
    public WebElement deleteFileFirst;
    @FindBy(xpath = "(//div[contains(@class,'action-icon') and contains(@class,'delete')])[2]")
    public WebElement deleteFileSecond;
    @FindBy(xpath = "(//input[@formcontrolname='name'])[2]")
    public WebElement inputNameModule;
    @FindBy(xpath = "//input[@formcontrolname='keyWord']")
    public WebElement inputKeyword;
    @FindBy(xpath = "//span[normalize-space()='Modullar üzərində əməliyyatlar']")
    public WebElement operationModuleButton;
    @FindBy(xpath = "//span[normalize-space()='İstifadəçi kateqoriyaları əməliyyatlar']")
    public WebElement userCategoryButton;
    @FindBy(xpath = "//button[.//img[contains(@src,'edit-colorless.svg')]]")
    public WebElement editModuleButton;
    @FindBy(xpath = "//button[.//img[contains(@src,'delete-colorless.svg')]]")
    public WebElement deleteModuleButton;
    @FindBy(xpath = "//button[@mattooltip='Məlumat']")
    public WebElement infoButton;
    @FindBy(xpath = "//textarea[@rows='4']")
    public WebElement infoInput;
    @FindBy(xpath = "//span[normalize-space()='Saxla']")
    public WebElement saveChangesModule;
    @FindBy(xpath = "//button[@mattooltip='Təsdiq']")
    public WebElement acceptModule;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-name')])[1]")
    public WebElement moduleNameColumnTable;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-keyWord')])[1]")
    public WebElement moduleKeywordColumnTable;
    @FindBy(xpath = "(//button[.//mat-icon[normalize-space(.)='info_fill']])[1]")
    public WebElement infoHover;
    @FindBy(xpath = "//span[normalize-space()='Bağla']")
    public WebElement closeModelWindow;
    @FindBy(xpath = "//mat-label[normalize-space(.)='Modullar']/ancestor::label/following-sibling::mat-select")
    public WebElement modalSelectCategory;
    @FindBy(xpath = "//span[normalize-space()='First Module']")
    public WebElement selectFirstModule;
    @FindBy(xpath = "//span[normalize-space()='Second Module']")
    public WebElement selectSecondModule;
}