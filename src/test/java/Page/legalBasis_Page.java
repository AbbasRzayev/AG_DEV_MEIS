package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class legalBasis_Page {
    public legalBasis_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Hüquqi baza']")
    public WebElement lagalBasis;
    @FindBy(xpath = "//span[text()=' Yeni sənəd ']")
    public WebElement plusBtnNewDocument;
    @FindBy(id = "mat-input-17")
    public WebElement nameForFirstDocument;
    @FindBy(id = "mat-input-18")
    public WebElement numberField;
    @FindBy(id = "mat-input-19")
    public WebElement stateNumber;
    @FindBy(id = "mat-input-21")
    public WebElement effectiveDate;
    @FindBy(id = "mat-input-22")
    public WebElement expirationDate;
    @FindBy(id = "mat-input-23")
    public WebElement admissonDate;
    @FindBy(id = "mat-input-20")
    public WebElement acceptedOrgan;
    @FindBy(id = "mat-input-24")
    public WebElement linkField;
    @FindBy(xpath = "//div[@class='mat-mdc-select-arrow ng-tns-c3393473648-36']")
    public WebElement docTypeBtn;
    @FindBy(xpath = "//span[text()='Əsasnamə']")
    public WebElement docType;

    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-41']")
    public WebElement status;
    @FindBy(xpath = "//span[text()='Qüvvədə olan']")
    public WebElement statusSelect;
    @FindBy(xpath = "//span[text()='Fayl əlavə edin']")
    public WebElement addFile;
    @FindBy(xpath = "//span[contains(.,'Yadda saxla')]")
    public WebElement yestBtn;
    @FindBy(xpath = "(//span[@class='mdc-list-item__content'])[6]")
    public WebElement legalBasisSIdeBar;
    @FindBy(xpath = "(//tr[@class='mat-mdc-row mdc-data-table__row cdk-row body-row ng-star-inserted'])[1]")
    public WebElement tableFirstElement;
    @FindBy(xpath = "//p[text()='778899']")
    public WebElement numCheck;
    @FindBy(xpath = "//p[text()='Document for public open']")
    public WebElement headCheck;
    @FindBy(xpath = "//p[text()='Document according to addressees']")
    public WebElement headCheckPerson;
    @FindBy(xpath = "//p[text()='Document according to structure']")
    public WebElement headCheckStructure;
    @FindBy(xpath = "//p[text()='Əsasnamə']")
    public WebElement docTypeCheck;
    @FindBy(xpath = "//p[text()='IT Product']")
    public WebElement acceptOrganCheck;
    @FindBy(xpath = "//p[text()='Qüvvədə']")
    public WebElement statusCheck;
    @FindBy(xpath = "(//div[@class='field'])[5]")
    public WebElement effeCheck;
    @FindBy(xpath = "//a[@class='link']")
    public WebElement linkGo;
    @FindBy(xpath = "//div[@class='container position-relative z-index-1 pt-5 mt-5']")
    public WebElement checkurlLink;
    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-44']")
    public WebElement statusList;
    @FindBy(xpath = "//span[text()='Ünvanlanmış şəxslərə görə']")
    public WebElement statusByPerson;
    @FindBy(id = "mat-input-25")
    public WebElement personList;
    @FindBy(xpath= "//label[contains(.,'Musa Rzayev')]")
    public WebElement selectMusa;
    @FindBy(xpath = "//span[text()='Struktur bölmə daxilində']")
    public WebElement statusByStructure;
    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c1205077789-46']")
    public WebElement statusByStructureList;
    @FindBy(xpath = "//label[text()='Antiinhisar və İstehlak Bazarlarına Nəzarət Dövlət Xidməti']")
    public WebElement statusByStructureSelect;
    @FindBy(xpath = "//span[text()='Təsdiq et']")
    public WebElement acceptStructure;
}