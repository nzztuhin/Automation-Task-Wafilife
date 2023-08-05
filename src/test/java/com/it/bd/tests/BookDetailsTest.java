package com.it.bd.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.BookDetailsPage;
import com.it.bd.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BookDetailsTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeTest
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Book details and place order test</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }
    @Test(priority = 0)
    public void bookTest() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Book Details Page test</b></p>");
        BookDetailsPage bookDetailsPage = new BookDetailsPage(childTest);
        bookDetailsPage.selectBookDetails();

    }
    @Test(priority = 1)
    public void orderTest() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Click on Order</b></p>");
        BookDetailsPage bookDetailsPage = new BookDetailsPage(childTest);
        bookDetailsPage.clickOrder();

    }
    @Test(priority = 2)
    public void checkoutOrderTest() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Click on checkout</b></p>");
        BookDetailsPage bookDetailsPage = new BookDetailsPage(childTest);
        bookDetailsPage.clickCheckout();

    }
    @AfterClass
    public void afterClass() {
        report.flush();
}
}

