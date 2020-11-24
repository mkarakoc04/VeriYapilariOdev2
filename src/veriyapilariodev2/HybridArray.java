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

    public void arayaEkle(BagliListe eklenecekYer, int yeniVeri) {

        if (eklenecekYer == null) {
            System.out.println("Verilen indis hatalı");
            return;
        }
        BagliListe yeniEleman = new BagliListe(yeniVeri);
        yeniEleman.sonraki = eklenecekYer.onceki;
        eklenecekYer.sonraki = yeniEleman;
        yeniEleman.onceki = eklenecekYer;
        if (yeniEleman.sonraki != null) {
            yeniEleman.sonraki.onceki = yeniEleman;
        }
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
}
