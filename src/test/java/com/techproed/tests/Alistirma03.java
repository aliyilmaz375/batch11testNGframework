package com.techproed.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alistirma03 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void test(){

        driver.get("https://www.amazon.com.tr");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select dropDownLink = new Select(dropDown);
        dropDownLink.selectByValue("search-alias=mi");

        WebElement searchButon = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchButon.sendKeys("Keman");
        searchButon.submit();

        driver.findElement(By.xpath("//span[.='Rode']")).click();
    }

    @AfterClass
    public void tearDown(){
        // driver.close();
    }
}