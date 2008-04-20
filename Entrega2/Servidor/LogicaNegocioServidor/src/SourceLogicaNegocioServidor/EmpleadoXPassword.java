
package SourceLogicaNegocioServidor;

import vo.Empleado;
import dao.DaoEmpleado;

/**
 *
 * @author acactown
 */
public class EmpleadoXPassword implements ITipoPeticion{

    String password;
    
    public EmpleadoXPassword(String password) {
        this.password = password;
    }

    
    public void peticion() {
        
    }

}
