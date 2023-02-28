package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.Duration;

public class TechGlobalActionTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionPage = new TechGlobalActionsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
        actions = new Actions(driver);
    }

    /*
    Go to https://techglobal-training.netlify.app/
    Click on the "Practices" dropdown in the header
    Select the "Frontend Testing" option from the dropdown menu
    Click on the "Actions" card
    Verify that the user is redirected to the Actions page
    Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
    Perform a click action on the first web element labeled as "Click on me"
    Verify that  message appears next of the element stating "You clicked on a button!"
    Perform a right click action on the second web element labeled as "Right-Click on me""
    Verify that  message appears next of the element stating "You right-clicked on a button!"
    Perform a double click action on the third web element labeled as "Double-Click on me"
    Verify that  message appears next of the element stating "You double-clicked on a button!"
     */
    @Test(priority = 1, description = "Click first 3 boxes ad validate result")
    public void clickActions() {
        actions.moveToElement(techGlobalActionPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionPage.clickResult.getText(), "You clicked on a button!");

        actions.moveToElement(techGlobalActionPage.rightClickBox).contextClick().perform();
        Assert.assertEquals(techGlobalActionPage.rightClickResult.getText(), "You right-clicked on a button!");

        actions.moveToElement(techGlobalActionPage.doubleClickBox).doubleClick().perform();
        Assert.assertEquals(techGlobalActionPage.DoubleClickResult.getText(), "You double-clicked on a button!");
    }

    /*
Go to https://techglobal-training.netlify.app/
Click on the "Practices" dropdown in the header
Select the "Frontend Testing" option from the dropdown menu
Click on the "Actions" card
Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
Verify that a message appears next to the  web element stating "An element dropped here!"
     */
    @Test(priority = 2, description = "Drag and Drop action")
    public void dragAndDropAction() {
        actions.moveToElement(techGlobalActionPage.dragMeBox).clickAndHold()
                .moveToElement(techGlobalActionPage.dropHereBox).release().perform();

        actions.dragAndDrop(techGlobalActionPage.dragMeBox, techGlobalActionPage.dropHereBox).perform();

        Waiter.waitForVisibilityOfElement(techGlobalActionPage.dragDropResult, 10);
        Assert.assertEquals(techGlobalActionPage.dragDropResult.getText(), "An element dropped here!");
    }

    /*
Go to https://techglobal-training.netlify.app/
Click on the "Practices" dropdown in the header
Select the "Frontend Testing" option from the dropdown menu
Click on the "Actions" card
Go to input box, and remove existing text inside
Enter “Hello” to search input box
Validate value attribute is “Hello”
     */
    @Test(priority = 3, description = "Validate keyboard actions")
    public void keyboardActions() {
        actions.keyDown(Keys.SHIFT).sendKeys(techGlobalActionPage.inputBox, "h")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys("ello")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"), "Hello");
    }

    /*
Go to https://techglobal-training.netlify.app/
Click on the "Practices" dropdown in the header
Select the "Frontend Testing" option from the dropdown menu
Click on the "Actions" card
Go to input box, and remove existing text inside
Enter “techglobal” to input box with uppercases
Validate the value attribute for search input box is “TECHGLOBAL”
Then, copy the text and paste again
Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */
    @Test(priority = 4, description = "Validate ....")
    public void moreKeyBoardActions() {
        techGlobalActionPage.inputBox.clear();
        actions.keyDown(Keys.SHIFT).sendKeys(techGlobalActionPage.inputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                        .keyDown(Keys.CONTROL)
                        .sendKeys("a")
                .pause(Duration.ofSeconds(2))
                        .sendKeys("c")
                                .keyUp(Keys.CONTROL)
                                        .sendKeys(Keys.ARROW_RIGHT)
                                                .keyDown(Keys.CONTROL)
                                                        .sendKeys("v")
                .pause(Duration.ofSeconds(2))
                        .perform();

       Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");

    }
}
