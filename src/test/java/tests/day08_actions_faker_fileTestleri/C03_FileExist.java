package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //2. logo.png dosyasını indirelim
        driver.findElement(By.linkText("logo.png")).click();

        ReusableMethods.bekle(3);
        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Java ile bir dosyanin bilgisayarimizda oldugunu test etmek icin
        // o dosyanin dosya yoluna ihtiyac duyariz

        String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // masaustunde logo.png dosyasinin oldugunu test edelim

        dosyaYolu = "/Users/ahmetbulutluoz/Desktop/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
