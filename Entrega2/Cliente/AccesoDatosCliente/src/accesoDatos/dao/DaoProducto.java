package accesoDatos.dao;

import accesoDatos.vo.Producto;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author acactown
 */
public class DaoProducto {
    
    /**
     * Almacena un producto en la base de datos.
     * @param p El producto que se va a almacenar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean create(Producto p) {
        return true;
    }
    
    /**
     * Retorna un producto de la Base de Datos.
     * @param id Identificador del producto que se quiere obtener
     * @return El producto
     */
    public static Producto read(int id){
        return new Producto();
    }
    
    /**
     * Retorna todos los productos de la Base de Datos.
     * @return Una lista con los productos
     */
    public static List<Producto> readAll(){
        List<Producto> productos = new ArrayList<Producto>();
        return productos;
    } 
 
    /**
     * Actualiza un producto de la Base de Datos.
     * @param p Producto que se quiere actualizar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean update(Producto p){
        return true;
    }
    
    /**
     * Elimina un producto de la Base de Datos.
     * @param p Producto que se quiere eliminar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean delete(Producto p){
        return true;
    }
}

