
package SourceLogicaNegocioServidor;

/**
 *
 * @author acactown
 */
public class PedirEmpleadoXPassword extends PeticionDeCliente{

    public PedirEmpleadoXPassword(String password) {
        tipoPeticion = new EmpleadoXPassword(password);
    }

}
