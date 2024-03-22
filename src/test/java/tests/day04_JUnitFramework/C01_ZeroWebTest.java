package tests.day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ZeroWebTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanina  “username” yazdirin
        WebElement usernameKutusu = driver.findElement(By.id("user_login"));
        usernameKutusu.sendKeys("username");
        //4. Password alanina “password” yazdirin
        driver.findElement(By.id("user_password"))
               .sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']"))
                .click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']"))
                .click();

        driver.findElement(By.id("pay_bills_link"))
                .click();

        //8. Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount"))
                .sendKeys("200");
        //9. Tarih kismina “2024-03-22” yazdirin
        driver.findElement(By.id("sp_date"))
                .sendKeys("2024-03-22");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees"))
                .click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement paymentSuccesElementi =
                driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (paymentSuccesElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");


        driver.quit();

    }
}
