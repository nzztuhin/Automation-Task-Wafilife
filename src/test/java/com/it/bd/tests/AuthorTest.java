package com.it.bd.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.AuthorPage;
import com.it.bd.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthorTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeTest
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Author page test</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }
    @Test(priority = 0)
    public void authorTest() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Author Page test</b></p>");
        AuthorPage authorPage = new AuthorPage(childTest);
        authorPage.clickAuthors();
        authorPage.scrollDown();
        authorPage.goToNextPage();
        authorPage.selectAnAuthor();
    }
    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
