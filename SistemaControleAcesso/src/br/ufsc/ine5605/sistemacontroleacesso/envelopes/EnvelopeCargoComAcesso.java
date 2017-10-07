    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.envelopes;

import java.util.ArrayList;
import java.util.Calendar;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;

/**
 *
 * @author PEaug
 */
public class EnvelopeCargoComAcesso {
	public String codigo;
	public String nome;
	public ICargo cargo;

	public ArrayList<Calendar> arrayComHorarios;


	public EnvelopeCargoComAcesso(String codigo, String nome, Calendar inicio, Calendar fim) {
		this.codigo = codigo;
		this.nome = nome;
                this.arrayComHorarios = new ArrayList<>();
                
	}
    
}
