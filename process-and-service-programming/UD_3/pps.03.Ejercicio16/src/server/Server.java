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
	
	private static int IDs = 1;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		serverSocket = new ServerSocket(PORT);
		System.out.println("(SERVIDOR) escuchando por el puerto: "+PORT);
		Socket socket;
		
		while (true) {
			socket = serverSocket.accept();
			
			ServerThread serverThread = new ServerThread(socket, IDs);
			serverThread.start();
			IDs++;
		}
		
		//socket.close();
		//serverSocket.close();
	}


}