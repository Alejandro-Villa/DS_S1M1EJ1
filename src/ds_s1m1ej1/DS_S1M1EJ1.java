/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;
import java.util.Observable;

/**
 *
 * @author antonio
 */
public class DS_S1M1EJ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TermometroObservable termometro = new TermometroObservable(15);
        
        GraficaTemperatura gr = new GraficaTemperatura(termometro);
        
        //GraficaTemperatura se suscribe como observador
        termometro.addObserver(gr);
        
        
        new Thread(termometro).start();
    }
    
}
