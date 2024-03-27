package tests.day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;
import java.util.Set;

public class C01_SwitchingWindows extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h2"));

        String expectedYazi = "Add/Remove Elements";
        String actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.

        // link'e tikladigimizda kontrolumuz disinda yeni bir tab acildigi icin
        // o tab'a gecebilmek icin WindowhandleDegerini bulmaliyiz

        // 1. adim click yapmadan ilk window'un WHD'ini kaydedelim
        String ilkWindowWHD = driver.getWindowHandle();

        // 2. click yapalim
        driver.findElement(By.linkText("Electronics Products"))
                .click();

        // 3.click'den sonra 2 window olacagi icin, iki WHD olur
        //   bir Set olusturup 2 WHD'ini kaydedelim
        Set<String> tumWHDSeti = driver.getWindowHandles();

        // 4. bir for-each loop ile Set'deki iki WHD'den
        //    ilk sayfanin WHD'ne esit olmayani, ikinciWindowWHD olarak kaydedelim

        String ikinciWindowWHD = "";

        for (String eachWHD : tumWHDSeti
             ) {

            if (  ! eachWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD = eachWHD;
            }
        }

        // 5. buldugumuz ikinciWindowWHD'ni kullanarak ikinci window'a gecelim
        driver.switchTo().window(ikinciWindowWHD);

        //● Electronics sayfasinin acildigini test edin

        String expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Bulunan urun sayisinin 16 olduğunu test edin
        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int expectedUrunsayisi = 16;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        Assert.assertEquals(expectedUrunsayisi,actualUrunSayisi);

        //● Ilk actiginiz addremove sayfasina donun

        driver.switchTo().window(ilkWindowWHD);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(2);
    }
}
