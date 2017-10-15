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
            throw new IllegalArgumentException("C�digo do cargo jah cadastrado.");
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
            throw new IllegalArgumentException("Código do cargo já cadastrado");
		}
    }

    
    //*Remove cargo utilizando como par�metro um cargo
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
                throw new IllegalArgumentException("Cargo n�o cadastrado.");
    		}
    	}else{
            throw new IllegalArgumentException("Cargo n�o cadastrado.");
    	}
    }
    
    //*Modifica cargo utilizando como parametro o cargo a ser alterado e o codigo e nome
    public void modificarCargo(ICargo cargo, String codigo, String nome){
    	
    	if(cargo != null){
    		if (listaCargo.contains(cargo)){
    			cargo.setCodigo(codigo);
    			cargo.setNome(nome);

    			ArrayList<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
    			for(Funcionario func: listaFuncionario){
    				if (func.getCargo().equals(cargo)){
    				
    				}
    			}
    		}else{
                throw new IllegalArgumentException("Cargo nao cadastrado.");
    		}
    	}
    }
    
  //*Modifica cargo utilizando como par�metro o cargo a ser alterado e o codigo, nome e hor�rios
    public void modificarCargo(CargoComAcesso cargo, String codigo, String nome, ArrayList<Calendar> arrayHorarios){
    	
    	if(cargo != null){
    		if (listaCargo.contains(cargo)){
    			cargo.setCodigo(codigo);
    			cargo.setNome(nome);
    			cargo.setArrayComHorarios(arrayHorarios);
    			ArrayList<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
    			for(Funcionario func: listaFuncionario){
    				if (func.getCargo().equals(cargo)){
    				
    				}
    			}
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
		try{
			return this.listaCargo.get(indiceCargo);
		}catch(ArrayIndexOutOfBoundsException exception){
            throw new IllegalArgumentException("Índice acima do tamanho do array"); 
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

	public void listarCargos() {
		// TODO Auto-generated method stub
		 for (Cargo cargo : this.getListaCargo()){
	            
	            System.out.println ("-Nome: " + cargo.getNome());
	            System.out.println ("-Codigo: " + cargo.getCodigo());
	             
	            /* if (cargo instanceof CargoComAcesso){
	            	CargoComAcesso cargoAcesso= (CargoComAcesso) cargo;
	            	Calendar horario= cargoAcesso.getArrayComHorarios().get(0);
	            	
	            	System.out.println ("-Inicio do Acesso: " + horario.get(HOUR_OF_DAY) + ":" + horario.get(MINUTE);
	                System.out.println ("-Fim do Acesso: " + horario.get(HOUR_OF_DAY) + ":" + horario.get(MINUTE);
	            } */

	            System.out.println ("----------------------------------------");
	        }
		
	}
    
}
