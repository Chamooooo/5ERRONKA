package pkg5erronka;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "salmenta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Salmenta {
    @XmlElement(name = "idTicket")
    private String idTicket;
    @XmlElement(name = "izena")
    private String izena;
    @XmlElement(name = "data")
    private String noizAteraDa;
    @XmlElement(name = "ordua")
    private String ordua;
    @XmlElement(name = "pisua")
    private String pisua;
    @XmlElement(name = "prezioaKiloko")
    private String prezioaKiloko;
    @XmlElement(name = "prezioTotala")
    private String prezioTotala;
    @XmlElement(name = "langileKodea")
    private String idLangilea;
    @XmlElement(name = "dendaIzena")
    private String idDenda;

    public Salmenta() {

        idLangilea = "autosalmenta";

    }

    public Salmenta(String strIdTicket, String strIzena, String strNoizAteraDa, String strOrdua, String strPisua, String strPrezioaKiloko, String strPrezioTotala, String strIdLangilea, String strIdDenda) {
       this.idTicket = strIdTicket;
       this.izena = strIzena;
       this.noizAteraDa = strNoizAteraDa;
       this.ordua = strOrdua;
       this.pisua = strPisua;
       this.prezioaKiloko = strPrezioaKiloko;
       this.prezioTotala = strPrezioTotala;
       this.idLangilea = strIdLangilea;
       this.idDenda = strIdDenda;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String strIdTicket) {
        this.idTicket = strIdTicket;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String strIzena) {
        this.izena = strIzena;
    }

    public String getNoizAteraDa() {
        return noizAteraDa;
    }

    public void setNoizAteraDa(String strNoizAteraDa) {
        this.noizAteraDa = strNoizAteraDa;
    }

    public String getOrdua(){

        return ordua;
    }

    public void setOrdua(String strOrdua){

        this.ordua = strOrdua;
    }

    public String getPisua() {
        return pisua;
    }

    public void setPisua(String strPisua) {
        this.pisua = strPisua;
    }

    public String getPrezioaKiloko() {
        return prezioaKiloko;
    }

    public void setPrezioaKiloko(String strPrezioaKiloko) {
        this.prezioaKiloko = strPrezioaKiloko;
    }

    public String getPrezioTotala() {
        return prezioTotala;
    }

    public void setPrezioTotala(String strPrezioTotala) {
        this.prezioTotala = strPrezioTotala;
    }

    public String getIdLangilea() {
        return idLangilea;
    }

    public void setIdLangilea(String strIdLangilea) {
        this.idLangilea = strIdLangilea;
    }

    public String getIdDenda() {
        return idDenda;
    }

    public void setIdDenda(String strIdDenda) {
        this.idDenda = strIdDenda;
    }
}
    