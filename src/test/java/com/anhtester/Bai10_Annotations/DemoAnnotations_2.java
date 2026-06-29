package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class DemoAnnotations_2 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Đây là Before Suite 2");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Đây là After Suite 2");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest 2: Chạy trước tất cả các test trong một thẻ <test>");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest 2: Chạy sau tất cả các test trong một thẻ <test>");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass 2: Chạy trước tất cả các test method trong class này");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass 2: Chạy sau tất cả các test method trong class này");
    }


    @Test
    public void test_method_04() {
        System.out.println("Đây là test method 04");
    }

    @Test
    public void test_method_05() {
        System.out.println("Đây là test method 05");
    }

    @Test
    public void test_method_06() {
        System.out.println("Đây là test method 06");
    }
}
