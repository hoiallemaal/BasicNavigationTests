package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {
        test("chrome");
        test("firefox");
        test("edge");

    }

    public static void test(String browserName){
        WebDriver driver=null;

        switch (browserName.toLowerCase()){
            case "chrome":
                driver=chrome();
                break;
            case "edge":
                driver=edge();
                break;
            case "firefox":
                driver=firefox();
                break;
            case "safari":
                driver=safari();
                break;
        }

        //Go to https://google.com
        driver.get("https://google.com");
        //save title
        String expected1=driver.getTitle();
        //go to https://etsy.com
        driver.get("https://etsy.com");
        //save title
        String expected2=driver.getTitle();
        //navigate back
        driver.navigate().back();
        //save title
        String actual1=driver.getTitle();
        //verify 1
        StringUtility.verifyEquals(expected1,actual1);

        //navigate forward
        driver.navigate().forward();
        //save title
        String actual2=driver.getTitle();
        //verify 2
        StringUtility.verifyEquals(expected2,actual2);

        //close browser
        driver.quit();
    }

    public static WebDriver chrome(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //maximize
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver firefox(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("firefox");
        //maximize
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver edge(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("edge");
        //maximize
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver safari(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("safari");
        //maximize
        driver.manage().window().maximize();
        return driver;
    }
}
