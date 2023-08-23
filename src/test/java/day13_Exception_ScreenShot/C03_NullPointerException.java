package day13_Exception_ScreenShot;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerException {

    WebDriver driver;
    Faker faker;
    Actions actions;


    @Test
    public void test01() {


       /*
        NULLPOINTEREXCEPTIN
            Eğer bir obje yada değişken oluşturup bunlara atama yapmazsak bu exception'ı alırız
         */

        //org.openqa.selenium.SessionNotCreatedException: Driver ayarları için WebDriverManager kullanmadığımızdan bu hatayı aldık
        //driver = new ChromeDriver();//-->driver objesine atama yapmazsak NULLPOINTEREXCEPTION alırız
        driver.get("https://amazon.com");

    }

    @Test
    public void test02() {

        //faker=new Faker();  -->atamasını yapınca nullPointerException hatasını handle etmiş olduk
        System.out.println(faker.name().firstName());//-->nullPointerException aldık
    }
}
