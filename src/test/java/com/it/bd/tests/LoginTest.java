package com.it.bd.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.LoginPage;
import com.it.bd.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeTest
    public void openUrl(){
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Login page test</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }
    @Test(priority = 0)
    public void loginButtonTest() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN Button TEST</b></p>");
        LoginPage loginPage = new LoginPage(childTest);
        loginPage.login();
    }
    @Test(priority = 1)
    public void loginTest() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
        LoginPage loginPage = new LoginPage(childTest);
        loginPage.checkLogin();
    }
    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
