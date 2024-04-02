package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme isleminde sorun olustu");
        }

    }

    public static List<String> stringListeDonustur(List<WebElement> webElementList){

        List<String> donusturulenList = new ArrayList<>();

        for (WebElement eachElement : webElementList
             ) {

            donusturulenList.add(eachElement.getText());
        }


        return donusturulenList;
    }

    public static void switchWindow(WebDriver driver, String hedefUrl){

        // birden fazla window acik iken bu method calisacak

        // 1- acik olan tum window'larin WHD'lerini bir Set olarak kaydedelim

        Set<String> tumWHDSeti = driver.getWindowHandles();

        // 2- bir for-each loop ile, her bir WHD'ini kullanip
        //    o window'a gidelim, eger gittigimiz window'da Url hedefUrl'e esit ise
        //    loop'u bitirelim

        for (String eachWHD : tumWHDSeti
             ) {

            driver.switchTo().window(eachWHD);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }

        }

    }

    public static void tumSayfaScreenshot(WebDriver driver){

        // 1- takesScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- cekilen screenshot'i kaydedecegimiz dosyayi olusturalim


        String kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS.jpeg";

        // screenshot'in her calistiginda farkli isimde olmasi icin tarih damgasi ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarihDamgasi = ldt.format(dtf); // 240402123223

        kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS"+tarihDamgasi+".jpeg";

        File tumSayfaScreenshot = new File(kaydedilecekDosyaYolu);

        // 3- tss objesini kullanarak screenshot alip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
