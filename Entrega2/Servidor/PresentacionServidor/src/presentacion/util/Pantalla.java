
package presentacion.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import accesoDatos.util.Log;

/**
 *  Clase que maneja posicion y tamaño de ventanas.
 */
public class Pantalla {
    /**
     * Metodo que recibe una ventana y le aplica Pantalla Completa (Full Screen)
     * Queneralmente corre desde una ventana entonces se ejecuta con el argumento this.
     * @param ventana Ventana a aplicar Pantalla Completa
     */
    public static void pantallaCompleta( Window ventana ){
        GraphicsDevice monitor = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if(!monitor.isFullScreenSupported())
            Log.setEvento("Servidor","ERROR","No hay Soporte para Pantalla Completa.");
        else
            Log.setEvento("Servidor","INFO","Se aplica Pantalla Completa.");
        try{
            // Activamos el modo a pantalla completa
            monitor.setFullScreenWindow(ventana);
        }
        catch(Throwable ex) {
            Log.setEvento("Servidor","ERROR",ex.getMessage());
        }
    }
}
