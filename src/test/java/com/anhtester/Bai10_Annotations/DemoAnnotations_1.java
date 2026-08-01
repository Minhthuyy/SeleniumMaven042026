package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class DemoAnnotations_1 extends ParentTestClass {
    @BeforeSuite
    public void beforeSuiteParent() {
        System.out.println("Đây là Before Suite 1");
    }

    @AfterSuite
    public void afterSuiteParent() {
        System.out.println("Đây là After Suite 1");
    }

    @BeforeTest
    public void beforeTestParent() {
        System.out.println("BeforeTest 1: Chạy trước tất cả các test trong một thẻ <test>");
    }

    @AfterTest
    public void afterTestParent() {
        System.out.println("AfterTest 1: Chạy sau tất cả các test trong một thẻ <test>");
    }

    @BeforeClass
    public void beforeClassParent() {
        System.out.println("BeforeClass 1: Chạy trước tất cả các test method trong class này");
        System.out.println("Thực hiện Login trước test case trong class này bằng email password");
    }

    @AfterClass
    public void afterClassParent() {
        System.out.println("AfterClass 1: Chạy sau tất cả các test method trong class này");
    }

    @BeforeGroups("smoke")
    public void beforeGroupParent() {
        System.out.println("BeforeGroup 1: Chạy trước nhóm smoke");
    }

    @BeforeMethod
    public void beforeMethodParent() {
        System.out.println("BeforeMethod 1: Chạy trước mỗi phương thức test - Mở Browser");
    }

    @AfterMethod
    public void afterMethodParent() {
        System.out.println("AfterMethod 1: Chạy sau mỗi phương thức test - Đóng Browser");
    }

    @Test(groups = "smoke")
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
