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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Alistirma04 {
/*
    ● https://www.amazon.com/ adresine gidin.
            - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin  45 oldugunu test edin
  -Test 2
            1. Kategori menusunden Books secenegini  secin
 2. Arama kutusuna Java yazin ve aratin
 3. Bulunan sonuc sayisini yazdirin
  4. Sonucun Java kelimesini icerdigini test edin
  */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select sel = new Select(dropDown);

        List<WebElement> list = sel.getOptions();
        for (WebElement w : list) {
            System.out.println(w.getText());
        }

        int listeSayisi = list.size();
        if (listeSayisi==45){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        Select dropDownLink = new Select(dropDown);
        dropDownLink.selectByValue("search-alias=stripbooks-intl-ship");

        WebElement aramaButton = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaButton.sendKeys("Java");
        aramaButton.submit();

        WebElement sonuc = driver.findElement(By.xpath("//span[.='1-16 of over 20,000 results for']"));
        sonuc.getText();

    }

    @AfterClass
    public void tearDown(){
        // driver.close();
    }
}
