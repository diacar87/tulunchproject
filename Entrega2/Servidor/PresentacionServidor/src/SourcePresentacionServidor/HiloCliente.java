
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
        peticion = new Peticion(0, "N/A");
        atendiendo = true;
     }
     
     public void run(){
        LogServidor.setEvento("Esperando Peticiones del Cliente :"+ this);
        try{
            entradaComunicacion = new ObjectInputStream(skClienteComunicacion.getInputStream());
            salidaComunicacion =new ObjectOutputStream(skClienteComunicacion.getOutputStream());
            salidaPeticiones = new ObjectOutputStream(skClientePeticiones.getOutputStream());
            try{
                peticion = ( Peticion )entradaComunicacion.readObject();
            }catch(ClassNotFoundException ex ) {
                LogServidor.setEvento("Error 3: Falla de Comunicacion de Entrada Desconocida: " + skClienteComunicacion + 
                      "\n               Causa :" + ex.getMessage());
            }
            LogServidor.setEvento("Se Agrega Cliente: "+ this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
        }catch(IOException ex) {
            LogServidor.setEvento("Error 4: Falla de Comunicacion: " + skClienteComunicacion + 
                      "\n               Causa :" + ex.getMessage());
        }
        int opcion = 0;              
    	while( atendiendo ){
          try{
             opcion = entradaComunicacion.readInt();
             switch( opcion ){

             }
          }catch (IOException e) {
              LogServidor.setEvento("El Cliente Termino la Conexion: " + this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
              break;
          }
        }
        
    	LogServidor.setEvento("Se Retiro el Cliente: " + this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
    	clientesActivos.removeElement(this);
    	try{
            LogServidor.setEvento("Se Desconecto el Cliente: " + this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
            skClienteComunicacion.close();
        } catch(Exception ex){
            LogServidor.setEvento("Error 5: No se pudo Cerrar la Comunicacion: " + skClienteComunicacion + 
                      "\n               Causa :" + ex.getMessage());
        }         
     }
    
}
