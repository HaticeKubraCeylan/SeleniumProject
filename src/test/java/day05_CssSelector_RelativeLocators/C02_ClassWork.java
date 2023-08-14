package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.TableRowSorter;
import java.security.Key;
import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[type='button']")).click();  //bu locate' i xpath ile //button olarak alabiliriz

        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin
        WebElement login=driver.findElement(By.cssSelector("input[type='text']"));
        login.sendKeys("username", Keys.TAB, "password", Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();  //-->sayfaya giriş yapabilmek için back() kullandık

        //6.Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span)[4]")).click();
        Thread.sleep(2000);

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina “2020-09-10” yazdirin
        //9.Pay buttonuna tiklayin
        WebElement amount=driver.findElement(By.cssSelector("input[name='amount']"));
        amount.sendKeys("500", Keys.TAB, "2020-09-10", Keys.TAB, Keys.TAB);
        Thread.sleep(3000);
        amount.submit();

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj=driver.findElement(By.xpath("(//span)[1]"));
        String actualMesaj=mesaj.getText();
        String expectedMesaj="The payment was successfully submitted.";
        if (actualMesaj.equals(expectedMesaj)){
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        //sayfayı kapat
        driver.close();





    }
}
