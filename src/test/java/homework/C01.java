package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidelim
    //programming languages ddm den istediğiniz 4 seçeneği seçiniz
    //sadece seçili olan option'ları yani seçenekleri yazdıralim
    //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
    //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
    //Seçtiğimiz seçeneklerin hepsini kaldıralim
    //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim


    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement prgLang=driver.findElement(By.cssSelector("[name='Languages']"));
        Select select= new Select(prgLang);
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);

        List<WebElement> options=select.getAllSelectedOptions();
        options.forEach(t-> System.out.println(t.getText()));

        Assert.assertEquals(4,options.size());

        String ilkEleman=select.getFirstSelectedOption().getText();
        System.out.println(ilkEleman);
        String beklenen="Java";
        Assert.assertEquals(ilkEleman,beklenen);

        select.deselectAll();

        selectVisibleText(prgLang,"Python");




    }
}
