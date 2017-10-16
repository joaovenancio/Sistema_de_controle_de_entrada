/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorGeral;

/**
 *
 * @author PEaug
 */
public class SistemaControleAcesso {

    /**Método <b>MAIN</b> da Aplicação
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControladorGeral c1 = new ControladorGeral();
        c1.iniciarTela();
    }
    
}
