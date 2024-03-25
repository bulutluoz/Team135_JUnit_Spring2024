package tests.day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C07_DropdownList extends TestBase_BeforeAfter {

    @Test
    public void dropdownTest(){

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // dogum tarihi gun, acilir menusunden 5'i secin

        // dropdown menu ile calismak icin
        // 1- uzerinde calisacagimiz dropdown'i locate edip kaydedelim
        WebElement gunAcilirMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        // 2- Select class'indaki method'lari kullanabilmek icin bir obje olusturalim
        //    obje olustururken uzerinde calisacagimiz dropdown'i parametre olarak girelim
        Select select = new Select(gunAcilirMenu);

        // 3- select objesi ile istenen method'lar kullanilabilir
        select.selectByVisibleText("5");

        ReusableMethods.bekle(3);

        // ve 5'in secili oldugunu test edin

        String expectedSecilenDeger = "5";
        String actualSecilenDeger = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSecilenDeger,actualSecilenDeger);

        // menu'de toplam 32 secenek oldugnu test edin

        int expectedSecenekSayisi = 32;

        int actualSecenekSayisi = select.getOptions().size();

        Assert.assertEquals(expectedSecenekSayisi,actualSecenekSayisi);


    }
}
