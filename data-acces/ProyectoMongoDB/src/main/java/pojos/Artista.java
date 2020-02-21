package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artista implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String dni;
	
	private String nombre;
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy="artista")
	private List<Pertenece> pertenece = new ArrayList<Pertenece>();
	
	

	public Artista() {
		super();
	}

	public Artista(String dni, String nombre, List<Pertenece> pertenece) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.pertenece = pertenece;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pertenece> getPertenece() {
		return pertenece;
	}

	public void setPertenece(List<Pertenece> pertenece) {
		this.pertenece = pertenece;
	}

	@Override
	public String toString() {
		return "Artista [dni=" + dni + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Artista other = (Artista) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	
	

}
