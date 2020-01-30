package Ejercicio2.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Hilo extends Thread {

	private Socket client;
	
	private int id;
	private Compartido compartido;
	private int jugadasrestantes = 2;
	
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public Hilo(Socket client, int id, Compartido compartido) throws IOException {
		this.client = client;
		this.id = id;
		this.compartido = compartido;
	}

	@Override
	public void run() {
		
		try {
			//enviar id
			objectOutputStream = new ObjectOutputStream(client.getOutputStream());
			objectOutputStream.writeObject(new Integer(id));
			
			//recibir confirmacion id
			objectInputStream = new ObjectInputStream(client.getInputStream());
			boolean confirmation = (Boolean) objectInputStream.readObject();
			if(confirmation) System.out.println("(SERVIDOR) Cliente con id '"+id+"' se ha conectado");
			
			//enviar jugadas
			objectOutputStream = new ObjectOutputStream(client.getOutputStream());
			objectOutputStream.writeObject(new Integer(jugadasrestantes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		while (true) {
			if (!client.isConnected()) {
				System.out.println("(SERVIDOR) Cliente con id '"+id+"' se ha desconectado");
				return;
			}
			if(jugadasrestantes==0) {
				System.out.println("(SERVIDOR) Cliente con id '"+id+"' se ha quedado sin jugadas, se ha desconectado");
				return;
			}
			try {
				
				objectInputStream = new ObjectInputStream(client.getInputStream());
				Integer apuesta = (Integer) objectInputStream.readObject();
				
				if(apuesta==-1) {
					System.out.println("(SERVIDOR) Cliente con id '"+id+"' se ha desconectado");
					return;
				}
				String resultado = compartido.jugar(id, apuesta);
				jugadasrestantes--;
				objectOutputStream = new ObjectOutputStream(client.getOutputStream());
				objectOutputStream.writeObject(new String(resultado));
				if(resultado.equals("Ya no se pueden hacer mas apuestas, se han repartido todos los premios")) {
					
				}
			} catch (Exception e) {
				System.out.println("(SERVIDOR) Cliente con id '"+id+"' se ha desconectado");
				return;
			} 
		}
		
	}

}
