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

    public void clickOrder() {
        try {
            if(clickOnOrder.isDisplayed()){
                clickOnOrder.click();
                timeout();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void clickCheckout() {
        try {
            if(checkout.isDisplayed()){
                checkout.click();
                timeout();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
