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


public class LoginPage extends CommonMethods {
    ExtentTest test;
    public LoginPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
        this.test = test;
    }

    @FindBys({
            @FindBy(xpath = "//a[@title='আমার অ্যাকাউন্ট']")
    })
    WebElement gotoLogin;
    @FindBys({
            @FindBy(xpath = "//input[@id='username']")
    })
    WebElement userName;

    @FindBys({
            @FindBy(xpath = "//input[@id='password']")
    })
    WebElement password;
    @FindBys({
            @FindBy(xpath = "//input[@name='login']")
    })
    WebElement loginButton;


    public void login() throws InterruptedException, IOException {
        timeout();

        try {
            if (gotoLogin.isDisplayed()){
                gotoLogin.click();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            if(userName.isDisplayed()) {
                userName.sendKeys("skysssyyy");
                timeout();
            }
        } catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Username is not locatable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "usernameLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "usernameLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(userName.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

        try {
            if(password.isDisplayed()) {
                password.sendKeys("qwerty123");
                timeout();
            }
        } catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Password is not locatable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "passwordLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "passwordLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(password.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

        try {
            if (loginButton.isDisplayed()) {
                loginButton.click();
                timeout(5000);
                    test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully clicked log in.</b></p>");
                    String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginPass");
                    String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginPass.png";
                    test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
           }
        } catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Login Button is not locatable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginButtonLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginButtonLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(loginButton.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

    }
    public void checkLogin() throws IOException {
       String checkLoginSuccess = PageDriver.getCurrentDriver().getTitle();

        String expectedText = "আমার অ্যাকাউন্ট - Wafilife";
        try {
            if(checkLoginSuccess.equals(expectedText)){
            test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully logged in.</b></p>");
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginPassed");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginPassed.png";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Login Failed. Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginFailed");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginFailed.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(loginButton.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }
    }
}

