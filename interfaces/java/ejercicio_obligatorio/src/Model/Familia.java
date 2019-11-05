package Model;

public class Familia {
    private Integer idFamilia;
    private String Familia;
    private String Foto;
    private Integer ver;
    private Character EsMenu;
    public Familia() {
        
    }
    public Familia(Integer idFamilia, String Familia, String Foto, Integer ver, Character EsMenu) {
        this.idFamilia = idFamilia;
        this.Familia = Familia;
        this.Foto = Foto;
        this.ver = ver;
        this.EsMenu = EsMenu;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getFamilia() {
        return Familia;
    }

    public void setFamilia(String Familia) {
        this.Familia = Familia;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Character getEsMenu() {
        return EsMenu;
    }

    public void setEsMenu(Character EsMenu) {
        this.EsMenu = EsMenu;
    }
    
    
}
