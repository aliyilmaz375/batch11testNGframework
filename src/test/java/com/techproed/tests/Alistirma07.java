package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Alistirma07 extends TestBase {

    @Test
    public void E2EgmiBank() throws InterruptedException {
        driver.get("http://www.gmibank.com/");
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        driver.findElement(By.xpath("//a[@aria-haspopup='true']")).click();
        driver.findElement(By.xpath("//span[.='Sign in']")).click();

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Employee9");
        actions.sendKeys(Keys.TAB).sendKeys("Employee9").perform();
        //actions.click(username).sendKeys("Employee9").sendKeys(Keys.TAB).sendKeys("Employee9").perform();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();  //sign in

        driver.findElement(By.xpath("//span[.='My Operations']")).click();  //my operations
        driver.findElement(By.xpath("//span[.='Manage Customers']")).click(); //manage customer

        driver.findElement(By.id("jh-create-entity")).click();  //create a new customer

        WebElement firstName = driver.findElement(By.name("firstName"));
        actions.click(firstName).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys("aaa").sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys("123-456-7890").sendKeys(Keys.TAB).
                sendKeys("123-456-7890").sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys("tokyo").sendKeys(Keys.TAB).
                sendKeys("333-22-4444").
                sendKeys(Keys.TAB).sendKeys("12/20/2020 12:00 AM").perform();

        Thread.sleep(3000);
        WebElement countryDropDown = driver.findElement(By.id("tp-customer-country"));
        Select select = new Select(countryDropDown);
        select.selectByVisibleText("FRANCE");

        WebElement state = driver.findElement(By.id("tp-customer-state"));
        state.sendKeys("East");

        Thread.sleep(3000);
        WebElement userDropDown = driver.findElement(By.xpath("//select[@id='tp-customer-user']"));
        Select select1 = new Select(userDropDown);
        select.selectByIndex(5);

        driver.findElement(By.id("tp-customer-zelleEnrolled")).click();
        driver.findElement(By.id("save-entity")).click();


    }
}
