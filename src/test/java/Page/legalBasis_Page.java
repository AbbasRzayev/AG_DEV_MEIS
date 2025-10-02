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
    @FindBy(xpath = "//input[@formcontrolname='title']")
    public WebElement nameForFirstDocument;
    @FindBy(xpath = "//input[@formcontrolname='legislationNumber']")
    public WebElement numberField;
    @FindBy(xpath = "//input[@formcontrolname='orgRegNumber']")
    public WebElement stateNumber;
    @FindBy(xpath = "//input[@formcontrolname='startDate']")
    public WebElement effectiveDate;
    @FindBy(xpath = "//input[@formcontrolname='endDate']")
    public WebElement expirationDate;
    @FindBy(xpath = "//input[@formcontrolname='agreementAcceptanceDateStr']")
    public WebElement admissonDate;
    @FindBy(xpath = "//input[@formcontrolname='recipient']")
    public WebElement acceptedOrgan;
    @FindBy(xpath = "//input[@formcontrolname='url']")
    public WebElement linkField;
    @FindBy(xpath = "//mat-select[@formcontrolname='legislationTypeId']")
    public WebElement docTypeBtn;
    @FindBy(xpath = "//span[text()='Əsasnamə']")
    public WebElement docType;
    @FindBy(xpath = "//mat-select[@formcontrolname='statusType']")
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
    @FindBy(xpath = "//mat-select[@formcontrolname='appointmentStatusType']")
    public WebElement statusView;
    @FindBy(xpath = "//span[text()='Ünvanlanmış şəxslərə görə']")
    public WebElement addressedPerson;
    @FindBy(css = "input.search-input")
    public WebElement addressedPersonInput;
    @FindBy(xpath = "//div[text()=' Musa Rzayev - AT|TestUser(!) ']")
    public WebElement selectMusaPerson;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-title')]//span)[1]")
    public WebElement legalNameCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-legislationNumber')])[1]")
    public WebElement legalNumberCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-legislationTypeName')])[1]")
    public WebElement legalTypeCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-recipient')])[1]")
    public WebElement legalAcceptOrganCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-startDateStr')])[1]")
    public WebElement legalStartDateCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-endDateStr')])[1]")
    public WebElement legalEndCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-agreementAcceptanceDateStr')])[1]")
    public WebElement legalAcceptDateCheck;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-statusType')])[1]")
    public WebElement legalStatusCheck;

    @FindBy(xpath = "(//div[@class='info']//p)[2]")
    public WebElement nameModal;
    @FindBy(xpath = "(//div[@class='info']//p)[4]")
    public WebElement numberModal;
    @FindBy(xpath = "(//div[@class='info']//p)[6]")
    public WebElement docTypeModal;
    @FindBy(xpath = "(//div[@class='info']//p)[8]")
    public WebElement acceptOrganModal;
    @FindBy(xpath = "(//div[@class='info']//p)[10]")
    public WebElement acceptDateModal;
    @FindBy(xpath = "(//div[@class='info']//p)[12]")
    public WebElement statusModal;
    @FindBy(xpath = "//span[text()='URL']")
    public WebElement urlModal;



}