    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.envelopes;

import java.util.ArrayList;
import java.util.Calendar;

//import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;

/**
 *
 * @author PEaug
 */
public class EnvelopeCargoComAcesso {
	public String codigo;
	public String nome;
//	public ICargo cargo;//Qual a necessidade desse atributo??
	public ArrayList<Calendar> arrayComHorarios;

        /*
        *@param String - Código do cargo a ser adicionado
        *@param String - Nome do cargo a ser criado
        *@param Calendar - Horário de ínicio de expediente do cargo
        *@param Calendar - Horário de final de expediente do cargo        
        */
	public EnvelopeCargoComAcesso(String codigo, String nome, Calendar inicio, Calendar fim, Calendar sInicio, Calendar sFim) {
		this.codigo = codigo;
		this.nome = nome;
        this.arrayComHorarios = new ArrayList<>();
        this.arrayComHorarios.add(inicio);
        this.arrayComHorarios.add(fim);
        this.arrayComHorarios.add(sInicio);
        this.arrayComHorarios.add(sFim);
                
	}
    
}
