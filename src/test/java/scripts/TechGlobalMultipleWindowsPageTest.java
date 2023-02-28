package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalMultipleWindowsPage;
import utilities.Waiter;
import utilities.WindowHandler;

public class TechGlobalMultipleWindowsPageTest extends TechGlobalBase{
    @BeforeMethod
    public  void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalMultipleWindowsPage = new TechGlobalMultipleWindowsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Multiple Windows");
    }
    @Test(priority = 1, description = "Validate the apple link")
    public void validateTheAppleLink(){
        Waiter.pause(2);

        //before clicking on Apple link

        String mainWindow = driver.getWindowHandle();
        techGlobalMultipleWindowsPage.links.get(0).click();

        for(String windowId: driver.getWindowHandles()){
            if(!windowId.equals(mainWindow)){
                driver.switchTo().window(windowId);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), "Apple");
        driver.close();

        // go back to TechGlobal page and validate that URL contains techglobal

        driver.switchTo().window(mainWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));
    }
    @Test(priority = 2, description = "Validate link urls")
    public void validateLinkURLs(){
        String[] urls = {"https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/"};

        for (int i = 0; i < techGlobalMultipleWindowsPage.links.size(); i++) {
            techGlobalMultipleWindowsPage.links.get(i).click();

            WindowHandler.switchToChildWindow();

            Assert.assertEquals(driver.getCurrentUrl(), urls[i]);
            driver.close();
            WindowHandler.switchBackToParentWindow();
            }

        }
    }

