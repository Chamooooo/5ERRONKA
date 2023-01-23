package pkg5erronka;

import java.time.LocalDate;

public class SALMENTAK {
    protected static String ID_TICKET;
    private String IZENA;
    private LocalDate NOIZ_ATERA_DA;
    private int KOPURUA;
    private double PISUA;
    private double PREZIOA_KILOKO;
    private double PREZIO_TOTALA;
    private String ID_LANGILEA;
    private String ID_DENDA;

    public SALMENTAK() {

        ID_LANGILEA = "autosalmenta";

    }

    public SALMENTAK(String ID_TICKET, String IZENA, LocalDate NOIZ_ATERA_DA, int KOPURUA, int PISUA, double PREZIOA_KILOKO, double PREZIO_TOTALA, String ID_LANGILEA, String ID_DENDA) {
        this.ID_TICKET = ID_TICKET;
        this.IZENA = IZENA;
        this.NOIZ_ATERA_DA = NOIZ_ATERA_DA;
        this.KOPURUA = KOPURUA;
        this.PISUA = PISUA;
        this.PREZIOA_KILOKO = PREZIOA_KILOKO;
        this.PREZIO_TOTALA = PREZIO_TOTALA;
        this.ID_LANGILEA = ID_LANGILEA;
        this.ID_DENDA = ID_DENDA;
    }

    public String getID_TICKET() {
        return ID_TICKET;
    }

    public void setID_TICKET(String ID_TICKET) {
        this.ID_TICKET = ID_TICKET;
    }

    public String getIZENA() {
        return IZENA;
    }

    public void setIZENA(String IZENA) {
        this.IZENA = IZENA;
    }

    public LocalDate getNOIZ_ATERA_DA() {
        return NOIZ_ATERA_DA;
    }

    public void setNOIZ_ATERA_DA(LocalDate NOIZ_ATERA_DA) {
        this.NOIZ_ATERA_DA = NOIZ_ATERA_DA;
    }

    public int getKOPURUA() {
        return KOPURUA;
    }

    public void setKOPURUA(int KOPURUA) {
        this.KOPURUA = KOPURUA;
    }

    public double getPISUA() {
        return PISUA;
    }

    public void setPISUA(int PISUA) {
        this.PISUA = PISUA;
    }

    public double getPREZIOA_KILOKO() {
        return PREZIOA_KILOKO;
    }

    public void setPREZIOA_KILOKO(double PREZIOA_KILOKO) {
        this.PREZIOA_KILOKO = PREZIOA_KILOKO;
    }

    public double getPREZIO_TOTALA() {
        return PREZIO_TOTALA;
    }

    public String getID_LANGILEA() {
        return ID_LANGILEA;
    }

    public void setID_LANGILEA(String ID_LANGILEA) {
        this.ID_LANGILEA = ID_LANGILEA;
    }

    public String getID_DENDA() {
        return ID_DENDA;
    }

    public void setID_DENDA(String ID_DENDA) {
        this.ID_DENDA = ID_DENDA;
    }
}
    