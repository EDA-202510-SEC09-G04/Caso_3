public class Clasificador extends Thread{

    private Buzon buzonClasificador;
    private boolean terminado = false;
    private Buzon buzonServidor;
    private int EventosFin;
    private int numeroClasificadores;
    private static int clasificadoresTerminados = 0;
    

    public Clasificador( Buzon buzonClasdificador, Buzon buzonServidor,int EventosFin, int numeroClasificadores){

        this.buzonClasificador = buzonClasdificador;
        this.buzonServidor = buzonServidor;
        this.EventosFin = EventosFin;
        this.numeroClasificadores = numeroClasificadores;




    }


    @Override


    public void run(){


        while (!terminado) {

            Evento eventoAEval = buzonClasificador.retirar();

            if (eventoAEval.EsFin()){

                terminado = true;
            }
           


            if(clasificadoresTerminados == numeroClasificadores-1){

                for (int i = 0; i < EventosFin; i++){



                }


            }



            
        }


        clasificadoresTerminados++;



    }





}
