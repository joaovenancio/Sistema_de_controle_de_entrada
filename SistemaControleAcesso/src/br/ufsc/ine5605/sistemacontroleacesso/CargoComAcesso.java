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
public class CargoComAcesso extends Gerente {

    /**
     * Atributo que representa os horários que o cargo pode acessar a porta do
     * financeiro
     */
    private ArrayList<Calendar> arrayComHorarios;

    /**
     * Construtor do Cargo com acesso
     *
     * @param codigo - Código do cargo
     * @param nome - Nome do cargo
     * @param inicio - Horário de inicio do expediente desse cargo
     * @param fim  - Horário de fim do expediente desse cargo
     */
    public CargoComAcesso(String codigo, String nome, Calendar inicio, Calendar fim) {
        super(codigo, nome);
        this.arrayComHorarios = new ArrayList<>();
        this.arrayComHorarios.add(inicio);
        this.arrayComHorarios.add(fim);
    }

    /**
     * Método que mostra se o cargo tem ou não acesso a porta do financeiro
     *
     * @param horario - Horário a ser comparado
     * @return - boolean indicando se o cargo tem acesso
     */
    @Override
    public boolean temAcesso(Calendar horario) {
        if (this.arrayComHorarios.get(0).before(horario) || this.arrayComHorarios.get(0).equals(horario)
        		&& this.arrayComHorarios.get(1).after(horario) || this.arrayComHorarios.get(1).equals(horario)) {
            return true;
        }

        return false;
    }

    /**
     * Método que retorna o Array de horários que o cargo pode acessar a porta
     * do financeiro
     *
     * @return - Array de horários que o cargo pode acessar a porta do
     * financeiro
     */
    public ArrayList<Calendar> getArrayComHorarios() {
        return arrayComHorarios;
    }

    /**
     * Método que modifica o Array de horários que o cargo pode acessar a porta
     *
     * @param arrayComHorarios - Array de horários que o cargo pode acessar a
     * porta do finnceiro
     */
    public void setArrayComHorarios(ArrayList<Calendar> arrayComHorarios) {
        this.arrayComHorarios = arrayComHorarios;
    }
}
