package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class contactInformationEditing_Page {
    public contactInformationEditing_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//td[text()='Abbas Rzayev']")
    public WebElement foundedUser;
}