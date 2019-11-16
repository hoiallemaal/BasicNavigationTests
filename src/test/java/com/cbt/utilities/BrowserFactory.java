package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browserType) {
        WebDriver driver=null;

        String osName =System.getProperty("os.name");

        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "safari":
                if(osName.contains("windows")){
                    driver=null;
                }else{
                    driver=new SafariDriver();
                }
                break;
            case "edge":
                if(osName.contains("ios")){
                    driver=null;
                }else {
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver=new OperaDriver();
                break;
        }
        return driver;
    }
}
