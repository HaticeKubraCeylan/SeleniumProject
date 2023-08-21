package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FilesExists {

    @Test
    public void test01() {

        /*
        Bilgisayarımızdaki bir dosyanın varlığını test edebilmemiz için
        1- Öncelikle dosyanın yolunu almamız gerekir(dosya üzerine sağ click yapıp yololarak kopyala seçeneği ile kopyalayabiliriz.
        Windows un alt sürümlerinde sağ click yapınca yol olarak kopyala çıkmıyor ise shsift tuşuna basılı olarak sağ click yaparsanız çıkıyor.

        2- Files.exists(Paths.get(dosyaYolu)) files claasından exists() methodu ile dosya yolunun varlığını test edebiliriz.
        Yukarıdaki kod bize true veya false döner. Dolayısıyla bu kodu direk Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)))
        şeklinde yazarak dosya varsa testim passed olur yoksa failed.
         */
        //masaüstünde bir dosya oluşturalım

        String dosyaYolu="C:\\Users\\Bulgur Pilavı\\Desktop\\B171.txt";

        //bu dosyanın varlığını doğrulayalım
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }


    @Test
    public void test02() {

        /*
        Ortak çalışmalarda bir server üzerinden bir dosya yolu almak istersek, her kullanıcının bilgisayarının ana yolu farklı olabilir ve
        serverdaki dosyanın yolu ortaktır. Dolayısıyla System.getProperty(user.home) methodu ile bilgisayarımızın ana yolunu alabilir,
        serverdaki ortak yol ile bunu birleştirip dosyanın yolunu dinamik olarak alabiliriz
         */

        //test01 methodundaki gibi dosyanın yolunu doğrulayalım
        System.out.println(System.getProperty("user.home"));
        String farkliYol=System.getProperty("user.home");   //herkeste farklı olan yol
        String ortakYol="/Desktop/B171.txt";   //serverdaki dosyanın yolu
        String dosyaYolu=farkliYol+ortakYol;    //bu şekilde dosyanın yolunu aldık

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
