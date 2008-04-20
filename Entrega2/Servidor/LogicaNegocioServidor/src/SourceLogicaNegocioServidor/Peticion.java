
package SourceLogicaNegocioServidor;

import java.io.Serializable;

/**
 *
 * @author acactown
 */
public class Peticion implements Serializable {
    
    private int opcionPeticion;
    private String nombreEmpleado;
    
    public Peticion() {
    }
    
    public Peticion(int opcionPeticion , String nombreEmpleado) {
        this.opcionPeticion = opcionPeticion;
        this.nombreEmpleado = nombreEmpleado;
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

}
