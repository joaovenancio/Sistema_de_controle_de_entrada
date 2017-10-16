/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.interfaces;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public interface ICargo {

    public String getNome();

    public String getCodigo();
    
    public ArrayList<Calendar> getArrayComHorarios();
    
    public void setNome(String nome);

    public void setCodigo(String codigo);        
    
    public boolean temAcesso(Calendar horario);
    
}
