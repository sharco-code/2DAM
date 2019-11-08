package Model;


public class Compra {
    private Integer idCompra;
    private Integer idProducto;
    private Double Cantidad;
    private String fecha;
    private Integer IdProveedor;

    public Compra() {
    }

    public Compra(Integer idCompra, Integer idProducto, Double Cantidad, String fecha, Integer IdProveedor) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.fecha = fecha;
        this.IdProveedor = IdProveedor;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompras(Integer idCompras) {
        this.idCompra = idCompras;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(Integer IdProveedor) {
        this.IdProveedor = IdProveedor;
    }
    
    
}
