package com.anhtester.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ListWebElement_FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(2000);

        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@id='side-menu']/li[contains(@class, 'menu-item')]"));

                //Duyet phan tu trong list WebElement
                for (WebElement menu : listMenu) {
                    System.out.println(menu.getText());
                }

//                //Click xo menu Sales de text xuat hien, sau do moi get List menu
//                driver.findElement(By.xpath("//span[normalize-space()='Sales' and @class")).click();

            List<WebElement> listSubMenuSales = driver.findElements(By.xpath("//span[normalize-space()='Sales']/parent::a/following-sibling::ul//li/a"));
                for (WebElement subMenu : listSubMenuSales) {
                    System.out.println(subMenu.getText());
                }

                driver.quit(); //Tat/thoat trinh duyet
    }
}
