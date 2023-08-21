package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsTest extends TestBase {

    @Test
    public void test01() {


        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("APjFqb"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).  //arama kutusunda shift tuşuna basılı tutar
                    sendKeys("selenium").  //-->shift tuşuna basılı tutarak SELENIUM yazdıracak
                    keyUp(Keys.SHIFT).   //--> shift tuşundan elini çek
                    sendKeys("-java",Keys.ENTER).perform();

    }


    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "java",Keys.ENTER);

        /*
        yukarıdaki örnekte actions class ı kullanmadan da istediğim metni büyük küçük harf ile yazdırabilirim.
        ilk yazdığımız Keys.SHIFT tuşuna basılı tutar dolayısıyla büyük harf ile yazar ikinci yazdığımız Keys.SHIFT ise shift tuşunu serbest bırakır.
        Klavye tuşlarını pratik olarak yukarıdaki örnekteki gibi kullanabiliriz.
         */



        /*
        Ödev:
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         */
    }
}
