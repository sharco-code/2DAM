import java.io.*;

public class Ejercicio06a {

	public static void main(String[] args) {

		System.out.println("[Ejercicio6a] Proceso Hijo ejecutando");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			System.out.println("[Ejercicio6a] Buffer: "+ str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
