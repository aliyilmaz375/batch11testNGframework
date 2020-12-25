package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Alistirma06 extends TestBase {
/*
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
    public void createHotel(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        Actions actions = new Actions(driver);
        driver.findElement(By.linkText("Log in")).click();
        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager");

        actions.sendKeys(Keys.TAB).sendKeys("Manager2!").sendKeys(Keys.ENTER).perform();

       driver.findElement(By.linkText("Hotel Management")).click();
       driver.findElement(By.xpath("//a[@href='/admin/HotelAdmin']")).click();
       driver.findElement(By.xpath("//span[.='Add Hotel ']")).click();
       Faker faker = new Faker();
       WebElement codeText = driver.findElement(By.id("Code"));
       actions.click(codeText).sendKeys(faker.code().asin()).
               sendKeys(Keys.TAB).
               sendKeys(faker.hobbit().character()).
               sendKeys(Keys.TAB).sendKeys(faker.hobbit().location()).
               sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
               sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).perform();

       WebElement dropDown = driver.findElement(By.id("IDGroup"));
       Select select = new Select(dropDown);
       select.selectByValue("1");

       WebElement saveButon = driver.findElement(By.id("btnSubmit"));
       saveButon.sendKeys(Keys.ENTER);





    }
}






