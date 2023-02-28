package scripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    SoftAssert softAssert;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicElementsPage techGlobalDynamicElementsPage;
    TechGlobalWaitsPage techGlobalWaitsPage;
    TechGlobalRadioButtonsPage techGlobalRadioButtonsPage;
    TechGlobalCheckBoxPage techGlobalCheckBoxPage;
    TechGlobalDropdownsPage techGlobalDropDownsPage;
    TechGlobalMultipleWindowsPage techGlobalMultipleWindowsPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalIFramesPage techGlobalIFramesPage;
    TechGlobalFileUploadPage techGlobalFileUploadPage;
    TechGlobalFileDownloadPage techGlobalFileDownloadPage;

    TechGlobalStaticTablesPage techGlobalStaticTablesPage;
    TechGlobalCalendarPage techGlobalCalendarPage;
    TechGlobalSortableTablePage techGlobalSortableTablePage;
    TechGlobalActionsPage techGlobalActionPage;
    Actions actions;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        softAssert = new SoftAssert();
        techGlobalBasePage = new TechGlobalBasePage();
    }
    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        softAssert.assertAll();
        Driver.quitDriver();
    }
}