/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso.controladores;

import br.ufsc.ine5605.sistemacontroleacesso.AcontecimentoRegistro;
import br.ufsc.ine5605.sistemacontroleacesso.Registro;
import br.ufsc.ine5605.sistemacontroleacesso.telas.TelaRegistro;
import java.util.ArrayList;

/**
 *
 * @author PEaug
 */
public class ControladorRegistros {
    //Atributos:
    private ControladorGeral controladorGeral;
    private TelaRegistro telaRegistro;
    private ArrayList<Registro> arrayDeRegistros;
   
            
    //Construtor
    public ControladorRegistros (ControladorGeral controladorGeral) {
        this.controladorGeral = controladorGeral;
        this.telaRegistro = new TelaRegistro(this);
        this.arrayDeRegistros = new ArrayList<>();
    }

    public void iniciarTela() {
        this.telaRegistro.iniciar();
    }

    public ArrayList<Registro> findAcontecimentoByIndice(int indiceDoAcontecimento) {
       //Criando o ArrayList de Retorno
        ArrayList<Registro> registrosEncontrados = new ArrayList<>();
       //Criando o Vetor com os índices do Enum
        AcontecimentoRegistro[] acontecimentos = AcontecimentoRegistro.values();
       //Iniciando a busca no Array do Controlador por Objetos com Enum igual ao do parametro 
        for(Registro registroBusca : arrayDeRegistros){
       //Se o registroBusca tiver um Enum igual ao Enum que está sendo apontado pelo vetor     
            if(registroBusca.getAcontecimento().equals(acontecimentos[indiceDoAcontecimento])){
       //O registro que satisfaz a condição é adicionado ao Array de retorno
                registrosEncontrados.add(registroBusca);
//TODO:PASSAR PARA A TELA!!                
//                System.out.println(registroBusca.getAcontecimento());
//                System.out.println(registroBusca.getDataAcontecimento().getTime());
//                System.out.println(registroBusca.getNumDeMatricula());
            }
        }
      //Retornando o Array para a tela  
        return registrosEncontrados;
    }

    public Iterable<Registro> getArrayDeRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ControladorGeral getControladorGeral(){
        return controladorGeral;
    }
}
