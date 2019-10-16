import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio07a {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			
			do {
				str = br.readLine();
				System.out.println("La cadena introducida es:"+str);
			} while(!str.equals("*"));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
