package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {


    @Test
    public void test01() {

        String farkliYol=System.getProperty("user.home");
        String ortakYol="/Downloads/b10 all test cases, code.docx";
        String dosyaYolu=farkliYol+ortakYol;
        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();
        bekle(4);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //"C:\Users\Bulgur Pilavı\Desktop\b10 all test cases, code.docx"

        String farkliAnaYol=System.getProperty("user.home");
        String ortakYoll="/Downloads/b10 all test cases, code.docx";
        String path=farkliAnaYol+ortakYoll;
        System.out.println(Files.exists(Paths.get(path)));
        Assert.assertTrue(Files.exists(Paths.get(path)));


        //"C:\Users\Bulgur Pilavı\Downloads\b10 all test cases, code.docx"   dosya yolu
    }
}
