package tests.day10_excelOtomasyon_screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C06_TumsayfaSS extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        // bestbuy anasayfaya gidin
        driver.get("https://www.bestbuy.com");

        // logonun gorundugunu test edin
        WebElement logoelementi = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));

        Assert.assertTrue(logoelementi.isDisplayed());

        // tumsayfa screenshot alip kaydedin
        ReusableMethods.tumSayfaScreenshot(driver);

        ReusableMethods.bekle(2);
    }
}
