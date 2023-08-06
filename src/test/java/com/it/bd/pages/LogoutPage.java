package com.it.bd.pages;

import com.aventstack.extentreports.ExtentTest;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

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

    public void logout() throws InterruptedException {
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
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
