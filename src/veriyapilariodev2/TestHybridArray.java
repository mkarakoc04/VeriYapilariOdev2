package veriyapilariodev2;

/**
 *
 * @author Mehdi
 */
public class TestHybridArray {

    public static void main(String[] args) {
        HybridArray liste = new HybridArray();
        liste.basaEkle(6);
        liste.ekranaYaz("Başa ekleme yaptık");

        liste.basaEkle(16);
        liste.ekranaYaz("Başa ekleme yaptık");

        liste.sonaEkle(-45);
        liste.sonaEkle(102);
        liste.ekranaYaz("Sona iki kere ekleme yaptık");

        liste.arayaEkle(1, 11);
        liste.arayaEkle(3, 0);
        liste.ekranaYaz("Araya iki kere ekleme yaptık");
    }

}
