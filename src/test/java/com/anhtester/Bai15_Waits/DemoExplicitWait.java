package com.anhtester.Bai15_Waits;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait extends BaseTest {

    @Test
    public void tesExplicitWait(){
        driver.get("http://hrm.anhtester.com/erp/login");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iusername")));
//        driver.findElement(By.id("iusername")).sendKeys("admin_example");

        WebUI.setText(driver, By.id("iusername"), "admin_example", 3);


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ipassword")));
//        driver.findElement(By.id("ipassword")).sendKeys("123456");

        WebUI.setText(driver, By.id("ipassword"), "123456", 3);

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebUI.clickElement(driver, By.xpath("//button[@type='submit']"),3);

        //Kiểm tra xem element có xuất hiện hay không
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Home']")));

        boolean isElementPresent = WebUI.isElementPresent(driver, By.xpath("//span[normalize-space()='Home']"), 4);
        Assert.assertTrue(isElementPresent, "Login Fail. The element 'Home' menu is not present.");
    }
}
