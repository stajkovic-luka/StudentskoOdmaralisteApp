package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FakturaOdmora implements Serializable{
    private long idFaktura;
    private double popust;
    private double iznosNakonPopusta;
    private double ukupanIznos;
    private String napomena;
    private Student student;
    private Sluzbenik sluzbenik;
    private List<StavkaFakture> stavkeFakture = new ArrayList<>();

    public FakturaOdmora() {
    }

    public FakturaOdmora(long idFaktura, double popust, double iznosNakonPopusta, double ukupanIznos, String napomena, Student student, Sluzbenik sluzbenik) {
        this.idFaktura = idFaktura;
        this.popust = popust;
        this.iznosNakonPopusta = iznosNakonPopusta;
        this.ukupanIznos = ukupanIznos;
        this.napomena = napomena;
        this.student = student;
        this.sluzbenik = sluzbenik;
    }
    
    

    public long getIdFaktura() {
        return idFaktura;
    }

    public void setIdFaktura(long idFaktura) {
        this.idFaktura = idFaktura;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getIznosNakonPopusta() {
        return iznosNakonPopusta;
    }

    public void setIznosNakonPopusta(double iznosNakonPopusta) {
        this.iznosNakonPopusta = iznosNakonPopusta;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    public List<StavkaFakture> getStavkeFakture() {
        return stavkeFakture;
    }

    public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
        this.stavkeFakture = stavkeFakture;
    }
    
    
}
