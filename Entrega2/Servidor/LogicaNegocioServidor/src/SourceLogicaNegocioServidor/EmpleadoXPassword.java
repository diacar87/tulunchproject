
package SourceLogicaNegocioServidor;

import vo.Empleado;
import java.util.List;


/**
 *
 * @author acactown
 */
public class EmpleadoXPassword{

    public static Empleado getEmpleado(String password) {
        Empleado empleado = new Empleado();
        List<Empleado> empleados = dao.DaoEmpleado.readAll();
        for(int i = 0; i<empleados.size() ; i++ ){
            if(empleados.get(i).getPassword().equals(password)){
                empleado = empleados.get(i);
                break;
            }
        }
        return empleado;
    }
    
}
