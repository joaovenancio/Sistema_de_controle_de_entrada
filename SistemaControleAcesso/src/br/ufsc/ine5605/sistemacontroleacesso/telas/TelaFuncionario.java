package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorFuncionario;

/**
 *
 * @author Joao Vitor Venancio
 */
public class TelaFuncionario {
    //Atributos:
    private ControladorFuncionario controlador;
    
    //Construtor:
    public TelaFuncionario (ControladorFuncionario controlador) {
        this.controlador = controlador;
    }
    
    //Metodos:
    public void iniciaTela() {
        byte opcao = 0;
        while (opcao <= 3 ) {
            System.out.println ("----------------------------------------");
            System.out.println ("--------------Funcionarios--------------");
            System.out.println ("----------------------------------------");
            System.out.println ("------------Escolha uma opção:----------");
            System.out.println ();
            System.out.println ("-1)Cadastrar um funcionario");
            System.out.println ("-2)Remover um funcionario pela matricula");
            System.out.println ("-3)Listar os funcionarios cadastrados");
            System.out.println ("-#OPÇÃO:_____");
            System.out.println ();
            
        }
    }
}
