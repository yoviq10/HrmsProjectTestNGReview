package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobTitleList extends CommonMethods {

    @FindBy (id="btnAdd")
    public WebElement addBtn;
}
