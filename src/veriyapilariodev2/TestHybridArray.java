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
        
        System.out.println("4. eleman: "+liste.elemaniBul(3).veri);

        liste.ilkElemaniSil();
        liste.ekranaYaz("İlk elemanı sildik");

        liste.sonElemaniSil();
        liste.ekranaYaz("Son elemanı sildik");

        liste.elemanSil(2);
        liste.ekranaYaz("3. elemanı sildik");
        
        System.out.println("Boyut:" +liste.boyutuGetir());
        
           System.out.println("listeyi yok ettik");
        liste.temizle();
         liste.ekranaYaz();
         System.out.println("Boyut:" +liste.boyutuGetir());
       
        TestIspat test=new TestIspat();
        
        
    }

}
