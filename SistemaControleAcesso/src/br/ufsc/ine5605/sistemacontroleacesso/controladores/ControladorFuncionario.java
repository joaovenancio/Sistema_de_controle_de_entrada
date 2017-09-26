package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorFuncionario {
    //Atributos:
    private ArrayList<IFuncionario> funcionarios;
    
    //Construtor:
    public ControladorFuncionario () {
        this.funcionarios = new ArrayList<IFuncionario>();
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
    
    
    
    
}
