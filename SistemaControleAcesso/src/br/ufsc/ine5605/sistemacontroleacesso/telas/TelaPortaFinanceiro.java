package br.ufsc.ine5605.sistemacontroleacesso.telas;
import br.ufsc.ine5605.sistemacontroleacesso.controladores.ControladorPortaFinanceiro;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Joao Vitor Venancio
 */
public class TelaPortaFinanceiro {
    //Atributos
    private ControladorPortaFinanceiro owner;
    private Scanner teclado;
    
    //Construtor
    public TelaPortaFinanceiro(ControladorPortaFinanceiro owner) {
        this.owner = owner;
        this.teclado = new Scanner(System.in);
        
    }

    public void iniciar() {
        int opcao = 0;
        while (opcao <= 1 && opcao >= 0 ) {
            System.out.println ("----------------------------------------");
            System.out.println ("-----------------Porta------------------");
            System.out.println ("----------------------------------------");
            System.out.println ("------------Escolha uma opção:----------");
            System.out.println ();
            System.out.println ("-1)Destrancar porta");
            System.out.println ("-2)Voltar");
            System.out.println ("-#OPÇÃO:_____");
            System.out.println ();
            
            opcao = this.teclado.nextInt();
            this.teclado.nextLine();
            
            switch(opcao) {
                //Detrancar a porta:
                case 1:
                    try {
                        
                       this.destrancarPorta();
                        
                    } catch (IllegalArgumentException exception) {
                        
                       System.out.println("########################################");
                       System.out.println("-" + exception.getMessage());
                       System.out.println("########################################");
                       System.out.println("-------------Tente novamente------------"); 
                       
                    }
                    
                    break;
            }
            
        }
    }
    
    /**
     * Faz um prompt para o usuario digitar a sua maricula e o hoario atual. Se por acaso a hora e os minutos
     * forem invalidos, ele joga uma excecao.
     */
    private void destrancarPorta() {
        System.out.println ("########################################");
        System.out.println ("------------DESTRANCAR PORTA------------");
        System.out.println ("########################################");
        //capturar o numero da matricular para chamar o metodo do controlador:
        System.out.println ("-Insira o seu numero de matricula:______");
        int numeroDeMatricula = this.teclado.nextInt();
        this.teclado.nextLine();
        //Pedir o horario atual para fazer a comparacao:
        
        System.out.println ("-Insira a HORA atual:___________________");
        int hora = this.teclado.nextInt();
        this.teclado.nextLine();
        //Tratamento da hora:
        if (!(hora >= 0 && hora <= 24)) {
            throw new IllegalArgumentException("Hora inváilda, insira um valor entre 0 e 24 horas");
        }
        
        System.out.println ("-Insira os minutos atuais:______________");
        int minutos = this.teclado.nextInt();
        this.teclado.nextLine();
        //Tratamento dos minutos:
        if (!(minutos >= 0 && minutos <= 60)) {
            throw new IllegalArgumentException("Minutos inváildos, insira um valor entre 0 e 60 minutos");
        }
        
        //Criar o Calendar com os dados obtidos:
        Calendar horario = Calendar.getInstance();
        horario.clear();
        horario.set(Calendar.HOUR_OF_DAY, hora);
        horario.set(Calendar.MINUTE, minutos);

        this.owner.abrirPorta(numeroDeMatricula, horario);
        
        
    }
    
    
}
