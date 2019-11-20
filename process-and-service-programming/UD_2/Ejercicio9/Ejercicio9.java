public class Ejercicio9 {

	public static class Contador  {
		
		private int contador = 0;
		
		Contador(final int cotnador) {
			this.contador = cotnador;
		}
		
		public void incrementa() {
			contador++;
		}
		public void decrementa() {
			contador--;
		}
		public int obtenerContador() {
			return contador;
		}
	}
	
	public static class Incrementa extends Thread  {
		
		private Contador contador;
		
		private final int MAX = 300;
		
		Incrementa(Contador contador) {
			this.currentThread().setName("HiloIncrementa");
			this.contador = contador;
		}
		
		@Override
		public void run() {
			synchronized (contador) {
				for (int i = 0; i < MAX; i++) {
					contador.incrementa();
				}
			}
			System.out.println("HiloIncrementa: El contador vale "+contador.obtenerContador());
		}
	}
	
	public static class Decrementa extends Thread  {
		
		private Contador contador;
		
		private final int MAX = 300;
		
		Decrementa(Contador contador) {
			this.currentThread().setName("HiloDecrementa");
			this.contador = contador;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < MAX; i++) {
				contador.decrementa();
			}
			System.out.println("HiloDecrementa: El contador vale "+contador.obtenerContador());
		}
	}
	
	public static void main(String[] args) {

		Contador c = new Contador(100);
		
		Thread i = new Incrementa(c);
		Thread d = new Decrementa(c);
		
		i.start();
		d.start();
	}

}
