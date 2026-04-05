package domain;

import java.io.Serializable;


public class Nocenje implements Serializable{
    private long idNocenje;
    private double cena;
    private String opis;

    public Nocenje() {
    }

    public Nocenje(long idNocenje, double cena, String opis) {
        this.idNocenje = idNocenje;
        this.cena = cena;
        this.opis = opis;
    }

    public long getIdNocenje() {
        return idNocenje;
    }

    public void setIdNocenje(long idNocenje) {
        this.idNocenje = idNocenje;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
}
