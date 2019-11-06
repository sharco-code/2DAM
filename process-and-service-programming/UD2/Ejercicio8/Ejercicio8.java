public class Ejercicio8 {

	private static final int NUM_HILOS = 200;

	public static class Hilo implements Runnable {

		private int radio;
		private int altura;

		Hilo(final int radio, final int altura) {
			this.radio = radio;
			this.altura = altura;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "- Radio = "+radio+" altura = "+altura+" Volumen = "+(Math.PI*Math.pow(radio, 2)*altura)+" Área = "+(2*Math.PI*radio*altura));
		}
	}

	public static void main(String[] args) {
		
		Thread[] MiHilo = new Thread[NUM_HILOS];

		for (int i = 0; i < MiHilo.length; i++) {
			MiHilo[i] = new Thread(new Hilo(((int) (Math.random() * 20) + 1), ((int) (Math.random() * 20) + 1)));
			
			if(i % 5 == 0) {
				MiHilo[i].setPriority(Thread.MAX_PRIORITY);
				MiHilo[i].setName("MiHilo("+"MAXIMA"+")"+i);
			}
			else if(i % 3 == 0) {
				MiHilo[i].setPriority(Thread.NORM_PRIORITY);;
				MiHilo[i].setName("MiHilo("+"NORMAL"+")"+i);
			}
			else {
				MiHilo[i].setPriority(Thread.MIN_PRIORITY);;
				MiHilo[i].setName("MiHilo("+"MINIMA"+")"+i);
			}
			
			MiHilo[i].start();
			try {
				MiHilo[i].join();
			} catch (InterruptedException e) {
			}
			
		}
		System.out.println("- FIN DEL HILO PRINCIPAL -");
	}

}