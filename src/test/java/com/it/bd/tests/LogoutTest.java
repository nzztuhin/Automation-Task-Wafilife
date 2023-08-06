package com.it.bd.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.LoginPage;
import com.it.bd.pages.LogoutPage;
import com.it.bd.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeTest
    public void openUrl(){
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Logout page test</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }
    @Test(priority = 0)
    public void logoutTest() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGOUT TEST</b></p>");
        LogoutPage logoutPage = new LogoutPage(childTest);
        logoutPage.logout();
    }
    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
