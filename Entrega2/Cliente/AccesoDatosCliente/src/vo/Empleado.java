package vo;

import java.io.Serializable;
import seguridad.encriptacion;

public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nombre;
    private String password;
    private String cargo;
    private String telefono;
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

}