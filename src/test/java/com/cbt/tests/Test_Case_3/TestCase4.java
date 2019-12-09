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

import java.lang.reflect.Array;
import java.util.List;

public class TestCase4 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testcase2() throws InterruptedException {
        driver.get("https://qa1.vytrack.com");

        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager85");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement click = driver.findElement(By.id("_submit"));
        click.click();

        Actions actions = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("(//li/a/span)[17]"));
        Thread.sleep(2000);
        actions.moveToElement(activities).perform();
        //activities.click();  19
        Thread.sleep(2000);
        WebElement calendar = driver.findElement(By.xpath("(//li/a/span)[19]"));
        Thread.sleep(3000);
        actions.moveToElement(calendar).click().perform();
        Thread.sleep(5000);

        WebElement records=driver.findElement(By.xpath("(//label[contains(@*,'dib')])[3]"));
        String rec=records.getText();
        //System.out.println(records.getText());

        String [] arr = rec.split(" ");
      //  System.out.println(arr[2]);
        String b=arr[2];

        String numberAsString=b;

     //   System.out.println(numberAsString);

        int number=Integer.parseInt(numberAsString);

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table/tbody/tr"));
        int d=allRowsWithoutHeader.size();
       // System.out.println("allRowsWithoutHeader = " + d);

        Assert.assertTrue(number==d);

// good test case, first i locate the number of records, then i took this string and with string manupilation
// 1. split string into arrays and i took the 3rd element of the array. then with the parseInt method,
      // i convert the strin into number. then i found the row number with list<Webelement> .then i look with
        //assert true method if they areequal. but .equals did not work so i used "=="
    }
}