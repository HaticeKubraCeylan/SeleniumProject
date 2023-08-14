package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethods {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        Driver ı oluşturduktan sonra maximize yapmamız bizim için gitmek istediğimiz sayfadaki elementlere daha rahat sorunsuz
        ulaşmamız için önemlidir.
        Bunun için driver ı hemen oluşturduktan sonra manage().window().maximize() methodunu kullanırız.
        Maximize yaptıktan sonra internetten kaynaklı sayfa performansından kaynaklı sayfadaki elementler hemen
        yüklenemeyebilir. Dolayısıyla sayfaya gittikten sonra bir elemente, bir butona tıklamak istediğimizde hemen
        sayfa yüklenmez ise elementi bulamayacağı için tıklama işlemini gerçekleştiremeyeceği için testimiz fail verecektir.
        Bunun önüne geçmek için maximize methodundan sonra driver ımıza selenium dan gelen implicitly wait ataması yaparız.
        Bu wait ile sayfanın tüm elementlerinin oluşmasını beklemesi için maximum bir süre belirtiriz.
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //techpro sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //sayfa başlığının Techpro içerdiğini test ediniz
        if (driver.getTitle().contains("TechPro")){
            System.out.println("PASSES");
        }else System.out.println("FAILED");

        //sayfayı kapatınız
        driver.close();


    }
}
