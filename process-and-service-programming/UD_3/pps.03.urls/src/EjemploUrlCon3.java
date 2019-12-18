import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class EjemploUrlCon3 {
	
	private static void sendGET(URLConnection urlConnection, String message) throws IOException {
		PrintWriter output = new PrintWriter(urlConnection.getOutputStream());
		
		output.write(message);
		output.close();
	}

	private static void probarMetodos(URLConnection urlConnection) {
		System.out.println("Método getURL: "+urlConnection.getURL());
		System.out.println("Método getLastModified: "+urlConnection.getLastModified());
		System.out.println("Método getContentType: "+urlConnection.getContentType());
		for (int i = 0; i < 10; i++) {
			System.out.println("Método getHeaderField("+i+"): "+urlConnection.getHeaderField(i));
		}
		System.out.println("Método url.getFile: "+urlConnection.getURL().getFile());
	}
	
	public static void main(String[] args) {
		try {
			//Creas el URLConnection pasandole la url
			URLConnection urlConnection = new URL("http://localhost/psp/ud3/vernombre.php").openConnection();
			urlConnection.setDoOutput(true);
			
			//Envias el GET
			sendGET(urlConnection, "nombre=Jose&apellidos=XDDDDD");
			
			probarMetodos(urlConnection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}
