/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;


import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
/**
 *
 * @author antonio
 */
public class TermometroObservable extends Observable implements Runnable{
    private float temperatura;
    
    public TermometroObservable(TermometroObservable t){
        this.temperatura = t.temperatura;
    }

    public TermometroObservable(float temp){
        this.temperatura = temp;
    }
    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        
        //compruebo si el parámetro observado ha cambiado
        if(this.temperatura!=temperatura){
            this.temperatura = temperatura;
            //Marco que la temperatura ha cambiado
            this.setChanged();
            //Notificar los observadores
            this.notifyObservers();
        }
    }
    
    public void run(){
        
        
        while(true){
            try {
                Random numAleatorio = new Random();
                float numero = numAleatorio.nextFloat()*4;
                if(-5<temperatura && temperatura<-1){
                    setTemperatura(temperatura+numero);
                }else{
                    if(38<temperatura && temperatura<42){
                        setTemperatura(temperatura-numero);
                    }
                    else{
                        if(numAleatorio.nextBoolean()){
                            setTemperatura(temperatura+numero);
                        }
                        else{
                            setTemperatura(temperatura-numero);
                        }
                    }
                }
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TermometroObservable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
