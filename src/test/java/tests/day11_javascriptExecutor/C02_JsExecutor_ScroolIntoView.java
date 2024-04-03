package tests.day11_javascriptExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_JsExecutor_ScroolIntoView extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // new products bolumu gorununceye kadar asagi inin

        ReusableMethods.bekle(1);
        WebElement newProductElementi = driver.findElement(By.xpath("//*[text()=' New Product ']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",newProductElementi);


        ReusableMethods.bekle(3);
        // new products bolumunden ilk urunu tiklayin

        WebElement ilkUrun = driver.findElement(By.xpath("(//li[@class='slick-slide slick-current slick-active'])[3]"));

        // jse ile click yapalim
        //jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].click();",ilkUrun);
        ilkUrun.click();
        ReusableMethods.bekle(3);

        // urun isminin Product Tax oldugunu test edin

        String expectedUrunIsmi = "Product Tax";
        String actualUrunIsmi = driver.findElement(By.xpath("(//*[text()='Product Tax'])[1]"))
                                        .getText();


        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        // urun tanim elementinin screenshot'ini kaydedin

        WebElement urunDetayElementi = driver.findElement(By.xpath("//*[@*='prod-detail']"));
        ReusableMethods.bekle(1);
        ReusableMethods.webelementScreenshot(urunDetayElementi,"newProductTesti");
    }
}
