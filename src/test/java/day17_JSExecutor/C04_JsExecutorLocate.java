package day17_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsExecutorLocate extends TestBase {


    @Test
    public void test() {

        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini locate edelim
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement element= (WebElement) js.executeScript("return document.getElementById('content');");
        System.out.println(element.getText());
        Assert.assertEquals("Hello Shadow DOM",element.getText());

    }

    @Test
    public void test02() {

        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini locate edelim
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement helloShadow= (WebElement) js.executeScript("return document.getElementById('content');");
        WebElement shadow=driver.findElement(By.xpath("(//h1)[2]"));
        js.executeScript("arguments[0].style.color='red';arguments[1].style.color='blue'",helloShadow,shadow);

    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunu js executor ile locate edelim
        //arama kutusunun attribute değerlerini yazdıralım
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String aramaKutusuTypeDegeri= js.executeScript("return document.getElementById('twotabsearchtextbox').type").toString();
        String aramaKutusuNameDegeri= js.executeScript("return document.getElementById('twotabsearchtextbox').name").toString();
        String aramaKutusuClassDegeri= js.executeScript("return document.getElementById('twotabsearchtextbox').className").toString();
        System.out.println(aramaKutusuTypeDegeri);
        System.out.println(aramaKutusuNameDegeri);
        System.out.println(aramaKutusuClassDegeri);


        /*
        Html kodları ile yazılmış bir webelementi js executor ile locate edip, locate ettiğimiz webelemente sahip
        attribute değerlerini yukarıdaki örnekteki gibi yazdırdık
         */




    }
}
