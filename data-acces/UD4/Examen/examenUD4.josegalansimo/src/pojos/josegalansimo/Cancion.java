package pojos.josegalansimo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cancion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int cod;
	
	private String titulo;
	
	private Double duracion;
	
	@ManyToMany(mappedBy="canciones")
	private List<Disco> discos;

	public Cancion() {
		super();
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

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	

	public Cancion(int cod, String titulo, Double duracion, List<Disco> discos) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.duracion = duracion;
		this.discos = discos;
	}



	public List<Disco> getDiscos() {
		return discos;
	}



	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
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
		return "Cancion [cod=" + cod + ", titulo=" + titulo + ", duracion=" + duracion + ", esta=" + discos + "]";
	}
	
	
}
