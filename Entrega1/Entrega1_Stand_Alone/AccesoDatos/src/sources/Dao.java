package sources;

import java.util.List;
import javax.persistence.*;

public class Dao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccesoDatosPU");
    private static EntityManager em = emf.createEntityManager();

    // CREATE
    public static String guardar(Object ob) {
        String mensaje = "Error: El "+ob.toString()+" no se pudo salvar";
        em.getTransaction().begin();
        em.persist(ob);
        if ( !em.getTransaction().getRollbackOnly() ){
            em.getTransaction().commit();
            mensaje = "El "+ob.toString()+" se pudo salvar";
        }
        else
            em.getTransaction().rollback();
        return mensaje;
    }
   
    // READ
    public static Empleado readEmpleado(int id){
        return em.find(Empleado.class, id);
    }
    
    public static List<Empleado> leerTodosLosEmpleados(){
        Query q = em.createQuery("SELECT e FROM Empleado e");
        List<Empleado> empleados = q.getResultList();
        return empleados;
    }
  
    public static Pedido readPedido(int id){
        return em.find(Pedido.class, id);
    }
    
    public static List<Pedido> leerTodosLosPedidos(){
        Query q = em.createQuery("SELECT p FROM Pedido p");
        List<Pedido> pedidos = q.getResultList();
        return pedidos;
        //return null;
    }
 
    public static Producto readProducto(int id){
        return em.find(Producto.class, id);
    }
    
    public static List<Producto> leerTodosLosProductos(){
        Query q = em.createQuery("SELECT p FROM Producto p");
        List<Producto> productos = q.getResultList();
        return productos;
    } 
 
    // UPDATE
    public static String actualizar(Object ob){
        String mensaje = "Error: El "+ob.toString()+" no se pudo actualizar ";
        em.getTransaction().begin();

        em.flush();
        ob = em.merge(ob);
        em.refresh(ob);
                
        if ( !em.getTransaction().getRollbackOnly() ){
            em.getTransaction().commit();
            mensaje = "El "+ob.toString()+" se pudo actualizar";
        }
        else
            em.getTransaction().rollback();
        return mensaje;
    }
    
    // DELETE
    public static String borrar(Object ob){
        String mensaje = "Error: El "+ob.toString()+" no se puedo remover ";
        em.getTransaction().begin();
        
        ob = em.merge(ob);
        em.remove(ob);
        if ( !em.getTransaction().getRollbackOnly() ){
            em.getTransaction().commit();
            mensaje = "El "+ob.toString()+" se pudo remover";
        }
        else
            em.getTransaction().rollback();
        return mensaje;
    }
}
