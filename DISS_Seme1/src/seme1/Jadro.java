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
public class Jadro {

    private int pocetReplikacii;
    private int pocetDveri;
    private double pravdepodobnostA;
    private double pravdepodobnostB;
    private double cena;
    
    public Jadro(){
        
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getPravdepodobnost1() {
        return pravdepodobnostA;
    }

    public void setPravdepodobnost1(double pravdepodobnostA) {
        this.pravdepodobnostA = pravdepodobnostA;
    }

    public double getPravdepodobnostB() {
        return pravdepodobnostB;
    }

    public void setPravdepodobnost2(double pravdepodobnostB) {
        this.pravdepodobnostB = pravdepodobnostB;
    }

    public int getPocetDveri() {
        return pocetDveri;
    }

    public void setPocetDveri(int pocetDveri) {
        this.pocetDveri = pocetDveri;
    }

    public int getPocetReplikacii() {
        return pocetReplikacii;
    }

    public void setPocetReplikacii(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
    }

}
