/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    
    
    
    
    
}
