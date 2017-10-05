/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorGeral {
    //Atributos:
    private ControladorFuncionario controladorFuncionario;
    private ControladorCargo controladorCargo;
    
    //Construtor:
    public ControladorGeral() {
        this.controladorCargo = new ControladorCargo(this);
        this.controladorFuncionario = new ControladorFuncionario(this);
    }
    
    //Metodos:
    public ControladorFuncionario getControladorFuncionario() {
        return controladorFuncionario;
    }

    public ControladorCargo getControladorCargo() {
        return controladorCargo;
    }
    
}
