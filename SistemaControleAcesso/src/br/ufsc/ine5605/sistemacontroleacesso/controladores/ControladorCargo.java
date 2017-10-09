/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargo;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoComAcesso;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaCargo;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufsc.ine5605.sistemacontroleacesso.Cargo;
import br.ufsc.ine5605.sistemacontroleacesso.CargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.CargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.Gerente;
import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class ControladorCargo {
    private TelaCargo telaCargo;
    private ArrayList<Cargo> listaCargo;
    private ControladorGeral controladorGeral;

    public ControladorCargo(ControladorGeral controladorGeral){
    	this.controladorGeral= controladorGeral;
    	this.listaCargo= new ArrayList<Cargo>();
    	this.telaCargo= new TelaCargo(this);
    }

    public void iniciarTela () {
        this.telaCargo.iniciar();
    }
    
    public void adicionarCargo(EnvelopeCargo envelope){
		Gerente cargo= new Gerente(envelope.codigo, envelope.nome);

    	if(cargo != null){
    		if (! listaCargo.contains(cargo)){
    			listaCargo.add(cargo);
    		}else{
                throw new IllegalArgumentException("Cargo jah cadastrado.");
    		}	
    	}
    }
    
//    public void adicionarCargo(EnvelopeCargoComAcesso envelope){
//		CargoComAcesso cargo= new CargoComAcesso(envelope.codigo, envelope.nome, 
//				envelope.inicio, envelope.fim );
//    	if(cargo != null){
//    		if (! listaCargo.contains(cargo)){
//    			listaCargo.add(cargo);
//    		}else{
//                throw new IllegalArgumentException("Cargo jah cadastrado.");
//    		}
//    	}
//    }
    
    
    public void removerCargo(ICargo cargo){
    	if(cargo != null){
    		if (listaCargo.contains(cargo)){
    			ArrayList<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
    			for(Funcionario func: listaFuncionario){
    				if (func.getCargo().equals(cargo)){
    					
    				}
    			}
    			listaCargo.remove(cargo);
    		}else{
                throw new IllegalArgumentException("Cargo nao cadastrado.");
    		}
    	}
    }
    
    public void modificarCargo(EnvelopeCargo[] cargo){
    	if(cargo != null){
    		if (listaCargo.contains(cargo[0])){
    			cargo[0].codigo= cargo[1].codigo;
    			cargo[0].nome= cargo[1].nome;
    			ArrayList<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
    			for(Funcionario func: listaFuncionario){
    				if (func.getCargo().equals(cargo)){
    				
    				}
    			}
    			listaCargo.remove(cargo);
    		}else{
                throw new IllegalArgumentException("Cargo nao cadastrado.");
    		}
    	}
    }
    
    /**
     * @param horaInicio int - hora a ser adicionada no Array de horas
     * @param horaFim int - minutos a serem adicionados no Array de horas
     * @return String - Status da operação
     **/
  //  public String addHorario(Calendar horaInicio, Calendar horaFim){
        
  //      for(Calendar dataBuscando : this.arrayComHorarios){
  //          if(dataBuscando.get(Calendar.HOUR) == calendario.get(Calendar.HOUR)){
  //              if(dataBuscando.get(Calendar.MINUTE) == calendario.get(Calendar.MINUTE)){
  //                 return "Horário já adicionado para esse funcionário";
  //              }
  //          }
    //    }
      //  return "Horário adicionado com sucesso!";
    //}
    
    public ArrayList<Cargo> getListaCargo() {
		return listaCargo;
	}
    
    public TelaCargo getTelaCargo() {
		return telaCargo;
	}

    public ICargo findCargoByIndice(int indiceCargo) {
		return null;

    }
    
}
