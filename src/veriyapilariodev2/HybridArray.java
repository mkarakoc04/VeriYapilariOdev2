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
        BagliListe eklenecekYer = elemaniBul(indis);
        //System.out.println("eklenecekYer = " + eklenecekYer.veri+" "+eklenecekYer.sonraki);
        if (eklenecekYer == null) {
            System.out.println("Verilen indis hatalı");
            return;
        }
        BagliListe yeniEleman = new BagliListe(yeniVeri);
        //System.out.println("yeniEleman = " + yeniEleman.veri);
        yeniEleman.sonraki = eklenecekYer;
        yeniEleman.onceki = eklenecekYer.onceki;
        eklenecekYer.onceki.sonraki = yeniEleman;
        eklenecekYer.onceki = yeniEleman;

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
        BagliListe silinecek = elemaniBul(indis);
        if (silinecek != null) {
            if (silinecek.sonraki != null) {
                silinecek.sonraki.onceki = silinecek.onceki;
            }
            if (silinecek.onceki != null) {
                silinecek.onceki.sonraki = silinecek.sonraki;
            }
        } else {
            System.out.println("Geçerli bir indis girin");
        }

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
        try {
            for (int i = 0; i < indis; i++) {
                eleman = eleman.sonraki;
            }
        } catch (Exception ex) {
            return null;
        }

        return eleman;
    }

    public void temizle() {
        ilkEleman = null;
    }

    public int boyutuGetir() {
         if (ilkEleman==null) {
          
            return 0;
        }
        int boyut = 1;
        BagliListe gec = ilkEleman;
        while (gec.sonraki != null) {
            gec = gec.sonraki;
            boyut++;
        }
        return boyut;
    }

    public void ekranaYaz() {
        if (ilkEleman==null) {
            System.out.println("Listede eleman yok");
            return;
        }
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
        String veriler = "";
        BagliListe gec = ilkEleman;
        veriler += String.valueOf(gec.veri);
        while (gec.sonraki != null) {
            gec = gec.sonraki;
            veriler += ", " + String.valueOf(gec.veri);
        }
        System.out.println(mesaj + "\nVeriler: " + veriler);
    }
}
