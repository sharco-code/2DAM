package pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Puerto {
	@Id
	private String nompuerto;
	
	@Column
	private Integer altura;
	
	@Column
	private String categoria;
	
	@Column
	private Double pendiente;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="netapa")
	private Etapa etapa;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="dorsal")
	private Ciclista ganador;
	
	public Puerto() {
	}
	public Puerto(String nompuerto, Integer altura, String categoria, Double pendiente, Etapa etapa,
			Ciclista ganador) {
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.etapa = etapa;
		this.ganador = ganador;
	}
	public String getNompuerto() {
		return nompuerto;
	}
	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPendiente() {
		return pendiente;
	}
	public void setPendiente(Double pendiente) {
		this.pendiente = pendiente;
	}

	public Etapa getEtapa() {
		return etapa;
	}
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
	
	public Ciclista getGanador() {
		return ganador;
	}
	public void setGanador(Ciclista ganador) {
		this.ganador = ganador;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nompuerto == null) ? 0 : nompuerto.hashCode());
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
		Puerto other = (Puerto) obj;
		if (nompuerto == null) {
			if (other.nompuerto != null)
				return false;
		} else if (!nompuerto.equals(other.nompuerto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Puerto [nompuerto=" + nompuerto + ", altura=" + altura + ", categoria=" + categoria + ", pendiente="
				+ pendiente + ", etapa=" + etapa + ", ganador=" + ganador + "]";
	}
	
	
	
}
