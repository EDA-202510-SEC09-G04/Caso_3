import java.util.Random;

public class Servidor extends Thread {

    private Buzon buzonConsolidacion;
    private boolean terminado;


    public Servidor(Buzon buzonConsolidacion){

        this.buzonConsolidacion = buzonConsolidacion;
        this.terminado = false;


    }




    @Override
    public void run() {


        Random rand = new Random();

        while (!terminado) {

            int num = rand.nextInt(100,1001);
            

            Evento eventoAEval = buzonConsolidacion.salir();

            if(eventoAEval.EsFin()){

                terminado = true;
                System.out.println("Servidor terminado ");

            } else{

                System.out.println("Servidor: Procesando el evento...");

                try{
                Thread.sleep(num);
                } catch(InterruptedException e){

                }

                System.out.println("Servidor: Evento con id" + eventoAEval.getId() + "ha sido procesado");

            }


            
        }




    }



}
