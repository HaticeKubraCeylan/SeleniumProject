package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C12 extends TestBase {

    @Test
    public void test() {


        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2.Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3.Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);

        //4.Password kutusuna “password.” yazin
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.navigate().back();

        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8.“Currency” drop down menusunden Eurozone’u secin
        driver.findElement(By.id("pc_currency")).sendKeys("Eurozone",Keys.TAB,"400");

        //9.“amount” kutusuna bir sayi girin
        //10.“US Dollars” in secilmedigini test edin
        WebElement usDollars=driver.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        Assert.assertFalse(usDollars.isSelected());

        //11.“Selected currency” butonunu secin
        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement selectedCurrency=driver.findElement(By.xpath("(//*[@class='radio inline'])[3]"));
        selectedCurrency.click();
        selectedCurrency.sendKeys(Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER);

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement text=driver.findElement(By.id("alert_content"));
        Assert.assertTrue(text.isDisplayed());



    }
}
