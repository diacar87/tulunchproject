
package presentacion.servidor;

import accesoDatos.util.Log;
import java.io.IOException;
import presentacion.vista.IniciarSesion;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author acactown
 */
public class EjecutarServidor{
   
   public EjecutarServidor(){
        Servidor servidor = new Servidor();
        Thread correrServidor = new Thread( servidor);
        correrServidor.start();
   }
   /**
    * Este es el main de los main,
    * es el que se encarga de poner a correr el Servidor y lanzar la interfaz de iniciar Sesion
    * @param abc
    * @throws java.io.IOException
    */
   public static void main(String abc[]) throws IOException {                
        EjecutarServidor ejecutarServidor = new EjecutarServidor();
        try {
            UIManager.setLookAndFeel(new com.nilo.plaf.nimrod.NimRODLookAndFeel());                                
        } catch (UnsupportedLookAndFeelException ex) {
            Log.setEvento("Servidor","WARNING",ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new IniciarSesion().setVisible(true);
                }
         }); 
   }  
}
