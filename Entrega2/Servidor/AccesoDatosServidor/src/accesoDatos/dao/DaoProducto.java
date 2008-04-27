package accesoDatos.dao;

import accesoDatos.vo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoProducto {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccesoDatosPU");
    private static EntityManager em = emf.createEntityManager();
    public  static String path = "C:\\Documents and Settings\\Familia\\Mis documentos\\NetBeansProjects\\Entrega2\\Servidor\\AccesoDatosServidor\\src\\accesoDatos\\vo\\imagenes\\";

    /**
     * Almacena un producto en la base de datos.
     * @param p El producto que se va a almacenar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean create(Producto p) {
        em.getTransaction().begin();
        em.persist(p);
        if ( !em.getTransaction().getRollbackOnly() ){
            em.getTransaction().commit();
           return true;
        }
        else{
            em.getTransaction().rollback();
            return false;
        }
    }
    
    /**
     * Retorna un producto de la Base de Datos.
     * @param id Identificador del producto que se quiere obtener
     * @return El producto
     * @throws IndexOutOfBoundsException si no existe un producto con ese identiicador
     */
    public static Producto read(int id){
        return em.find(Producto.class, id);
    }
    
    /**
     * Retorna todos los productos de la Base de Datos.
     * @return Una lista con los productos
     */
    public static List<Producto> readAll(){
        Query q = em.createQuery("SELECT p FROM Producto p");
        List<Producto> productos = q.getResultList();
        return productos;
    } 
 
    /**
     * Actualiza un producto de la Base de Datos.
     * @param p Producto que se quiere actualizar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean update(Producto p){
        em.getTransaction().begin();
        em.flush();
        p = em.merge(p);
        em.refresh(p);
                
        if ( !em.getTransaction().getRollbackOnly() ){
            em.getTransaction().commit();
            return true;
        }
        else{
            em.getTransaction().rollback();
            return false;
        }
    }
    
    /**
     * Elimina un producto de la Base de Datos.
     * @param p Producto que se quiere eliminar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean delete(Producto p){
        em.getTransaction().begin();
        p = em.merge(p);
        em.remove(p);
        if ( !em.getTransaction().getRollbackOnly() ){
            em.getTransaction().commit();
            return true;
        }
        else{
            em.getTransaction().rollback();
            return false;
        }
    }
}

