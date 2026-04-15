import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

import org.w3c.dom.events.Event;

public class Buzon {


    private ArrayList<Evento> cola;
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

            ocupantes++;
            depositar(ev);
            notify();

        }
    }


    public synchronized void salir(Evento ev){

        while (ocupantes == 0 ) {

            try{
                wait();
            } catch(InterruptedException e){

            }

            ocupantes--;
            retirar(ev);
            notify();
            
        }


    }


    public void depositar(Evento e){

        cola.add(e);
    }

    public void retirar(Evento e){

        cola.remove(e);
    }



    


}
