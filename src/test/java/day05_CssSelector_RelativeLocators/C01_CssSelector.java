package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        WebElement addElementButton= driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();
        Thread.sleep(3000);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton=driver.findElement(By.cssSelector("button[class='added-manually']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        //Delete tusuna basin
        deleteButton.click();
        Thread.sleep(3000);

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement =driver.findElement(By.cssSelector("h3"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        //sayfayı kapat
        driver.close();

        /*
        cssSelector kullanmak için ilk olarak tag name sonrasında köşeli parantez içinde attribute ve değeri yazılır.
        SYNTAX:
                    tagName[attributeName='attributeDeğeri']

               XPATH ile CSSSELECTOR arasındaki fark
               1- xpath ile bir webelement için birden fazla sonuç verirse index ile bunu tek 'e düşürebiliriz.Fakat cssSelector ile index kullanamayız.
               2- xpath ile bir tag 'a sahip webelementin text 'ini locate edebiliriz. Fakar css ile bunu yapamayız.
               3- cssSelector xpath 'e göre daha hızlı çalışır
         */


        /*
        ÖDEV:
        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        Add Element butonuna 100 kez basınız
        Delete butonuna 90 kez basınız ve 90 kez basıldığını doğrulayınız
         */



    }
}
