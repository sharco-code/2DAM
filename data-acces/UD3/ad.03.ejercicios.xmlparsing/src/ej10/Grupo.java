package ej10;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Grupo implements Serializable {
	private String nombre;
	@Id
	private String codigo;
	private int maxalumnos;
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "grupo")
	private List<Alumno> alumnos;
	
	public Grupo() {
		super();
	}
	public Grupo(String nombre, String codigo, int maxalumnos, List<Alumno> alumnos) {
		super();
		this.nombre = nombre;
		
		this.codigo = codigo;
		this.maxalumnos = maxalumnos;
		this.alumnos = alumnos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getMaxalumnos() {
		return maxalumnos;
	}
	public void setMaxalumnos(int maxalumnos) {
		this.maxalumnos = maxalumnos;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", codigo=" + codigo + ", maxalumnos=" + maxalumnos + ", alumnos=" + alumnos
				+ "]";
	}
	
	
	
}
