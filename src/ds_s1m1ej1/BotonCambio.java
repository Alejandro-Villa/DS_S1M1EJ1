/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;

//import GUI.*;

import GUI.MainWindow;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class BotonCambio implements Runnable { // Habia errata aqui
//    private final TermometroObservable t;
//    private MainWindow w;
//    float temp_actual;
//    private javax.swing.JButton botonCambio;
//    
//    // Constructor, se copia referencia al observable y se inica temp
//    public BotonCambio(TermometroObservable termometro, MainWindow w){
//        t = termometro;
//        temp_actual = t.getTemperatura();
//        this.w = w;
//    }
//    
//    // Se pide temp al observable y si cambia se actualiza
//    public float getNuevaTemperatura() {
//        float temp_nueva = t.getTemperatura();
//        if(temp_nueva != temp_actual) {
//            temp_actual = temp_nueva;
////            System.out.println("Pantalla Temperatura:" + temp_actual);
//            w.updateBoton(this);
//        }
//        
//        return temp_actual;
//    }
//    
//    public void setNuevaTemperatura(){
//        Random numAleatorio = new Random();
//        float numero = numAleatorio.nextFloat()*4;
//        if(-5<temp_actual && temp_actual<-1){
//            t.setTemperatura(temp_actual+numero);
//        }else{
//            if(38<temp_actual && temp_actual<42){
//                t.setTemperatura(temp_actual-numero);
//            }
//            else{
//                if(numAleatorio.nextBoolean()){
//                    t.setTemperatura(temp_actual+numero);
//                }
//                else{
//                    t.setTemperatura(temp_actual-numero);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void run() {
//        while(true) {
//            getNuevaTemperatura();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(PantallaTemperatura.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//}

public class BotonCambio implements Observer{
    private TermometroObservable termometro=null;
    MainWindow gui = null;
    
    
    public BotonCambio(MainWindow g){
        this.gui=g;
    }
    
    public float getTemperatura(){
        return termometro.getTemperatura();
    }
    
    @Override
    public void update(Observable o, Object arg){
        //if(o==termometro){
        //    System.out.println("el valor de temp es: "+termometro.getTemperatura());
        //}
        //System.out.println((TermometroObservable) o);
        if(o instanceof TermometroObservable){
            termometro = new TermometroObservable((TermometroObservable)o);
            
//            System.out.println("Grafica ultimo dato: " + termometro.getTemperatura());
            gui.updateBoton(this);                   
        }
        
    }
}
