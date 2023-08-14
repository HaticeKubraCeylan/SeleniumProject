package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon sayfasına gidin
        driver.get("https:/amazon.com");

        //arama kutusunu locate ediniz  ve iphone yazdırıp aratınız
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);   //-->submit() kullanmadan enter tuşuna bu şekilde de basmış oluruz , koyup Keys.ENTER yazıyoruz
        //aramaKutusu.submit();  //-->enter tuşuna basarız


        /*
        WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));
        aramaKutusu.sendKeys("iphone");
         */

        /*
        Sayfadaki bir webelementi locate etmek için öncelikle locate edeceğimiz webelementin üzerine sağ tıklayıp
        sayfanın altında açılan webelementle alakalı html kodlarına ulaşabiliriz.
        Bu html kodları yardımı ile eğer webelementin html kodlarında id attribute'üne sahip bir değer varsa locate etmek için önce bunu kullanabiliriz.
        Attribute değerine çift tıklayıp ctrl+c   ctrl+f   ctrl+v yaparak öğenin unique olup olmadığını html kodların alt kısmındaki arama
        bölümünden kontrol ederiz. Ve tek olan attribute değerini o web elementi handle edebilmek için kullanabiliriz.

        Input tag'ına sahip bir webelementi locate ettikten sonra sendKeys() methodu ile
        o webelemente istediğimiz text'i gönderebiliriz.

        Bir text'i arama kutusuna gönderdikten sonra klavyeden nasıl enter tuşuna basıyorsak otomasyon ile de bunu yaptırabiliriz.
        Bunun için 2 yol vardır:
        1) submit() methodunu kullanarak enter yaptırabiliriz
        2) tanımlanmış veri tipi olan (enum) Keys.ENTER 'ı kullanabiliriz.
         */



        //sayfayı kapatınız
        driver.close();




    }
}
