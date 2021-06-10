package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    protected static WebDriver driver;

    /* ADD DESCRIPTION:
    This method opens browser and navigate to URL
     */

   @BeforeMethod(alwaysRun = true)

    //@Test
    public static void setUp(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILE); // used to be this: "C:\\Users\\yoviq\\IdeaProjects\\HrmsProject\\src\\Configs\\Configuration.properties"
        //ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid name of browser");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /*
    * This method closes
    *
    */

    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    /*
    *
    */

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }

    /*
    * This method will wait till element becomes visible
    * @param element
    * */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
    * this method will wait till element becomes visible
    * @param element
    */


    public static void waitForVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }


    /*
    * This method checks if element is displayed
    * @param element
    * @return boolean
    */
    public static boolean displayed(WebElement element){  //webElement is displayed
        waitForVisibility(element);
       return element.isDisplayed();   //will return a boolean

    }
}
