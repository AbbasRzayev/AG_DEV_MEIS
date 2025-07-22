package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class searchByUserData_Page {
    public searchByUserData_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "td.mat-column-fullName")
    public WebElement name;
    @FindBy(xpath = "//mat-label[text()='Soyad']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement surname;
    @FindBy(id = "mat-select-0")
    public WebElement dropDown;
    @FindBy(xpath = "//span[text()='Təmizlə']")
    public WebElement clearFields;
    @FindBy(xpath = "//span[text()='Təsdiqlənməyib']")
    public WebElement unverifiedList;
    @FindBy(xpath = "//span[text()='İnzibatçı təsdiqləyib']")
    public WebElement inspectAcc;
    @FindBy(xpath = "(//td[@class='mat-mdc-cell mdc-data-table__cell cdk-cell text-center cdk-column-statusType mat-column-statusType ng-star-inserted'])[1]")
    public WebElement unverified;
    @FindBy(xpath = "(//mat-icon[@class='mat-icon notranslate checked material-icons mat-ligature-font mat-icon-no-color'])[1]")
    public WebElement inspectorAccept;
    @FindBy(css = "input[formcontrolname='patronymic']")
    public WebElement fatherNameField;
    @FindBy(xpath = "(//p[@class='preview-text ng-star-inserted'])[5]")
    public WebElement fatherNameText;
    @FindBy(xpath = "//td[text()=' Abbas Rzayev ']")
    public WebElement foundName;
    @FindBy(xpath = "//mat-label[text()='FİN']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement finField;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[1]")
    public WebElement pinText;
    @FindBy(id = "mat-input-19")
    public WebElement workPlaceInput;
    @FindBy(xpath = "(//td[text()='Azərbaycan Metrologiya İnstitutu'])[1]")
    public WebElement workPlace;
    @FindBy(xpath = "//span[text()=' Axtar ']")
    public WebElement searchBtn;
    @FindBy(css = "tbody.mat-mdc-row")
    public WebElement workClass;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and @aria-haspopup='menu'])[1]")
    public WebElement nameFilter;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and @aria-haspopup='menu'])[2]")
    public WebElement dutyFilter;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and @aria-haspopup='menu'])[3]")
    public WebElement structureFilter;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and @aria-haspopup='menu'])[4]")
    public WebElement adminConfirmedFilter;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and @aria-haspopup='menu'])[5]")
    public WebElement currentStatusFilter;
    @FindBy(xpath = "//span[text()='Filter tətbiq et']")
    public WebElement openFilter;
    @FindBy(xpath = "//span[text()='Dəyişiklikləri sıfırla']")
    public WebElement restTheChanges;
    @FindBy(css = "div.mat-mdc-paginator-range-label")
    public WebElement getTableDataText;
    @FindBy(xpath = "//div[contains(@class, 'filter-overlay')]")
    public WebElement filterModal;
    @FindBy(xpath = "//button[.//mat-icon[text()='close']]")
    public WebElement closeFilterModal;
    @FindBy(xpath = "//label[.//mat-label[text()='Vəzifə']]/following-sibling::input")
    public WebElement dutyInput;
    @FindBy(xpath = "//mat-label[text()='Çalışdığı müəssisə']/ancestor::label/following-sibling::input")
    public WebElement structureInput;
    @FindBy(xpath = "//mat-label[text()='Təsdiqin statusu']/ancestor::label/following-sibling::mat-select")
    public WebElement adminApprovalList;
  @FindBy(xpath = "//mat-label[text()='Statusu']/ancestor::label/following-sibling::mat-select")
    public WebElement currentStatusList;
    @FindBy(xpath = "//div[contains(@class,'manual-option') and contains(.,'QA_AT')]")
    public WebElement dutyQASelect;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and .//mat-icon[text()='more_vert']])[2]")
    public WebElement dutyInputSecond;
    @FindBy(xpath = "(//div[@class='mat-ripple mat-mdc-menu-trigger custom--icon-button' and .//mat-icon[text()='more_vert']])[3]")
    public WebElement noteType;
    @FindBy(xpath = "//span[contains(., 'İnzibatçı təsdiqləyib')]")
    public WebElement selectAdminApproval;
    @FindBy(xpath = "//span[contains(., 'Təsdiqlənməyib')]")
    public WebElement selectAdminNotApproval;
    @FindBy(xpath = "//span[contains(., 'Deaktiv')]")
    public WebElement selectNotApprovedStatus;
    @FindBy(xpath = "//span[contains(., 'Aktiv')]")
    public WebElement selectApprovedStatus;

}