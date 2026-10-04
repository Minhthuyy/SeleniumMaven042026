package com.anhtester.Bai16_ThucHanh;

import com.anhtester.Locators.LocatorsCRM;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThucHanhCustomerCRM extends BaseTest {

    @Test(priority =1)
    public void testAddNewCustomer(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorsCRM.inputEmail, "admin@example.com", 10);
        WebUI.setText(driver, LocatorsCRM.inputPassword, "123456");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkDashboardMenu = WebUI.isElementPresent(driver, LocatorsCRM.menuDashboard, 5);
        Assert.assertTrue(checkDashboardMenu, "Login Fail. The element 'Dashboard' menu is not present.");
    }

}
