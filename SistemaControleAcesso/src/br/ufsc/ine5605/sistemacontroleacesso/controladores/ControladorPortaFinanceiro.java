/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.AcontecimentoRegistro;
import br.ufsc.ine5605.sistemacontroleacesso.CargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.CargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso.Registro;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaPortaFinanceiro;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorPortaFinanceiro {

    //Atributos
    private ControladorGeral controladorGeral;
    private TelaPortaFinanceiro telaPortaFinanceiro;

    //Construtor
    public ControladorPortaFinanceiro(ControladorGeral controlador) {
        this.controladorGeral = controlador;
        this.telaPortaFinanceiro = new TelaPortaFinanceiro(this);
    }

    //Metodos
    /**
     * Mostra uma interface grafica para o usuario interagir. Nele ele pode
     * selecionar o que quer fazer na porta.
     */
    public void iniciarTela() {
        this.telaPortaFinanceiro.iniciar();
    }

    /**
     * Tenta abrir a porta. Caso o a matricula do funcionario não for valida,
     * ele joga uma excecao.
     *
     * @param numeroDeMatricula para o usuario tentado destrancar a porta.
     * @param horario da data atual.
     */
    public String abrirPorta(int numeroDeMatricula, Calendar horario) {
        //Verificar se o numero de matricula existe:
        boolean existe = false;
        Funcionario funcionarioPorta = null;
        for (Funcionario funcionarioLista : this.controladorGeral.getControladorFuncionario().getFuncionarios()) {
            if (funcionarioLista.getNumeroDeMatricula() == numeroDeMatricula) {
                existe = true;
                funcionarioPorta = funcionarioLista;
                break;
            }
        }
        //Se nao existir, joga uma excecao;
        if (!(existe)) {
            throw new IllegalArgumentException("Usuario com essa matricula nao existe");
        }

        //Tentar acesso a porta:
        //Metodo em andamento
        //Verificar se o usuario em questao possui acesso a a porta:
        
        if (funcionarioPorta.getCargo().temAcesso(horario)) {
        	return "Acesso Autorizado.";
        }else{
	        if (funcionarioPorta.getCargo() instanceof CargoComAcesso) {
	            //TEM QUE FAZER A VERIFICAÇÃO!
	            //controladorGeral.getControladorRegistros().addRegistro();
	            return AcontecimentoRegistro.FORADEHORARIO.getDescricao();
	        }else if (funcionarioPorta.getCargo() instanceof CargoSemAcesso){
	            return AcontecimentoRegistro.CARGOSEMACESSO.getDescricao();
	        }
        }
        return "Acesso não autorizado.";
    }
    
}
