package tests.day09_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C03_KlasikKodlarlaYapilmayanWebTables extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        WebElement baslikSatiriElementi = driver.findElement(By.xpath("//div[@role='hrow']"));
        System.out.println("Baslik satiri : " + baslikSatiriElementi.getText());

        //  3. 3.sutunun basligini yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@role='hrow']/div[@role='hdata']"));
        System.out.println("tum basliklar listesi : " + ReusableMethods.stringListeDonustur(baslikElementleriList));
        System.out.println("3.sutun basligi : " + baslikElementleriList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> dataElementleriList = driver.findElements(By.xpath("//*[@*='tdata']"));
        System.out.println("Tum data listesi " + ReusableMethods.stringListeDonustur(dataElementleriList));

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Toblo body'sindeki data sayisi : " + dataElementleriList.size());

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@*='trow']"));
        System.out.println("Toblo body'sindeki satir sayisi : " + satirElementleriList.size());

        //  7. Tablodaki sutun sayisini yazdirin

        // yukarda toplam data sayisi ve toplam satir sayisi buldugumuz icin
        // onlari bolerek sutun sayisina ulasabiliriz
        System.out.println("Tablodaki sutun sayisi : " +
                dataElementleriList.size()/satirElementleriList.size()   ); // 4

        // eger locate ile sutun sayisina ulasmak istersek
        // herhangi bir satirdaki sutun sayisina bakabiliriz

        List<WebElement> ikinciSatirDatalariList = driver.findElements(By.xpath("((//div[@role='trow'])[2]/div[@role='tdata'])"));

        System.out.println("Sutun sayisi : " + ikinciSatirDatalariList.size());

        //  8. Tablodaki 3.kolonu yazdirin



        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin


        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        //    ((//div[@role='trow'])[4]/div[@role='tdata'])[2]
    }
}
