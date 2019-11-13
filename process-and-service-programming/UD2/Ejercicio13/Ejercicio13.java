import Ejercicio12.Ejercicio12.Hilo;

public class Ejercicio13 {

	public static class Productor extends Thread {
		
		private final int ITERACIONES = 5;
		
		private Monitor monitor;
		
		public Productor(final Monitor monitor) {
			this.monitor = monitor;
		}
		
		public void run() {	
			
			try {
				for (int i = 0; i < ITERACIONES; i++) {
					int nRand = ((int) (Math.random() * 10) + 1);
					monitor.setNum(nRand);
					System.out.println(" [Productor] numero introducido: "+nRand);
					sleep(300);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static class Consmuidor extends Thread {
		
		private final int ITERACIONES = 5;
		
		private Monitor monitor;
		
		public Consmuidor(final Monitor monitor) {
			this.monitor = monitor;
		}
		
		public void run() {
			try {
					for (int i = 0; i < ITERACIONES; i++) {

						System.out.println(" [Consmuidor] numero almacenado: "+monitor.getNum());
						
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class Monitor { 
		private int num;
		private boolean disponible;
		
		public Monitor() {
			num = 0;
			disponible = false;
		}
		
		public boolean isDisponible() {
			return disponible;
		}

		public void setDisponible(boolean disponible) {
			this.disponible = disponible;
		}

		public synchronized int getNum() {
			while(!disponible) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			this.disponible = false;
			this.notify();
			return num;
		}
		
		public synchronized void setNum(final int num) {
			
			while(disponible) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			this.num = num;
			this.disponible = true;
			this.notify();
		}
	}
	
	public static void main(String[] args) {
		Monitor m  = new Monitor();
		
		Consmuidor c = new Consmuidor(m);
		
		Productor p = new Productor(m);
		
		Thread th1 = c;
		Thread th2 = p;
		p.start();
		c.start();
	}

}
