package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Ciclista implements Serializable {
	@Id
	@Column
	private Integer dorsal;
	@Column
	private String nombre;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name="nomeq")
	private Equipo equipo;
	@Column
	private String nacimiento;
	@Column
	private String nomrep;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "ciclista")
	private List<Etapa> etapasGanadas = new ArrayList<>();
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "ganador")
	private List<Puerto> puertosGanados = new ArrayList<>();
	
	
	public Ciclista() {}
	public Ciclista(Integer dorsal, String nombre, String nacimiento, String nomrep, Equipo equipo) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.nomrep = nomrep;
		this.equipo = equipo;
	}
	
	public List<Etapa> getEtapasGanadas() {
		return etapasGanadas;
	}
	public void setEtapasGanadas(List<Etapa> etapas) {
		this.etapasGanadas = etapas;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Integer getDorsal() {
		return dorsal;
	}
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getNomrep() {
		return nomrep;
	}
	public void setNomrep(String nomrep) {
		this.nomrep = nomrep;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dorsal == null) ? 0 : dorsal.hashCode());
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
		Ciclista other = (Ciclista) obj;
		if (dorsal == null) {
			if (other.dorsal != null)
				return false;
		} else if (!dorsal.equals(other.dorsal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ciclista [dorsal=" + dorsal + ", nombre=" + nombre + ", equipo=" + equipo + ", nacimiento=" + nacimiento
				+ ", nomrep=" + nomrep + ", etapas=" + etapasGanadas + "]";
	}
	public List<Puerto> getPuertosGanados() {
		return puertosGanados;
	}
	public void setPuertosGanados(List<Puerto> puertosGanados) {
		this.puertosGanados = puertosGanados;
	}
	
}
