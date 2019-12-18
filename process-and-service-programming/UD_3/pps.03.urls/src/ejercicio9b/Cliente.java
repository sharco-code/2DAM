package ejercicio9b;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		Socket client = null;
		try {
			client = new Socket("127.0.0.1", 6000);
		} catch (IOException io) {
			System.out.println(io);
		}
		String msg = "Saludos desde el cliente.";
		
	}

}
