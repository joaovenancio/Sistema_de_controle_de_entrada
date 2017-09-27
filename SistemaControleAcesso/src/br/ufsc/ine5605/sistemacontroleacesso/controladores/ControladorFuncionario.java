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
    private ArrayList<IFuncionario> funcionarios;
    private TelaFuncionario telaFuncionario;
    
    //Construtor:
    public ControladorFuncionario () {
        this.funcionarios = new ArrayList<IFuncionario>();
        this.telaFuncionario = new TelaFuncionario(this);
    }
    
    //Metodos:
    public boolean adicionarFuncionario (EnvelopeFuncionario envelope) {
        if (envelope == null) {
            return false;
        } else {
            IFuncionario novoFuncionario = new Funcionario(envelope.numeroDeMatricula,
            envelope.nome, envelope.dataDeNascimento, envelope.telefone, envelope.salario);
            //Verificação se já existe esse nome e matricula para esse funcionario ao mesmo tempo:
            //Verificar se jah existe a mesma matricula:
            for (IFuncionario funcionarioLista : funcionarios) {
                if (funcionarioLista.getNumeroDeMatricula() == novoFuncionario.getNumeroDeMatricula() ) {
                    return false;
                } else {
                    //Verificar se jah existe o mesmo nome:
                    if (funcionarioLista.getNome().equals(novoFuncionario.getNome()) ) {
                        return false;
                    }
                }
            }
            //Se o nome e a matricula não existirem, pode ser inserido:
            this.funcionarios.add(novoFuncionario);
            return true;
            
        }
    }
    
    public boolean removerFuncionario (IFuncionario funcionario) {
        if (funcionario == null) {
            return false;
        } else {
            this.funcionarios.remove(funcionario);
            return true;
        }
    }
    
    //Getter:
    public TelaFuncionario getTelaFuncionario () {
        return this.telaFuncionario;
    }
    
    
}
