package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2_9 {

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
    public void test9() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://practice-cybertekschool.herokuapp.com/");

        WebElement codes=driver.findElement(By.linkText("Status Codes"));
        codes.click();

        WebElement click200=driver.findElement(By.xpath("(//ul/li/a)[2]"));
        click200.click();

        WebElement codes200=driver.findElement(By.xpath("//p"));   //p/text()[1]
        codes200.getText();
        System.out.println(codes200.getText());

       String actual=codes200.getText();
       String expect="This page returned a 200 status code.";
       Assert.assertTrue(actual.equals(expect),"verifys if the result of the status codes is true");

    }
}
