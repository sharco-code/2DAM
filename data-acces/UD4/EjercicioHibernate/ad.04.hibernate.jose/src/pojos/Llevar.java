package pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Llevar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="dorsal")
	private Ciclista ciclista;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="netapa")
	private Etapa etapa;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="codigo")
	private Maillot maillot;
	
	public Llevar() {
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Maillot getMaillot() {
		return maillot;
	}

	public void setMaillot(Maillot maillot) {
		this.maillot = maillot;
	}

	public Llevar(Ciclista ciclista, Etapa etapa, Maillot maillot) {
		this.ciclista = ciclista;
		this.etapa = etapa;
		this.maillot = maillot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etapa == null) ? 0 : etapa.hashCode());
		result = prime * result + ((maillot == null) ? 0 : maillot.hashCode());
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
		if (etapa == null) {
			if (other.etapa != null)
				return false;
		} else if (!etapa.equals(other.etapa))
			return false;
		if (maillot == null) {
			if (other.maillot != null)
				return false;
		} else if (!maillot.equals(other.maillot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Llevar [ciclista=" + ciclista + ", etapa=" + etapa + ", maillot=" + maillot + "]";
	}
	
	
	
}
