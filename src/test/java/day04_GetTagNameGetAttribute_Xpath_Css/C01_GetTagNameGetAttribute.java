package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute{
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        ////<input id="searchHeaderInput" type="text" class="form-input" placeholder="Search Program">
        //arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.id("searchHeaderInput"));

        //arama kutusunun tag name' inin input olduğunu test edelim
        System.out.println("Arama Kutusu WebElementi Tag Name: "+aramaKutusu.getTagName());
        String gercekTagName=aramaKutusu.getTagName();
        String beklenenTagName="input";
        if (gercekTagName.equals(beklenenTagName)){
            System.out.println("Test passed");
        } else System.out.println("Test failed");

        //arama kutusunun class attributununn değerinin "form-input" olduğunu test ediniz
        String gercekAttributeName= aramaKutusu.getAttribute("class");  //-->form-input
        System.out.println("Class Attribute değeri: "+gercekAttributeName);
        String istenenAttributeDegeri="form-input";
        if (gercekAttributeName.equals(istenenAttributeDegeri)){
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        //sayfayı kapatınız
        driver.close();





    }
}