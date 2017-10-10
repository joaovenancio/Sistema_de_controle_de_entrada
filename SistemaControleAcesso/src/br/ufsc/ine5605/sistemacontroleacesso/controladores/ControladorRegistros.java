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

    public void findByAcontecimento(int indiceDoAcontecimento) {
        AcontecimentoRegistro[] acontecimentos = AcontecimentoRegistro.values();
        for(Registro registroBusca : arrayDeRegistros){
            if(registroBusca.getAcontecimento().equals(acontecimentos[indiceDoAcontecimento])){
                System.out.println();
            }
        }
    }

    public Iterable<Registro> getArrayDeRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
