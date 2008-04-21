
package SourceLogicaNegocioCliente;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

/**
 *
 * @author acactown
 */
public class PantallaCompleta {
    
    public static void setVentana( Window ventana ){
        GraphicsDevice monitor = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if(!monitor.isFullScreenSupported())
            LogCliente.setEvento("WARNING :  No hay Soporte para Pantalla Completa.");
        else
            LogCliente.setEvento("INFO : Se aplica Pantalla Completa.");
        try{
            // Activamos el modo a pantalla completa
            monitor.setFullScreenWindow(ventana);
        }
        catch(Throwable ex) {
            LogCliente.setEvento("ERROR : " + 
                 "\n               DETALLE :" + ex.getMessage());
        }
    }
}
