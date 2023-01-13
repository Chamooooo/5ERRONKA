package ariketi.erronki5;

public class TICKETI {

    private int idTicket;
    private String izena;
    private String idLangilea;
    private int kopurua;
    private double prezioaKiloko;
    private double prezioTotala;

    public TICKETI(){

        idLangilea = "autosalmenta";

    }

    public TICKETI(String strIzena, int iKopurua, double dbPrezioaKiloko, double dbPrezioTotala){

        izena = strIzena;
        kopurua = iKopurua;
        prezioTotala = dbPrezioTotala;
        prezioaKiloko = dbPrezioaKiloko;

    }

    public int getIdTicket() {
        return idTicket;
    }

    public String getIzena() {
        return izena;
    }

    public String getIdLangilea() {
        return idLangilea;
    }

    public int getKopurua() {
        return kopurua;
    }

    public double getPrezioaKiloko() {
        return prezioaKiloko;
    }

    public double getPrezioTotala() {
        return prezioTotala;
    }
    
    
    
}
