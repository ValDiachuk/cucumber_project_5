package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.TechGlobalBase;
import utilities.Driver;

public class TechGlobalWaitsPage extends TechGlobalBase {
    public TechGlobalWaitsPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(css = "button[id='red'")
    public WebElement redBoxButton;

}
