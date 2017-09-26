/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class Funcionario {
    //Atributos:
    private int numeroDeMatricula;
    private String nome;
    private Calendar dataDeNascimento;
    private String telefone;
    private int salario;
    
    //Construtor:
    public Funcionario (int numeroDeMatricula, String nome, Calendar dataDeNascimento,
    String telefone, int salario) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.salario = salario;
    }
}
