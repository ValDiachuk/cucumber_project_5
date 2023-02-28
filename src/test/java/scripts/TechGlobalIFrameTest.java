package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramesPage;
import utilities.Waiter;

import java.util.stream.IntStream;

public class TechGlobalIFrameTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramesPage = new TechGlobalIFramesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");

    }
    /*
Go to https://techglobal-training.netlify.app/
Click on “Practices” dropdown in the header
Select the “Frontend Testing” option
Click on the “IFrames” card
Validate the “Please fill out your information below” text
     */
    @Test(priority= 1, description = "Validete input header text")
    public void validateInputText(){

        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);
        Assert.assertTrue(techGlobalIFramesPage.inputHeader.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.inputHeader.getText(), "Please fill out your information below");
        Waiter.pause(3);

    }
    /*
Go to https://techglobal-training.netlify.app/
Click on “Practices” dropdown in the header
Select the “Frontend Testing” option
Click on the “IFrames” card
Enter “John” to first name input box
Enter “Doe” to last name input box
Click on “SUBMIT” button
Validate the result equals “You entered: John Doe”
     */
    @Test(priority = 2, description = "Validate the result equals “You entered: John Doe”")
    public void userInput(){
        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);

        // 2 other ways how to send the key
        /*
        String[] credentials = {"John", "Doe"};
        for(int i = 0; i < credentials.length; i ++)
            techGlobalIFramesPage.inputFields.get(i).sendKeys(credentials[i]);
         */
        /*
        IntStream.range(0, credentials.length).forEach( i -> techGlobalIFramesPage.inputFields.get(i).sendKeys(credentials[i]));
         */

        techGlobalIFramesPage.inputFirstName.sendKeys("John");
        techGlobalIFramesPage.inputLastName.sendKeys("Doe");
        techGlobalIFramesPage.submitButton.click();
        driver.switchTo().defaultContent(); // or driver.switchTo().parentFrame();
        Assert.assertEquals(techGlobalIFramesPage.result.getText(), "You entered: John Doe");
    }
}
