
package SourceLogicaNegocioServidor;

/**
 * Clase de la cual heredan todas las peticiones de los diferentes clientes...
 * @author acactown
 */
public class PeticionDeCliente {

    /**
     * Como cada cliente tiene un tipo de peticion diferente este es el tipo de peticion de un cliente en especifico.
     */
    public ITipoPeticion tipoPeticion;

    public void setTipoPeticion(ITipoPeticion tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }
    
    /**
     * Esta es la manera como cada cliente ejecuta su peticion.
     */
    public void ejecutarPeticion(){
        tipoPeticion.peticion();
    }

}
