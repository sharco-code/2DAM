package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Maillot {
	@Id
	@Column
	private String codigo;
	@Column
	private String tipo;
	@Column
	private String color;
	@Column
	private Integer premio;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "maillot")
	private List<Llevar> llevar = new ArrayList<Llevar>();

	public Maillot() {
	}

	public List<Llevar> getLlevar() {
		return llevar;
	}

	public void setLlevar(List<Llevar> llevar) {
		this.llevar = llevar;
	}

	public Maillot(String codigo, String tipo, String color, Integer premio) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.color = color;
		this.premio = premio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPremio() {
		return premio;
	}

	public void setPremio(Integer premio) {
		this.premio = premio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Maillot other = (Maillot) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Maillot [codigo=" + codigo + ", tipo=" + tipo + ", color=" + color + ", premio=" + premio + "]";
	}
	
}
