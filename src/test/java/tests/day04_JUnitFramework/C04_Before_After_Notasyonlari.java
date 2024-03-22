package tests.day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Before_After_Notasyonlari {

    /*
        EGER
        her test method'undan once MUTLAKA CALISMASINI istedigimiz bir method varsa
        @Before notasyonu ile isaretlenebilir

        Ayni sekilde
        her test method'undan sonra MUTLAKA CALISMASINI istedigimiz bir method varsa
        @After notasyonu ile isaretlenebilir

     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("setup method'u calisti");
    }

    @After
    public void teardown(){
        System.out.println("teardown method'u calisti");
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void youtubeTesti(){
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");
    }

    @Test
    public void testOtomasyonuTesti(){
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");
    }

    @Test
    public void wisequarterTesti(){
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");
    }
}
