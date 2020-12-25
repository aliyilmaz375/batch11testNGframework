package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeWorkExplicitWait extends TestBase {

    //1. " https://demoqa.com/dynamic-properties” sayfasina gidin
    //2. “Visible After 5 Seconds” butonunun gorunun oldugunu test edin

    @Test
    public void test(){
        driver.get("https://demoqa.com/dynamic-properties");

        SoftAssert soft = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement visibleAfterLocate = driver.findElement(By.id("visibleAfter"));

        soft.assertTrue(visibleAfterLocate.isDisplayed());

        soft.assertAll();
    }


}
