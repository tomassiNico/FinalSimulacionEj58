/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.eventos;

/**
 *
 * @author xtoma
 */
public class FinCargaGasolina implements Evento{
    @Override
    public String tipoEvento() {
        return "gasolina";
    }
}
