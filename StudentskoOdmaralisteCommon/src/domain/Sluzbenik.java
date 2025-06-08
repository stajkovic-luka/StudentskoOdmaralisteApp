/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lukas
 */
public class Sluzbenik implements Serializable{
    private int idSluzbenik;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private List<SluzbenikSmena> sluzbenikSmena;
    private List<Rezervacija> rezervacije;
    
    public Sluzbenik() {
        sluzbenikSmena = new ArrayList<>();
        rezervacije = new ArrayList<>();
    }

    public Sluzbenik(int idSluzbenik, String ime, String prezime, String korisnickoIme, String lozinka, List<SluzbenikSmena> sluzbenikSmena, List<Rezervacija> rezervacije) {
        this.idSluzbenik = idSluzbenik;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.sluzbenikSmena = sluzbenikSmena;
        this.rezervacije = rezervacije;
    }
    
    // Getteri i setteri
    public int getIdSluzbenik() {
        return idSluzbenik;
    }

    public void setIdSluzbenik(int idSluzbenik) {
        this.idSluzbenik = idSluzbenik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<SluzbenikSmena> getSluzbenikSmena() {
        return sluzbenikSmena;
    }

    public void setSluzbenikSmena(List<SluzbenikSmena> sluzbenikSmena) {
        this.sluzbenikSmena = sluzbenikSmena;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public String toString() {
        return "Sluzbenik{" + "idSluzbenik=" + idSluzbenik + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", sluzbenikSmena=" + sluzbenikSmena + ", rezervacije=" + rezervacije + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sluzbenik other = (Sluzbenik) obj;
        if (this.idSluzbenik != other.idSluzbenik) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        if (!Objects.equals(this.sluzbenikSmena, other.sluzbenikSmena)) {
            return false;
        }
        return Objects.equals(this.rezervacije, other.rezervacije);
    }

    
    
    
    
    
}
