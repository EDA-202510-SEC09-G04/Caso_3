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


    
  






}
