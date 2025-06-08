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
    
    // Getteri i setteri
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
        final Smena other = (Smena) obj;
        if (this.idSmena != other.idSmena) {
            return false;
        }
        if (!Objects.equals(this.prostorija, other.prostorija)) {
            return false;
        }
        if (!Objects.equals(this.komentar, other.komentar)) {
            return false;
        }
        if (this.tipSmene != other.tipSmene) {
            return false;
        }
        return Objects.equals(this.sluzbenikSmena, other.sluzbenikSmena);
    }

    @Override
    public String toString() {
        return "Smena{" + "idSmena=" + idSmena + ", prostorija=" + prostorija + ", komentar=" + komentar + ", tipSmene=" + tipSmene + ", sluzbenikSmena=" + sluzbenikSmena + '}';
    }
    
    
}
