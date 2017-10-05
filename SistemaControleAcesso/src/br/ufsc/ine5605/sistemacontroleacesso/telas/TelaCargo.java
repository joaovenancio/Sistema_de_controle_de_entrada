/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.Cargo;
import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorCargo;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargo;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;

import java.util.Scanner;
//TODO:IMPLEMENTAR

/**
 *
 * @author PEaug
 */
public class TelaCargo {

    private ControladorCargo controladorCargo;
    private Scanner teclado;

    public TelaCargo(ControladorCargo controladorCargo, Scanner teclado) {
        this.controladorCargo = controladorCargo;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        while (opcao <= 6) {
            System.out.println("----------------------------------------");
            System.out.println("--------------Cargos--------------");
            System.out.println("----------------------------------------");
            System.out.println("------------Escolha uma opÃ§Ã£o:----------");
            System.out.println();
            System.out.println("-1)Criar um novo Cargo Sem Acesso");
            System.out.println("-2)Criar um novo Cargo Com Acesso");
            System.out.println("-3)Criar um novo Cargo Gerente");
            System.out.println("-4)Remover Cargo pelo CÃ³digo");
            System.out.println("-5)Modificar Cargo");
            System.out.println("-6)Listar Cargos Existentes");
            System.out.println("-#OPÃ‡ÃƒO:_____");
            System.out.println();

            opcao = this.teclado.nextInt();
            this.teclado.nextLine();

            switch (opcao) {
                case 1:

                    EnvelopeCargoSemAcesso envelope = this.criarCargoSemAcesso();
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

                case 2:
                	 EnvelopeCargoComAcesso envelopeAcesso = this.criarCargoComAcesso();
                     //try catch do controlador.addCargo
                     //Tratar dos erros de input que o usuario pode ter causado:
                     try {

                         this.controladorCargo.adicionarCargo(envelopeAcesso);

                     } catch (IllegalArgumentException exception) {
                         System.out.println("########################################");
                         System.out.println("-" + exception.getMessage());
                         System.out.println("########################################");
                         System.out.println("-------------Tente novamente------------");

                     }
               
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
               
                case 4:
                    //try catch do controlador.removerCargo
                    //Tratar dos erros de input que o usuario pode ter causado:
                    EnvelopeCargo envelopeCargo= this.removerCargoByCodigo();
                    
                	try {

                        this.controladorCargo.removerCargo(envelopeCargo);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
               
                	
               
                case 5:
                    //try catch do controlador.removerCargo
                    //Tratar dos erros de input que o usuario pode ter causado:
                    EnvelopeCargo[] envelopeCargoMod=  this.modificarCargo();
                    
                	try {

                        this.controladorCargo.modificarCargo(envelopeCargoMod);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }
                	
                	
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
        this.teclado.nextLine();
        
        System.out.println ("Início do horário de acesso:_____________________");
        int inicio = this.teclado.nextInt();
        this.teclado.nextLine();
        System.out.println ("-Fim do horário de acesso:_____________________");
        int fim = this.teclado.nextInt();
        this.teclado.nextLine();
        
        //Envelope criado para adicionar a lista
        return new EnvelopeCargoComAcesso(codigo, nome, inicio, fim);
	}    

    private EnvelopeCargoSemAcesso criarCargoSemAcesso() {
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
        return new EnvelopeCargoSemAcesso(codigo, nome);
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
        return new EnvelopeCargo(codigo, nome);
    }
    
	private EnvelopeCargo removerCargoByCodigo() {
    	//Capturar os valores para remover o cargos
        System.out.println ("----------------------------------------");
        System.out.println ("----------------Remove Cargo--------------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira o código do cargo:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Nome do cargo:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        
        return new EnvelopeCargo(codigo, nome);

	}
	
    private EnvelopeCargo[] modificarCargo() {
    	//Capturar os valores para modificar o cargos
        System.out.println ("----------------------------------------");
        System.out.println ("----------------Modifica Cargo--------------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira o código do cargo a ser modificado:_________");
        String primeiroCodigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Insira o novo código do cargo:_________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Novo nome do cargo:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        EnvelopeCargo[] listaEnvelopeCargo= new EnvelopeCargo[2];
        
        listaEnvelopeCargo[0]= new EnvelopeCargo(primeiroCodigo, null);
        listaEnvelopeCargo[1]= new EnvelopeCargo(codigo, nome);
        
        return listaEnvelopeCargo;

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
