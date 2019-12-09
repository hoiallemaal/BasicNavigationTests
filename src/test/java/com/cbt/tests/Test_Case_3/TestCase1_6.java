package com.cbt.tests.Test_Case_3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1_6 {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        actions = new Actions(driver);

        actions.pause(5000);

        driver.findElement(By.xpath("//button[@data-dismiss='alert']")).click();

        WebElement activities = driver.findElement(By.partialLinkText("Activities"));
        WebElement calenderEvents = driver.findElement(By.xpath("//*[@*='oro_calendar_event_index']/a"));

        actions.pause(3000);

        actions.moveToElement(activities).pause(2000).moveToElement(calenderEvents).pause(1000).click().build().perform();

        actions.pause(5000);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01() {

        String actual = driver.findElement(By.cssSelector(".btn-group.actions-group>div")).getText();
        String expected = "Options";

        Assert.assertEquals(actual, expected, "Verify options displayed.");
    }

    @Test
    public void test02() {
        String actual = driver.findElement(By.className("input-widget")).getAttribute("value");
        String expected = "1";

        Assert.assertEquals(actual, expected, " Verify Page Number:1 ");
    }

    @Test
    public void test03() {
        String actual = driver.findElement(By.xpath("(//div[@class='btn-group'])[2]")).getText();
        String expected = "25";

        Assert.assertEquals(actual, expected, "Verify that view per page number is 25");
    }

    @Test
    public void test04() {
        actions.pause(1000);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='grid-container']//tbody/tr"));

        int size = rows.size();
        String actual = driver.findElement(By.xpath("//label[contains(text(),'Total')]")).getText();
        String expected = "" + size;
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);

        Assert.assertTrue(actual.contains(expected), "Verify that number of calendar events (rows in the table) is equals to number of records ");

        actions.pause(5000);

    }
}