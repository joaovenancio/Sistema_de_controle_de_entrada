/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.Cargo;
import br.ufsc.ine5605.sistemacontroleacesso.CargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.CargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.Gerente;
import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorCargo;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargo;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;

import java.util.Calendar;
import java.util.Scanner;
//TODO:IMPLEMENTAR

/**
 *
 * @author PEaug
 */
public class TelaCargo {

    private ControladorCargo controladorCargo;
    private Scanner teclado;

    public TelaCargo(ControladorCargo controladorCargo) {
        this.controladorCargo = controladorCargo;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        while (opcao <= 7) {
            System.out.println("----------------------------------------");
            System.out.println("--------------Cargos--------------");
            System.out.println("----------------------------------------");
            System.out.println("------------Escolha uma opção:----------");
            System.out.println();
            System.out.println("-1)Criar um novo Cargo Sem Acesso");
            System.out.println("-2)Criar um novo Cargo Com Acesso");
            System.out.println("-3)Criar um novo Cargo Gerente");
            System.out.println("-4)Remover Cargo pelo Código");
            System.out.println("-5)Modificar Cargo");
            System.out.println("-6)Listar Cargos Existentes");
            System.out.println("-7)Voltar");
            System.out.println("-#OPÇÃO:_____");
            System.out.println();

            opcao = this.teclado.nextInt();
            this.teclado.nextLine();

            switch (opcao) {
                case 1:

                    EnvelopeCargo envelope = this.criarCargoSemAcesso();
                    //try catch do controlador.addCargo
                    //Tratar dos erros de input que o usuario pode ter causado:
                    try {

                        this.controladorCargo.adicionarCargo(envelope);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                    break;

                case 2:
                	 EnvelopeCargoComAcesso envelopeAcesso = this.criarCargoComAcesso();
                     //try catch do controlador.addCargo
                     //Tratar dos erros de input que o usuario pode ter causado:
                     try {

//                         this.controladorCargo.adicionarCargo(envelopeAcesso);

                     } catch (IllegalArgumentException exception) {
                         System.out.println("########################################");
                         System.out.println("-" + exception.getMessage());
                         System.out.println("########################################");
                         System.out.println("-------------Tente novamente------------");

                     }
                     break;
                     
                case 3:
                	EnvelopeCargo envelopeGerente = this.criarCargoGerente();
                    //try catch do controlador.addCargo
                    //Tratar dos erros de input que o usuario pode ter causado:
                    try {

                        this.controladorCargo.adicionarCargo(envelopeGerente);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                    break;
                    
                case 4:
                    //try catch do controlador.removerCargo
                    //Tratar dos erros de input que o usuario pode ter causado:
                    ICargo ICargo= this.removerCargoByCodigo();
                    
                	try {

                        this.controladorCargo.removerCargo(ICargo);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                    break;                	
               
                case 5:
                    //try catch do controlador.removerCargo
                    //Tratar dos erros de input que o usuario pode ter causado:
                    
                	//Retorna o cargo a ser modificado
                	ICargo modCargo=  this.modificarCargo();
                    
                   //Verifica qual o tipo de cargo a ser modificado 
                	try {
                		if (modCargo instanceof CargoSemAcesso){
                			EnvelopeCargo modEnvelope= this.criarCargoSemAcesso();
                			controladorCargo.modificarCargo(modCargo, modEnvelope.codigo,
                					modEnvelope.nome);
                			
                		}else if(modCargo instanceof CargoComAcesso){
                			EnvelopeCargoComAcesso modEnvelope= this.criarCargoComAcesso();
                			CargoComAcesso cargoComAcesso= (CargoComAcesso) modCargo;
                			
                			controladorCargo.modificarCargo(cargoComAcesso, modEnvelope.codigo,
                					modEnvelope.nome, modEnvelope.arrayComHorarios);
                			
                		}else{
                			EnvelopeCargo modEnvelope= this.criarCargoGerente();
                			controladorCargo.modificarCargo(modCargo, modEnvelope.codigo,
                					modEnvelope.nome);
                		}

                		

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                    break;
              	
                case 6:

                    this.listarCargos();
                }
                break;
        }
    }
    
    
	private EnvelopeCargoComAcesso criarCargoComAcesso() {
    	//Capturar os valores para criar os cargos
        System.out.println ("----------------------------------------");
        System.out.println ("----------------Novo Cargo--------------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira o código do cargo:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Nome do cargo:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("In�cio do horário de acesso - hora:_____________________");
        int inicioHora = this.teclado.nextInt();
        this.teclado.nextLine();
        
        System.out.println ("Início do horário de acesso - minuto:_____________________");
        int inicioMinuto = this.teclado.nextInt();
        this.teclado.nextLine();
        
        System.out.println ("-Fim do horário de acesso - hora:_____________________");
        int fimHora = this.teclado.nextInt();
        this.teclado.nextLine();
        
        System.out.println ("Fim do horário de acesso - minuto:_____________________");
        int fimMinuto = this.teclado.nextInt();
        this.teclado.nextLine();
        
        Calendar calendarioInicio= Calendar.getInstance();
        calendarioInicio.clear();
        calendarioInicio.set(Calendar.HOUR, inicioHora);
        calendarioInicio.set(Calendar.MINUTE, inicioMinuto);
        
        Calendar calendarioFim= Calendar.getInstance();
        calendarioFim.clear();
        calendarioFim.set(Calendar.HOUR, fimHora);
        calendarioFim.set(Calendar.MINUTE, fimMinuto);

        
        //Envelope criado para adicionar a lista
        return new EnvelopeCargoComAcesso(codigo, nome, calendarioInicio, calendarioFim);
	}    

    private EnvelopeCargo criarCargoSemAcesso() {
    	//Capturar os valores para criar os cargos
        System.out.println ("----------------------------------------");
        System.out.println ("----------------Novo Cargo--------------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira o código do cargo:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Nome do cargo:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        //Envelope criado para adicionar a lista
        return new EnvelopeCargo(codigo, nome, false);
    }
    
    private EnvelopeCargo criarCargoGerente() {
		// TODO Auto-generated method stub
    	//Capturar os valores para criar os cargos
        System.out.println ("----------------------------------------");
        System.out.println ("----------------Novo Cargo--------------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira o código do cargo:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Nome do cargo:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        //Envelope criado para adicionar a lista
        return new EnvelopeCargo(codigo, nome, true);
    }
    
	private ICargo removerCargoByCodigo() {
    	//Capturar os valores para remover o cargos
        System.out.println ("----------------------------------------");
        System.out.println ("---------------Remove Cargo-------------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira o código do cargo:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();

        return this.controladorCargo.findCargoByCodigo(codigo);
        
	}
	
    private ICargo modificarCargo() {
    	//Lista os cargos
    	this.listarCargos();
    	
    	System.out.println ("-Insira o código do cargo a ser modificado:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        return this.controladorCargo.findCargoByCodigo(codigo);
    }
	
    
	public void listarCargos() {
        System.out.println ("----------------------------------------");
        System.out.println ("------------Listagem de Cargos----------");
        System.out.println ("----------------------------------------");
        //Listagem dos cargos
        for (Cargo cargo : this.controladorCargo.getListaCargo()){
            
            System.out.println ("-Nome: " + cargo.getNome());
            System.out.println ("-Codigo: " + cargo.getCodigo());

            System.out.println ("----------------------------------------");
        }
    }

}
