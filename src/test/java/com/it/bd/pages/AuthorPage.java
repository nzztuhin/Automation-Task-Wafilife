package com.it.bd.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import com.it.bd.utilities.GetScreenShot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AuthorPage extends CommonMethods {
    ExtentTest test;
    public AuthorPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
        this.test = test;
    }
    @FindBys({
            @FindBy(xpath = "//span[@class='menu-label-level-0'][contains(text(),'লেখক')]")
    })
    WebElement authors;

    @FindBys({
            @FindBy(xpath = "//a[contains(text(),'→')]")
    })
    WebElement nextPage;

    @FindBys({
            @FindBy(xpath = "//h3[normalize-space()='Md. Aktar Hossain']")
    })
    WebElement selectAuthor;


    public void clickAuthors(){
        try {
            if(authors.isDisplayed()){
                authors.click();
                timeout();
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully clicked log in.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "authorpage");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "authorpage.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
        //Scroll down
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        timeout(5000);
    }
    public void goToNextPage(){
        try {
            if(nextPage.isDisplayed()){
                nextPage.click();
                timeout();
                PageDriver.getCurrentDriver().navigate().back();
                timeout();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void selectAnAuthor() {
        try {
            if(selectAuthor.isDisplayed()){
                selectAuthor.click();
                timeout();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
