package com.techproed.smokeTest;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {
/*
smoketest paketinin altina bir test classi olusturun : GlbSignUpTest
Kullanici kimlik bilgileri ile kayit oldugunda “Success!” mesajini gordugunu
test edin
 */

    @Test (groups = "grup1")
    public void test() throws InterruptedException {
        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        Driver.getDriver().get(ConfigReader.getProperty("urlGlbTrdrRegister"));
        glbSignUpPage.emailTextBox.sendKeys(ConfigReader.getProperty("emailGlbTrdr"));
        glbSignUpPage.nameTextBox.sendKeys(ConfigReader.getProperty("nameGlbTrdr"));
        glbSignUpPage.mobileTextBox.sendKeys(ConfigReader.getProperty("mobileGlbTrdr"));
        glbSignUpPage.passwordTextBox.sendKeys(ConfigReader.getProperty("passwordGlbTrdr"));
        glbSignUpPage.rePasswordTextBox.sendKeys(ConfigReader.getProperty("passwordConfirmGlbTrdr"));
        glbSignUpPage.signUpButton.click();
        Thread.sleep(4000);

        Assert.assertTrue(glbSignUpPage.successMesaji.isDisplayed());
        //Driver.closeDriver();



    }
}
