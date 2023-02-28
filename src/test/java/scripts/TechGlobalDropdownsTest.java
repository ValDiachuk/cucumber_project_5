package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropDownsPage = new TechGlobalDropdownsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");
    }

    @Test(priority = 1, description = "Select Delivery option")
    public void selectDeliveryOption(){
        DropdownHandler.clickOnDropdownOption(techGlobalDropDownsPage.deliveryDropdown,
                techGlobalDropDownsPage.deliveryDropdownOptions,
                "Delivery");
    }

    @Test(priority = 2, description = "Select iPhone 14 Pro Max option")
    public void selectProductOption(){
        DropdownHandler.selectByVisibleText(techGlobalDropDownsPage.productDropdown, "iPhone 14 Pro Max");
    }

    @Test(priority = 3, description = "Select Yellow options")
    public void selectColorOption(){
        DropdownHandler.selectByIndex(techGlobalDropDownsPage.colorDropdown, 1);
    }

    @Test(priority = 4, description = "Validate the selected item message")
    public void validateTheItemSelected(){
        DropdownHandler.selectByIndex(techGlobalDropDownsPage.productDropdown, 3);
        DropdownHandler.selectByVisibleText(techGlobalDropDownsPage.colorDropdown, "Silver");
        DropdownHandler.clickOnDropdownOption(techGlobalDropDownsPage.deliveryDropdown,
                techGlobalDropDownsPage.deliveryDropdownOptions, "Delivery");

        techGlobalDropDownsPage.submitButton.click();
        Assert.assertEquals(techGlobalDropDownsPage.resultMessage.getText(), "Your Silver MacBook Pro 13 will be delivered to you.");
        Waiter.pause(5);
    }
}