package domain;

import java.io.Serializable;
import java.time.LocalDate;


public class StavkaFakture implements Serializable{
    private int rb;
    private boolean dorucakUkljucen;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private int brojDana;
    private double cena;
    private double iznos;
    private double dodatniTroskovi;
    private Nocenje nocenje;
    private FakturaOdmora fakturaOdmora;

    public StavkaFakture() {
    }

    public StavkaFakture(int rb, boolean dorucakUkljucen, LocalDate datumOd, LocalDate datumDo, int brojDana, double cena, double iznos, double dodatniTroskovi, Nocenje nocenje, FakturaOdmora fakturaOdmora) {
        this.rb = rb;
        this.dorucakUkljucen = dorucakUkljucen;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.brojDana = brojDana;
        this.cena = cena;
        this.iznos = iznos;
        this.dodatniTroskovi = dodatniTroskovi;
        this.nocenje = nocenje;
        this.fakturaOdmora = fakturaOdmora;
    }
    
    

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public boolean isDorucakUkljucen() {
        return dorucakUkljucen;
    }

    public void setDorucakUkljucen(boolean dorucakUkljucen) {
        this.dorucakUkljucen = dorucakUkljucen;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public double getDodatniTroskovi() {
        return dodatniTroskovi;
    }

    public void setDodatniTroskovi(double dodatniTroskovi) {
        this.dodatniTroskovi = dodatniTroskovi;
    }

    public Nocenje getNocenje() {
        return nocenje;
    }

    public void setNocenje(Nocenje nocenje) {
        this.nocenje = nocenje;
    }

    public FakturaOdmora getFakturaOdmora() {
        return fakturaOdmora;
    }

    public void setFakturaOdmora(FakturaOdmora fakturaOdmora) {
        this.fakturaOdmora = fakturaOdmora;
    }
    
    
}
