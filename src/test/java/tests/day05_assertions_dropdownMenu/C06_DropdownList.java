package tests.day05_assertions_dropdownMenu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C06_DropdownList extends TestBase_BeforeAfter {


    @Test
    public void dropdownTesti(){

        /*
            Dropdown menu ozel bir acilir menudur
            select tag'i ile olusturulur
            icindeki secenekler de option tag'i ile olusturulur
            ve genellikle option tag'i icinde value attribute'u
            ve webElement'in text'i olur

            Selenium dropdown menu icin ozel
            Select class'i olusturmustur
            biz de Select class'indan method'lar kullanarak
            dropdown uzerinde istedigimiz secimleri yapabilir
            ve istedigimiz bilgileri alabiliriz
         */

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // dogum tarihi gun, acilir menusunden 5'i secin

        WebElement gunAcilirMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        gunAcilirMenu.sendKeys("5");
        ReusableMethods.bekle(3);

        // ve 5'in secili oldugunu test edin

        System.out.println(gunAcilirMenu.getText());


    }
}
