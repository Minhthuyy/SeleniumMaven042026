package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.LocalStorageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoJSExecutor extends BaseTest {
    @Test
    public void testDemo01(){
        driver.get("https://cms.anhtester.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value', 'admin@example.com');", driver.findElement(By.xpath("//input[@id='email']")));
        js.executeScript("arguments[0].setAttribute('value', '123456');", driver.findElement(By.xpath("//input[@id='password']")));
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[normalize-space()='Login']")));

        try {
            driver.findElement(By.xpath("//span[normalize-space()='Dashboard']"));
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail("Failed to login");
        }

        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
    }

    @Test
    public void testDemo02(){
        driver.get("https://anhtester.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,500)");
        sleep(1);
        js.executeScript("window.scrollTo(0,1000)");
        sleep(1);
        js.executeScript("window.scrollTo(0,1500)");
        sleep(1);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        sleep(1);


        System.out.println(js.executeScript("return window.innerHeight;").toString());
        System.out.println(js.executeScript("return window.innerWidth;").toString());

//        js.executeScript("window.location = 'https://facebook.com/anhtester'");

        sleep(3);
    }

    @Test
    public void testDemo03(){
        driver.get("https://anhtester.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Giá trị true là cuộn nằm phía trên
        //Giá trị false là cuộn nằm phía dưới
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//h2[contains(text(),'Khoá học mới nhất')]")));
        sleep(3);
    }

    @Test
    public void testDemo04(){
        driver.get("https://anhtester.com");
        LocalStorageUtils.setValueToLocalStorage(driver, "email", "admin@example.com");
        driver.findElement(By.xpath("//a[@class='btn btn-primary d-inline-flex align-items-center me-2']")).click();
        sleep(1);

        String emailFromLocalStorage = LocalStorageUtils.getValueFromLocalStorage(driver, "email");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailFromLocalStorage);
        sleep(3);
    }

    @Test
    public void testDemo05(){
        driver.get("https://cms.anhtester.com/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//input[@id='email']")));
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
//
//        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//input[@id='password']")));
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
//
//        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//button[@type='submit']")));
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebUI.setText(driver , By.xpath("//input[@id='email']"), "admin@example.com");
        sleep(1);
        WebUI.setText(driver , By.xpath("//input[@id='password']"), "123456");
        sleep(1);
        WebUI.clickElement(driver , By.xpath("//button[@type='submit']"));
        sleep(3);

    }
}
