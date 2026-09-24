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
        WebUI.setText(driver, LocatorCRM.inputPassword, "123456", 10);
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkDashboardMenu = WebUI.isElementPresent(driver, LocatorCRM.menuDashboard, 5);
        Assert.assertTrue(checkDashboardMenu, "Login Fail. The element 'Dashboard' menu is not present.");
    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorCRM.inputEmail, "admin123@example.com", 10);
        WebUI.setText(driver, LocatorCRM.inputPassword, "123456", 10);
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkAlertErrorMessage = WebUI.isElementPresent(driver, LocatorCRM.alertErrorMessage, 5);
        Assert.assertTrue(checkAlertErrorMessage, "Login Fail. The element 'Alert Error Message' is not present.");
    }




}
