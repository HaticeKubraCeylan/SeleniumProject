package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {


    @Test
    public void test() throws IOException {

        /*
          Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
         (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
        */

        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue(712816);
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(2161000);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(8982000);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(5663000);
        FileOutputStream fos=new FileOutputStream("src/test/java/resources/Capitals.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();


        //ödev
        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
        //-Satir sayisini bulalim
        //-Fiziki olarak kullanilan satir sayisini bulun
        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        //1)Yeni bir Class olusturalim WriteExcel
        //2)Yeni bir test method olusturalim writeExcelTest()
        //3)Adimlari takip ederek 1.satira kadar gidelim
        //4)5.hucreye yeni bir cell olusturalim
        //5)Olusturdugumuz hucreye “Nufus” yazdiralim
        //6)2.satir nufus kolonuna 1500000 yazdiralim
        //7)10.satir nufus kolonuna 250000 yazdiralim
        //8)15.satir nufus kolonuna 54000 yazdiralim 9)Dosyayi kaydedelim
        //10)Dosyayi kapatalim




    }
}
