package veriyapilariodev2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Mehdi
 */
public class TestIspat {

    public static void main(String[] args) {
        arrayListOlustur(100000, 1000);
        linkedListOlustur(100000, 1000);
        hybridArrayOlustur(100000, 1000);
    }

    //int boyut=100000;
    public static Random rnd = new Random();
    public static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static LinkedList<Integer> linkedList = new LinkedList<Integer>();
    public static HybridArray hybridArray = new HybridArray();

    public static void arrayListOlustur(int boyut, int aralik) {
        long baslangicsaati = System.currentTimeMillis();
        for (int i = 0; i < boyut; i++) {
            arrayList.add(rnd.nextInt(aralik));
        }
        System.out.println("Array List'e " + boyut + " tane eleman ekledik: " + (System.currentTimeMillis() - baslangicsaati) + " milisaniyede tamamlandı");
    }
    
     public static void linkedListOlustur(int boyut, int aralik) {
        long baslangicsaati = System.currentTimeMillis();
        for (int i = 0; i < boyut; i++) {
            linkedList.add(rnd.nextInt(aralik));
        }
        System.out.println("Linked List'e " + boyut + " tane eleman ekledik: " + (System.currentTimeMillis() - baslangicsaati) + " milisaniyede tamamlandı");
    }

     public static void hybridArrayOlustur(int boyut, int aralik) {
        long baslangicsaati = System.currentTimeMillis();
        for (int i = 0; i < boyut; i++) {
            hybridArray.sonaEkle(rnd.nextInt(aralik));
        }
        System.out.println("Bizim sınıfa " + boyut + " tane eleman ekledik: " + (System.currentTimeMillis() - baslangicsaati) + " milisaniyede tamamlandı");
    }
}
