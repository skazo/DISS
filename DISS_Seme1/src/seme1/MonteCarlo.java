/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seme1;

import java.awt.image.ReplicateScaleFilter;
import java.util.Observable;

/**
 *
 * @author Michal
 */
public abstract class MonteCarlo extends Observable {

    private int pocetReplikacii;

    public MonteCarlo() {
        super();
    }

    protected abstract void replikacia();

    public void simuluj() {
       predSimulaciou();
        for (int i = 0; i < pocetReplikacii; i++) {
            predReplikaciou();
            replikacia();
            poReplikacii();
        }
        poSimulacii();
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
