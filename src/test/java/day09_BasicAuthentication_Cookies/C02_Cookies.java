package day09_BasicAuthentication_Cookies;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {

    @Test
    public void test01() {
        /*
        cookie denildiğinde aklımıza manage() methodu gelmeli. manage() methodu ile cookie lerle ilgili tüm işlemleri yaparız
         */


        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-tum cookie'leri listeleyin
        Set<Cookie>cookieSet= driver.manage().getCookies();   //tüm cookieleri cookieSet e attık
        int sayac=1;
        for (Cookie c:cookieSet ) {
            System.out.println(sayac+" .cookie : "+c);
            System.out.println(sayac+" . cookie name : "+c.getName());
            System.out.println(sayac+" . cookie value : "+c.getValue());
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();  //-->USD
        Assert.assertEquals("USD",actualCookieValue);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie= new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);   //cookie ekledik
        //driver.manage().addCookie(new Cookie("en sevdigim cookie","cikolatali"));   --> ikinci yol

        System.out.println("******************************");
        cookieSet= driver.manage().getCookies();    //ekleme yaptıktan sonra cookieSet e tekrar tüm cookie leri atadık
        int sayac1=1;
        for (Cookie c:cookieSet ) {
            System.out.println(sayac1+" .cookie : "+c);
            System.out.println(sayac1+" . cookie name : "+c.getName());
            System.out.println(sayac1+" . cookie value : "+c.getValue());
            sayac1++;
        }

        //6-eklediginiz cookie'nin sayfaya eklendigini test
        Assert.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");   //cookie sildik
        System.out.println("***************************");
        cookieSet= driver.manage().getCookies();   //cookieSet üzerinde değişiklik yapınca işlem sonrası yeniden atama yapmamız gerekiyor
        int sayac2=1;
        for (Cookie c:cookieSet ) {
            System.out.println(sayac2+" .cookie : "+c);
            System.out.println(sayac2+" . cookie name : "+c.getName());
            System.out.println(sayac2+" . cookie value : "+c.getValue());
            sayac2++;
        }
        Assert.assertFalse(cookieSet.contains(driver.manage().getCookieNamed("skin")));


        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();   //tüm cookie leri sildik
        cookieSet= driver.manage().getCookies();  //cookieSet i yeniden güncelledik

        Assert.assertTrue(cookieSet.isEmpty());
    }
}
