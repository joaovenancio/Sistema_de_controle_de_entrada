/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorCargo;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeCargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
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
        while (opcao <= 3) {
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
            System.out.println("-#OPÇÃO:_____");
            System.out.println();

            opcao = this.teclado.nextInt();
            this.teclado.nextLine();

            switch (opcao) {
                case 1:

                    EnvelopeCargoSemAcesso envelope = this.criarCargoSemAcesso();
                    //try catch do controlador.addFuncionario
                    //Tratar dos erros de input que o usuario pode ter causado:
                    try {

                        this.controladorCargo.adicionarCargoSemAcesso(envelope);

                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");

                    }

                //case 2:
                //int matricula = this.removerFuncionario();
                //if (controlador.removerFuncionarioPelaMatricula(matricula)) {
                //    System.out.println("-Funcioario removido com sucesso!");
                //} else {
                //    System.out.println("-Funcionario nao encontrado pela");
                //    System.out.println("-matricula fornecida, nao foi");
                //    System.out.println("-possivel remove-lo");
                //}
                case 3:

                    this.listarCargos();
            }
        }
    }
    private EnvelopeCargoSemAcesso criarCargoSemAcesso() {
     System.out.println ("----------------------------------------");
        System.out.println ("-------------Novo Cargo-----------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira um nome:_________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Insira um código:___________________");
        String codigo = this.teclado.nextLine();
        this.teclado.nextLine();
        
        
        //Enveolpe cirado para adicionar a lista
        return new EnvelopeCargoSemAcesso(nome, codigo);
}

    public void listarCargos() {
        //Inicializar
        System.out.println("----------------------------------------");
        System.out.println("---------Listagem de Funcionarios-------");
        System.out.println("----------------------------------------");
        //Listagem dos funcionarios
        for (ICargo cargoLista : this.controladorCargo.getCargos()) {

            System.out.println("-Nome: " + cargoLista.getNome());
            System.out.println("-Matricula: " + cargoLista.getNome());
            System.out.println("-Telefone: " + cargoLista.getCodigo());
            System.out.println("----------------------------------------");
        }
    }
    
    
}
    




