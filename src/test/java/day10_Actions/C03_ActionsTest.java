package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {

    @Test
    public void actions() {

        //techproeducation sayfaasına gidelim
        driver.get("https://techproeducation.com");

        //sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

        /*
        Sayfanın ortalarındaki bir webelementi locate etmek istediğinizde driver sayfayı açtığı zaman webelementi göremediği için
        bazen sayfayı az bir aşağıya doğru scroll yapmamız gerekebilir. Bunun için yukarıdaki örnekteki gibi Page_Down ile bunu gerçekleştirebiliriz.

        Sayfadaki bir webelementi locate ettiğimiz halde nosuchelementexception alıyorsak;
            1) locate i tekrar kontrol ederiz buna rağmen aynı hatayı alıyorsak;
            2) webelementin iframe içinde olup olmadığına bakarız yine aynı hatayı alıyorsak;
            3) driver webelementi göremiyordur, dolayısıyla actions class ı kullanarak scroll yapıp elementin görünür olmasını sağlarız.

         */
    }

    @Test
    public void actions2() {

        //techproeducation sayfaasına gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();  //--> sayfanın en altına scroll yapar

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();      //--> sayfanın en üstüne scroll yapar

    }


    @Test
    public void actions3() {

        //techproeducation sayfaasına gidelim
        driver.get("https://techproeducation.com");

        //Events yazısına kadar scroll yapalım
        WebElement eventsyazisi=driver.findElement(By.xpath("(//h2)[1]"));

        new Actions(driver).scrollToElement(eventsyazisi).perform();  //--> locate ini aldığımız webelemente kadar scroll yapar


    }

}
