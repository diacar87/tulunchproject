
package SourcePresentacionServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import SourceLogicaNegocioServidor.LogServidor;
import SourceLogicaNegocioServidor.Peticion;

/**
 *
 * @author acactown
 */
public class HiloCliente implements Runnable{

    Socket skClienteComunicacion = null;
    //Socket skClientePeticiones = null;
    ObjectInputStream entradaComunicacion = null;
    ObjectOutputStream salidaComunicacion = null;
    //ObjectOutputStream salidaPeticiones = null;
    public static Vector<HiloCliente> clientesActivos = new Vector();
    Peticion peticion;
    boolean atendiendo;
    
     //public HiloCliente(Socket skClienteComunicacion,Socket skClientePeticiones){
     public HiloCliente(Socket skClienteComunicacion){
        this.skClienteComunicacion = skClienteComunicacion;
        //this.skClientePeticiones = skClientePeticiones;
        clientesActivos.add(this);
        peticion = new Peticion(0, "N/A");
        atendiendo = true;
     }
     
     public void run(){
        LogServidor.setEvento("Esperando Peticiones del Cliente :"+ this);
        try{
            entradaComunicacion = new ObjectInputStream(skClienteComunicacion.getInputStream());
            salidaComunicacion =new ObjectOutputStream(skClienteComunicacion.getOutputStream());
            //salidaPeticiones = new ObjectOutputStream(skClientePeticiones.getOutputStream());
            try{
                peticion = ( Peticion )entradaComunicacion.readObject();
            }catch(ClassNotFoundException ex ) {
                LogServidor.setEvento("Error 3: Falla de Comunicacion de Entrada Desconocida: " + skClienteComunicacion + 
                      "\n               Causa :" + ex.getMessage());
            }
            LogServidor.setEvento("Se Agrega Cliente: "+ this +
                       "\n               Empleado    : "+ peticion.getNombreEmpleado() +
                       "\n               Desde IP    : " + String.valueOf(skClienteComunicacion.getInetAddress()) +
                       "\n               Nombre Host : " + skClienteComunicacion.getInetAddress().getHostName());
        }catch(IOException ex) {
            LogServidor.setEvento("Error 4: Falla de Comunicacion: " + skClienteComunicacion + 
                      "\n               Causa :" + ex.getMessage());
        }
                      
    	while( atendiendo ){
             switch( peticion.getOpcionPeticion() ){
                 case 1://se envia un Empleado al conocer el password

             }
        }        
     
        
    	LogServidor.setEvento("Se Retiro el Cliente: " + this +
                       "\n               Empleado    : "+ peticion.getNombreEmpleado() +
                       "\n               Desde IP    : " + String.valueOf(skClienteComunicacion.getInetAddress()) +
                       "\n               Nombre Host : " + skClienteComunicacion.getInetAddress().getHostName());
    	clientesActivos.removeElement(this);
    	try{
            LogServidor.setEvento("Se Desconecto el Cliente: " + this +
                       "\n               Empleado    : "+ peticion.getNombreEmpleado() +
                       "\n               Desde IP    : " + String.valueOf(skClienteComunicacion.getInetAddress()) +
                       "\n               Nombre Host : " + skClienteComunicacion.getInetAddress().getHostName());
            skClienteComunicacion.close();
        } catch(Exception ex){
            LogServidor.setEvento("Error 5: No se pudo Cerrar la Comunicacion: " + skClienteComunicacion + 
                      "\n               Causa :" + ex.getMessage());
        }         
     }
    
}
