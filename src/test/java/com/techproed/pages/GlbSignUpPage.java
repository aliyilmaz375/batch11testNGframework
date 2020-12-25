package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@name='mobile']")
    public WebElement mobileTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name='re_password']")
    public WebElement rePasswordTextBox;

    @FindBy(xpath = "//button[@value='Login']")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMesaji;
}