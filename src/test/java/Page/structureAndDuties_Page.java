package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class structureAndDuties_Page {
    public structureAndDuties_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='mat-mdc-list-item-unscoped-content'])[9]")
    public WebElement controlPanel;
    @FindBy(xpath = "//a[@class='mat-ripple ng-star-inserted active']")
    public WebElement userTab;
    @FindBy(xpath = "//mat-label[text()='Ad']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement nameField;
    @FindBy(xpath = "//mat-label[text()='FİN']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//input")
    public WebElement finField;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    public WebElement searchButton;
    @FindBy(xpath = "(//tr[@role='row'])[2]")
    public WebElement foundedUser;
    @FindBy(xpath = "//span[text()='Struktur və vəzifə dəyişdirilməsi']")
    public WebElement structureAndDutiesChangePage;
    @FindBy(xpath = "//span[text()='Bu şəxsin adından sistemə giriş etmək']")
    public WebElement enterToTheSystemFromAdminPanel;

    @FindBy(xpath = "//h6[contains(text(),'Keyfiyyətə Nəzarət(AT)')]/preceding::button[.//img[contains(@src,'next.svg')]][1]")
    public WebElement openQualityControlStructureParentList;

    @FindBy(xpath = "//h6[contains(text(),'Avtomatlaşdırılma və manual testlər')]")
    public WebElement ATAndManualSector;

    @FindBy(xpath = "//h6[contains(text(),'AISTGroup MMC')]")
    public WebElement openAISTMMCStructureParentList;

    @FindBy(xpath = "//button[.//mat-icon[text()='expand_more']]")
    public WebElement dutiesSearchField;

    @FindBy(xpath = "//div[contains(text(),' Şöbə Müdiri ')]")
    public WebElement selectSectionDirector;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement againNameField;

    @FindBy(xpath = "(//span[@class='mat-mdc-list-item-unscoped-content'])[2]")
    public WebElement perCabinet;

    @FindBy(xpath = "//input[@placeholder='Vəzifə seçin']")
    public WebElement dutyInput;
    @FindBy(xpath = "//mat-label[text()='Ad']/ancestor::label/following-sibling::input")
    public WebElement dutyInputDutyTab;
    @FindBy(xpath = "//mat-label[text()='ID']/ancestor::label/following-sibling::input")
    public WebElement dutyInputDutyIDTab;
    @FindBy(xpath = "//td[normalize-space()='IT Mühəndis(QA)']")
    public WebElement ITDuty;
    @FindBy(xpath = "//td[normalize-space()='IT(edited)']")
    public WebElement ITEditedDuty;

    @FindBy(xpath = "//span[text()='Strukturda yerim və vəzifəm']")
    public WebElement strucAndDutyTab;
    @FindBy(xpath = "(//td[contains(@class, 'cdk-column-id')])[1]")
    public WebElement getDutyID;

    @FindBy(xpath = "//label[@class='item_title active no_child']")
    public WebElement sturckCheck;

    @FindBy(xpath = "//label[text()='İnformasiya texnologiyaları və elektron idarəetmə sektoru']")
    public WebElement informationStruck;
    @FindBy(xpath = "//span[text()=' Sektor müdiri ']")
    public WebElement sectorDirector;
    @FindBy(xpath = "//div[text()=' QA_AT ']")
    public WebElement qaAtPosition;
    @FindBy(xpath = "//div[normalize-space(text())='IT Mühəndis(QA)']")
    public WebElement ITPosition;
    @FindBy(xpath = "(//button[descendant::img[contains(@src, 'edit-colorless.svg')]])[1]")
    public WebElement dutyEditBtn;
    @FindBy(xpath = "//span[text()='Bu şəxsin adından sistemə giriş etmək']")
    public WebElement logInWithThisPerson;
    @FindBy(xpath = "//span[text()='Struktur və vəzifə']")
    public WebElement sdTab;
    @FindBy(xpath = "//span[text()='+ Yeni struktur']")
    public WebElement plusStructur;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement nameStruc;
    @FindBy(xpath = "//input[@formcontrolname='shortName']")
    public WebElement shortNameStruc;
    @FindBy(xpath = "//input[@formcontrolname='orgCode']")
    public WebElement depCode;
    @FindBy(xpath = "//input[@formcontrolname='priority']")
    public WebElement prioField;
    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    public WebElement detailInfo;
    @FindBy(xpath = "//input[@formcontrolname='sun']")
    public WebElement sunInfo;
    @FindBy(xpath = "//input[@formcontrolname='voen']")
    public WebElement tinInfo;
    @FindBy(xpath = "//input[@formcontrolname='address']")
    public WebElement addressInfo;
    @FindBy(xpath = "//span[text()=' Yadda saxla ']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Problemli sınaq şöbələr(test)']")
    public WebElement newStructure;
    @FindBy(xpath = "/html/body/app-root/div/div/main/app-control/div/ng-component/app-structure-tab/mat-card/app-recursive-structure/div/div[6]/div/mat-icon")
    public WebElement openMenu;

    @FindBy(xpath = "//span[text()='Sil']")
    public WebElement deleteButton;

    @FindBy(id = "mat-input-16")
    public WebElement addReason;

    @FindBy(xpath = "(//span[@class='mdc-button__label'])[2]")
    public WebElement acceptDelete;

    @FindBy(xpath = "//a[@class='mat-ripple ng-star-inserted active']")
    public WebElement programsPanel;
    @FindBy(xpath = "//span[text()='Vəzifə']")
    public WebElement dutyTab;
    @FindBy(xpath = "//span[text()='+ Yeni Vəzifə']")
    public WebElement dutyPLus;
    @FindBy(xpath = "//input[@formcontrolname='positionName']")
    public WebElement dutyNameInput;
    @FindBy(xpath = "//input[@formcontrolname='priority']")
    public WebElement priorityInput;
    @FindBy(xpath = "//span[text()=' Yadda saxla ']")
    public WebElement saveEdit;
    @FindBy(xpath = "//mat-dialog-content//meis-custom-toggle//div[contains(@class, 'toggle-switch')]")
    public WebElement newDutyToggleBtn;
    @FindBy(xpath = "(//div[contains(@class, 'toggle-switch')])[1]")
    public WebElement ToggleBtn;
    @FindBy(id = "mat-input-9")
    public WebElement dutySearchField;
    @FindBy(xpath = "//span[text()=' Axtar ']")
    public WebElement dutySearchButton;
    @FindBy(xpath = "//span[normalize-space(text())='Əlavə et']")
    public WebElement dutyAdd;
    @FindBy(xpath = "//td[text()=\"Keyfiyyətə nəzarət(test)\"]")
    public WebElement dutyBackground;
    //label[contains(@class,'QA')] - elementin icinde element axtarishi
    @FindBy(xpath = "//span[text()=' Bəli ']")
    public WebElement yesButton;
    @FindBy(xpath = "//button[descendant::img[contains(@src, 'delete-colorless.svg')]]")
    public WebElement deleteBtn;
    @FindBy(xpath = "//span[text()=' Təsdiqlə ']")
    public WebElement structureAndDutiesSubmit;
    @FindBy(xpath = "//td[text()=' Keyfiyyətə Nəzarət(AT) ']")
    public WebElement QualityControlStructureCheck;
    @FindBy(xpath = "//td[text()=' QA_AT ']")
    public WebElement qaAtPositionTableCheck;
    @FindBy(xpath = "//td[text()=' Şöbə Müdiri ']")
    public WebElement sectorDirectorPositionTableCheck;
    @FindBy(xpath = "//td[text()=' AISTGroup MMC ']")
    public WebElement aistMMCStructureCheck;
    @FindBy(xpath = "//span[text()='Strukturda yerim və vəzifəm']")
    public WebElement mYStructureAndPositionTab;
    @FindBy(xpath = "//h6[contains(., 'Keyfiyyətə Nəzarət(AT)')]")
    public WebElement qaATstructureProfilePage;
    @FindBy(xpath = "//h6[contains(., 'AISTGroup MMC')]")
    public WebElement aistMMCstructureProfilePage;
    @FindBy(xpath = "//h6[contains(., 'Avtomatlaşdırılma və manual testlər')]")
    public WebElement structureSectorProfilePage;
    @FindBy(xpath = "//button[.//img[@alt='openChild' and contains(@src, 'next.svg')]]")
    public WebElement openStructureSectorProfilePage;
    @FindBy(xpath = "//p[contains(., 'Şöbə Müdiri')]")
    public WebElement sectorDirecotrPositionProfilePage;
    @FindBy(xpath = "//p[contains(., 'QA_AT')]")
    public WebElement qaAtPositionProfilePage;
    @FindBy(xpath = "//h6[text()='Avtomatlaşdırılmış Testlər']")
    public WebElement firstStructureName;
    @FindBy(xpath = "//h6[text()='Keyfiyyət mütəxəsisləri']")
    public WebElement secondStructureName;
    @FindBy(xpath = "//h6[text()='Nəzarət şöbəsi']")
    public WebElement departmentNameCheckAdmin;
    @FindBy(xpath = "//h6[text()='Avtomalaşdırma sektoru']")
    public WebElement sectorNameCheckAdmin;
    @FindBy(xpath = "//h6[text()='Avtomatlaşdırılmış Testlər']/following-sibling::mat-icon[contains(text(), 'more_vert')]")
    public WebElement firstStructureSelect;
    @FindBy(xpath = "//h6[normalize-space(text())='Keyfiyyət mütəxəsisləri']/following-sibling::mat-icon[contains(text(), 'more_vert')]")
    public WebElement secondStructureSelect;
    @FindBy(xpath = "//h6[normalize-space(text())='Nəzarət şöbəsi']/following-sibling::mat-icon[contains(text(), 'more_vert')]")
    public WebElement departmentSelect;
    @FindBy(xpath = "//h6[normalize-space(text())='Avtomalaşdırma sektoru']/following-sibling::mat-icon[contains(text(), 'more_vert')]")
    public WebElement sectorSelect;

    @FindBy(xpath = "//span[contains(.,'Baxış')]")
    public WebElement firstStructurePreviewSection;
    @FindBy(xpath = "//span[contains(.,'Redaktə')]")
    public WebElement  StructureEdit;
    @FindBy(xpath = "//span[contains(.,'Sil')]")
    public WebElement  StructureDelete;
    @FindBy(xpath = "//textarea[@aria-required]")
    public WebElement  StructureDeleteInput;
    @FindBy(xpath = "//span[text()=' Təsdiq et ']")
    public WebElement  StructureDeleteAccept;

    @FindBy(xpath = "//span[text()='Yeni']")
    public WebElement  StructureNew;

    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[1]")
    public WebElement firstStructurePreviewSectionName;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[2]")
    public WebElement firstStructurePreviewSectionShort;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[3]")
    public WebElement firstStructurePreviewSectionCode;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[4]")
    public WebElement firstStructurePreviewSectionPriority;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[5]")
    public WebElement firstStructurePreviewSectionSun;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[6]")
    public WebElement firstStructurePreviewSectionTin;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[7]")
    public WebElement firstStructurePreviewSectionStructureAddress;
    @FindBy(xpath = "(//p[@class='ng-star-inserted'])[8]")
    public WebElement firstStructurePreviewSectionDetail;
    @FindBy(xpath = "//span[text()='Bağla']")
    public WebElement closeStructurePreviewModal;
    @FindBy(xpath = "//h6[normalize-space(text())='Keyfiyyət mütəxəsisləri']/ancestor::div[contains(@class, 'list-item-header')]//button")
    public WebElement openStructureList;
    @FindBy(xpath = "//h6[normalize-space(text())='Nəzarət şöbəsi']/ancestor::div[contains(@class, 'list-item-header')]//button")
    public WebElement openDepartmentList;

    @FindBy(xpath = "//h6[normalize-space(text())='Avtomalaşdırma sektoru']")
    public List<WebElement> sectorNameCheck;
    @FindBy(xpath = "//h6[text()='Nəzarət şöbəsi']")
    public List<WebElement> departmentNameCheck;
    @FindBy(xpath = "//h6[text()='Keyfiyyət mütəxəsisləri']")
    public List<WebElement> sectorNameCheckinDelete;

    @FindBy(xpath = "//mat-label[text()='Status']/ancestor::div[contains(@class,'mat-mdc-form-field-infix')]//mat-select")
    public WebElement selectStatusDuty;

    @FindBy(xpath = "//span[text()='Deaktiv']")
    public WebElement selectDeActiveDuty;

    @FindBy(xpath = "//span[text()='Aktiv']")
    public WebElement selectActiveDuty;


}