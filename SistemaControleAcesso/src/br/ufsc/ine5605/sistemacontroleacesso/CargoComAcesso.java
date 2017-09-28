/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class CargoComAcesso extends Gerente{
     private ArrayList<Calendar> arrayComHorarios;
             
    public CargoComAcesso(String codigo, String nome) {
        super(codigo, nome);
        this.arrayComHorarios = new ArrayList<>();
    }
    
    //recebe por parametro um int(?) e configura isso pra date e add na array
    public void addHorario(){}
}
