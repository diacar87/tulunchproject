
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
        ServerSocket skServerComunicacion = null;
        //ServerSocket skServerPeticiones = null;

        try{
            skServerComunicacion = new ServerSocket(8081);
            //skServerPeticiones = new ServerSocket(8082);
            LogServidor.setEvento("El Servidor esta Corriendo.");
            while( escuchando ){
                Socket skComunicacion = null;
                //Socket skPeticiones = null;
                try {
                    LogServidor.setEvento("Esperando Cliente.");
                    skComunicacion = skServerComunicacion.accept();
                    //skPeticiones = skServerPeticiones.accept();
                } catch (IOException e){
                    LogServidor.setEvento("Error 2: Falla de Comunicacion: " + skServerComunicacion + "\n               Causa :" + e.getMessage());
                    continue;
                }
                //HiloCliente cliente = new HiloCliente(skComunicacion, skPeticiones);
                HiloCliente cliente = new HiloCliente(skComunicacion);
                Thread correrCliente = new Thread(cliente);
                correrCliente.start();
            }
        }catch(IOException e){
            LogServidor.setEvento("Error 1: Falla de Comunicacion: " + skServerComunicacion + "\n               Causa :" + e.getMessage());
        }
    }
}
