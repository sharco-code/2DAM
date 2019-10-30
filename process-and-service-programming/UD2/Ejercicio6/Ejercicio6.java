public class Ejercicio6 {

	public static class Hilo implements Runnable {

		private int radio;
		
		private double circunferencia;
		private double area;
		private double volumen;
		
		private final double INCREMENTO = 0.04;
		
		Hilo(int radio) {
			this.radio = radio;
		}

		@Override
		public void run() {
			for (double i = 00.4; i <= radio; i+=INCREMENTO) {
				circunferencia = 2*i*Math.PI;
				area = Math.PI*Math.pow(i, 2);
				volumen = 4/3*Math.PI*Math.pow(i, 3);
				System.out.printf("Hilo: %s Circunferencia: %.2f Área: %.2f Volumen: %.2f\n",Thread.currentThread().getName(),circunferencia,area,volumen);
			}
			
		}
	}

	public static void main(String[] args) {

		Hilo hilo = new Hilo(((int) (Math.random() * 10) + 1));
		
		for (int i = 0; i < 20; i++) {
			Thread thread = new Thread(hilo);
			thread.start();
		}
		

	}

}
