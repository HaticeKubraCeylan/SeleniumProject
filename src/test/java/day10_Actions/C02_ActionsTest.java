package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {

    @Test
    public void action() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountListWE= driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        //new Actions(driver).moveToElement(accountListWE).perform();  action ı 1 kere kullanacaksak bu şekilde kullanmak daha pratik
        Actions actions =new Actions(driver);
        actions.moveToElement(accountListWE).perform();  //--> mouse ı locate ettiğimiz webelementin üzerine götürdük
        driver.findElement(By.xpath("//*[text()='Account']")).click();


        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertEquals("Your Account", driver.getTitle());


    }
}
