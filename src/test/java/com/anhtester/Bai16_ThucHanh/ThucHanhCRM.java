package com.anhtester.Bai16_ThucHanh;

import com.anhtester.Locators.LocatorCRM;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThucHanhCRM extends BaseTest {

    @Test
    public void testLoginCRM_Success(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "admin@example.com", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "123456");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkDashboardMenu = WebUI.isElementPresent(driver, LocatorCRM.menuDashboard, 5);
        Assert.assertTrue(checkDashboardMenu, "Login Fail. The element 'Dashboard' menu is not present.");
    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "admin123@example.com", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "123456");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkAlertErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertErrorMessage, 5);
        Assert.assertTrue(checkAlertErrorMessage, "Login Fail. The element 'Alert Error Message' is not present.");
    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "admin@example.com", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "654321");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkAlertErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertErrorMessage, 5);
        Assert.assertTrue(checkAlertErrorMessage, "Login Fail. The element 'Alert Error Message' is not present.");

        Assert.assertEquals(driver.findElement(LocatorCRM.alertErrorMessage).getText(), "Invalid email or password");
    }

    @Test
    public void testLoginFailWithEmailNull(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "654321");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkAlertErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertErrorMessage, 5);
        Assert.assertTrue(checkAlertErrorMessage, "Login Fail. The element 'Alert Error Message' is not present.");

        Assert.assertEquals(driver.findElement(LocatorCRM.alertErrorMessage).getText(), "The Email Address field is required.");

    }

    @Test
    public void testLoginFailWithPasswordNull(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "admin@example.com", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkAlertErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertErrorMessage, 5);
        Assert.assertTrue(checkAlertErrorMessage, "Login Fail. The element 'Alert Error Message' is not present.");

        Assert.assertEquals(driver.findElement(LocatorCRM.alertErrorMessage).getText(), "The Password field is required.");

    }

    @Test
    public void testLoginFailWithEmailAndPasswordNull(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkEmailErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertEmailRequiredMessage, 5);
        Assert.assertTrue(checkEmailErrorMessage, "Login Fail. The Email Error Message is not present.");

        boolean checkPasswordErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertPasswordRequiredMessage, 5);
        Assert.assertTrue(checkPasswordErrorMessage, "Login Fail. The Password Error Message is not present.");

        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.anhtester.com/admin/authentication", "The Current URL is not correct");
    }





}
