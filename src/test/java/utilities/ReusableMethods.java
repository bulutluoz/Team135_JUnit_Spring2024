package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
