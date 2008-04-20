
package SourcePresentacionServidor;

/**
 *
 * @author acactown
 */
import java.io.*;
import java.net.*;

public class Servidor{
   
   EjecutarServidor ejecutarServidor;
   public Servidor(){
        ejecutarServidor = new EjecutarServidor();
        Thread correrServidor = new Thread(ejecutarServidor);
   }

   public static void main(String abc[]) throws IOException {                
        Servidor servidor = new Servidor();
   }  
}
