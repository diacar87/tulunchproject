
package SourceLogicaNegocioServidor;

/**
 *
 * @author acactown
 */
public class PeticionEmpleado extends PeticionCliente{

    public PeticionEmpleado(String password) {
        tipoPeticion = new PedirEmpleadoXPassword(password);
    }

}
