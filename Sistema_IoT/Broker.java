import java.util.Random;

import javax.swing.plaf.synth.SynthStyle;

import org.w3c.dom.events.Event;

public class Broker extends Thread {

    public Buzon buzonClasificacion;
    public Buzon buzonAlertas;
    public Buzon buzonEntrada;
    public int cantidadTotalEventos;


    public Broker(Buzon buzonEntrada, Buzon buzonAlertas, Buzon buzonClasificacion, int cantidadTotalEventos){

        this.buzonEntrada = buzonEntrada;
        this.buzonClasificacion = buzonClasificacion;
        this.buzonAlertas = buzonAlertas;
        this.cantidadTotalEventos = cantidadTotalEventos;


    }


    @Override

    public void run(){
       
        System.out.println("El broker ha iniciado...");
        int contador = 0;
        Random rand  = new Random();
       

        while ( contador < cantidadTotalEventos){

            System.out.println("Broker: iteración " + contador + " - esperando evento...");
            int num = rand.nextInt(201);

            Evento eventoAEval = buzonEntrada.salir();

            System.out.println("Broker: evento con id " + eventoAEval.getId() + " recibido, evaluando...");
            
            if (num % 8 == 0){
                System.out.println("Broker: evento ANÓMALO, enviando a alertas...");
                buzonAlertas.entrarSemiActiva(eventoAEval);
                System.out.println("Broker: enviado a alertas");
            }
            else{
                System.out.println("Broker: evento NORMAL, enviando a clasificación...");
                buzonClasificacion.entrarSemiActiva(eventoAEval);
                System.out.println("Broker: enviado a clasificación");
            }

            contador++;

        }


        Evento eventoFinal = new Evento(-1, -1, -1,true);
        buzonAlertas.entrarSemiActiva(eventoFinal);
        System.out.println("Broker terminó. Procesó " + contador + " eventos");


    }
    





}
