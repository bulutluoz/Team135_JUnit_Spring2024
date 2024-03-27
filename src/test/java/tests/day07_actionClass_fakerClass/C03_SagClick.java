package tests.day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C03_SagClick extends TestBase_BeforeAfter {

    @Test
    public void sagClickTesti(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        WebElement dgiDroneElementi = driver.findElement(By.id("pic2_thumb"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.contextClick(dgiDroneElementi).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertyazi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertyazi,actualAlertYazi);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

    }
}
