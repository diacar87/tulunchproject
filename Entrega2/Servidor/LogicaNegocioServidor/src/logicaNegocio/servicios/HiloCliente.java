
package logicaNegocio.servicios;

import accesoDatos.conexion.Peticion;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import accesoDatos.util.Log;
import accesoDatos.vo.Empleado;

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
            Log.setEvento("Servidor","INFO","Se envian Flujos de Entrada/Salida al Cliente en el Hilo<p class=\"salto\">"+ this.toString() +"</p>");
            salidaPeticion = new ObjectOutputStream(skPeticion.getOutputStream());
            salidaPeticion.flush();
            entradaPeticion = new ObjectInputStream(skPeticion.getInputStream());
            Log.setEvento("Servidor","INFO","Esperando Peticiones de Cliente en el Hilo<p class=\"salto\">"+ this.toString() +"</p>");
        } catch (IOException ex) {
            Log.setEvento("Servidor","ERROR",ex.getMessage());
        }
        while( atendiendo ){
            try {
                peticion = (Peticion)entradaPeticion.readObject();
                switch (peticion.getOpcion()) {
                    case 1:
                        Empleado empleado = ValidarPassword.setPassword( peticion.getEmpleado().getPassword());
                        salidaPeticion.writeObject(empleado);
                        salidaPeticion.flush();
                    break;
                }
            } catch (IOException ex) {
                /*Log.setEvento("Servidor","INFO","El Cliente Termino la Conexion desde IP : "+ skPeticion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getEmpleado().getNombre() +"</p>" +
                                            "<p class=\"salto\">Cargo       : "+ peticion.getEmpleado().getCargo() +"</p>" +
                                            "<p class=\"salto\">Por Hilo    : "+ this.toString() +"</p>"); */
                break;
            } catch (ClassNotFoundException ex) {
                Log.setEvento("Servidor","WARNING","Entrada Desconocida , "+ ex.getMessage());
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
