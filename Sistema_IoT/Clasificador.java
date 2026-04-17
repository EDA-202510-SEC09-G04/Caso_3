public class Clasificador extends Thread{

    private Buzon buzonClasificador;
    private boolean terminado = false;
    private Buzon[] buzonesServidor;
    private int EventosFin;
    private int numeroClasificadores;
    private static int clasificadoresTerminados = 0;
    

    public Clasificador( Buzon buzonClasdificador, Buzon[] buzonesServidor,int EventosFin, int numeroClasificadores){

        this.buzonClasificador = buzonClasdificador;
        this.buzonesServidor = buzonesServidor;
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

            else{

               for (int i = 0; i< buzonesServidor.length; i++){

                if (eventoAEval.getTipoServidor() == i){

                    buzonesServidor[i].entrar(eventoAEval);
                }

               }

            }
           


           



            
        }


       



    }





}
