package tests.day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_CheckBox {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    //	a. Verilen web sayfasına gidin.
    //	     https://testotomasyonu.com/form
    //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
    //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkBoxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        // secim checkbox'dan ve yazidan yapilabiliyor
        // ikisini de test etmek icin
        // carpintiyi yazidan, sirt agrisini checkbox elementinden secelim

        WebElement carpintiCheckBox = driver.findElement(By.xpath("//*[@id='gridCheck4']"));
        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));

        WebElement sirtAgrisiCheckBox = driver.findElement(By.xpath("//*[@id='gridCheck5']"));
        WebElement sirtAgrisiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck5']"));

        carpintiYaziElementi.click();
        sirtAgrisiCheckBox.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(carpintiCheckBox.isSelected());
        Assert.assertTrue(sirtAgrisiCheckBox.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerCheckBox= driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox= driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerCheckBox.isSelected());
        Assert.assertFalse(epilepsiCheckBox.isSelected());
        ReusableMethods.bekle(3);
    }
}
