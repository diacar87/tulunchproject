package accesoDatos.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
@NamedQueries({@NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"), @NamedQuery(name = "Pedido.findByMesa", query = "SELECT p FROM Pedido p WHERE p.mesa = :mesa"), @NamedQuery(name = "Pedido.findByEnCurso", query = "SELECT p FROM Pedido p WHERE p.enCurso = :enCurso"), @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha")})
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "mesa", nullable = false)
    private int mesa;
    
    @Column(name = "enCurso", nullable = false)
    private boolean enCurso = true;
    
    @Column(name = "fecha", nullable = false)
    private String fecha;
    
    @JoinTable(name = "pedido_producto", joinColumns = {@JoinColumn(name = "pedido", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "producto", referencedColumnName = "id")})
    @ManyToMany
    private List<Producto> productos = new ArrayList<Producto>();
    
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne
    private Empleado empleado;

    public Pedido() {
    }

    public Pedido(int mesa, Empleado empleado, String fecha) {
        this.mesa = mesa;
        this.fecha = fecha;
        this.empleado = empleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public boolean getEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void adicionarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
        return "vo.Pedido[id=" + id + "]";
    }

}
