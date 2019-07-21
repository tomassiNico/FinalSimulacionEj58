/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Cliente> clientes;
    private VectorEstado vector;
    private ObservableList<VectorEstado> vectores;
    
    
    private double tiempoMaxCliente;
    private int cliConCompra;
    private int colaMaxGasolinera;
    private int colaMaxGomeria;
    private int colaMaxAccesorio;
    

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
        this.clientes = FXCollections.observableArrayList();
        this.vectores = FXCollections.observableArrayList();
        this.tiempoMaxCliente = 0;
        this.cliConCompra = 0;
        this.colaMaxAccesorio = 0;
        this.colaMaxGasolinera = 0;
        this.colaMaxGomeria = 0;
    }
    
    public ObservableList<VectorEstado> getEstados(){
        return this.vectores;
    }
    
    public void simular(){
        this.vectores.clear();
        this.llegadaCliente.generarProximaLlegada(reloj);
        
        while(reloj < tiempoSimulacion){
            
            this.vector = new VectorEstado(reloj, colaGasolinera, surtidor1, surtidor2, surtidor3, colaGomeria, gomero1, gomero2, colaAccesorios, accesorio, servicioSolicitado, llegadaCliente, colaMaxAccesorio, colaMaxGomeria, colaMaxGasolinera, cliConCompra, clientes.size(), tiempoMaxCliente);
            vectores.add(vector);
            resetearDatos();
            
            double proximoEvento = proximoEvento();
            this.reloj = proximoEvento;
            
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
    
    private void resetearDatos(){
        llegadaCliente.resetear();
        servicioSolicitado.resetear();
    }
    
    private void simularFinAccesorio(){
        Cliente cli = accesorio.getCliente();
        cli.salirSistema(reloj);
        cli.comprar();
        cliConCompra ++;
        accesorio.desocupar();
        if (tiempoMaxCliente < cli.getPermanencia()) {
                    tiempoMaxCliente = cli.getPermanencia();
            }
        if (colaAccesorios == 0) {
            accesorio.desocupar();
        }
        else{
            colaAccesorios --;
            accesorio.calcularTiempoAtencion(reloj);
            accesorio.ocupar();
        }
    }
        
    private void simularFinGomeria(Gomeria gom){
        Cliente cli = gom.getCliente();
        cli.salirSistema(reloj);
        gom.desocupar();
        if (tiempoMaxCliente < cli.getPermanencia()) {
                    tiempoMaxCliente = cli.getPermanencia();
            }
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
        Cliente cli = sur.getCliente();
        sur.desocupar();

        if (servicioSolicitado.getOtroServicio() == "Gomeria") {
            simularLlegadaGomeria(cli);
        }
        else{
            if (servicioSolicitado.getOtroServicio() == "Accesorio") {
                simularLlegadaAccesorio(cli);
            }
            else{
                cli.salirSistema(reloj);
                if (tiempoMaxCliente < cli.getPermanencia()) {
                    tiempoMaxCliente = cli.getPermanencia();
                }
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
        Cliente cli = new Cliente(reloj);
        this.clientes.add(cli);
        
        if (servicioSolicitado.esGasolina()) {
            simularLlegadaGasolinera(cli);
        }
        else{
            if (servicioSolicitado.getOtroServicio() == "Gomeria") {
                simularLlegadaGomeria(cli);
            }
            if (servicioSolicitado.getOtroServicio() == "Accesorio") {
                simularLlegadaAccesorio(cli);
            }
        }
        
        this.llegadaCliente.generarProximaLlegada(reloj);
    }
    
    private void simularLlegadaAccesorio(Cliente cli){
        if (!accesorio.estaOcupado()) {
            accesorio.calcularTiempoAtencion(reloj);
            accesorio.ocupar();
            accesorio.atenderCliente(cli);
        }
        else{
            colaAccesorios ++;
            if (colaAccesorios > colaMaxAccesorio) {
                colaMaxAccesorio = colaAccesorios;
            }
        }
    }
    
    private void simularLlegadaGomeria(Cliente cli){
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
            gomDesocupada.atenderCliente(cli);
        }
        else{
            colaGomeria ++;
            if (colaGomeria > colaMaxGomeria) {
                colaMaxGomeria = colaGomeria;
            }
        }
    }
    
    private void simularLlegadaGasolinera(Cliente cli){
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
            surDesocupado.atenderCliente(cli);
        }
        else{
            colaGasolinera ++;
            if (colaGasolinera > colaMaxGasolinera) {
                colaMaxGasolinera = colaGasolinera;
            }
            TiempoAtencion.getInstance().resetear();
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
    
    private void finalizarAtencionCliente(Cliente cli){
        cli.setFin(reloj);
        
        double tiempoPermanencia = cli.getFin() - cli.getInicio(); 
        
        if (tiempoMaxCliente < tiempoPermanencia) {
            tiempoMaxCliente = tiempoPermanencia;
        }
    }
    
    public ObservableList<Cliente> getClientes(){
        return this.clientes;
    }
    
    public double getReloj(){
        return this.reloj;
    }
}
