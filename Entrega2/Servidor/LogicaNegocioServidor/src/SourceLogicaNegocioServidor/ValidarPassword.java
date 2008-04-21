/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SourceLogicaNegocioServidor;
import java.util.List;
import vo.*;
import dao.*;

/**
 *
 * @author Diana
 */
public class ValidarPassword {
    public void validarPassword(){}
    
     public static Empleado setPassword(String password){
         List<Empleado> empleados =DaoEmpleado.readAll();        
        for(int i=0; i<empleados.size(); i++){             
            if (empleados.get(i).getPassword().equals(password)){               
                return empleados.get(i);
            }
        }  
         
        return null;        
   }

}
