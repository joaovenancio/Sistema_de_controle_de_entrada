package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaFuncionario;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorFuncionario {
    //Atributos:
    private ArrayList<Funcionario> funcionarios;
    private TelaFuncionario telaFuncionario;
    
    //Construtor:
    public ControladorFuncionario () {
        this.funcionarios = new ArrayList<Funcionario>();
        this.telaFuncionario = new TelaFuncionario(this);
    }
    
    //Metodos:
    public void iniciarTela () {
        this.telaFuncionario.iniciar();
    }
    
    public void adicionarFuncionario (EnvelopeFuncionario envelope) {
        if (envelope == null) {
        } else {
            //Fazer o tratamento dos dados:
            //Ano nao pode ser abaixo de 0
            if (envelope.ano < 0 ) {
                throw new IllegalArgumentException("Ano de nascimento invalido");
                //Mes nao pode ser abaixou ou acima de 12
            } else if (!(envelope.mes >= 1 && envelope.mes <= 12)) {
                throw new IllegalArgumentException("Mes de nascimento invalido, extrapolou os meses possiveis");
                //O dia precisa ser maior do que 1 e menor do que 31
            } else if (!(envelope.dia > 0 && envelope.dia <= 31)) {
                throw new IllegalArgumentException("Dia do nascimento invalida, não existe dia com esse numero");
            }
            
            //Feito o tratamento do ano, criar um objeto do tipo Calendar para poder cirar o funcionario
            Calendar dataDeNascimento = Calendar.getInstance();
            dataDeNascimento.clear();
            dataDeNascimento.set(Calendar.YEAR, envelope.ano);
            dataDeNascimento.set(Calendar.MONTH, envelope.mes -1); //Os meses começam a contar no 0, por isso o menos um
            dataDeNascimento.set(Calendar.DATE, envelope.dia);
            
            //Criar o novoFuncionario:
            Funcionario novoFuncionario = new Funcionario(envelope.numeroDeMatricula,
            envelope.nome, envelope.telefone, envelope.salario, dataDeNascimento);
            
            //Verificação se já existe esse nome e matricula para esse funcionario ao mesmo tempo:
            //Verificar se jah existe a mesma matricula:
            for (IFuncionario funcionarioLista : funcionarios) {
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
            this.funcionarios.add(novoFuncionario);
            
        }
    }
    
    /*
    Procura pela lista de IFuncioarios por um com a mesma matricula
    @retruns true se encotrou e removeu
    @returns false se não encotrou (portanto nao removeu)
    */
    public boolean removerFuncionarioPelaMatricula (int matricula) {
        IFuncionario funcionarioRemover = null;
        boolean encontrou = false;
        for (IFuncionario funcionarioLista : this.funcionarios) {
            if (funcionarioLista.getNumeroDeMatricula() == matricula) {
                funcionarioRemover = funcionarioLista;
                encontrou = true;
                break;
            }
        }
        if (encontrou) {
            this.funcionarios.remove(funcionarioRemover);
            return true;
        } else {
            return false;
        }
    }
    
    //Getter:
    public TelaFuncionario getTelaFuncionario () {
        return this.telaFuncionario;
    }
    
    public ArrayList<Funcionario> getFuncionarios () {
        return this.funcionarios;
    }
    
}
