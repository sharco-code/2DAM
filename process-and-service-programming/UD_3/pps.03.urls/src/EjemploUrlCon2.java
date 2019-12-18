import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class EjemploUrlCon2 {
	
	private static void sendGET(URLConnection urlConnection, String message) throws IOException {
		PrintWriter output = new PrintWriter(urlConnection.getOutputStream());
		
		output.write(message);
		output.close();
	}

	private static String readContentFromURL(URLConnection urlConnection) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String line = bufferedReader.readLine(), result = "";
		while (line != null) {
			result += line;
			line = bufferedReader.readLine();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		try {
			//Creas el URLConnection pasandole la url
			URLConnection urlConnection = new URL("http://localhost/psp/ud3/vernombre.php").openConnection();
			urlConnection.setDoOutput(true);
			
			//Envias el GET
			sendGET(urlConnection, "nombre=Jose&apellidos=XDDDDD");
			
			System.out.println(readContentFromURL(urlConnection));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
