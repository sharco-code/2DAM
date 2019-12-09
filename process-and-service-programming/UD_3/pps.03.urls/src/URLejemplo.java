
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLejemplo {
	
	public static void main(String[] args) {
		URL url;
		try {
			URL urlBase = new URL("http://docs.oracle.com");
			
			url = new URL("http://docs.oracle.com");
			visualizar(url);
			
			url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
			visualizar(url);
			
			url = new URL("http", "docs.oracle.com", "/javase/10");
			visualizar(url);
			
			url = new URL("http", "localhost", 8084,"/webApp/Controlador?accion=modificar");
			visualizar(url);
			
			url = new URL(urlBase, "/javase/10/docs/api/java/net/URL.html");
			visualizar(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	private static void readURL(URL url) {
		try {
			InputStream input = url.openStream();
			InputStreamReader isr = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(isr);
			String linea;
		
			while((linea = br.readLine()) != null) {
		    	System.out.println(linea);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void visualizar(URL url) {
		System.out.println("Metodo toString: "+url.toString());
		System.out.println("Metodo getProtocol: "+url.getProtocol());
		System.out.println("Metodo getFile: "+url.getFile());
		System.out.println("Metodo getDefaultPort: "+url.getDefaultPort());
		System.out.println("Metodo getAuthority: "+url.getAuthority());
		System.out.println("Metodo getHost: "+url.getHost());
		System.out.println("Metodo getPort: "+url.getPort());
		System.out.println("Metodo getQuery: "+url.getQuery());
		System.out.println("Metodo getUserInfo: "+url.getUserInfo());
		System.out.println(".........................................\n");
	}

}
