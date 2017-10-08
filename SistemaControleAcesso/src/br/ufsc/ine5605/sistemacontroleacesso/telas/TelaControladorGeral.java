/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorGeral;
import java.util.Scanner;

/**
 *
 * @author PEaug
 */
public class TelaControladorGeral {
    //Atributos
    private ControladorGeral controladorGeral;
    private Scanner teclado;
    
    //Construtor
    public TelaControladorGeral(ControladorGeral controladorGreal) {
        this.controladorGeral = controladorGeral;
        this.teclado = new Scanner(System.in);
    }
    
    //Metodos:
    /**
     * Mostra uma interface grafica para o usuario interagir. Nele se pode selecionar
     * o que quer fazer dentro do sistema de controle de acesso.
     */
    public void iniciar() {
        int opcao = 0;
        while (opcao <= 4 && opcao >= 0) {
            System.out.println ("----------------------------------------");
            System.out.println ("------SISTEMA DE CONTROLE DE ACESSO-----");
            System.out.println ("----------------------------------------");
            System.out.println ("------------Escolha uma opção:----------");
            System.out.println ();
            System.out.println ("-1)Gerenciar Cargos");
            System.out.println ("-2)Gerenciar Funcionarios");
            System.out.println ("-3)Gerenciar Registros");
            System.out.println ("-4)Usar a Porta");
            System.out.println ("-#OPÇÃO:_____");
            System.out.println ();
            
            opcao = this.teclado.nextInt();
            this.teclado.nextLine();
            
            switch(opcao) {
                
                case 1:
                    this.controladorGeral.getControladorCargo().iniciarTela();
                    break;
                    
                case 2:
                    this.controladorGeral.getControladorFuncionario().iniciarTela();
                    break;
                
                case 3:
                    this.controladorGeral.getControladorRegistros().iniciarTela();
                    break;
                    
                case 4:
                    this.controladorGeral.getControladorPortaFinanceiro().iniciarTela();
                    break;
                 
            }
        }
    }
}
