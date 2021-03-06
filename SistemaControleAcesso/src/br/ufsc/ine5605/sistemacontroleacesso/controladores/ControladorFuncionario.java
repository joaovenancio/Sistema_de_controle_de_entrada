package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.FuncionarioDAO;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaFuncionario;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorFuncionario {
    //Atributos:
    private ControladorGeral controladorGeral;
    private TelaFuncionario telaFuncionario;
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    //Construtor:
    public ControladorFuncionario (ControladorGeral controladorGeral) {
        this.controladorGeral = controladorGeral;
        this.telaFuncionario = new TelaFuncionario(this);
    }
    
    //Metodos:
    /**
     * Chama a tela do controlador e inicia ela.
     */
    public void iniciarTela () {
        this.telaFuncionario.iniciar();
    }
    
    /**
     * Confere se os imputs de dados estao corretos, se nao estiver, joga uma excecao.
     * Se estiver tudo certo, instancia um novo funcionario e adiciona ele a array dentro
     * do controlador.
     * @param envelope - Conteudo para criar o objeto Funcionario
     */
    public void adicionarFuncionario (EnvelopeFuncionario envelope) {
        if (envelope == null) {
        } else {
            //Fazer o tratamento dos dados:
            //Ano nao pode ser abaixo de 0
            if (envelope.ano < 0 ) {
                throw new IllegalArgumentException("Ano de nascimento invalido");
                //Mes nao pode ser abaixo de 1 ou acima de 12
            } else if (!(envelope.mes >= 1 && envelope.mes <= 12)) {
                throw new IllegalArgumentException("Mes de nascimento invalido, extrapolou os meses possiveis");
                //O dia precisa ser maior do que 1 e menor do que 31
            } else if (!(envelope.dia > 0 && envelope.dia <= 31)) {
                throw new IllegalArgumentException("Dia do nascimento invalida, não existe dia com esse numero");
            }
            
            //Ver se foi associado um cargo a um funcionario
            if (envelope.cargo == null) {
                throw new IllegalArgumentException("Não foi associado um Cargo a um Funcionario");
            }
            
            //Feito o tratamento do Cargo, ano, mes e dia, criar um objeto do tipo Calendar para poder cirar o funcionario
            Calendar dataDeNascimento = Calendar.getInstance();
            dataDeNascimento.clear();
            dataDeNascimento.set(Calendar.YEAR, envelope.ano);
            dataDeNascimento.set(Calendar.MONTH, envelope.mes -1); //Os meses começam a contar no 0, por isso o menos um
            dataDeNascimento.set(Calendar.DATE, envelope.dia);
            
            //Criar o novoFuncionario:
            Funcionario novoFuncionario = new Funcionario(envelope.numeroDeMatricula,
            envelope.nome, envelope.telefone, envelope.salario, envelope.cargo, dataDeNascimento);
            
            //Verificação se já existe esse nome e matricula para esse funcionario ao mesmo tempo:
            //Verificar se jah existe a mesma matricula:
            for (Funcionario funcionarioLista : funcionarioDAO.getList()) {
                if (funcionarioLista.getNumeroDeMatricula() == novoFuncionario.getNumeroDeMatricula() ) {
                    throw new IllegalArgumentException("Numero de matricula jah registrado");
                } else {
                    //Verificar se jah existe o mesmo nome:
                    if (funcionarioLista.getNome().equals(novoFuncionario.getNome()) ) {
                        throw new IllegalArgumentException("Nome de funcionario jah cadastrado");
                    }
                }
            }
            //Se o nome e a matricula não existirem, pode ser adicionado:
            this.funcionarioDAO.put(novoFuncionario);
            
        }
    }
    
    /**
     * Procura pela lista de IFuncioarios por um com a mesma matricula
     * @param matricula int - Matricula do funcionaio que se quer remover
     * @return boolean - True se encotrou e removeu / False se não encotrou (portanto nao removeu)
     */
    public boolean removerFuncionarioPelaMatricula (int matricula) {
        Funcionario funcionarioRemover = null;
        boolean encontrou = false;
        for (Funcionario funcionarioLista : funcionarioDAO.getList()) {
            if (funcionarioLista.getNumeroDeMatricula() == matricula) {
                funcionarioRemover = funcionarioLista;
                encontrou = true;
                break;
            }
        }
        if (encontrou) {
            funcionarioDAO.remove(funcionarioRemover);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Procura por um funcionario que possua a matricula colocada como parametro.
     * @param matricula int - Numero da matrícula do funcionario.
     * @return Funcionario - Que possui o numero de matricula, ou null se nao encontrar.
     */
    public Funcionario findFuncionarioByMatricula (int matricula) {
        for (Funcionario funcionarioLista : funcionarioDAO.getList()) {
            if (funcionarioLista.getNumeroDeMatricula() == matricula) {
                return funcionarioLista;
            }
        }
        return null;
    }
    
    /**
     * Recebe um funcionario e um evelope e troca as informacoes do funcionario por
     * aquelas que estao no enveolpe.
     * 
     * @param funcionarioParaModificar funcionario - O Funcionario que se quer modificar.
     * @param envelope envelope - Pacote contendo as informacoes para modificar o Funcionario.
     */
    public void modificarFuncionario (Funcionario funcionarioParaModificar, EnvelopeFuncionario envelope) {
//        //Verificar se o funcionario não é nulo:
//        if (funcionarioParaModificar == null) {
//            throw new IllegalArgumentException("Não existe um funcionário com essa matricula");
//        }
//        
//        //Tratamento do envelope:
//        if (envelope == null) {
//        } else {
//            //Fazer o tratamento dos dados dentro do envelope:
//            //Ano nao pode ser abaixo de 0
//            if (envelope.ano < 0 ) {
//                throw new IllegalArgumentException("Ano de nascimento invalido");
//                //Mes nao pode ser abaixo de 1 ou acima de 12
//            } else if (!(envelope.mes >= 1 && envelope.mes <= 12)) {
//                throw new IllegalArgumentException("Mes de nascimento invalido, extrapolou os meses possiveis");
//                //O dia precisa ser maior do que 1 e menor do que 31
//            } else if (!(envelope.dia > 0 && envelope.dia <= 31)) {
//                throw new IllegalArgumentException("Dia do nascimento invalida, não existe dia com esse numero");
//            }
//            
//            //Feito o tratamento do Cargo, ano, mes e dia, criar um objeto do tipo Calendar para poder cirar o funcionario
//            Calendar dataDeNascimento = Calendar.getInstance();
//            dataDeNascimento.clear();
//            dataDeNascimento.set(Calendar.YEAR, envelope.ano);
//            dataDeNascimento.set(Calendar.MONTH, envelope.mes -1); //Os meses começam a contar no 0, por isso o menos um
//            dataDeNascimento.set(Calendar.DATE, envelope.dia);
//            
//            //Ver se foi associado um cargo a um funcionario
//            if (envelope.cargo == null) {
//                throw new IllegalArgumentException("Não foi associado um Cargo a um Funcionario");
//            }
//            
//            //Verificação se já existe esse nome e matricula para esse funcionario ao mesmo tempo:
//            //Verificar se jah existe a mesma matricula:
//            for (Funcionario funcionarioLista : funcionarioDAO.getList()) {
//                if (funcionarioLista.getNumeroDeMatricula() == envelope.numeroDeMatricula ) {
//                    throw new IllegalArgumentException("Numero de matricula jah registrado");
//                } else {
//                    //Verificar se jah existe o mesmo nome:
//                    if (funcionarioLista.getNome().equals(envelope.nome) ) {
//                        throw new IllegalArgumentException("Nome de funcionario jah cadastrado");
//                    }
//                }
//            }
//            
//            //Agora colocar as novas informacoes do funcionario no funcionario escolhido:
//            int indexArray = this.funcionarios.indexOf(funcionarioParaModificar);
//            
//            this.funcionarios.get(indexArray).setDataDeNascimento(dataDeNascimento);
//            //this.funcionarios.get(indexArray).setCargo(null);
//            this.funcionarios.get(indexArray).setCargo(envelope.cargo);
//            this.funcionarios.get(indexArray).setNumeroDeMatricula(envelope.numeroDeMatricula);
//            this.funcionarios.get(indexArray).setNome(envelope.nome);
//            this.funcionarios.get(indexArray).setTelefone(envelope.telefone);
//            this.funcionarios.get(indexArray).setSalario(envelope.salario);
//        }
    }
    
    //Getter:
    public TelaFuncionario getTelaFuncionario () {
        return this.telaFuncionario;
    }
    
    public ArrayList<Funcionario> getFuncionarios () {
        return new ArrayList(funcionarioDAO.getList());
    }

    public ControladorGeral getControladorGeral() {
        return controladorGeral;
    }
}
