package ej10;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Alumno {
	@Id
	private int expediente;
	private String nombrealu;
	private String fechaingreso;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="grupo_codigo")
	private Grupo grupo;
	
	public Alumno() {
		super();
	}

	public Alumno(int expediente, String nombrealu, String fechaingreso, Grupo grupo) {
		super();
		this.expediente = expediente;
		this.nombrealu = nombrealu;
		this.fechaingreso = fechaingreso;
		this.grupo = grupo;
	}

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getNombrealu() {
		return nombrealu;
	}

	public void setNombrealu(String nombrealu) {
		this.nombrealu = nombrealu;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Alumno [expediente=" + expediente + ", nombrealu=" + nombrealu + ", fechaingreso=" + fechaingreso
				+ ", grupo=" + grupo + "]";
	}
	
	
	
}
