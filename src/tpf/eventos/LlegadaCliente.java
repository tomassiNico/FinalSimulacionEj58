/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.eventos;

import java.util.Random;
import distribuciones.Normal;
/**
 *
 * @author xtoma
 */
public class LlegadaCliente {
    
    private Random generadorRnd;
    private double rndLlegada1;
    private double rndLlegada2;
    private double tiempoLlegada;
    private double proximaLlegada;
    private Normal generadorNormal;
    
    public LlegadaCliente(){
        this.generadorRnd = new Random();
        this.rndLlegada1 = -1;
        this.rndLlegada2 = -1;
        this.tiempoLlegada = -1;
        this.proximaLlegada = -1;
        // pasamos los 24 segundos y los 23 segundo a minutos 
        // para el generador de distr normal
        this.generadorNormal = new Normal(0.4, 0.3833333);
    }

    public double getRndLlegada1() {
        return Math.round(rndLlegada1*100.0)/100.0;
    }

    public void setRndLlegada1(double rndLlegada) {
        this.rndLlegada1 = rndLlegada;
    }
    
    public double getRndLlegada2() {
        return Math.round(rndLlegada2*100.0)/100.0;
    }

    public void setRndLlegada2(double rndLlegada) {
        this.rndLlegada2 = rndLlegada;
    }

    public double getTiempoLlegada() {
        return Math.round(tiempoLlegada*100.0)/100.0;
    }

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public double getProximaLlegada() {
        return Math.round(proximaLlegada*100.0)/100.0;
    }

    public void setProximaLlegada(double proximaLlegada) {
        this.proximaLlegada = proximaLlegada;
    }
    
    public void generarProximaLlegada(double reloj){
        
        this.rndLlegada1 = this.generadorRnd.nextDouble();
        this.rndLlegada2 = this.generadorRnd.nextDouble();
        this.tiempoLlegada = this.generadorNormal.generarNumero(rndLlegada1, rndLlegada2);
        
        if (this.tiempoLlegada > (28.0/60)) {
            this.tiempoLlegada = (28.0/60);
        }
        
        if (this.tiempoLlegada < (20.0/60)) {
            this.tiempoLlegada = (20.0/60);
        }
        
        this.proximaLlegada = this.tiempoLlegada + reloj;
        
    }
    
}
