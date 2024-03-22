package tests.day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C08_GoogleAssertion {


    @Test
    public void googleTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Accept all']"))
                .click();
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertTrue("Title Google icermiyor", actualTitle.contains(expectedTitleIcerik));

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@aria-label = 'Search']"))
                .sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi = driver.findElement(By.id("result-stats"));

        System.out.println(sonucYaziElementi.getText());
        //About 176.000.000 results (0,36 seconds)

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] sonucYaziArr = sonucYaziElementi.getText().split(" ");

        String sonucSayisiStr = sonucYaziArr[1]; // 149.000.000

        int actualSonucSayisiInt = Integer.parseInt(sonucSayisiStr.replaceAll("\\D",""));
        int expectedMinSonucSayisi = 10000000;

        Assert.assertTrue("sonuc sayisi 10 milyondan az", actualSonucSayisiInt>expectedMinSonucSayisi);

        //8- Sayfayi kapatin

        ReusableMethods.bekle(2);
        driver.quit();
    }
}
