import java.util.Random;

public class Evento  {

    private int identificador;
    private int idSensor;
    private int tipoServidor;
    private boolean esfin;


    public Evento(int identificador, int idSensor, int tipoServidor, boolean esfin){

        this.identificador = identificador;
        this.idSensor = idSensor;
        this.tipoServidor = tipoServidor;
        this.esfin = esfin;



    }

    public Evento(int identificador, int idSensor, int tipoServidor){

           this(identificador,idSensor,tipoServidor,false);

    }


    public  boolean EsFin(){

        return esfin;
    }

    public  int getId(){

        return identificador;
    }


    public int getTipoServidor(){

        return tipoServidor;
    }

    public int asignarServidor(){

        Random rand = new Random();
        int num = rand.nextInt(tipoServidor+1);

        return num;



    }

    
  






}
