package com.anhtester.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class Checkbox {
        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();

            driver.get("https://demoqa.com/select-menu");
            Thread.sleep(2000);
            //Scroll đến element
            WebElement element = driver.findElement(By.xpath("//h1[normalize-space()='Select Menu']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

//            //Tạo class Select từ Selenium
//            Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
//
//            Thread.sleep(2000);

            // Locate dropdown
            WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));

            // Click để xổ dropdown ra
            dropdown.click();

            Thread.sleep(2000);

            // Tạo class Select
            Select select = new Select(dropdown);
            //Select option theo text hiển thị
            select.selectByVisibleText("Blue");

            Thread.sleep(1000);
            //Get giá trị sau khi đã chọn
            System.out.println(select.getFirstSelectedOption().getText());

            Thread.sleep(1000);
            driver.quit();
        }


    private static void closeDriver() {
    }

    private static void createDriver() {
    }
}
