package Ejercicio2.server;

public class Compartido {
	
	private String[] vector;
	
	private boolean isApartamentoAdjudicado = false;
	private boolean isCruceroAdjudicado = false;
	
	Compartido(String[] vector) {
		this.vector = vector;
	}

	public synchronized String jugar(int id, int apuesta) {
		if(vector[apuesta].equals("Apartamento")) {
			if(isApartamentoAdjudicado) return "Ese premio ya lo ha ganado otro cliente";
			isApartamentoAdjudicado = true;
			return "Has ganado "+vector[apuesta];
		}

		if(vector[apuesta].equals("Crucero")) {
			if(isCruceroAdjudicado) return "Ese premio ya lo ha ganado otro cliente";
			isCruceroAdjudicado = true;
			return "Has ganado "+vector[apuesta];
		}

		return "No has ganado nada";
	}

	public boolean isApartamentoAdjudicado() {
		return isApartamentoAdjudicado;
	}


	public boolean isCruceroAdjudicado() {
		return isCruceroAdjudicado;
	}


}
