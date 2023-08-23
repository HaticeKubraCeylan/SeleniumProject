package homework;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.management.StandardMBean;

public class C07 extends TestBase {

    @Test
    public void test() {

        ////https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        ////Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//h5)[3]")).click();

        ////""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text=driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(text.isDisplayed());

        ////Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        ////New Tab butonunun görünür olduğunu doğrula
        WebElement tubButton=driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(tubButton.isDisplayed());

        ////New Tab butonuna click yap
        tubButton.click();

        ////Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        window(1);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='sampleHeading']")).isDisplayed());

        ////İlk Tab'a geri dön
        window(0);

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(tubButton.isDisplayed());



    }
}
