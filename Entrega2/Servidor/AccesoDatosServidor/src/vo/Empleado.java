package vo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import seguridad.encriptacion;

@Entity
@Table(name = "empleado")
@NamedQueries({@NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"), @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"), @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password"), @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo"), @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"), @NamedQuery(name = "Empleado.findByCelular", query = "SELECT e FROM Empleado e WHERE e.celular = :celular")})
public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "cargo", nullable = false)
    private String cargo;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "celular")
    private String celular;

    public Empleado() {
    }

    public Empleado(String nombre, String password, String cargo){
        this.nombre = nombre;
        this.password = encriptacion.md5(password);
        this.cargo = cargo;
    }

    public Empleado(String nombre, String password, String cargo, String telefono, String celular) {
        this.nombre = nombre;
        this.password = password;
        this.cargo = cargo;
        this.telefono = telefono;
        this.celular = celular;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vo.Empleado[id=" + id + "]";
    }

}
