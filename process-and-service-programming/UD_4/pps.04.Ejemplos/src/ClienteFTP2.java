import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP2 {

	private static final String URL = "ftp.rediris.es";
	private static final String USERNAME = "anonymous";
	private static final String PASSWORD = "anonymous";
	
	private static final String TYPES[] = {"Fichero", "Directorio", "Enlace simbrediri"};
	
	private static FTPClient client = new FTPClient();
	
	public static void main(String[] args) {
		try {
			log("Conectando a '"+URL+"' ");
			client.connect(URL);
			client.enterLocalPassiveMode();
			
			login(client);
			showDirectories(client);
			logout(client);
			
			client.disconnect();
			log("Desconectado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void showDirectories(FTPClient client) throws IOException {
		log("Directorio actual: "+ client.printWorkingDirectory());
		FTPFile[] files = client.listFiles();
		log("Ficheros en el directiorio actual: " + files.length);
		System.out.println("\n Directorios:");
		for (int i = 0; i < files.length; i++) {
			//System.out.println("  - "+files[i].getName()+" ->  "+TYPES[files[i].getType()]);
			System.out.println("  - ["+TYPES[files[i].getType()]+"] "+files[i].getName());
		}
		System.out.println();
	}

	private static void logout(FTPClient client) throws IOException {
		if(client.logout()) {
			log("Logout del servidor FTP");
		} else {
			error("Logout error");
		}
	}

	private static void login(FTPClient client) throws IOException {
		if(client.login(USERNAME, PASSWORD)) {
			log("Login correcto");
		} else {
			error("Login incorrecto");
			client.disconnect();
			log("Desconectado");
			System.exit(1);
		}
	}
	
	private static void log(String msg) {
		System.out.println("[LOG] "+msg);
	}

	private static void error(String msg) {
		System.out.println("[ERROR] "+msg);
	}
}
