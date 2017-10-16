package br.ufsc.ine5605.sistemacontroleacesso.telas;

import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
//Calendar ou date?
import java.util.Calendar;
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
        this.teclado = new Scanner(System.in);
    }
    
    //Metodos:
    /**
     * Mostra uma interface grafica para o usuario interagir. Nele ele pode selecionar
     * o que quer fazer sobre os funcionarios.
     */
    public void iniciar() {
        int opcao = 0;
        while (opcao <= 4 ) {
            System.out.println ("----------------------------------------");
            System.out.println ("--------------Funcionarios--------------");
            System.out.println ("----------------------------------------");
            System.out.println ("------------Escolha uma opção:----------");
            System.out.println ();
            System.out.println ("-1)Cadastrar um funcionario");
            System.out.println ("-2)Remover um funcionario pela matricula");
            System.out.println ("-3)Listar os funcionarios cadastrados");
            System.out.println ("-4)Modificar um funcionario");
            System.out.println ("-5)Voltar");
            System.out.println ("-#OPÇÃO:_____");
            System.out.println ();
            
            opcao = inputDeIntTratado();            
            switch (opcao) {
                //Cadastrar um funcionario:
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
                    break;
                
                    //Remover um funcionario pela matricula
                case 2:
                    int matricula = 0;
                    try {
                    
                        matricula = this.removerFuncionario();
                        
                    } catch (IllegalArgumentException exception) {
                        System.out.println("########################################");
                        System.out.println("-ERRO DE INPUT: CARACTERES NAO SAO");
                        System.out.println("-ACEITOS PARA ESSE CAMPO");
                        System.out.println("########################################");
                    }
                    
                    if (controlador.removerFuncionarioPelaMatricula(matricula)) {
                        System.out.println ("-Funcioario removido com sucesso!");
                    } else {
                        System.out.println("########################################");
                        System.out.println ("-Funcionario nao encontrado pela");
                        System.out.println ("-matricula fornecida, nao foi");
                        System.out.println ("-possivel remove-lo");
                        System.out.println("########################################");
                    }
                    break;
                
                //Listar os funcionarios
                case 3:
                    this.listarFuncionarios();
                    break;
                    
                //Modificar um funcionario
                case 4:
                    
                    try {
                        
                        this.modificarFuncionario();
                        
                    } catch (IllegalArgumentException exception) {
                        
                    }
                    
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
        //Tratar o input, caso for uma String, pode quebrar o sistema:
        //Caso estiver tudo ok: 
        int numeroDeMatricula = inputDeIntTratado();
        
        System.out.println ("-Nome do funcionario:___________________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        //Aqui fica os inputs para a data de nascimento, esperar a implementacao
        //do Calendar
        //-----
        System.out.println ("-Dia do nascimento:_____________________");
        int dia = inputDeIntTratado();
        
        System.out.println ("-Mes do nascimento:_____________________");
        int mes = this.inputDeIntTratado();
        
        System.out.println ("-Ano do nascimento:_____________________");
        int ano = this.inputDeIntTratado();
        //-----
        
        System.out.println ("-Telefone do funcionario:_______________");
        String telefone = this.teclado.nextLine();
        this.teclado.nextLine();
        
        System.out.println ("-Salario:_______________________________");
        int salario = this.teclado.nextInt();
        this.teclado.nextLine();
        
        
        //Associar um cargo a um funcionario:
        System.out.println ("-----Selecione o cargo do funcionario----");
        //Mostra os cargos:
        this.controlador.getControladorGeral().getControladorCargo().getTelaCargo().listarCargos();
        //Input para selecionar o cargo:
        System.out.println ("-");
        System.out.println ("-Digite o código do cargo:_______________");
        String codigoCargo = this.teclado.nextLine();
        //GetCargo pelo indice que o usuario colocou:
        ICargo cargo = this.controlador.getControladorGeral().getControladorCargo().findCargoByCodigo(codigoCargo);
        
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
        int matricula = this.inputDeIntTratado();
        
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
            System.out.println ("-Cargo: " + funcionarioLista.getCargo().getNome());
            System.out.println ("----------------------------------------");
        }
    }
    
    /**
     * Mostra inptus para modificar os dados de um funcionario. Se o numero de matricila estiver errado,
     * ele joga uma excecao.
     */
    private void modificarFuncionario() {
        System.out.println ("----------------------------------------");
        System.out.println ("----------Modificar Funcionario---------");
        System.out.println ("----------------------------------------");
        System.out.println ("----------Selecione o Funcionario-------");
        System.out.println ("-----------que Deseja Modificar---------");
        this.listarFuncionarios();
        System.out.println ("-Inisra o numero de matricula:__________");
        int matricula = this.inputDeIntTratado();
        this.teclado.nextLine();
        //Achar o funcionario e guardar ele:
        Funcionario funcionarioParaModificar = this.controlador.findFuncionarioByMatricula(matricula);
        
        //Nova matricula:
        System.out.println ("-Insira um novo numero de matricula:_____");
        int numeroDeMatricula = this.inputDeIntTratado();
        this.teclado.nextLine();
        
        //Novo nome:
        System.out.println ("-Novo nome do funcionario:_______________");
        String nome = this.teclado.nextLine();
        this.teclado.nextLine();
        
        //Aqui fica os inputs para a data de nascimento, esperar a implementacao
        //do Calendar
        System.out.println ("-Novo Dia do nascimento:_________________");
        int dia = this.inputDeIntTratado();
        this.teclado.nextLine();
        System.out.println ("-Novo Mes do nascimento:_________________");
        int mes = this.teclado.nextInt();
        this.teclado.nextLine();
        System.out.println ("-Novo Ano do nascimento:_________________");
        int ano = this.teclado.nextInt();
        this.teclado.nextLine();
        //
        
        //Novo numero de telefone:
        System.out.println ("-Novo Numero de Telefone do Funcionario:");
        String telefone = this.teclado.nextLine();
        this.teclado.nextLine();
        
        //Novo salario:
        System.out.println ("-Salario:_______________________________");
        int salario = this.teclado.nextInt();
        this.teclado.nextLine();
        
        //Novo cargo:
        //Associar um cargo a um funcionario:
        System.out.println ("-----Selecione o cargo do funcionario----");
        //Mostra os cargos
        this.controlador.getControladorGeral().getControladorCargo().getTelaCargo().listarCargos();
        //Input para selecionar o cargo
        System.out.println ("-");
        System.out.println ("-Digite o numero do cargo:_______________");
        String codigoCargo = teclado.nextLine();
        teclado.nextLine();
        //GetCargo
        ICargo cargo = this.controlador.getControladorGeral().getControladorCargo().findCargoByCodigo(codigoCargo);
        
        //Enveolpe criado para poder ser processado pela metodo do controlador
        EnvelopeFuncionario novoFuncionario = new EnvelopeFuncionario(numeroDeMatricula, nome,
        telefone, salario, cargo, ano, mes, dia);
        
        
        //Executar a modificacao:
        this.controlador.modificarFuncionario(funcionarioParaModificar, novoFuncionario);
        
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
