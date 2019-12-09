import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo3 {

	private static void visualizar(URLConnection url) {

	}
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://isca.es");
			
			URLConnection urlConnection = url.openConnection();
			
			urlConnection.getInputStream();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			
			String linea;
			linea = bf.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = bf.readLine();
			}
			
		} catch (Exception e) {
		}

	}

}
