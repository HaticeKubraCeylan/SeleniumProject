package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ActionsTest extends TestBase {

    @Test
    public void actions() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayız
        WebElement kutu=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(kutu).perform();  //--> locate ettiğimiz webelemente sağ click yapar
        //kullandığımız action ı işleme alması için perform() methodu kullanmamız gerekiyor


        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        //driver.switchTo().alert().getText()  methodu ile alert üzerindeki mesajı aldık ve doğrulama yaptık

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();



    }
}
