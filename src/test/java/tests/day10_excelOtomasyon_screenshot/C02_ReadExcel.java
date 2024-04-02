package tests.day10_excelOtomasyon_screenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // goreve baslamadan once, datalarin oldugu sayfaya ulasalim
        String dosyaYolu = "src/test/java/tests/day10_excelOtomasyon_screenshot/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim

        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)
        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1data2 = sayfa1.getRow(0).getCell(1).getStringCellValue();
        //getCell() bize Cell objesi dondurdugu icin direk String variable'a atayamayiz
        // toString() veya getStringCellValue() kullanabiliriz
        System.out.println(satir1data2); // Başkent (İngilizce)

        //		- 2.satir 4.cell’in afganistan’in baskenti "Kabil" oldugunu test edelim
        String expectedData = "Kabil";
        String actualData = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedData,actualData);

        //		- Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()); // 190 bize son satirin index'ini verir

        //		- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191

        // Sayfa2'deki son satir index'ini ve fiziki olarak kullanilan satir sayisini yazdirin

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum()); // 19
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()); // 8
        // bos satirlari saymaz, sadece data iceren satir sayisini yazdirir

        // Sayfa2'deki 3.satir, 7.sutun'daki bilgiyi yazdirin
        System.out.println(workbook.getSheet("Sayfa2").getRow(2).getCell(6)); // null

        // Sayfa2'deki 5.satir, 2.sutun'daki bilgiyi yazdirin
        // System.out.println(workbook.getSheet("Sayfa2").getRow(4).getCell(1)); // NullPointerException
        // satir fiziki olarak kullanilmadigi icin sanal olarak satir olusturulmamis

        // Sayfa2'deki 25.satir, 1.sutun'daki bilgiyi yazdirin
        // System.out.println(workbook.getSheet("Sayfa2").getRow(24).getCell(0)); // NullPointerException


        // Senegal'in turkce baskent isminin Dakar oldugunu test edin

        String expectedBaskentIsmi = "Dakar";
        String actualBaskentIsmi ="";

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            // i bize satir numarasini getiriyor
            // biz o satirdaki ulke ismine bakip, Senegal ise, baskenti kaydedelim

            if (sayfa1.getRow(i).getCell(0).toString().equals("Senegal")){
                actualBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();
            }

        }

        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

        // ulkeler excelinde turkce baskent ismi Amsterdam olan bir ulke oldugunu test edin

        boolean amsterdamVarMi = false;

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            if (satirdakiBaskentIsmi.equals("Amsterdam")){
                amsterdamVarMi = true;
            }
        }

        Assert.assertTrue(amsterdamVarMi);

        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        // ulke ismi key, baskent value olsun


        // Senegal'in turkce baskent isminin Dakar oldugunu test edin


        // ulkeler excelinde turkce baskent ismi Amsterdam olan bir ulke oldugunu test edin


    }
}
