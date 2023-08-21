package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FakerTest extends TestBase {
    @Test
    public void test01() {

        //1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2.“create new account” butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        bekle(2);

        //3.“firstName” giris kutusuna bir isim yazin
        //4.“surname” giris kutusuna bir soyisim yazin
        //5.“email” giris kutusuna bir email yazin
        //6.“email” onay kutusuna emaili tekrar yazin
        //7.Bir sifre girin
        //8.Tarih icin gun secin
        //9.Tarih icin ay secin
        //10.Tarih icin yil secin
        //11.Cinsiyeti secin
        Faker faker=new Faker();
        WebElement firstName=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        String fakeEmail=faker.internet().emailAddress();
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,fakeEmail);
        bekle(2);
        firstName.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,fakeEmail,Keys.TAB,faker.internet().password(),Keys.TAB,Keys.TAB,"25",
                Keys.TAB,"May",Keys.TAB,"2000",Keys.TAB,Keys.TAB,Keys.SPACE,Keys.ENTER);

        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1']")).isSelected());

        //13.Sayfayi kapatin




    }


}
