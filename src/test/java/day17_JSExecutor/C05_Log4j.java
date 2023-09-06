package day17_JSExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Log4j extends TestBase {


    @Test
    public void test() {
        /*
        1- Log4j kullanabilmek için öncelikle src>main>resources package ı altında log4j2.xml dosyası oluşturduk.
        2- log4j2.xml dosyası içerisine pdf deki adreste de bulunan xml kodlarını yapıştırdık.
        3- log4j-api ve log4j-core dependency lerini pom.xml dosyasına ekledik.
        Ve test methodumuzda loglama işlemleri için Logger arayüzünden bir obje oluşturup LogManager classından getLogger methodu ile
        classımızı argumen olarak tanımlayacağız.
         */

        Logger logger= LogManager.getLogger(C05_Log4j.class);
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        logger.info("Kullanıcı amazon sayfasına gitti");

        //arama kutusunda java aratalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("Arama kutusu locate edildi");
        aramaKutusu.sendKeys("java", Keys.ENTER);
        logger.info("Arama kutusunda java aratıldı");



    }
}
