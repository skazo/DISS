package seme1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author knazik.michal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
//   simulacia pre strategiu A
//          Jadro jadro1 = new Jadro(1000000,true);
//        jadro1.simuluj();
 //   simulacia pre strategiu B       
     Jadro jadro2 = new Jadro(1000000, 3, true);
        jadro2.simuluj();   
       
    }
    
}
