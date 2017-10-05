/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.envelopes;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;

/**
 *
 * @author Joao Vitor Venancio
 */
public class EnvelopeFuncionario {
    //Atributos:
    public int numeroDeMatricula;
    public String nome;
    public String telefone;
    public int salario;
    public IFuncionario funcionario;
    public ICargo cargo;
    //Informações para a criacao do atributo Calendar
    public int ano;
    public int mes;
    public int dia;
    

    //Construtor:
    public EnvelopeFuncionario(int numeroDeMatricula, String nome, String telefone, int salario, ICargo cargo, int ano, int mes, int dia) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }
}
