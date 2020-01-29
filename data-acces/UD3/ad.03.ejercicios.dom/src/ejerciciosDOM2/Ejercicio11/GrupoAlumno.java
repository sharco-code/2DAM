package ejerciciosDOM2.Ejercicio11;

import java.util.List;

public class GrupoAlumno {
	private String codigo;
	private String nombre;
	private int maxAlumnos;
	private List<String> nombreAlumnos;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMaxAlumnos() {
		return maxAlumnos;
	}
	public void setMaxAlumnos(int maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}
	public List<String> getNombreAlumnos() {
		return nombreAlumnos;
	}
	public void setNombreAlumnos(List<String> nombreAlumnos) {
		this.nombreAlumnos = nombreAlumnos;
	}
	public GrupoAlumno(String codigo, String nombre, int maxAlumnos, List<String> nombreAlumnos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.maxAlumnos = maxAlumnos;
		this.nombreAlumnos = nombreAlumnos;
	}
	public GrupoAlumno() {
		super();
	}
	@Override
	public String toString() {
		return "GrupoAlumno [codigo=" + codigo + ", nombre=" + nombre + ", maxAlumnos=" + maxAlumnos
				+ ", nombreAlumnos=" + nombreAlumnos + "]";
	}
	
}
