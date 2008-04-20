
package SourceLogicaNegocioServidor;

import java.io.Serializable;

/**
 *
 * @author acactown
 */
public class Peticion implements Serializable {
    
    private int opcionPeticion;
    private String nombreEmpleado;
    private String parametroPeticion;
    
    public Peticion() {
    }
    
    public Peticion(int opcionPeticion , String nombreEmpleado, String parametroPeticion) {
        this.opcionPeticion = opcionPeticion;
        this.nombreEmpleado = nombreEmpleado;
        this.parametroPeticion = parametroPeticion;
    }


    public

    int getOpcionPeticion() {
        return opcionPeticion;
    }

    public void setOpcionPeticion(int opcionPeticion) {
        this.opcionPeticion = opcionPeticion;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getParametroPeticion() {
        return parametroPeticion;
    }

    public void setParametroPeticion(String parametroPeticion) {
        this.parametroPeticion = parametroPeticion;
    }

}
