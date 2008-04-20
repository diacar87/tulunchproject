
package SourcePresentacionServidor;

/**
 *
 * @author acactown
 */
import java.io.*;
import java.net.*;

public class EjecutarServidor{
   
   Servidor servidor;
   public EjecutarServidor(){
        servidor = new Servidor();
        Thread correrServidor = new Thread( servidor);
        correrServidor.start();
   }

   public static void main(String abc[]) throws IOException {                
        EjecutarServidor ejecutarServidor = new EjecutarServidor();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
   }  
}
