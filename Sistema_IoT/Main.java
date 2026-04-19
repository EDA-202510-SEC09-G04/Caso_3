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
    }

}
