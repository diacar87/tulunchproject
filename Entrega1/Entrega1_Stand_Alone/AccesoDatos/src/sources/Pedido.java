package sources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
@NamedQueries({@NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"), @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha"), @NamedQuery(name = "Pedido.findByMesa", query = "SELECT p FROM Pedido p WHERE p.mesa = :mesa")})
public class Pedido implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "fecha", nullable = false)
    private String fecha;
    
    @Column(name = "mesa", nullable = false)
    private Integer mesa;
    
    //@Column(name = "empleado", nullable = false)
    private Empleado empleado;
    //@OneToMany(mappedBy = "pedidoId")
    private List<Producto> productos = new ArrayList<Producto>();

    public Pedido() {
    }

    public Pedido(Integer id, String fecha, Integer mesa) {
        this.id = id;
        this.fecha = fecha;
        this.mesa = mesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void add(Producto producto){
        productos.add(producto);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "accesodato.Pedido[id=" + id + "]";
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
