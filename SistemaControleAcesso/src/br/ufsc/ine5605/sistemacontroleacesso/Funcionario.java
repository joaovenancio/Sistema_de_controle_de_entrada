/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class Funcionario implements IFuncionario{
    //Atributos:
    private int numeroDeMatricula;
    private String nome;
    private Calendar dataDeNascimento;
    private String telefone;
    private int salario;
    public boolean getNumeroDeMatricula;
    
    //Construtor:
    public Funcionario (int numeroDeMatricula, String nome, Calendar dataDeNascimento,
    String telefone, int salario) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.salario = salario;
    }
    
    //Metodos:
    @Override
    public boolean getNumeroDeMatricula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
