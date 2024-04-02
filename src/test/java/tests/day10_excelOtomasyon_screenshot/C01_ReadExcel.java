package tests.day10_excelOtomasyon_screenshot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // ulkeler dosyasina erisip sayfa1'deki 2.satir 3.sutundaki bilgiyi yazdirin

        // 1- Java ile bilgisayarimizdaki bir dosyaya ulasmak icin dosya yoluna ihtiyacimiz var
        String dosyaYolu = "src/test/java/tests/day10_excelOtomasyon_screenshot/ulkeler.xlsx";

        // 2- Dosyadaki bilgileri alabilmek icin file input stream olusturmaliyiz

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- fiziki excel'den okunan bilgileri
        //    class'imizda kullanabilmemiz icin
        //    class icinde o bilgileri excel formatinda kullanabilecek bir objeye yuklemeliyiz

        Workbook workbook = WorkbookFactory.create(fis); // butun excel dosyasinin kopyasi

        Sheet sayfa1 = workbook.getSheet("Sayfa1"); // workbook'daki sayfa1

        // satir ve sutunda index kullanilir
        // Java'daki genel kullanima uygun olarak index 0'dan baslar
        Row satir2 = sayfa1.getRow(1);

        Cell satir2ucuncuData = satir2.getCell(2);

        System.out.println(satir2ucuncuData); // Afganistan

        // 4.satirdaki 2.datayi yazdiralim

        System.out.println(sayfa1.getRow(3).getCell(1)); // Aljiers


    }
}
