package Model;


public class Proveedor {
    private Integer idProveedor;
    private String Nombre;
    private String Dir;
    private String Pob;
    private String cp;
    private String CIF;
    private String Prov;
    private String Tel;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String Nombre, String Dir, String Pob, String cp, String CIF, String Prov, String Tel) {
        this.idProveedor = idProveedor;
        this.Nombre = Nombre;
        this.Dir = Dir;
        this.Pob = Pob;
        this.cp = cp;
        this.CIF = CIF;
        this.Prov = Prov;
        this.Tel = Tel;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public String getPob() {
        return Pob;
    }

    public void setPob(String Pob) {
        this.Pob = Pob;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String Prov) {
        this.Prov = Prov;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }
    
}
