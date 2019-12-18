package ejercicio11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static ServerSocket serverSocket;
	private static final int PORT = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		serverSocket = new ServerSocket(PORT);

		Socket socket = serverSocket.accept();

		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

		String message = (String) ois.readObject();
		System.out.println("(SERVIDOR) Mensaje recibido: " + message);

		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

		oos.writeObject("" + (Integer.parseInt(message)*Integer.parseInt(message)));

		ois.close();
		oos.close();
		socket.close();

		serverSocket.close();
	}

}
