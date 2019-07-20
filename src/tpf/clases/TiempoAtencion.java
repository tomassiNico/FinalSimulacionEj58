/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

/**
 *
 * @author nleguizamon
 */
public class TiempoAtencion {
    private double rnd;
    private double tiempoAtencion;
    private double finAtencion;
    private String servicio;
    
    private static TiempoAtencion instance;  
    
    public static TiempoAtencion getInstance(){
        if (instance == null) {
            instance = new TiempoAtencion();
            instance.setRnd(-1);
            instance.setFinAtencion(-1);
            instance.setServicio("");
            instance.setTiempoAtencion(-1);
        }
        return instance;
    }
    
    private TiempoAtencion(){
        
    }
    
    public void resetear(){
        this.setRnd(-1);
        this.setFinAtencion(-1);
        this.setServicio("");
        this.setTiempoAtencion(-1);
    }

    public double getRnd() {
        return rnd;
    }

    public void setRnd(double rnd) {
        this.rnd = rnd;
    }

    public double getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(double tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public double getFinAtencion() {
        return finAtencion;
    }

    public void setFinAtencion(double finAtencion) {
        this.finAtencion = finAtencion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    } 
    
}
