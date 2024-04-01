package tests.day09_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_DemoQaWebTable extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriListesi = driver.findElements(By.xpath("(//div[@role='row'])/div[@role='columnheader']"));
        System.out.println("Basliklar: " + ReusableMethods.stringListeDonustur(baslikElementleriListesi));
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikElementleriListesi.get(2).getText());
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataList = driver.findElements(By.xpath("(//div[@role='row'])/div[@role='gridcell']"));
        //System.out.println("Tum datalar : " + ReusableMethods.stringListeDonustur(tumDataList));

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosOlmayanHucreSayisi = 0;
        System.out.println("=========Tum Datalar=======");

        for (int i = 0; i < tumDataList.size() ; i++) {

            if (!tumDataList.get(i).getText().isBlank() ){
                System.out.println(tumDataList.get(i).getText());
                bosOlmayanHucreSayisi++;
            }
        }

        System.out.println("Bos olmayan hucre sayisi : " + bosOlmayanHucreSayisi);
        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriList = driver.findElements(By.xpath("(//div[@role='row'])"));
        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     herhangi bir satirdaki data sayisina bakalim

        List<WebElement> ikinciSatirElementleriList = driver.findElements(By.xpath("(//div[@role='row'])[2]/div[@role='gridcell']"));
        System.out.println("Sutun sayisi : " + ikinciSatirElementleriList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //10. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirsin
        //    (//div[@role='row'])[3]/div[@role='gridcell'][1]
    }
}
