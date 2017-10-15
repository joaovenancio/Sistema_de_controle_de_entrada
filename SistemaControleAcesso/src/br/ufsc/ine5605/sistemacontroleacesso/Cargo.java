/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;

/**
 *
 * @author PEaug
 */
public abstract class Cargo implements ICargo {
    /**
     * Atributo que representa o <b>código do Cargo</b>
     */
    protected String codigo;
    /**
     * Atributo que representa o <b>nome do Cargo</b>
     */
    protected String nome;

   /**Método para retorno do código do Cargo
    *@return String - Retorna o código do Cargo 
    */
    @Override
    public String getCodigo() {
        return codigo;
    }
    
   /**Método para retorno do nome do Cargo 
    *return String - Retorna o nome do Cargo
    */
    @Override
    public String getNome() {
        return nome;
    }
    
   /**Método para alteração do código do Cargo
    *@param codigo String - Código a ser setado no Cargo
    */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
   /**Método para alteração do Nome do Cargo
    *@param nome String - Nome a ser setado no Cargo 
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**Método que indica se o cargo possui acesso a Porta do Financeiro
     *@return boolean - Retorna true se o cargo tem acesso e false caso contrario
     */
    
    public boolean temAcesso(){
    	return true;
    }
}
