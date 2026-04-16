import java.util.Random;

public class Administrador extends Thread {

    private Buzon buzonAlertas;
    private Buzon buzonClasificacion;
    private boolean finRecibido = false;
    private int numeroClasificadores;

    public Administrador(Buzon buzonAlertas, Buzon buzonClasificacion, int numeroClasificadores){

        this.buzonAlertas = buzonAlertas;
        this.buzonClasificacion = buzonClasificacion;
        this.numeroClasificadores = numeroClasificadores;
       
    }



    @Override

    public void run(){

        Random random = new Random();
       

        while (!finRecibido) {

            

            Evento evento = buzonAlertas.retirar();

            if(evento == null){

                continue;
            }


            if(evento.EsFin() == true){

                finRecibido = true;
                System.out.println("Administrador recibió evento de fin");
            }


            for(int i = 0; i < buzonAlertas.obtenerCola().size(); i++){

                 int num = random.nextInt(21);

                if(num % 4 == 0){
                    buzonClasificacion.entrar(evento);

                    System.out.println("Administrador: evento " + evento.getId() + " es NORMAL → clasificación");
                }
                else{

                     System.out.println("Administrador: evento " + evento.getId() + " es MALICIOSO → DESCARTADO");
                }
            

            }

            
        }



        for(int i = 0; i < numeroClasificadores; i++){

            Evento eventoFin = new Evento(-1, -1, -1, true);

            buzonClasificacion.entrar(eventoFin);




        }


        System.out.println("Administrador terminó");



    }



}
