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
    
    /**Construtor de Registro
     * 
     * @param acontecimento acontecimento que gerou o registro
     * @param dataAcontecimento data do acontecimento que gerou o registro
     * @param numDeMatricula número de matrícula do funcionário que gerou o 
     * registro
     */
    public Registro(AcontecimentoRegistro acontecimento, Calendar dataAcontecimento, int numDeMatricula ) {
        this.acontecimento = acontecimento;
        this.dataAcontecimento = dataAcontecimento;
        this.numDeMatricula = numDeMatricula;
    }
    
    //Metodos
    
    @Override
    public AcontecimentoRegistro getAcontecimento() {
        return this.acontecimento;
    }

    @Override
    public Calendar getDataAcontecimento() {
        return this.dataAcontecimento;
    }

    @Override
    public int getNumDeMatricula() {
        return this.numDeMatricula;
    }
    
    
}
