import Ejercicio11.Ejercicio11.EstadoAsientos;

public class Ejercicio12 {

	public static class ObjetoCompartido {

		private String str;
		
		private void mostrar(String str) {
			System.out.print(str+" ");
		}
		
	}
	
	public static class Hilo extends Thread {

		private ObjetoCompartido o;
		private String str;
		
		Hilo(final ObjetoCompartido o, String str) {
			this.o = o;
			this.str = str;
		}

		public void run() {			
			synchronized (o){

				for(int i = 0; i < 10; i++) {
					try {
						sleep(300);
					} catch(Exception e) {
						// TODO: handle exception
					}
					o.mostrar(str);
					o.notify();
					try {
						o.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				o.notifyAll();	
			}
		}
	}
	
	public static void main(String[] args) {
		
		ObjetoCompartido ob1 = new ObjetoCompartido();
		
		Thread th1 = new Hilo(ob1, "A");
		Thread th2 = new Hilo(ob1, "B");
		
		th1.start();
		th2.start();
	}

}
