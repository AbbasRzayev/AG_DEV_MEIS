package Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class meisAndProgramLogs_Page {

    public meisAndProgramLogs_Page() {PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath = "//span[text()='MEİS və proqramlara giriş']")
    public WebElement meisProgramLogTab;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-date')])[1]")
    public WebElement meisDate;
    @FindBy(xpath = "(//tbody[contains(@class,'mdc-data-table__content')])[2]//tr[1]")
    public WebElement programTime;
}


