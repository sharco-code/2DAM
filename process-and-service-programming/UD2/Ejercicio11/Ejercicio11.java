import Ejercicio8.Ejercicio8.Hilo;

public class Ejercicio11 {

	public static class Hilo implements Runnable {

		private int plazas_a_reservar;
		
		private EstadoAsientos estadoAsientos;
		
		Hilo(final int plazas_a_reservar, EstadoAsientos estadoAsientos) {
			this.plazas_a_reservar = plazas_a_reservar;
			this.estadoAsientos = estadoAsientos;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+" reservará "+this.plazas_a_reservar+" plazas");
			
			synchronized (estadoAsientos){
				if(estadoAsientos.reservar(plazas_a_reservar)) {
					System.out.println(Thread.currentThread().getName()+" Reserva realizada con éxito. Las plazas libres son "+estadoAsientos.getPlazas_libres());
				} else {
					System.out.println("No hay "+plazas_a_reservar+" plazas suficientes para el cliente "+Thread.currentThread().getName()+" Las plazas libres son "+estadoAsientos.getPlazas_libres());
				}
					
			}
		}
	}
	
	public static class EstadoAsientos {
		
		private int plazas_libres = 10;
		
		EstadoAsientos() {
		}
		
		public boolean reservar(int n) {
			if(plazas_libres - n > 0) {
				plazas_libres = plazas_libres - n;
				return true;
			}
			return false;
		}
		public int getPlazas_libres() {
			return plazas_libres;
		}
	}

	
	public static void main(String[] args) {
		Thread[] MiHilo = new Thread[2];
		EstadoAsientos estadoAsientos = new EstadoAsientos();
		
		Thread Cliente1 = new Thread(new Hilo(((int) (Math.random() * 10) + 1), estadoAsientos));
		Cliente1.setName("Cliente1");
		Thread Cliente2 = new Thread(new Hilo(((int) (Math.random() * 10) + 1), estadoAsientos));
		Cliente2.setName("Cliente2");

		Cliente1.start();
		Cliente2.start();
		
	}
	
}
