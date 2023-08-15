package day07_Dropdown_Alert;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alert extends TestBase {

    /*
    Eğer bir sayfadaki butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan uyarı penceresine sağ click yapamıyorsak (incele/inspect)
    bu tür uyarı pencerelerine javascript Alert denir. Bu uyarı penceresini handle edemediiğimiz için driver' ı bu pencereye geçiş yaptırmamız gerekir.
    Bunun için switchTo() methodu kullanılır.
    driver.switchTo().alert() methoduyla alert' e geçiş yaparız. Ve alert onaylamak için accept(), iptal etmek için dismiss(),
    alert üzerindeki yazıyı almak için getText() ve alertteki mesaj kutusuna bir text göndermek için sendKeys() methodu kullanırız.
     */
    /*
https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    "successfuly" icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

 */

    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(2);
        driver.switchTo().alert().accept();  //--> alert'e geçiş yap ve onayla
        String resultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String expectedMessage="You successfully clicked an alert";
        bekle(2);
        Assert.assertEquals(expectedMessage,resultMessage);

    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        driver.switchTo().  //--> geçiş methodu
                alert().   //--> js alert'e geçiş yapar
                dismiss();   //--> cansel
        bekle(2);
        String resultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedMessage="successfuly";
        Assert.assertFalse(resultMessage.contains(unexpectedMessage));

    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("kubra");
        bekle(2);
        driver.switchTo().alert().accept();
        String resultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String expectedMessage="kubra";
        Assert.assertTrue(resultMessage.contains(expectedMessage));

    }
}
