package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbHomePage {

    public GlbHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailLogin;

    @FindBy(xpath = "//input[@id='password']")
    public  WebElement passwordLogin;

    @FindBy(xpath = "//button[@value='Login']")
    public WebElement loginButton;


}

