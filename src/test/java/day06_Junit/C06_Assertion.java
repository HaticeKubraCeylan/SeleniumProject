package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {
    //https://www.youtube.com adresine gidin
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //Sayfa başlığının “YouTube” oldugunu test edin
    //YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
    }

    @Test
    public void test01() {
        //Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals("YouTube", driver.getTitle());

        //YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test02() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test03() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertNotEquals("youtube", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    /*
        //https://www.facebook.com adresine gidin
        //Url'in facebook içerdiğini test(assertion ile)
        //"Create an Account" button'una basin
        //Çıkan formu doldurunuz
        //kaydol butonuna tıklayınız
        Not: Before methodda driver ayarlarını yapınız
         After ile sayfayı kapatınız
 */
}



