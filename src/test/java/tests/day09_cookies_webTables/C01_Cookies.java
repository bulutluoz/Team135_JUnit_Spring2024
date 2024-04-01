package tests.day09_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin

        Set<Cookie> cookiesSeti = driver.manage().getCookies();
        int index = 1;

        for (Cookie eachCookie : cookiesSeti
             ) {
            System.out.println(index+". cookie  :    " + eachCookie);
            index++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int expectedMinCookieSayisi = 5;
        int actualCookieSayisi = cookiesSeti.size();
        Assert.assertTrue(actualCookieSayisi>expectedMinCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieDegeri = "USD";
        String actualCookieDegeri = driver.manage()
                                            .getCookieNamed("i18n-prefs")
                                            .getValue();

        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie eklenecekCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(eklenecekCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        cookiesSeti = driver.manage().getCookies();


        boolean cikolataliCookieVarMi = false;

        for (Cookie eachCookie : cookiesSeti
             ) {
            if (eachCookie.getValue().equals("cikolatali")){
                cikolataliCookieVarMi = true;
                break;
            }

        }

        Assert.assertTrue(cikolataliCookieVarMi);
        // 2.yontem olarak, cookie seti, ekledigimiz cookie'i iceriyor mu diye test edelim
        Assert.assertTrue(cookiesSeti.contains(eklenecekCookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");

        cookiesSeti = driver.manage().getCookies();

        boolean skinCookieVarMi = false;

        for (Cookie eachCookie : cookiesSeti
        ) {
            if (eachCookie.getName().equals("skin")){
                skinCookieVarMi = true;
                break;
            }

        }

        // skin cookie silinmisse, skinCookieVarMi degeri false olmali

        Assert.assertFalse(skinCookieVarMi);


        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookiesSeti = driver.manage().getCookies();

        Assert.assertEquals(cookiesSeti.size(),0);


        ReusableMethods.bekle(3);
    }
}
