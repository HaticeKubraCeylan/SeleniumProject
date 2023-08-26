package day15_ExtenetReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {


    @Test
    public void test() {

        rapor("Chrome","Amazon Testi");
        extentTest=extentReport.createTest("Extent Report","Test Raporu");


        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kutusu locate edildi");
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");
        extentReport.flush();



    }
}
