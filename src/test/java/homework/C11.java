package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C11 extends TestBase {

    @Test
    public void test() {


        //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2.Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button)[2]")).click();
        WebElement messsage=driver.findElement(By.id("message"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(messsage));

        //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın
        Assert.assertTrue(messsage.isDisplayed());

        //5.Textbox’in etkin oldugunu(enabled) dogrulayın.
        textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());

    }
}
