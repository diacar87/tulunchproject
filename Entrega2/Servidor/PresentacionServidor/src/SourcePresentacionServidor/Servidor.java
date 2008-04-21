
package SourcePresentacionServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import SourceLogicaNegocioServidor.LogServidor;



/**
 *
 * @author acactown
 */
public class Servidor implements Runnable{
    
    boolean escuchando = true;
    
    public Servidor() {
        LogServidor.setSalida();
    }

    public void run(){
        try{
             // Paso 1: crear  e instanciar objetos  ServerSocket
            ServerSocket  skServerComunicacion = new ServerSocket(8081);
            ServerSocket skServerPeticiones = new ServerSocket(8082);
            LogServidor.setEvento("INFO","El Servidor esta Corriendo.");
            while( escuchando ){
                Socket skComunicacion = null;
                Socket skPeticiones = null;
                try {
                    LogServidor.setEvento("INFO","Esperando Cliente.");
                    // Paso 2: esperar una conexion.
                    
                    skComunicacion = skServerComunicacion.accept();
                    skPeticiones = skServerPeticiones.accept();
                } catch (IOException e){
                    LogServidor.setEvento("ERROR", e.getMessage());
                    continue;
                }
                HiloCliente cliente = new HiloCliente(skComunicacion, skPeticiones);
                Thread correrCliente = new Thread(cliente);
                correrCliente.start();
            }
        }catch(IOException e){
            LogServidor.setEvento("ERROR", e.getMessage());
        }
    }
}
