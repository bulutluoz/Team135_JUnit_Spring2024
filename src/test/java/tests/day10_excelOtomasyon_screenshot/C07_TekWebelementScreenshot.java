package tests.day10_excelOtomasyon_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class C07_TekWebelementScreenshot extends TestBase_BeforeAfter {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);
        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);

        // arama sonuc yazisinin screenshot'ini alip kaydedin

        // 1- screenshot alinacak webelemnti locate edip kaydedelim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        // 2- screenshot'in kaydedilecegi dosyayi olusturalim

        File webelementSS = new File("target/screenshots/webelementSS.png");

        // 3- screenshot alip gecici dosyaya kaydedelim

        File geciciDosya = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi ana dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,webelementSS);

    }
}
