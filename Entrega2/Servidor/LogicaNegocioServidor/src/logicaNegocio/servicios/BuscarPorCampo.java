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
 * @author DeveloperDreamTeam
 */

public class BuscarPorCampo {
    /**
     * Permite buscar uno o varios Empleados por medio de alguno de sus atributos
     * @param busqueda La cadena a buscar
     * @param campo El atributo por medio del cual se realiza la busqueda
     * @return Lista de Empleados
     */
    public static List<Empleado> buscarEmpleado(String busqueda, String campo){
        List<Empleado> empleados=new ArrayList<Empleado>();
        List<Empleado> encontrados=new ArrayList<Empleado>();           
       
        if(campo.equals("id")){                     
                encontrados.add(DaoEmpleado.read(Integer.parseInt(busqueda)));                         
        }
        else{
            empleados=DaoEmpleado.readAll();
            for(int i = 0 ; i< empleados.size() ; i++){             
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
        }   
        
        if(encontrados.isEmpty() || encontrados.get(0)==null)
            return null;
        else
            return encontrados;                              
    }    
    
    public static void main(String args[])
    {
        List<Empleado> encontrados=new ArrayList<Empleado>();          
        encontrados.add(DaoEmpleado.read(Integer.parseInt("12")));   
        if(encontrados.get(0)==null)
        
        System.out.println(encontrados.get(0));
    }
}
