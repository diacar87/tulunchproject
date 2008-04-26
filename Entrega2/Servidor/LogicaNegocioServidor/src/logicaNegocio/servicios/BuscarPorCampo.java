/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaNegocio.servicios;

import accesoDatos.dao.DaoEmpleado;
import accesoDatos.dao.DaoPedido;
import accesoDatos.dao.DaoProducto;
import accesoDatos.vo.Empleado;
import accesoDatos.vo.Pedido;
import accesoDatos.vo.Producto;
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
    
    /**
     * Permite buscar uno o varios Productos por medio de sus atributos
     * @param busqueda La cadena a buscar
     * @param campo El atributo por medio del cual se realiza la busqueda
     * @return Lista de Productos
     */
    
     public static List<Producto> buscarProducto(String busqueda, String campo){
        List<Producto> productos=new ArrayList<Producto>();
        List<Producto> encontrados=new ArrayList<Producto>();           
       
        if(campo.equals("id")){                     
                encontrados.add(DaoProducto.read(Integer.parseInt(busqueda)));                         
        }
        else{
            productos=DaoProducto.readAll();
            for(int i = 0 ; i< productos.size() ; i++){             
             if(campo.equals("nombre") && productos.get(i).getNombre().equals(busqueda)){
                 encontrados.add(productos.get(i));
             }
             if(campo.equals("tipo") && productos.get(i).getTipo().equals(busqueda)){
                 encontrados.add(productos.get(i));
             }
             if(campo.equals("precio") && (productos.get(i).getPrecio()==Double.parseDouble(busqueda) || productos.get(i).getPrecio()==Integer.parseInt(busqueda))){
                 encontrados.add(productos.get(i));
             }
             
             if(campo.equals("estaEnMenu")){
                 if(busqueda.equals("Si") && productos.get(i).getEstaEnMenu())
                     encontrados.add(productos.get(i));
                 if(busqueda.equals("No") && !productos.get(i).getEstaEnMenu())
                     encontrados.add(productos.get(i));
                     
             }                 
             if(campo.equals("eliminado")){
                 if(busqueda.equals("Si") && productos.get(i).getEliminado())
                     encontrados.add(productos.get(i));
                 if(busqueda.equals("No") && !productos.get(i).getEliminado())
                     encontrados.add(productos.get(i));
                     
             } 
                              
            }
        }   
        
        if(encontrados.isEmpty() || encontrados.get(0)==null)
            return null;
        else
            return encontrados;                              
    }    
     
       /**
     * Permite buscar uno o varios Pedido/Ventas por medio de sus atributos
     * @param busqueda La cadena a buscar
     * @param campo El atributo por medio del cual se realiza la busqueda
     * @return Lista de Pedidos
     */
    
      public static List<Pedido> buscarPedido(String busqueda, String campo){
        List<Pedido> pedidos=new ArrayList<Pedido>();
        List<Pedido> encontrados=new ArrayList<Pedido>();           
              
        if(campo.equals("id")){                     
                encontrados.add(DaoPedido.read(Integer.parseInt(busqueda)));                         
        }
        else{
            pedidos=DaoPedido.readAll();
            for(int i = 0 ; i< pedidos.size() ; i++){             
             if(campo.equals("mesa") && String.valueOf(pedidos.get(i).getMesa()).equals(busqueda)){
                 encontrados.add(pedidos.get(i));
             }
             if(campo.equals("enCurso")){
                 if(busqueda.equals("Si") && pedidos.get(i).getEnCurso())
                     encontrados.add(pedidos.get(i));
                 if(busqueda.equals("No") && !pedidos.get(i).getEnCurso())
                     encontrados.add(pedidos.get(i));
                     
             }  
             if(campo.equals("fecha") && pedidos.get(i).getFecha().equals(busqueda)){
                 encontrados.add(pedidos.get(i));
             }
             if(campo.equals("empleado") && pedidos.get(i).getEmpleado().getNombre().equals(busqueda)){
                 encontrados.add(pedidos.get(i));
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
        List<Pedido> encontrados=new ArrayList<Pedido>();          
        encontrados=buscarPedido("5","id");
        for(int i=0;i<encontrados.size();i++)        
           System.out.println(encontrados.get(i).getEmpleado().getNombre());
    }
}
