package day15_ExtenetReport_Webtable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel extends TestBase {


    @Test
    public void test() throws IOException {
        /*
        Eğer projemizde excel dosyasından veri almak istiyorsak öncelikle mvnrepository.com adresinden arama çubuğundan
        poi yazarak apache poi ve poi_ooxml dependency'lerini pom.xml dosyamıza kopyalamamız gerekir. Her iki dependency
        nin de versiyonları aynı olmalı.
         */

        //1- Projemize resources package'ı altına koyduğumuz excel dosyamızın yolunu alırız.
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";

        //2- Dosyayı okuyabilmemiz için javada akışa almamız gerekir
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3- Java ortamında bir excel dosyası oluşturabilmek için
        Workbook workbook= WorkbookFactory.create(fis);

        //4- Oluşturduğumuz excel dosyasında sayfa seçmemiz gerekir
        Sheet sheet=workbook.getSheet("Sheet1");

        //5- Belirttiğimiz sayfadaki satır bilgisini seçmemiz gerekir
        Row row=sheet.getRow(0);   //index 0'dan başlar

        //6- Belirttiğimiz satırdaki hücre bilgisini seçmemiz gerkir
        Cell cell=row.getCell(0);

        //Sout içinde cell bilgisini yazdırdığımızda 1.satır 1.hücredeki bilgiyi verir
        System.out.println(cell);  //-->COUNTRY


        /*
        NOT:
        Excel dosyanız açıkken işlem yapmayınız
        Excel dosyasında herhangi bir hücrede değişiklik yaptıysanız exceli kapatırken kaydetmeyiniz
         */




    }


    @Test
    public void test02() throws IOException {
        //***pratik çözüm
        //1.satır ve 1.sütun bilgilerini yazdıralım
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));


    }
}
