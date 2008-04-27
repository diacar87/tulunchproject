/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaNegocio.servicios;

import accesoDatos.dao.DaoProducto;
import accesoDatos.vo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana
 */
public class MenuDelDia {
    public static List<Producto> getMenuDelDia(){
        List<Producto> productos = new ArrayList<Producto>();
        List<Producto> menu = new ArrayList<Producto>();
        productos=DaoProducto.readAll();
        for(int i=0;i<productos.size();i++){
            if(productos.get(i).getEstaEnMenu())
                menu.add(productos.get(i));
        }            
        return menu;        
    }
    
    public static void agregarAMenu(String id){
        int idInt=Integer.parseInt(id);
        Producto producto=new Producto();
        producto=DaoProducto.read(idInt);
        producto.setEstaEnMenu(true);
        DaoProducto.update(producto);               
    }
    
    public static void quitarDeMenu(String id){
        int idInt=Integer.parseInt(id);
        Producto producto=new Producto();
        producto=DaoProducto.read(idInt);
        producto.setEstaEnMenu(false);
        DaoProducto.update(producto);               
    }
            
}
