package tests.day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_BeforeAfterKullanimi {

    /*
        Gorevimiz her ne kadar basit olsa da
        @After notasyonuna sahip method'u ayri yapmak daha mantiklidir

        Assert method'lari assertion failed oldugunda
        exception firlatir ve test method'unda kod calismasini durdurur
        test method'unda kod calismasi dursa ile
        driver'in kapanmasi icin @After method'u devreye girer

     */
    WebDriver driver;
    @After
    public void teardown(){
        // sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void nutellaTesti(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size()>0);
        System.out.println("Assertion failed olursa bu satir calismaz");

    }
}
