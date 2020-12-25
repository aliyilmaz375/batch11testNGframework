package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HomeWorkWindowHandle extends TestBase {
/*
    Window Handle Home Work
1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
            5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
            8.Ok diyerek Popup'i kapatin
            9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
*/
    @Test
    public void test(){
        driver.get("http://webdriveruniversity.com/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")).click();

        String ilkSayfaHandle = driver.getWindowHandle();

        Set<String> tumHandle = driver.getWindowHandles();
        String ikinciSayfaHandle="";

        for (String w: tumHandle
        ) {
            if (!w.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);

        Faker faker = new Faker();
        WebElement username = driver.findElement(By.id("text"));
        actions.click(username).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        String popupMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(popupMessage, "validation failed");
        driver.switchTo().alert().accept();

        driver.switchTo().window(ilkSayfaHandle);

        String ilkSayfaDonusDogrulama = driver.getCurrentUrl();
        Assert.assertEquals(ilkSayfaDonusDogrulama, "http://webdriveruniversity.com/");
    }
}

