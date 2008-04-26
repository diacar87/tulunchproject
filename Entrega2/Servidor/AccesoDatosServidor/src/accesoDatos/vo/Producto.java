package accesoDatos.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "producto")
@NamedQueries({@NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"), @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"), @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo"), @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"), @NamedQuery(name = "Producto.findByEstaEnMenu", query = "SELECT p FROM Producto p WHERE p.estaEnMenu = :estaEnMenu"), @NamedQuery(name = "Producto.findByEliminado", query = "SELECT p FROM Producto p WHERE p.eliminado = :eliminado")})
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "precio", nullable = false)
    private double precio;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "estaEnMenu", nullable = false)
    private boolean estaEnMenu = false;
    
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado = false;
    
    @Transient
    private ImageIcon foto = null;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(String nombre, String tipo, double precio) {
        this.precio = precio;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstaEnMenu() {
        return estaEnMenu;
    }

    public void setEstaEnMenu(boolean estaEnMenu) {
        this.estaEnMenu = estaEnMenu;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vo.Producto[id=" + id + "]";
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
}
