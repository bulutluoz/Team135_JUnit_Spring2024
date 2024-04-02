package tests.day10_excelOtomasyon_screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C05_TumSayfaScreenshot extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        ReusableMethods.bekle(2);
        // cookies cikarsa kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[9]"))
                .click();
        // youtube logosunun gorundugunu test edin
        ReusableMethods.bekle(2);
        WebElement logoElementi = driver.findElement(By.id("yt-logo-updated-svg_yt4"));
        Assert.assertTrue(logoElementi.isEnabled());

        // tum sayfa screenshot kaydedin
        ReusableMethods.tumSayfaScreenshot(driver);
    }
}
