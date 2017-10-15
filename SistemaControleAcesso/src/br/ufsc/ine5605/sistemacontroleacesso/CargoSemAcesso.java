/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class CargoSemAcesso extends Cargo{

    public CargoSemAcesso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    /**
     *@return boolean - Retorna true se o cargo tem acesso e false caso contrario
     **/
	
    @Override
	public boolean temAcesso(Calendar horario) {
		return false;
	}
    
}
