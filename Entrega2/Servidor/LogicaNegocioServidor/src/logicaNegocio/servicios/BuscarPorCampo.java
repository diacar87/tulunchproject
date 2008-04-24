/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaNegocio.servicios;

import accesoDatos.dao.DaoEmpleado;
import accesoDatos.vo.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yohan
 */
public class BuscarPorCampo {
    public static List<Empleado> buscarEmpleado(String busqueda, String campo){
        List<Empleado> empleados=new ArrayList<Empleado>();
        List<Empleado> encontrados=new ArrayList<Empleado>();
        empleados=DaoEmpleado.readAll();
        
         for(int i = 0 ; i< empleados.size() ; i++){
             if(campo.equals("id") && empleados.get(i).getId().equals(busqueda)){
                 encontrados.add(empleados.get(i));
             }
             if(campo.equals("nombre") && empleados.get(i).getNombre().equals(busqueda)){
                 encontrados.add(empleados.get(i));
             }
             if(campo.equals("cargo") && empleados.get(i).getCargo().equals(busqueda)){
                 encontrados.add(empleados.get(i));
             }
             if(campo.equals("telefono") && empleados.get(i).getTelefono().equals(busqueda)){
                 encontrados.add(empleados.get(i));
             }
             if(campo.equals("celular") && empleados.get(i).getCelular().equals(busqueda)){
                 encontrados.add(empleados.get(i));
             }                 
         }
        return encontrados;                              
    }    

}
