/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaCargo;
//TODO:IMPLEMENTAR
/**
 *
 * @author PEaug
 */
public class ControladorCargo {
    private TelaCargo telaCargo;

    public ICargo getCargoByIndice(int indiceCargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TelaCargo getTelaCargo() {
        return this.telaCargo;
    }

    public void adicionarCargo(EnvelopeCargoSemAcesso envelope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
