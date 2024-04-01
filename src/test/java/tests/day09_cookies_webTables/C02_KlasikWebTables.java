package tests.day09_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C02_KlasikWebTables extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //1."https://testotomasyonu.com/webtables" adresine gidin

        driver.get("https://testotomasyonu.com/webtables");
        //2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());
        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBodyElementi.getText();

        Assert.assertTrue(actualTumBody.contains(expectedBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        // System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));

        for (int i = 0; i < satirElementleriList.size() ; i++) {

            System.out.println(i+1 +". satir   :    " + satirElementleriList.get(i).getText());
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin

        int expectedSutunSayisi = 4 ;
        // herhangi bir satirdaki datalari list'e koyup, list'in size'ina bakabiliriz

        List<WebElement> birinciSatirElementleriList = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int actualSutunSayisi = birinciSatirElementleriList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin

        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[3]"));


        System.out.println("Ucuncu sutun elementleri listesi : " +
                            ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));

        //8. Tablodaki basliklari yazdirin

        WebElement baslikSatirElementi = driver.findElement(By.xpath("//thead/tr"));
        System.out.println("Basliklar : " + baslikSatirElementi.getText());


        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        ReusableMethods.bekle(2);
    }
}
