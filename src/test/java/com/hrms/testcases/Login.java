package com.hrms.testcases;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends CommonMethods {   //accessibility of all functions in common methods class

    @Test
    public void logoValidation(){
    LoginPageElements login=new LoginPageElements(); //accessing instance variables
        Assert.assertTrue(displayed(login.logo)); //this checks

    }


}
