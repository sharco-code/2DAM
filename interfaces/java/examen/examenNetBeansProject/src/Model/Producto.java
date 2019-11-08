package Model;

public class Producto {
    private Integer idProducto;
    private String Nombre;

    public Producto() {
    }

    public Producto(Integer idProducto, String Nombre) {
        this.idProducto = idProducto;
        this.Nombre = Nombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
