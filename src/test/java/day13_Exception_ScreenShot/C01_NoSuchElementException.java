package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {


    @Test
    public void test() {


        /*
        NoSuchElementException:
        Eğer bu exceptionı alıyorsanız
        1- yanlış locate almış olabilirsiniz dolayısıyla locate i düzeltmeniz gerekir
        2- locate ini aldığınız webelement iframe içinde olabilir dolayısıyla iframe e geçiş yapmanız gerekir
        3- bir tıklama işleminden sonra yeni bir pencere açıldıysa driver ı o pencereye geçirmezsek bu hatayı alırız dolayısıyla pencereye geçiş yapmamız gerekir
        4- locate etmek istediğimiz webelement sayfanın altında ise bazen bazı sayfalar scroll yapmadan bu webelementi göremez dolayısıyla driver a elementi göstermemeiz gerekir
         */


        driver.get("https://techproeducation.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("fadshgjadsf"));
        aramaKutusu.sendKeys("java");





    }
}
