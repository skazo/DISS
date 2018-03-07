package seme1;

import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michal
 */
public class Jadro extends MonteCarlo implements Runnable{

    private Hra hra;
    private Statistika statistika;
    private int pocetReplikacii;
    private int aktualnaVyhra;
    private boolean typHry;

    public Jadro(int pocetReplikacii, int pocetDveri, boolean typHry) {
        super(pocetReplikacii);
        this.statistika = new Statistika(pocetReplikacii,typHry); 
        this.hra = new Hra(pocetDveri,typHry);
        
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
        setChanged();
        notifyObservers(statistika);
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

    public Statistika getStatistika() {
        return statistika;
    }

    public void setStatistika(Statistika statistika) {
        this.statistika = statistika;
    }

    public int getAktualnaVyhra() {
        return aktualnaVyhra;
    }

    public void setAktualnaVyhra(int aktualnaVyhra) {
        this.aktualnaVyhra = aktualnaVyhra;
    }

    public boolean isTypHry() {
        return typHry;
    }

    public void setTypHry(boolean typHry) {
        this.typHry = typHry;
    }

    @Override
    public void run() {
        simuluj();
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
