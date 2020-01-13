package Ejercicio14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
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

			Persona p = (Persona) objetInputStream.readObject();
			System.out.println("(SERVIDOR) Mensaje recibido: " + p.toString());
			
			ObjectOutputStream objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
			p.setNombre(p.getNombre().toUpperCase());
			objetOutputStream.writeObject(p);

			objetInputStream.close();
			objetOutputStream.close();
			socket.close();

			serverSocket.close();
		
	}

}