package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkIframe extends TestBase {
    /*
    Iframe Home Work
1. “http://webdriveruniversity.com/IFrame/index.html”
    sayfasina gidin
2. “Our Products” butonuna basin
3. “Cameras product”i tiklayin
4. Popup mesajini yazdirin
5. “close” butonuna basin
6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
7. "http://webdriveruniversity.com/index.html" adresine
    gittigini test edin

     */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        driver.switchTo().frame("frame");
        driver.findElement(By.linkText("Our Products")).click();


        driver.findElement(By.xpath("//p[.='Cameras']")).click();
        Thread.sleep(5000);
        String message=driver.findElement(By.className("modal-body")).getText();
        System.out.println("pop up mesaji : "+ message);

        driver.findElement(By.xpath("//button[.='Close']")).click();

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[.='WebdriverUniversity.com (IFrame)']")).click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"http://webdriveruniversity.com/index.html");




    }

}
