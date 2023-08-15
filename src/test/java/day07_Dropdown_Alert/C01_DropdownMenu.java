package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {
     /*
    Dropdown menü; alt başlıkların listelendiği sayfadaki bir webelemenre denir.
    Dropdown webelementine sendKeys() methodu ile listede bulunan seçeneklerden istediğimizi gönderebiliriz.
    Gönderemediğimiz durumlarda Select class ından bir obje oluşturarak bu oluşturduğumuz objeye parametre olarak locate ettiğimiz dropdown webelementini yazariz.
    BU oluşturduğumuz obje ile byIndex, byvisibletext ve byValue methodları ile dropdown menudeki seçeneklerden istediğimizi seçebiliriz.
    getOptions() methodu ile tüm dropdown menüdeki seçenekleri listeleyebiliriz.
    getFirstSelectedOption() methodu ile dropdown menüde ilk seçili olan seçeneği getirir.
    Bir dropdown menu <select> tag ına sahip değilse Select classını kullanamazsınız
    */
    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test1() {
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil=driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay=driver.findElement(By.cssSelector("select#month"));
        WebElement gun=driver.findElement(By.cssSelector("select#day"));

        //b. Select objesi olustur
        Select selectyil=new Select(yil);
        Select selectay=new Select(ay);
        Select selectgun=new Select(gun);

        //c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        selectyil.selectByIndex(5);
        selectay.selectByVisibleText("May");
        selectgun.selectByValue("22");
    }

    @Test
    public void test2() {
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler=driver.findElement(By.cssSelector("select#state"));
        Select select=new Select(eyaletler);
        List<WebElement>eyaletListesi=select.getOptions();
        //eyaletListesi.forEach(t-> System.out.println(t.getText())); //-->lambda
        for (WebElement each : eyaletListesi){
            System.out.println(each.getText());
        }
    }

    @Test
    public void test3() {
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state=driver.findElement(By.cssSelector("select#state"));
        Select select=new Select(state);
        String seciliOlanSecenek=select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State", seciliOlanSecenek);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
