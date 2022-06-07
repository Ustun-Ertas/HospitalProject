package Hastane;

import java.util.ArrayList;
import java.util.List;

public class Doktor {

    String drIsim;
    String drSoyisim;
    String unvan;

    static List<Doktor> doktorlar = new ArrayList<>();

    Doktor() {
        doktorBul();
    }

    public Doktor(String drIsim, String drSoyisim, String unvan) {

        this.drIsim = drIsim;
        this.drSoyisim = drSoyisim;
        this.unvan = unvan;
        doktorlar.add(this);
    }

    void doktorBul() {
        Doktor d1 = new Doktor("Nilson", "Avery", "Allergist");
        Doktor d2 = new Doktor("John", "Abel", "Nörolog");
        Doktor d3 = new Doktor("Robert", "Erik", "Genel Cerrah");
        Doktor d4 = new Doktor("Marry", "Jacob", "Çocuk Doktoru");
        Doktor d5 = new Doktor("Alan", "Pedro", "Dahiliye");
        Doktor d6 = new Doktor("Mahesh", "Tristen", "Kardiolog");
    }


}
