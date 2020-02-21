package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cod;
	
	private String nombre;
	
	private String fecha;
	
	private String pais;
	
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy="grupo")
	private List<Pertenece> pertenece = new ArrayList<>();
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy="grupo")
	private List<Disco> discos = new ArrayList<>();
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy="grupo")
	private List<Club> clubs = new ArrayList<>();
	
	
	

	public Grupo() {
		super();
	}




	public Grupo(int cod, String nombre, String fecha, String pais, List<Pertenece> pertenece, List<Disco> discos) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.fecha = fecha;
		this.pais = pais;
		this.pertenece = pertenece;
		this.discos = discos;
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




	public String getPais() {
		return pais;
	}




	public void setPais(String pais) {
		this.pais = pais;
	}




	public List<Pertenece> getPertenece() {
		return pertenece;
	}




	public void setPertenece(List<Pertenece> pertenece) {
		this.pertenece = pertenece;
	}




	public List<Disco> getDiscos() {
		return discos;
	}




	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}
	
	




	public List<Club> getClubs() {
		return clubs;
	}




	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}




	@Override
	public String toString() {
		return "Grupo [cod=" + cod + ", nombre=" + nombre + ", fecha=" + fecha + ", pais=" + pais + "]";
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
		Grupo other = (Grupo) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

	
	
	
	
	
	
	

}
