
package accesoDatos.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 
 * @author acactown
 */
public class ConexionServidor {
    
    private static String ipServidor;
    private static int puertoComunicacion;
    private static int puertoPeticion;
    private static boolean datos = false;
    private static ObjectInputStream entradaComunicacion = null;
    private static ObjectOutputStream salidaComunicacion = null;
    private static ObjectInputStream entradaPeticiones = null;
    private static Socket skComunication = null;
    private static Socket skPeticiones = null;
    
    /**
     * Metodo que se encarga de traer los datos de la conexion alamacenados en el dico duro.
     * Se ejecutara la primera vez que se trate de conectar al Servidor.
     */
    private static void obtenerPropiedadesConexion(){
        try{
            SAXBuilder parsear = new SAXBuilder( true );
            Document constructor = parsear.build("src/accesoDatos/libs/propiedadesConexionServidor.xml");
            Element propiedadesConexion = constructor.getRootElement();
            Element eleConexion = propiedadesConexion.getChild("conexion");
            Element etiqueta = eleConexion.getChild("servidorIp");
            ipServidor = etiqueta.getAttributeValue("ip");
            etiqueta = eleConexion.getChild("comunicacionPuerto");
            puertoComunicacion = Integer.valueOf(etiqueta.getAttributeValue("port"));
            etiqueta = eleConexion.getChild("comunicacionPuerto");
            puertoComunicacion = Integer.valueOf(etiqueta.getAttributeValue("port"));
            etiqueta = eleConexion.getChild("peticionPuerto");
            puertoPeticion = Integer.valueOf(etiqueta.getAttributeValue("port"));
        }catch(JDOMException e){
            Log.setEvento("Cliente","ERROR",e.getMessage());
        }catch(IOException e){
            Log.setEvento("Cliente","ERROR",e.getMessage());
        }
    }
    /**
     * Se encarga de conectarse al servidor y obtener los Flujos de Entrada y Salida
     * @return <tt>true</tt> si fue posible realizar la Conexion y hay comunicacion entre el Cliente y el Servidor.
     */
    private static boolean conectar(){
        try {
            if(!datos){
                obtenerPropiedadesConexion();
                datos = true;
            }
            Log.setEvento("Cliente","INFO","Intentando Conectarse al Servidor.");
            // Paso 1: crear un socket para realizar la conexion
            skComunication = new Socket(ipServidor, puertoComunicacion);
            skPeticiones = new Socket( ipServidor, puertoPeticion);
            Log.setEvento("Cliente","INFO","<b>Conectado a :</b> "+  skComunication.getInetAddress().getHostName());
            Log.setEvento("Cliente","INFO","Se envian Flujos de Entrada y Salida al Servidor");
            //Paso 2: obtener los flujos de entrada y salida
            entradaComunicacion = new ObjectInputStream(skComunication.getInputStream());
            salidaComunicacion = new ObjectOutputStream(skComunication.getOutputStream());
            entradaPeticiones = new ObjectInputStream(skPeticiones.getInputStream());
            Log.setEvento("Cliente","INFO","Comunicacion exitosa de Flujos de Entrada y Salida al Servidor");
            return true;
      } catch (IOException e) {
         Log.setEvento("Cliente","ERROR","El Servidor no esta Corriendo.");
      }
      return false;
    }
    
    public static void main(String arg[]){
        ConexionServidor.conectar();
    }
    
}
