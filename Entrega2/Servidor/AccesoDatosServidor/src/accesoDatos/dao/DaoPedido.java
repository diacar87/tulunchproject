package accesoDatos.dao;

import accesoDatos.vo.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoPedido {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccesoDatosPU");
    private static EntityManager em = emf.createEntityManager();

    /**
     * Almacena un pedido en la base de datos.
     * @param p El pedido que se va a almacenar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean create(Pedido p) {
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
     * Retorna un pedido de la Base de Datos.
     * @param id Identificador del pedido que se quiere obtener
     * @return El pedido
     * @throws IndexOutOfBoundsException si no existe un pedido con ese identificador
     */
    public static Pedido read(int id) {
        return em.find(Pedido.class, id);
    }
    
    /**
     * Retorna todos los pedidos de la Base de Datos.
     * @return Una lista con los pedidos
     */
    public static List<Pedido> readAll() {
        Query q = em.createQuery("SELECT p FROM Pedido p");
        List<Pedido> pedidos = q.getResultList();
        return pedidos;
    }

    /**
     * Actualiza un pedido de la Base de Datos.
     * @param p Pedido que se quiere actualizar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean update(Pedido p){
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
     * Elimina un pedido de la Base de Datos.
     * @param e Pedido que se quiere eliminar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean delete(Pedido p){
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

