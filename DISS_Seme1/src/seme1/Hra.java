/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seme1;

import java.util.Random;

/**
 *
 * @author Michal
 */
public class Hra {

    private int pocetDveri;
    private boolean[] dvere;
    private Random generatorAuto;  // generuje nahodne cislo aby urcil poziciu auta
    private Random generatorHrac; // generuje nahodne cislo aby urcil hracov vyber
    private Random generatorHrac2;
    private Random generatorModerator; // generuje nahodne cislo aby urcil vyber moderatora
    private int auto;
    private int hrac;
    private int moderator;
    private int aktualneCisloHry;
    private boolean typHry;  // true a / false b

    public Hra(int pocetDveri, boolean typHry) {
        this.pocetDveri = pocetDveri;
        this.dvere = new boolean[pocetDveri];
        this.auto = -1;
        this.hrac = -1;
        this.moderator = -1;
        this.aktualneCisloHry = 1;
        this.typHry = typHry;
        generujNasady();

    }

    // 1
    public void generujNasady() {
        Random rand = new Random();
        generatorAuto = new Random(rand.nextInt());
        generatorHrac = new Random(rand.nextInt());
        generatorHrac2 = new Random(rand.nextInt());
        generatorModerator = new Random(rand.nextInt());
    }

    // 2
    public void nastavAutoZviera() {
     // System.out.println("cislo hry: " + getAktualneCisloHry());
        for (int i = 0; i < pocetDveri; i++) {
            //System.out.println("cislo dveri: " + i);
            dvere[i] = false;

        }
        auto = generatorAuto.nextInt(pocetDveri);
        dvere[auto] = true;
        hrac = generatorHrac.nextInt(pocetDveri);

//        for (int i = 0; i < pocetDveri; i++) {
//            System.out.println("obsah dveri " + i + " : " + dvere[i]);
//        }
        
    }

    //3  
//    public int pocetDveriNaOtvorenie(int pocetDveri) {
//        int pocetDveriNaOtvorenieModerator;
//        if (auto == hrac) {
//            pocetDveriNaOtvorenieModerator = pocetDveri - 1;
//        } else {
//            pocetDveriNaOtvorenieModerator = pocetDveri - 2;
//        }
//        return pocetDveriNaOtvorenieModerator;
//    }
    public void otvorVolneDvereModerator() {
        // moderatorovi pridelim dvere ktore moze otvorit nie je tam auto ani volba hraca
        //int dvereModerator[];
        if (auto == hrac) {
            int[] dvereModerator = new int[pocetDveri - 1];
            int pom = 0;
            int pom2;

            for (int i = 0; i < dvere.length; i++) {

                if (dvere[i] == false && i != hrac) {
                    dvereModerator[pom] = i;
                    pom++;
                }
            }
            if (dvereModerator.length == 1) {
                pom2 = 0;
                moderator = dvereModerator[pom2];
            } else {
                pom2 = generatorModerator.nextInt(dvereModerator.length);
                moderator = dvereModerator[pom2];
            }
        } else {
            int[] dvereModerator = new int[pocetDveri - 2];
            int pom = 0;
            int pom2;

            for (int i = 0; i < dvere.length; i++) {

                if (dvere[i] == false && i != hrac) {
                    dvereModerator[pom] = i;
                    pom++;
                }
            }
            if (dvereModerator.length == 1) {
                pom2 = 0;
                moderator = dvereModerator[pom2];
            } else {
                pom2 = generatorModerator.nextInt(dvereModerator.length);
                moderator = dvereModerator[pom2];
            }
        }

    }

    public void zmenaDveriHraca() {
        // tu si bude vyberat druhe dvere hrac
        // otvorVolneDvereModerator();
        int[] dvereHrac = new int[pocetDveri - 2];
        int pom = 0;
        int pom2;

        for (int i = 0; i < pocetDveri; i++) {

            if (i != hrac && i != moderator) {
                dvereHrac[pom] = i;
                pom++;
            }

        }
        if (dvereHrac.length == 1) {
            pom2 = 0;
            hrac = dvereHrac[pom2];
        } else {
            pom2 = generatorHrac2.nextInt(dvereHrac.length);
            hrac = dvereHrac[pom2];
        }

    }

    public int urobStrategiuA() {
        int vyhral;

        if (auto == hrac) {
            vyhral = 1;
        } else {
            vyhral = 0;
        }
 //  System.out.println("strategiaA: CisloA: " + auto + " CisloH: " + hrac + " CisloM: " + moderator + " Vyhral?: " + vyhral);
        return vyhral;
    }

    // ak zmeni a trafi vrati 1 inak 0
    // false
    public int urobStrategiuB() {
        int vyhral = Integer.MAX_VALUE;
        zmenaDveriHraca();
        if (auto == hrac) {
            vyhral = 1;
        } else {
            vyhral = 0;
        }
//        System.out.println("strategiaB: CisloA: " + auto + " CisloH: " + hrac + " CisloM: " + moderator + " Vyhral?: " + vyhral);
        return vyhral;
    }

    public int urobHru() {
        int nieco = 0;
        nastavAutoZviera();
        otvorVolneDvereModerator();
        if (typHry) {
           nieco = urobStrategiuA();
        } else {
        nieco = urobStrategiuB();
        }
        aktualneCisloHry=getAktualneCisloHry();
        aktualneCisloHry++;
        //setAktualneCisloHry(aktualneCisloHry);
        
        return nieco;
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

    public int getAktualneCisloHry() {
        return aktualneCisloHry;
    }

    public void setAktualneCisloHry(int aktualneCisloHry) {
        this.aktualneCisloHry = aktualneCisloHry;
    }
    
    
}
