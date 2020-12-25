package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alistirma05 {

    /*
    1- amazon sayfasina git
    2- Aramabutonunun solundaki dropdown locate et ve Men's Fashion kategorisini secin
    3- arama butonunu locate edin ve "men's shoes" yazdirin ve aratin.
    4- brand kisminda "adidas" markasini locate edin ve secin
    5- acilan sayfadaki sonuclari yazdirin. sonucun icinde 340 gecmedigini dogrulayin.
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

    }
    @Test (priority = 1)
    public void dropDownTest(){

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select dropDownLink = new Select(dropDown);
        dropDownLink.selectByValue("search-alias=fashion-mens-intl-ship");

    }
    @Test (priority = 2)
    public void aramaButon(){
        WebElement arama = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        arama.sendKeys("men's shoes");
        arama.submit();
    }

    @Test (priority = 3)
    public void brandTest(){
        driver.findElement(By.xpath("//span[.='adidas']")).click();
    }

    @Test (priority = 4)
    public void sonucTest(){
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());
        Assert.assertFalse(sonuc.getText().contains("340"));
    }

    @AfterClass
    public void tearDown(){
        // driver.close();
    }
}
