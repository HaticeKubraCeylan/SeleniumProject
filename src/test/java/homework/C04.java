package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04 extends TestBase {

    @Test
    public void test() {

        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> pictures=driver.findElements(By.xpath("//img[@width='225' or height='225']"));
        for (int i = 0; i <pictures.size() ; i++) {
            pictures = driver.findElements(By.xpath("//img[@width='225' or height='225']"));
            pictures.get(i).click();

            // - Her sayfanın sayfa başlığını yazdıralım
            System.out.println((i + 1) + ". nin başlığı  =" + driver.getTitle());
            driver.navigate().back();

        }


    }


    @Test
    public void test02() {

        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        List<WebElement>resimler = driver.findElements(By.xpath("//img[@width ='225' and @height='225']"));
        for (WebElement w: resimler) {
            resimler=driver.findElements(By.xpath("//img[@width='225' or height='225']"));
            bekle(1);
            w.click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }


    }
}
