package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.sql.Driver;
import java.time.Duration;

public class C06_ExplicitlyWait {

    @Test
    public void implicitWaitTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textboxElementi.isEnabled());

        //3. Enable butonuna tıklayın

        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();
        // ve textbox etkin oluncaya kadar bekleyin
        // etkin olma suresi implicitly wait suresi icinde oldugundan
        // extra islem yapmadan bu maddeyi gecebiliriz

        //4. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYazisi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledYazisi.isDisplayed());

        //5. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assert.assertTrue(textboxElementi.isEnabled());

        driver.quit();
    }


    @Test
    public void explicitWaitTesti(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textboxElementi.isEnabled());

        //3. Enable butonuna tıklayın

        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();

        //4. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        // WebElementin gorunur olmasini beklemek icin implicitlyWait suresi yetmedi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        // WebElement itsEnabledYazisi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        // wait.until(ExpectedConditions.visibilityOf(itsEnabledYazisi));
        /*
            Yukardaki 78. ve 79.satir birbirine bagimli
            elementi tanimlamadan bekletemiyoruz
            beklemeden elementi tanimlayamiyoruz

            bu kisir donguyu kirmak icin
            iki satiri birlestirebiliyoruz
         */

        WebElement itsEnabledYazisi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's enabled!\"]")));

        Assert.assertTrue(itsEnabledYazisi.isDisplayed());


        //5. Textbox’in etkin oldugunu(enabled) dogrulayın.

        // Eger explicitly Wait ile bekleyecegimiz element locate edilebiliyorsa


        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));

        Assert.assertTrue(textboxElementi.isEnabled());


        driver.quit();
    }
}
