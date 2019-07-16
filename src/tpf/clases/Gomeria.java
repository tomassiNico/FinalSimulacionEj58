/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

/**
 *
 * @author xtoma
 */
public class Gomeria {
    
    private double inicioAtencion;
    private double finAtencion;
    
    public Gomeria(double inicio){
        this.inicioAtencion = inicio;
        this.finAtencion = -1;
    }

    public double getInicioAtencion() {
        return inicioAtencion;
    }

    public void setInicioAtencion(double inicioAtencion) {
        this.inicioAtencion = inicioAtencion;
    }

    public double getFinAtencion() {
        return finAtencion;
    }

    public void setFinAtencion(double finAtencion) {
        this.finAtencion = finAtencion;
    }
    
    
    
}
