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

    public Jadro() {
        super();
        this.hra = new Hra(3, true);
    }

    
    // 
    @Override
    protected void replikacia() {
       hra.zacniHru();
       statistika.vyratajStatistiku();
       hra.vymazDvere();
    }

    @Override
    public void predReplikaciou() {
            //dorobit
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
    
    
}
