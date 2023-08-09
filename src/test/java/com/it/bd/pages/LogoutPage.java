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

public class LogoutPage extends CommonMethods {
    ExtentTest test;
    public LogoutPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
        this.test = test;
    }
    @FindBys({
            @FindBy(xpath = "//div[@class='login-links']//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')]")
    })
    WebElement myAccount;

    @FindBys({
            @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']")
    })
    WebElement logout;

    public void logout() throws InterruptedException, IOException {
        timeout();

        try {
            if (myAccount.isDisplayed()){
                myAccount.click();
                timeout();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            if (logout.isDisplayed()){
                logout.click();
                timeout();
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully logged out.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "logoutPass");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "logoutPass.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }
        catch (Exception e){
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Logout Button is not locatable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "logoutButtonLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "logoutButtonLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(logout.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

    }
}
