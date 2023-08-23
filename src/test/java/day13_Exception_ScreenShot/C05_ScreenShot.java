package day13_Exception_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ScreenShot extends TestBase {


    @Test
    public void test01() throws IOException {

        /*
        ScreenShot
        selenium da tüm sayfanın resmini alabilmek için;
        1- TakeScreeenShot arayüzünden bir obje oluşturup driver a eşitleriz
        farklı arayüzler olduğu için casting yaparız
        2- FileUtils class ından copyFile() methodu içine parametre olarak
        oluşturmuş olduğumuz obje ile getScreenShotAs() methodunu kullanır getScreenShot() methoduna parametre olarak
        OutputType.File ekleriz ve bunu yeni bir dosyaya kaydetmesi için new File() diyerek resmi kaydedeceğimiz dosyanın yolunu belirtiriz
         */


        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("src/test/java/utilities/TumSayfaResimleri/screenShot.jpeg"));
    }


    @Test
    public void test02() throws IOException {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");

        //tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts= (TakesScreenshot) driver;
        String dosyaYolu="src/test/java/utilities/TumSayfaResimleri/techproScreenShot.jpeg";
        File file=new File(dosyaYolu);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),file);

    }

    @Test
    public void test03() throws IOException {
        driver.get("https://facebook.com");

        //tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts= (TakesScreenshot) driver;
        String dosyaYolu="target/facebookScreenShot.png";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
