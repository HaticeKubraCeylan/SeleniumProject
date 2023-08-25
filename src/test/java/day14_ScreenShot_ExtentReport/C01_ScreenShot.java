package day14_ScreenShot_ExtentReport;

import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {

    @Test
    public void test() throws IOException {

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        String dosyaYolu="src/test/java/utilities/TumSayfaResimleri/ekranGoruntusu.jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());


        String dosyaYolu="target/ekranGoruntusu/screeenShot"+tarih+".png";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }
    @Test
    public void test03() {
        //Youtube sayfasına gidelim
        driver.get("https://youtube.com");

        //ekran resmini alalım
        ekranResmi();//-->TestBase class'ındaki method ile ekran resmini aldık

    }
}
