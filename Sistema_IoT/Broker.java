import java.util.Random;

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
       
        int contador = 0;
        Random rand  = new Random();
       

        while ( contador < cantidadTotalEventos){

           
            int num = rand.nextInt(201);

            Evento eventoAEval = buzonEntrada.retirar();
            
            if (num % 8 == 0){

                buzonAlertas.depositar(eventoAEval);
            }
            else{

                buzonClasificacion.depositar(eventoAEval);
            }

            contador++;

        }


        Evento eventoFinal = new Evento(-1, -1, -1,true);
        buzonAlertas.depositar(eventoFinal);
        System.out.println("Broker terminó. Procesó " + contador + " eventos");


    }
    





}
