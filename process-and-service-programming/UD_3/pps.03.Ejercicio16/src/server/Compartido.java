package server;

public class Compartido {
	
	private int num;
	private boolean isFinished;
	private int idWinner;

	public Compartido(int numero) {
		this.num = numero;
		this.isFinished = false;
	}
	
	public synchronized String nuevaJugada(int id,int num) {
		String cadena = "";

		if(!isFinished) {
			if(num>num) return "El numero es demasiado alto";
			if(num<num) return "El numero es demasiado bajo";
			if(num==num) {
				this.isFinished = true;
				this.idWinner = id;
				return "Has ganado! el nº era "+num;
			}
		}else {
			return "El juego ha terminado, el ganador es el jugador "+this.idWinner+", el numero era "+this.num;
		}
		
		return cadena;
	}

	public boolean isTerminado() {
		return isFinished;
	}

	public int getIdGanador() {
		return idWinner;
	}
	
	

}
