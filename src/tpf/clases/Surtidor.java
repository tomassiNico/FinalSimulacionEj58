/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

import distribuciones.Uniforme;
import java.util.Random;

/**
 *
 * @author xtoma
 */
public class Surtidor implements SimuladorServicio{
    
    private double inicioAtencion;
    private double finAtencion;
    private boolean ocupado;
    private Cliente cliente;
    
    public Surtidor(){
        this.inicioAtencion = -1;
        this.finAtencion = -1;
        this.ocupado = false;
        this.cliente = null;
    }
    
    public Surtidor(double inicio){
        this.inicioAtencion = inicio;
        this.finAtencion = -1;
        this.ocupado = true;
        this.cliente = new Cliente(inicio);
    }
    
    
    public void desocupar(){
        this.inicioAtencion = -1;
        this.finAtencion = -1;
        this.ocupado = false;
        this.cliente = null;
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

    @Override
    public void calcularTiempoAtencion(double reloj) {
        String sevicio = "Gasolinera";
        
        Random generadorRnd = new Random();
        double rnd = generadorRnd.nextDouble();
        double inf = 45.0/60.0;
        double sup = 55.0/60.0;
        Uniforme distUni = new Uniforme(inf, sup);
        double tiempoAtencion = distUni.generarNumero(rnd);
        this.inicioAtencion = reloj;
        this.finAtencion =  reloj + tiempoAtencion;
        
        TiempoAtencion tiempo = TiempoAtencion.getInstance();
        tiempo.setRnd(rnd);
        tiempo.setServicio(sevicio);
        tiempo.setTiempoAtencion(tiempoAtencion);
        tiempo.setFinAtencion(this.finAtencion); 
    }
    
    public boolean estaOcupado(){
        return this.ocupado;
    }

    public void ocupar(){
        this.ocupado = true;
    }
    
    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void atenderCliente(Cliente cli) {
        this.cliente = cli;
        cli.setAtendido(true);
    }
    
    public String getClienteAtencion(){
        if (cliente == null) {
            return "";
        }
        return String.valueOf(cliente.getNumCliente());
    }
}
