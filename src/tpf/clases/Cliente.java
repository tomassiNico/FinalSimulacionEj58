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
    private int numCliente;
    private boolean atendido;
    private double permanencia;
    private boolean compro;
    
    private static int seqCliente = 1; 
    
    public Cliente(double inicio){
        this.inicio = inicio;
        this.fin = -1;
        this.atendido = false;
        this.compro = false;
        this.numCliente = this.seqCliente;
        seqCliente++;
    }

    public void setInicio(double inicio) {
        this.inicio = inicio;
    }

    public void setFin(double fin) {
        this.fin = fin;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public double getPermanencia() {
        return Math.round(permanencia*10000.0)/10000.0;
    }

  
    public double getInicio() {
        return Math.round(inicio*10000.0)/10000.0;
    }

    public double getFin() {
        return Math.round(fin*10000.0)/10000.0;
    }
    
    public void salirSistema(double reloj){
        this.fin = reloj;
        this.permanencia = this.fin - this.inicio;
    }
    
    public void comprar(){
        this.compro = true;
    }
    
    public boolean hizoCompra(){
        return this.compro;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }
    
}
