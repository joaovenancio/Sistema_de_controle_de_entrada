package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
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
    /**
     * Mostra uma interface grafica para o usuario interagir. Nele ele pode selecionar
     * o que quer fazer sobre os funcionarios.
     */
    public void iniciar() {
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
            this.teclado.nextLine();
            
            switch (opcao) {
                case 1:
                    
                    EnvelopeFuncionario envelope = this.cadastrarFuncionario();
                    //try catch do controlador.addFuncionario
                    //Tratar dos erros de input que o usuario pode ter causado:
                    try {
                        
                        this.controlador.adicionarFuncionario(envelope);
                        
                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-" + exception.getMessage());
                        System.out.println("########################################");
                        System.out.println("-------------Tente novamente------------");
                        
                    }
                
                case 2:
                    
                    int matricula = this.removerFuncionario();
                    if (controlador.removerFuncionarioPelaMatricula(matricula)) {
                        System.out.println ("-Funcioario removido com sucesso!");
                    } else {
                        System.out.println ("-Funcionario nao encontrado pela");
                        System.out.println ("-matricula fornecida, nao foi");
                        System.out.println ("-possivel remove-lo");
                    }
                
                case 3:
                    
                    this.listarFuncionarios();
            }
        }
    }

    /**
     * Cria uma interface grafica para o usuario poder inserir os dados para a 
     * criacao de um Funcionario.
     * @return EnvelopeFuncionario com as informacoes coletadas via insercao
     * no console.
     */
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
        System.out.println ("-Dia do nascimento:_____________________");
        int dia = this.teclado.nextInt();
        this.teclado.nextLine();
        System.out.println ("-Mes do nascimento:_____________________");
        int mes = this.teclado.nextInt();
        this.teclado.nextLine();
        System.out.println ("-Ano do nascimento:_____________________");
        int ano = this.teclado.nextInt();
        this.teclado.nextLine();
        //
        
        System.out.println ("-Telefone do funcionario:_______________");
        String telefone = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Salario:_______________________________");
        int salario = this.teclado.nextInt();
        this.teclado.nextLine();
        
        
        //Associar um cargo a um funcionario:
        System.out.println ("-----Slecione o cargo do funcionario----");
        //Mostra os cargos
        this.controlador.getControladorGeral().getControladorCargo().getTela().listarCargos();
        //Input para selecionar o cargo
        System.out.println ("-");
        System.out.println ("-Digite o numero do cargo:_______________");
        int indiceCargo = teclado.nextInt();
        teclado.nextLine();
        //GetCargo
        ICargo cargo = this.controlador.getControladorGeral().getControladorCargo().getCargoByIndice(indiceCargo);
        
        //Enveolpe cirado para adicionar a lista
        return new EnvelopeFuncionario(numeroDeMatricula, nome,
        telefone, salario, cargo, ano, mes, dia);
    }
    
    /**
     * Cria uma interface para o usuario poder digitar a matricula que sera
     * excluida do sistema.
     * @return int com o numero da matricula que o usuario digitou.
     */
    private int removerFuncionario () {
        //Inicializar
        System.out.println ("----------------------------------------");
        System.out.println ("-----------Remover Funcionario----------");
        System.out.println ("----------------------------------------");
        System.out.println ("-Inisra o numero de matricula:__________");
        //Capturar o valor da matricula
        int matricula = this.teclado.nextInt();
        this.teclado.nextLine();
        
        return matricula;
    }
    
    /**
     * Exibe uma lista de todos os usuarios cadastrados no sistema.
     */
    private void listarFuncionarios () {
        //Inicializar
        System.out.println ("----------------------------------------");
        System.out.println ("---------Listagem de Funcionarios-------");
        System.out.println ("----------------------------------------");
        //Listagem dos funcionarios
        for (IFuncionario funcionarioLista : this.controlador.getFuncionarios()){
            
            System.out.println ("-Nome: " + funcionarioLista.getNome());
            System.out.println ("-Matricula: " + funcionarioLista.getNumeroDeMatricula());
            System.out.println ("-Telefone: " + funcionarioLista.getTelefone());
            System.out.println ("-Salario: " + funcionarioLista.getSalario());
            System.out.println ("----------------------------------------");
        }
    }
}
