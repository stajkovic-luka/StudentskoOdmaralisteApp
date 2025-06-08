package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author lukas
 */
public class StavkaRezervacije implements Serializable{
    private int rb;
    private String nazivSmestaja;
    private int brSobe;
    private LocalDate datumVazenjaOd;
    private LocalDate datumVazenjaDo;
    private int brojDana;
    private double cena;
    private double iznos;
    private Rezervacija rezervacija;
    private Soba soba;

    public StavkaRezervacije() {
        
    }

    public StavkaRezervacije(int rb, String nazivSmestaja, int brSobe, LocalDate datumVazenjaOd, LocalDate datumVazenjaDo, int brojDana, double cena, double iznos, Rezervacija rezervacija, Soba soba) {
        this.rb = rb;
        this.nazivSmestaja = nazivSmestaja;
        this.brSobe = brSobe;
        this.datumVazenjaOd = datumVazenjaOd;
        this.datumVazenjaDo = datumVazenjaDo;
        this.brojDana = brojDana;
        this.cena = cena;
        this.iznos = iznos;
        this.rezervacija = rezervacija;
        this.soba = soba;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNazivSmestaja() {
        return nazivSmestaja;
    }

    public void setNazivSmestaja(String nazivSmestaja) {
        this.nazivSmestaja = nazivSmestaja;
    }

    public int getBrSobe() {
        return brSobe;
    }

    public void setBrSobe(int brSobe) {
        this.brSobe = brSobe;
    }

    public LocalDate getDatumVazenjaOd() {
        return datumVazenjaOd;
    }

    public void setDatumVazenjaOd(LocalDate datumVazenjaOd) {
        this.datumVazenjaOd = datumVazenjaOd;
    }

    public LocalDate getDatumVazenjaDo() {
        return datumVazenjaDo;
    }

    public void setDatumVazenjaDo(LocalDate datumVazenjaDo) {
        this.datumVazenjaDo = datumVazenjaDo;
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

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

   

    
  
    
    
}
