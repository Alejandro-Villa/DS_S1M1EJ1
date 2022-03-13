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
    float temp_actual_gr;
    
    // Constructor, se copia referencia al observable y se inica temp
    public PantallaTemperatura(TermometroObservable termometro, MainWindow w){
        t = termometro;
        temp_actual_gr = t.getTemperatura();
        this.w = w;
    }
    
    // Se pide temp al observable y si cambia se actualiza
    public void actualizarTemp() {
        float temp_nueva = t.getTemperatura();
        if(temp_nueva != temp_actual_gr) {
            temp_actual_gr = temp_nueva;
//            System.out.println("Pantalla Temperatura:" + temp_actual);
            w.updatePantalla(this);
        }
    }
    
    public float getTemperatura(){
        return temp_actual_gr;
    }
    
    public float getTemperaturaF(){
        return (float) (temp_actual_gr*1.8+32);
    }

    @Override
    public void run() {
        while(true) {
            actualizarTemp();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaTemperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
