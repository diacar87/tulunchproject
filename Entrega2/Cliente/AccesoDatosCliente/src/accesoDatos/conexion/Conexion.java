
package accesoDatos.conexion;

import accesoDatos.util.Log;
import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 
 * @author acactown
 */
public class Conexion {
    
    private static String ipServidor;
    private static int puertoPeticion;
    
    /**
     * Metodo que se encarga de traer los datos de la conexion alamacenados en el dico duro.
     * Se ejecutara la primera vez que se trate de conectar al Servidor.
     */
    private static void obtenerPropiedadesConexion(){
        try{
            SAXBuilder parsear = new SAXBuilder( true );
            Document constructor = parsear.build("src/accesoDatos/libs/propiedadesConexion.xml");
            Element propiedadesConexion = constructor.getRootElement();
            Element eleConexion = propiedadesConexion.getChild("conexion");
            Element etiqueta = eleConexion.getChild("servidorIp");
            ipServidor = etiqueta.getAttributeValue("ip");
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

      return false;
    }
    
    
}
