/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;

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

    
    

    
    
    
}
