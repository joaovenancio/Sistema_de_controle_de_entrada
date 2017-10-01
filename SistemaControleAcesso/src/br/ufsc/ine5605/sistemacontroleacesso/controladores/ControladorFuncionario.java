package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaFuncionario;
import java.util.ArrayList;

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
            Funcionario novoFuncionario = new Funcionario(envelope.numeroDeMatricula,
            envelope.nome, envelope.dataDeNascimento, envelope.telefone, envelope.salario);
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
            //Se o nome e a matricula não existirem, pode ser inserido:
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
