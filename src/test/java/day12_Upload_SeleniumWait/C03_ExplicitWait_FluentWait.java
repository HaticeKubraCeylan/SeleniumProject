package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ExplicitWait_FluentWait extends TestBase {


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE=driver.findElement(By.xpath("(//h4)[2]"));
        /*
        Aşağıdaki gibi fluentWait classında bir obje oluştururuz
        sonra obje ile max süreyi belirtir ve
        hangi aralıklarla bekleme yapacaksa onu belirtiriz
         */
        FluentWait<WebDriver>wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).withMessage("WebElementi kontrol et");
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
        WebElement helloWorldWE=driver.findElement(By.xpath("(//h4)[2]"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).until(ExpectedConditions.visibilityOf(helloWorldWE));
        Assert.assertEquals("Hello World!",helloWorldWE.getText());

    }

    //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.Remove butonuna basin.
    //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6.Add buttonuna basin
    //7.It’s back mesajinin gorundugunu test edin



    //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2.Textbox’in etkin olmadigini(enabled) dogrulayın
    //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın
    //5.Textbox’in etkin oldugunu(enabled) dogrulayın.
}
