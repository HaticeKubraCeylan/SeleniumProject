package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.Key;

public class C03 extends TestBase {

    @Test
    public void test01() {

        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2.Sign in butonuna basin
        WebElement signInButton= driver.findElement(By.xpath("//*[@class='icon-signin']"));
        signInButton.click();
        //driver.findElement(By.cssSelector("button#signin_button"));

        //3.Login kutusuna "username" yazin
        //4.Password kutusuna "password" yazin
        bekle(2);
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);

        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.navigate().back();

        //6.Pay Bills sayfasina gidin
        //driver.findElement(By.xpath("//*[text()='Online Banking']"));
        driver.findElement(By.cssSelector("li#onlineBankingMenu>div>strong")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7."Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("//*[@href='#ui-tabs-3']")).click();

        //8."Currency" drop down menusunden Eurozone'u secin
        WebElement dropdown=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(dropdown);
        select.selectByValue("EUR");

        //9."amount" kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("500");

        //10."US Dollars" in secilmedigini test edin
        WebElement usDollars=dropdown.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        Assert.assertFalse(usDollars.isSelected());

        //11."Selected currency" butonunu secin
        WebElement selectedCurrency=dropdown.findElement(By.xpath("(//*[@class='radio inline'])[3]"));
        selectedCurrency.click();

        //12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        //driver.findElement(By.cssSelector("div.controls>input:nth-child(5)")).click();
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();

        //13."Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin.
        WebElement text=driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(text.isDisplayed());



    }
}
