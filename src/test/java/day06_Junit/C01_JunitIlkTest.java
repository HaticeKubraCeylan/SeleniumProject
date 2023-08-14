package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitIlkTest {
    /*
    Projemizde Junit framework' u kullanmak istiyorsan öncelikle mvnrepository.com adresinden junit dependency' sini pom.xml dosyamıza koymamız gerekiyor.
    BU dependency sayesinde artık main method kullanmadan notasyon sayesinde test scriplerimizi yazacağız. Notasyonlar @ işareti ile başlar.
        @Test notasyonu içinde oluşturacağımız test methodunda kodlarımızı yazar ve çalıştırırız.

        @Test notasyonuna sahip bir methodu hızlı bir şekilde oluşturmak istersek alt+insert tuşlarına basarak test methodunu oluşturabiliriz.

        Junit framework ünde testlerimizi istediğimiz bir sıralamada çalıştırmak istersek alfabetik ve numerik olarak test methodlarının isimlerini belirtmemiz gerekir.
     */

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }

    @Test
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void test03() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
    }

    @Test
    public void test04() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
    }
}
