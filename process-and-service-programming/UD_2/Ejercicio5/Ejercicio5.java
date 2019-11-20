public class Ejercicio5 {

	public static class Hilo extends Thread {
		
		private int a, b;
		
		Hilo(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public void run() {
			System.out.printf("Base=%d --- Altura=%d --- Área=%.1f\n\n",a,b,(float)(a*b/2));
		}
	}
	
	public static void main(String[] args) {

		Thread hilo1 = new Hilo(((int) (Math.random() * 10) + 1), ((int) (Math.random() * 10) + 1));
		hilo1.start();
		Thread hilo2 = new Hilo(((int) (Math.random() * 10) + 1), ((int) (Math.random() * 10) + 1));
		hilo2.start();
		Thread hilo3 = new Hilo(((int) (Math.random() * 10) + 1), ((int) (Math.random() * 10) + 1));
		hilo3.start();
		Thread hilo4 = new Hilo(((int) (Math.random() * 10) + 1), ((int) (Math.random() * 10) + 1));
		hilo4.start();
		Thread hilo5 = new Hilo(((int) (Math.random() * 10) + 1), ((int) (Math.random() * 10) + 1));
		hilo5.start();
	}

}
