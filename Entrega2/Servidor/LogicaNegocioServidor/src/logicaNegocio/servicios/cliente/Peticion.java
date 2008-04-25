
package logicaNegocio.servicios.cliente;

import java.io.Serializable;
import accesoDatos.vo.Empleado;

/**
 *
 * @author acactown
 */
public class Peticion implements Serializable {
    
    private int opcionPeticion;
    private Empleado empleado;

    public Peticion() {
    }

    
    public Peticion(int opcionPeticion, Empleado empleado) {
        this.opcionPeticion = opcionPeticion;
        this.empleado = empleado;
    }

    public int getOpcionPeticion() {
        return opcionPeticion;
    }

    public void setOpcionPeticion(int opcionPeticion) {
        this.opcionPeticion = opcionPeticion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
