
package accesoDatos.util;

import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author acactown
 */
public class PropiedadesConexion {
    
    private static int puertoComunicacion;
    private static int puertoPeticion;
    private static boolean datos = false;

    private static void obtenerPropiedadesConexion(){
        try{
            SAXBuilder parsear = new SAXBuilder( true );
            Document constructor = parsear.build("src/accesoDatos/libs/propiedadesConexion.xml");
            Element propiedadesConexion = constructor.getRootElement();
            Element eleConexion = propiedadesConexion.getChild("conexion");
            Element etiqueta = eleConexion.getChild("comunicacionPuerto");
            puertoComunicacion = Integer.valueOf(etiqueta.getAttributeValue("port"));
            etiqueta = eleConexion.getChild("peticionPuerto");
            puertoPeticion = Integer.valueOf(etiqueta.getAttributeValue("port"));
        }catch(JDOMException e){
            Log.setEvento("Servidor","ERROR",e.getMessage());
        }catch(IOException e){
            Log.setEvento("Servidor","ERROR",e.getMessage());
        }
    }
    
    public static int getPuertoComunicacion() {
        if(!datos){
                obtenerPropiedadesConexion();
                datos = true;
        }
        return puertoComunicacion;
    }

    public static int getPuertoPeticion() {
        if(!datos){
                obtenerPropiedadesConexion();
                datos = true;
        }
        return puertoPeticion;
    }

}