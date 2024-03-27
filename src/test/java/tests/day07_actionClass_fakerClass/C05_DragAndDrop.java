package tests.day07_actionClass_fakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C05_DragAndDrop extends TestBase_BeforeAfter {

    @Test
    public void dragAndDropTesti(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement acceptableKutusu = driver.findElement(By.id("draggable2"));
        WebElement dropHereElementi = driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.dragAndDrop(acceptableKutusu,dropHereElementi).perform();
        ReusableMethods.bekle(2);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(droppedYaziElementi.isDisplayed());

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(1);
        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereElementi = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableElementi,dropHereElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        WebElement dropHereYaziElementi = driver.findElement(By.xpath("//*[text()='Drop Here']"));

        Assert.assertTrue(dropHereYaziElementi.isDisplayed());

        ReusableMethods.bekle(2);
    }
}
