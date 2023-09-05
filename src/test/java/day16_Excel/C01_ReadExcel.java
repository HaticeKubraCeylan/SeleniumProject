package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu= "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);


        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sutun1=workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        //toString ve casting arasindaki fark;
        //casting yapilirsa "Null" deger dondurur.
        //toString() eger hucrede bir deger olmazsa nullpointerExeption firlatir.
        // Bu da bizim hatayi nerede aldigimizi bulmamizi kolaylastirir

        System.out.println(satir3Sutun1);
        Assert.assertEquals("France", satir3Sutun1);

        //Kullanılan satır sayısın bulun
        /*
        getPhysicalNumberOfRows() methodu dolu olan hücreleri sayarak satır sayısını verir. Index 1 den başlar.
         */
        System.out.println("Kullanılan satır sayısı : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());

        //Sayfadaki satır sayısını yazdırınız
        /*
        getLastRowNum() methodu en son kullanılan hücreye kadar dolu veya boş bütün satırları sayar. Index 0 dan başlar.
         */
        System.out.println("Sayfadaki satır sayısı : "+workbook.getSheet("Sheet1").getLastRowNum());

        //Ülke-Başkent şeklinde verileri yazdırın
        /*
        getPhysicalNumberOfCells() methodu kullanılan sütun sayısını verir.
        Kullanılan sütun sayısını alabilmek için önce satır sayısını belirtiriz. Dolayısıyla o satırdaki kullanılan hücre(cell) sayısını verir.
         */
        for (int i=0; i<workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++){
            for (int j=0; j<workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++){
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test02() throws IOException {
        //Ülke-Başkent şeklinde verileri yazdırın (MAP ile)

        String dosyaYolu= "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Map<String,String>ulkeBaskent=new LinkedHashMap<>();
        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            String ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir=workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+ "\n");
        }
        System.out.println(ulkeBaskent);
    }
}
