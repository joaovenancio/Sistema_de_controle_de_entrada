/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;
import br.ufsc.ine5605.sistemacontroleacesso.Funcionario;
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
     * Mostra uma interface grafica para o usuario interagir. Nele ele pode selecionar
     * o que quer fazer na porta.
     */
    public void iniciarTela() {
        this.telaPortaFinanceiro.iniciar();
    }

    /**
     * Tenta abrir a porta. Caso o a matricula do funcionario não for valida, ele joga uma excecao.
     * 
     * @param numeroDeMatricula para o usuario tentado destrancar a porta.
     * @param horario da data atual.
     */
    public void abrirPorta(int numeroDeMatricula, Calendar horario) {
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
        if(!(existe)) {
            throw new IllegalArgumentException("Usuario com essa matricula nao existe");
        }
        
        //Tentar acesso a porta:
        
        //Metodo em andamento
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        //Verificar se o usuario em questao possui acesso a aporta:
        if (funcionarioPorta.getCargo().temAcesso(horario)) {
            System.out.println("Acesso autorizado.");
        }else{
            System.out.println("Acesso não autorizado.");
        }
    }
}
