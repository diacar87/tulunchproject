
package presentacion.servidor;

/**
 *
 * @author acactown
 */
import presentacion.vista.IniciarSesion;
import java.io.*;
import java.net.*;

public class EjecutarServidor{
   
   public EjecutarServidor(){
        Servidor servidor = new Servidor();
        Thread correrServidor = new Thread( servidor);
        correrServidor.start();
   }

   public static void main(String abc[]) throws IOException {                
        EjecutarServidor ejecutarServidor = new EjecutarServidor();
        IniciarSesion is=new IniciarSesion();
        is.llamarIniciarSesion();
   }  
}
