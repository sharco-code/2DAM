package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Datos;

public class HiloServidor extends Thread {

	private Socket client;
	
	private int id;
	private int num;
	
	private Compartido compartido;
	
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public HiloServidor(Socket client, int id, Compartido compartido) throws IOException {
		this.client = client;
		this.id = id;
		this.compartido = compartido;
	}

	@Override
	public void run() {
		Datos datos = new Datos("Adivina un nº entre 1-25", 0, id);

		while (true) {
			if (!client.isConnected()) System.out.println("(SERVIDOR) Cliente se ha desconectado");
			try {
				this.objectOutputStream = new ObjectOutputStream(client.getOutputStream());
				objectOutputStream.writeObject(datos);
				if (!datos.isJuega()) break;

				this.objectInputStream = new ObjectInputStream(client.getInputStream());
				datos = (Datos) objectInputStream.readObject();
				datos.setCadena(compartido.nuevaJugada(datos.getIdentificador(), Integer.parseInt(datos.getCadena())));

				if (compartido.isTerminado()) {
					if (datos.getIdentificador() == compartido.getIdGanador()) datos.setGana(true);

					datos.setJuega(false);
				}

				datos.setIntentos(datos.getIntentos() + 1);

				if (datos.getIntentos() >= 5 && !datos.isGana()) {
					datos.setJuega(false);
					datos.setCadena("Se ha alcanzado el limite de intentos");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			objectInputStream.close();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
