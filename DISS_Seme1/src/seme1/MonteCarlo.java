/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seme1;

/**
 *
 * @author Michal
 */
public abstract class MonteCarlo {

    private int pocetReplikacii;

    public MonteCarlo(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
    }

    public void simuluj() {
        predSimulaciou();
        for (int i = 0; i < pocetReplikacii; i++) {
            predReplikaciou();
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
}
