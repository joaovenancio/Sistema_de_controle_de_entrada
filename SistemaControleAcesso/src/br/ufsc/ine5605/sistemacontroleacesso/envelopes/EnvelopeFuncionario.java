/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.envelopes;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Joao Vitor Venancio
 */
public class EnvelopeFuncionario {
    //Atributos:
    public int numeroDeMatricula;
    public String nome;
    public Date dataDeNascimento;
    public String telefone;
    public int salario;
    public IFuncionario funcionario;

    //Construtor:
    public EnvelopeFuncionario(int numeroDeMatricula, String nome, Date dataDeNascimento, String telefone, int salario) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.salario = salario;
        //FALTA O FUNCIONARIO
    }
}
