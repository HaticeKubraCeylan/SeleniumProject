package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase{

    @Test
    public void test() throws IOException {

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //events linkine tıklayalım
        driver.findElement(By.xpath("(//*[text()='Events'])[1]")).click();

        //başlığın events olduğunu doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));

        //ve sayfanın resmini alalım
        TakesScreenshot ts= (TakesScreenshot) driver;
        String tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="target/ekranGoruntusu/ekranGoruntusu"+tarih+".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //ve sayfanın resmini alalım
        TakesScreenshot takes= (TakesScreenshot) driver;
        String date= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String path="target/ekranGoruntusu/ekranGoruntusu"+date+".jpeg";
        FileUtils.copyFile(takes.getScreenshotAs(OutputType.FILE),new File(path));

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //çıkan sonuç yazısının resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='sg-col-inner'])[1]"));
        String zaman= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String yol="target/webElementEkranGoruntusu/ekranGoruntusu"+zaman+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(yol));

        //techpro sayfasına geri dönelim
        window(0);

        //ve sayfanın resmini alalım
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String dateTime = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String pathYol = "target/ekranGoruntusu/ekranGoruntusu"+dateTime+".jpeg";
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),new File(pathYol));


    }
}
