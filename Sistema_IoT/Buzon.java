import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

import org.w3c.dom.events.Event;

public class Buzon {


    private Queue<Evento> cola;
    private int capacidad;
    private static int ocupantes = 0;
   

    public Buzon(int capacidad){

    this.capacidad = capacidad;



    }



    public synchronized void entrar(Evento ev){

        while (capacidad == ocupantes) {
            try{
            wait();
            } catch(InterruptedException e){


            }
        }

            ocupantes++;
            depositar(ev);
            notify();

        
    }


    public synchronized Evento salir(){

        while (ocupantes == 0 ) {

            try{
                wait();
            } catch(InterruptedException e){

            }

           

            
        }
        

        ocupantes--;
        Evento evento = retirar();
        notify();

        return evento;
            


    }


    public void depositar(Evento e){

        cola.add(e);
    }

    public Evento retirar(){

        Evento evento = cola.poll();
        return evento;
    }


    public Queue<Evento> obtenerCola(){

        return this.cola;
    }
    
    public int numOcupantes(){

        return this.ocupantes;
    }


}
