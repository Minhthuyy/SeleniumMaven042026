package com.anhtester.Bai6_WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoWebElement03 {
    public static boolean isElementDisplayed(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        System.out.println(loginButton.getCssValue("background-color"));
        System.out.println(loginButton.getCssValue("font-size"));
        System.out.println(loginButton.getCssValue("font-family"));

        driver.findElement(By.xpath("//input[@type='password']")).submit();
        Thread.sleep(2000);





        String InvoicesAwaitingPayment = driver.findElement(By.xpath("//div[normalize-space()='Invoices Awaiting Payment']/following-sibling::span")).getText();
        System.out.println("Invoices Awaiting Payment: " + InvoicesAwaitingPayment);

        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//table[@id='clients']/tbody//tr[1]/td[3]/a")).getText());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//table[@id='clients']/tbody//tr[1]/td[3]/a")).click();
        Thread.sleep(2000);




        driver.quit();
    }
}
