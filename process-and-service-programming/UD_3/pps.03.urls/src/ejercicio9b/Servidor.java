package ejercicio9b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(6000);
			System.out.println("Servidor escuchando en el puerto "+6000);
		} catch (IOException io) {
			System.out.println(io);
		}
		Socket client = null;
		try {
			client = servidor.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
			
		} catch (IOException io) {
			System.out.println(io);
		}
		
		
		try {
			client = servidor.accept();
		} catch (IOException io) {
			System.out.println(io);
		}
		System.out.println("*** Datos del primer cliente ***");
		System.out.println("Puerto del cliente:"+client.getPort());
		System.out.println("Puerto del servidor:"+client.getLocalPort());
		System.out.println("Direccion ip del cliente:"+client.getInetAddress());
		System.out.println("Direccion ip del servidor:"+client.getLocalAddress());
	}

}
