
package SourceLogicaNegocioServidor;

import vo.Empleado;
import dao.DaoEmpleado;

/**
 *
 * @author acactown
 */
public class PedirEmpleadoXPassword implements ITipoPeticion{

    String password;
    
    public PedirEmpleadoXPassword(String password) {
        this.password = password;
    }

    
    public void peticion() {
        
    }

}
