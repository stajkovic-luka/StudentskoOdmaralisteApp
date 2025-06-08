/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    
    // Getteri i setteri
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Status other = (Status) obj;
        if (this.idStatus != other.idStatus) {
            return false;
        }
        if (this.godinaStudija != other.godinaStudija) {
            return false;
        }
        if (this.budzet != other.budzet) {
            return false;
        }
        if (!Objects.equals(this.datumVazenjaOd, other.datumVazenjaOd)) {
            return false;
        }
        if (!Objects.equals(this.datumVazenjaDo, other.datumVazenjaDo)) {
            return false;
        }
        return Objects.equals(this.studenti, other.studenti);
    }

    @Override
    public String toString() {
        return "Status{" + "idStatus=" + idStatus + ", godinaStudija=" + godinaStudija + ", budzet=" + budzet + ", datumVazenjaOd=" + datumVazenjaOd + ", datumVazenjaDo=" + datumVazenjaDo + ", studenti=" + studenti + '}';
    }

   
    
    
    
}
