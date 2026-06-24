package com.anhtester.Bai10_Annotations;

import org.testng.annotations.Test;

public class DemoTest {

    @Test(priority = 1, description = "Test Login CRM success")
    public void testLoginCRM() {
        System.out.println("Đây là test case login CRM");
    }

    @Test(priority = 2, description = "Test Logout CRM success")
    public void testLogoutCRM() {
        System.out.println("Đây là test case logout CRM");
    }

    @Test(priority = 3, description = "Test login thất bại với email không hợp lệ")
    public void testLoginFailWithInvalidEmal() {
        System.out.println("Đây là test case login thất bại với email không hợp lệ");
    }
}
