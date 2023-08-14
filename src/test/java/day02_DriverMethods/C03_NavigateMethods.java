package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com");   //-->bu method get() meyhodu gibi girilen url e gider
        Thread.sleep(3000);   //java dan gelen beklemedir. belirttiğimiz ms kadar kodlarımızın çalışmasını bekletir

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(3000);

        //Tekrar YouTube'sayfasina donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(3000);

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();

        /*
        navigate() methodları ile sayfada ileri geri yapmak isteyebiliriz back ve forward methodları ile bunu yapabiliriz.
        bu methodları kullanırken get() yada navigate().to() methodu ile sayfaya gidebiliriz.
         */



    }
}
