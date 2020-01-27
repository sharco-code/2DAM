package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static ServerSocket serverSocket;

	private static final int PORT = 9876;

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("(SERVIDOR) escuchando por el puerto: " + PORT);

			int id = 1;
			int numero = (int) (1 + 25 * Math.random());
			System.out.println("Numero: " + numero);
			
			Compartido compartido = new Compartido(numero);
			while (true) {
				Socket client = serverSocket.accept();
				HiloServidor hiloServidor = new HiloServidor(client, id, compartido);
				hiloServidor.start();

				id++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
