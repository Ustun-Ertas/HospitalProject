package p1_travelCal;

public class Arrays {


    /*
        Bir siniftaki ogrencilerin boylari tamsayi olarak sirasiz veriliyor,
        ayrica bu sinifin ogrencisi olan Ali'nin boyu veriliyor. Beden egitimi dersinde
        buyukten kucuge dogru ogrenciler siralandiginda Ali kacinci sirada olur(en uzun
        ogrenci 1. siradadir, Ali'nin boyu verilen dizide de yer almaktadir

         */

    //Once Ali'den kac kisi uzun oldugunu bulmak lazim
    //Sonra Ali ile ayni boyda kac kisi var onu bulmam lazim
    //Ve son olarakta Ali'nin muhtemel siralari

    public static void main(String[] args) {

        int []boylar = new int []{190,170,185,170,177,178,198,170,187,182 };//Burda boylar diye bir dizi olusturdum
        int alidenKacKisiUzun= 0;//Aliden kac kisi uzun oldugunu hesapladim baslangicta sifir kisi
        int ayniBoydanOlanlar=0;//bunuda sifira esitledim
        int alininBoyu=170;//Alinin boyuna 175 verdim kafadan

        //for dongusu aciyorum

        for (int i = 0; i <boylar.length ; i++) {

            if (boylar[i]==alininBoyu) ayniBoydanOlanlar++;//Alinin boyu ile esit olanalari sayacak

            else if (boylar[i]>alininBoyu) alidenKacKisiUzun++;//Aliden uzun olanlari sayacak

        }
        int altSira=alidenKacKisiUzun+1;//Aliden uzun bir kise ise Ali 2.sirada olur (+1)
        int ustSira=alidenKacKisiUzun+ayniBoydanOlanlar;//en geride durma durumu

        System.out.println("Ali " + altSira+" ile "+ustSira+" arasinda bir yerdedir");



    }

}



