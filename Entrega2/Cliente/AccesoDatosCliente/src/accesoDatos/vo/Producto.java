package accesoDatos.vo;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private double precio;
    private String tipo;
    private String nombre;
    private boolean estaEnMenu = false;
    private boolean eliminado = false;
    private ImageIcon foto = null;

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

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

}
