import java.util.Random;

public class Sensor  extends Thread{

 static int indentificador = 0;
 private int  valorbase;
 private Buzon buzonEntrada;
 private int eventosGenerados;
 private int numeroServidores;


 public Sensor(int valorbase, int numeroServidores, Buzon buzonEntrada){
    
    indentificador ++;
    this.valorbase = valorbase;
    this.numeroServidores = numeroServidores;
    this.buzonEntrada = buzonEntrada;
    this.eventosGenerados = 0;
    

 }




 @Override

 public void run(){

    Random numeroRandom = new Random();
    int eventosPorGenerar = indentificador * valorbase;


   

        for (int i = 1; i<= eventosPorGenerar; i++){

            int tipoServidor = numeroRandom.nextInt(numeroServidores) + 1;

            int idEvento = indentificador++;

            Evento nuEvento = new Evento(idEvento, indentificador, tipoServidor);
            buzonEntrada.entrar(nuEvento);
            eventosGenerados ++;
            


        }

    



 }

    
}
