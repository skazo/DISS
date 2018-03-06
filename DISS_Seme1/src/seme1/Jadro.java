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
    private int aktualnaVyhra;
    private boolean typHry;

    public Jadro(int pocetReplikacii, boolean typHry) {
        super(pocetReplikacii);
        this.statistika = new Statistika(pocetReplikacii,typHry); 
        this.hra = new Hra(3,typHry);
        
    }
    
    @Override
    public void replikacia() {
       aktualnaVyhra = 0; 
       aktualnaVyhra = hra.urobHru();
    }

    @Override
    public void predReplikaciou() {
       
    }

    @Override
    public void poReplikacii() {
        statistika.preratajStatistiku(aktualnaVyhra);
        statistika.vratStatistiku(typHry);
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
