package utilities;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme isleminde sorun olustu");
        }

    }
}
