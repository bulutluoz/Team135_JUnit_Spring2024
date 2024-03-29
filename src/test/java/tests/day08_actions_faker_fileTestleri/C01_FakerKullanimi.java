package tests.day08_actions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C01_FakerKullanimi extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//span[text()='Account']"))
                .click();
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement isimKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String password = faker.internet().password();
        String email = faker.internet().emailAddress();

        ReusableMethods.bekle(1);
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        ReusableMethods.bekle(15);
        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin

        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(email);

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(password);

        driver.findElement(By.id("submitlogin")).click();

        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));

        Assert.assertTrue(logoutButonu.isDisplayed());
        ReusableMethods.bekle(1);

        logoutButonu.click();


        ReusableMethods.bekle(5);
    }
}
