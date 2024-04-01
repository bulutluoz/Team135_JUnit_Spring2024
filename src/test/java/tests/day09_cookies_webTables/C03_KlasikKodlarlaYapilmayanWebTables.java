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

        List<WebElement> ucuncuSutunDataList = driver.findElements(By.xpath("(//div[@role='trow'])/div[@role='tdata'][3]"));
        System.out.println("ucuncu sutun elementleri list : " +
                            ReusableMethods.stringListeDonustur(ucuncuSutunDataList));


        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        
        // herbir satiri elden gecirip
        // Cotegory bilgisi Furniture olan satiri bulup
        // o satirdaki urun fiyatini yazdirmaliyiz
        // her satirdaki Category elementinin locate'i
        // (//div[@role='trow'])[    5     ]/div[@role='tdata'][2]

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            String dinamikCategoryXpathi = "(//div[@role='trow'])[" + i + "]/div[@role='tdata'][2]";
            String dinamikFiyatXpathi = "(//div[@role='trow'])[" + i + "]/div[@role='tdata'][3]";


            String satirdakiCategoryDegeri = driver.findElement(By.xpath(dinamikCategoryXpathi))
                                                    .getText();
            String satirdakiFiyatDegeri = driver.findElement(By.xpath(dinamikFiyatXpathi))
                                                    .getText();

            if (satirdakiCategoryDegeri.equals("Furniture")){
                System.out.println("Category'si Furniture olan urunun fiyati : "+ satirdakiFiyatDegeri);
            }

        }

        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        //    ((//div[@role='trow'])[4]/div[@role='tdata'])[2]

        printData(1,2); // Electronics
        printData(2,3); // $399.00

    }

    public void printData(int satirNo, int sutunNo){

        //    ((//div[@role='trow'])[   4   ]/div[@role='tdata'])[   2   ]

        String dinamikXpath = "((//div[@role='trow'])[" + satirNo + "]/div[@role='tdata'])["+sutunNo+"]";

        WebElement istenenWebelement = driver.findElement(By.xpath(dinamikXpath));

        System.out.println(satirNo+".satir,"+sutunNo+".sutundaki data : " + istenenWebelement.getText());

    }
}
