/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;

import java.util.Observable;
import java.util.Observer;
import GUI.*;
import java.util.ArrayList;



/**
 *
 * @author antonio
 */
public class GraficaTemperatura implements Observer{
    private TermometroObservable termometro=null;
    MainWindow gui = null;
    ArrayList<Float> temps = new ArrayList<Float>();
    
    
    public GraficaTemperatura(MainWindow g){
        this.gui=g;
    }
    
    public float getTemperatura(){
        return termometro.getTemperatura();
    }
    
    public ArrayList<Float> getTemperaturas(){
        return  new ArrayList<Float>(temps);
    }
    
    @Override
    public void update(Observable o, Object arg){
        //if(o==termometro){
        //    System.out.println("el valor de temp es: "+termometro.getTemperatura());
        //}
        //System.out.println((TermometroObservable) o);
        if(o instanceof TermometroObservable){
            termometro = new TermometroObservable((TermometroObservable)o);
            
            if(temps.size()<7){
                temps.add(termometro.getTemperatura());
            }else{
                temps.remove(0);
                temps.add(termometro.getTemperatura());
            }
            
//            System.out.println("Grafica ultimo dato: " + termometro.getTemperatura());
            gui.updateGrafica(this);                   
        }
        
    }
}
