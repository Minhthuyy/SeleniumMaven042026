package com.anhtester.Bai13_AlertPopupIFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        //Click vào nút "Click Me" thứ nhất
        driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert1 = driver.switchTo().alert();
        //Dùng hàm accept() để xác nhận Alert (tương ứng click vào nút OK)
        alert1.accept();
        //Hoặc là dùng như này (Annonimous)
        //driver.switchTo().alert().accept();

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertDismiss() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        //Click vào nút "Click Me" thứ hai
        driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();
        //Dùng hàm dismiss() để từ chối Alert (tương ứng click vào nút Cancel)
        alert2.dismiss();

        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "You pressed Cancel!");


        //Click vào nút "Click Me" thứ hai
        driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        //Dùng hàm dismiss() để từ chối Alert (tương ứng click vào nút Cancel)
        alert2.accept();

        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "You pressed OK!");
        Thread.sleep(1000);


    }
}
