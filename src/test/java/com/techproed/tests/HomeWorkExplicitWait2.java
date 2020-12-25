package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkExplicitWait2 extends TestBase {
    /*
    1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
7. Textbox’in etkin oldugunu(enabled) dogrulayın.
     */
    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBoxLocate = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxLocate.isEnabled());

        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement messageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(messageText.isEnabled());

        Assert.assertTrue(textBoxLocate.isEnabled());

    }
}
