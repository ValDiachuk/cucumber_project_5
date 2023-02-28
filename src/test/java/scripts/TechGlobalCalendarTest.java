package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCalendarPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TechGlobalCalendarTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCalendarPage = new TechGlobalCalendarPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Calendar");

    }
    @Test(priority = 1, description = "validate date picker")
    public void validateDatePicker(){
        techGlobalCalendarPage.calendarButton.click();
        int year = 2024, month = 5, day = 16;
        String monthString = String.valueOf(Month.of(month).toString().charAt(0) + Month.of(month).toString().charAt(1));
        techGlobalCalendarPage.navigateToYearAndMonth(2024, "May");
        Waiter.pause(3);
        techGlobalCalendarPage.clickOnDate(day);
        LocalDate selectLocalDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
        String expectedDate = selectLocalDate.format(formatter);

        Assert.assertEquals(techGlobalCalendarPage.result.getText(), "You have selected " + expectedDate + ".");
    }
}
