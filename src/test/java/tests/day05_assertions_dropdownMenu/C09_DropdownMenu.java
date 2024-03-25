package tests.day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeAfter;

public class C09_DropdownMenu extends TestBase_BeforeAfter {

    @Test
    public void zeroTesti(){
        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login"))
                .sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password"))
                .sendKeys("password");
        // 5. Sign in tusuna basin,

        driver.findElement(By.xpath("//*[@value = 'Sign in']"))
                .click();
        // back tusuna basarak sayfaya donun
        driver.navigate().back();

        // 6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu"))
                .click();

        driver.findElement(By.id("pay_bills_link"))
                .click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']"))
                .click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDDM = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDDM);
        select.selectByValue("EUR");
        // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount"))
                .sendKeys("200");
        // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollarRadioButton = driver.findElement(By.id("pc_inDollars_true"));

        Assert.assertFalse(usDollarRadioButton.isSelected());

        // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false"))
                .click();
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"))
                .click();

        driver.findElement(By.id("purchase_cash"))
                .click();
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonucYaziElementi = driver.findElement(By.id("alert_content"));

        String expectedSonucYazisi = "Foreign currency cash was successfully purchased.";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }
}
