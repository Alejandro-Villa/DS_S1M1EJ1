/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;
import GUI.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author antonio
 */
public class PantallaTemperatura implements Runnable { // Habia errata aqui
    private final TermometroObservable t;
    private MainWindow w;
    float temp_actual;
    
    // Constructor, se copia referencia al observable y se inica temp
    public PantallaTemperatura(TermometroObservable termometro, MainWindow w){
        t = termometro;
        temp_actual = t.getTemperatura();
        this.w = w;
    }
    
    // Se pide temp al observable y si cambia se actualiza
    public float getNuevaTemperatura() {
        float temp_nueva = t.getTemperatura();
        if(temp_nueva != temp_actual) {
            temp_actual = temp_nueva;
            System.out.println("Pantalla Temperatura:" + temp_actual);
            w.updatePantalla(this);
        }
        
        return temp_actual;
    }

    @Override
    public void run() {
        while(true) {
            getNuevaTemperatura();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaTemperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
