package ej14.ej8;

import java.util.ArrayList;
import java.util.List;

public class CicloFormativo {

	private String nombre;
	private String familia;
	private int grado;
	private int horas;
	
	private List<Modulo> modulos = new ArrayList<>(); 
	
	
	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public CicloFormativo() {
		super();
	}

	public CicloFormativo(String nombre, String familia, int grado, int horas, List<Modulo> modulos) {
		super();
		this.nombre = nombre;
		this.familia = familia;
		this.grado = grado;
		this.horas = horas;
		this.modulos = modulos;
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
		String s;
		if(grado==1) s = "Medio";
		else s = "Superior";
		return nombre + "\nFamilia: " + familia + "\nGrado: " + s + "\nHoras totales: " + horas
				+ "\nModulos:" + modulos;
	}

	
	
	
	
}
