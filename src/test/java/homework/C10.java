package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C10 extends TestBase {

    @Test
    public void test() {



        //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Remove butonuna basin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        WebElement text=driver.findElement(By.xpath("//*[@id='message']"));

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(text));

        //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(text.isDisplayed());

        //6.Add buttonuna basin
        driver.findElement(By.xpath("(//button)[1]")).click();

        //7.It’s back mesajinin gorundugunu test edin
        WebElement text1=driver.findElement(By.xpath("//*[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(text1));
        Assert.assertTrue(text1.isDisplayed());


    }
}
