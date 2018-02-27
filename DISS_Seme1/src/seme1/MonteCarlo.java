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
public abstract class MonteCarlo extends Observable implements Runnable{
    
    private int pocetReplikacii;
    
    
    public MonteCarlo(){
        super();
    }
    
}
