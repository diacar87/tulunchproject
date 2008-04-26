package presentacion.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import accesoDatos.util.Log;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *  Clase que maneja posicion y tamaño de ventanas.
 */
public class Ventana {
    /**
     * Metodo que recibe una ventana y le aplica Ventana Completa (Full Screen)
     * Queneralmente corre desde una ventana entonces se ejecuta con el argumento this.
     * @param ventana Ventana a aplicar Ventana Completa
     */
    public static void pantallaCompleta( Window ventana ){
        GraphicsDevice monitor = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if(!monitor.isFullScreenSupported())
            Log.setEvento("Cliente","WARNING","No hay Soporte para Pantalla Completa.");
        else
            Log.setEvento("Cliente","INFO","Se aplica Pantalla Completa.");
        try{
            // Activamos el modo a pantalla completa
            monitor.setFullScreenWindow(ventana);
        }
        catch(Throwable ex) {
            Log.setEvento("Cliente","ERROR",ex.getMessage());
        }
    }
    
    /**
    * Metodo que recibe una ventana y la centra vertical y horizontalmente en la pantalla
    * Queneralmente corre desde una ventana entonces se ejecuta con el argumento this.
    * @param ventana Ventana que se va a centrar
    */
    public static void centrar(Window ventana){
        ventana.pack();

        // Se obtienen las dimensiones en pixels de la pantalla.
        Dimension dimensionPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Se obtienen las dimensiones en pixels de la ventana.
        Dimension dimensionVentana = ventana.getSize();
        
        // Una cuenta para situar la ventana en el centro de la pantalla.
        ventana.setLocation(
            (dimensionPantalla.width - dimensionVentana.width) / 2,
            (dimensionPantalla.height - dimensionVentana.height) / 2);
    }
}