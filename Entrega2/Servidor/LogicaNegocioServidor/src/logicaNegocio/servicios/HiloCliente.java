
package logicaNegocio.servicios;

import accesoDatos.conexion.Peticion;
import accesoDatos.dao.DaoEmpleado;
import accesoDatos.dao.DaoProducto;
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
            salidaPeticion = new ObjectOutputStream(skPeticion.getOutputStream());
            salidaPeticion.flush();
            entradaPeticion = new ObjectInputStream(skPeticion.getInputStream());
        } catch (IOException ex) {
            Log.setEvento("Servidor","ERROR",ex.getMessage());
        }
        int contadorProducto = 0;
        while( atendiendo ){
            try {
                peticion = (Peticion)entradaPeticion.readObject();
                Log.setEvento("Servidor","INFO","Se Procesa Peticion de Cliente desde IP : "+ skPeticion.getInetAddress().getHostAddress() +
                            "<p class=\"salto\">Empleado    : "+ peticion.getEmpleado().getNombre() +"</p>" +
                            "<p class=\"salto\">En Hilo    : "+ this.toString() +"</p>");
                switch (peticion.getOpcion()) {
                    case 1: // Gestiona Peticion  del cliente al pedir un empleado segun un password ya encriptado, la consume Cliente.Presentacion.IniciarSesion
                        salidaPeticion.writeObject( ValidarPassword.setPassword( peticion.getEmpleado().getPassword()) );
                        salidaPeticion.flush();
                    break;
                    case 2: // Gestiona Peticion  del cliente al pedir la cantidad de Productos en la base de datos, la consume Cliente.Presentacion.VistaMesero
                        contadorProducto = DaoProducto.readAll().size();
                        salidaPeticion.writeObject(contadorProducto);
                        salidaPeticion.flush();
                        contadorProducto = 1 ;
                        System.out.println("valor = "+contadorProducto );
                    break;
                    case 3: // Gestiona Peticion  del cliente al pedir los Productos en la base de datos, la consume Cliente.Presentacion.VistaMesero
                        salidaPeticion.writeObject(DaoProducto.read(contadorProducto));
                        salidaPeticion.flush();
                        contadorProducto++;
                        System.out.println(contadorProducto);
                    break;
                }
            } catch (IOException ex) {
                Log.setEvento("Servidor","INFO","El Cliente Termino la Conexion desde IP : "+ skPeticion.getInetAddress().getHostAddress() +
                                            "<p class=\"salto\">Empleado    : "+ peticion.getEmpleado().getNombre() +"</p>" +
                                            "<p class=\"salto\">En Hilo    : "+ this.toString() +"</p>");
                break;
            } catch (ClassNotFoundException ex) {
                Log.setEvento("Servidor","WARNING","Entrada Desconocida , "+ ex.getMessage());
                continue;
            }
        }
        try{
            skPeticion.close();
        } catch (IOException ex) {
            Log.setEvento("Servidor","WARNING",ex.getMessage());
        }
    }
    
}
