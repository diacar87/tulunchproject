/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SourceLogicaNegocioServidor;
import dao.*;
import java.util.List;
import vo.*;

/**
 *
 * @author Diana
 */
public class CRUDEmpleado {
    public static List<Empleado> readAll()
    {        
            List<Empleado> empleados;
            empleados=DaoEmpleado.readAll();
            return empleados;        
    }

}
