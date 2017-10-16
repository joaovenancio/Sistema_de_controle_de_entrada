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
    /**Enum que representa a tentativa de acesso a porta do
     * financeiro fora do horário permitido pelo cargo
     */
    FORADEHORARIO("O Usuario em questao tem acesso a porta, porem tentou"
                  + " acessa-la fora do horario permitido pelo seu cargo"),
    
    /**Enum que representa a tentativa de acesso a porta do financeiro por um
     * cargo que não tem acesso 
     */
    CARGOSEMACESSO("O Usuario em questao nao possui acesso a porta e"
                   + " tentou abri-la");
    
    //Atributos
    /**
     * Atributo do Enum que representa a descrição do registro
     */
    private String descricao;
    
    //Construtor
    /**Construtor da descrição do Enum
     * 
     * @param descricao - Descrição do Acontecimento a ser registrado
     */
    AcontecimentoRegistro (String descricao) {
        this.descricao = descricao;
    }
    
    //Metodos
    /**
     * Método para retorno da descrição de um Enum
     * @return String - Descrição do registro
     */
    public String getDescricao() {
        return descricao;
    }
}
