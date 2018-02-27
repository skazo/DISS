/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seme1;

import java.util.Random;

/**
 *
 * @author Michal - odohrava sa tu hra - generovanie nasad, vytvori sa pole,
 * naplni sa, hra sa podla strategie A a B
 */
public class Hra {

    private int pocetDveri;
    private boolean[] dvere;
    private Random generatorAuto;  // generuje nahodne cislo aby urcil poziciu auta
    private Random generatorHrac; // generuje nahodne cislo aby urcil hracov vyber
    private Random generatorModerator; // generuje nahodne cislo aby urcil vyber moderatora
    private boolean strategia; 
            
    public Hra(int pocetDveri, boolean strategia) {
        this.pocetDveri = pocetDveri;
        this.dvere = new boolean[pocetDveri];
        this.strategia = strategia;
        generujNasady();
      
    }

    public void generujNasady() {
        Random rand = new Random();
        generatorAuto = new Random(rand.nextInt());
        generatorHrac = new Random(rand.nextInt());
        
    }

    public void nastavAutoZviera() {
                       
        for (int i = 0; i < pocetDveri; i++) {
            //System.out.println("cislo dveri: " + i);
            dvere[i]= false;    
        }
        dvere[generatorAuto.nextInt(pocetDveri)]=true;
       
        for (int i = 0; i < pocetDveri; i++) {
            System.out.println("obsah dveri: "+dvere[i]);
        }
   
        
    }

    // ak zotrva na svojom a trafi vrati 1 inak 0
    // true
    public int urobStrategiuA() {
        int vyhral = 20;
        if (true) {

        } else {
            vyhral = 0;
        }
        return vyhral;
    }

    // ak zmeni a trafi vrati 1 inak 0
    // false
    public int urobStrategiuB() {
        int vyhral = 20;
        if (true) {

        } else {
            vyhral = 0;
        }
        return vyhral;
    }
    
    public void zacniHru(){
          nastavAutoZviera();
          if (strategia) {
            urobStrategiuA();
        } else {
              urobStrategiuB();
        }
          
    }

    public void vymazDvere() {
        dvere = new boolean[pocetDveri];
    }

    public void nastavPocetDveri(int novyPocetDveri) {
        pocetDveri = novyPocetDveri;
    }

    public int getPocetDveri() {
        return pocetDveri;
    }

    public void setPocetDveri(int pocetDveri) {
        this.pocetDveri = pocetDveri;
    }

    public boolean[] getDvere() {
        return dvere;
    }

    public void setDvere(boolean[] dvere) {
        this.dvere = dvere;
    }

    public Random getGeneratorAuto() {
        return generatorAuto;
    }

    public void setGeneratorAuto(Random generatorAuto) {
        this.generatorAuto = generatorAuto;
    }

    public Random getGeneratorHrac() {
        return generatorHrac;
    }

    public void setGeneratorHrac(Random generatorHrac) {
        this.generatorHrac = generatorHrac;
    }

    public Random getGeneratorModerator() {
        return generatorModerator;
    }

    public void setGeneratorModerator(Random generatorModerator) {
        this.generatorModerator = generatorModerator;
    }

}
