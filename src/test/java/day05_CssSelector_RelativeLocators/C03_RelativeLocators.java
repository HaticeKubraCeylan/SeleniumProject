package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_RelativeLocators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //Berlin'i 3 farkli relative locator ile locate edin
        WebElement NYCWebElement=driver.findElement(By.xpath("//*[@id='pid3_thumb']"));
        WebElement bayAreaWebElement=driver.findElement(By.xpath("//*[@id='pid8_thumb']"));
        WebElement berlinWebElement=driver.findElement(with(By.tagName("img")).below(NYCWebElement).toLeftOf(bayAreaWebElement));
        berlinWebElement.click();

        //Relative locator'larin dogru calistigini test edin
        String actualDegeri=berlinWebElement.getAttribute("id");  //pid7_thumb
        String expectedDegeri="pid7_thumb";
        if (actualDegeri.equals(expectedDegeri)){
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        driver.close();

        /*
        RELATIVE LOCATOR
            Bir web sayfasında benzer tag 'lara sahip webelemenlerin olduğu durumlarda kullanılabilir.
        Örneğin bir webelementini locate ettiniz ve o elementin altındaki bir webelemente ulaşmak için önündeki başka bir webelementi kapatmanız gerekir(reklam gibi)
        bu gibi durumlarda relative locator ile o elemntin locate 'ini almadan yukarıdaki örnekteki gibi handle edebilirsiniz.
            Relative Locator ile kullanılan methodlar;
                above () --> belirtilen elementin üstünde olan elementi seçer
                below () --> belirtilen elementin altında olan elementi seçer
                to_left_of () --> belirtilen elementin solunda olan elementi seçer
                to_right_of () --> belirtilen elementin sağında olan elementi seçer
                near () --> belirtilen elementin yakınında/yanında olan elementi seçer
         */




    }
}
