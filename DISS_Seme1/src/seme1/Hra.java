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
    private int auto;
    private int hrac;
    private int moderator;
    private int pomocna;

    public Hra(int pocetDveri) {
        this.pocetDveri = pocetDveri;
        this.dvere = new boolean[pocetDveri];
        this.auto = -1;
        this.hrac = -1;
        this.moderator = -1;
        this.pomocna = 1;    
    }

    public void generujNasady() {
        Random rand = new Random();
        generatorAuto = new Random(rand.nextInt());
        generatorHrac = new Random(rand.nextInt());
        generatorModerator = new Random(rand.nextInt());
    }

    public void nastavAutoZviera() {
        System.out.println("cislo hry"+pomocna);
        for (int i = 0; i < pocetDveri; i++) {
            //System.out.println("cislo dveri: " + i);
            dvere[i] = false;
            
        }
        auto = generatorAuto.nextInt(pocetDveri);
        this.dvere[auto] = true;
        
        
        for (int i = 0; i < pocetDveri; i++) {
            System.out.println("obsah dveri: "+dvere[i]);
        }
        pomocna++;
    }

    public void urobHru() {
        generujNasady();
        nastavAutoZviera();
        hrac = generatorHrac.nextInt(pocetDveri);
        otvorVolneDvereModerator();
        urobStrategiuA();
        urobStrategiuB();
    }

    // ak zotrva na svojom a trafi vrati 1 inak 0
    // true
    public int pocetDveriNaOtvorenie(int pocetDveri) {
        int pocetDveriNaOtvorenieModerator;
        if (auto == hrac) {
            pocetDveriNaOtvorenieModerator = pocetDveri - 1;
        } else {
            pocetDveriNaOtvorenieModerator = pocetDveri - 2;
        }
        return pocetDveriNaOtvorenieModerator;
    }

    public void otvorVolneDvereModerator() {
        // moderatorovi pridelim dvere ktore moze otvorit nie je tam auto ani volba hraca
        int[] dvereModerator = new int[pocetDveriNaOtvorenie(pocetDveri)];

        for (int i = 0; i < pocetDveri; i++) {
            int pom = 0;
            if (dvere[i] == false && i != hrac && i != moderator) {
                dvereModerator[pom] = i;
                pom++;
            }
            int pom2 = generatorModerator.nextInt(dvereModerator.length);
            moderator = dvereModerator[pom2];
        }
    }

    public void zmenaDveriHraca() {
        // tu si bude vyberat druhe dvere hrac
        otvorVolneDvereModerator();
        int[] dvereHrac = new int[pocetDveriNaOtvorenie(pocetDveri)];

        for (int i = 0; i < pocetDveri; i++) {
            int pom = 0;
            if (i != hrac && i != moderator) {
                dvereHrac[pom] = i;
                pom++;
            }
            int pom2 = generatorHrac.nextInt(dvereHrac.length);
            hrac = dvereHrac[pom2];
        }

    }

    public int urobStrategiuA() {
     //  otvorVolneDvereModerator();
        int vyhral = 20;

        if (auto == hrac) {
            vyhral = 1;
        } else {
            vyhral = 0;
        }
        
        System.out.println("strategiaA: CisloA: "+auto+" CisloH: "+hrac+" CisloM: " +moderator+" Vyhral?: "+vyhral);
        return vyhral;
    }

    // ak zmeni a trafi vrati 1 inak 0
    // false
    public int urobStrategiuB() {
        int vyhral = 20;
     //   otvorVolneDvereModerator();
        zmenaDveriHraca();

        if (auto == hrac) {
            vyhral = 1;
        } else {
            vyhral = 0;
        }
        System.out.println("strategiaB: CisloA: "+auto+" CisloH: "+hrac+" CisloM: " +moderator+" Vyhral?: "+vyhral);
        return vyhral;
    }

//    public void zacniHru(){
//          nastavAutoZviera();
//          if (strategia) {
//            urobStrategiuA();
//        } else {
//              urobStrategiuB();
//        }
//          
//    }
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
