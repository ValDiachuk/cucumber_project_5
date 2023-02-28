package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.TechGlobalBase;
import utilities.Driver;

public class TechGlobalFileUploadPage extends TechGlobalBase {
    public TechGlobalFileUploadPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy( id = "file_upload")
    public WebElement fileUpload;

    @FindBy( id = "file_submit")
    public  WebElement uploadButton;

    @FindBy(id = "result")
    public WebElement result;
}
