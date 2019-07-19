/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

import java.util.ArrayList;
import tpf.eventos.LlegadaCliente;

/**
 *
 * @author nleguizamon
 */
public class GestorSimulacion {
    private double reloj;
    private double mostrarDesde;
    private double mostrarHasta;
    private double tiempoSimulacion;
    private int colaGasolinera;
    private int colaAccesorios;
    private int colaGomeria;
    private LlegadaCliente llegadaCliente;
    private Servicio servicioSolicitado;
    private TiempoAtencion tiempoAtencion;
    private Surtidor surtidor1;
    private Surtidor surtidor2;
    private Surtidor surtidor3;
    private ArrayList<Surtidor> surtidores;
    private Gomeria  gomero1;
    private Gomeria  gomero2;
    private ArrayList<Gomeria> gomeros;
    private VentaAccesorio accesorio;
    private ArrayList<Cliente> clientes;
    private VectorEstado vector;
    private ArrayList<VectorEstado> vectores;

    public GestorSimulacion(double tiempo, double desde, double hasta) {
        this.reloj = 0;
        this.colaGasolinera = 0;
        this.colaAccesorios = 0;
        this.colaGomeria = 0;
        this.mostrarDesde = desde;
        this.mostrarHasta = hasta;
        this.tiempoSimulacion = tiempo;
        this.llegadaCliente = new LlegadaCliente();
        this.servicioSolicitado = new Servicio();
        this.tiempoAtencion = TiempoAtencion.getInstance();
        this.surtidor1 = new Surtidor();
        this.surtidor2 = new Surtidor();
        this.surtidor3 = new Surtidor();
        this.surtidores = new ArrayList();
        this.surtidores.add(surtidor1);
        this.surtidores.add(surtidor2);
        this.surtidores.add(surtidor3);
        this.gomero1 = new Gomeria();
        this.gomero2 = new Gomeria();
        this.gomeros = new ArrayList();
        this.gomeros.add(gomero1);
        this.gomeros.add(gomero2);
        this.accesorio = new VentaAccesorio();
        this.clientes = new ArrayList();
        this.vector = new VectorEstado();
        this.vectores = new ArrayList();
    }
    
    public void simular(){
        this.llegadaCliente.generarProximaLlegada(reloj);
        
        while(reloj < tiempoSimulacion){
            double proximoEvento = proximoEvento();
            
            if (proximoEvento == llegadaCliente.getProximaLlegada()) {
                simularLlegadaCliente();
            }
            
            for (Surtidor sur: surtidores) {
                if (proximoEvento == sur.getFinAtencion()) {
                    simularFinGasolinera(sur);
                }
            }
            
            for (Gomeria gom: gomeros) {
                if (proximoEvento == gom.getFinAtencion()) {
                    simularFinGomeria(gom);
                }
            }
            
            if (proximoEvento == accesorio.getFinAtencion()) {
                simularFinAccesorio();
            }
        }
    }
    
    private void simularFinAccesorio(){
        
    }
    
    private void simularFinGomeria(Gomeria gom){
        if (colaGomeria == 0) {
            gom.desocupar();
        }
        else{
            colaGomeria --;
            gom.calcularTiempoAtencion(reloj);
            gom.ocupar();
        }
    }
    
    private void simularFinGasolinera(Surtidor sur){
        servicioSolicitado.servicioPosGasolinera();
        if (servicioSolicitado.getOtroServicio() == "Gomeria") {
            simularLlegadaGomeria();
        }
        else{
            if (servicioSolicitado.getOtroServicio() == "Accesorio") {
                simularLlegadaAccesorio();
            }
        }
        
        if (colaGasolinera == 0) {
            sur.desocupar();
        }
        else{
            colaGasolinera --;
            sur.calcularTiempoAtencion(reloj);
            sur.ocupar();
        }
    }
    
    private void simularLlegadaCliente(){
        this.servicioSolicitado.servicioSolicitado();
        
        if (servicioSolicitado.esGasolina()) {
            simularLlegadaGasolinera();
        }
        else{
            if (servicioSolicitado.getOtroServicio() == "Gomeria") {
                simularLlegadaGomeria();
            }
            if (servicioSolicitado.getOtroServicio() == "Accesorio") {
                simularLlegadaAccesorio();
            }
        }
    }
    
    private void simularLlegadaAccesorio(){
        if (!accesorio.estaOcupado()) {
            accesorio.calcularTiempoAtencion(reloj);
            accesorio.ocupar();
        }
        else{
            colaAccesorios ++;
        }
    }
    
    private void simularLlegadaGomeria(){
        Gomeria gomDesocupada = null;
        for (Gomeria gom: gomeros) {
            if (!gom.estaOcupado()) {
                gomDesocupada = gom;
                break;
            }
        }
        
        if (gomDesocupada != null) {
            gomDesocupada.calcularTiempoAtencion(reloj);
            gomDesocupada.ocupar();
        }
        else{
            colaGomeria ++;
        }
    }
    
    private void simularLlegadaGasolinera(){
        Surtidor surDesocupado = null;
        for (Surtidor sur: surtidores) {
            if (!sur.estaOcupado()) {
                surDesocupado = sur;
                break;
            }
        }
        
        if (surDesocupado != null) {
            surDesocupado.calcularTiempoAtencion(reloj);
            surDesocupado.ocupar();
        }
        else{
            colaGasolinera ++;
        }
        
    }
            
            
    private double proximoEvento(){
        double tiempoSigEvento = this.llegadaCliente.getProximaLlegada();
        
        for(Surtidor sur: surtidores){
            if (sur.getFinAtencion() < tiempoSigEvento && sur.getFinAtencion() != -1) {
                tiempoSigEvento = sur.getFinAtencion();
            }
        }
        
        for (Gomeria gom: gomeros) {
            if (gom.getFinAtencion() < tiempoSigEvento && gom.getFinAtencion() != -1) {
                tiempoSigEvento = gom.getFinAtencion();
            }
        }
        
        if (accesorio.getFinAtencion() < tiempoSigEvento && accesorio.getFinAtencion() != -1) {
                tiempoSigEvento = accesorio.getFinAtencion();
        }
        return tiempoSigEvento;
    }
    
    
    public ArrayList historiaSimulacion(){
        return this.vectores;
    }
    
    
}
