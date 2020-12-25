package com.techproed.smokeTest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PositiveTestGlbSignIn {

    @Test
    public void test(){
        GlbHomePage glbHomePage = new GlbHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("urlGlbTrdrLogin"));
        glbHomePage.emailLogin.sendKeys(ConfigReader.getProperty("emailLogin"));
        glbHomePage.passwordLogin.sendKeys(ConfigReader.getProperty("passwordLogin"));
        glbHomePage.loginButton.click();
    }

}
