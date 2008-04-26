
package accesoDatos.conexion;

import java.io.Serializable;

/**
 *
 * @author acactown
 */
public class Peticion implements Serializable{
    
    private String nombreCliente;
    private int opcion;
    
    public Peticion() {
    }

    public Peticion(String nombreCliente, int opcion) {
        this.nombreCliente = nombreCliente;
        this.opcion = opcion;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public

    String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}