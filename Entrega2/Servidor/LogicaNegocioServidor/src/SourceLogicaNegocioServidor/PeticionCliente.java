
package SourceLogicaNegocioServidor;

/**
 *
 * @author acactown
 */
public class PeticionCliente {

    public ITipoPeticion tipoPeticion;

    public void setTipoPeticion(ITipoPeticion tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }
    
    public void enviarPeticion(){
        tipoPeticion.peticion();
    }

}
