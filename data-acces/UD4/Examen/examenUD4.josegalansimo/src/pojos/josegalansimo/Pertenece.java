package pojos.josegalansimo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pertenece implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="dni")
	private Artista artista;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cod")
	private Grupo grupo;
	
	private String funcion;

	public Pertenece() {
		super();
	}

	public Pertenece(Artista artista, Grupo grupo, String funcion) {
		super();
		this.artista = artista;
		this.grupo = grupo;
		this.funcion = funcion;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		Pertenece other = (Pertenece) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pertenece [artista=" + artista + ", grupo=" + grupo + ", funcion=" + funcion + "]";
	}
	
	
}
