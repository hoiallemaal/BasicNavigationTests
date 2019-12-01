package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2_8 {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
         //driver.quit();
    }

    @Test
    public void test8() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://practice-cybertekschool.herokuapp.com/");

      WebElement acomp=driver.findElement(By.linkText("Autocomplete"));
      acomp.click();

      WebElement enter=driver.findElement(By.cssSelector("#myCountry"));
      enter.sendKeys("United S");
      WebElement enterchoose=driver.findElement(By.xpath("//strong"));
      enterchoose.click();

      WebElement submit=driver.findElement(By.xpath("(//input)[2]"));
      Thread.sleep(1000);
      submit.click();

      WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        String actual=result.getText();
        String expect="You selected: United States of America";

        Assert.assertTrue(actual.equals(expect),"verify that the result is true");


    }
}