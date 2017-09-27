package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
//Calendar ou date?
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Joao Vitor Venancio
 */
public class TelaFuncionario {
    //Atributos:
    private ControladorFuncionario controlador;
    private Scanner teclado;
    
    //Construtor:
    public TelaFuncionario (ControladorFuncionario controlador) {
        this.controlador = controlador;
    }
    
    //Metodos:
    public void iniciaTela() {
        int opcao = 0;
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
            
            opcao = this.teclado.nextInt();
            
            switch (opcao) {
                case 1:
                    EnvelopeFuncionario envelope = this.cadastrarFuncionario();
                    //try catch do controlador.addFuncionario
                    //Tratar dos erros de input que o usuario pode ter causado:
            }
        }
    }

    private EnvelopeFuncionario cadastrarFuncionario() {
        //Capturar os valores para criar os funcionarios
        System.out.println ("----------------------------------------");
        System.out.println ("-------------Novo Funcionario-----------");
        System.out.println ("----------------------------------------");
        
        System.out.println ("-Insira um numero de matricula:_________");
        int numeroDeMatricula = this.teclado.nextInt();
        this.teclado.nextLine();
        
        System.out.println ("-Nome do funcionario:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        //Aqui fica os inputs para a data de nascimento, esperar a implementacao
        //do Calendar
        System.out.println ("-:______________________________________");
        Date dataDeNascimento = new Date();
        this.teclado.nextLine();
        //
        
        System.out.println ("-Telefone do funcionario:_______________");
        String telefone = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Salario:_______________________________");
        int salario = this.teclado.nextInt();
        this.teclado.nextLine();
        
        //Enveolpe cirado para adicionar a lista
        return new EnvelopeFuncionario(numeroDeMatricula, nome, dataDeNascimento,
        telefone, salario);
    }
}
