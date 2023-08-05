package com.it.bd.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.CompleteOrderPage;
import com.it.bd.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompleteOrderTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeTest
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Complete Order Page</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }
    @Test
    public void OrderTest()throws InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>fill order page Page test</b></p>");
        CompleteOrderPage completeOrderPage = new CompleteOrderPage(childTest);
        completeOrderPage.completeOrder();

    }
    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
