package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Alistirma08 extends TestBase {

    public void login(){

        driver.get("http://www.gmibank.com/");

        driver.findElement(By.xpath("//a[@aria-haspopup='true']")).click();  //kisi simgesi
        driver.findElement(By.xpath("//span[.='Sign in']")).click();    //sign in

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));  //username
        username.sendKeys("Employee9");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));  //password
        password.sendKeys("Employee9");

        driver.findElement(By.xpath("//button[@type='submit']")).click();   //sign in
        driver.findElement(By.xpath("//span[.='My Operations']")).click();  //my operations
        driver.findElement(By.xpath("//span[.='Manage Customers']")).click(); //manage customer
    }


    @Test
    public void tableTest() throws InterruptedException {
        login();
        Thread.sleep(4000);

        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        List<WebElement> tumBasliklar = driver.findElements(By.xpath("//thead//th"));
        System.out.println("basliklarin sayisi ;" + tumBasliklar.size());    //baslik sayisini verir


        for (WebElement w : tumBasliklar
        ) {
            System.out.println(w.getText());        //baslik isimlerini verir.
        }

    }

    @Test
    public void rowsTest() throws InterruptedException {
        login();
        Thread.sleep(4000);
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("tum satir sayisi ; " + tumSatirlar.size());

        System.out.println("5 inci satirdaki musteri ; " + tumSatirlar.get(5).getText());

    }

    @Test
    public void test(){
        login();
        WebElement basliklarListesi=driver.findElement(By.xpath("//thead//th[8]"));
        WebElement satirlar=driver.findElement(By.xpath("//tbody//tr[4]//td[8]"));
        WebElement satirlar1=driver.findElement(By.xpath("//tbody//tr[4]//td[1]"));


        System.out.println(satirlar1.getText() + " ; " +basliklarListesi.getText()+ " ; " + satirlar.getText());

    }

}
