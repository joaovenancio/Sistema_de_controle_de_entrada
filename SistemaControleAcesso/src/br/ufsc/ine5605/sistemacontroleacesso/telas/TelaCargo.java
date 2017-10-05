/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorCargo;
import java.util.Scanner;

/**
 *
 * @author PEaug
 */
public class TelaCargo {
    private ControladorCargo controladorCargo;
    private Scanner teclado;

    public TelaCargo(ControladorCargo controladorCargo, Scanner teclado) {
        this.controladorCargo = controladorCargo;
        this.teclado = new Scanner(System.in);
    }
    
    
    public void listarCargos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
