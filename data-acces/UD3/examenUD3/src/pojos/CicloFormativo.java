package pojos;



public class CicloFormativo {

	private String nom;
	private String familia;
	private int grau;
	private int hores;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public int getGrau() {
		return grau;
	}
	public void setGrau(int grau) {
		this.grau = grau;
	}
	public int getHores() {
		return hores;
	}
	public void setHores(int hores) {
		this.hores = hores;
	}
	public CicloFormativo(String nom, String familia, int grau, int hores) {
		super();
		this.nom = nom;
		this.familia = familia;
		this.grau = grau;
		this.hores = hores;
	}
	public CicloFormativo() {
		super();
	}
	@Override
	public String toString() {
		return "CicloFormativo [nom=" + nom + ", familia=" + familia + ", grau=" + grau + ", hores=" + hores + "]";
	}
	
	
	
}
