/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.AcontecimentoRegistro;
import br.ufsc.ine5605.sistemacontroleacesso.Registro;
import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorRegistros;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import java.util.Scanner;

/**
 *
 * @author PEaug
 */
public class TelaRegistro {

    /**
     * Controlador de registro responsável por essa tela
     */
    private ControladorRegistros controladorRegistros;
    /**
     * Scanner que capta a entrada do teclado
     */
    private Scanner teclado;

    public TelaRegistro(ControladorRegistros controlador) {
        this.controladorRegistros = controlador;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        while (opcao <= 3 && opcao >= 0) {
            System.out.println("----------------------------------------");
            System.out.println("--------------Registros--------------");
            System.out.println("----------------------------------------");
            System.out.println("------------Escolha uma opção:----------");
            System.out.println();
            System.out.println("-1)Buscar Acesso Negado por Acontecimento");
            System.out.println("-2)Buscar Acesso Negado por Matrícula");
            System.out.println("-3)Voltar");
            System.out.println("-#OPÇÃO:_____");
            System.out.println();

            opcao = this.inputDeIntTratado();
           

            switch (opcao) {

                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("-----Buscar Registro de Acesso Negado por Acontecimento----");
                    System.out.println("----------------------------------------");
                    System.out.println("-----Acontecimentos----");
                    this.listarAcontecimentos();
                    System.out.println("---Selecione um dos acontecimentos");
                    System.out.println("-#OPÇÃO:_____");
                    System.out.println();
                    int acontecimentoSelecionado;
                    acontecimentoSelecionado = this.inputDeIntTratado();
                    this.teclado.nextLine();                  
                    //Aqui começa o método de findRegistroByAcontecimento e o retorno já passa pelo foreach
                    for (Registro registroBusca
                            : this.controladorRegistros.findRegistroByAcontecimento(acontecimentoSelecionado)) {
                        //A partir daqui são printados: Acontecimento, Data do Acontecimento e Nº de Matrícula
                        System.out.println(registroBusca.getAcontecimento());
                        System.out.println(registroBusca.getDataAcontecimento().getTime());
                        System.out.println(registroBusca.getNumDeMatricula());
                    }
                    break;
                case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("-----Buscar Registro de Acesso Negado por Matrícula----");
                    System.out.println("----------------------------------------");
                    System.out.println("----------Matrículas ativas:");
                    System.out.println("------------------------------------------");
                    for (IFuncionario funcionarioLista : controladorRegistros.
                            getControladorGeral().getControladorFuncionario().getFuncionarios()) {

                        System.out.println("-Nome: " + funcionarioLista.getNome());
                        System.out.println("-Matricula: " + funcionarioLista.getNumeroDeMatricula());
                        System.out.println("---------------------------------------");
                    }
                    System.out.println("---Selecione um número de matrícula");
                    System.out.println("-#OPÇÃO:_____");
                    int numerodeMatriculaSelecionado;
                    numerodeMatriculaSelecionado = this.inputDeIntTratado();
                    this.teclado.nextLine();
                    for(Registro registroLista : 
                            controladorRegistros.findRegistroByMatricula(numerodeMatriculaSelecionado)){
                        System.out.println("------------");
                        System.out.println(registroLista.getAcontecimento());
                        System.out.println(registroLista.getDataAcontecimento());
                    }
                    break;
            }

        }

    }

    private void listarAcontecimentos() {
        for (AcontecimentoRegistro acontecimentoBusca : AcontecimentoRegistro.values()) {
            System.out.println("-" + acontecimentoBusca.ordinal() + ")" + acontecimentoBusca.toString());
        }
    }
    
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
