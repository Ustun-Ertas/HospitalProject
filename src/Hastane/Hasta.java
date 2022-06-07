package Hastane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static Hastane.VeriBankasi.gecmisiVar;


public class Hasta {

    static Scanner sc = new Scanner(System.in);
    LocalDateTime dF = LocalDateTime.now();//Tarih oluşturmak için
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");//Tarih oluşturmak için
    Date date = new Date();//Tarih oluşturmak için
    static LocalDateTime randevuTarihi;//Tarih oluşturmak için

    private String hsIsim;
    private String hsSoyisim;
    String saglikSorunu;
    private int hastaID;

    static List<String> yapılanIslemler = new ArrayList<>();
    static List<Hasta> hastalar = new ArrayList<>();//Scan ile girilen isimleri hasta listesine eklemek için


    void hastaBilgisiOlustur() {

        System.out.print("Lütfen Hasta İsmini Giriniz\t\t: ");
        this.hsIsim = sc.next();
        System.out.print("Lütfen Hasta Soyismini Giriniz\t: ");
        this.hsSoyisim = sc.next();
        System.out.println("==================================================================");
        System.out.println("Sayın :\t" + hsIsim.toUpperCase() + "\t" + hsSoyisim.toUpperCase());
        System.out.print("Lütfen Sağlık Sorununu Giriniz.\nAlerji için\t\t\t\t\t1\nBaş Ağrısı için\t\t\t\t2\nDiabet için\t\t\t\t\t3\nSoğuk Algınlığı için\t\t4\nMigren için\t\t\t\t\t5\nKalp Hastalıkları için\t\t6\nÇıkış için\t\t\t\t\t7 ");
        this.saglikSorunu = sc.next();
        System.out.println();

        if (Integer.valueOf(saglikSorunu) < 1 || Integer.valueOf(saglikSorunu) > 7) {
            System.out.println("Hatalı giriş yaptınız. Lütfen tekrar giriniz.");
            hastaBilgisiOlustur();
        } else {
            hastalar.add(this);
            doktorBul(saglikSorunu);
        }
    }

    private void doktorBul(String saglikSorunu) {
        System.out.println("==================================================================");
        System.out.println("Sizi uzman doktorumuza yönlendiriyoruz.");
        Doktor dr = new Doktor();
        Durum dur = new Durum();

        VeriBankasi v = new VeriBankasi();
        v.hastanınGecmisi();//Hastanın geçmişinin diğer classlarda çalıştırdık. Bunu çalıştırmazsak hastanın geçmiş verileri gelmez.

        if (saglikSorunu.equals("6")) {//Kalp Hastaları için öncelik verildi.

            System.out.println("!!!Kalp Hastalıklarına Öncelik Tanınmaktadır!!!");
            System.out.println("Kalp hastalıkları için Uzman Dr.\t:\t" +
                    dr.doktorlar.get(5).drIsim + "\t" + dr.doktorlar.get(5).drSoyisim + ",\tBranşı : " + dr.doktorlar.get(5).unvan);
            System.out.println("==================================================================");
            gecmisBilgileriİstiyorMusun();

        } else {
            switch (saglikSorunu) {
                case "1":
                    System.out.println("Alerji hastalıkları için Uzman Dr.\t:\t" +
                            dr.doktorlar.get(0).drIsim + "\t" + dr.doktorlar.get(0).drSoyisim + ",\tBranşı : " + dr.doktorlar.get(0).unvan);
                    gecmisBilgileriİstiyorMusun();
                    hastaYonlendir();
                    break;
                case "2":
                    System.out.println("Baş ağrısı hastalıkları için Uzman Dr.\t:\t" +
                            dr.doktorlar.get(1).drIsim + "\t" + dr.doktorlar.get(1).drSoyisim + ",\tBranşı : " + dr.doktorlar.get(1).unvan);
                    gecmisBilgileriİstiyorMusun();
                    hastaYonlendir();
                    break;
                case "3":
                    System.out.println("Diabet hastalıkları için Uzman Dr.\t:\t" +
                            dr.doktorlar.get(2).drIsim + "\t" + dr.doktorlar.get(2).drSoyisim + ",\tBranşı : " + dr.doktorlar.get(2).unvan);
                    gecmisBilgileriİstiyorMusun();
                    hastaYonlendir();
                    break;
                case "4":
                    System.out.println("Soğuk algınlığı  hastalıkları için Uzman Dr.\t:\t" +
                            dr.doktorlar.get(3).drIsim + "\t" + dr.doktorlar.get(3).drSoyisim + ",\tBranşı : " + dr.doktorlar.get(3).unvan);
                    gecmisBilgileriİstiyorMusun();
                    hastaYonlendir();
                    break;
                case "5":
                    System.out.println("Migren hastalıkları için Uzman Dr.\t:\t" +
                            dr.doktorlar.get(4).drIsim + "\t" + dr.doktorlar.get(4).drSoyisim + ",\tBranşı : " + dr.doktorlar.get(4).unvan);
                    gecmisBilgileriİstiyorMusun();
                    hastaYonlendir();
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen Tekrar deneyiniz.");
                    doktorBul(saglikSorunu);
                    break;
            }
        }

        sc.nextInt();
    }

    void hastaYonlendir() {
        Random rnd = new Random();//Sıra vermek için random sayı üretildi
        int rand = rnd.nextInt(100);

        System.out.println("==================================================================");
        System.out.println("Hastayı yönlendirmek istediğiniz birimi seçiniz.");
        System.out.println("Kan Tahlilleri\t\t\t1\nİdrar Tahlilleri\t\t2\nRadyoloji\t\t\t\t3\nTomografi\t\t\t\t4\nİleri Tarihe Randevu\t5\nÇıkış\t\t\t\t\t6\n");

        try {
            int yonBirim = sc.nextInt();
            switch (yonBirim) {
                case 1:
                    yapılanIslemler.add("Kan Tahlili");
                    System.out.println("Kan Tahilili için Laboratuvar Sıranız :\t" + rand);
                    baskaIslemSor();
                    break;
                case 2:
                    yapılanIslemler.add("İdrar Tahlili");
                    System.out.println("İdrar Tahlili için Laboratuvar Sıranız :\t" + rand);
                    baskaIslemSor();
                    break;
                case 3:
                    yapılanIslemler.add("Radyoloji");
                    System.out.println("Radyoloji için Laboratuvar Sıranız :\t" + rand);
                    baskaIslemSor();
                    break;
                case 4:
                    yapılanIslemler.add("Tomografi");
                    System.out.println("Tomografi için Laboratuvar Sıranız :\t" + rand);
                    baskaIslemSor();
                    break;
                case 5:
                    yapılanIslemler.add("İleri Bir Tarihe Randevu Verildi.");
                    randevuTarihi = dF.plusDays(3).plusHours(10);
                    System.out.println("Size verilen randevu tarihi :\t" + randevuTarihi);
                    System.out.println("Lütfen randevunuzdan 30 dk önce hastanemizde olunuz");
                    baskaIslemSor();
                    break;
                case 6:
                    System.out.println("Çıkış işlemleriniz yapılıyor.");
                    cıkıs();
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar giriş yapınız.");
                    hastaYonlendir();

            }
        } catch (InputMismatchException e) {
            sc.nextDouble();
            System.out.println("Lütfen Rakam Girişi Yaparak Yönledirilecek Birimi Seçiniz.");
            System.out.println("==================================================================");
            hastaYonlendir();

        }
        sc.next();

    }

    void tahlilGecmişBul() {

        System.out.println("==================================================================");

        for (int i = 0; i < gecmisiVar.size(); i++) {
            if (hsSoyisim.equalsIgnoreCase(gecmisiVar.get(i).gecSoyisim) &&
                    hsIsim.equalsIgnoreCase(gecmisiVar.get(i).gecIsim)) {

                System.out.println("Hasta Adı:\t" + gecmisiVar.get(i).gecIsim + "\tHastanın Soyadı :\t"
                        + gecmisiVar.get(i).gecSoyisim + "\tGeçmiş Hastalıkları :\t" + gecmisiVar.get(i).yasadıgıHastalik);
                break;
            } else {
                System.out.println("Hastanemizde " + hsIsim + "\t" + hsSoyisim + " 'ye ait geçmiş bilgisi yer almamaktadır.\nHastayı yönlendirmek istediğiniz birimi seçiniz.");
                break;
            }
        }
        hastaYonlendir();
    }

    void gecmisBilgileriİstiyorMusun() {

        System.out.println("Acil müdahale için geçmiş hasta bilgilerinin kontrolünü istiyor musunuz?");
        System.out.print(" 'E' Hayır için 'H' giriniz : ");
        char secim = sc.next().toUpperCase().charAt(0);
        if (secim == 'E') {
            tahlilGecmişBul();
        } else if (secim == 'H') {
            hastaYonlendir();
        } else {
            System.out.println("Hatalı giriş yaptınız tekrar deneyiniz : ");
            doktorBul(saglikSorunu);
        }
        sc.nextInt();
    }

    private void baskaIslemSor() {
        System.out.println("Başka bir işlem yapmak istiyor musunuz?");
        System.out.print("Devam etmek için 1,\t çıkış yapmak için 2 ye basınız. ");
        int secim = sc.nextInt();
        if (secim == 1) {
            hastaYonlendir();
        } else if (secim == 2) {
            cıkıs();
        } else {
            System.out.println("Hatalı giriş yaptınız tekrar deneyiniz : ");
            baskaIslemSor();
        }
        sc.nextDouble();
    }

    private void cıkıs() {

        System.out.println("==================================================================");
        System.out.println("====================   JAVA\tHASTAHANESİ  =========================");
        System.out.println("Tarih ve Saat :\t\t\t\t\t\t" + dateFormat.format(date));
        System.out.println();
        System.out.println("Sayın \t\t\t\t:" + hsIsim.toUpperCase() + "\t" + hsSoyisim.toUpperCase());
        System.out.println("Yaptığınız işlemler : " + yapılanIslemler);
        System.out.println();
        if (yapılanIslemler.contains("İleri Bir Tarihe Randevu Verildi.")) {
            System.out.println("Size verilen randevu tarihi :\t" + randevuTarihi);
        }

        System.out.println();
        System.out.println("==================================================================");
        System.out.println("\t\t\t\tSağlıklı Günler Dileriz. :-) ");
        System.out.println("==================================================================");

        System.exit(0);

    }

}
