/*
Jose Galán Simó
2 - DAM
 */

package Model;

public class Producto {
    private Integer idProducto;
    private String Nombre;
    private String Foto;
    private int ver;
    private double PVP;
    private double Coste;
    private String DeCocina;
    private String EsMenu;
    private String EsPlantilla;
    private Integer idFamilia;

    public Producto(Integer idProducto, String Nombre, String Foto, double PVP, double Coste, String DeCocina, String EsMenu, String EsPlantilla, Integer idFamilia) {
        this.idProducto = idProducto;
        this.Nombre = Nombre;
        this.Foto = Foto;
        this.PVP = PVP;
        this.Coste = Coste;
        this.DeCocina = DeCocina;
        this.EsMenu = EsMenu;
        this.EsPlantilla = EsPlantilla;
        this.idFamilia = idFamilia;
    }

    public Producto() {
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

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public double getPVP() {
        return PVP;
    }

    public void setPVP(double PVP) {
        this.PVP = PVP;
    }

    public double getCoste() {
        return Coste;
    }

    public void setCoste(double Coste) {
        this.Coste = Coste;
    }

    public String getDeCocina() {
        return DeCocina;
    }

    public void setDeCocina(String DeCocina) {
        this.DeCocina = DeCocina;
    }

    public String getEsMenu() {
        return EsMenu;
    }

    public void setEsMenu(String EsMenu) {
        this.EsMenu = EsMenu;
    }

    public String getEsPlantilla() {
        return EsPlantilla;
    }

    public void setEsPlantilla(String EsPlantilla) {
        this.EsPlantilla = EsPlantilla;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }
    
    
}
