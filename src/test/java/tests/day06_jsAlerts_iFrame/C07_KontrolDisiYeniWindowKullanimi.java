package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

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
        System.out.println("Click yapmadan once WHD : " + driver.getWindowHandle());
        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        dellBilgElementi.click();
        /*
            Biz driver'a yeni window ac demeden
            kontrolumuz disinda yeni bir window aciliyorsa
            driver eski window'da kalir

            driver'in yeni window'a gecis yapabilmesi icin
            driver
         */
        System.out.println("Click yaptiktan sonra WHD : " + driver.getWindowHandle());
        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        System.out.println(fiyatElementi.getText());
        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin
        //6- Sayfayi kapatin

        ReusableMethods.bekle(2);
    }
}
