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
}
