package pojos;

import java.io.Serializable;


public class Equipo implements Serializable {

	private String nomeq;

	private String director;
	
	public Equipo() {}
	public Equipo(String nombre, String director) {
		this.nomeq = nombre;
		this.director = director;
	}
	public String getNombre() {
		return nomeq;
	}
	public void setNombre(String nombre) {
		this.nomeq = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeq == null) ? 0 : nomeq.hashCode());
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
		Equipo other = (Equipo) obj;
		if (nomeq == null) {
			if (other.nomeq != null)
				return false;
		} else if (!nomeq.equals(other.nomeq))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Equipo [nomeq=" + nomeq + ", director=" + director + "]";
	}
	
}
