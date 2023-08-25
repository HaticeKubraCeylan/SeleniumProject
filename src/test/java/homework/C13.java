package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C13 extends TestBase {


    @Test
    public void test() {


        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);
        select.selectByIndex(1);
        System.out.println(select.getOptions().get(1).getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getOptions().get(2).getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getOptions().get(1).getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        System.out.println(select.getOptions());
        select.getOptions().forEach(t -> System.out.println(t.getText()));

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        System.out.println(select.getOptions().size());
        int dropSize=select.getOptions().size();
        if (dropSize==4){
            System.out.println("true");
        }else System.out.println("false");


    }
}
