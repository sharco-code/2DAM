import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class UploadFile {

	private static final String URL = "localhost";
	private static final String USERNAME = "usuario1";
	private static final String PASSWORD = "usuario1";
	
	private static final String TYPES[] = {"Fichero", "Directorio", "Enlace simbrediri"};
	
	private static FTPClient client = new FTPClient();
	
	public static void main(String[] args) {
		try {
			log("Conectando a '"+URL+"' ");
			client.connect(URL);
			client.enterLocalPassiveMode();
			
			login(client);
			
			client.setFileType(FTP.BINARY_FILE_TYPE);
			String dir = "NUEVODIR";
			
			//si el directorio no existe se crea
			if(!client.changeWorkingDirectory("/"+dir)) {
				
				if(client.makeDirectory(dir)) log("Directorio '"+dir+"' creado");
				else {
					error("No se ha podido crear el directorio '"+dir+"'");
					System.exit(0);
				}
				
				System.out.println("Directorio actual: "+client.printWorkingDirectory());
				
				//STREAM DE ENTRADA CON EL FICHERO A SUBIR
				String file = "E:\\F18C-manual.pdf";
				BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
				//pagina 12
			}
			
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
