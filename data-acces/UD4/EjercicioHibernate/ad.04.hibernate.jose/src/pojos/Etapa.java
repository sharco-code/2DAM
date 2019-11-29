package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Etapa {
	@Id
	@Column
	private Integer netapa;
	@Column
	private Integer km;
	@Column
	private String salida;
	@Column
	private String llegada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="dorsal")
	private Ciclista ciclista;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "etapa")
	private List<Puerto> puertos = new ArrayList<Puerto>();
	
	public Etapa() {
	}
	public Etapa(Integer netapa, Integer km, String salida, String llegada, Ciclista ciclista) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.ciclista = ciclista;
	}
	public Integer getNetapa() {
		return netapa;
	}
	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}
	public Integer getkm() {
		return km;
	}
	public void setKn(Integer kn) {
		this.km = km;
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

	
	@Override
	public String toString() {
		return "Etapa [netapa=" + netapa + ", kn=" + km + ", salida=" + salida + ", llegada=" + llegada + ", ciclista="
				+ ciclista + ", puertos=" + puertos + "]";
	}
	public Ciclista getCiclista() {
		return ciclista;
	}
	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}
	public List<Puerto> getPuertos() {
		return puertos;
	}
	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
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
