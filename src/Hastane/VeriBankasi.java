package Hastane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VeriBankasi extends Hasta {
    String gecIsim;
    String gecSoyisim;
    String gecHastaID;
    String yasadıgıHastalik;

    static List<VeriBankasi> gecmisiVar = new ArrayList<>();

    VeriBankasi() {
        hastanınGecmisi();
    }

    public VeriBankasi(String gecIsim, String gecSoyisim, String gecHastaID, String yasadıgıHastalik) {

        this.gecIsim = gecIsim;
        this.gecSoyisim = gecSoyisim;
        this.gecHastaID = gecHastaID;
        this.yasadıgıHastalik = yasadıgıHastalik;
        gecmisiVar.add(this);
    }


   static void hastanınGirisZamanı() {

        DateFormat dF = new SimpleDateFormat("dd.MM.YYYY  -  HH:mm:ss");
        Date date = new Date();
        System.out.println("Hastanın Giriş Tarihi ve Saati\t:\t\t" + dF.format(date));

    }

    void hastanınGecmisi() {

        VeriBankasi g1 = new VeriBankasi("veli", "deli", "123", "Kalbinden by-pass geçirmiş, şekeri var, tansiyonu yüksek");
        VeriBankasi g2 = new VeriBankasi("Ayşe", "Bulut", "345", "Beyin travması geçirmiş, psikiyatrik tedavi görüyor.");
        VeriBankasi g3 = new VeriBankasi("Defne", "Nergiz", "678", "Tansiyon ve şeker hastası");
        VeriBankasi g4= new VeriBankasi("Pala", "Remzi", "345", "Diabet rahatsızlıkları var ve Tansiyon ve şeker hastası");

    }

}
