package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

public class C07_KontrolDisiYeniWindowKullanimi extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // electonics yazisi iframe icinde oldugundan once o iframe'i locate edip, gecis yapalim

        WebElement iframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElementi);

        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assert.assertTrue(electronicsProductsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellBilgElementi = driver.findElement(By.id("dell-core"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellBilgElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);
        ReusableMethods.bekle(2);
        String ilkWindowWHD = driver.getWindowHandle();
        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        dellBilgElementi.click();
        /*
            Biz driver'a yeni window ac demeden
            kontrolumuz disinda yeni bir window aciliyorsa
            driver eski window'da kalir

            driver'in yeni window'a gecis yapabilmesi icin
            driver'a yeni window'un WindowHandleDegerini vermeliyiz
         */

        Set<String> tumWHDSeti = driver.getWindowHandles();
        String ikinciWindowWHD="";

        for (String eachWHD : tumWHDSeti
             ) {

            if ( ! eachWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD = eachWHD;
            }
        }


        driver.switchTo().window(ikinciWindowWHD);

        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String expectedFiyat = "$399.00";
        String actualFiyat = fiyatElementi.getText();

        Assert.assertEquals(expectedFiyat,actualFiyat);

        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin

        driver.switchTo().window(ilkWindowWHD);

        // fashion bir iframe icinde oldugundan once o iframe'e gecis yapmaliyiz

        WebElement iframeFashion= driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashion);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2"));

        Assert.assertTrue(fashionYaziElementi.isDisplayed());

        //6- Sayfayi kapatin

        ReusableMethods.bekle(2);
    }
}
