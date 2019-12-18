package ejercicio9;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		Socket client = null;
		String host = "127.0.0.1";
		int portServer = 6000; // num port prefixat
		try {
			client = new Socket(host, portServer);
		} catch (IOException io) {
			System.out.println(io);
		}

	}

}
