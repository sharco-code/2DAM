package model;

import java.io.Serializable;

public class Numero implements Serializable {

    private static final long serialVersionUID = 1L;

    private int numero;
    private double cuadrado;
    private double cubo;

    public Numero() { }
    
    public Numero(int numero, double cuadrado, double cubo) {
        this.numero = numero;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(double cuadrado) {
        this.cuadrado = cuadrado;
    }

    public double getCubo() {
        return cubo;
    }

    public void setCubo(double cubo) {
        this.cubo = cubo;
    }

	@Override
	public String toString() {
		return "Numero [numero=" + numero + ", cuadrado=" + cuadrado + ", cubo=" + cubo + "]";
	}
    
    
}
