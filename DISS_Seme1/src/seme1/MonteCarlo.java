/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seme1;

import java.util.Observable;

/**
 *
 * @author Michal
 */
public abstract class MonteCarlo extends Observable {

    private int pocetReplikacii;
    private boolean stop;

    public MonteCarlo(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
        this.stop = false;
    }

      
     public void simuluj() {
      predSimulaciou();
        for (int i = 0; i < pocetReplikacii; i++) {
            predReplikaciou();
            if (stop) {
              break;  
            } 
            replikacia();
            poReplikacii();
        }
        poSimulacii();
    
    }

    public void replikacia() {

    }
    
    public void predReplikaciou() {

    }

    public void poReplikacii() {

    }

    public void predSimulaciou() {

    }

    public void poSimulacii() {
            
    }

    public int getPocetReplikacii() {
        return pocetReplikacii;
    }

    public void setPocetReplikacii(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
    
}
