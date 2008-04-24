
package logicaNegocio.servicios;

import accesoDatos.vo.Empleado;
import accesoDatos.dao.DaoEmpleado;
import java.util.List;


/**
 *
 * @author acactown
 */
public class EmpleadoXPassword{

    public static Empleado getEmpleado(String password) {
        Empleado empleado = new Empleado();
        List<Empleado> empleados = DaoEmpleado.readAll();
        for(int i = 0; i<empleados.size() ; i++ ){
            if(empleados.get(i).getPassword().equals(password)){
                empleado = empleados.get(i);
                break;
            }
        }
        return empleado;
    }
    
}
