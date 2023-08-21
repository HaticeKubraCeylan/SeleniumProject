package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.bouncycastle.util.io.TeeInputStream;
import org.junit.Test;


public class C01_Faker  {

    @Test
    public void faker() {

        /*
        Faker class ı fake datalar oluşturabilmek için öncelikle mvnrepository.com adresinden github-javafaker dependency alıp pom.xml dosyamıza koyulur.
        Faker classından bir obje oluşturup isim, soyisim, şehir, adres vb.. fake datalar oluşturabiliriz.
         */

        Faker faker=new Faker();

        //faker objesini kullanarak fake isim yazdıralım
        System.out.println(faker.name().firstName());

        //faker objesini kullanarak fake soyisim yazdıralım
        System.out.println(faker.name().lastName());

        //faker objesini kullanarak fake isim-soyisim yazdıralım
        System.out.println(faker.name().fullName());

        //faker objesini kullanarak fake şehir yazdıralım
        System.out.println(faker.address().city());

        //faker objesini kullanarak fake adres yazdıralım
        System.out.println(faker.address().fullAddress());

        //faker objesini kullanarak fake email yazdıralım
        System.out.println(faker.internet().emailAddress());

        //faker objesini kullanarak fake rastgele 15 haneli sayı yazdıralım
        System.out.println(faker.number().digits(15));

    }

}
