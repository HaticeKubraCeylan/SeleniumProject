package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1.Amazon sayfasina gidelim. https://techproeducation.com/
        driver.get("https://techproeducation.com");

        //2.Sayfa basligini(title) yazdirin
        System.out.println("Sayfa başlığı: "+driver.getTitle());

        //3.Sayfa basliginin “Techpro” icerdigini test edin
        if (driver.getTitle().contains("TechPro")){
            System.out.println("TEST PASSES");
        }else System.out.println("TEST FAILED");

        //4.Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url: "+driver.getCurrentUrl());

        //5.Sayfa url’inin “Techpro” icerdigini test edin.
        if (driver.getCurrentUrl().contains("TechPro")){
            System.out.println("TEST PASSES");
        }else System.out.println("TEST FAILED");

        //6.Sayfa handle degerini yazdirin
        String techproSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("Sayfa handle değeri : "+techproSayfaHandleDegeri);
        /*
            getWindowHandle() methodu ile kendimiz isteyerek başka bir pencereye geçiş yaptığımızda iki tane pencere açmış olacağız.
        Dolayısıyla ilk açtığımız pencereye geçiş yapmak istediğimizde ilk açtığımız pencereden sonra almış olduğumuz window handle değeri ile
        geçiş yapabiliriz. Pencereler arası geçiş konusunda bunu detaylı göreceğiz.  Bir sayfaya gittiğimizde bir linke tıkladığımızda bizim kontrolümüz dışında yeni bir pencere
        açılabilir. Bu gibi durumlarda da getWindowHandles() methodu ile driver' ın açmış olduğu pencerelerin handle değerleri bir list' e assing ederiz
        ve pencereye index ile çok rahat geçiş yapabiliriz.
         */

        //7.Sayfa HTML kodlarinda “text” kelimesi gectigini test edin
        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().contains("text"));

        //sayfayı kapatınız
        driver.close();   //-->close() methodu driver ın en son açtığı sayfayı kapatır
        //driver.quit():  -->bu method ise bizim açtığımız birden fazla sekme yada pencerelerin hepsini kapatmak için kullanılır


    }
}
