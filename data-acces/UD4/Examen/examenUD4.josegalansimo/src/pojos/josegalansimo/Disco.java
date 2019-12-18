package pojos.josegalansimo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Disco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int cod;
	
	private String nombre;
	
	private String fecha;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="cod_comp")
	private Companyia companyia;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="cod_gru")
	private Grupo grupo;
	
	@ManyToMany
	@JoinTable(name="esta"
		,joinColumns={
			@JoinColumn(name="cod")
			}
		,inverseJoinColumns={
			@JoinColumn(name="can")
			})
	private List<Cancion> canciones;

	public Disco() {
		super();
	}

	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Companyia getCompanyia() {
		return companyia;
	}

	public void setCompanyia(Companyia companyia) {
		this.companyia = companyia;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	

	public List<Cancion> getCancions() {
		return canciones;
	}


	public void setCancions(List<Cancion> cancions) {
		this.canciones = cancions;
	}


	public Disco(int cod, String nombre, String fecha, Companyia companyia, Grupo grupo, List<Cancion> cancions) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.fecha = fecha;
		this.companyia = companyia;
		this.grupo = grupo;
		this.canciones = cancions;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disco other = (Disco) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disco [cod=" + cod + ", nombre=" + nombre + ", fecha=" + fecha + ", companyia=" + companyia + ", grupo="
				+ grupo + ", esta=" + canciones + "]";
	}
	
}
