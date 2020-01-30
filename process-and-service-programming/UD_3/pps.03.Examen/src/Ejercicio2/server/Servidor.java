package Ejercicio2.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static ServerSocket serverSocket;

	private static final int PORT = 8000;

	private static String[] vector = new String[20];
	
	private static void asignarPremios() {
		int numero1, numero2;
		//bucle para que no sean iguales los numeros
		do {
			numero1 = (int) (1 + 20 * Math.random()) - 1;
			numero2 = (int) (1 + 20 * Math.random()) - 1;
		} while (numero1==numero2);
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = "Sin premio";
		}
		vector[numero1] = "Apartamento";
		System.out.println("(SERVIDOR) "+vector[numero1]+" en la posicion "+numero1);
		
		vector[numero2] = "Crucero";
		System.out.println("(SERVIDOR) "+vector[numero2]+" en la posicion "+numero2);
		System.out.println("----------------------------------------------------");
	}
	
	public static void main(String[] args) {
		try {
			asignarPremios();
			
			serverSocket = new ServerSocket(PORT);
			System.out.println("(SERVIDOR) escuchando por el puerto: " + PORT);

			int id = 1;
			
			Compartido compartido = new Compartido(vector);
			while (true) {
				if(compartido.isApartamentoAdjudicado() && compartido.isCruceroAdjudicado()) {
					System.out.println("(SERVIDOR) todos los premios repartidos, cerrando serivor");
					System.exit(0);
				}
				Socket client = serverSocket.accept();
				Hilo hilo = new Hilo(client, id, compartido);
				hilo.start();
				id++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
