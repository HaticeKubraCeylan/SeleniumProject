package day17_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorScroll extends TestBase {


    @Test
    public void test() {


        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Back to school webelementine kadar scroll yapalım
        WebElement backtoschoolWE=driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",backtoschoolWE);
        bekle(2);

        //sayfanın en altına scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);

        //sayfanın en üstüne scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }
}
