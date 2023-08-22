package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_WebDriverWait extends TestBase {


    @Test
    public void test01() {

        /*
        Selenium Wait:
            implicitly wait: driver ı oluşturduktan sonra sayfadaki tüm elementlerin etkileşime girebilmesi için belirtmiş
        olduğumuz maksimum süre kadar bekler (Duration.ofSecond(15)).

            explict wait / WebdriverWait --> bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için maksimum
        belirtmiş olduğumuz süre kadar default olarak yarım sn lik aralıklarla bekler. örneğin bir webelemente tıkladıktan sonra
        bir alert ün yada bir webelementin oluşması zaman alabilir. ve testimizi her çalıştırdığımızda bu zaman değişkenlik gösterebilir
        dolayısıyla bu gibi durumlarda Thread.Sleep methodu işimize yaramayabilir.bu gibi durumlarda webdriverWait ile max belirttiğimiz
        süre boyunca elementin etkileşime girmesini bekletebiliriz

            Explicity Wait ile bir de fluentWait kullanımı vardır. WebDriverWait ile arasındaki fark fluentWait te bekleme aralığını kendimiz belirleriz.
         */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE=driver.findElement(By.xpath("(//h4)[2]"));
        /*
        1- hangi web elementi görünür olmana kadar beklemek istiyorsak o webelementin locate ini alırız.
        2- WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));  wait objesi oluştututuz.
        3- wait objesi ile until methodu ile parametre olarak bekleme koşulunu ExpectedConditions classındaki methodlarla belirtiriz
         */
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));   //--> helloWordWE webelementini görünür olana kadar bekle

        Assert.assertEquals("Hello World!",helloWorldWE.getText());

    }

    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld=new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertEquals("Hello World!",helloWorld.getText());


    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());

        // kaybolan webelementler icin incele dedikten sonra kaynaklar bolumundeki pause butonundan sayfayi durduruyoruz
    }
    /*
    ÖDEV:
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıkla
    loading webelementi kaybolana kadar bekleyelim
    Hello World! Yazının sitede oldugunu test et
     */
}
