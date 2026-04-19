import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
 

    public static void main(String[] args){



        String nombreArchivo = "config.txt";
        int ni = 0;
        int eventosBase = 0;
        int nc = 0;
        int ns = 0;
        int tam1 = 0;
        int tam2 = 0;

        try{

            Scanner scanner = new Scanner(new File(nombreArchivo));

            ni = scanner.nextInt();
            eventosBase = scanner.nextInt();
            ns = scanner.nextInt();
            tam1 = scanner.nextInt();
            tam2 = scanner.nextInt();

            scanner.close();

            System.out.println("Parámetros cargados:");
            System.out.println("  ni (sensores): " + ni);
            System.out.println("  eventosBase: " + eventosBase);
            System.out.println("  nc (clasificadores): " + nc);
            System.out.println("  ns (servidores): " + ns);
            System.out.println("  tam1 (capacidad buzón clasificación): " + tam1);
            System.out.println("  tam2 (capacidad buzón servidores): " + tam2);

        } catch(FileNotFoundException e){

            System.err.println("Error: No se encontró el archivo " + nombreArchivo);
            e.printStackTrace();
            System.exit(1);


        }

        int totalEventos = 0;

        for(int i = 0 ; i < ni ; i++){

            totalEventos += eventosBase * i;

        }

        Buzon buzonEntrada = new Buzon(2000000);
        Buzon buzonAlertas = new Buzon(2000000);
        Buzon buzonClasificador = new Buzon(tam1); 

        Buzon[] buzonesServidores = new Buzon[ns];


        for (int i = 0; i < ns; i++){

            buzonesServidores[i] = new Buzon(tam2);
        }


        // Sensores


        Sensor[] sensores = new Sensor[ni];


        for(int i = 0; i < ni; i++){

            sensores[i] = new Sensor(i+1, eventosBase, ns, buzonEntrada);
        }


        // Broker

        Broker broker = new Broker(buzonEntrada, buzonAlertas, buzonClasificador, totalEventos);

        // Administrador

        Administrador admin = new Administrador(buzonAlertas, buzonClasificador, nc);

        // Clasificadores

        Clasificador[] clasificadores = new Clasificador[nc];

        for(int i = 0; i< nc;i++){


            clasificadores[i] = new Clasificador(buzonClasificador, buzonesServidores, nc);
        }

        // Servidores
        Servidor[] servidores = new Servidor[ns];
        for (int i = 0; i < ns; i++) {
            servidores[i] = new Servidor(buzonesServidores[i]);
        }


    }

}
