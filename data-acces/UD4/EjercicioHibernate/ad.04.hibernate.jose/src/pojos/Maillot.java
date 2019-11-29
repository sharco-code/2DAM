package pojos;

public class Maillot {
	private String codigo;
	private String tipo;
	private String color;
	private Integer premio;
	
	public Maillot() {
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