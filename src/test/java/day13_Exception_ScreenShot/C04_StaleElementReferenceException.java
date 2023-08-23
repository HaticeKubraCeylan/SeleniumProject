package day13_Exception_ScreenShot;

import com.github.javafaker.Team;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {


    @Test
    public void test01() {

        /*
        StaleElementReferenceException
        bir webelementi locate etiikten sonra sayfada refresh(navigate.refresh), back() yada forward() işlemi yaptıysanızve tekrar locate inialdığınız webelementi
        kullanmak isterseniz bu hatayı alırsınız
        çünkü sayfa yenileme, sayfada ileri geri yapma işleminden sonra driver locate ini aldığınız elementi eskimiş element olarak görür ve
        bu durumu bu hatayı handle etmek için o elementi tekrar locate etmeniz gerekir

            List<Webelement> linkler= driver.findElement(By.xpath("gfhgfh"));
            yukarıdaki linklerin olduğu listeyi bir loop içinde hepsine click yapacağız
            for döngüsü içinde bu işlemi yaparken navigate back yapınca list bayatlıyor ve ikinci döngü çalışmıyor

            for(i=0; i<linkler.size();i++){
            linkler.get(i).click()
            driver.navigate().back();
            linkler= driver.findElement(By.xpath("gfhgfh"));  diyerek linkler listini yeniden tanıtınca sorun handle edilmiş oluyor

            tekrar liste atama yapmazsak aynı şekilde listin içindeki elementleri eskimiş kabul edip StaleElementReferenceException fırlatacak.
            Dolayısıyla loop içinde list in tekrar elementlerin atamasını yaparsak bu exception ı handle etmiş oluruz
        */


        driver.get("https://techproeducation.com");
        //Events linkine tıklayalım
        WebElement link=driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        link.click();
        bekle(5);

        //Back ile ana sayfaya dönelim
        driver.navigate().back();
        bekle(5);

        //tekrar Events linkine tıklayalım
        link.click();  //--> StaleElementReferenceException


    }

    @Test
    public void test02() {

        driver.get("https://amazon.com");

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("iphone", Keys.ENTER);
       bekle(2);

       //back ile anasayfaya dönelim
        driver.navigate().back();

        //tekrar arama kutusunda samsung aratalım
        //WebElement aramaKutusuWE = driver.findElement(By.id("twotabsearchtextbox"));   //bu hatırlatma ile handle ederiz
        //aramaKutusuWE.sendKeys("samsung",Keys.ENTER);

        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung",Keys.ENTER);   //--> StaleElementReferenceException


    }



}
