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
import org.openqa.selenium.support.ui.Select;

public class CompleteOrderPage extends CommonMethods {
    ExtentTest test;
    public CompleteOrderPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
        this.test = test;
    }
    @FindBys({
            @FindBy(xpath = "//select[@id='billing_area']")
    })
    WebElement billingArea;

    @FindBys({
            @FindBy(xpath = "//textarea[@id='billing_address_1']")
    })
    WebElement fullAddress;

    @FindBys({
            @FindBy(xpath = "//textarea[@id='order_comments']")
    })
    WebElement comments;
    @FindBys({
            @FindBy(xpath = "//input[@id='payment_method_bkash']")
    })
    WebElement paymentMethod;

    public void completeOrder() {
        try {
            if(billingArea.isDisplayed()){
                billingArea.click();
                timeout(5);
                Select select = new Select(billingArea);
                select.selectByVisibleText("আগারগাঁও");
                timeout();
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            if(fullAddress.isDisplayed()){
                fullAddress.sendKeys("ভিসা ও পাসপোর্ট অফিস,আগারগাঁও");
                timeout();

            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            if(comments.isDisplayed()){
                comments.sendKeys("আপনি কি সন্ধ্যায় বইটি ডালিভার করতে পারেন? ধন্যবাদ");
                timeout();
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            if(paymentMethod.isDisplayed()){
                paymentMethod.click();
                timeout(5000);
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully completed the order.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "completeOrder");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "completeOrder.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
