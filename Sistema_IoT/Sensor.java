    import java.util.Random;

    public class Sensor  extends Thread{

    private int indentificador ;
    private int  valorbase;
    private Buzon buzonEntrada;
    private int numeroServidores;
    private int eventosGenerados;


    public Sensor(int identificador,int valorbase, int numeroServidores, Buzon buzonEntrada){
        
        this.indentificador = identificador;
        this.valorbase = valorbase;
        this.numeroServidores = numeroServidores;
        this.buzonEntrada = buzonEntrada;
        this.eventosGenerados = 0;
        

    }


    


    @Override


    

    public void run(){

        Random numeroRandom = new Random();
        int eventosPorGenerar = indentificador * valorbase;


    

            while (eventosGenerados < eventosPorGenerar){

                int tipoServidor = numeroRandom.nextInt(numeroServidores) + 1;
                int idEvento =  indentificador *(100) + eventosGenerados;

                Evento nuEvento = new Evento(idEvento, indentificador, tipoServidor);
                buzonEntrada.entrarSemiActiva(nuEvento);
                eventosGenerados++;
                
                


            }

        
            System.out.println("Sensor con id: " + indentificador + " a creado " + eventosGenerados + "eventos");



    }

        
    }
