package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FakturaOdmora implements Serializable{
    private int idFaktura;
    private double popust;
    private double iznosNakonPopusta;
    private double ukupanIznos;
    private String napomena;
    private Student student;
    private Sluzbenik sluzbenik;
    private List<StavkaFakture> stavkeFakture = new ArrayList<>();
}
