package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_Actions extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        /*
            Bazi web sayfalari
            gorunmeyen webelementleri locate etmemize izin verir, bazilari izin vermez

            Eger gorunmeyen bir elementi locate etmemize izin veriyorsa
            asagiya inmek icin
            actions.scrollToElement(iframeElementi); kullanabiliriz,

            Eger izin vermiyorsa, locate edemedigimiz bir webelementi
            hedef olarak actions objesine veremeyiz
            bu durumda
            actions.sendKeys(Keys.PAGE_DOWN);
            actions.sendKeys(Keys.ARROW_DOWN);
            tuslari ile istenen bolgeye inebiliriz
            Ancak bilgisayardan bilgisayara cozunurluk degistigi icin
            bu test tum bilgisayarlarda calismayabilir
         */



        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframeElementi =driver.findElement(By.xpath("(//iframe)[1]"));

        //actions.scrollToElement(iframeElementi);


        driver.switchTo().frame(iframeElementi);


        //3- videoyu izlemek icin Play tusuna basin
        WebElement playTusu = driver.findElement(By.xpath("//button[@title='Play']"));
        playTusu.click();

        //4- videoyu calistirdiginizi test edin
        WebElement videoElementi = driver.findElement(By.xpath("//*[@*='video-stream html5-main-video']"));
        actions.moveToElement(videoElementi).perform();

        WebElement sesElementi = driver.findElement(By.xpath("//*[@*='ytp-volume-panel']"));
        Assert.assertTrue(sesElementi.isEnabled());

        ReusableMethods.bekle(5);
    }
}
