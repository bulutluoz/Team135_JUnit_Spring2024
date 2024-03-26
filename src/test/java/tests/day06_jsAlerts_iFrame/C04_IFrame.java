package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_IFrame extends TestBase_BeforeAfter {

    @Test
    public void iFrameTest(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        // once electronics products'in icinde oldugu iframe'e gecis yapmaliyiz
        WebElement iframeElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElectronics);

        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(electronicsProductsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellBilgisayarElementi = driver.findElement(By.xpath("(//*[@id='pictext1'])[1]"));

        String actualYazi = dellBilgisayarElementi.getText();
        String expectedYazi = "DELL Core I3 11th Gen";

        Assert.assertEquals(expectedYazi,actualYazi);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren
        //   en az 1 urun olduğunu test edin

        // once anasayfaya gecip, oradan sagdaki iframe'e gecis yapalim
        driver.switchTo().parentFrame();
        WebElement iFrameFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iFrameFashion);

        // tum urunleri bir list olarak kaydedelim
        List<WebElement> tumUrunElementleriList = driver.findElements(By.xpath("//a[@class='overlay']"));

        // listeyi String list'e cevirelim

        List<String> urunIsimleriList = ReusableMethods.stringListeDonustur(tumUrunElementleriList);

        // Bir flag olusturalim, listedeki tum urun isimlerini gozden gecirip
        // istenen icerige sahip bir urun varsa flag'i degisdtirelim

        boolean arananUrunVarMi = false;

        for (String each : urunIsimleriList
             ) {
            if (each.contains("Men Slim Fit")){
                arananUrunVarMi = true;
            }
        }

        Assert.assertTrue(arananUrunVarMi);

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fashionElementi = driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assert.assertTrue(fashionElementi.isDisplayed());

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        //    once ana sayfaya gecis yapalim
        driver.switchTo().defaultContent();

        WebElement hereElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereElementi.isDisplayed());


        //7- Sayfayi kapatin
        ReusableMethods.bekle(3);
    }
}
