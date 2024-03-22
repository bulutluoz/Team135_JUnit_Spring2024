package tests.day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C05_Assertion {

    // asagidaki 3 testi ayri ayri test method'larinda calistirin
    // 1- Testotomasyonu anasayfaya gidin
    // testotomasyonu sayfasina gittiginizi test edin
    // 2- phone icin arama yapin
    // arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip
    //    urun isminde case sensitive olmadan phone gectigini test edin

    /*
        Gorev incelenecek olursa
        her test method'undan once setup yapip
        her test method'undan sonra driver'i kapatmak mantikli olmaz

        setup method'u 1.method'dan once calismali
        teardown ise method'lar calisip bittikten sonra,
        yani 3.method'dan sonra calismali

        EGER
        setup() class'in en basinda
        teardown() ise class'in en sonunda calissin istiyorsak
        @BeforeClass ve @AfterClass notasyonlarini kullaniriz
     */

    static WebDriver driver;
    List<WebElement> bulunanUrunElementleriList;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- Testotomasyonu anasayfaya gidin
        // testotomasyonu sayfasina gittiginizi test edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("Anasayfa testi FAILED");
    }

    @Test
    public void test02(){
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin
        // 3.gorevde ilk urune tiklama oldugundan
        // bu test icin bulunan urun listesi olusturup size'ini test edelim
        bulunanUrunElementleriList = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));

        if (bulunanUrunElementleriList.size()>0){
            System.out.println("Urun arama testi PASSED");
        }else System.out.println("Urun arama testi FAILED");

    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayip
        bulunanUrunElementleriList = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        bulunanUrunElementleriList.get(0).click();
        //    urun isminde case sensitive olmadan phone gectigini test edin

        String expectedUrunIsimIcerik = "phone";
        String actualIsimKucukHarf = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"))
                                            .getText()
                                            .toLowerCase();
        if (actualIsimKucukHarf.contains(expectedUrunIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");

    }
}
