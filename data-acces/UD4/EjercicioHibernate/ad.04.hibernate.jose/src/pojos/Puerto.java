package pojos;

public class Puerto {
	private String nompuerto;
	private Integer altura;
	private String categoria;
	private Double pendiente;
	private Integer netapa;
	private Integer dorsal;
	public Puerto() {
	}
	public Puerto(String nompuerto, Integer altura, String categoria, Double pendiente, Integer netapa,
			Integer dorsal) {
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.netapa = netapa;
		this.dorsal = dorsal;
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
	public Integer getNetapa() {
		return netapa;
	}
	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}
	public Integer getDorsal() {
		return dorsal;
	}
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
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
				+ pendiente + ", netapa=" + netapa + ", dorsal=" + dorsal + "]";
	}
	
}
