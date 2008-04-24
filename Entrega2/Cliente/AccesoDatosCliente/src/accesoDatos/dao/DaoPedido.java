package accesoDatos.dao;

import accesoDatos.vo.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author acactown
 */
public class DaoPedido {
    

    /**
     * Almacena un pedido en la base de datos.
     * @param p El pedido que se va a almacenar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean create(Pedido p) {
            return true;
    }
    
    /**
     * Retorna un pedido de la Base de Datos.
     * @param id Identificador del pedido que se quiere obtener
     * @return El pedido
     */
    public static Pedido read(int id) {
        return new Pedido();
    }
    
    /**
     * Retorna todos los pedidos de la Base de Datos.
     * @return Una lista con los pedidos
     */
    public static List<Pedido> readAll() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        return pedidos;
    }

    /**
     * Actualiza un pedido de la Base de Datos.
     * @param p Pedido que se quiere actualizar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean update(Pedido p){
        return true;
    }
    
    /**
     * Elimina un pedido de la Base de Datos.
     * @param e Pedido que se quiere eliminar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean delete(Pedido p){
        return true;
    }
}

