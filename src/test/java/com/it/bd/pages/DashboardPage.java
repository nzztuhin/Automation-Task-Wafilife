package com.it.bd.pages;

import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends CommonMethods {
    public DashboardPage(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }
    @FindBys({
            @FindBy(xpath = "//li[1]//a[1]//span[1]")
    })
    WebElement adminOptions;

    @FindBys({
            @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    })
    WebElement dashboardText;

    public void checkDashboard(){

        try {
            if(dashboardText.isDisplayed()){
                String expectedText = "Dashboard";
                String actualText = dashboardText.getText();
                Assert.assertEquals(actualText,expectedText);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void clickAdmin(){
        try {
            if(adminOptions.isDisplayed()){
                adminOptions.click();
                timeout();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
