/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaCargo;
import java.util.ArrayList;
//TODO:IMPLEMENTAR
/**
 *
 * @author PEaug
 */
public class ControladorCargo {
    private TelaCargo telaCargo;
    private ArrayList<ICargo> arrayDeCargos;

    public ControladorCargo() {
        this.arrayDeCargos = new ArrayList<>();
    }   

    public ICargo getCargoByIndice(int indiceCargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TelaCargo getTelaCargo() {
        return this.telaCargo;
    }

    public ArrayList<ICargo> getArrayDeCargos() {
        return arrayDeCargos;
    }

    public void setArrayDeCargos(ArrayList<ICargo> arrayDeCargos) {
        this.arrayDeCargos = arrayDeCargos;
    }
    
    

    public void adicionarCargoSemAcesso(EnvelopeCargoSemAcesso envelope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<ICargo> getCargos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
