/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.envelopes;

import br.ufsc.ine5605.sistemacontroleacesso.Cargo;
import br.ufsc.ine5605.sistemacontroleacesso.Gerente;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;

/**
 *
 * @author Pablo
 */
public class EnvelopeCargo {
	public String codigo;
	public String nome;
    public boolean ehGerente;
	
	public EnvelopeCargo(String codigo, String nome, boolean ehGerente) {
            this.codigo = codigo;
            this.nome = nome;
            this.ehGerente = ehGerente;
	}
}
