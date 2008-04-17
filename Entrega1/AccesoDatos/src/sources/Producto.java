package sources;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
@NamedQueries({@NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"), @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"), @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"), @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo"), @NamedQuery(name = "Producto.findByEstaEnMenu", query = "SELECT p FROM Producto p WHERE p.estaEnMenu = :estaEnMenu")})
public class Producto implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "estaEnMenu", nullable = false)
    private Boolean estaEnMenu;

    public Producto() {
    }

    public Producto(int id, String nombre, Double precio, String tipo, Boolean estaEnMenu) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estaEnMenu = estaEnMenu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstaEnMenu() {
        return estaEnMenu;
    }

    public void setEstaEnMenu(Boolean estaEnMenu) {
        this.estaEnMenu = estaEnMenu;
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
        return "accesodato.Producto[id=" + id + "]";
    }
    
    public static void main(String[] args){
        
        Producto p = new Producto(70, "aguacate", 12.3, "alimento", true);
        
        Dao.guardar(p);
        
        //Pedido pe = Dao.readPedido(5);
        //pe.add(p);
        //Dao.actualizar(pe);
    }
}
