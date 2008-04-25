
package presentacion.servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import logicaNegocio.servicios.Peticion;
import logicaNegocio.servicios.EmpleadoXPassword;
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
        Log.setEvento("Servidor","INFO","Esperando Peticiones del Cliente");
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
            Log.setEvento("Servidor","INFO","Atendiendo Cliente desde IP : "+ skClienteComunicacion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getNombreEmpleado() +"</p>" ); 
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
                Log.setEvento("Servidor","INFO","El Cliente Termino la Conexion desde IP : "+ skClienteComunicacion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getNombreEmpleado() +"</p>" ); 
                break;
            }
        }
    	Log.setEvento("Servidor","INFO","Se Retiro el Cliente desde IP : "+ skClienteComunicacion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getNombreEmpleado() +"</p>" ); 
    	clientesActivos.removeElement(this);
    	try{
            Log.setEvento("Servidor","INFO","Se Desconecto el Cliente desde IP : "+ skClienteComunicacion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getNombreEmpleado() +"</p>" ); 
            skClienteComunicacion.close();
        } catch(Exception ex){
            Log.setEvento("Servidor","ERROR", ex.getMessage());
        }         
     }
    
}
