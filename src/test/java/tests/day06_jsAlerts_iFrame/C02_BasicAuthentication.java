package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_BasicAuthentication extends TestBase_BeforeAfter {

    @Test
    public void basicAuthenticationTesti(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");


        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String expectedGirisyazi = "Congratulations! You are logged in as: membername";
        String actualGirisYazisi = driver.findElement(By.tagName("i"))
                                         .getText();

        Assert.assertEquals(expectedGirisyazi,actualGirisYazisi);


    }

}
