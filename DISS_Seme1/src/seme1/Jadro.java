package seme1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michal
 */
public class Jadro extends MonteCarlo {

    private Hra hra;
    private Statistika statistika;
    private int pocetReplikacii;

    public Jadro(int pocetReplikacii) {
        super(pocetReplikacii);
        this.hra = new Hra(3);
    }
    
    // 
    @Override
    public void replikacia() {
       hra.urobHru();
    }

    @Override
    public void predReplikaciou() {
        
    }

    @Override
    public void poReplikacii() {
            
    }

    @Override
    public void predSimulaciou() {
        
    }

    @Override
    public void poSimulacii() {

    }
    
    public Hra getHra() {
        return hra;
    }

    public void setHra(Hra hra) {
        this.hra = hra;
    }
    
    public int getPocetReplikacii() {
        return pocetReplikacii;
    }

    public void setPocetReplikacii(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
    }
    
}
