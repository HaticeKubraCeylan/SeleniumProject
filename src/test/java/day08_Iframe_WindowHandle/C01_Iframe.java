package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {



    /* meryem hoca yazdı
        ifarme    bir sayfa içine başka bir html koduyla yerleştirilen link..
        bir sayfa içindeki linkin locate ini alacak  olursak eger bunun tag'ı da iframe ise nosuch exeption hatası olarız
        bunun için driver ı o html tag ına geçirmeliyiz. switch to methodu ile ifarme ye geçmenin 3 yolu var
            index ile= driver.switchTo().frame(index of the iframe)
            id veya name ile =index ile= driver.switchTo().frame(id of the iframe )
            webelement ile= index ile= driver.switchTo().frame(webelement of the iframe)
        (bir sayfada kaçtane ifarme olduğunu nasıl görürüz kaynak kodlarının arama kısmına //ifarme yazarsak kac tane olduğunu görürüz)
        bir sayfada birden fazla link olabilir yani iframe olabilir.iç ice iframe olabilir bunlar arası geçir için ;
        driver.switchto()parentFrame() 1 üstteki seviye deki frame ye cıkartır
        drver.switchTo().defaultContent(); en üstteki frame e cıkmak için kullanılır.
        driver.navigate.refresh() methodu da sayfayı yenileyeceği için yine anasayfaya döner.
        bir sayfa içinde bir frame var bunun içinde de 50 syfalık form var..hepsini doldurdunuz..sonra üst frame geçip
        tekrar form sayfasına dönmeniz gerekirse. defaultContent() bunu yapar..ama refresh yaparsanız doldurduğunuz form silinir.
        bu yüzden refresh sayfayı yenilediği için içindeki frame silinir..bu yüzden eğer refresh kullanacaksak dikkat etmeliyiz.

        //Son olarak ana sayfadaki, sayfanın en altındaki daki 'Povered By' yazisini varligini test edelim
        // "Footer", web sitelerinin veya belgelerin en alt kısmında bulunan bir bölümdür.
        //driver son olarak iframe de kaldı onu geri getirelim..bunu refresh veya drver.switchTo().defaultContent(); ile yapabiliriz
        driver.switchTo().defaultContent();  // driver ı en üstteki parente getirdik.yani bir geri
        String footer=driver.findElement(By.xpath("(//*[@class='blog-footer'])[1]")).getText();
        Assert.assertTrue(footer.contains("Povered By"));
         */
    @Test
    public void iframe() {


        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        WebElement anaSayfadakiText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']"));
        Assert.assertTrue(anaSayfadakiText.getText().contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);   //--> Driver' ı index kullanarak iframe geçiş yaptırdık
        bekle(2);
        WebElement applicationListWE = driver.findElement(By.xpath("//h1"));
        String expectedText = "Applications lists";
        Assert.assertEquals(applicationListWE.getText(),expectedText);

        //Son olarak anasayfadaki footer(sayfanın altında) daki 'Povered By' yazisini varligini test edilip
        ///driver.get(driver.getCurrentUrl());   //refresh yapmanın bi yolu
        driver.navigate().refresh();  //-->Refresh() bizi anasayfaya götürür fakat iframe içinde bir form doldurma gibi işlemler yaparsak bunları sıfırlar
                                      //refresh() kullandığımızda tüm elementleri de yenilediği için tekrar locate almamız gerekebilir.--> staleElementReferansException
        driver.switchTo().defaultContent();  //-->Anasayfasya geçer
        WebElement sayfanınAltındakiText=driver.findElement(By.xpath("//*[text()='Povered By']"));
        Assert.assertTrue(sayfanınAltındakiText.getText().contains("Povered By"));

        /*
        Iframe(inline frame) bir html dökümanın içine yerleştirilmiş başka bir html dökümanına denir.
        Iframe deki bir webelementi locate etmek için driver ımızı yine geçiş komutları için kullandığımız switchTo() methodu ile iframe' e geçirmeliyiz.
        Sayfada kaç tane iframe olduğuna bakarak index (index 0 dan başlar) ile geçiş yapabiliriz. Yada iframe locate ederek de geçiş yapabiliriz yada iframe
        tag' ındaki id ve name attribute değerleri ile de geçiş yapabiliriz.
        SYNTAX:
                driver.switchTo().frame(index yafa iframeWE yada iframe id/name attribute değeri)
         */





    }
}
