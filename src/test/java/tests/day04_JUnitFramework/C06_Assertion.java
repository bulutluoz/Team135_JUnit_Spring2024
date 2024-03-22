package tests.day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
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

public class C06_Assertion {
    /*
        JUnit bir test method'unun PASSED veya FAILED olmasina
        kodlarin problemsiz olarak calisip calismamasina bakarak karar verir
        eger kodlari calistirirken hic bir sorunla karsilasmazsa
        (Process finished with exit code 0)
        testleri PASSED olarak isaretler
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

        String expectedUrlIcerik = "testotomasyonu111";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Anasayfa testi PASSED");
        }else {
            System.out.println("Anasayfa testi FAILED");
            throw new AssertionFailedError("Url istenen metni icermiyor");
        }
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

        if (bulunanUrunElementleriList.size()==0){
            System.out.println("Urun arama testi PASSED");
        }else {
            System.out.println("Urun arama testi FAILED");
            throw new AssertionFailedError("Bulunan urun listesi bos");
        }

    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayip
        bulunanUrunElementleriList = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        bulunanUrunElementleriList.get(0).click();
        //    urun isminde case sensitive olmadan phone gectigini test edin

        String expectedUrunIsimIcerik = "phonexx";
        String actualIsimKucukHarf = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"))
                .getText()
                .toLowerCase();
        if (actualIsimKucukHarf.contains(expectedUrunIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else {
            System.out.println("Urun isim testi FAILED");
            throw new AssertionFailedError("urun ismi phone icermiyor");
        }

    }
}
