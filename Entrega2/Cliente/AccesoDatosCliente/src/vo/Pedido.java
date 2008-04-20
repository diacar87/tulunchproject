package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;   
    private Integer id;
    private int mesa;
    private boolean enCurso = true;
    private String fecha;
    private List<Producto> productos = new ArrayList<Producto>();
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

}
