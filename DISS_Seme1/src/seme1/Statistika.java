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
public class Statistika {

    private double vysledok;   // vysledok uspesnyhch stretegii
    private int aktualnaReplikacia;
    private final int vsetkyReplikacie;
    private boolean typStrategie;   // stretegiaA = true - stetegiaB = false
    // private final int pocetPreskoc;

    public Statistika(int replikacie, boolean typStrategie) {
        this.vysledok = 0;
        this.aktualnaReplikacia = 0;
        this.vsetkyReplikacie = replikacie;
        this.typStrategie = typStrategie;
        //   this.pocetPreskoc = pocetPreskoc;

    }

    public void preratajStatistiku(int uspech) {
        vysledok += uspech;
        aktualnaReplikacia++;
    }

    // vrat pocet uspesnych/pocet replikacii danej strategie
    public double vratStatistiku(boolean typStrategie) {
        double uspesnoststrategie = 0;
        
        if (this.typStrategie == true) {
            uspesnoststrategie = vysledok / aktualnaReplikacia;
         //   System.out.println("Uspesnost strategie A: " + uspesnoststrategie);

        } else {
            uspesnoststrategie = vysledok / aktualnaReplikacia;
        //    System.out.println("Uspesnost strategie B: " + uspesnoststrategie);
        }

        return uspesnoststrategie;

    }

    public double getVysledok() {
        return vysledok;
    }

    public void setVysledok(double vysledok) {
        this.vysledok = vysledok;
    }

    public int getAktualnaReplikacia() {
        return aktualnaReplikacia;
    }

    public void setAktualnaReplikacia(int aktualnaReplikacia) {
        this.aktualnaReplikacia = aktualnaReplikacia;
    }

    public boolean isTypStrategie() {
        return typStrategie;
    }

    public void setTypStrategie(boolean typStrategie) {
        this.typStrategie = typStrategie;
    }
    
    

}
