package tests.day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C08_DropdownMenuTesti extends TestBase_BeforeAfter {

    @Test
    public void dropdowntesti(){

        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDD = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun = new Select(gunDD);
        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDD = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDD);
        selectAy.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDD = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDD);
        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin
        System.out.println(
                "Gun : " + selectGun.getFirstSelectedOption().getText()+
                ", Ay :" + selectAy.getFirstSelectedOption().getText() +
                ", Yil : " + selectYil.getFirstSelectedOption().getText()
        );
        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayOptionElementleriList = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(ayOptionElementleriList));
        // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedOptionSayisi = 13;
        int actualOptionSayisi = ayOptionElementleriList.size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        ReusableMethods.bekle(3);


    }
}
