package com.cbt.tests.Test_Case_3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
}

    @Test
    public void testcase1() throws InterruptedException {
        driver.get("https://qa1.vytrack.com");

        WebElement username=driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager85");

        WebElement password=driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement click=driver.findElement(By.id("_submit"));
        click.click();

        Actions actions = new Actions(driver);
       WebElement activities = driver.findElement(By.xpath("(//li/a/span)[17]"));
        Thread.sleep(2000);
       actions.moveToElement(activities).perform();
       //activities.click();  19
        Thread.sleep(2000);
       WebElement calendar=driver.findElement(By.xpath("(//li/a/span)[19]"));
       Thread.sleep(3000);
       actions.moveToElement(calendar).click().perform();
       Thread.sleep(5000);

       WebElement options=driver.findElement(By.xpath("(//div[contains(@class,'btn btn-link')])[2]"));
        Thread.sleep(5000);

        String actual=options.getText();
        String expected="Options";
        System.out.println(options.getText());
       Assert.assertTrue(expected.equals(actual));

        Assert.assertTrue(options.isDisplayed(),"options is displayed");


    }
}
