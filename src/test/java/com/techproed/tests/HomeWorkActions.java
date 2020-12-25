package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomeWorkActions extends TestBase {
    /*
    1."http://webdriveruniversity.com/Actions" sayfasina gidin
    2."Hover over Me First" kutusunun ustune gelin
    3."Link 1" e tiklayin
    4.Popup mesajini yazdirin
    5.Popup'i tamam diyerek kapatin
    6."Click and hold" kutusuna basili tutun
    7. "Click and hold" kutusunda cikan yaziyi yazdirin
    8. "Double click me" butonunu cift tiklayin
    */
    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMeFirst).perform();

        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        String popUpMessage = driver.switchTo().alert().getText();
        System.out.println("Pop up message: " + popUpMessage);
        driver.switchTo().alert().accept();

        actions.sendKeys(Keys.PAGE_DOWN);
        WebElement clickHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();

        System.out.println(clickHold.getText());

        Thread.sleep(5000);
        WebElement doubleClick=driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();


    }
}
