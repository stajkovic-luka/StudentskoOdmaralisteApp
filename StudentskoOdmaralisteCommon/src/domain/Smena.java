package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukas
 */
public class Smena implements Serializable {

    private int idSmena;
    private String prostorija;
    private String komentar;
    private TipSmene tipSmene;
    private List<SluzbenikSmena> sluzbenikSmena;

    public Smena() {
        sluzbenikSmena = new ArrayList<>();
    }

    public Smena(int idSmena, String prostorija, String komentar, TipSmene tipSmene, List<SluzbenikSmena> sluzbenikSmena) {
        this.idSmena = idSmena;
        this.prostorija = prostorija;
        this.komentar = komentar;
        this.tipSmene = tipSmene;
        this.sluzbenikSmena = sluzbenikSmena;
    }

    public int getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(int idSmena) {
        this.idSmena = idSmena;
    }

    public String getProstorija() {
        return prostorija;
    }

    public void setProstorija(String prostorija) {
        this.prostorija = prostorija;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public TipSmene getTipSmene() {
        return tipSmene;
    }

    public void setTipSmene(TipSmene tipSmene) {
        this.tipSmene = tipSmene;
    }

    public List<SluzbenikSmena> getSluzbenikSmena() {
        return sluzbenikSmena;
    }

    public void setSluzbenikSmena(List<SluzbenikSmena> sluzbenikSmena) {
        this.sluzbenikSmena = sluzbenikSmena;
    }

}
