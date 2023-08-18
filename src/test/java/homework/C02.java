package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {


    @Test
    public void test01() {

        //●https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown=driver.findElement(By.cssSelector("select#dropdown"));
        Select select =new Select(dropdown);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        List<WebElement>options=select.getOptions();
        System.out.println(options.get(2).getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        selectVisibleText(dropdown,"Option 1");
        System.out.println(options.get(1).getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        for (WebElement w:options) {
            System.out.println(w.getText());
        }

        //5.Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
        int ddSize=(options.size());
        Assert.assertFalse(ddSize>4);
        if (ddSize>4){
            System.out.println("True");
        }else System.out.println("False");


    }
}
