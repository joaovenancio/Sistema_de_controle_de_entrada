/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IFuncionario;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Joao Vitor Venancio
 */
public class Funcionario implements IFuncionario{
    //Atributos:
    private int numeroDeMatricula;
    private String nome;
    private String telefone;
    private int salario;
    private ICargo cargo;
    private Calendar dataDeNascimento;
    
    //Construtor:
    public Funcionario (int numeroDeMatricula, String nome,
    String telefone, int salario, ICargo cargo, Calendar dataDeNascimento) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
        this.dataDeNascimento = dataDeNascimento;
        //Falta o CARGO
    }
    
    //Metodos:
    //Getters e setters:
    @Override
    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(int numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Calendar dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public ICargo getCargo() {
        return cargo;
    }

    public void setCargo(ICargo cargo) {
        this.cargo = cargo;
    }
    
}
