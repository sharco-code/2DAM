package pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Club implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cod;
	
	private String nombre;
	
	private String sede;
	
	private int num;
	
	@ManyToOne
	@JoinColumn(name="cod_gru")
	private Grupo grupo;

	public Club() {
		super();
	}

	public Club(int cod, String nombre, String sede, int num, Grupo grupo) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.sede = sede;
		this.num = num;
		this.grupo = grupo;
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

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
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
		Club other = (Club) obj;
		if (cod != other.cod)
			return false;
		return true;
	}
	
	
	

}
