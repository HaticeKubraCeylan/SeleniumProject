package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {

        /*
        Bir webelementi locate etmek istediğimizde o elementin unique olması gerekir. Xpath kullanımını biliyorsak istediğimiz
        webelementi her zaman unique alabiliriz.
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");


        //b.Search(ara) “city bike”(arama kutusunu xpath ile locate edelim)
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        /*
        Xpath kullanımına // sembolleri ile başlarız. Bu sembollerden sonra tag name belirtmemiz gerekir.
        tag name yerine * sembolünü kullanabiliriz. BU sembol tag name farketmeksizin anlamına gelir.
        sonra köşeli parantez açıp kullanacağımız attribute 'ten önce @ sembolü kullanmalıyız. Sonrasında da attribute
        yazılıp = tek tırnak içinde attributün değeri yazılmalıdır ve köşeli parantez kapatılır.
        SYNTAX:
                //tagName[@attributeName='attributeDeğeri']
                //*[@*='attributeDeğeri']  --> eğer bu kullanımda birden fazla sonuç verirse * koyduğumuz yerlere tagName ve attributeName 'i belirtmemiz gerekir.
                                               Buna rağmen birden fazla sonuç verirse o webelementin indexini aşağıdaki şekilde belirtiriz.
                                               (//tagName[@attributeName='attributeDeğeri'])[index]

           Xpath kullanmadığımız zaman bir webelemntin locate 'i ile alakalı birden fazla sonuç çıkarsa bütün sonuçları bir liste atıp
           index ile o webelementi handle etmem gerekecektir. Dolayısıyla yukarıdaki örnekteki gibi xpath kullanımında birden fazla sonuç alırsak
           direk xpath üzerinden index ile bunu çözebiliriz.
         */

         /*
        //*[@type='text'] -->  tag name farketmeksizin demek
        //*[@*='text'] --> tag name farketmeksizin ve attribute farkmeksizin demek
        */



        //c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(aramaSonucu.getText());

        //Sadece sonuç sayısını yazdırın
        String [] sonucSayisi = aramaSonucu.getText().split(" ");
        System.out.println("sonuç sayısı: "+sonucSayisi[2]);

        //d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//h2//a)[1]")).click();
        //xpath alırken direk tag ları kullanarak da unique sonuç vermezse yukarıdaki örnekteki gibi index ile elementi handle edebiliriz.

        //sayfayı kapat
        driver.close();





    }
}
