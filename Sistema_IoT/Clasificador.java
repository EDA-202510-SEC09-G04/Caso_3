public class Clasificador extends Thread{

    private Buzon buzonClasificador;
    private boolean terminado = false;
    private Buzon[] buzonesServidor;
    
    private int numeroClasificadores;
    private static int clasificadoresTerminados = 0;
    

    public Clasificador( Buzon buzonClasdificador, Buzon[] buzonesServidor, int numeroClasificadores){

        this.buzonClasificador = buzonClasdificador;
        this.buzonesServidor = buzonesServidor;
        this.numeroClasificadores = numeroClasificadores;




    }


    @Override


    public void run(){


        while (!terminado) {

            Evento eventoAEval = buzonClasificador.retirar();


            if (clasificadoresTerminados == numeroClasificadores-1){

                for(int i = 0 ; i < buzonesServidor.length; i++){
                    Evento eventoFin = new Evento(-1,-1,-1,true);

                    buzonesServidor[i].entrar(eventoFin);
                    System.out.println("Evento fin enviado al servidor número " + i );
                }

            }

            if (eventoAEval.EsFin()){

                terminado = true;
                clasificadoresTerminados++;
                System.out.println("Clasificador terminado por el evento fin con id" + eventoAEval.getId());
            }

            else{

               for (int i = 0; i< buzonesServidor.length; i++){

                if (eventoAEval.getTipoServidor() == i){

                    buzonesServidor[i].entrar(eventoAEval);
                    System.out.println("Evento enviado al servidor número" + i + "con el id" + eventoAEval.getId());
                }

               }

            }

          
           


           



            
        }


       



    }





}
