
package presentacion.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import accesoDatos.util.Log;
import accesoDatos.util.PropiedadesConexion;



/**
 *
 * @author acactown
 */
public class Servidor implements Runnable{
    
    boolean escuchando = true;
    
    public Servidor() {
    }

    public void run(){
        try{
             // Paso 1: crear  e instanciar objetos  ServerSocket
            ServerSocket  skServerComunicacion = new ServerSocket( PropiedadesConexion.getPuertoComunicacion() );
            ServerSocket skServerPeticiones = new ServerSocket( PropiedadesConexion.getPuertoPeticion() );
            Log.setEvento("Servidor","INFO","El Servidor esta Corriendo.");
            Log.setEvento("Servidor","INFO","El Servidor esta escuchando por el puerto "+ skServerComunicacion.getLocalPort());
            Log.setEvento("Servidor","INFO","El Servidor esta atendiendo por el puerto "+ skServerPeticiones.getLocalPort());
            while( escuchando ){
                Socket skComunicacion = null;
                Socket skPeticiones = null;
                try {
                    Log.setEvento("Servidor","INFO","Esperando Cliente.");
                    // Paso 2: esperar una conexion.
                    
                    skComunicacion = skServerComunicacion.accept();
                    skPeticiones = skServerPeticiones.accept();
                } catch (IOException e){
                    Log.setEvento("Servidor","WARNING", e.getMessage());
                    continue;
                }
                HiloCliente cliente = new HiloCliente(skComunicacion, skPeticiones);
                Thread correrCliente = new Thread(cliente);
                correrCliente.start();
            }
        }catch(IOException e){
            Log.setEvento("Servidor","ERROR", e.getMessage());
        }
    }
}
