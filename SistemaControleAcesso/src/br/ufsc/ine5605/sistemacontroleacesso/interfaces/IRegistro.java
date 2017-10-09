/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.interfaces;

import br.ufsc.ine5605.sistemacontroleacesso.AcontecimentoRegistro;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public interface IRegistro {
    
   /**<b>Método para retorno do Acontecimento do Registro</b>
    *@return AcontecimentoRegistro - Acontecimento do Registro
    */
    public AcontecimentoRegistro getAcontecimento();
    
    /**
     * <b>Método para retorno da data do Acontecimento do Registro</b>
     * @return Calendar - Data do Acontecimento do Registro
     */
    public Calendar getDataAcontecimento();
    
    /**<b>Método para retorno do número de matrícula do Funcionário 
     * que gerou o Registro</b>
     * @return int - Número de matrícula do Funcionário
     */
    public int getNumDeMatricula();
}
