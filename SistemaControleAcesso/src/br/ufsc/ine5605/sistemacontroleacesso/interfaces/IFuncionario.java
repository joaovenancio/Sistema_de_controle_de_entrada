/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.interfaces;

/**
 *
 * @author Joao Vitor Venancio
 */
public interface IFuncionario {
    /**
     * 
     * @return 
     */
    public int getNumeroDeMatricula();
    
    /**Método que retorna o número de telefone do funcionario
     * 
     * @return - número de telefone do funcionario
     */
    public String getTelefone();

    /**
     *  
     * @return 
     */
    public String getNome();
    
    /**Método que retorna o salário do funcionario
     * 
     * @return salário do funcionario
     */
    public int getSalario();
}
