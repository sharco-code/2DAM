package pojos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cancion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cod;
	
	private String titulo;
	
	private double duracion;
	
	@OneToMany(mappedBy = "cancion")
	private List<Esta> esta = new ArrayList<>();

	public Cancion() {
		super();
	}

	public Cancion(int cod, String titulo, double duracion, List<Esta> esta) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.duracion = duracion;
		this.esta = esta;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
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
		Cancion other = (Cancion) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cancion [cod=" + cod + ", titulo=" + titulo + ", duracion=" + duracion  + "]";
	}
	
	
	
	
	
	
	
	

}
