/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1m1ej1;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author antonio
 */
public class GraficaTemperatura implements Observer{
    private TermometroObservable termometroObservable;
    
    @Override
    public void update(Observable o, Object arg){
        //termometroObservable.setTemperatura();
    }
}
