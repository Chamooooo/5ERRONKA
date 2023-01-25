package pkg5erronka;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "salmenta")
public class Salmenta {
    private String idTicket;
    private String izena;
    private String noizAteraDa;
    private String pisua;
    private String prezioaKiloko;
    private String prezioTotala;
    private String idLangilea;
    private String idDenda;

    public Salmenta() {

        idLangilea = "autosalmenta";

    }

    public Salmenta(String strIdTicket, String strIzena, String ldNoizAteraDa, String strPisua, String strPrezioaKiloko, String strPrezioTotala, String strIdLangilea, String strIdDenda) {
       this.idTicket = strIdTicket;
       this.izena = strIzena;
       this.noizAteraDa = ldNoizAteraDa;
       this.pisua = strPisua;
       this.prezioaKiloko = strPrezioaKiloko;
       this.prezioTotala = strPrezioTotala;
       this.idLangilea = strIdLangilea;
       this.idDenda = strIdDenda;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getNoizAteraDa() {
        return noizAteraDa;
    }

    public void setNoizAteraDa(String noizAteraDa) {
        this.noizAteraDa = noizAteraDa;
    }

    public String getPisua() {
        return pisua;
    }

    public void setPisua(String pisua) {
        this.pisua = pisua;
    }

    public String getPrezioaKiloko() {
        return prezioaKiloko;
    }

    public void setPrezioaKiloko(String prezioaKiloko) {
        this.prezioaKiloko = prezioaKiloko;
    }

    public String getPrezioTotala() {
        return prezioTotala;
    }

    public void setPrezioTotala(String prezioTotala) {
        this.prezioTotala = prezioTotala;
    }

    public String getIdLangilea() {
        return idLangilea;
    }

    public void setIdLangilea(String idLangilea) {
        this.idLangilea = idLangilea;
    }

    public String getIdDenda() {
        return idDenda;
    }

    public void setIdDenda(String idDenda) {
        this.idDenda = idDenda;
    }
}
    