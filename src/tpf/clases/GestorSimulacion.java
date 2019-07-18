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
    private int colaGasolinera;
    private int colaAccesorios;
    private int colaGomeria;
    private LlegadaCliente llegadaCliente;
    private Servicio servicioSolicitado;
    private TiempoAtencion tiempoAtencion;
    private Surtidor surtidor1;
    private Surtidor surtidor2;
    private Surtidor surtidor3;
    private Gomeria  gomero1;
    private Gomeria  gomero2;
    private VentaAccesorio accesorio;
    private ArrayList<Cliente> clientes;
    private VectorEstado vector;
    private ArrayList<VectorEstado> vectores;

    public GestorSimulacion() {
        this.reloj = 0;
        this.colaGasolinera = 0;
        this.colaAccesorios = 0;
        this.colaGomeria = 0;
        this.llegadaCliente = new LlegadaCliente();
        this.servicioSolicitado = new Servicio();
        this.tiempoAtencion = TiempoAtencion.getInstance();
        this.surtidor1 = new Surtidor();
        this.surtidor2 = new Surtidor();
        this.surtidor3 = new Surtidor();
        this.gomero1 = new Gomeria();
        this.gomero2 = new Gomeria();
        this.accesorio = new VentaAccesorio();
        this.clientes = new ArrayList();
        this.vector = new VectorEstado();
    }
    
    
}
