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
public class Student implements Serializable {

    private int idStudent;
    private String ime;
    private String prezime;
    private long brTelefona;
    private String fakultet;
    private Status status;
    private List<Rezervacija> rezervacije;

    public Student() {
        rezervacije = new ArrayList<>();
    }

    public Student(int idStudent, String ime, String prezime, long brTelefona, String fakultet, Status status, List<Rezervacija> rezervacije) {
        this.idStudent = idStudent;
        this.ime = ime;
        this.prezime = prezime;
        this.brTelefona = brTelefona;
        this.fakultet = fakultet;
        this.status = status;
        this.rezervacije = rezervacije;
    }
    
    // Getteri i setteri
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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

    public long getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(long brTelefona) {
        this.brTelefona = brTelefona;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", ime=" + ime + ", prezime=" 
                + prezime + ", brTelefona=" + brTelefona + ", fakultet=" + fakultet +
                ", status=" + status + ", rezervacije=" + rezervacije + '}';
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
        final Student other = (Student) obj;
        if (this.idStudent != other.idStudent) {
            return false;
        }
        if (this.brTelefona != other.brTelefona) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.fakultet, other.fakultet)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return Objects.equals(this.rezervacije, other.rezervacije);
    }

    
}
