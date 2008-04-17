

package SourceLogicaNegocio;



import java.util.List;
import sources.*;

public class LogicaNegocio {
    
    public Empleado validarPassword(String password){
        List<Empleado> empleados = Dao.leerTodosLosEmpleados();
        for(int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getPassword().equals(password)){
                return empleados.get(i);
            }
        }
        int id=0;
        String nombre = "N/A";
        String cargo = "N/A";
        String telefono ="N/A";
        String pass = "N/A";
        return new Empleado(id, nombre, cargo, telefono, pass);
    }

    public static void main(String []args){
        LogicaNegocio l=new LogicaNegocio();
                
        Empleado emp=l.validarPassword("1456");
        System.out.println(emp.getNombre());
    }
}

