package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Etapa {
	@Id
	@Column
	private Integer netapa;
	@Column
	private Integer kn;
	@Column
	private String salida;
	@Column
	private String llegada;
	@Column
	private Integer dorsal;
	
	public Etapa() {
	}
	public Etapa(Integer netapa, Integer kn, String salida, String llegada, Integer dorsal) {
		super();
		this.netapa = netapa;
		this.kn = kn;
		this.salida = salida;
		this.llegada = llegada;
		this.dorsal = dorsal;
	}
	public Integer getNetapa() {
		return netapa;
	}
	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}
	public Integer getKn() {
		return kn;
	}
	public void setKn(Integer kn) {
		this.kn = kn;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public String getLlegada() {
		return llegada;
	}
	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}
	public Integer getDorsal() {
		return dorsal;
	}
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	@Override
	public String toString() {
		return "Etapa [netapa=" + netapa + ", kn=" + kn + ", salida=" + salida + ", llegada=" + llegada + ", dorsal="
				+ dorsal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Etapa other = (Etapa) obj;
		if (netapa == null) {
			if (other.netapa != null)
				return false;
		} else if (!netapa.equals(other.netapa))
			return false;
		return true;
	}
	
	
}
