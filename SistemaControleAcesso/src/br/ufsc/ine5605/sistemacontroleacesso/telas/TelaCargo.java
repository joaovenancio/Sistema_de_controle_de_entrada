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
import java.util.Date;
import java.util.InputMismatchException;
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
                    try {
                        EnvelopeCargo envelope = this.criarCargoSemAcesso();
                        //try catch do controlador.addCargo
                        //Tratar dos erros de input que o usuario pode ter causado:

                        this.controladorCargo.adicionarCargo(envelope);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("- " + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                    break;

                case 2:
                	try {
                         //try catch do controlador.addCargo
                         //Tratar dos erros de input que o usuario pode ter causado:
                		 EnvelopeCargoComAcesso envelopeAcesso = this.criarCargoComAcesso();

                         this.controladorCargo.adicionarCargo(envelopeAcesso);

                     } catch (IllegalArgumentException exception) {
                         System.out.println("########################################");
                         System.out.println("- " + exception.getMessage());
                         System.out.println("########################################");
                         System.out.println("-------------Tente novamente------------");

                     }
                     break;
                     
                case 3:
                    try {
                    	EnvelopeCargo envelopeGerente = this.criarCargoGerente();
                        //try catch do controlador.addCargo
                        //Tratar dos erros de input que o usuario pode ter causado:

                        this.controladorCargo.adicionarCargo(envelopeGerente);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("- " + exception.getMessage());
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
                	
                    if (modCargo == null){
                    	System.out.println("Cargo não cadastrado.");
                    	break;
                    }
                    
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

                		

                    } catch (IllegalArgumentException | InputMismatchException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                    break;
              	
                case 6:

                    this.listarCargos();
                }
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
        while(! this.ehAlfabeto(nome)){
        	System.out.println("Insira um nome com apenas caracteres.");
             nome = this.teclado.nextLine();
        }
        this.teclado.nextLine();
        
        System.out.println ("Início do horário de acesso - apenas hora:_____________________");
        int inicioHora = this.inputDeIntTratado();
        
        System.out.println ("Início do horário de acesso - apenas minuto:_____________________");
        int inicioMinuto = this.inputDeIntTratado();
        
        System.out.println ("Fim do horário de acesso - apenas hora:_____________________");
        int fimHora = this.inputDeIntTratado();
        
        System.out.println ("Fim do horário de acesso - apenas minuto:_____________________");
        int fimMinuto = this.inputDeIntTratado();
        
        if (inicioHora < 0 || inicioHora > 24) {
            throw new IllegalArgumentException("Hora de início inserida inválida.");
            //Mes nao pode ser abaixo de 1 ou acima de 12
        } else if (inicioMinuto < 0 || inicioMinuto > 59) {
            throw new IllegalArgumentException("Minuto de início inserido inválido.");
            //O dia precisa ser maior do que 1 e menor do que 31
        } else if (fimHora < 0 || fimHora > 24) {
            throw new IllegalArgumentException("Hora de fim inserida inválida.");
        } else if (fimMinuto < 0 || fimMinuto > 59) {
            throw new IllegalArgumentException("Minuto de fim inserido inválido.");
        }        
        
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
        while(! this.ehAlfabeto(nome)){
        	System.out.println("Insira um nome com apenas caracteres.");
             nome = this.teclado.nextLine();
        }
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
        while(! this.ehAlfabeto(nome)){
        	System.out.println("Insira um nome com apenas caracteres.");
             nome = this.teclado.nextLine();
        }
        this.teclado.nextLine();
        
        //Envelope criado para adicionar a lista
        return new EnvelopeCargo(codigo, nome, true);
    }
    
	private ICargo removerCargoByCodigo() {
    	//Capturar os valores para remover o cargos
        System.out.println ("----------------------------------------");
        System.out.println ("--------------Remover Cargo-------------");
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
    
    //*Verifca se só tem letras
    public boolean ehAlfabeto(String name) {
        return name.matches("[a-zA-Z ]*");
    }
    
	public void listarCargos() {
        System.out.println ("----------------------------------------");
        System.out.println ("------------Listagem de Cargos----------");
        System.out.println ("----------------------------------------");
        
        //Listagem dos cargos
        this.controladorCargo.listarCargos();
    }
	
	   /**
     * Método que trata os inputs numericos, evitando que sejam colocados caracteres.
     * @return int  
     */
    private int inputDeIntTratado () {
        Scanner scannerDeTratamento = null;
        do {
            String inputDoUsuario = this.teclado.nextLine();
            scannerDeTratamento = new Scanner(inputDoUsuario);
            //"Esvaziar" o buffer do scanner:
            teclado.nextLine();
            if (!(scannerDeTratamento.hasNextInt())) {
                System.out.println("########################################");
                System.out.println("----ERRO DE INPUT: CARACTERES NAO SAO---");
                System.out.println("--------ACEITOS PARA ESSE CAMPO.--------");
                System.out.println("########################################");
                System.out.println("---------INSIRA UM VALOR VALIDO---------");
                System.out.println("########################################");
            }
        } while (!(scannerDeTratamento.hasNextInt()));
        //Caso estiver tudo ok: 
        int resultado = scannerDeTratamento.nextInt();
        scannerDeTratamento = null;
        return resultado;
    }

}
