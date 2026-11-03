package com.anhtester.Bai16_ThucHanh;

import com.anhtester.Locators.LocatorsCRM;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class ThucHanhCustomerCRM extends BaseTest {

    @BeforeMethod
    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(driver, LocatorsCRM.inputEmail, "admin@example.com", 10);
        WebUI.setText(driver, LocatorsCRM.inputPassword, "123456");
        WebUI.clickElement(driver, By.xpath("//button[normalize-space()='Login']"));

        boolean checkDashboardMenu = WebUI.isElementPresent(driver, LocatorsCRM.menuDashboard, 5);
        Assert.assertTrue(checkDashboardMenu, "Login Fail. The element 'Dashboard' menu is not present.");
    }

    @Test(priority =1)
    public void testAddNewCustomer() {
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Customers']"), 10);
        boolean checkCustomerPage = WebUI.isElementPresent(driver, By.xpath("////span[normalize-space()='Customers Summary']"), 10);
        Assert.assertTrue(checkCustomerPage, "Customer page is not present.");
        WebUI.clickElement(driver, By.xpath("////a[normalize-space()='New Customer']"), 10);


        // Cho form load xong bang ham chung
        if (!WebUI.isElementPresent(driver, By.id("company"), 10)) {
            throw new RuntimeException("Form Add Customer khong load duoc.");
        }

        //Du lieu dung chung cho buoc dien form va buoc verify
        String companyName = "Selenium Auto Test " + System.currentTimeMillis();
        String vat = "0312345678";
        String phone = "0901234567";
        String website = "https://anhtester.com";
        String address = "123 Nguyen Hue";
        String city = "Tra Vinh";
        String state = "Vinh Long";
        String zip = "940000";
        String currency = "USD";
        String language = "Vietnamese";
        String country = "Vietnam";
        String group = "VIP";
        System.out.println(companyName);

        // --- Tab "Customer Details" ---
        WebUI.setText(driver, By.xpath("//input[@id='company']"), companyName, 10);
        WebUI.setText(driver, By.xpath("//input[@id='vat']"), vat);
        WebUI.setText(driver, By.xpath("//input[@id='phonenumber']"), phone);
        WebUI.setText(driver, By.xpath("//input[@id='website']"), website);
        WebUI.setText(driver, By.xpath("//textarea[@id='address']"), address);
        WebUI.setText(driver, By.xpath("//input[@id='city']"), city);
        WebUI.setText(driver, By.xpath("//input[@id='state']"), state);
        WebUI.setText(driver, By.xpath("//input[@id='zip']"), zip);

        // Dropdown selectpicker -> dung helper cuc bo (WebUI chua ho tro)
        selectPickerByText("default_currency", currency);
        selectPickerByText("default_language", language);
        selectPickerByText("country", country);

        //Field "Group" la multi-select, id co dau ngoac: groups_in[]
//        selectPickerByText("groups_in[]", group);

        WebUI.clickElement(driver, By.xpath("//button[@data-id='groups_in[]']"));
        sleep(1);
        WebUI.setText(driver, By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input"), group);
        sleep(1);
        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='" + group + "']"));
        sleep(1);
        WebUI.clickElement(driver, By.xpath("//button[@data-id='groups_in[]']")); //Dong dropdown multi-select

        // --- Save --- (co 2 nut "Save"; nut Submit cua form co class 'only-save')
        WebUI.clickElement(driver, By.xpath("//button[contains(@class,'only-save')]"));

        // Verify the redirect and saved customer details.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlMatches(".*/admin/clients/client/\\d+$"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.matches(".*/admin/clients/client/\\d+$"),
                "Save that bai - URL khong chuyen sang trang profile khach hang: " + currentUrl);
        System.out.println("Save thanh cong - URL chuyen sang trang profile khach hang: " + currentUrl);

        Assert.assertEquals(driver.getTitle(), companyName, "Ten cong ty tren tieu de trang profile khong khop.");

        verifyInputValue(By.id("company"), companyName, "Company");
        verifyInputValue(By.id("vat"), vat, "VAT");
        verifyInputValue(By.id("phonenumber"), phone, "Phone");
        verifyInputValue(By.id("website"), website, "Website");
        verifyInputValue(By.id("address"), address, "Address");
        verifyInputValue(By.id("city"), city, "City");
        verifyInputValue(By.id("state"), state, "State");
        verifyInputValue(By.id("zip"), zip, "Zip");

        verifyPickerValue(By.id("default_currency"), currency, "Currency");
        verifyPickerValue(By.id("default_language"), language, "Language");
        verifyPickerValue(By.id("country"), country, "Country");
        verifyPickerValue(By.id("groups_in[]"), group, "Group");

        System.out.println("Verify thanh cong tat ca cac fields.");
    }

    private void verifyInputValue(By locator, String expectedValue, String fieldName) {
        Assert.assertTrue(WebUI.isElementPresent(driver, locator, 10), "Khong tim thay field '" + fieldName + "' tren trang profile.'");
        String actual = driver.findElement(locator).getAttribute("value");
        Assert.assertEquals(actual, expectedValue, "Field '" + fieldName + "' luu sai. Mong doi: '" + expectedValue + "'; Thuc te: '" + actual + "'");
    }

    private void verifyPickerValue(By locator, String expectedValue, String fieldName) {
        Assert.assertTrue(WebUI.isElementPresent(driver, locator, 10), "Khong tim thay field '" + fieldName + "' tren trang profile.");
        boolean selectedValueFound = driver.findElement(locator)
                .findElements(By.cssSelector("option:checked"))
                .stream()
                .anyMatch(option -> expectedValue.equals(option.getText().trim()));
        Assert.assertTrue(selectedValueFound, "Field '" + fieldName + "' khong co gia tri da chon '" + expectedValue + "'.");
    }


    private void selectPickerByText(String selectId, String visibleText) {
        String js =
                "var sel=document.getElementById(arguments[0]);" +
                        "var found=false;" +
                        "for(var i=0;i<sel.options.length;i++){" +
                        "  if(sel.options[i].text.trim()===arguments[1]){sel.value=sel.options[i].value;found=true;break;}" +
                        "}" +
                        "if(window.jQuery){jQuery(sel).trigger('change');}else{sel.dispatchEvent(new Event('change'));}" +
                        "return found;";

        Object found = ((JavascriptExecutor) driver).executeScript(js, selectId, visibleText);
        if (Boolean.FALSE.equals(found)) {
            throw new RuntimeException("Khong tim thay option '" + visibleText + "' trong select #" + selectId);
        }
    }

}
