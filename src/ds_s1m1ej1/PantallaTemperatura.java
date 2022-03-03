/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;

/**
 *
 * @author antonio
 */
public class PantallaTemperatura { // Habia errata aqui
    private TermometroObservable t;
    float temp_actual;
    
    // Constructor, se copia referencia al observable y se inica temp
    public PantallaTemperatura(TermometroObservable termometro){
        t = termometro;
        temp_actual = t.getTemperatura();
    }
    
    // Se pide temp al observable y si cambia se actualiza
    float getNuevaTemperatura() {
        float temp_nueva = t.getTemperatura();
        if(temp_nueva != temp_actual)
            temp_actual = temp_nueva;
        
        return temp_actual;
    }
}
