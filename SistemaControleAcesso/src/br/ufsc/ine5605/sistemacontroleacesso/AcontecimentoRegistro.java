/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso;

/**
 *
 * @author Joao Vitor Venancio
 */
public enum AcontecimentoRegistro {
    //Enums:
    FORADEHORARIO("O Usuario em questao tem acesso a porta, porem tentou"
                  + " acessa-la fora do horario permitido pelo seu cargo"),
    CARGOSEMACESSO("O Usuario em questao nao possui acesso a porta e"
                   + " tentou abri-la");
    
    //Atributos
    private String descricao;
    
    //Construtor
    AcontecimentoRegistro (String descricao) {
        this.descricao = descricao;
    }
    
    //Metodos
    public String getDescricao() {
        return descricao;
    }
}
