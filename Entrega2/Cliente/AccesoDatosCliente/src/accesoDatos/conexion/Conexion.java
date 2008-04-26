
package accesoDatos.conexion;

import accesoDatos.util.Log;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
    private static boolean datos;
    
    /**
     * Metodo que se encarga de traer los datos de la conexion alamacenados en el dico duro.
     * Se ejecutara la primera vez que se trate de conectar al Servidor.
     */
    private static void obtenerPropiedadesConexion(){
        try{
            SAXBuilder parsear = new SAXBuilder( true );
            Document constructor = parsear.build("../AccesoDatosCliente/src/accesoDatos/libs/propiedadesConexion.xml");
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
     * Metodo que Obtiene las propiedaes de la conexion y luego envia una Peticiones al Servidor
     * @param peticion la Peticion a enviar
     * @return El objeto que retorna el Servidor, pilas hay que hacerle el cast
     */
    public static Object enviarPeticion(Peticion peticion){
        if(!datos){
            obtenerPropiedadesConexion();
            datos = true;
        }
        Socket skPeticion;
        ObjectInputStream entradaPeticion = null;
        ObjectOutputStream salidaPeticion = null;
        try {
            Log.setEvento("Cliente","INFO","Intentando Conectarse al Servidor con IP "+ ipServidor +" por el puerto " + puertoPeticion);
            skPeticion = new Socket(InetAddress.getByName( ipServidor ), puertoPeticion );
            Log.setEvento("Cliente","INFO","Conectado a "+ skPeticion.getInetAddress().getHostName() );
            Log.setEvento("Cliente","INFO","Se envian Flujos de Entrada y Salida al Servidor");
            salidaPeticion = new ObjectOutputStream(skPeticion.getOutputStream());
            salidaPeticion.flush();
            entradaPeticion = new ObjectInputStream(skPeticion.getInputStream());
            Log.setEvento("Cliente","INFO","Se envia Peticion");
            salidaPeticion.writeObject(peticion);
            salidaPeticion.flush();
            Log.setEvento("Cliente","INFO","Recepcion Exitosa");
            salidaPeticion.close();
            entradaPeticion.close();
            skPeticion.close();
            return entradaPeticion.readObject();
        } catch (UnknownHostException ex) {
            Log.setEvento("Cliente","ERROR", ex.getMessage());
        } catch (IOException ex) {
            Log.setEvento("Cliente","ERROR", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Log.setEvento("Cliente","WARNING", ex.getMessage());
        }
        return null;
        
    }
    
    
}
