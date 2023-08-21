package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {

    @Test
    public void actions() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        iframe çıktığı için driver ı iframe e geçirmem gerekir
         */

        //driver.switchTo().frame(0);  //testbase de method oluşturduk
        frameIndex(0); //TestBase deki method ile ifame e geçiş yaptık

        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();  //drag webelementini alıp drop webelementinin üzerine bırakır

    }

    @Test
    public void actions2() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameIndex(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).  //-->drag webelementini tut ve bekle
                moveToElement(drop).  //-->drop elementinin üzerine götür
                release().   //-->basılı tutulan webelementi serbest bırakır
                perform();  //-->action ı işleme aldık


        //actions.clickAndHold(drag).release(drop).perform();   --> ikinci yol

    }


    @Test
    public void actions3() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        frameIndex(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        //WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(150,20).release().perform();

        //drag webelementinin drop webelementinin üzerine bırakıldığını test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());


    }
}
