
package SourceLogicaNegocioServidor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author acactown
 */
public class LogServidor {
    
    private static PrintWriter escritorArchivo = null;
    private static PrintWriter escritorConsola = null;
    private static Calendar fecha;
    private static List<String> dias = new ArrayList<String>();    
    private static List<String> meses = new ArrayList<String>();
    
    public static void setSalida (){
        dias.add("Lunes");dias.add("Martes");dias.add("Miercoles");dias.add("Jueves");dias.add("Viernes");dias.add("Sabado");dias.add("Domingo");        
        meses.add("Enero");meses.add("Febrero");meses.add("Marzo");meses.add("Abril");meses.add("Mayo");meses.add("Junio");meses.add("Julio");meses.add("Agosto");meses.add("Septiembre");meses.add("Octubre");meses.add("Noviembre");meses.add("Diciembre");
        String nombreLog = "LogServidor.log"; 
        String ip = "N/A",host="N/A";
        try {
            escritorArchivo = new PrintWriter(new FileWriter(nombreLog,true));
            escritorConsola = new PrintWriter(System.out);
            InetAddress ipservidor = InetAddress.getLocalHost();
            ip = String.valueOf(ipservidor);
            host = ipservidor.getHostName();
        } catch (IOException io) {
            System.out.println("Error :  al intentar abrir el archivo : "+nombreLog +
                                         "\n no se puede crear el Log del Servidor");
        }finally{
            escritorArchivo.println("\n------------------------| LOG DE SERVIDOR |-------------------" +
                             "\n  IP del Servidor : " + ip +
                             "\n  Nombre del Host : "+ host +
                             "\n  Fecha y Hora de Inicio : "+ tiempoEvento() +
                             "\n--------------------------------------------------------------");
            escritorArchivo.flush();
            escritorConsola.println("\n------------------------| LOG DE SERVIDOR |-------------------" +
                             "\n  IP del Servidor : " + ip +
                             "\n  Nombre del Host : "+ host +
                             "\n  Fecha y Hora de Inicio : "+ tiempoEvento() +
                             "\n--------------------------------------------------------------");
            escritorConsola.flush();
        }
    }
    
    public static void setEvento(String evento) {
        escritorArchivo.println("\n"+ tiempoEvento() +" -->"+ evento);
        escritorArchivo.flush();
        escritorConsola.println("\n"+ tiempoEvento() +" -->"+ evento);
        escritorConsola.flush();
    }
    
    private static  String tiempoEvento(){   
        fecha = Calendar.getInstance();
        String dia = dias.get(fecha.get(Calendar.DAY_OF_WEEK) -1 );
        String diaMes = tiempoExacto(fecha.get(Calendar.DAY_OF_MONTH) );
        String mes = meses.get(fecha.get(Calendar.MONTH)-1 );
        String anio = tiempoExacto(fecha.get(Calendar.YEAR) );
        String horas = tiempoExacto(fecha.get(Calendar.HOUR_OF_DAY) );
        String minutos = tiempoExacto(fecha.get(Calendar.MINUTE) );
        String segundos = tiempoExacto(fecha.get( Calendar.SECOND) );
        return dia +" "+ diaMes +"/"+ mes +"/"+ anio +"  <"+horas +":"+ minutos +":"+ segundos +">";
    }
    
    private static String tiempoExacto(int unidadTiempo){
        if( unidadTiempo < 10 ) return "0"+ String.valueOf(unidadTiempo);
        return String.valueOf(unidadTiempo);
    }
    

}
