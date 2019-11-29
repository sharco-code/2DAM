package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Llevar {
	@Id
	@Column
	private Integer dorsal;
	@Column
	private Integer netapa;
	@Column
	private String codigo;
	public Llevar() {
	}
	
	
	public Llevar(Integer dorsal, Integer netapa, String codigo) {
		super();
		this.dorsal = dorsal;
		this.netapa = netapa;
		this.codigo = codigo;
	}


	public Integer getDorsal() {
		return dorsal;
	}
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	public Integer getNetapa() {
		return netapa;
	}
	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((netapa == null) ? 0 : netapa.hashCode());
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
		Llevar other = (Llevar) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (netapa == null) {
			if (other.netapa != null)
				return false;
		} else if (!netapa.equals(other.netapa))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Llevar [dorsal=" + dorsal + ", netapa=" + netapa + ", codigo=" + codigo + "]";
	}
	
}
