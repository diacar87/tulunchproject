
package accesoDatos.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *  Recibe los diferentes eventos y los escribe en el Log HTML
 * @author acactown
 */
public class Log {
    
    private static PrintWriter escritorArchivo;
    private static Calendar fecha;
    private static List<String> dias = new ArrayList<String>();    
    private static List<String> meses = new ArrayList<String>();
    private static String usuario;
    private static File nombreLog;
    private static boolean infoInicial = false;
    
    /**
     * Cada vez que se decide a escribir un evento tiene que crearse el escritor puesto que la clse es static 
     */
    private static void crearEscritor(){
        dias.add("Domingo");dias.add("Lunes");dias.add("Martes");dias.add("Miercoles");dias.add("Jueves");dias.add("Viernes");dias.add("Sabado");        
        meses.add("Enero");meses.add("Febrero");meses.add("Marzo");meses.add("Abril");meses.add("Mayo");meses.add("Junio");meses.add("Julio");meses.add("Agosto");meses.add("Septiembre");meses.add("Octubre");meses.add("Noviembre");meses.add("Diciembre");
        try {
            escritorArchivo = new PrintWriter(new FileWriter(nombreLog, true));
        } catch (IOException ex) {
            System.out.println("ERROR :  Al intentar Abrir el Archivo : "+ nombreLog + "No se puede crear el Log del " + usuario +
                    "\n               DETALLE : " + ex.getMessage());
        }
    }
    /**
     * Metodo para crear el archivo HTML que crea la cabezara del Log.
     * Es decir los datos Basicos de la maquina en donde corre el Usuario.
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
            InetAddress ipUsuario = InetAddress.getLocalHost();
            ip = ipUsuario.getHostAddress();
            host = ipUsuario.getHostName();
            SO = System.getProperty("os.name");
            VSO = System.getProperty("os.version");
            arquitectura = System.getProperty("os.arch");
        } catch (IOException ex) {
            System.out.println("ERROR :  Al Obtener IP y Nombre Host del " + usuario +
                    "\n               DETALLE : " + ex.getMessage());
        }finally{
            String primerLog = "<html> <head> <title>Sistema Para Gestion de Pedidos Tu Lunch - Log Servidor</title> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <meta name=\"generator\" content=\"NetBeans IDE 6.0\"> <meta name=\"author\" content=\"DeveloperDreamTeam\"> <style> *{ margin:0px; padding:0px; font-size:13px; }#contenido{ margin:30px auto 10px auto; width:760px; color:#000; background-color:#FFF; }#titulo{ font-size:20px; margin-bottom:5px; text-align:center; }#subTitulo{ font-size:15px; text-align:center;} #cabezera{ width:500px; margin:0px auto; }#infoInicial{ width:500px; border-top:1px solid #B47420; }.tipoDatoInicial{ background-color:#FFA023; color:#FFF; font-weight:bold; width:160px; padding-left:5px; border-right:1px solid #B47420; border-left:1px solid #B47420; border-bottom:1px solid #B47420; }.datoInicial{ padding-left:5px; border-right:1px solid #B47420; border-bottom:1px solid #B47420; }#contenidoLogs{ width:830px; margin:0px auto; text-align:center; color:#000; background-color:#FFF; }#cabezeraLogs{ color:#FFF; font-weight:bold; background-color:#FFA023; text-align:center; border-top:1px solid #B47420; }.tipoEvento{ text-align:center; width:110px; border-right:1px solid #B47420; border-bottom:1px solid #B47420; }.detalleEvento{ width:470px; border-right:1px solid #B47420; border-bottom:1px solid #B47420; } .contenidoDetalle{ padding-left:5px; text-align:left; font-size:11px; } .fechaEvento{ text-align:center; width:240px; border-right:1px solid #B47420; border-bottom:1px solid #B47420; border-left:1px solid #B47420; }.salto{ text-align:left; padding-left:33px; font-size:11px; } </style> </head> <body> <div id=\"contenido\"> <h1 id=\"titulo\">Sistema Para Gestion de Pedidos Tu Lunch</h1> <h2 id=\"subTitulo\">Log del "+ usuario +"</h2> <br> <div id=\"cabezera\"> <table id=\"infoInicial\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tbody> <tr><td class=\"tipoDatoInicial\">IP del Servidor :</td><td class=\"datoInicial\">"+ ip +"</td></tr> <tr><td class=\"tipoDatoInicial\">Nombre del Host :</td><td class=\"datoInicial\">"+ host +"</td></tr> <tr><td class=\"tipoDatoInicial\">Sistema Operativo :</td><td class=\"datoInicial\">"+ SO +"</td></tr> <tr><td class=\"tipoDatoInicial\">Version del SO :</td><td class=\"datoInicial\">"+ VSO +"</td></tr> <tr><td class=\"tipoDatoInicial\">Arquitectura :</td><td class=\"datoInicial\">"+ arquitectura +"</td></tr> <tr><td class=\"tipoDatoInicial\">Fecha y Hora de Inicio :</td><td class=\"datoInicial\">"+ tiempoEvento() +"</td></tr> </tbody> </table> </div> <br> </div> <div id=\"contenidoLogs\"> <table id=\"cabezeraLogs\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tbody> <tr><td class=\"fechaEvento\">Fecha y Hora de Evento</td><td class=\"tipoEvento\">Tipo de Evento</td><td class=\"detalleEvento\">Detalle del Evento</td></tr> </tbody> </table> </div>";
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
     * @param usuarioEvento Recibe 
     * @param tipoEvento Recibe el Tipo de evento bien sea <tt>INFO</tt>,<tt>ERROR</tt> o <tt>WARNING</tt>
     * o el que se quiera como tipo de Evento.
     * @param evento  Recibe el evento a escribir en el Log HTML
     */
    public static void setEvento(String usuarioEvento,String tipoEvento, String evento) {
        usuario = usuarioEvento;
        nombreLog = new File("../../Log"+ usuario +".html");
        String log;
        if(!infoInicial){
            infoInicial = true;
            setSalida();
            log = "<div id=\"contenidoLogs\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tbody> <tr><td class=\"fechaEvento\">"+ tiempoEvento() +"</td><td class=\"tipoEvento\">"+ tipoEvento +"</td><td class=\"detalleEvento\"><div class=\"contenidoDetalle\">"+ evento +"</div></td></tr> </tbody> </table> </div>";
            escribir(log );
        }
        else{
            crearEscritor();
            log = "<div id=\"contenidoLogs\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tbody> <tr><td class=\"fechaEvento\">"+ tiempoEvento() +"</td><td class=\"tipoEvento\">"+ tipoEvento +"</td><td class=\"detalleEvento\"><div class=\"contenidoDetalle\">"+ evento +"</div></td></tr> </tbody> </table> </div>";
            escribir(log );
        }
        if(tipoEvento.equals("ERROR")){
            log = "<div id=\"contenidoLogs\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tbody> <tr><td class=\"fechaEvento\">"+ tiempoEvento() +"</td><td class=\"tipoEvento\">INFO</td><td class=\"detalleEvento\"><div class=\"contenidoDetalle\">Cerrando Aplicacion.</div></td></tr> </tbody> </table> </div>";
            escribir(log );
            JOptionPane.showMessageDialog(null,"ERROR : "+ evento +"\nPor favor pongase en contacto con el Administrador.","ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if(tipoEvento.equals("WARNING")){
            JOptionPane.showMessageDialog(null,"WARNING : "+ evento +"\nPor favor pongase en contacto con el Administrador.","WARNING",JOptionPane.WARNING_MESSAGE);
        }
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
