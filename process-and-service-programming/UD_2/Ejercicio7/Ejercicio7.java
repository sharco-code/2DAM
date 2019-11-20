public class Ejercicio7 {

	public static class Hilo implements Runnable {
		private int num;
		
		Hilo(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			int f=0;
			int t1=1,t2;
			for (int i = 0; i < num; i++) {
				t2 = f;
				f = t1 + f;
				t1 = t2;
				System.out.printf("%s Posicion: %d Valor: %d\n",Thread.currentThread().getName(),i,t1);
			}
			System.out.println(Thread.currentThread().getName()+" acabado !!!!");
		}
	}

	public static void main(String[] args) {
		
		Thread[] MiHilo = new Thread[10];
		for (int i = 0; i < 10; i++) {
			MiHilo[i] = new Thread(new Hilo(((int) (Math.random() * 20) + 1)));
			MiHilo[i].setName("MiHilo_"+i);
			MiHilo[i].start();
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
		
		for (Thread thread : MiHilo) System.out.println(thread.getName()+" "+thread.isAlive()+" "+thread.getState());
		System.out.println("HILO PRINCIPAL ACABADO!!!");
	}

}