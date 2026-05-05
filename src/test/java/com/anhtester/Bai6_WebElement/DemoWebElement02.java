package com.anhtester.Bai6_WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoWebElement02 {
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

        driver.get("https://angular-reactive-forms-zvzqvd.stackblitz.io/");

        driver.findElement(By.xpath("//span[normalize-space()='Run this project']")).click();

        boolean checkButtonSubmit = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isEnabled();
        System.out.println("Check button Submit: " + checkButtonSubmit);

        boolean checkButtonHacked = driver.findElement(By.xpath("//button[normalize-space()='\"Hacked\" Submit button']")).isEnabled();
        System.out.println("Check button Hacked: " + checkButtonHacked);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        Thread.sleep(2000);

        checkButtonSubmit = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isEnabled();
        System.out.println("Check button Submit 2: " + checkButtonSubmit);

        checkButtonHacked = driver.findElement(By.xpath("//button[normalize-space()='\"Hacked\" Submit button']")).isEnabled();
        System.out.println("Check button Hacked 2: " + checkButtonHacked);

        driver.quit();
    }
}
