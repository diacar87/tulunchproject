
package SourceLogicaNegocioServidor;

import vo.Empleado;
import java.util.List;


/**
 *
 * @author acactown
 */
public class EmpleadoXPassword implements ITipoPeticion{

    String password;
    private Empleado empleado;
    
    public EmpleadoXPassword(String password) {
        this.password = password;
    }

    
    public void ejecutarPeticion() {
        List<Empleado> empleados = dao.DaoEmpleado.readAll();
        for(int i = 0; i<empleados.size() ; i++ ){
            if(empleados.get(i).getPassword().equals(password)){
                empleado = empleados.get(i);
                break;
            }
        }
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    
}
