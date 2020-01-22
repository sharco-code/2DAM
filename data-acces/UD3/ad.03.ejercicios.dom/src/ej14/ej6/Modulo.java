package ej14.ej6;

public class Modulo {

	private String nombre;
	private int horas;
	private int curso;
	
	public Modulo(String nombre, int horas, int curso) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", horas=" + horas + ", curso=" + curso + "]";
	}
	
	
}
