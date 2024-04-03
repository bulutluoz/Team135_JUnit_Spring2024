package tests.day11_javascriptExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C01_WebelementScreenshot extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        // google'a gidin
        driver.get("https://www.google.com");
        // istenirse cookies'i kabul edin
        driver.findElement(By.xpath("//*[text()='Accept all']"))
                .click();
        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@name='q']"));

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edin
        // (url'in Nutella icermesini test edelim)

        String expectedUrlIcerik = "Nutella";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // Arama sonuc yazisinin screenshot'ini kaydedin

        WebElement sonucYaziElementi = driver.findElement(By.id("result-stats"));

        //ReusableMethods.webelementScreenshot(sonucYaziElementi,"GoogleAramaTesti");
        ReusableMethods.webelementScreenshot(sonucYaziElementi);

    }
}
