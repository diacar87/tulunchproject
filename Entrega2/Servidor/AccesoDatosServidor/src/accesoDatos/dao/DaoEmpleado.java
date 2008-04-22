package accesoDatos.dao;

import accesoDatos.vo.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoEmpleado {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccesoDatosPU");
    private static EntityManager em = emf.createEntityManager();
    
    /**
     * Almacena un empleado en la base de datos.
     * @param e El empleado que se va a almacenar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean create(Empleado e){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
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
     * Retorna un empleado de la Base de Datos.
     * @param id Identificador del empleado que se quiere obtener
     * @return El empleado
     * @throws IndexOutOfBoundsException si no existe un empleado con ese identiicador
     */
    public static Empleado read(int id){
        return em.find(Empleado.class, id);
    }
   
    /**
     * Retorna todos los empleados de la Base de Datos.
     * @return Una lista con los empleados
     */
    public static List<Empleado> readAll() {
        Query q = em.createQuery("SELECT e FROM Empleado e");
        List<Empleado> empleados = q.getResultList();
        return empleados;
    }
  
    /**
     * Actualiza un empleado de la Base de Datos.
     * @param e Empleado que se quiere actualizar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean update(Empleado e) {
        em.getTransaction().begin();
        em.flush();
        e = em.merge(e);
        em.refresh(e);

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
     * Elimina un empleado de la Base de Datos.
     * @param e Empleado que se quiere eliminar
     * @return <tt>true</tt> si la Base de Datos cambio con este llamado
     */
    public static boolean delete(Empleado empleado) {
        em.getTransaction().begin();
        empleado = em.merge(empleado);
        em.remove(empleado);
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

