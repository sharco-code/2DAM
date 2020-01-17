package ej7;

public class CicloFormativo {

	private String nombre;
	private String familia;
	private int grado;
	private int horas;
	
	public CicloFormativo(String nombre, String familia, int grado, int horas) {
		super();
		this.nombre = nombre;
		this.familia = familia;
		this.grado = grado;
		this.horas = horas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "CicloFormativo [nombre=" + nombre + ", familia=" + familia + ", grado=" + grado + ", horas=" + horas
				+ "]";
	}
	
	
	
}
