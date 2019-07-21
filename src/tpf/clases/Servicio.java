/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

import java.util.Random;

/**
 *
 * @author xtoma
 */
public class Servicio {
    
    private Random generadorRnd;
    private double rndGasolinera;
    private boolean esGasolina;
    private double rndOtroServicio;
    private String otroServicio;
    
    public  Servicio(){
       this.generadorRnd = new Random();
       this.esGasolina= false;
       this.rndGasolinera = -1;
       this.rndOtroServicio = -1;
       this.otroServicio = "";
    }
    
    public void resetear(){
       this.esGasolina= false;
       this.rndGasolinera = -1;
       this.rndOtroServicio = -1;
       this.otroServicio = "";
    }

    public double getRndGasolinera() {
        return rndGasolinera;
    }

    public void setRndGasolinera(double rndGasolinera) {
        this.rndGasolinera = rndGasolinera;
    }
    
    public boolean esGasolina(){
        return esGasolina;
    }

    public String getEsGasolina() {
        String gasolina;
        if (esGasolina) {
            gasolina= "S";
        }
        else{
            gasolina= "N";
        }
        return gasolina;
    }

    public void setEsGasolina(boolean esGasolina) {
        this.esGasolina = esGasolina;
    }

    public double getRndOtroServicio() {
        return rndOtroServicio;
    }

    public void setRndOtroServicio(double rndOtroServicio) {
        this.rndOtroServicio = rndOtroServicio;
    }

    public String getOtroServicio() {
        return otroServicio;
    }

    public void setOtroServicio(String otroServicio) {
        this.otroServicio = otroServicio;
    }
    
    public void servicioSolicitado(){
        rndGasolinera = generadorRnd.nextDouble();
        if (rndGasolinera < 0.8) {
            this.esGasolina = true;
            this.rndOtroServicio = -1;
            this.otroServicio = "";
        }
        else{
           this.esGasolina = false;
           rndOtroServicio = generadorRnd.nextDouble();
            if (rndOtroServicio < 0.40) {
                this.otroServicio = "Accesorio";
            }
            else{
                this.otroServicio = "Gomeria";
            }
        }
    }
    
    public void servicioPosGasolinera(){
        this.rndGasolinera = -1;
        this.esGasolina = false;
        this.rndOtroServicio = generadorRnd.nextDouble();
        if (this.rndOtroServicio < 0.30) {
            this.otroServicio = "Accesorio";
        }
        else{
            if (this.rndOtroServicio < 0.50) {
                this.otroServicio = "Gomeria";
            }
            else{
                this.otroServicio = "Nada";
            }
        }
    }
    
}
