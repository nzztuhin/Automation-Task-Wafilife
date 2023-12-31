package com.it.bd.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {

    public static String url = "https://www.wafilife.com/";
    WebDriver driver = null;

    @BeforeSuite
     public void start() {
         String browser = System.getProperty("browser", "chrome");

         if(browser.contains("chrome")){
             ChromeOptions options = new ChromeOptions();
                     options.setAcceptInsecureCerts(true);
                     options.addArguments("--remote-allow-origins=*");
             driver = new ChromeDriver(options);

         } else if (browser.contains("firefox")) {
             WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();

         }
         else {
             WebDriverManager.edgedriver().setup();
             driver = new EdgeDriver();
         }
         PageDriver.getInstance().setDriver(driver);
     }
     @AfterSuite
     public void close(){

        PageDriver.getCurrentDriver().quit();
     }

}
