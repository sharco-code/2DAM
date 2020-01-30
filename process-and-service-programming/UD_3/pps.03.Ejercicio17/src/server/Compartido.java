package server;

public class Compartido {

	private int num;
	private boolean isFinished = false;
	private int idWinner;

	public Compartido(int numero) {
		this.num = numero;
	}

	public synchronized String nuevaJugada(int id, int num) {
		String cadena = "";

		if (!isFinished) {
			if (num > this.num) return "El numero es demasiado alto";
			if (num < this.num) return "El numero es demasiado bajo";
			if (num == this.num) {
				this.isFinished = true;
				this.idWinner = id;
				return "Has ganado! el nº era " + this.num;
			}
		} else return "El juego ha terminado, el ganador es el jugador " + this.idWinner + ", el numero era " + this.num;
	}

	public boolean isTerminado() {
		return isFinished;
	}

	public int getIdGanador() {
		return idWinner;
	}

}
