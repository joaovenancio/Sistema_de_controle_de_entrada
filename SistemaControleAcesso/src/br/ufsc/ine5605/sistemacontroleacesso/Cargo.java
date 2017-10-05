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
    protected String codigo;
    protected String nome;

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     *@return boolean - Retorna true se o cargo tem acesso e false caso contrario
     **/
    public boolean temAcesso(){
        return true;
    }
}
