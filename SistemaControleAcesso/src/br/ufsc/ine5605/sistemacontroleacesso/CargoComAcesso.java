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
             
    public CargoComAcesso(String codigo, String nome) {
        super(codigo, nome);
        this.arrayComHorarios = new ArrayList<>();
    }
    
    /**
     * @param horario
     **/
    public String addHorario(int hora, int minutos){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Calendar calendario = Calendar.getInstance();
        
        calendario.set(Calendar.HOUR_OF_DAY, hora);
        calendario.set(Calendar.MINUTE, minutos);
        
        /*TODO:Implementar a lógica que está no package de testes ou pensar em
        *uma que esteja de acordo com o alinhamento do projeto
        */
        //TODO:Decidir como vai ser o retorno desse método
        for(Date dataBuscando : this.arrayComHorarios){
            if(dataBuscando.getHours() == calendario.get(hora)){
                if(dataBuscando.getMinutes() == calendario.get(minutos)){
                   
                    
                }
            }
        }
        
    }
    
    //TODO:Fazer um getArray que mostre os horários do funcionário
    //TODO:Rever se as classes estão alinhadas com o documento da homologacao
}
