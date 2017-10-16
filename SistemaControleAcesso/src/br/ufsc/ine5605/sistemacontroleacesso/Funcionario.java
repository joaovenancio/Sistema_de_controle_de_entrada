/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import br.ufsc.ine5605.sistemacontroleacesso.interfaces.ICargo;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public class Funcionario{
    //Atributos:
    /**
     * Atributo que representa o número de matrícula do funcionário
     */
    private int numeroDeMatricula;
    
    /**
     * Atributo que representa o nome do funcionário
     */
    private String nome;
    
    /**
     * Atributo que representa o número de telefone do funcionário
     */
    private String telefone;
    
    /**
     * Atributo que representa o salário do funcionário
     */
    private int salario;
    
    /**
     * Atributo que representa o cargo do funcionário
     */
    private ICargo cargo;
    
    /**
     * Atributo que representa a data de nascimento do funcionário
     */
    private Calendar dataDeNascimento;
    
    //Construtor:
    /**Construtor da classe funcionário
     * 
     * @param numeroDeMatricula  número de matrícula do funcionário
     * @param nome  nome do funcionário
     * @param telefone  número de telefone do funcionário
     * @param salario  salário do funcionário
     * @param cargo  cargo do funcionário
     * @param dataDeNascimento  data de nascimento do funcionário
     */
    public Funcionario (int numeroDeMatricula, String nome,
    String telefone, int salario, ICargo cargo, Calendar dataDeNascimento) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
        this.dataDeNascimento = dataDeNascimento;
    }
    
    //Metodos:
    //Getters e setters:
    /**Método que retorna o número de matrícula
     * 
     * @return  número de matrícula
     */
    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }
    
    /**Método que modifica o número de matrícula do funcionário 
     * 
     * @param numeroDeMatricula  número de matrícula a ser setado
     */
    public void setNumeroDeMatricula(int numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    /**Método que retorna o nome do funcionário
     * 
     * @return nome do funcionário
     */
    public String getNome() {
        return nome;
    }
    
    /**Método que modifica o nome do funcionário
     * 
     * @param nome  nome do funcionário a ser setado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**Método que retorna a data de nascimento do funcionário
     * 
     * @return data de nascimento do funcionário
     */
    public Calendar getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**Método que modifica a data de nascimento do funcionário
     * 
     * @param dataDeNascimento data de nascimento do funcionário a ser setada
     */
    public void setDataDeNascimento(Calendar dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    
    public String getTelefone() {
        return telefone;
    }
    
    //COLOCAR NA INTERFACE????????
    /**Método que modifica o número de telefone do funcionario
     * 
     * @param telefone  número de telefone do funcionario a ser setado
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getSalario() {
        return salario;
    }
    
    /**Método que modifica o salário do funcionario
     * 
     * @param salario  salário do funcionario a ser setado
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    /**Método que retorna o cargo do funcionario
     * 
     * @return cargo do funcionario
     */
    public ICargo getCargo() {
        return cargo;
    }
    
    /**Método que modifica o cargo do funcionario 
     * 
     * @param cargo  cargo do funcionario a ser setado
     */
    public void setCargo(ICargo cargo) {
        this.cargo = cargo;
    }
    
}
