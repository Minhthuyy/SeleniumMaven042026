package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class DemoAnnotations_1 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Đây là Before Suite 1");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Đây là After Suite 1");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest 1: Chạy trước tất cả các test trong một thẻ <test>");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest 1: Chạy sau tất cả các test trong một thẻ <test>");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass 1: Chạy trước tất cả các test method trong class này");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass 1: Chạy sau tất cả các test method trong class này");
    }


    @Test
    public void test_method_01() {
        System.out.println("Đây là test method 01");
    }

    @Test
    public void test_method_02() {
        System.out.println("Đây là test method 02");
    }

    @Test
    public void test_method_03() {
        System.out.println("Đây là test method 03");
    }
}
