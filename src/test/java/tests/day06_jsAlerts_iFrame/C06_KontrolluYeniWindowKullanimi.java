package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C06_KontrolluYeniWindowKullanimi extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        /*
            Eger yaptigimiz test sirasinda
            kontrollu olarak yeni tab/window olusturursak
            driver objesi OTOMATIK olarak yeni window'a gecis yapar

            Eger testimiz sirasinda
            gectigimiz window'lara tekrar donmemiz gerekiyorsa
            o window'dan gecerken WindowHandleDegerini kaydedip
            ihtiyac oldugunda
            driver.switchTo().window(toWindowHandleDegeri);
            ile eski window'a donebiliriz.
         */

        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://www.testotomasyonu.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String toWindowHandleDegeri = driver.getWindowHandle();
        System.out.println("test otomasyon WHD : " + toWindowHandleDegeri);
        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);
        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        System.out.println("wisequarter WHD : " + driver.getWindowHandle());
        //● Sayfa title’nin “wisequarter” icerdigini test edin

        expectedTitleIcerik = "Wise Quarter";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        System.out.println("walmart WHD : " + driver.getWindowHandle());

        //● Sayfa title’nin “Walmart” icerdigini test edin
        expectedTitleIcerik ="Walmart";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Ilk acilan window'a donun ve testotomasyonu sayfasina dondugunuzu test edin

        driver.switchTo().window(toWindowHandleDegeri);
        expectedTitleIcerik = "Otomasyon";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        ReusableMethods.bekle(3);
    }
}
