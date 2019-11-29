package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2 {

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
    public void test1() throws InterruptedException {

        driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement clickregister = driver.findElement(By.linkText("Registration Form"));
        clickregister.click();
        WebElement dob = driver.findElement(By.name("birthday"));
        dob.sendKeys("wrong_dob");

        WebElement getdob = driver.findElement(By.xpath("//small[@*='date']"));
        Thread.sleep(3000);

        System.out.println(getdob.getText());
        Assert.assertTrue(getdob.isDisplayed(), "verify that warning message is displayed  ");
    }
    @Test
    public void test2() throws InterruptedException {
       driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement clickregister = driver.findElement(By.linkText("Registration Form"));
        clickregister.click();

        WebElement cplus=driver.findElement(By.xpath("//label[@*='inlineCheckbox1']"));
        System.out.println(cplus.getText());
        Assert.assertTrue(cplus.isDisplayed(), "verify that c++ is displayed  ");

        WebElement java=driver.findElement(By.xpath("//label[@*='inlineCheckbox2']"));
        System.out.println(java.getText());
        Assert.assertTrue(cplus.isDisplayed(), "verify that c++ is displayed  ");

        WebElement javaScript=driver.findElement(By.xpath("//label[@*='inlineCheckbox3']"));
        System.out.println(javaScript.getText());
        Assert.assertTrue(cplus.isDisplayed(), "verify that c++ is displayed  ");

    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement clickregister = driver.findElement(By.linkText("Registration Form"));
        clickregister.click();

        WebElement name1=driver.findElement(By.name("firstname"));
        name1.sendKeys("a");
        WebElement warning=driver.findElement(By.xpath("(//small[@*='stringLength'])[1]"));
        String actualmessage=warning.getText();
        System.out.println(warning.getText());

        String expectedmessage="first name must be more than 2 and less than 64 characters long";
        Assert.assertTrue(actualmessage.equals(expectedmessage));


    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement clickregister = driver.findElement(By.linkText("Registration Form"));
        clickregister.click();

        WebElement name1=driver.findElement(By.name("lastname"));
        name1.sendKeys("a");
        WebElement warning=driver.findElement(By.xpath("(//small[@*='stringLength'])[2]"));
        String actualmessage=warning.getText();
        System.out.println(warning.getText());

        String expectedmessage="The last name must be more than 2 and less than 64 characters long";
        Assert.assertTrue(actualmessage.equals(expectedmessage));

}

    @Test
    public void test5() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement clickregister = driver.findElement(By.linkText("Registration Form"));
        clickregister.click();

        WebElement name1=driver.findElement(By.name("firstname"));
        Thread.sleep(1000);
        name1.sendKeys("Mike");


        WebElement lastname=driver.findElement(By.name("lastname"));
        Thread.sleep(1000);
        lastname.sendKeys("Smith");


        WebElement username=driver.findElement(By.name("username"));
        Thread.sleep(1000);
        username.sendKeys("MikeSmith1");

        WebElement email=driver.findElement(By.name("email"));
        Thread.sleep(1000);
        email.sendKeys("hazretinohut@yandex.com");


        WebElement password=driver.findElement(By.name("password"));
        Thread.sleep(1000);
        password.sendKeys("+18624534678");


        WebElement phone=driver.findElement(By.name("phone"));
        Thread.sleep(1000);
        phone.sendKeys("571-000-0000");


        WebElement gend=driver.findElement(By.name("gender"));
        Thread.sleep(1000);
        gend.click();


        WebElement birthday=driver.findElement(By.name("birthday"));
        Thread.sleep(1000);
        birthday.sendKeys("09/03/1980");


        WebElement department=driver.findElement(By.name("department"));
        Thread.sleep(2000);
        Select departmentList=new Select(department);
        departmentList.selectByIndex(1);

        WebElement job=driver.findElement(By.name("job_title"));
        Thread.sleep(2000);
        Select jobList=new Select(job);
        jobList.selectByIndex(4);

        WebElement clickJava=driver.findElement(By.id("inlineCheckbox2"));
        clickJava.click();

        WebElement signUp=driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        WebElement done=driver.findElement(By.xpath("//div/p"));
        System.out.println(done.getText());

        String actualmessage=done.getText();
        String expectedmessage="You've successfully completed registration!";
        Assert.assertTrue(actualmessage.equals(expectedmessage));
    }
}
