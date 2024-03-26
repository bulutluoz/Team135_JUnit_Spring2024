package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C03_IFrame extends TestBase_BeforeAfter {

    @Test
    public void iframeTest(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());

        System.out.println(anIframeYaziElementi.getText());

        //	- Text Box’a “Merhaba Dunya!” yazin.

        /*
            Testimizi calistirdigimizda
            driver webElement locator'i dogru oldugu halde
            webElement'i bulamiyorsa
            sebebi ulasmaya calistigimiz webElement'in
            bir iframe icinde bulunmasi olabilir

            Bu durumda webElementi locate etmeye calismadan once
            iFrame'e gecis yapmaliyiz

            iFrame kullanirken JS Alert'den farkli olarak suna dikkat etmeliyiz
            driver'i iFrame'e gecirdikten sonra
            anasayfada islem yapmak isterseniz
            yeniden driver'a anasayfaya dondurmeliyiz

         */

        WebElement iFrameElementi = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);
        ReusableMethods.bekle(1);


        WebElement textBox= driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya...");


        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
        //    ve  yazisini konsolda yazdirin.

        driver.switchTo().parentFrame();
        // ic ice birden fazla iFrame varsa, bir usttekine gecis yapar
        // driver.switchTo().defaultContent();
        // direk anasayfaya gecis yapar

        WebElement elementalSeleniumYaziElementi = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(elementalSeleniumYaziElementi.isEnabled());

        System.out.println(elementalSeleniumYaziElementi.getText());

        ReusableMethods.bekle(3);
    }
}
