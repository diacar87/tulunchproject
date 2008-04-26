
package logicaNegocio.servicios.cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import accesoDatos.util.Log;

/**
 *
 * @author acactown
 */
public class HiloCliente implements Runnable{

    private Socket skPeticion;
    private ObjectInputStream entradaPeticion;
    private ObjectOutputStream salidaPeticion;
    private boolean atendiendo;
    private Peticion peticion;
    
    public HiloCliente(Socket skPeticion) {
        this.skPeticion = skPeticion;
        entradaPeticion = null;
        salidaPeticion = null;
        atendiendo = true;
    }
        
    public void run(){
        try {
            Log.setEvento("Servidor","INFO","Se envian Flujos de Entrada y Salida al Cliente por Hilo "+ this.toString());
            salidaPeticion = new ObjectOutputStream(skPeticion.getOutputStream());
            salidaPeticion.flush();
            entradaPeticion = new ObjectInputStream(skPeticion.getInputStream());
            Log.setEvento("Servidor","INFO","Esperando Peticiones del Cliente en el Hilo "+ this.toString());
        } catch (IOException ex) {
            Log.setEvento("Servidor","ERROR",ex.getMessage());
        }
        while( atendiendo ){
            try {
                peticion = (Peticion)entradaPeticion.readObject();
                switch (peticion.getOpcionPeticion()) {
                    case 1:
                        peticion.setOpcionPeticion(5);
                        salidaPeticion.writeObject(peticion);
                    break;
                }
            } catch (IOException ex) {
                /*Log.setEvento("Servidor","INFO","El Cliente Termino la Conexion desde IP : "+ skPeticion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getEmpleado().getNombre() +"</p>" +
                                            "<p class=\"salto\">Cargo       : "+ peticion.getEmpleado().getCargo() +"</p>" +
                                            "<p class=\"salto\">Por Hilo    : "+ this.toString() +"</p>"); */
                break;
            } catch (ClassNotFoundException ex) {
                Log.setEvento("Servidor","WARNING","Entrada Desconocida :"+ ex.getMessage());
                continue;
            }
        }
        try{
            skPeticion.close();
        } catch (IOException ex) {
            Log.setEvento("Servidor","ERROR",ex.getMessage());
        }
    }
    
}
