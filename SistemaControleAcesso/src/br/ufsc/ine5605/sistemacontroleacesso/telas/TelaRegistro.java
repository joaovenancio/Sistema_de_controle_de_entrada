/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.AcontecimentoRegistro;
import br.ufsc.ine5605.sistemacontroleacesso.Registro;
import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorRegistros;
import java.util.Scanner;

/**
 *
 * @author PEaug
 */
public class TelaRegistro {
    /**
     * Controlador de registro responsável por essa tela
     */
    private ControladorRegistros controladorRegistros ;
    /**
     * Scanner que capta a entrada do teclado
     */
    private Scanner teclado;
    
    public TelaRegistro(ControladorRegistros controlador){
        this.controladorRegistros = controlador;
        this.teclado = new Scanner(System.in);
    }
    
    public void iniciar(){
        int opcao = 0;
        while (opcao <= 6) {
            System.out.println("----------------------------------------");
            System.out.println("--------------Registros--------------");
            System.out.println("----------------------------------------");
            System.out.println("------------Escolha uma opção:----------");
            System.out.println();
            System.out.println("-1)Buscar Acesso Negado por Acontecimento");
            System.out.println("-2)Buscar Acesso Negado por Matrícula");
            System.out.println("-6)Voltar");
            System.out.println("-#OPÇÃO:_____");
            System.out.println();

            opcao = this.teclado.nextInt();
            this.teclado.nextLine();
            
            switch(opcao){
                
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("-----Buscar Registro por Acontecimento----");
                    System.out.println("----------------------------------------");
                    System.out.println("-----Acontecimentos----");
                    this.listarAcontecimentos();
                    System.out.println("---Selecione um dos acontecimentos");
                    System.out.println("-#OPÇÃO:_____");
                    System.out.println();
                    int acontecimentoSelecionado; 
                    acontecimentoSelecionado = this.teclado.nextInt();
                    this.teclado.nextLine();
                    //TODO: Terminar a implementação com a busca no Array de Retorno
                    this.controladorRegistros.findAcontecimentoByIndice(acontecimentoSelecionado);
                            break;
                    }
            
                    
            }
    
        } 

    private void listarAcontecimentos() {
        for(AcontecimentoRegistro acontecimentoBusca : AcontecimentoRegistro.values()){
            System.out.println( "-"+acontecimentoBusca.ordinal() +")" + acontecimentoBusca.toString());
        }
    }
}

