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
    @FindBy(id = "mat-input-3")
    public WebElement surename;
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
    @FindBy(xpath = "//td[text()='Abbas Rzayev']")
    public WebElement foundName;
    @FindBy(xpath = "//input[contains(@formcontrolname, 'pin')]")
    public WebElement finField;
    @FindBy(xpath = "(//p[@class='preview-text ng-star-inserted'])[3]")
    public WebElement fintext;
    @FindBy(id = "mat-input-19")
    public WebElement workPlaceInput;
    @FindBy(xpath = "(//td[text()='Azərbaycan Metrologiya İnstitutu'])[1]")
    public WebElement workPlace;
    @FindBy(xpath = "//span[text()=' Axtar ']")
    public WebElement searchBtn;
    @FindBy(css = "tbody.mat-mdc-row")
    public WebElement workClass;
}