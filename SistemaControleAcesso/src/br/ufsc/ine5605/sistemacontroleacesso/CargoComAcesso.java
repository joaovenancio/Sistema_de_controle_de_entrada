/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PEaug
 */
public class CargoComAcesso extends Gerente{
     private ArrayList<Calendar> arrayComHorarios;

             
    public CargoComAcesso(String codigo, String nome, Calendar inicio, Calendar fim) {
        super(codigo, nome);
        this.arrayComHorarios.add(inicio);
        this.arrayComHorarios.add(fim);
    }
    
    /**
     * @param hora int - hora a ser adicionada no Array de horas
     * @param minutos int - minutos a serem adicionados no Array de horas
     * @return String - Status da operação
     **/
    public String addHorario(int hora, int minutos){
        Calendar calendario = Calendar.getInstance();
        
        calendario.set(Calendar.HOUR_OF_DAY, hora);
        calendario.set(Calendar.MINUTE, minutos);
        
        for(Calendar dataBuscando : this.arrayComHorarios){
            if(dataBuscando.get(Calendar.HOUR) == calendario.get(Calendar.HOUR)){
                if(dataBuscando.get(Calendar.MINUTE) == calendario.get(Calendar.MINUTE)){
                   return "Horário já adicionado para esse funcionário";
                }
            }
        }
        return "Horário adicionado com sucesso!";
    }
    
    //TODO:Rever se as classes estão alinhadas com o documento da homologacao
}
