/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.envelopes;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;

/**
 *
 * @author PEaug
 */
public class EnvelopeCargoSemAcesso {
	public String codigo;
	public String nome;
	public ICargo cargo;
	
	public EnvelopeCargoSemAcesso(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

}
