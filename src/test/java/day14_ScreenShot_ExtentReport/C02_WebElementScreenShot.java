package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {


    @Test
    public void test() throws IOException {

        /*
        Eğer sadece bir webelementin resmini almak istersek ;
            O elementin locate ini alıp WE.getScreenShotAs() methodu ile webelementin resmini alabiliriz
            Tüm sayfanın resmini almak istediğimizde TakeScreenShot arayüzünden bir obje oluşturup
            bu objeyi drivera eşitliyorduk. dolayısıyla driverin gittiği sayfanın resmini ts.getScreenShotAs methoduyla alabiliyorduk.
            Sadece bir webelementin resmini alacağımız için TakeScreenShot arayüzüne gerek kalmadan direk webelementin
            locate i ile getScreenShotAs methodu kullanarak yine aynı FileUtils class ı ile copyFile methodunu kullanarak resmi alıyoruz.
         */

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //ekran resmini alalım
        ekranResmi();

        //sonuç yazısı webelementinin resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/webElementEkranGoruntusu/WEscreenShot"+tarih+".png";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }

    @Test
    public void test02() {

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //ekran resmini alalım
        ekranResmi();

        //sonuç yazısı webelementinin resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi);


    }
}
