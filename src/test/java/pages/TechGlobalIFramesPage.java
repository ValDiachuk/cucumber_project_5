package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class TechGlobalIFramesPage extends TechGlobalBasePage {

public TechGlobalIFramesPage(){
    super();

}
    @FindBy(css = "#name_form>p")
    public WebElement inputHeader;

    @FindBy(css="#form_frame")
    public WebElement iFrameId;

    @FindBy(id = "first_name")
    public WebElement inputFirstName;

    @FindBy(id = "last_name")
    public WebElement inputLastName;

    @FindBy(css = ".input")
    public List<WebElement> inputFields; // for 2 other ways how I can send the key

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "result")
    public WebElement result;

}
