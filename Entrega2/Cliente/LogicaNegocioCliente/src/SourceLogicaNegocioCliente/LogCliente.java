
package SourceLogicaNegocioCliente;

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
public class LogCliente {
    
    private static PrintWriter escritorArchivo;
    private static PrintWriter escritorConsola;
    private static Calendar fecha;
    private static List<String> dias = new ArrayList<String>();    
    private static List<String> meses = new ArrayList<String>();
    private static String nombreLog;
    
    public static void crearEscritor(){
        dias.add("Lunes");dias.add("Martes");dias.add("Miercoles");dias.add("Jueves");dias.add("Viernes");dias.add("Sabado");dias.add("Domingo");        
        meses.add("Enero");meses.add("Febrero");meses.add("Marzo");meses.add("Abril");meses.add("Mayo");meses.add("Junio");meses.add("Julio");meses.add("Agosto");meses.add("Septiembre");meses.add("Octubre");meses.add("Noviembre");meses.add("Diciembre");
        nombreLog = "LogCliente.log";
        try {
            escritorArchivo = new PrintWriter(new FileWriter(nombreLog,true));
            escritorConsola = new PrintWriter(System.out);
        } catch (IOException ex) {
            System.out.println("ERROR :  Al intentar Abrir el Archivo : "+ nombreLog + "No se puede crear el Log del Cliente" +
                    "\n               DETALLE : " + ex.getMessage());
        }
    }
    
    public static void setSalida (){
        crearEscritor();
        String ip = "No se puedo Obtener La IP";
        String host="No se puedo Obtener el Nombre del Host";
        try {
            InetAddress ipCliente = InetAddress.getLocalHost();
            ip = String.valueOf(ipCliente);
            host = ipCliente.getHostName();
        } catch (IOException ex) {
            System.out.println("ERROR :  Al Obtener IP y Nombre Host del Cliente" +
                    "\n               DETALLE : " + ex.getMessage());
        }finally{
            String primerLog ="\n------------------------| LOG DE CLIENTE |-------------------" +
                              "\n  IP del Cliente  : " + ip +
                              "\n  Nombre del Host : "+ host +
                              "\n  Fecha y Hora de Inicio : "+ tiempoEvento() +
                              "\n--------------------------------------------------------------";
            escribir(escritorArchivo, primerLog);
            escribir(escritorConsola, primerLog);
            
        }
    }
    
    public static void escribir(PrintWriter escritor, String evento){
        escritor.println(evento);
        escritor.flush();
    }
    
    public static void setEvento(String evento) {
        crearEscritor();
        escribir(escritorArchivo, tiempoEvento() +" --> "+ evento );
        escribir(escritorConsola, tiempoEvento() +" --> "+ evento );
    }
    
    private static  String tiempoEvento(){
        fecha = Calendar.getInstance();
        String dia = dias.get(fecha.get(Calendar.DAY_OF_WEEK) -1 );
        String diaMes = tiempoExacto(fecha.get(Calendar.DAY_OF_MONTH) );
        String mes = meses.get(fecha.get(Calendar.MONTH) -1 );
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
