/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukas
 */
public class Status implements Serializable{
    private int idStatus;
    private int godinaStudija;
    private boolean budzet;
    private LocalDate datumVazenjaOd;
    private LocalDate datumVazenjaDo;
    private List<Student> studenti;
    
    public Status() {
        studenti = new ArrayList<>();
    }

    public Status(int idStatus, int godinaStudija, boolean budzet, LocalDate datumVazenjaOd, LocalDate datumVazenjaDo, List<Student> studenti) {
        this.idStatus = idStatus;
        this.godinaStudija = godinaStudija;
        this.budzet = budzet;
        this.datumVazenjaOd = datumVazenjaOd;
        this.datumVazenjaDo = datumVazenjaDo;
        this.studenti = studenti;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public boolean isBudzet() {
        return budzet;
    }

    public void setBudzet(boolean budzet) {
        this.budzet = budzet;
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

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

   
    
    
    
}
