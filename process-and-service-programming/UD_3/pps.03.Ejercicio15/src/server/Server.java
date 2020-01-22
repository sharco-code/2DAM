package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Numero;

public class Server {

	private static ServerSocket serverSocket;
	
	private static final int PORT = 9876;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		serverSocket = new ServerSocket(PORT);
		System.out.println("(SERVIDOR) escuchando por el puerto: "+PORT);
		Socket socket = serverSocket.accept();

		Numero n;
		
		ObjectInputStream objetInputStream = null;
		ObjectOutputStream objetOutputStream = null;
		
		do {
			objetInputStream = new ObjectInputStream(socket.getInputStream());
			
			n = (Numero) objetInputStream.readObject();

			if (n.getNumero() <= 0) break;
			if(n.getNumero()==0) {
				System.out.println("Cerrando servidor...");
				System.exit(0);
			}
			n.setCuadrado(Math.pow(n.getNumero(), 2));
			n.setCubo(Math.pow(n.getNumero(), 3));
			objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objetOutputStream.writeObject(n);

		} while(n.getNumero() >= 0);

		objetInputStream.close();
		objetOutputStream.close();
		socket.close();

		serverSocket.close();
	}

}