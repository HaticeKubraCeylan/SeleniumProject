package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C05 extends TestBase {

    @Test
    public void test() {

        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(aramaKutusu);
        //System.out.println(aramaKutusu.getText());

        List<WebElement> secenekler = select.getOptions();
        secenekler.forEach(t -> System.out.println(t.getText()));

        System.out.println("***********");


        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım,
        for (int i = 1; i<6; i++){
            aramaKutusu = driver.findElement(By.id("searchDropdownBox"));
            Select select1 = new Select(aramaKutusu);
            List<WebElement> ilkBes = select1.getOptions();
            String secenek = ilkBes.get(i).getText();

            WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            searchBox.sendKeys(secenek, Keys.ENTER);

            System.out.println(driver.getTitle());
            driver.navigate().back();
        }


    }
}
