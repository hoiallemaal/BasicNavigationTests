package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2_7 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
      // driver.quit();
    }
    @Test
    public void test7() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement upload=driver.findElement(By.xpath("//ul/li[18]/a"));
        upload.click();
        //*[@id="content"]/ul/li[18]/a
        WebElement choose1=driver.findElement(By.name("file"));
        choose1.click();
        choose1.sendKeys("/OneDrive/Pictures/Secreenshots/aa");

        WebElement uploads=driver.findElement(By.id("file-submit"));
        uploads.click();
    }
}
