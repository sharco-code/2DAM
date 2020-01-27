package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Numero;

public class ServerThread extends Thread {

	private Socket socket;
	
	private int idClient;
	
	ServerThread(Socket socket, int iDs) {
		this.socket = socket;
		this.idClient = iDs;
	}
	
	@Override
	public void run() {
		try {
			Numero n;
			
			ObjectInputStream objetInputStream = null;
			ObjectOutputStream objetOutputStream = null;
			
			//enviar id
			objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objetOutputStream.writeObject(new Integer(idClient));
			
			//recibir confirmacion id
			objetInputStream = new ObjectInputStream(socket.getInputStream());
			boolean confirmation = (Boolean) objetInputStream.readObject();
			if(confirmation) System.out.println("(SERVIDOR) se ha conectado un cliente con id: "+idClient);
			
			do {
				objetInputStream = new ObjectInputStream(socket.getInputStream());
				
				n = (Numero) objetInputStream.readObject();

				if(n.getNumero()==0) {
					System.out.println("(SERVIDOR) Cliente con id: "+idClient+" se ha desconectado");
					
					break;
				}
				n.setCuadrado(Math.pow(n.getNumero(), 2));
				n.setCubo(Math.pow(n.getNumero(), 3));
				objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
				objetOutputStream.writeObject(n);

			} while(n.getNumero() >= 0);

			objetInputStream.close();
			objetOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}
