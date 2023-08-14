package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodsTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String amazonUrl ="https://amazon.com";
        String techproUrl ="https://techproeducation.com";

        //amazon sayfasına gidiniz
        driver.get(amazonUrl);

        //sayfa başlığını konsola yazdırınız
        String amazonActualTitle = driver.getTitle();  //--> gidilen sayfanın başlığını verir
        System.out.println("Amazon sayfası başlığı: "+amazonActualTitle);

        //sayfanın url ini konsola yazdırınız
        String amazonActualUrl = driver.getCurrentUrl();   //-->gidilen sayfanın url ini verir
        System.out.println("Amazon sayfası Url i : "+amazonActualUrl);

        //techproeducation sayfasına gidiniz
        driver.get(techproUrl);

        //sayfa başlığını konsola yazdırınız
        String techproActualTitle = driver.getTitle();
        System.out.println("Techpro sayfa başlığı : "+techproActualTitle);

        //sayfanın url ini konsola yazdırınız
        String techproActualUrl = driver.getCurrentUrl();
        System.out.println("Techpro sayfası Url : "+techproActualUrl);


    }


}
