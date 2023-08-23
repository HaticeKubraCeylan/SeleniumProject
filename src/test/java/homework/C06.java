package homework;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C06 extends TestBase {


    @Test
    public void test() {


        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");

        //-Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement elementalSelenium=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

        //-Elemental Selenium linkine tıklayınız
        elementalSelenium.click();

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
        List<String>penceler=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(penceler.get(1));
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        Assert.assertEquals("https://elementalselenium.com/",driver.getCurrentUrl());

        //A free weekly email of tips to help make
        //Selenium one of the most robust browser
        //automation tools out there.

        //-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
        driver.findElement(By.id("email")).sendKeys("kubra.torpi@gmail.com");

        //-Language dropdown menuden java seçiniz
        WebElement dropMenu=driver.findElement(By.xpath("//select"));
        Select select =new Select(dropMenu);
        select.selectByValue("Java");

        //-Join the mailing list buttonuna tıklayınız
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //-Sayfada Thank you! yazısının çıktığını doğrulayınız
        //driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
    }
}
