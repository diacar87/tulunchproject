
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
        ServerSocket skServerMensajes = null;

        try{
            skServerComunicacion = new ServerSocket(8081);
            skServerMensajes = new ServerSocket(8082);
            LogServidor.setEvento("El Servidor esta Corriendo.");
            while( escuchando ){
                Socket skComunicacion = null;
                Socket skMensajes = null;
                try {
                    LogServidor.setEvento("Esperando Cliente.");
                    skComunicacion = skServerComunicacion.accept();
                    skMensajes = skServerMensajes.accept();
                } catch (IOException e){
                    LogServidor.setEvento("Error 2: Falla de Comunicacion: " + skServerComunicacion + "\n    Causa :" + e.getMessage());
                    continue;
                }
                HiloCliente cliente = new HiloCliente(skComunicacion, skMensajes, this);           
                Thread correrCliente = new Thread(cliente);
            }
        }catch(IOException e){
            LogServidor.setEvento("Error 1: Falla de Comunicacion: " + skServerComunicacion + "\n    Causa :" + e.getMessage());
        }
    }
}
