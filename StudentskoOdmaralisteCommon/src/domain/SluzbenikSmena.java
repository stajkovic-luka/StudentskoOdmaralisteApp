/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author lukas
 */
public class SluzbenikSmena implements Serializable{
    private Sluzbenik sluzbenik;
    private Smena smena;
    private LocalDate datumSmene;

    public SluzbenikSmena() {
        
    }

    public SluzbenikSmena(Sluzbenik sluzbenik, Smena smena, LocalDate datumSmene) {
        this.sluzbenik = sluzbenik;
        this.smena = smena;
        this.datumSmene = datumSmene;
    }
    
    // Getteri i setteri
    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    public Smena getSmena() {
        return smena;
    }

    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    public LocalDate getDatumSmene() {
        return datumSmene;
    }

    public void setDatumSmene(LocalDate datumSmene) {
        this.datumSmene = datumSmene;
    }

    @Override
    public String toString() {
        return "SluzbenikSmena{" + "sluzbenik=" + sluzbenik + ", smena=" + smena + ", datumSmene=" + datumSmene + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final SluzbenikSmena other = (SluzbenikSmena) obj;
        if (!Objects.equals(this.sluzbenik, other.sluzbenik)) {
            return false;
        }
        if (!Objects.equals(this.smena, other.smena)) {
            return false;
        }
        return Objects.equals(this.datumSmene, other.datumSmene);
    }

    
    

    
    
    
}
