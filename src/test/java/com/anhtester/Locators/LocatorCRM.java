package com.anhtester.Locators;

import org.openqa.selenium.By;

public class LocatorCRM {
    public static By inputEmail = By.id("email");
    public static By inputPassword = By.id("password");
    public static By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    public static By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public static By alertErrorMessage = By.xpath("//div[@class='text-center alert alert-danger']");

}
