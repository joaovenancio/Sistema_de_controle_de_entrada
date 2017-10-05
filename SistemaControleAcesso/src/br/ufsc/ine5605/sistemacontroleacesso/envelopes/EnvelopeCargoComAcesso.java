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
public class EnvelopeCargoComAcesso {
	public String codigo;
	public String nome;
	public ICargo cargo;
	public int inicio;
	public int fim;
	
	public EnvelopeCargoComAcesso(String codigo, String nome, int inicio, int fim) {
		this.codigo = codigo;
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
	}
    
}
