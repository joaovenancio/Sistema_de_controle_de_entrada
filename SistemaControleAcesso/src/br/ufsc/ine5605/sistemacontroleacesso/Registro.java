/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;
import br.ufsc.ine5605.sistemacontroleacesso.interfaces.IRegistro;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public class Registro implements IRegistro {
    //Atributos
    private AcontecimentoRegistro acontecimento;
    private Calendar dataAcontecimento;
    private int numDeMatricula;
    
    //Construtor
    public Registro(AcontecimentoRegistro acontecimento, Calendar dataAcontecimento, int numDeMatricula ) {
        this.acontecimento = acontecimento;
        this.dataAcontecimento = dataAcontecimento;
        this.numDeMatricula = numDeMatricula;
    }
    
    //Metodos
    public AcontecimentoRegistro getAcontecimento() {
        return this.acontecimento;
    }

    public Calendar getDataAcontecimento() {
        return this.dataAcontecimento;
    }

    public int getNumDeMatricula() {
        return this.numDeMatricula;
    }
    
    
}
