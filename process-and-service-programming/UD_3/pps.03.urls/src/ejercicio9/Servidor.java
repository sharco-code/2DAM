package ejercicio9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket servidor = null;
		int port = 6000;
		try {
			servidor = new ServerSocket(port);
			System.out.println("Servidor escuchando en el puerto "+port);
		} catch (IOException io) {
			System.out.println(io);
		}
		Socket client_acceptat = null;
		try {
			client_acceptat = servidor.accept();
		} catch (IOException io) {
			System.out.println(io);
		}
		System.out.println("*** Datos del primer cliente ***");
		System.out.println("Puerto del cliente:"+client_acceptat.getPort());
		System.out.println("Puerto del servidor:"+client_acceptat.getLocalPort());
		System.out.println("Direccion ip del cliente:"+client_acceptat.getInetAddress());
		System.out.println("Direccion ip del servidor:"+client_acceptat.getLocalAddress());
		
		try {
			client_acceptat = servidor.accept();
		} catch (IOException io) {
			System.out.println(io);
		}
		System.out.println("*** Datos del primer cliente ***");
		System.out.println("Puerto del cliente:"+client_acceptat.getPort());
		System.out.println("Puerto del servidor:"+client_acceptat.getLocalPort());
		System.out.println("Direccion ip del cliente:"+client_acceptat.getInetAddress());
		System.out.println("Direccion ip del servidor:"+client_acceptat.getLocalAddress());
	}

}
