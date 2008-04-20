
package SourcePresentacionServidor;

/**
 *
 * @author acactown
 */
import java.io.*;
import java.net.*;

public class EjecutarServidor{
   
   Servidor ejecutarServidor;
   public EjecutarServidor(){
        ejecutarServidor = new Servidor();
        Thread correrServidor = new Thread(ejecutarServidor);
   }

   public static void main(String abc[]) throws IOException {                
        EjecutarServidor servidor = new EjecutarServidor();
   }  
}
