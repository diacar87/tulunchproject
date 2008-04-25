
package presentacion.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import accesoDatos.util.Log;
import accesoDatos.util.PropiedadesConexion;
import presentacion.vista.IniciarSesion;


/**
 * Esta clase es el "main de los main".
 * 1) Aplica el LookAndFeel.
 * 2) Llama a la interfaz InisiarSesion de Cajero/Admin.
 * 3) Pone a Correr al Servidor que atiende a las Clientes.
 * @author acactown
 */
public class Servidor {
    
    private ServerSocket skServerPeticiones;
    private boolean escuchando;
    
    public Servidor() {
        skServerPeticiones = null;
        escuchando = true;
    }

    public void ejecutarServidor(){
        try{
            skServerPeticiones = new ServerSocket( PropiedadesConexion.getPuertoPeticion() );
            Log.setEvento("Servidor","INFO","El Servidor esta Corriendo.");
            Log.setEvento("Servidor","INFO","El Servidor esta Enviado/Recibiendo Peticiones por el Puerto "+ skServerPeticiones.getLocalPort());
            while( escuchando ){
                Socket skPeticion = null;
                try {
                    Log.setEvento("Servidor","INFO","Esperando Cliente.");
                    skPeticion = skServerPeticiones.accept();
                } catch (IOException e){
                    Log.setEvento("Servidor","WARNING", e.getMessage());
                    continue;
                } finally{
                    HiloCliente clienteNuevo = new HiloCliente(skPeticion);
                    Thread hilo = new Thread(clienteNuevo);
                    hilo.start();
                }
            }
        }catch(IOException e){
            Log.setEvento("Servidor","ERROR", e.getMessage());
        }
    }
   /**
    * 
    * @param arg
    */
    public static void main(String arg[]) {                
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
        Servidor servidor = new Servidor();
        servidor.ejecutarServidor();
   }
    
}
