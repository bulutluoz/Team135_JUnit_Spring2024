package tests.day10_excelOtomasyon_screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_GetScreenshot extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);


        // arama sonuc sayfasinin screenshot'ini kaydedin

        TakesScreenshot tss = (TakesScreenshot) driver;

        ReusableMethods.bekle(2);
    }
}
