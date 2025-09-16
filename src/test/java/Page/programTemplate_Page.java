package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class programTemplate_Page {
    public programTemplate_Page() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//span[normalize-space()='Şablonlar']")
    public WebElement programTemplatesTabAdmin;
    @FindBy(xpath = "//span[normalize-space()='Yeni şablon']")
    public WebElement newTemplatesButton;
    @FindBy(xpath = "//mat-label[normalize-space(.)='Şablon adı']/ancestor::label/following-sibling::input")
    public WebElement programTemplateNameInput;
    @FindBy(xpath = "//button[.//mat-icon[text()='expand_more']]")
    public WebElement dutySelection;
    @FindBy(xpath = "//div[normalize-space()='Proqramçı']")
    public WebElement programmerDuty;
    @FindBy(xpath = "//div[normalize-space()='IT Mühəndis(QA)']")
    public WebElement qaDuty;
    @FindBy(xpath = "//h6[normalize-space()='AISTGroup MMC']")
    public WebElement aistStructure;
    @FindBy(xpath = "//h6[normalize-space()='Keyfiyyətə Nəzarət(AT)']")
    public WebElement qualityStructure;
    @FindBy(xpath = "//span[normalize-space()='Növbəti']")
    public WebElement nextTemplate;
    @FindBy(xpath = "//p[normalize-space()='Elektron Sənəd Dövriyyəsi']")
    public WebElement programTemplateElectronDocument;
    @FindBy(xpath = "(//div[@class='toggle-switch'])[1]")
    public WebElement programFirstSwitcherTemplate;
    @FindBy(xpath = "(//p[contains(@class,'name')])[1]")
    public WebElement programFirstProgramTemplate;
    @FindBy(xpath = "//span[normalize-space()='Təsdiq']")
    public WebElement acceptTemplate;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-name')])[1]")
    public WebElement checkTempName;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-organizationPositionName')])[1]")
    public WebElement checkTempDuty;
    @FindBy(xpath = "(//td[contains(@class,'mat-column-structureOfOrganizationName')])[1]")
    public WebElement checkTempStructure;
    @FindBy(xpath = "(//td[contains(@class,'cdk-column-softwareCount')])[1]")
    public WebElement checkTempCount;
    @FindBy(xpath = "//button[.//img[contains(@src,'delete-colorless.svg')]]")
    public WebElement deleteTemplate;
    @FindBy(xpath = "//span[normalize-space()='Bəli']")
    public WebElement deleteYesTemplate;
}