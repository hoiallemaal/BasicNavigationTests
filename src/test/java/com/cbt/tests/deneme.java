package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deneme {

    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/");

        WebElement username=driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager67");

        WebElement password=driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement login=driver.findElement(By.id("_submit"));
        login.click();

        String expected="Dashboard";
        String actual=driver.getTitle();

        if(expected.equals(actual)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("actual"+actual);
            System.out.println("expected"+expected);

        }
            driver.quit();
    }
}
