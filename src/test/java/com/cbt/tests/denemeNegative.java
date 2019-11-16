package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class denemeNegative {
    public static void main(String[] args) {



    WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");

    WebElement username=driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager");

    WebElement password=driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

    WebElement login=driver.findElement(By.id("_submit"));
        login.click();

        String expected="Login";
        String actual=driver.getTitle();

        StringUtility.verifyEquals(expected,actual);
        driver.quit();


}
}