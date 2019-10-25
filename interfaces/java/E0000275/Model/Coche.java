package E0000275.Model;

public class Coche {
	private Integer ID;
	private String Marca;
	private String Modelo;
	private String Color;
	private String Combustible;
	private Double Precio;

	public Coche(Integer iD, String marca, String modelo, String color, String combustible, Double precio) {
		super();
		ID = iD;
		Marca = marca;
		Modelo = modelo;
		Color = color;
		Combustible = combustible;
		Precio = precio;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getCombustible() {
		return Combustible;
	}
	public void setCombustible(String combustible) {
		Combustible = combustible;
	}
	public Double getPrecio() {
		return Precio;
	}
	public void setPrecio(Double precio) {
		Precio = precio;
	}

	

}
