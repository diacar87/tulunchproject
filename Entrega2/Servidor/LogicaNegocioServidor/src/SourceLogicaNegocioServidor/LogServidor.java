
package SourceLogicaNegocioServidor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *  Recibe los diferentes eventos y los escribe en el Log HTML
 * @author acactown
 */
public class LogServidor {
    
    private static PrintWriter escritorArchivo;
    private static Calendar fecha;
    private static List<String> dias = new ArrayList<String>();    
    private static List<String> meses = new ArrayList<String>();
    private static File nombreLog = new File("../../LogServidor.html");
    
    /**
     * Cada vez que se decide a escribir un evento tiene que crearse el escritor puesto que la clse es static 
     */
    private static void crearEscritor(){
        dias.add("Domingo");dias.add("Lunes");dias.add("Martes");dias.add("Miercoles");dias.add("Jueves");dias.add("Viernes");dias.add("Sabado");        
        meses.add("Enero");meses.add("Febrero");meses.add("Marzo");meses.add("Abril");meses.add("Mayo");meses.add("Junio");meses.add("Julio");meses.add("Agosto");meses.add("Septiembre");meses.add("Octubre");meses.add("Noviembre");meses.add("Diciembre");
        try {
            escritorArchivo = new PrintWriter(new FileWriter(nombreLog, true));
        } catch (IOException ex) {
            System.out.println("ERROR :  Al intentar Abrir el Archivo : "+ nombreLog + "No se puede crear el Log del Servidor" +
                    "\n               DETALLE : " + ex.getMessage());
        }
    }
    /**
     * Metodo para crear el archivo HTML que crea la cabezara del Log.
     * Es decir los datos Basicos de la maquina en donde corre el servidor.
     * Por eso debe ser lo primero que se ejecute antes de registar cualquier evento.
     * si el archivo Ya existe lo borra y lo crea nuevamente.
     */
    public static void setSalida (){
        if(nombreLog.exists()) nombreLog.delete();
        crearEscritor();
        String ip = "No se puedo Obtener La IP";
        String host="No se puedo Obtener el Nombre del Host";
        String SO = "No se puedo Obtener el Nombre del Sistema Operativo";
        String VSO = "No se puedo Obtener la Version del Sistema Operativo";
        String arquitectura = "No se puedo Obtener la Arquitectura del Sistema";
        
        try {
            InetAddress ipServidor = InetAddress.getLocalHost();
            ip = String.valueOf(ipServidor);
            host = ipServidor.getHostName();
            SO = System.getProperty("os.name");
            VSO = System.getProperty("os.version");
            arquitectura = System.getProperty("os.arch");
        } catch (IOException ex) {
            System.out.println("ERROR :  Al Obtener IP y Nombre Host del Servidor" +
                    "\n               DETALLE : " + ex.getMessage());
        }finally{
            String primerLog = "<html><head><title>Sistema Para Gestion de Pedidos Tu Lunch - Log Servidor</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /><meta name=\"generator\" content=\"NetBeans IDE 6.0\" /><meta name=\"author\" content=\"DeveloperDreamTeam\" />" +
                               "<style>*{margin:0px;padding:0px;font-size:13px;}td{line-height:11pt;}#contenido{margin:30px auto 10px auto;width:760px;color:#000;background-color:#FFF;}#titulo{font-size:20px;margin-bottom:5px;text-align:center;}#subTitulo{font-size:15px;text-align:center;}#cabezera{width:500px;margin:0px auto;}#infoInicial{width:500px;}.tipoDatoInicial{background-color:#FFA023;color:#FFF;font-weight:bold;width:160px;padding-left:5px;border-right:1px solid #B47420;border-left:1px solid #B47420;border-bottom:1px solid #B47420;}.datoInicial{padding-left:5px;border-right:1px solid #B47420;border-bottom:1px solid #B47420;}#contenidoLogs{width:829px;margin:0px auto;text-align:center;color:#000;background-color:#FFF;}#cabezeraLogs{color:#FFF;font-weight:bold;background-color:#FFA023;}.tipoEvento{width:120px;border-right:1px solid #B47420;border-bottom:1px solid #B47420;}.detalleEvento{width:460px;border-right:1px solid #B47420;border-bottom:1px solid #B47420;}.fechaEvento{width:250px;border-right:1px solid #B47420;border-bottom:1px solid #B47420;border-left:1px solid #B47420;}.superior{border-top:1px solid #B47420;}.salto{text-align:left;margin:0px auto;padding-left:70px;}</style>"+
                               "</head><body><div id=\"contenido\"><h1 id=\"titulo\">Sistema Para Gestion de Pedidos Tu Lunch</h1><h2 id=\"subTitulo\">LOG DEL SERVIDOR</h2><br /><div id=\"cabezera\"><table id=\"infoInicial\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><div class=\"superior\"><td class=\"tipoDatoInicial\">IP del Servidor :</td><td class=\"datoInicial\">"+ ip +
                               "</td></div></tr><tr><td class=\"tipoDatoInicial\">Nombre del Host :</td><td class=\"datoInicial\""+ host +
                               "</td></tr><tr><td class=\"tipoDatoInicial\">Sistema Operativo :</td><td class=\"datoInicial\">"+ SO +
                               "</td></tr><tr><td class=\"tipoDatoInicial\">Version del SO :</td><td class=\"datoInicial\">"+ VSO +
                               "</td></tr><tr><td class=\"tipoDatoInicial\">Arquitectura :</td><td class=\"datoInicial\">"+ arquitectura +
                               "</td></tr><tr><td class=\"tipoDatoInicial\">Fecha y Hora de Inicio :</td><td class=\"datoInicial\">"+ tiempoEvento() +
                               "</td></tr></table></div><br /></div><div id=\"contenidoLogs\"><table id=\"cabezeraLogs\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><div class=\"superior\"><td class=\"fechaEvento\">Fecha de Evento</td><td class=\"tipoEvento\">Tipo de Evento</td><td class=\"detalleEvento\">Detalle del Evento</td></div></tr></table></div>";
            escribir(primerLog);
        }
    }
    
    /**
     * Escribe el evento que se desato y los escribe en el Archivo Log HTML
     * @param evento Recibe el evento a escribir en el Log HTML
     */
    private static void escribir(String evento){
        escritorArchivo.println(evento);
        escritorArchivo.flush();
    }
    /**
     * Recibe los parametros tipo de evento y evento a escribir en el log HTML
     * @param tipoEvento Recibe el Tipo de evento bien sea <tt>INFO</tt>,<tt>ERROR</tt> o <tt>WARNING</tt>
     * o el que se quiera como tipo de evento
     * @param evento  Recibe el evento a escribir en el Log HTML
     */
    public static void setEvento(String tipoEvento, String evento) {
        crearEscritor();
        String log = "<div id=\"contenidoLogs\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td class=\"fechaEvento\">"+ tiempoEvento() +"</td><td class=\"tipoEvento\">"+ tipoEvento +"</td><td class=\"detalleEvento\">"+ evento +"</td></tr></table></div>";
        escribir(log );
    }
    /**
     * Calcula la hora del Sistema en la cual este metodo fue invocado
     * @return Retorna la Hora del Sistema Exacta en la cual se invoca al metodo
     */
    private static  String tiempoEvento(){
        fecha = Calendar.getInstance();
        String dia = dias.get(fecha.get(Calendar.DAY_OF_WEEK) -1 );
        String diaMes = tiempoExacto(fecha.get(Calendar.DAY_OF_MONTH) );
        String mes = meses.get(fecha.get(Calendar.MONTH) );
        String anio = tiempoExacto(fecha.get(Calendar.YEAR) );
        String horas = tiempoExacto(fecha.get(Calendar.HOUR_OF_DAY) );
        String minutos = tiempoExacto(fecha.get(Calendar.MINUTE) );
        String segundos = tiempoExacto(fecha.get( Calendar.SECOND) );
        return dia +" "+ diaMes +"/"+ mes +"/"+ anio +"  <"+horas +":"+ minutos +":"+ segundos +">";
    }
    /**
     * Recibe un  numero que puede ser de un digito o dos, si es de un digito le antepone el 0.
     * Ej: entra 8 retorna 08
     * @param unidadTiempo El numero a comparar
     * @return String un numero de dos diguitos 
     */
    private static String tiempoExacto(int unidadTiempo){
        if( unidadTiempo < 10 ) return "0"+ String.valueOf(unidadTiempo);
        return String.valueOf(unidadTiempo);
    }
    

}
