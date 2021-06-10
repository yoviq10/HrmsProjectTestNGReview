package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends CommonMethods {

    @FindBy (xpath = "//div[@id ='divLogo']/img")
    public WebElement logo;  //making it public for accessibility


    @FindBy(id= "txtUsername")
   public WebElement username;

    public LoginPageElements(){
        PageFactory.initElements(driver,this); //need to extend class to access the driver
    }

}
