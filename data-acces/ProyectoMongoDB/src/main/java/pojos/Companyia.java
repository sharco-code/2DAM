package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Companyia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private int cod;
	
	private String nombre;
	
	private String dir;
	
	private String fax;
	
	private String tfno;
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy="companyia")
	private List<Disco> discos = new ArrayList<>();
	
	
	

	public Companyia() {
		super();
	}

	public Companyia(int cod, String nombre, String dir, String fax, String tfno, List<Disco> discos) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.dir = dir;
		this.fax = fax;
		this.tfno = tfno;
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

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
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
		Companyia other = (Companyia) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Companyia [cod=" + cod + ", nombre=" + nombre + ", dir=" + dir + ", fax=" + fax + ", tlfno=" + tfno
				 + "]";
	}
	
	
	
	
	
	
	
	

}
