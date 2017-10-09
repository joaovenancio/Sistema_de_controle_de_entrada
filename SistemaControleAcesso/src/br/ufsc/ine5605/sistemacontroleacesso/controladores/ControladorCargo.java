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
    
    //* Adiciona cargo Gerente ou CargoSemAcesso.
    public void adicionarCargo(EnvelopeCargo envelope){
    	boolean existeCodigo = false;
    	boolean existeNome= false;
		
    	//Verifica se existe cargo com mesmo codigo ou nome
    	for(Cargo cargoArray: listaCargo){
			if (cargoArray.getCodigo() == envelope.codigo){
				existeCodigo = true;
			}
			if (cargoArray.getNome() == envelope.nome){
				existeNome = true;
			} 
    	}
	
    	if (! existeCodigo){
    		if(! existeNome){
		    	if (envelope.ehGerente){
		    		Gerente cargo= new Gerente(envelope.codigo, envelope.nome);
		    		
		    		if(cargo != null){
		    			listaCargo.add(cargo);
		        	}
		    	}else{
		    		CargoSemAcesso cargo = new CargoSemAcesso(envelope.codigo, envelope.nome); 
		    		
		    		if(cargo != null){
		    			listaCargo.add(cargo);
		        	}
		    	}
	    	}else{
	            throw new IllegalArgumentException("Nome do cargo jah cadastrado.");
			}	
		}else{
            throw new IllegalArgumentException("Código do cargo jah cadastrado.");
		}
    }

    
    //* Adiciona cargos com acesso - CargoComAcesso.
    public void adicionarCargo(EnvelopeCargoComAcesso envelope){
    	boolean existeCodigo = false;
    	boolean existeNome= false;
    	
    	for(Cargo cargoArray: listaCargo){
			if (cargoArray.getCodigo() == envelope.codigo){
				existeCodigo = true;
			}
			
			if (cargoArray.getNome() == envelope.nome){
				existeNome = true;
			} 
    	}
    	
    	if (! existeCodigo){
    		if(! existeNome){
    	    	CargoComAcesso cargo= new CargoComAcesso(envelope.codigo, envelope.nome, 
						envelope.arrayComHorarios.get(0), envelope.arrayComHorarios.get(1));
		    		
	    		if(cargo != null){
	    			listaCargo.add(cargo);
	    		}
	    	}else{
	            throw new IllegalArgumentException("Nome do cargo jah cadastrado.");
			}	
		}else{
            throw new IllegalArgumentException("Código do cargo jah cadastrado.");
		}
    }

    
    //*Remove cargo utilizando como parâmetro um cargo
    public void removerCargo(ICargo cargo){
    	if(cargo != null){
    		if (listaCargo.contains(cargo)){
    			ArrayList<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
    			for(Funcionario funcio: listaFuncionario){
    				if (funcio.getCargo().equals(cargo)){
    					funcio.setCargo(null);
    				}
    			}
    			listaCargo.remove(cargo);
    		}else{
                throw new IllegalArgumentException("Cargo não cadastrado.");
    		}
    	}else{
            throw new IllegalArgumentException("Cargo não cadastrado.");
    	}
    }
    
    //*Modifica cargo utilizando como parâmetro o cargo a ser alterado e o cargo alterador
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
     * @return String - Status da operaÃ§Ã£o
     **/
  //  public String addHorario(Calendar horaInicio, Calendar horaFim){
        
  //      for(Calendar dataBuscando : this.arrayComHorarios){
  //          if(dataBuscando.get(Calendar.HOUR) == calendario.get(Calendar.HOUR)){
  //              if(dataBuscando.get(Calendar.MINUTE) == calendario.get(Calendar.MINUTE)){
  //                 return "HorÃ¡rio jÃ¡ adicionado para esse funcionÃ¡rio";
  //              }
  //          }
    //    }
      //  return "HorÃ¡rio adicionado com sucesso!";
    //}
    
    public ArrayList<Cargo> getListaCargo() {
		return listaCargo;
	}
    
    public TelaCargo getTelaCargo() {
		return telaCargo;
	}

    public ICargo findCargoByIndice(int indiceCargo) {
		try{
			return this.listaCargo.get(indiceCargo);
		}catch(ArrayIndexOutOfBoundsException exception){
            throw new IllegalArgumentException("Indice acima do tamanho do array"); 
		}
    }
    
    public ICargo findCargoByCodigo(String codigo) {
		for(Cargo cargo: this.listaCargo){
			if (cargo.getCodigo().equals(codigo)){
				return cargo;
			}
		}
		
		return null;
    }
    
}
