package Hastane;

public class Durum extends Hasta{

    private String aktuelDurum;
    private boolean aciliyet;

    public String getAktuelDurum() {
        return aktuelDurum;
    }

    public void setAktuelDurum(String aktuelDurum) {
        this.aktuelDurum = aktuelDurum;
    }

    public boolean isAciliyet() {

        return aciliyet;
    }

    public void setAciliyet(boolean aciliyet) {//Kalp hastalıkları acil olarak set edildi.

        this.aciliyet = aciliyet;
        if(super.saglikSorunu.equals("6")){
            aciliyet=true;
        }
    }
}
