package com.anhtester.Bai11_Assert;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {

    @Test
    public void testHardAssert() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.anhtester.com/admin/", "URL is not correct");

        try{
            driver.findElement(By.xpath("//li[contains(@class,'header-user-profile')]")).isDisplayed();
        }catch (Exception e) {
            Assert.fail("Menu Profile is not displayed. Exception: " + e.getMessage());
        }


        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.anhtester.com/admin/", "URL is not correct");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        driver.findElement(By.xpath("//label[text()='Company']/following-sibling::input")).sendKeys("THUY_TEST_1704A1");
        driver.findElement(By.xpath("//input[@id='vat']")).click();
        driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("0364675662");
        driver.findElement(By.id("website")).sendKeys("https://anhtester.com");
        driver.findElement(By.xpath("//button[@data-id='groups_in[]']")).click();
        driver.findElement(By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input")).sendKeys("VIP");
        driver.findElement(By.xpath("//span[normalize-space()='VIP']")).click();
        driver.findElement(By.xpath("//button[@data-id='groups_in[]']")).click();
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("123 Nguyen Van Linh");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Hue");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Hue");
        driver.findElement(By.id("zip")).sendKeys("530000");

        driver.findElement(By.xpath("//button[@data-id='country']")).click();

        driver.findElement(By.xpath("//button[@data-id='country']/following-sibling::div//input")).sendKeys("Vietnam");

        driver.findElement(By.xpath("//span[normalize-space()='Vietnam']")).click();

    }

}
