import java.net.URI;
import java.net.URL;

public class Ejemplo2 {

	private static void visualizar(URL url) {
		System.out.println("------------------------------------");
		System.out.println("\nAutority:   \t"+url.getAuthority());
		System.out.println("Host:       \t"+url.getHost());
		System.out.println("Port:       \t"+url.getPort());
		System.out.println("DefaultPort:\t"+url.getDefaultPort());
		System.out.println("File:       \t"+url.getFile());
		System.out.println("Path:       \t"+url.getPath());
		System.out.println("Protocol:   \t"+url.getProtocol());
		System.out.println("Query:      \t"+url.getQuery());
		System.out.println("UserInfo:   \t"+url.getUserInfo());
	}
	
	public static void main(String[] args) {
		try {
			URL url;
			
			
			url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
			visualizar(url);
			url = new URL("http", "docs.oracle.com", "/javase/10");
			visualizar(url);
			url = new URL("http", "localhost", 8084,"/webApp/Controlador?accion=modificar");
			visualizar(url);
			url = new URL( new URL("http://docs.google.es"), "/javase/10/docs/api/java/net/URL.html");
			visualizar(url);
		} catch (Exception e) {
		}

	}

}
