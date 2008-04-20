
package SourcePresentacionServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import SourceLogicaNegocioServidor.LogServidor;
import SourceLogicaNegocioServidor.Peticion;
import java.io.IOException;



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
        peticion = new Peticion();
        atendiendo = true;
     }
     
     public void run(){
        LogServidor.setEvento("Esperando Peticiones del Cliente :"+ this);
        try{
            entradaComunicacion = new ObjectInputStream(skClienteComunicacion.getInputStream());
            salidaComunicacion =new ObjectOutputStream(skClienteComunicacion.getOutputStream());
            salidaPeticiones = new ObjectOutputStream(skClientePeticiones.getOutputStream());
            peticion.setNombreEmpleado(entradaComunicacion.readUTF());
            LogServidor.setEvento("Se Agrega Cliente: "+ this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
        }catch(IOException e) {
            LogServidor.setEvento("Error 3: Falla de Comunicacion: " + skClienteComunicacion + "\n               Causa :" + e.getMessage());
        }
        int opcion = 0;              
    	while( atendiendo ){
          try{
             opcion = entradaComunicacion.readInt();
             switch( opcion ){

             }
          }catch (IOException e) {
              LogServidor.setEvento("Fallo Comunicacion con el Cliente: " + this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
              break;
          }
        }
        
    	LogServidor.setEvento("Se Retiro el Cliente: " + this +
                       "\n               Empleado : "+ peticion.getNombreEmpleado());
    	clientesActivos.removeElement(this);
    	try
    	{
          serv.mostrar("Se desconecto un usuario");
          scli.close();
    	}	
        catch(Exception et)
        {serv.mostrar("no se puede cerrar el socket");}  */        
     }
     


}
