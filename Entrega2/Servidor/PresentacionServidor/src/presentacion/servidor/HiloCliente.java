
package presentacion.servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import logicaNegocio.Peticion;
import logicaNegocio.EmpleadoXPassword;
import accesoDatos.vo.Empleado;
import accesoDatos.util.Log;

/**
 *
 * @author acactown
 */
public class HiloCliente implements Runnable{

    Socket skClienteComunicacion = null;
    Socket skClientePeticiones = null;
    ObjectInputStream entradaComunicacion = null;
    ObjectOutputStream salidaComunicacion = null;
    ObjectOutputStream salidaPeticiones = null;
    public static Vector<HiloCliente> clientesActivos = new Vector();
    Peticion peticion;
    boolean atendiendo;
    
    public HiloCliente(Socket skClienteComunicacion,Socket skClientePeticiones){
        this.skClienteComunicacion = skClienteComunicacion;
        this.skClientePeticiones = skClientePeticiones;
        clientesActivos.add(this);
        peticion = new Peticion(0, "Iniciar Sesion", "N/A");
        atendiendo = true;
     }
     
     public void run(){
        Log.setEvento("Servidor","INFO","Esperando Peticiones del Cliente :"+ this);
        try{
            // Paso 3: obtener flujos de entrada y salida.
     
            salidaComunicacion =new ObjectOutputStream(skClienteComunicacion.getOutputStream()); // establecer flujo de salida para los objetos
            entradaComunicacion = new ObjectInputStream(skClienteComunicacion.getInputStream()); // establecer flujo de entrada para los objetos
            salidaPeticiones =new ObjectOutputStream(skClienteComunicacion.getOutputStream()); // establecer flujo de salida para los objetos
            
            // Paso 4: procesar la conexion.
            try{
                peticion = ( Peticion )entradaComunicacion.readObject();
            }catch(ClassNotFoundException ex ) {
                Log.setEvento("Servidor","ERROR","Entrada Desconocida :"+ ex.getMessage());
            }
            Log.setEvento("Servidor","INFO","Se Agrega Cliente : "+ this +
                                            "<div class=\"salto\"><p><b>Empleado    :</b>"+ peticion.getNombreEmpleado() +
                                            "</p><p><b>Desde IP    :</b>"+ String.valueOf(skClienteComunicacion.getInetAddress()) +
                                            "</p><p><b>Nombre Host :</b>"+ skClienteComunicacion.getInetAddress().getHostName() +"</p></div>"); 
        }catch(IOException ex) {
            Log.setEvento("Servidor","ERROR",ex.getMessage());
        }
                      
        while( atendiendo ){
            try{
                 switch( peticion.getOpcionPeticion() ){
                     case 1://se envia un Empleado al conocer el password
                            Empleado empleado = EmpleadoXPassword.getEmpleado( peticion.getParametroPeticion());
                            salidaPeticiones.writeObject(empleado);                    
                     break;
                 }
            } catch (IOException ex) {
                Log.setEvento("Servidor","INFO","El Cliente Termino la Conexion: "+ this +
                                            "<div class=\"salto\"><p><b>Empleado    :</b>"+ peticion.getNombreEmpleado() +
                                            "</p><p><b>Desde IP    :</b>"+ String.valueOf(skClienteComunicacion.getInetAddress()) +
                                            "</p><p><b>Nombre Host :</b>"+ skClienteComunicacion.getInetAddress().getHostName() +"</p></div>"); 
                break;
            }
        }
    	Log.setEvento("Servidor","INFO","Se Retiro el Cliente: " + this +
                                    "<div class=\"salto\"><p><b>Empleado    :</b>"+ peticion.getNombreEmpleado() +
                                    "</p><p><b>Desde IP    :</b>"+ String.valueOf(skClienteComunicacion.getInetAddress()) +
                                    "</p><p><b>Nombre Host :</b>"+ skClienteComunicacion.getInetAddress().getHostName() +"</p></div>"); 
    	clientesActivos.removeElement(this);
    	try{
            Log.setEvento("Servidor","INFO","Se Desconecto el Cliente: " + this +
                                        "<div class=\"salto\"><p><b>Empleado    :</b>"+ peticion.getNombreEmpleado() +
                                        "</p><p><b>Desde IP    :</b>"+ String.valueOf(skClienteComunicacion.getInetAddress()) +
                                        "</p><p><b>Nombre Host :</b>"+ skClienteComunicacion.getInetAddress().getHostName() +"</p></div>"); 
            skClienteComunicacion.close();
        } catch(Exception ex){
            Log.setEvento("Servidor","ERROR", ex.getMessage());
        }         
     }
    
}
