
package SourceLogicaNegocioServidor;

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
            LogServidor.setEvento("WARNING :  No hay Soporte para Pantalla Completa.");
        else
            LogServidor.setEvento("INFO : Se aplica Pantalla Completa.");
        try{
            // Activamos el modo a pantalla completa
            monitor.setFullScreenWindow(ventana);
        }
        catch(Throwable ex) {
            LogServidor.setEvento("ERROR : " + 
                 "\n               DETALLE :" + ex.getMessage());
        }
    }
}
