/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

import tpf.eventos.LlegadaCliente;

/**
 *
 * @author nleguizamon
 */
public class VectorEstado {
    
    private double reloj;
    
    private double rnd1Ll;
    private double rnd2Ll;
    private double tiempoLl;
    private double proxLl;
    
    private double rndSer;
    private boolean gasolina;
    private double rndOtSer;
    private String otSer;
    
    private double rndTiAt;
    private double tiemAt;
    private double finAt;

    public double getReloj() {
        return reloj;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public String getRnd1Ll() {
        if (rnd1Ll == -1) {
            return "";
        }
        return String.valueOf(Math.round(rnd1Ll*10000.0)/10000.0);
    }

    public void setRnd1Ll(double rnd1Ll) {
        this.rnd1Ll = rnd1Ll;
    }

    public String getRnd2Ll() {
        if (rnd2Ll == -1) {
            return "";
        }
        return String.valueOf(Math.round(rnd2Ll*10000.0)/10000.0);
    }

    public void setRnd2Ll(double rnd2Ll) {
        this.rnd2Ll = rnd2Ll;
    }

    public String getTiempoLl() {
        if (tiempoLl == -1) {
            return "";
        }
        return String.valueOf(Math.round(tiempoLl*10000.0)/10000.0);
    }

    public void setTiempoLl(double tiempoLl) {
        this.tiempoLl = tiempoLl;
    }

    public double getProxLl() {
        return proxLl;
    }

    public void setProxLl(double proxLl) {
        this.proxLl = proxLl;
    }

    public String getRndSer() {
        if (rndSer == -1) {
            return "";
        }
        return String.valueOf(Math.round(rndSer*10000.0)/10000.0);
    }

    public void setRndSer(double rndSer) {
        this.rndSer = rndSer;
    }

    public String isGasolina() {
        if (rndSer == -1) {
            return "";
        }
        if (gasolina) {
            return "SI";
        }
        else{
            return "NO";
            
        }
    }

    public void setGasolina(boolean gasolina) {
        this.gasolina = gasolina;
    }

    public String getRndOtSer() {
        if (rndOtSer == -1) {
            return "";
        }
        return String.valueOf(Math.round(rndOtSer*10000.0)/10000.0);
    }

    public void setRndOtSer(double rndOtSer) {
        this.rndOtSer = rndOtSer;
    }

    public String getOtSer() {
        return otSer;
    }

    public void setOtSer(String otSer) {
        this.otSer = otSer;
    }

    public String getRndTiAt() {
        if (rndTiAt == -1) {
            return "";
        }
        return String.valueOf(Math.round(rndTiAt*10000.0)/10000.0);
    }

    public void setRndTiAt(double rndTiAt) {
        this.rndTiAt = rndTiAt;
    }

    public String getTiemAt() {
        if (tiemAt == -1) {
            return "";
        }
        return String.valueOf(Math.round(tiemAt*10000.0)/10000.0);
    }

    public void setTiemAt(double tiemAt) {
        this.tiemAt = tiemAt;
    }

    public String getFinAt() {
        if (finAt == -1) {
            return "";
        }
        return String.valueOf(Math.round(finAt*10000.0)/10000.0);
    }

    public void setFinAt(double finAt) {
        this.finAt = finAt;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public int getColaSur() {
        return colaSur;
    }

    public void setColaSur(int colaSur) {
        this.colaSur = colaSur;
    }

    public String getInSur1() {
        if (inSur1 == -1) {
            return "";
        }
        return String.valueOf(Math.round(inSur1*10000.0)/10000.0);
    }

    public void setInSur1(double inSur1) {
        this.inSur1 = inSur1;
    }

    public String getFinSur1() {
        if (finSur1 == -1) {
            return "";
        }
        return String.valueOf(Math.round(finSur1*10000.0)/10000.0);
    }

    public void setFinSur1(double finSur1) {
        this.finSur1 = finSur1;
    }

    public String getInSur2() {
        if (inSur2 == -1) {
            return "";
        }
        return String.valueOf(Math.round(inSur2*10000.0)/10000.0);
    }

    public void setInSur2(double inSur2) {
        this.inSur2 = inSur2;
    }

    public String getFinSur2() {
        if (finSur2 == -1) {
            return "";
        }
        return String.valueOf(Math.round(finSur2*10000.0)/10000.0);
    }

    public void setFinSur2(double finSur2) {
        this.finSur2 = finSur2;
    }

    public String getInSur3() {
        if (inSur3 == -1) {
            return "";
        }
        return String.valueOf(Math.round(inSur3*10000.0)/10000.0);
    }

    public void setInSur3(double inSur3) {
        this.inSur3 = inSur3;
    }

    public String getFinSur3() {
        if (finSur3 == -1) {
            return "";
        }
        return String.valueOf(Math.round(finSur3*10000.0)/10000.0);
    }

    public void setFinSur3(double finSur3) {
        this.finSur3 = finSur3;
    }

    public int getColaGom() {
        return colaGom;
    }

    public void setColaGom(int colaGom) {
        this.colaGom = colaGom;
    }

    public String getInGom1() {
        if (inGom1 == -1) {
            return "";
        }
        return String.valueOf(Math.round(inGom1*10000.0)/10000.0);
    }

    public void setInGom1(double inGom1) {
        this.inGom1 = inGom1;
    }

    public String getFinGom1() {
        if (finGom1 == -1) {
            return "";
        }
        return String.valueOf(Math.round(finGom1*10000.0)/10000.0);
    }

    public void setFinGom1(double finGom1) {
        this.finGom1 = finGom1;
    }

    public String getInGom2() {
        if (inGom2 == -1) {
            return "";
        }
        return String.valueOf(Math.round(inGom2*10000.0)/10000.0);
    }

    public void setInGom2(double inGom2) {
        this.inGom2 = inGom2;
    }

    public String getFinGom2() {
        if (finGom2 == -1) {
            return "";
        }
        return String.valueOf(Math.round(finGom2*10000.0)/10000.0);
    }

    public void setFinGom2(double finGom2) {
        this.finGom2 = finGom2;
    }

    public int getColaAcc() {
        return colaAcc;
    }

    public void setColaAcc(int colaAcc) {
        this.colaAcc = colaAcc;
    }

    public String getInAcc() {
        if (inAcc == -1) {
            return "";
        }
        return String.valueOf(Math.round(inAcc*10000.0)/10000.0);
    }

    public void setInAcc(double inAcc) {
        this.inAcc = inAcc;
    }

    public String getFinAcc() {
        if (finAcc == -1) {
            return "";
        }
        return String.valueOf(Math.round(finAcc*10000.0)/10000.0);
    }

    public void setFinAcc(double finAcc) {
        this.finAcc = finAcc;
    }

    public int getMaxAcc() {
        return maxAcc;
    }

    public void setMaxAcc(int maxAcc) {
        this.maxAcc = maxAcc;
    }

    public int getMaxGom() {
        return maxGom;
    }

    public void setMaxGom(int maxGom) {
        this.maxGom = maxGom;
    }

    public int getMaxSur() {
        return maxSur;
    }

    public void setMaxSur(int maxSur) {
        this.maxSur = maxSur;
    }

    public int getCompraron() {
        return compraron;
    }

    public void setCompraron(int compraron) {
        this.compraron = compraron;
    }

    public int getTotalCli() {
        return totalCli;
    }

    public void setTotalCli(int totalCli) {
        this.totalCli = totalCli;
    }
    private String ser;
    
    private int colaSur;
    private double inSur1;
    private double finSur1;
    private double inSur2;
    private double finSur2;
    private double inSur3;
    private double finSur3;
    
    private int colaGom;
    private double inGom1;
    private double finGom1;
    private double inGom2;
    private double finGom2;

    private int colaAcc;
    private double inAcc;
    private double finAcc;
    
    private int maxAcc;
    private int maxGom;
    private int maxSur;
    
    private int compraron;
    private int totalCli;
    
    private double maxPermanencia;

    public VectorEstado(double reloj, int colaSur, Surtidor s1, Surtidor s2, Surtidor s3, int colaGom, Gomeria g1, Gomeria g2, int colaAcc, VentaAccesorio a, Servicio ser, LlegadaCliente lle, int maxAcc, int maxGom, int maxSur, int compraron, int totalCli, double maxP) {
        this.reloj = reloj;
        this.colaSur = colaSur;
        this.colaGom = colaGom;
        this.colaAcc = colaAcc;
        this.maxAcc = maxAcc;
        this.maxGom = maxGom;
        this.maxSur = maxSur;
        this.compraron = compraron;
        this.totalCli = totalCli;
        this.inAcc = a.getInicioAtencion();
        this.inGom1 = g1.getInicioAtencion();
        this.inGom2 = g2.getInicioAtencion();
        this.inSur1 = s1.getInicioAtencion();
        this.inSur2 = s2.getInicioAtencion();
        this.inSur3 = s3.getInicioAtencion();
        this.finAcc = a.getFinAtencion();
        this.finGom1 = g1.getFinAtencion();
        this.finGom2 = g2.getFinAtencion();
        this.finSur1 = s1.getFinAtencion();
        this.finSur2 = s2.getFinAtencion();
        this.finSur3 = s3.getFinAtencion();
        this.finAt = TiempoAtencion.getInstance().getFinAtencion();
        this.tiemAt = TiempoAtencion.getInstance().getTiempoAtencion();
        this.rndTiAt = TiempoAtencion.getInstance().getRnd();
        this.ser = TiempoAtencion.getInstance().getServicio();
        this.rnd1Ll = lle.getRndLlegada1();
        this.rnd2Ll = lle.getRndLlegada2();
        this.tiempoLl = lle.getTiempoLlegada();
        this.proxLl = lle.getProximaLlegada();
        
        this.rndSer = ser.getRndGasolinera();
        this.gasolina = ser.esGasolina();
        this.rndOtSer = ser.getRndOtroServicio();
        this.otSer = ser.getOtroServicio();
        
        this.compraron = compraron;
        this.totalCli = totalCli;
        
        this.maxPermanencia = maxP;
        
    }

    public double getMaxPermanencia() {
        return Math.round(maxPermanencia*10000.0)/10000.0;
    }

    public void setMaxPermanencia(double maxPermanencia) {
        this.maxPermanencia = maxPermanencia;
    }
    
    
}
