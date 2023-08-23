package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {


    @Test
    public void upload() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@id='file-upload']"));
        //dosyaSec.click();   -->tıklama işleminde windows penceresi açılacağından burda hata alırız
                            //selenium windows pencerelerine müdahale edemez

        //Yuklemek istediginiz dosyayi secelim.
        // "C:\Users\Bulgur Pilavı\Desktop\B171.txt"   -->yüklemek istediğimiz dosyanın yolu
        String dosyaYolu="C:\\Users\\Bulgur Pilavı\\Desktop\\B171.txt";
        dosyaSec.sendKeys(dosyaYolu);
        //uploadFilePath(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim
        WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("File Uploaded!", text.getText());
        Assert.assertTrue(text.isDisplayed());


    }

    @Test
    public void test() {

        // Test sayfasını aç
        driver.get("https://www.ilovepdf.com/compress_pdf");

        // Dosya seçme düğmesini bul ve tıkla
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();

        // Dosya yüklemek için Robot sınıfını kullan
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\testng.pdf";
        bekle(3);
        uploadFilePath(dosyaYolu);



    }
}
