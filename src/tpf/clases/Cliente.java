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
public class Cliente {
    
    private double inicio;
    private double fin;
    
    public Cliente(double inicio){
        this.inicio = inicio;
        this.fin = -1;
    }

    public void setInicio(double inicio) {
        this.inicio = inicio;
    }

    public void setFin(double fin) {
        this.fin = fin;
    }

    public double getInicio() {
        return inicio;
    }

    public double getFin() {
        return fin;
    }
    
}
