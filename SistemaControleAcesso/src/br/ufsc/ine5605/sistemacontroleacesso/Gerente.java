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
public class Gerente extends CargoSemAcesso{
    
    public Gerente(String codigo, String nome) {
        super(codigo, nome);
    }
    
    /**
     * @param horario
     *@return se o cargo tem acesso
     **/
    
    @Override
    public boolean temAcesso(Calendar horario){
        return true;
    }
    
}
