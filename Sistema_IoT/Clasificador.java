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
        
    }





}
