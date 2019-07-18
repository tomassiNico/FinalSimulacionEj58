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

    public GestorSimulacion(double desde, double hasta) {
        this.reloj = 0;
        this.colaGasolinera = 0;
        this.colaAccesorios = 0;
        this.colaGomeria = 0;
        this.mostrarDesde = desde;
        this.mostrarHasta = hasta;
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
        if (reloj == 0) {
            this.llegadaCliente.generarProximaLlegada(reloj);
        }
        else{
            
        }
    }
    
    private void proximoEvento(){
        double tiempoSigEvento = this.llegadaCliente.getProximaLlegada();
        String proximoEvento = "llegada";
        
    }
    
    
    public ArrayList historiaSimulacion(){
        return this.vectores;
    }
    
    
}
