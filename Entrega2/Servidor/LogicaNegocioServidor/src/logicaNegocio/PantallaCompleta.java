
package logicaNegocio;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

/**
 *  Clase que recibe una Ventana y le aplica Pantalla Completa (FullScreen).
 * @author acactown
 */
public class PantallaCompleta {
    /**
     * Metodo que recibe una ventana y le aplica Pantalla Completa
     * Queneralmente corre desde una ventana entonces se ejecuta con el argumento this.
     * @param ventana Ventana a aplicar Pantalla Completa
     */
    public static void setVentana( Window ventana ){
        GraphicsDevice monitor = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if(!monitor.isFullScreenSupported())
            LogServidor.setEvento("WARNING","No hay Soporte para Pantalla Completa.");
        else
            LogServidor.setEvento("INFO","Se aplica Pantalla Completa.");
        try{
            // Activamos el modo a pantalla completa
            monitor.setFullScreenWindow(ventana);
        }
        catch(Throwable ex) {
            LogServidor.setEvento("ERROR",ex.getMessage());
        }
    }
}
