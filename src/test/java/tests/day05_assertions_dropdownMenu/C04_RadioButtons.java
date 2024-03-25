package tests.day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButtons {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	      https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void yazidanSecimTesti(){

        driver.get("https://testotomasyonu.com/form");

        WebElement kadinYaziElementi = driver.findElement(By.xpath("//*[@for ='inlineRadio1']"));
        WebElement erkekYaziElementi = driver.findElement(By.xpath("//*[@for ='inlineRadio2']"));
        WebElement digerYaziElementi = driver.findElement(By.xpath("//*[@for ='inlineRadio3']"));

        erkekYaziElementi.click();

        WebElement kadinCheckbox = driver.findElement(By.xpath("//*[@id ='inlineRadio1']"));
        WebElement erkekCheckbox = driver.findElement(By.xpath("//*[@id ='inlineRadio2']"));
        WebElement digerCheckbox = driver.findElement(By.xpath("//*[@id ='inlineRadio3']"));

        // erkek'in secili oldugunu test edelim
        Assert.assertTrue(erkekCheckbox.isSelected());

        // kadin ve diger'in secili olmadigini test edelim
        Assert.assertFalse(kadinCheckbox.isSelected());
        Assert.assertFalse(digerCheckbox.isSelected());

    }

    @Test
    public void checkboxSecimTesti(){

        driver.get("https://testotomasyonu.com/form");

        WebElement kadinCheckbox = driver.findElement(By.xpath("//*[@id ='inlineRadio1']"));
        WebElement erkekCheckbox = driver.findElement(By.xpath("//*[@id ='inlineRadio2']"));
        WebElement digerCheckbox = driver.findElement(By.xpath("//*[@id ='inlineRadio3']"));

        erkekCheckbox.click();

        // erkek'in secili oldugunu test edelim
        Assert.assertTrue(erkekCheckbox.isSelected());

        // kadin ve diger'in secili olmadigini test edelim
        Assert.assertFalse(kadinCheckbox.isSelected());
        Assert.assertFalse(digerCheckbox.isSelected());
    }
}
