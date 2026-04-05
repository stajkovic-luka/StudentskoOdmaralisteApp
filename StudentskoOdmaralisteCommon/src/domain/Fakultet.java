package domain;

import java.io.Serializable;


public class Fakultet implements Serializable{
    private int idFakultet;
    private String naziv;
    private String mesto;
    private boolean akreditovan;

    public Fakultet() {
    }

    public Fakultet(int idFakultet, String naziv, String mesto, boolean akreditovan) {
        this.idFakultet = idFakultet;
        this.naziv = naziv;
        this.mesto = mesto;
        this.akreditovan = akreditovan;
    }

    public int getIdFakultet() {
        return idFakultet;
    }

    public void setIdFakultet(int idFakultet) {
        this.idFakultet = idFakultet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public boolean isAkreditovan() {
        return akreditovan;
    }

    public void setAkreditovan(boolean akreditovan) {
        this.akreditovan = akreditovan;
    }
    
    
}
