package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lukas
 */
public class Soba implements Serializable{
    private int idSoba;
    private int kapacitet;
    private int zauzetoMesta;
    private int sprat;
    private double cena;
    private List<StavkaRezervacije> stavkeRezervacije;
    
    public Soba() {
        stavkeRezervacije = new ArrayList<>();
    }

    public Soba(int idSoba, int kapacitet, int zauzetoMesta, int sprat, double cena, List<StavkaRezervacije> stavkeRezervacije) {
        this.idSoba = idSoba;
        this.kapacitet = kapacitet;
        this.zauzetoMesta = zauzetoMesta;
        this.sprat = sprat;
        this.cena = cena;
        this.stavkeRezervacije = stavkeRezervacije;
    }
    
    // Getteri i setteri
    public int getIdSoba() {
        return idSoba;
    }

    public void setIdSoba(int idSoba) {
        this.idSoba = idSoba;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getZauzetoMesta() {
        return zauzetoMesta;
    }

    public void setZauzetoMesta(int zauzetoMesta) {
        this.zauzetoMesta = zauzetoMesta;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public List<StavkaRezervacije> getStavkeRezervacije() {
        return stavkeRezervacije;
    }

    public void setStavkeRezervacije(List<StavkaRezervacije> stavkeRezervacije) {
        this.stavkeRezervacije = stavkeRezervacije;
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
        final Soba other = (Soba) obj;
        if (this.idSoba != other.idSoba) {
            return false;
        }
        if (this.kapacitet != other.kapacitet) {
            return false;
        }
        if (this.zauzetoMesta != other.zauzetoMesta) {
            return false;
        }
        if (this.sprat != other.sprat) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        return Objects.equals(this.stavkeRezervacije, other.stavkeRezervacije);
    }

    @Override
    public String toString() {
        return "Soba{" + "idSoba=" + idSoba + ", kapacitet=" + kapacitet + ", zauzetoMesta=" + zauzetoMesta + ", sprat=" + sprat + ", cena=" + cena + ", stavkeRezervacije=" + stavkeRezervacije + '}';
    }

    
    
}
