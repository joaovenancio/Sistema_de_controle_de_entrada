/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PEaug
 */
public class CargoComAcesso extends Gerente{
    //Atributos
    /**
     * ArrayList que representa os horários que o cargo tem acesso a porta do 
     * Financeiro
     */
    private ArrayList<Calendar> arrayComHorarios= new ArrayList<Calendar>();

    public ArrayList<Calendar> getArrayComHorarios() {
		return arrayComHorarios;
	}

	public void setArrayComHorarios(ArrayList<Calendar> arrayComHorarios) {
		this.arrayComHorarios = arrayComHorarios;
	}

	//Construtor
    public CargoComAcesso(String codigo, String nome, Calendar inicio, Calendar fim) {
        super(codigo, nome);
        this.arrayComHorarios.add(inicio);
        this.arrayComHorarios.add(fim);
    }
    
    
}
