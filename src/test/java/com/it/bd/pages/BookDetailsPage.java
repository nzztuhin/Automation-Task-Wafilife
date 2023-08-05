package com.it.bd.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import com.it.bd.utilities.GetScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class BookDetailsPage extends CommonMethods {
    ExtentTest test;
    public BookDetailsPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
        this.test = test;
    }
    @FindBys({
            @FindBy(xpath = "//div[@class='product_thumbnail_wrapper']//a")
    })
    WebElement selectDetails;
    @FindBys({
            @FindBy(xpath = "//div[@class='body-wrapper']//button[2]")
    })
    WebElement clickOnOrder;

    @FindBys({
            @FindBy(xpath = "//a[@title='checkout']")
    })
    WebElement checkout;

    public void selectBookDetails() {
        try {
            if(selectDetails.isDisplayed()){
                selectDetails.click();
                timeout();
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully reached author page.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "bookdetailspage");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "bookdetailspage.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void clickOrder() throws IOException {
        try {
            if(clickOnOrder.isDisplayed()){
                clickOnOrder.click();
                timeout();
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully click on the order button.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "clickOnOrder");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "clickOnOrder.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }catch (Exception e){
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Out of stock.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "orderFailed");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "orderFailed.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(clickOnOrder.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }
    }
    public void clickCheckout() {
        try {
            if(checkout.isDisplayed()){
                checkout.click();
                timeout();
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully click on the order button.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "checkout");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "checkout.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
