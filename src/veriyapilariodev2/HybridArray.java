/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilariodev2;

/**
 *
 * @author Mehdi
 */
import java.util.LinkedList;

public class HybridArray {

    BagliListe ilkEleman;

    class BagliListe {

        int veri;
        BagliListe onceki;
        BagliListe sonraki;

        BagliListe(int d) {
            veri = d;
        }
    }

    public void basaEkle(int yeniVeri) {

        BagliListe yeniEleman = new BagliListe(yeniVeri);

        yeniEleman.sonraki = ilkEleman;
        yeniEleman.onceki = null;

        if (ilkEleman != null) {
            ilkEleman.onceki = yeniEleman;
        }

        ilkEleman = yeniEleman;
    }

    public void arayaEkle(int indis, int yeniVeri) {
        BagliListe eklenecekYer =elemaniBul(indis);
        //System.out.println("eklenecekYer = " + eklenecekYer.veri+" "+eklenecekYer.sonraki);
        if (eklenecekYer == null) {
            System.out.println("Verilen indis hatalı");
            return;
        }
        BagliListe yeniEleman = new BagliListe(yeniVeri);
        //System.out.println("yeniEleman = " + yeniEleman.veri);
        yeniEleman.sonraki = eklenecekYer;
        yeniEleman.onceki = eklenecekYer.onceki;
        eklenecekYer.onceki.sonraki=yeniEleman;
        eklenecekYer.onceki=yeniEleman;
        
//        if (yeniEleman.sonraki != null) {
//            yeniEleman.sonraki.onceki = yeniEleman;
//        }
    }

    void sonaEkle(int yeniVeri) {
        BagliListe yeniEleman = new BagliListe(yeniVeri);
        BagliListe sonEleman = ilkEleman;
        yeniEleman.sonraki = null;

        if (ilkEleman == null) {
            yeniEleman.onceki = null;
            ilkEleman = yeniEleman;
            return;
        }
        while (sonEleman.sonraki != null) {
            sonEleman = sonEleman.sonraki;
        }
        sonEleman.sonraki = yeniEleman;
        yeniEleman.onceki = sonEleman;
    }

    public void ilkElemaniSil() {
        BagliListe gec = ilkEleman;
        ilkEleman = gec.sonraki;
        ilkEleman.onceki = null;
    }

    public void sonElemaniSil() {
        BagliListe onceki = sonElemaniBul().onceki;
        onceki.sonraki = null;
    }

    public void elemanSil(int indis) {
        BagliListe gec = ilkEleman;
        for (int i = 0; i < indis; i++) {
            gec = gec.sonraki;
        }
        gec.onceki = gec.sonraki;
        gec.sonraki.onceki = gec.onceki;
    }

    public BagliListe sonElemaniBul() {

        BagliListe gec = ilkEleman;
        while (gec.sonraki != null) {
            gec = gec.sonraki;
        }
        return gec;
    }

    public int oku(int indis) {
        BagliListe eleman = ilkEleman;
        for (int i = 0; i < indis; i++) {
            eleman = ilkEleman.sonraki;
        }
        return eleman.veri;
    }

    public BagliListe elemaniBul(int indis) {
        BagliListe eleman = ilkEleman;
         
        //System.out.println("eleman = " + eleman.veri+" " + eleman.sonraki.veri+" " + eleman.sonraki.sonraki.veri);
        for (int i=0; i < indis; i++) {
            eleman = eleman.sonraki;
           // System.out.println("i:"+i);
        }
         //System.out.println("indis:"+indis);
         //System.out.println("eleman:"+eleman.veri);
        return eleman;
    }

    public void temizle() {
        ilkEleman.sonraki = null;
    }

    public int boyutuGetir() {
        int boyut = 1;
        BagliListe gec = ilkEleman;
        while (gec.sonraki != null) {
            gec = gec.sonraki;
            boyut++;
        }
        return boyut;
    }

    public void ekranaYaz() {
        String veriler = "";
        BagliListe gec = ilkEleman;
        veriler += String.valueOf(gec.veri);
        while (gec.sonraki != null) {
            gec = gec.sonraki;
            veriler += ", " + String.valueOf(gec.veri);
        }
        System.out.println("Veriler\n" + veriler);
    }
    
      public void ekranaYaz(String mesaj) {
        String veriler ="";
        BagliListe gec = ilkEleman;
        veriler += String.valueOf(gec.veri);
        while (gec.sonraki != null) {
            gec = gec.sonraki;
            veriler += ", " + String.valueOf(gec.veri);
        }
        System.out.println(mesaj+"\nVeriler: " + veriler);
    }
}
