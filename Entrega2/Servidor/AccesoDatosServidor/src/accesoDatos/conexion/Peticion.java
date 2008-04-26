
package accesoDatos.conexion;

import accesoDatos.vo.Empleado;
import java.io.Serializable;

/**
 *
 * @author acactown
 */
public class Peticion implements Serializable{
    
    private Empleado empleado;
    private int opcion;
    
    public Peticion() {
    }

    public Peticion(Empleado empleado, int opcion) {
        this.empleado = empleado;
        this.opcion = opcion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
}
