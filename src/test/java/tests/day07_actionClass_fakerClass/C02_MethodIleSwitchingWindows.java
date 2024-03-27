package tests.day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_MethodIleSwitchingWindows extends TestBase_BeforeAfter {

    @Test
    public void windowtesti(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.

        driver.get("https://testotomasyonu.com/addremove/");

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.linkText("Electronics Products"))
                .click();

        //● Electronics sayfasinin acildigini test edin

        // once yeni window'a gecis yapalim
        ReusableMethods.switchWindow(driver,"https://testotomasyonu.com/category/7/products");

        String expectedTitleIcerik = "Electronics";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        ReusableMethods.bekle(2);
    }
}
