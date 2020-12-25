package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Alistirma09 extends TestBase {
    /*
        1- http://www.gmibank.com/   adresine gidin
             ○ Username : Employee9
             ○ Password : Employee9
      2- my operation ve manage customer locate et ve tikla
      3- yeni method oluştur tüm table head’sinin boyutunu(sutun sayisi) bulun.
      4- headers(basliklar)'i yazdiralim
      5- yeni method oluştur. table body’sinde bulunan toplam satir(row) sayısını bulun.
      6-  Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
      7- 4 uncu satirdaki müşterinin ID numarasini ve adresni yazdir
         */
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

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th"));  //baslik sayisini verir
        System.out.println(basliklar.size());

        for (WebElement w : basliklar               //baslik isimlerini verir
             ) {
            System.out.println(w.getText());
        }

    }

    @Test
    public void rowsTest() throws InterruptedException {
        login();
        Thread.sleep(4000);

        List<WebElement> satirlar = driver.findElements(By.xpath("//tbody//tr"));  // satir sayisini verir
        System.out.println("Satir sayisi : " + satirlar.size());

        for (WebElement w: satirlar
             ) {
            System.out.println(w.getText());                            //satir isimlerini verir
        }

    }

    @Test
    public void test() throws InterruptedException {

        login();
        Thread.sleep(4000);

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th"));   //adres basligi
        WebElement satir = driver.findElement(By.xpath("//tbody//tr[4]//td[8]"));    //musterini adresi
        WebElement satir1 = driver.findElement(By.xpath("//tbody//tr[4]//td[1]"));   //id numara


        System.out.println(satir1.getText() +" ; " + basliklar.get(7).getText() + " ; " + satir.getText());

    }

}
