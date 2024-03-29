package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C05_FileUpload extends TestBase_BeforeAfter {

    @Test
    public void fileUploadTesti(){

        //https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Package icindeki deneme.txt dosyayi secelim.

        // bilgisayarimizda bulunan dosyalara webDriver ile ulasamayacagimiz icin
        // chooseFile butonuna yuklemek istedigimiz dosyanin
        // dosya yolunu yollamamiz yeterli olacaktir

        //   /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/team135_JUnit
        //   yukardaki bolum, herkeste degisen kisim
        //   /src/test/java/tests/day08_actions_faker_fileTestleri/deneme.txt
        //   herkeste ortak olan kisim

        String dinamikDosyaYolu = System.getProperty("user.dir") +
                                    "/src/test/java/tests/day08_actions_faker_fileTestleri/deneme.txt";

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedyaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";
        String actualYazi = fileUploadedyaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(5);
    }
}
