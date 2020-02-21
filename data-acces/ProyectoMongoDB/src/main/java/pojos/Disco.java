package pojos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Disco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cod;
	
	private String nombre;
	
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name="cod_gru")
	private Grupo grupo;
	
	@ManyToOne
	@JoinColumn(name="cod_comp")
	private Companyia companyia;
	
	@OneToMany(mappedBy = "disco")
	private List<Esta> esta = new ArrayList<>();
	
	

	public Disco() {
		super();
	}

	public Disco(int cod, String nombre, String fecha, Grupo grupo, Companyia companyia, List<Esta> esta) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.fecha = fecha;
		this.grupo = grupo;
		this.companyia = companyia;
		this.esta = esta;
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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Companyia getCompanyia() {
		return companyia;
	}

	public void setCompanyia(Companyia companyia) {
		this.companyia = companyia;
	}

	public List<Esta> getEsta() {
		return esta;
	}

	public void setEsta(List<Esta> esta) {
		this.esta = esta;
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
		return "Disco [cod=" + cod + ", nombre=" + nombre + ", fecha=" + fecha + ", grupo=" + grupo + ", companyia="
				+ companyia  + "]";
	}
	
	
	
	

}
