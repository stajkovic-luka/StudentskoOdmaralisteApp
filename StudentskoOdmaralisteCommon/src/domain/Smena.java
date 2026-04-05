package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lukas
 */
public class Smena implements Serializable {

    private long idSmena;
    private String prostorija;
    private String komentar;
    private TipSmene tipSmene;

    public Smena() {
    }

    public Smena(long idSmena, String prostorija, String komentar, TipSmene tipSmene) {
        this.idSmena = idSmena;
        this.prostorija = prostorija;
        this.komentar = komentar;
        this.tipSmene = tipSmene;
    }

    public long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(long idSmena) {
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

    
    
}
