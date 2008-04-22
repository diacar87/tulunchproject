package accesoDatos.dao;

import java.util.ArrayList;
import java.util.List;
import accesoDatos.vo.Empleado;

public class DaoEmpleado {

    public static boolean create(Empleado e){
        return true;
    }

    public static Empleado read(int id){
        return new Empleado();
    }
   
    public static List<Empleado> readAll() {
        return new ArrayList<Empleado>();
    }
  
    
    public static boolean update(Empleado e) {
        return true;
    }
    
    
    public static boolean delete(Empleado empleado) {
        return true;
    }
}

