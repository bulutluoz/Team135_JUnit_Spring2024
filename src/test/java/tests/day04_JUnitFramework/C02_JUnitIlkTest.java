package tests.day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_JUnitIlkTest {

    /*
        JUNit'in bize sagladigi en buyuk avantajlardan biri @Test notasyonudur

        @Test sayesinde siradan method'lar bagimsiz olarak calisabilecek test method'larina donusur

        JUnit'de bir class'daki test method'larinin hangi sira ile calisacagi
        ONGORULEMEZ ve DUZENLENEMEZ
        (test01, test02,test03 yazarsak bu siraya uygun calistiriyor)

     */
    // asagidaki 3 websayfasina gidip, o sayfalara gittigimizi test edin
    // testler birlikte veya ayri ayri calistirilabilmelidir
    // youtube, testotomasyonu ve wisequarter

    @Test @Ignore
    public void youtubeTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");

        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");

        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void wisequarterTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");

        ReusableMethods.bekle(2);
        driver.quit();
    }

}
