import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.events.Event;

public class Buzon {


    private Queue<Evento> cola;
    private int capacidad;
    private  int ocupantes ;
   

    public Buzon(int capacidad){

        this.capacidad = capacidad;
        this.cola = new LinkedList<Evento>();
        this.ocupantes = 0;



    }

    public void entrarSemiActiva(Evento ev){
    while (true) {
        synchronized (this) {
            if (capacidad > ocupantes) {
                ocupantes++;
                depositar(ev);
                notifyAll();
                return;
            }
        }
        Thread.yield(); 
    }
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
            notifyAll();

        
    }


    public Evento SalirSemiActiva() {
    while (true) {
        synchronized (this) {
            if (ocupantes > 0) {
                ocupantes--;
                Evento evento = retirar();
                notifyAll();
                return evento;
            }
        }
        Thread.yield(); 
    }
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
        notifyAll();

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
