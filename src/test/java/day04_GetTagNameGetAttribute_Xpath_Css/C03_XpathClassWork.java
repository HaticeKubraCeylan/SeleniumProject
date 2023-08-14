package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();


        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(3000);

        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//*[.='Delete']"));
        if (deleteButonu.isDisplayed()){  //-->bir webelement görünebiliyor ise
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        //Delete tusuna basin
        Thread.sleep(3000);
        deleteButonu.click();

        //Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement= driver.findElement(By.xpath("//h3"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("Test passed");
        }else System.out.println("test failed");

        driver.close();





    }
}
