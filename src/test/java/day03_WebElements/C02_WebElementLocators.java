package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //tüm elementlerin oluşması için bekle

        //techpro sayfasına gidelim
        driver.get("https:/techproeducation.com");

        //arama kutusunda java aratalım
        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        Thread.sleep(3000);

        //çıkan seçeneklerden full stack java developer seçeneğine tıklayalım

        List<WebElement>javaDeveloperListesi = driver.findElements(By.linkText("Full Stack Java Developer"));
        /*
        linktext 'i Full Stack Java Developer olan bütün webelementleri javaDeveloperListesi isimli liste attım
        Web sayfası üzerinden yukarı aşağı ok tuşları ile hangi webelement tıklamak istediğim webelemnt ise onu 4. de bulduk. list te index sıfırdan
        başladığı için 3. element benim istediğim element olacaktır.
         */
        javaDeveloperListesi.forEach(t-> System.out.println(t.getText()));  //listteki elemanları yazdır
        javaDeveloperListesi.get(0).click();


        //başlığın Java içerdiğini test edelim
        if (driver.getTitle().contains("Java")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //sayfada kaç tane link olduğunu konsola yazdıralım
        List<WebElement> linkler =driver.findElements(By.tagName("a"));
        System.out.println("Sayfadaki linklerin Sayisi = " + linkler.size());
        /*
        Tag 'ı a olan webelementlerin hepsini bir list e attık. List kullanımında birden fazla webelemente ulaşmak istediğimiz
        için findElement() methodu yerine findElements() methodunu kullanırız.
         */

        //sonra linkleri konsola yazdıralım
        for (WebElement w:linkler){
            if (!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }

        //Lambda ile ;
        linkler.forEach(t-> System.out.println(t.getText()));
        linkler.forEach(link->{if(!link.getText().isEmpty()){System.out.println(link.getText());}});

        /*
        Bir webelementin sahip olduğu texti yazdırmak isterseniz getText() methodunukullanmamız gerekir
         */

        driver.close();





    }
}
