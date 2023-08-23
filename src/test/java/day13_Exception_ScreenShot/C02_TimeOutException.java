package day13_Exception_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void test() {

        /*
        TimeOutException:
        Eğer timeOutException alıyorsanız ;
        1- kullanılan explicitWait teki max süreyi kontrol etmemız gerekir
        2- explicitWait ile kullandığımız elementin locateini kontrol etmemiz gerekir
        3- explicitWait ile kullandığımız methodu doğru seçmemiz gerekir
         */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE=driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));  //-->timeOutException almak için süreyi azalttık
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!",helloWorldWE.getText());


    }

    @Test
    public void test02() {


        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlis locate")));

        //wait içinde yanlış locate de bize timeOutException verir

        //NOT: eğer yanlış locator (örneğin xpath yerine css gibi) kullanırsanız InvalidSelectorException alırsınız


    }
}
