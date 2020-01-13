package Ejercicio13;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private static ServerSocket serverSocket;
	private static final int PORT = 9876;

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]) throws IOException, ClassNotFoundException {

		serverSocket = new ServerSocket(PORT);
		System.out.println("(SERVIDOR) escuchando por el puerto: "+PORT);
		Socket socket = serverSocket.accept();

		ObjectInputStream objetInputStream = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream objetOutputStream = null;
		String message = null;
		do {
			message = (String) objetInputStream.readObject();
			if(message.equals("*")) break;
			System.out.println("(SERVIDOR) Mensaje recibido: " + message);
			
			objetOutputStream = new ObjectOutputStream(socket.getOutputStream());

			objetOutputStream.writeObject("Numero de caracteres:" + message.length());
		}while(!message.equals("*"));
		

		objetInputStream.close();
		objetOutputStream.close();
		socket.close();

		serverSocket.close();
	}

}